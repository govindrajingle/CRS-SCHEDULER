package in.cdacnoida.dava.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.xml.sax.SAXException;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.model.ConsignmentDetails;
import in.cdacnoida.dava.model.ConsignmentDetailsExcel;
import in.cdacnoida.dava.model.ExportOrderModel;
import in.cdacnoida.dava.model.List_srno;
import in.cdacnoida.dava.model.PRODUCTS;
import in.cdacnoida.dava.model.PrimiseDetails;
import in.cdacnoida.dava.model.PrimiseDetailsExcel;
import in.cdacnoida.dava.model.Product;
import in.cdacnoida.dava.model.ProductDetailsExcel;
import in.cdacnoida.dava.model.ProductExcel;
import in.cdacnoida.dava.model.ProductList;
import in.cdacnoida.dava.model.Product_List;
import in.cdacnoida.dava.model.SECONDARY;
import in.cdacnoida.dava.model.SEC_LIST;
import in.cdacnoida.dava.model.SecondaryExcel;
import in.cdacnoida.dava.model.SerialNumberExcel;
import in.cdacnoida.dava.model.TERTIARY;
import in.cdacnoida.dava.model.TertiaryExcel;
import in.cdacnoida.dava.service.CountryRegionMapService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.ExportServices;
import in.cdacnoida.dava.springsecurity.LoggedInUserSession;
import in.cdacnoida.dava.transactions.UserRepository;

@Controller
public class ExportOrderAction {

	@Autowired
	public CountryRegionMapService crmServ;

	@Autowired
	private LoggedInUserSession userData;

	@Autowired
	private DavaServices service;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExportServices exportServices;

	@RequestMapping(value = "/exportOrder", method = RequestMethod.GET)
	public ModelAndView exportOrder(@ModelAttribute("exportOrderModel") ExportOrderModel exportOrderModel,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		List<DrugMst> getProductNames = service.getProductNames();
		List<RegionMstDomain> regionDtls = crmServ.loadRegion();

		mv.addObject("getProductNames", getProductNames);
		mv.addObject("regionDtls", regionDtls);
		mv.setViewName("ExportOrder");

		return mv;
	}

	@PostMapping("/exportOrder")
	public ModelAndView saveExportOrderDetails(@ModelAttribute("exportOrderModel") ExportOrderModel exportOrderModel,
			RedirectAttributes redirectAttribute, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		boolean result = service.saveExportOrderDetails(exportOrderModel);
		if (result)
			redirectAttribute.addFlashAttribute("flagSave", 1);
		else
			redirectAttribute.addFlashAttribute("error", "error in saving data");

		mv.setViewName("redirect:/exportOrder");
		return mv;
	}

	@GetMapping("/countrybasedOnRegion")
	public ResponseEntity<List<CountryMst>> getCountrybasedOnRegion(@RequestParam("regionId") Integer regionId) {
		List<CountryMst> getCountrybasedOnRegion = service.getCountrybasedOnRegion(regionId);
		return new ResponseEntity<List<CountryMst>>(getCountrybasedOnRegion, HttpStatus.OK);
	}

	@GetMapping("/getExportOrderDetails")
	public @ResponseBody String getExportOrderDetails(HttpServletRequest request, HttpServletResponse response) {
		String jsonResponse = exportServices.getExportOrderDetails(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}

	/*
	 * @GetMapping("/convertExcelToXML") public ModelAndView getConverterPage() {
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("excelToXmlConverter");
	 * return mv; }
	 */

	@PostMapping("/convertExcelToXML")
	public ModelAndView convertExcelToSxml(@RequestParam("uploadfile") MultipartFile multipartFile, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("excelToXmlConverter");
		String errorMsg="";
		File file = new File(multipartFile.getOriginalFilename());
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Excel to java object

		List<ConsignmentDetailsExcel> consignmentDetails = Poiji.fromExcel(file, ConsignmentDetailsExcel.class);

		PoijiOptions option3 = PoijiOptionsBuilder.settings().sheetName("Product").build();
		List<ProductExcel> prod1 = Poiji.fromExcel(file, ProductExcel.class, option3);

		PoijiOptions options = PoijiOptionsBuilder.settings().sheetName("Tertiary").build();
		List<TertiaryExcel> tertiary = Poiji.fromExcel(file, TertiaryExcel.class, options);

		PoijiOptions options1 = PoijiOptionsBuilder.settings().sheetName("SECONDARY").build();
		List<SecondaryExcel> secondary = Poiji.fromExcel(file, SecondaryExcel.class, options1);

		PoijiOptions options2 = PoijiOptionsBuilder.settings().sheetName("Srno").build();
		List<SerialNumberExcel> srno = Poiji.fromExcel(file, SerialNumberExcel.class, options2);

		String fileName = "";
		ArrayList<String> productNumber=new ArrayList<String>();
		ArrayList<String> batchNumber=new ArrayList<String>();
		ArrayList<String> codeSNo=new ArrayList<String>();
		String consignmentProductCount="";
		
		for (ConsignmentDetailsExcel consignmentDtl : consignmentDetails) {
			fileName=consignmentDtl.getFilename();
			consignmentProductCount=consignmentDtl.getProductCount();
			ConsignmentDetails conDtl=new ConsignmentDetails();
			conDtl.setSender_manufacturer_code(consignmentDtl.getSender_manufacturer_code());
			conDtl.setFilename(consignmentDtl.getFilename());
			conDtl.setFile_date(consignmentDtl.getFile_date());
			conDtl.setFile_time(consignmentDtl.getFile_time());
			conDtl.setSupply_type(consignmentDtl.getSupply_type());
			conDtl.setSerialization_type(consignmentDtl.getSerialization_type());
			conDtl.setEway_bill_no(consignmentDtl.getEway_bill_no());
			conDtl.setBill_date(consignmentDtl.getBill_date());
			conDtl.setRegionDc(consignmentDtl.getRegionId());
			conDtl.setCountryOfExp(consignmentDtl.getCountryOfExp());
			conDtl.setCompanyName(consignmentDtl.getCompanyName());
			conDtl.setCompanyAddress(consignmentDtl.getCompanyAddress());
			conDtl.setPortName(consignmentDtl.getPortName());
			conDtl.setLandingPort(consignmentDtl.getLandingPort());

			Product_List prolist = new Product_List();
			
			Integer i=0;
			List<Product> productCount=new ArrayList<Product>();
			for (ProductExcel secon : prod1) {
				
				
				
				Product products=new Product();			    					
				products.setProductName(secon.getProductName());
				products.setProdCode(secon.getProdCode());
				products.setBatch_number(secon.getBatch_number());
				products.setExpiry_date(secon.getExpiray_date());
				products.setHs_code(secon.getHs_code());
				products.setProcurementSourceGstn(secon.getProcureement_source_gstn());
				products.setProcurement_source_name(secon.getProcurement_source_name());
				products.setProcurement_source_address(secon.getProcurement_source_address());

				if(products.getProdCode().equals(products.getBatch_number())){
					errorMsg="Product Number and Batch Number should be different on "+i+"th PRODUCT tag";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
			       
				}
				
				if(productNumber.contains(products.getProdCode())){
					errorMsg="Product Number must be unique on "+i+"th PRODUCT tag";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;

				}
				
				if(batchNumber.contains(products.getBatch_number())){
					errorMsg="Batch Number must be unique on "+i+"th PRODUCT tag";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
				}
				
				
				prolist.addProduct(products);
				productNumber.add(secon.getProdCode());
				batchNumber.add(secon.getBatch_number());
				productCount.add(products);
				i++;
				
			}

			if(!consignmentProductCount.equals(String.valueOf(productCount.size()))){
				
				System.out.println("consignmentProductCount ::" + consignmentProductCount);
				System.out.println("productCount.size() ::" +productCount.size());
				
				errorMsg="Product count must be same as given in Consignment details product count";
				mv.addObject("errorStatus", true);
			    mv.addObject("errorMsg",errorMsg);
			    return mv;
		}
			
			conDtl.addProduct(prolist);		    				
			conDtl.setTertiaryCount(consignmentDtl.getTertiaryCount());

			int j=0;
			ArrayList<TERTIARY> tertiaryCount=new ArrayList<>();
			Map<String,ArrayList<Product>> tertiaryProduct=new HashedMap<>();
			Map<String,String> ssccTertiaryType=new HashedMap<>();
			for (TertiaryExcel tertiary2 : tertiary) {
				
				
				
				TERTIARY tertiary1=new TERTIARY();
				tertiary1.setTertiaryType(consignmentDtl.getTertiaryType());
				tertiary1.setProductCount(consignmentDtl.getProductCount());
				tertiary1.setSscc(consignmentDtl.getsSCC());
				
				if(!productNumber.contains(tertiary2.getProdCode())){
					errorMsg="Given Product in "+j+" tertiary tag is not present in product list";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
			        
				}
				
				Product prod2=new Product();
				prod2.setProdCode(tertiary2.getProdCode());
				prod2.setBatch_number(tertiary2.getBatch_number());
				tertiary1.addProduct(prod2);
				
				tertiaryCount.add(tertiary1);
				
				ArrayList<Product> tertiaryProduct1=new ArrayList<>();
				tertiaryProduct1.add(prod2);
				
				if(tertiaryProduct.containsKey(tertiary2.getSsccCode()))
					tertiaryProduct.get(tertiary2.getSsccCode()).add(prod2);
				else
					tertiaryProduct.put(tertiary2.getSsccCode(),tertiaryProduct1);
					
				if(!ssccTertiaryType.containsKey(tertiary2.getSsccCode())){
					ssccTertiaryType.put(tertiary2.getSsccCode(), tertiary2.getTertiaryType());
				}
				
				conDtl.addTertiary(tertiary1);
				j++;
			}	    
			
			/*if(!consignmentDtl.getTertiaryCount().equals(String.valueOf(tertiaryCount.size()))){
				Component parentComponent = null;
				JOptionPane.showMessageDialog(parentComponent, "Tertiary count must be same as given in Consignment details tertiary count");
		        throw new ExcelToXmlValidationException("Tertiary count must be same as given in Consignment details tertiary count");
			}*/
			HashSet<String> uniqueTertiarySet = new HashSet<String>();
			HashSet<String> uniqueSecodarySet = new HashSet<String>();
			
			//long count1 = secondary.stream().map(e -> e.getCode_sno()).distinct().count();
			//long count2 = tertiary.stream().map(e -> e.getSsccCode()).distinct().count();
			for(SecondaryExcel secondaryRow : secondary) {
				boolean isSecondaryDuplicate=uniqueSecodarySet.add(secondaryRow.getCode_sno());
			 if(!isSecondaryDuplicate) {
					errorMsg= errorMsg + " Dublicate code in Code Sr Nocondary sheet";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
				}
			}
			
			for(TertiaryExcel tertiaryRow : tertiary) {
				boolean isTertiaryDuplicate=uniqueTertiarySet.add(tertiaryRow.getSsccCode());
				if(!isTertiaryDuplicate) {
					errorMsg= errorMsg + "Dublicate code in sscc Teritary sheet";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
				}
			}
			
			if(!conDtl.getTertiaryCount().equals((String.valueOf(tertiaryProduct.size())))){
				errorMsg="Tertiary count must be same as given in Consignment details tertiary count";
				mv.addObject("errorStatus", true);
				mv.addObject("errorMsg",errorMsg);
				return mv;
			}
			
			
			HashSet<String> uniqueTtertiaryTypeHomoMap = new HashSet<String>();
			HashSet<String> uniqueTtertiaryTypeHetrMap = new HashSet<String>();
				for(Map.Entry<String, String> getTertiaryType : ssccTertiaryType.entrySet()){
					String ssccCode=getTertiaryType.getKey();
					String tertiaryType=getTertiaryType.getValue();
					ArrayList<Product> ProductCount=tertiaryProduct.get(ssccCode);
					
					if(tertiaryType.equals("HOMO")){
						boolean isHomoPresent = uniqueTtertiaryTypeHomoMap.add(ssccCode);
						if(uniqueTtertiaryTypeHomoMap.size()>1){
							errorMsg="For Homogeneous product there must be only one product in Tertiary Pack";
							mv.addObject("errorStatus", true);
							mv.addObject("errorMsg",errorMsg);
							return mv;
						}
					}
					
					if(tertiaryType.equals("HETR")){
						boolean isHetroPresent = uniqueTtertiaryTypeHetrMap.add(ssccCode);
						if(!isHetroPresent){
							errorMsg="For Heterogeneous product there must be more than one product in Tertiary Pack";
							mv.addObject("errorStatus", true);
							mv.addObject("errorMsg",errorMsg);
							return mv;
						}
					}
					
					/*if(tertiaryType.equals("HOMO")){
						
						if(ProductCount.size()>1){
							errorMsg="For Homogeneous product there must be only one product in Tertiary Pack";
							mv.addObject("errorStatus", true);
							mv.addObject("errorMsg",errorMsg);
							return mv;
						}
					}
					if(tertiaryType.equals("HETR")){
						if(!(ProductCount.size()>1)){
							errorMsg="For Heterogeneous product there must be more than one product in Tertiary Pack";
							mv.addObject("errorStatus", true);
							mv.addObject("errorMsg",errorMsg);
							return mv;
						}
					}*/
					if(!tertiaryType.equals("HETR") & !tertiaryType.equals("HOMO")){
						errorMsg= "Please give proper Type value for tertiary tag HOMO/HETR";
						mv.addObject("errorStatus", true);
						mv.addObject("errorMsg",errorMsg);
						return mv;
					}
				}
			
			
				
			SEC_LIST secList=new SEC_LIST();
				
			
			Map<String,String[]> seconTypeCount=new HashMap<>();
			Map<String,ArrayList<String>> serialNumberOne=new HashMap<>();
			Map<String,ArrayList<Product>> seconProductCount=new HashMap<>();
			HashMap<String, Integer> typeCountMap = new HashMap<>();
			
			
			/*errorMsg = "";
			boolean error = false;
			if(count1 != secList.getSecondary().size()) {
				errorMsg= errorMsg + "Code Sr Nocondary sheet";
				error = true;
			}
			if(count2 != tertiary.size()) {
				errorMsg= errorMsg + "Code Sr Teritary sheet";
				error = true;
			}
			if(error) {
				mv.addObject("errorStatus", true);
				mv.addObject("errorMsg",errorMsg);
				return mv;
				
			}*/
			
			
			for (SecondaryExcel secon : secondary) {
				
				if(!seconTypeCount.containsKey(secon.getCode_sno()))
					seconTypeCount.put(secon.getCode_sno(), new String[]{secon.getType(),secon.getSubCount(),secon.getSscc()});
				
				if(!typeCountMap.containsKey(secon.getType())) {
					typeCountMap.put(secon.getType(), 1);
				}else {
					Integer count =typeCountMap.get(secon.getType());
					count++;
					typeCountMap.put(secon.getType(), count);
				}
					
					
				SECONDARY secondary1=new SECONDARY();
				secondary1.setSscc(secon.getSscc());
				secondary1.setType(secon.getType());
				secondary1.setLevel(secon.getLevel());
				secondary1.setParentCD(secon.getParentDc());
				secondary1.setCode_sno(secon.getCode_sno());
					
				Product prod=new Product();
				prod.setProdCode(secon.getProdCode());
				prod.setBatch_number(secon.getBatch_number());
				
				
				if(seconProductCount.containsKey(secon.getSscc()))
					seconProductCount.get(secon.getSscc()).add(prod);
				else{
					ArrayList<Product> aa=new ArrayList<>();
					aa.add(prod);
					seconProductCount.put(secon.getSscc(), aa);
				}
					
					
				if(codeSNo.size()==0)
					codeSNo.add(secon.getCode_sno());
				else if(codeSNo.contains(secon.getCode_sno())){
					errorMsg= "CODE_SNo Code must be diffrent";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
				}else
					codeSNo.add(secon.getCode_sno());

				if(!productNumber.contains(secon.getProdCode())){
					errorMsg="Product Code must be same as given in product list";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
				}
					
				if(!batchNumber.contains(secon.getBatch_number())){
					errorMsg="Batch number must be same as given in product list";
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
				   
				}
			
				prod.setSubCount(secon.getSubCount());
					
				//if(Integer.parseInt(secon.getSubCount())>1) {
					List_srno srNo1=new List_srno();
					for (SerialNumberExcel srNoExcel : srno) {
						if(srNoExcel.getCODE_Sno().equals(secon.getCode_sno())){
							srNo1.addSrNo(srNoExcel.getSrno());
							
//							if(serialNumberOne.containsKey(srNoExcel.getCODE_Sno()))
//								serialNumberOne.get(srNoExcel.getCODE_Sno()).add(srNoExcel.getSrno());
//							else{
//								ArrayList<String> aa=new ArrayList<String>();
//								aa.add(srNoExcel.getSrno());
//								serialNumberOne.put(srNoExcel.getCODE_Sno(),aa);
//							}
						}
					}
					prod.addListSrNo(srNo1);
					System.out.println(prod+":"+srNo1);
				//}
					
					secList.addSecondary(secondary1);
					secondary1.addProduct(prod);
					
					//code for contains validation
					
					for(TERTIARY ter : tertiaryCount) {
						if(!ter.getSscc().equals(secondary1.getSscc())){
							errorMsg="Parent CD should be parent code of this pack and all SSCC code is specified the should be exists in tertiary pack list.";
							mv.addObject("errorStatus", true);
							mv.addObject("errorMsg",errorMsg);
							return mv;
						}
					}
				}
			
			
				for(Map.Entry<String, String[]> entry: seconTypeCount.entrySet()){
					String code_srNo=entry.getKey();
					String[] data=entry.getValue();
					String subCount="";
					String secondaryType="";
					String ssccNumber="";
					if(data!=null && data.length==3){
						secondaryType=data[0];
						subCount=data[1];
						ssccNumber=data[2];
					}
					
						
					ArrayList<Product> secondaryList=seconProductCount.get(ssccNumber);
					Integer homocount = typeCountMap.get("HOMO");
					Integer hetrocount = typeCountMap.get("HETR");
					
					if(secondaryType.equals("HOMO")){
						if(homocount != 1){
							
							
							errorMsg="For Homogeneous product there must be only one product in Secondary Pack";
							mv.addObject("errorStatus", true);
							mv.addObject("errorMsg",errorMsg);
							return mv;
						}
					}
					if(secondaryType.equals("HETR")){
						if(hetrocount <= 1){
							
						
							errorMsg="For Heterogeneous product there must be more than one product in Secondary Pack";
							mv.addObject("errorStatus", true);
							mv.addObject("errorMsg",errorMsg);
							return mv;
						}
					}
					
					if(!secondaryType.equals("HETR") & !secondaryType.equals("HOMO")){
						errorMsg="Please give proper Type value for Secondary tag HOMO/HETR";
						mv.addObject("errorStatus", true);
						mv.addObject("errorMsg",errorMsg);
						return mv;
    				}
					
					ArrayList<String> seconSubCount=serialNumberOne.get(code_srNo);
					if(subCount.equals("") && !subCount.equals(String.valueOf(seconSubCount.size()))){
						errorMsg="Serial number subcount must be same as given in Secondary tag";
						mv.addObject("errorStatus", true);
						mv.addObject("errorMsg",errorMsg);
						return mv;
    				}   
					
				}
				
				
			
				/*java.util.List<SECONDARY> secondaryList=secList.getSecondary();
				
				for (SECONDARY secondary2 : secondaryList) {
					
					String secType=secondary2.getType();
					java.util.List<Product> productList=secondary2.getProduct();

    				if(secType.equals("HOMO") && !(productList.size()==1)){
    					Component parentComponent = null;
				        JOptionPane.showMessageDialog(parentComponent, "For Homogeneous product there must be only one product in Secondary List");
				        throw new ExcelToXmlValidationException("For Homogeneous product there must be only one product in Secondary List");
    				}
					
    				if(secType.equals("HETRO") && !(productList.size()>1)){
    					Component parentComponent = null;
				        JOptionPane.showMessageDialog(parentComponent, "For Heterogeneous product there must be only one product in Secondary List");
				        throw new ExcelToXmlValidationException("For Heterogeneous product there must be only one product in Secondary List");
    				}
				}*/
				
				
				conDtl.setSecList(secList);
			
				String fileNameWithExt =fileName + ".xml";
				File file2 = new File("H:\\"+fileNameWithExt);
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(ConsignmentDetails.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(conDtl, file2);
				// jaxbMarshaller.marshal(conDtl, System.out);

				String isValidXml = validateXMLSchema("F:\\IVEDA_NEW\\DAVA_PORTAL\\src\\main\\webapp\\WEB-INF\\XSD\\IVEDAExporterPackingDtl.xsd","H://"+fileNameWithExt);
				if(isValidXml.length() > 0 && !"True".equals(isValidXml)) {
					errorMsg=isValidXml.replace("'", "\"");
					mv.addObject("errorStatus", true);
					mv.addObject("errorMsg",errorMsg);
					return mv;
				}
				
				
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(file2);
				byte[] buffer = new byte[8192];

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1)
					baos.write(buffer, 0, bytesRead);

				response.setContentType("application/xhtml+xml");
				response.addHeader("Content-Disposition", "attachment; filename=" + fileName + ".xml");

				byte[] outBuf = baos.toByteArray();
				ServletOutputStream stream = response.getOutputStream();
				stream.write(outBuf);
				stream.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 

		}
		return mv;

	}

	@GetMapping("/convertProductExcelToXML")
	public ModelAndView getConverterPagee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("excelToXmlConverter");
		return mv;
	}

	@PostMapping("/convertProductExcelToXML")
	public void convertProductExcelToSxml(@RequestParam("uploadfile") MultipartFile multipartFile,
			HttpServletRequest request, HttpServletResponse response) {

		System.err.println("helloooooooo");

		File file = new File(multipartFile.getOriginalFilename());
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Excel to java object
		List<ProductDetailsExcel> productDetails = Poiji.fromExcel(file, ProductDetailsExcel.class);

		// ProductDetailsExcel productDtl=new ProductDetailsExcel();
	//	String fileName = "abcdeP0123459876";
		
		String fileName="";
		fileName=productDetails.get(0).getFileName();

		int count = 0;

		ProductList proList = new ProductList();
		proList.setFileName(productDetails.get(0).getFileName());
		proList.setManfCode(productDetails.get(0).getManufacturerCode());

		for (ProductDetailsExcel productDtl : productDetails) {

			PRODUCTS product = new PRODUCTS();

			//System.out.println("?????" + productDtl.getProductType());

			
			  if(productDtl.getProductType().equalsIgnoreCase("f"))
			  
			  { 
				  
				  product.setManfSiteCode(productDtl.getManufacturingSiteCode());
			  product.setProductType(productDtl.getProductType());
			//  product.setProductCode(productDtl.getProductCode());
			  product.setProductName(productDtl.getProductName());
			  product.setGenericName(productDtl.getGenericName());
			  product.setComposition(productDtl.getComposition());
			  product.setScheduled(productDtl.getScheduled());
			  product.setRemark(productDtl.getRemark());
			  product.setStorageCondition(productDtl.getStorageCondition());
			  product.setStrength(productDtl.getStrength());
			  product.setDosage(productDtl.getDosage());
			  product.setHsCode(productDtl.getHsCode()); proList.addProduct(product);
			  
			  }
			 
			// proList.addProduct(product);

			else if (productDtl.getProductType().equalsIgnoreCase("b")) {
				
			//	System.out.println("????" + "inside b");

				// PRODUCTS product=new PRODUCTS();
				product.setManfSiteCode(productDtl.getManufacturingSiteCode());
				product.setProductType(productDtl.getProductType());
				product.setGenericName(productDtl.getGenericName());
				product.setStorageCondition(productDtl.getStorageCondition());
				product.setHsCode(productDtl.getHsCode());
				proList.addProduct(product);
			}

			// proList.addProduct(product);

		}

		File file1 = new File(fileName);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(proList, file1);
			// jaxbMarshaller.marshal(conDtl, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(file1);
			byte[] buffer = new byte[8192];

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1)
				baos.write(buffer, 0, bytesRead);

			response.setContentType("application/xhtml+xml");
			response.addHeader("Content-Disposition", "attachment; filename=" + file1 + ".xml");

			byte[] outBuf = baos.toByteArray();
			ServletOutputStream stream = response.getOutputStream();
			stream.write(outBuf);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;

	}
public static String validateXMLSchema(String xsdPath, String xmlPath){
        String error = "";
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
           Validator validator = schema.newValidator();
           Result result = null;
            validator.validate(new StreamSource(new File(xmlPath)),result);
            return "True";
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            error = e.getMessage().split(":")[1];
            return error;
        }
    }

	@GetMapping("/convertPrimiseExcelToXML")
	public ModelAndView getConvertPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("excelToXmlConverter");
		return mv;
	}

	@PostMapping("/convertPrimiseExcelToXML")
	public void convertPrimiseExcelToSxml(@RequestParam("uploadfile") MultipartFile multipartFile,
			HttpServletRequest request, HttpServletResponse response) {

		System.err.println("helloooooooo");

		File file = new File(multipartFile.getOriginalFilename());
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Excel to java object

		List<PrimiseDetailsExcel> primiseDetails = Poiji.fromExcel(file, PrimiseDetailsExcel.class);

		System.err.println(primiseDetails);

		String fileName = "primise";
		for (PrimiseDetailsExcel primiseDetail : primiseDetails) {

			PrimiseDetails primiseDtl = new PrimiseDetails();

			primiseDtl.setSiteType(primiseDetail.getSiteType());
			primiseDtl.setSiteName(primiseDetail.getSiteName());
			primiseDtl.setAddress(primiseDetail.getAddress());
			primiseDtl.setLicenceNo(primiseDetail.getLicennceNo());
			primiseDtl.setPincode(primiseDetail.getPincode());
			primiseDtl.setEmail(primiseDetail.getEmail());
			primiseDtl.setContactNo(primiseDetail.getContactNo());
			primiseDtl.setContactPersonName(primiseDetail.getContactPersonName());
			primiseDtl.setDesignation(primiseDetail.getDesignation());
			primiseDtl.setMobileNo(primiseDetail.getMobileNo());
			primiseDtl.setContact(primiseDetail.getContact());

			File file4 = new File(fileName);
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(PrimiseDetails.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(primiseDtl, file4);
				// jaxbMarshaller.marshal(conDtl, System.out);

			} catch (JAXBException e) {
				e.printStackTrace();
			}
			InputStream inputStream = null;

			try {
				inputStream = new FileInputStream(file4);
				byte[] buffer = new byte[8192];

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1)
					baos.write(buffer, 0, bytesRead);

				response.setContentType("application/xhtml+xml");
				response.addHeader("Content-Disposition", "attachment; filename=" + fileName + ".xml");

				byte[] outBuf = baos.toByteArray();
				ServletOutputStream stream = response.getOutputStream();
				stream.write(outBuf);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
