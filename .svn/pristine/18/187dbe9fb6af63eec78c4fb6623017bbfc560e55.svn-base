package in.cdacnoida.dava.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.ApprovalPremisesDetail;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DataUploadTypeMstDomain;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.LicPremiseDtlDomain;
import in.cdacnoida.dava.entities.MemberTypeMasterDomain;
import in.cdacnoida.dava.entities.PortOfExportDomain;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.UploadConsignDtlDomain;
import in.cdacnoida.dava.entities.UploadInvoiceDtlDomain;
import in.cdacnoida.dava.entities.UploadPurchaseOrderDtlDom;
import in.cdacnoida.dava.entities.UploadXmlDataDtlDomain;
import in.cdacnoida.dava.entities.UploadXmlDataDtlLogDomain;
import in.cdacnoida.dava.entities.UploadXmlInvoiceDtlDomain;
import in.cdacnoida.dava.misc.ValidationGroups.ManufacturingSiteDetails;
import in.cdacnoida.dava.model.EXP_TERTIARY_LIST;
import in.cdacnoida.dava.model.FileUploadFlag;
import in.cdacnoida.dava.model.MANUFACTURE_SCHEMA_LIST;
import in.cdacnoida.dava.model.MemberAddDtlModel;
import in.cdacnoida.dava.model.OffRegModel;
import in.cdacnoida.dava.model.PRODUCT_SCHEMA_LIST;
import in.cdacnoida.dava.model.ProductModel;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.model.UploadDataForm;
import in.cdacnoida.dava.model.XmlBean;
import in.cdacnoida.dava.service.CountryRegionMapService;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.GlobalService;
import in.cdacnoida.dava.springsecurity.LoggedInUserSession;
import in.cdacnoida.dava.util.DataEncoder;
import in.cdacnoida.dava.util.Sendmail;
import in.cdacnoida.davaconfig.EmailContent;
import in.cdacnoida.davaconfig.FileUploadingPath;
import in.cdacnoida.davaconfig.FtpDetailsProperties;
import sun.misc.BASE64Decoder;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*import com.fasterxml.jackson.xml.XmlMapper;*/

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




@Controller
public class UploadXml {
		
	@Autowired
	private LoggedInUserSession userData;
	
	@Autowired
	public DavaDaoServices davaDao;

	@Autowired
	FtpService ftpService;

	@Autowired
	GlobalService gService;

	@Autowired
	DataEncoderService encodedservice;
	
	@Autowired
	private FtpDetailsProperties ftpProps;
	
	@Autowired
	private DavaServices davaServices;
	
	@Autowired
	private Sendmail sendmail;
	
	@Autowired
	private EmailContent emailContent;
	
	@Autowired
	private FileUploadingPath uploadingPath;
	
	@Autowired
	public CountryRegionMapService crmServ;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UploadXml.class);
	
	@GetMapping("/uploadXml")
	public ModelAndView getxmlPage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("getXmlUploadPage");
		return mv;
	}
	
	
	@PostMapping("/uploadXml")
	public ModelAndView uploadXmlFile(@RequestParam("file") MultipartFile file) {
		ModelAndView mv=new ModelAndView();
		XmlBean myxmlBean=null;
		File multiFile=new File(file.getOriginalFilename());
		try {
			multiFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(multiFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//XML File upload code
		String rootDirectory=ftpProps.getDirectory();
		String userType=userData.getUserType();
		Long userId=userData.getUserId();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		String finalPath=rootDirectory+File.separator+userType+File.separator+userId+File.separator+year+File.separator+file.getOriginalFilename();
		LOGGER.info("Final path to upload xml file {}",finalPath);
		try {
			boolean result = ftpService.uploadFile(file.getOriginalFilename(),file.getInputStream(),finalPath);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//End
		
		LOGGER.info("inside upload xml file=="+file.getName());
		try {
			 JAXBContext jaxbContext = JAXBContext.newInstance(XmlBean.class);
			 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			  myxmlBean=(XmlBean) jaxbUnmarshaller.unmarshal(multiFile);
			  LOGGER.info("myXmlBean file name {}",myxmlBean);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		mv.addObject("myxmlBean", myxmlBean);
		mv.setViewName("getXmlUploadPage");
		return mv;
	}
	
	
	@GetMapping(value = "/UploadXmlDataPage")
	public String UploadXmlDataPage(@ModelAttribute("uploadData") UploadDataForm uploadData,
			HttpServletRequest request) {

		List<DataUploadTypeMstDomain> dataType = davaDao.getDataUploadType();
		request.setAttribute("dataType", dataType);
		return "UploadXmlDataPage";
	}

	@RequestMapping(value = "/uploadFileXml/{filename}/{docId}/{purposeType}", method = RequestMethod.POST)
	public @ResponseBody List<FileUploadFlag> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile,
			@PathVariable String filename, @PathVariable int docId,@PathVariable int purposeType, HttpServletRequest request, HttpServletResponse response,HttpSession session)
			throws NoSuchAlgorithmException, IOException, ParserConfigurationException, SAXException {
		
		
		
		
		
		 List<FileUploadFlag> returnList = new ArrayList<FileUploadFlag>();
		  int doc_size = 0, doc_id = 0;
		  String fileSize= uploadfile.getSize() / 1024 + " Kb";
		  String FileNameOriginal = uploadfile.getOriginalFilename();
		  FileUploadFlag obj_FileUploadFlag = new FileUploadFlag();
		  
		String[] contentName=filename.split("shubham");
		  if(contentName.length==2) {
			  filename=contentName[0];
			  String xmldata=contentName[1];
			  String stChecksum = "";
				try {
					byte[] uploadBytes = uploadfile.getBytes();
					MessageDigest md5 = MessageDigest.getInstance("MD5");
					byte[] digest = md5.digest(uploadBytes);
					String hashString = new BigInteger(1,digest).toString(16);
					stChecksum = hashString.trim();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(!stChecksum.equals(xmldata)) {
					returnList.clear();
					obj_FileUploadFlag.setSuccessFlag(3);
					obj_FileUploadFlag.setFileName(FileNameOriginal);
					returnList.add(obj_FileUploadFlag);
					return returnList;

				}
		  }
	
		returnList.clear();
		obj_FileUploadFlag.setFileName("");
		obj_FileUploadFlag.setSuccessFlag(0);
		returnList.add(obj_FileUploadFlag);
		int extsize = StringUtils.countMatches(uploadfile.getOriginalFilename(), ".");
		boolean result = false ;
		String finalName =null;
		if ((uploadfile.getContentType().equalsIgnoreCase("text/xml"))
						&& FilenameUtils.isExtension(uploadfile.getOriginalFilename(), "xml") && extsize == 1) {

			doc_size = Integer.parseInt(fileSize.split(" ")[0]);
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			
			if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024 && Integer.parseInt(fileSize.split(" ")[0]) > 0) {

				try {
					
					String path = ftpProps.getTempupload(); // Initially file uploaded in TempFile folder
					

					//String directory = ftpProps.getTempupload();
					if (docId == 0) {
						doc_id = gService.addDocument("TempFile", doc_size, FileNameOriginal, "T", 1000001); // Document Mst Save
						 finalName = path +doc_id+ ".xml";
						System.err.println("in file upload doc id-- " + doc_id);

					} else {
						doc_id = docId;
						gService.updateDocumentSize(doc_id, doc_size);
					}
					Path path1 = null ;
					//Upload file locally
				       try {
				    	   // Get the file and save it somewhere
						/*
						 * byte[] bytes = uploadfile.getBytes();
						 * System.out.println("UPLOADED_FOLDER path=="+UPLOADED_FOLDER); path1 =
						 * Paths.get(UPLOADED_FOLDER + uploadfile.getOriginalFilename());
						 * System.out.println("PATH!=="+path1); File inputFile =new
						 * File(UPLOADED_FOLDER); // Files.set inputFile.setWritable(true);
						 * Files.write(path1, bytes);
						 */
				            //Files.isExecutable(true);
				            
				            System.out.println("in try block");
				            byte[] bytes = uploadfile.getBytes();
				            path1 = Paths.get(uploadingPath.getXmlPath() + uploadfile.getOriginalFilename());
				            File file1=new File(uploadingPath.getXmlPath()+ uploadfile.getOriginalFilename());
				            FileOutputStream out=new FileOutputStream(file1);
				            out.write(bytes);
				            out.close();
				            System.out.println("in try block done");
				            
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				       File xsdFile = null;
				       String xmlfileString = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
						
						  String checkStatus = CheckXSDFormat(path1, xsdFile,purposeType); // Check the xml file format from XSD format
						  System.out.println("checkStatus of file is =="+checkStatus);
						  boolean hashStatus = CheckHashValue(path1);  // Check the hash value of File Content
						//  boolean digitalSignCheck = CheckDigitalSign(xmlfileString);
						  
					
					  if(hashStatus== true) {
					  
					  if(checkStatus.equals("ProperFormat")) {
					  
						  // check digital sign also (pending)

						  String codeList = davaDao.getduplicateCodes(xmlfileString);
						  if(codeList==null || codeList == "null" || codeList=="") {
						  //String codeList=xMLParser.parseXML(xmlfileString);
						  result= ftpService.uploadFile(finalName, uploadfile.getInputStream(), uploadingPath.getXmlPath() + uploadfile.getOriginalFilename()); // file upload on ftp temp folder
						  }else {
							  System.err.println("file has duplicate codes.");
							  returnList.clear();
							  obj_FileUploadFlag.setSuccessFlag(8); // file has duplicate codes
							  obj_FileUploadFlag.setFileName(FileNameOriginal);
							  obj_FileUploadFlag.setErrorMsg(codeList);
							  returnList.add(obj_FileUploadFlag); 
							  return returnList; 
						  }
						 
					  
					  } 
					  else 
					  { 
					  System.err.println("file is not in XSD format...");
					  returnList.clear();
					  obj_FileUploadFlag.setSuccessFlag(7); // file is not in  XSD format...
					  obj_FileUploadFlag.setFileName(FileNameOriginal);
					  obj_FileUploadFlag.setErrorMsg(checkStatus);
					  returnList.add(obj_FileUploadFlag); 
					  return returnList; 
					  }
					  
					  }
					  else 
					  { 
						  System.err.println("file hash value already exist..");
					  returnList.clear(); 
					  obj_FileUploadFlag.setSuccessFlag(6); // hash value of xml file already exist 
					  obj_FileUploadFlag.setFileName(FileNameOriginal);
					  returnList.add(obj_FileUploadFlag); 
					  return returnList;
					  
					  }
					if (!result) {
						System.out.println("File not uploaded!!!!");
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(3);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return returnList;
					}
					else {
						System.err.println("File Uploaded Successfully!!!");
						davaServices.updateDocumentMstPath(finalName,doc_id);
						UploadXmlDataDtlLogDomain uploadDomainLog = davaServices.saveUploadDataLogDtl(finalName,doc_size,doc_id,path1,purposeType,xmlfileString);

						//UploadXmlDataDtlDomain uploadDomain = davaServices.saveUploadDataDtl(finalName,doc_size,doc_id,path1,purposeType);
			    		
						/*
						 * File fXmlFile = new File("/Users/mkyong/staff.xml"); DocumentBuilderFactory
						 * dbFactory = DocumentBuilderFactory.newInstance(); DocumentBuilder dBuilder =
						 * dbFactory.newDocumentBuilder(); Document doc = dBuilder.parse(fXmlFile); try
						 * { String strRealPathLogo = request.getSession() .getServletContext()
						 * .getRealPath("/WEB-INF/XML"); String xslInput = strRealPathLogo +
						 * File.separator + finalName; FileInputStream xsl = new
						 * FileInputStream(xslInput); TransformerFactory tFactory = TransformerFactory
						 * .newInstance(); StreamSource styleSource = new StreamSource(xsl); Transformer
						 * transformer = tFactory .newTransformer(styleSource); String str =
						 * "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><roottag>";
						 * 
						 * 
						 * str = str + "</roottag>"; String s = new String(str.getBytes(), "UTF-8");
						 * InputStream is = new ByteArrayInputStream(s.getBytes()); StreamSource
						 * xmlSource = new StreamSource(is); StringWriter outWriter = new
						 * StringWriter(); StreamResult result1 = new StreamResult(outWriter);
						 * transformer.transform(xmlSource, result1); StringBuffer sb =
						 * outWriter.getBuffer(); String finalstring = sb.toString();
						 * System.out.println("finalstring" + finalstring);
						 * request.setAttribute("notesheet", finalstring);
						 * 
						 * } catch (Exception e) { e.printStackTrace(); }
						 */
						 //downloadMoveFile(doc_id,request,response);
					}
					
					try {
						// PdfReader pdfReader = new PdfReader(finalName);

					} catch (Exception e) {
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(4);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return returnList;
					}
				} catch (IOException e) {
					e.printStackTrace();

				}

			} else {
				returnList.clear();
				obj_FileUploadFlag.setSuccessFlag(2);
				obj_FileUploadFlag.setFileName(FileNameOriginal);
				returnList.add(obj_FileUploadFlag);
				return returnList;
			}
		} else {
			returnList.clear();
			obj_FileUploadFlag.setSuccessFlag(1);
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			returnList.add(obj_FileUploadFlag);
			return returnList;
		}

		returnList.clear();
		String strDocId = encodedservice.encode(doc_id + "");
		obj_FileUploadFlag.setSuccessFlag(5);

		obj_FileUploadFlag.seteNSuccessFlag(strDocId);
		obj_FileUploadFlag.setFileName(FileNameOriginal);
		returnList.add(obj_FileUploadFlag);
		
		return returnList;
	}
	
	private boolean CheckDigitalSign(String xmlfileString) {
		
      
        String inFileStr = "";
        boolean coreValidity = false;

                 inFileStr = xmlfileString;
               // System.out.println("inFileStr   :::::::::: " + inFileStr);
                
                try {
            		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            		dbf.setNamespaceAware(true);
            		Document doc = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(inFileStr)));
            		NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS,"Signature");

            		if (nl.getLength() == 0) {
            			throw new Exception("Cannot find Signature element");
            		}

            		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
            		//System.out.println("BKcertPath ====  "+BKcertPath);
					FileInputStream fin = new FileInputStream(uploadingPath.getCertPath());
            		CertificateFactory f = CertificateFactory.getInstance("X.509");
            		X509Certificate certificate = (X509Certificate) f.generateCertificate(fin);
            		PublicKey pk = certificate.getPublicKey();
            		System.out.println("pk : " + pk);

            		DOMValidateContext valContext = new DOMValidateContext(pk,nl.item(0));
            		XMLSignature signature = fac.unmarshalXMLSignature(valContext);

            		// Validate the XMLSignature (generated above)
            		coreValidity = signature.validate(valContext);
            		
                } 
            	catch (Exception e1) {
            		e1.printStackTrace();
            	} 

            		if (coreValidity == false) {
            			System.err.println("Digital Sign Verification Failed");
			/*
			 * Component parentComponent = null;
			 * JOptionPane.showMessageDialog(parentComponent, "Verification Failed");
			 */
            		} else {
            			System.err.println("Digital Sign Verification Completed");
			/*
			 * Component parentComponent = null;
			 * JOptionPane.showMessageDialog(parentComponent, "Verification Completed");
			 */
            		}
					return coreValidity;
            		
            		
               
    }


	private boolean CheckHashValue(Path path1) throws IOException {
    	
        String fileString = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
		String hashvalue = MD5Hash.getMd5(fileString);
        //String hashvalue = fileString.hashCode()+"";
        //System.err.println("hashvalue=-------------------   "+hashvalue);
        boolean response=true;
        //List<String> itemsToAdd = new ArrayList<String>();
        //itemsToAdd.add(hashvalue);
        List<String> uploaddata = davaServices.getUploadedData();
        System.out.println(uploaddata.size());
        	List<String> hashValues=new ArrayList<String>();
			/*
			 * for (UploadXmlDataDtlDomain modelListdata : uploaddata) {
			 * hashValues.add(modelListdata.getStrHashCode()); }
			 */
            if(uploaddata.contains(hashvalue)) 
            	response = false;
		return response;
	}


	private String CheckXSDFormat(Path xmlFilePath, File xsdFile, int purposeType) {

		String response = ""; 
		//System.err.println("xmlFilePath-------  "+xmlFilePath.toString());
		File schemaFile = null;
		if(purposeType == 1) {
			schemaFile = new File(uploadingPath.getXsdPath()+"PROSchema.xsd");
			
			System.out.println(schemaFile.exists()+"PROSchema.xsd");
		}else if(purposeType == 2) {
			schemaFile = new File(uploadingPath.getXsdPath()+"ManufactureSchema.xsd");
			
			System.out.println(schemaFile.exists()+"ManufactureSchema.xsd");
		}else if(purposeType == 3) {
			schemaFile = new File(uploadingPath.getXsdPath()+"IVEDAExporterPackingDtl.xsd");
			
			System.out.println(schemaFile.exists()+"IVEDAExporterPackingDtl.xsd");
		}else {
			System.out.println("purpose not found 404 .....................");
		}
		
	     // Source xmlFile = new StreamSource(new File("F:\\DAVA\\DAVA_PORTAL\\src\\main\\webapp\\WEB-INF\\XML\\PROSchema.xml"));
	    Source xmlFile = new StreamSource(new File(xmlFilePath.toString()));
	     // System.err.println("xml file path--- "+);
	    	//Source xmlFile = new StreamSource(new File("F:\\abc.xml"));
	    	
	    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    	
	    	try {
	    		System.out.println("schemaFile.canRead();"+schemaFile.canRead());
	    		System.out.println("schemaFile.canRead();"+schemaFile.canWrite());
	    		schemaFile.setReadable(true);
	    	  Schema schema = schemaFactory.newSchema(schemaFile);
	    	  Validator validator = schema.newValidator();
	    	  validator.validate(xmlFile);
	    	  System.out.println(xmlFile.getSystemId() + " \nis xsd Format valid");
	    	  response = "ProperFormat";
	    	} 
	    	catch (SAXException e) {
	    	  System.out.println(xmlFile.getSystemId() + " \nis xsd Format NOT valid reason:" + e);
	    	  
	    	  String expReason=e.toString();
	    	  String[] data=expReason.split(";");
	    	  response="your xml is not in proper format, details are given below : \n"
	    	  		+ data[2] + "\n" + data[4];
	    	  
	    	} 
	    	catch (IOException e) {} 

		return response;
	}
	
	/*
	 * @RequestMapping(value = "/saveXmlData/{enDocid}/{purposeType}", method =
	 * RequestMethod.POST) public String saveXmlData(@RequestParam("uploadfile")
	 * MultipartFile uploadfile, @PathVariable String enDocid,@PathVariable String
	 * purposeType,HttpServletRequest request, HttpServletResponse
	 * response,HttpSession session) {
	 * 
	 * System.err.println("  upload file------ "+uploadfile.getOriginalFilename());
	 * System.err.println("upload ---- --   "+uploadfile.getSize()); Path xmlPath =
	 * null ; int docId = Integer.parseInt(encodedservice.decode(enDocid)); Integer
	 * purpose = Integer.parseInt(purposeType);
	 * System.out.println("purpose          "+purpose); //Upload file locally try {
	 * // Get the file and save it somewhere byte[] bytes = uploadfile.getBytes();
	 * xmlPath = Paths.get(UPLOADED_FOLDER + uploadfile.getOriginalFilename());
	 * String fileasString = new String(Files.readAllBytes(xmlPath),
	 * StandardCharsets.UTF_8); // String hashvalue = fileString.hashCode()+"";
	 * if(purpose == 1) { boolean a= davaServices.saveProductInTable(fileasString);
	 * }else if(purpose == 2) { boolean a=
	 * davaServices.saveManufacturerInTable(fileasString); }else if(purpose == 3){
	 * boolean a= davaServices.savePackingInTable(fileasString);
	 * System.out.println(a); System.out.println("tertiary exporting packaing");
	 * }else { System.out.
	 * println("purpose not found 404................................................................."
	 * ); }
	 * 
	 * davaServices.updateFinalStatus(docId);
	 * 
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * System.out.println("xmlPath------------  "+xmlPath);
	 * 
	 * ProductModel proModel = convertXmlToBean(xmlPath);
	 * System.out.println("product model in save  after convertion-- "+proModel);
	 * return "redirect:/UploadXmlDataPage";
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/saveXmlData/{enDocid}/{purposeType}", method = RequestMethod.POST)
	public String saveXmlData(@RequestParam("uploadfile") MultipartFile uploadfile, @PathVariable String enDocid,@PathVariable String purposeType,HttpServletRequest request, HttpServletResponse response,HttpSession session,RedirectAttributes attr)
	{
		
		String stChecksum = "";
		try {
			byte[] uploadBytes = uploadfile.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(uploadBytes);
			String hashString = new BigInteger(1,digest).toString(16);
			stChecksum = hashString.trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String xmldata=request.getParameter("xmlUploadData");
		if(!stChecksum.equals(xmldata)) {
			attr.addFlashAttribute("flag", 4);
			return "redirect:/UploadXmlDataPage";
		}
		
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		String userName = userDetails.get(0).getUserName();
		System.out.println("userNAmeeee :  " + userName);
		Long userid = userDetails.get(0).getUserId();
		System.out.println("userid ::::: " + userid);
		
		EXP_TERTIARY_LIST exp_tertiary_list=null;
		MANUFACTURE_SCHEMA_LIST manufacture_schema_list = null;
		PRODUCT_SCHEMA_LIST prod_schema_list = null;
		System.err.println("  upload file------ "+uploadfile.getOriginalFilename());
		System.err.println("upload ---- --   "+uploadfile.getSize());
		Path xmlPath = null ;
		int docId = Integer.parseInt(encodedservice.decode(enDocid));
		Integer purpose = Integer.parseInt(purposeType);
		System.out.println("purpose          "+purpose);
		//Upload file locally
	       try {
	    	   // Get the file and save it somewhere
	            byte[] bytes = uploadfile.getBytes();
	            xmlPath = Paths.get(uploadingPath.getXmlPath() + uploadfile.getOriginalFilename());
	            String fileasString = new String(Files.readAllBytes(xmlPath), StandardCharsets.UTF_8);
	            //StringBuffer sb = new StringBuffer();
	            //sb.append(fileasString);
	            //System.out.println(fileasString);
	            //String hashvalue = fileString.hashCode()+"";
	            //copy from log to upload table
				//UploadXmlDataDtlDomain uploadDomain = davaServices.saveUploadDataDtl(finalName,doc_size,doc_id,path1,purposeType);

	            String xmlPreview="";
	            if(purpose == 1) {
	            	//boolean a=  davaServices.saveProductInTable(fileasString);

	            	File multiFile=new File(uploadfile.getOriginalFilename());
	        		try {
	        			multiFile.createNewFile();
	        			FileOutputStream fos = new FileOutputStream(multiFile);
	        			fos.write(uploadfile.getBytes());
	        			fos.close();
	        		} catch (IOException e1) {
	        			e1.printStackTrace();
	        		}
	            	
	            	
	            	try {
		       			JAXBContext jaxbContext = JAXBContext.newInstance(PRODUCT_SCHEMA_LIST.class);
		       			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		       			prod_schema_list=(PRODUCT_SCHEMA_LIST) jaxbUnmarshaller.unmarshal(multiFile);
		       			LOGGER.info("myXmlBean file name {}",prod_schema_list.getProductSchemaDtl().get(0).getComposition());
		       			LOGGER.info("Product view {}",prod_schema_list);
		       			xmlPreview=prod_schema_list.toString();
	            	} catch (JAXBException e) {
	            		e.printStackTrace();
	            	}
	            	
	            	if(prod_schema_list!=null) {
	            		//DrugMst drug=davaServices.saveProductDetails(prod_schema_list,docId);
	            		 UploadXmlDataDtlLogDomain dom= davaServices.getUploadedDataLog(docId);
	            		UploadXmlDataDtlDomain uploadDomain = davaServices.saveUploadDataDtlfromLog(dom);
	            		//davaServices.saveProductInTable(fileasString,userDetails.get(0).getNumInstId());
	            		attr.addFlashAttribute("flag", 1);
	            		
	            		String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXML");
	        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXML");
	        			sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
	        			//sendmail.transferToMailServer(userName, "Product Detail XML", "Your Product Detail XML is uploaded succesfully.");
	            		
	            		davaServices.addDataToEmailMst("Product Detail XML", request);
	            		
	            		davaServices.addEmailDetailsToDb(userid, userName, "Product Detail XML", "Your Product Detail XML is uploaded succesfully.", request);
	            		
	            	}
	            	
	            	davaServices.updateFinalStatus(docId,fileasString);
	            	
	            }else if(purpose == 2) {
	            	//boolean a=  davaServices.saveManufacturerInTable(fileasString);
	            	
	            	File multiFile=new File(uploadfile.getOriginalFilename());
	        		try {
	        			multiFile.createNewFile();
	        			FileOutputStream fos = new FileOutputStream(multiFile);
	        			fos.write(uploadfile.getBytes());
	        			fos.close();
	        		} catch (IOException e1) {
	        			e1.printStackTrace();
	        		}
	            	
	            	
	            	try {
		       			JAXBContext jaxbContext = JAXBContext.newInstance(MANUFACTURE_SCHEMA_LIST.class);
		       			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		       			manufacture_schema_list=(MANUFACTURE_SCHEMA_LIST) jaxbUnmarshaller.unmarshal(multiFile);
		       			LOGGER.info("myXmlBean file name {}",manufacture_schema_list.getInstitutePremiseDtl().get(0).getManufAdd());
		       			xmlPreview=manufacture_schema_list.toString();
	            	} catch (JAXBException e) {
	            		e.printStackTrace();
	            	}
	            	
	            	if(manufacture_schema_list!=null) {
	            		InstPremiseDtlDomain premiseDomain=davaServices.saveManufacturePremiseDetails(manufacture_schema_list,docId);
	            		attr.addFlashAttribute("flag", 2);
	            		
	            		String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXML");
	        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXML");
	        			sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
	        			
	            		//sendmail.transferToMailServer(userName, "Manufacturing Site Detail XML", "Your Manufacturing Site Detail XML is uploaded succesfully.");
	            	
	            		davaServices.addDataToEmailMst("Manufacturing Site Detail XML", request);
	            		
	            		davaServices.addEmailDetailsToDb(userid, userName, "Manufacturing Site Detail XML", "Your Manufacturing Site Detail XML is uploaded succesfully.", request);
	            		
	            	}
	            	davaServices.updateFinalStatus(docId,fileasString);
	            	
	            }else if(purpose == 3){
	            	//System.err.println(fileasString);
	            	
	            	davaServices.updateFinalStatus(docId,fileasString);
	            	
		            UploadXmlDataDtlLogDomain dom= davaServices.getUploadedDataLog(docId);

	            	//List<UploadXmlDataDtlDomain> dom = davaDao.getUploadedeData(docId);
					UploadXmlDataDtlDomain uploadDomain = davaServices.saveUploadDataDtlfromLog(dom);

	            	Integer uploadId = uploadDomain.getNumUploadId();
	            	
	            	String fileName = uploadDomain.getStrFilename();
	            	Long userId = (long) uploadDomain.getNumUserId();
	            	
	            	List<RegistrationDetails> rd = davaDao.getRegistrationDetails(userId);
	            	
	            	String UserName = rd.get(0).getUserName();
	            	
	            	Integer a=  davaServices.saveConsignmentDetailsInTable(uploadId);
	            	if(a==1) {
	            	attr.addFlashAttribute("flag", 3);
	            	
	            	String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXML");
        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXML");
        			sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
        			
	            	//sendmail.transferToMailServer(userName, "Tertiary Packing Detail XML", "Your Tertiary Packing Detail XML is uploaded succesfully by "+UserName+" and your file name is "+fileName);
	            	
	            	davaServices.addDataToEmailMst("Tertiary Packing Detail XML Process", request);
            		
            		davaServices.addEmailDetailsToDb(userId, userName, "Tertiary Packing Detail XML", "Your Tertiary Packing Detail XML is uploaded succesfully by "+UserName+" and your file name is "+fileName, request);
	            	}
	            	else {
	            		attr.addFlashAttribute("flag", 5);
	            	}
	            	//dml_insert_pack_dtl(uploadid int4, errorflag int4)
				/*
				 * File multiFile=new File(uploadfile.getOriginalFilename()); try {
				 * multiFile.createNewFile(); FileOutputStream fos = new
				 * FileOutputStream(multiFile); fos.write(uploadfile.getBytes()); fos.close(); }
				 * catch (IOException e1) { e1.printStackTrace(); }
				 * 
				 * 
				 * try { JAXBContext jaxbContext =
				 * JAXBContext.newInstance(EXP_TERTIARY_LIST.class); Unmarshaller
				 * jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				 * exp_tertiary_list=(EXP_TERTIARY_LIST) jaxbUnmarshaller.unmarshal(multiFile);
				 * LOGGER.info("myXmlBean file name {}",exp_tertiary_list.getConsignmentDetails(
				 * ).getFile_date()); xmlPreview=exp_tertiary_list.toString(); } catch
				 * (JAXBException e) { e.printStackTrace(); }
				 * 
				 * 
				 * if(exp_tertiary_list!=null) { ConsignmentDetailDomain
				 * consignmentDetailDomain=davaServices.saveConsignmentDetails(exp_tertiary_list
				 * ,docId); attr.addFlashAttribute("flag", 3);
				 * sendmail.transferToMailServer(userName, "Consignment Packaging Detail XML",
				 * "Your Consignment Packaging Detail XML is uploaded succesfully."); }
				 */
	            	
	            	
	            }else {
	            	System.out.println("no purpose type match..................");
	            }
	            
	            // davaServices.updateFinalStatus(docId,fileasString);
	         
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       System.out.println("xmlPath------------  "+xmlPath);
	       
	       ProductModel proModel =   convertXmlToBean(xmlPath);
		System.out.println("product model in save  after convertion-- "+proModel);
		return "redirect:/UploadXmlDataPage";

	}


	private ProductModel convertXmlToBean(Path  xmlPath) {

		
		/*
		 * File xmlFile = new File("PROSchema.xml"); ProductModel product = null;
		 * JAXBContext jaxbContext; try { jaxbContext =
		 * JAXBContext.newInstance(ProductModel.class);
		 * 
		 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 * 
		 * product = (ProductModel) jaxbUnmarshaller.unmarshal(xmlFile);
		 * List<ProductDetailModel> productList = product.getProductDetail();
		 * System.out.println("product from XML getFileName ----   "+product.getFileName
		 * ()+" product getManufCode=====   "+product.getManufCode());
		 * System.out.println("product data list--- "+productList.size());
		 * for(ProductDetailModel p:productList) {
		 * System.err.println("product detailsss=======  "+p.getProductName()
		 * +"   product code----  "+p.getProductCode()); }
		 * 
		 * } catch (JAXBException e) { e.printStackTrace(); }
		 */		  
		 		
			System.out.println("in convert bean");
	    try {
	    	System.out.println("in side try block");
	       // XmlMapper xmlMapper = new XmlMapper();

	        // read file and put contents into the string
	        String readContent = new String(Files.readAllBytes(xmlPath));
	        //System.err.println("readContent----------   "+readContent);
	        
	        // deserialize from the XML into a Phone object
	       // ProductModel deserializedData = xmlMapper.readValue(readContent, ProductModel.class);
	       // System.err.println("deserializedData------ "+deserializedData);
	        
	        // Print object details
	        System.out.println("Deserialized data: ");
			/*
			 * System.out.println("\tgetFileName: " + deserializedData.getFileName());
			 * System.out.println("\tgetManufCode: " + deserializedData.getManufCode());
			 */
	       // System.out.println("\tDisplay Size: " + deserializedData.getDisplaySize());
	    } catch (IOException e) {
	        // handle the exception
	    }
		
		
		
		return null;
	}
	
	@RequestMapping(value = "/getUploadXmlDetails",method = RequestMethod.GET)
	@ResponseBody
	public String getUploadXmlDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowUploadXmlDetails(request,0);
	
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	@RequestMapping(value = "/getConsignmentUploadXmlDetails",method = RequestMethod.GET)
	@ResponseBody
	public String getConsignmentUploadXmlDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowConsignUploadXmlDetails(request);
	
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	@RequestMapping(value = "/getXmlDiscription",method = RequestMethod.GET)
	@ResponseBody
	public String getXmlDis(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = davaServices.ShowXmlDiscription(request);
	
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	@RequestMapping(value = "/uploadXmlPage",method = RequestMethod.GET)
	public String getUploadXmlDet(HttpServletRequest request, HttpServletResponse response) 
	{
		System.err.println("in data table codeeeeeeeeeee");
		//String resp = "";
	     return "/UploadXml/uploadXmlPage";
	}
	
	@GetMapping(value = "/UploadedData")
	public String UploadedData(@ModelAttribute("uploadData") UploadDataForm uploadData,
			HttpServletRequest request) {

		List<DataUploadTypeMstDomain> dataType = davaDao.getDataUploadType();
		request.setAttribute("dataType", dataType);
		return "UploadedData";
	}
	
	@GetMapping(value = "/UploadedAllDataInstWise")
	public String UploadedAllDataInstWise(@ModelAttribute("uploadData") UploadDataForm uploadData, HttpServletRequest request) {

		List<DataUploadTypeMstDomain> dataType = davaDao.getDataUploadType();
		request.setAttribute("dataType", dataType);
		return "UploadedAllDataInst";
	}
	
	@PostMapping(value = "/saveTotalRecall")
	public String saveOfficialReg(@ModelAttribute("uploadData") UploadDataForm uploadData, BindingResult result, HttpServletRequest request,RedirectAttributes attr) 
	{
		String value=""; 
			Long userId=userData.getUserId();
			Integer upId = uploadData.getUploadId();
			System.err.println("uploaded  Id  ====   "+upId);
			System.err.println("User  Id  ====   "+userId);
			
			String recall = davaServices.totalRecall(upId,userId);
			
			attr.addFlashAttribute("flagRecall", 1);
			return "redirect:/UploadedData";
			
		
	}

	
	@PostMapping("/viewUploadedXML")
	@ResponseBody
	public String viewUploadedXML(@RequestParam("docId") String data_, HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("Id::::");
		System.out.println("data__=="+data_);
	    String docId = request.getParameter("docId");
	    System.out.println("Id::::"+docId);
		String value2=decode(docId);
		String value3=reverse(value2);
		String value4 = decode(value3);
		int doc_id = Integer.parseInt(value4);
		
		
		
		
		List<UploadXmlDataDtlDomain> dom = davaDao.getUploadedeData(doc_id);
    	
		 String finalstring="No Data Found";
		String xslFile="";
		String strRealPathLogo = request.getSession().getServletContext().getRealPath("/WEB-INF/JSP/RegistrationPages/");
		
		String Id=request.getParameter("enfId");
		System.out.println("Id::::"+Id);
		if(dom.size()>0) {
	      String strXml= dom.get(0).getXmlData();
	      System.out.println("xml string:::"+strXml);
	      
	      int purposeType=dom.get(0).getNum_purposeTypeId();
	      
	      if(purposeType == 1) {
				xslFile="Product.xsl";
			}else if(purposeType == 2) {
				xslFile="Manufacture.xsl";
			}else if(purposeType == 3) {
				xslFile= "Exporter.xsl";
			}
		String xslInput = strRealPathLogo+File.separator+xslFile;
	      FileInputStream xsl;
		try {
			xsl = new FileInputStream(xslInput);
			TransformerFactory tFactory = TransformerFactory.newInstance();
		       StreamSource styleSource = new StreamSource(xsl);
		       Transformer transformer = tFactory.newTransformer(styleSource);
		       String s = new String(strXml.getBytes(),"UTF-8");
			   InputStream is = new ByteArrayInputStream(s.getBytes());
			   StreamSource xmlSource = new StreamSource(is);
			       
			   StringWriter outWriter = new StringWriter();
			   StreamResult result1 = new StreamResult( outWriter );
			   transformer.transform(xmlSource, result1);
			   StringBuffer sb = outWriter.getBuffer(); 
			   
			   finalstring = sb.toString();
			   
			   System.out.println("response::::"+finalstring);
			   request.setAttribute("viewdata", finalstring);
			   
			   
			   
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	      
		}
		
		
		return finalstring;
	
    }

	
	@RequestMapping(value ="/ShowConsignmnetDetails" ,method = RequestMethod.POST)
	public String ShowConsignmnetDetails(@RequestParam("docId") int docId,
			HttpServletRequest request)  {

			String data = davaDao.getConsignmentDetails(docId);
			request.setAttribute("data", data);
		if(data==null || data=="")
			request.setAttribute("error", "No Tree View Details to show!");
		return "ShowDetails";
	}
	
	@GetMapping(value = "/getUploadedData")
	public String getUploadedData(@ModelAttribute("uploadData") UploadDataForm uploadData,
			HttpServletRequest request) {

		List<DataUploadTypeMstDomain> dataType = davaDao.getDataUploadType();
		request.setAttribute("dataType", dataType);
		return "CustomUploadedData";
	}
	
	@RequestMapping(value = "/getUploadExporterDetails",method = RequestMethod.GET)
	@ResponseBody
	public String getUploadExporterDetails(@RequestParam("numTypeId") int numTypeId,HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		System.out.println("numTypeId=="+numTypeId);
		String jsonResponse = davaServices.ShowUploadXmlDetails(request,numTypeId);
	
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	public String decode(String strString_p) {
		if (strString_p == null)
			strString_p = "";
		else {
			try {
				strString_p = new String((new sun.misc.BASE64Decoder()).decodeBuffer(strString_p));
			} catch (Exception e) {
			}
		}
		return strString_p;
	}
	public static String reverse(String input) {
		char[] in = input.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}
	@RequestMapping(value = "/uploadFilePDF", method = RequestMethod.POST)
	public @ResponseBody List<FileUploadFlag> uploadFilePDF(@RequestParam("uploadfile") MultipartFile uploadfile,@RequestParam("docId1") String docId1,
			 HttpServletRequest request, HttpServletResponse response,HttpSession session)
			throws Exception {
		

	
		
		
		String value5=decode(docId1);
		String value6=reverse(value5);
		String value7 = decode(value6);
		int doc_id = Integer.parseInt(value7);
		
		
		
		
		
		String file = request.getParameter("filename");
		String fileSize = uploadfile.getSize() / 1024 + " Kb";
		String FileNameOriginal = uploadfile.getOriginalFilename();
		System.out.println("FileNameOriginal-----------   "+FileNameOriginal);

		String value1=request.getParameter("hashValue");
		String value2=decode(value1);
		String value3=reverse(value2);
		String hashValue=value3;
		System.out.println("hashValue:::"+hashValue);
		String hash=null;

		if (uploadfile != null) {
			String fakePath="C:\\fakepath\\"+FileNameOriginal;
			hash=encodedservice.encode(fakePath);
			System.out.println("hash:::"+hash);
		}
		
		FileUploadFlag obj_FileUploadFlag = new FileUploadFlag();
		List<FileUploadFlag> returnList = new ArrayList<FileUploadFlag>();
		returnList.clear();
		obj_FileUploadFlag.setFileName("");
		obj_FileUploadFlag.setSuccessFlag(0);
		returnList.add(obj_FileUploadFlag);
		int extsize = StringUtils.countMatches(uploadfile.getOriginalFilename(), ".");
		boolean result = false ;
		String finalName =null;
			
		 String check=null;
			int urlcheck = 0;
		GlobalAction globalAction=new GlobalAction();
		if(uploadfile!=null) {
			check =GlobalAction.validateFileContentType("pdf", uploadfile);
			 urlcheck=GlobalAction.checkFileContainUrl(uploadfile);
		}
		/*
		 * if ((uploadfile.getContentType().equalsIgnoreCase("application/pdf")) ||
		 * (uploadfile.getContentType().equalsIgnoreCase("application/force-download"))
		 * && FilenameUtils.isExtension(uploadfile.getOriginalFilename(), "pdf") &&
		 * extsize == 1) {
		 */
		if ( hash.toString().equals(hashValue) ) {
		if(check != "12" && urlcheck!=19 ) {
	//	if(check != "12" ) {
			if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024 && Integer.parseInt(fileSize.split(" ")[0]) > 0) {
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			

				try {
					
					String path = ftpProps.getTempupload(); // Initially file uploaded in TempFile folder
					finalName = doc_id+ ".pdf";
					String finalPath = path+finalName;
				result= ftpService.uploadFile(finalName, uploadfile.getInputStream(), path); // file upload on ftp temp folder
						 
						 
					  
					if (!result) {
						System.out.println("File not uploaded!!!!");
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(3);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return returnList;
					}
					else {
						System.err.println("File Uploaded Successfully!!!");
						UploadXmlDataDtlDomain uploadDomain = davaServices.saveUploadACkDtl(FileNameOriginal,doc_id, finalPath);

					}
					
				} catch (IOException e) {
					e.printStackTrace();

				}

			}else {
				returnList.clear();
				obj_FileUploadFlag.setSuccessFlag(2);
				obj_FileUploadFlag.setFileName(FileNameOriginal);
				returnList.add(obj_FileUploadFlag);
				return returnList;
			}
		} else {
			returnList.clear();
			//obj_FileUploadFlag.setSuccessFlag(1);
			obj_FileUploadFlag.setSuccessFlag(4);
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			returnList.add(obj_FileUploadFlag);
			return returnList;
		}
	}else {
		returnList.clear();
		//obj_FileUploadFlag.setSuccessFlag(1);
		obj_FileUploadFlag.setSuccessFlag(4);
		obj_FileUploadFlag.setFileName(FileNameOriginal);
		returnList.add(obj_FileUploadFlag);
		return returnList;
	}

		returnList.clear();
		String strDocId = encodedservice.encode(doc_id + "");
		obj_FileUploadFlag.setSuccessFlag(5);

		obj_FileUploadFlag.seteNSuccessFlag(strDocId);
		obj_FileUploadFlag.setFileName(FileNameOriginal);
		returnList.add(obj_FileUploadFlag);
		
		return returnList;
	}
	
	@GetMapping(value = "/RecalledData")
	public String RecalledData(@ModelAttribute("uploadData") UploadDataForm uploadData,
			HttpServletRequest request) {

		
		return "DataRecalled";
	}
	
	@RequestMapping(value = "/getRecalledUploadXML",method = RequestMethod.GET)
	@ResponseBody
	public String getRecalledUploadXML(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = davaServices.GetRecalledUploadedXML(request,0);
	
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	@GetMapping(value = "/showAllUploadedData")
	public String showAllUploadedData(@ModelAttribute("uploadData") UploadDataForm uploadData, HttpServletRequest request) {
		
		List<RegistrationDetails> regList = davaDao.getAllRegistrations();
		request.setAttribute("regList", regList);
		
		//List<Object> registrationList = davaDao.getRegistrationListing(UserId);
		
		return "AllUploadedData";
	}
	
	@RequestMapping(value = "/getAllUploadXmlDetails",method = RequestMethod.GET)
	@ResponseBody
	public String getAllUploadXmlDetails(@RequestParam("company") Integer company,@RequestParam("fromdate") String fromdate,@RequestParam("todate") String todate,HttpServletRequest request, HttpServletResponse response) 
	{
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("in data table code");
		System.out.println(company+" company  "+fromdate+" fromdate "+todate+"  todate");
		Date dateFromDate= null;
		try {
			dateFromDate = inputFormat.parse(fromdate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Date dateToDate= null;
		try {	
			dateToDate = inputFormat.parse(todate);
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
		
		System.out.println(dateFromDate+"   dates   "+dateToDate);
		
		String jsonResponse = davaServices.ShowAllUploadXmlDetails(request,company,dateFromDate,dateToDate);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	
	@GetMapping("/getCompanyProfileData")
	public ResponseEntity<List<RegistrationDetails>> loadRegWiseData(@RequestParam("company") Long company,HttpServletRequest request) {
		System.err.println(company+" company  ");
		List<RegistrationDetails> list = davaServices.fetchRegistrationData(company,request);
		System.out.println(list.get(0).getApplicantType());
		return new ResponseEntity<List<RegistrationDetails>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateConsignmentDtls")
	public String updateConsignmentDtls(@ModelAttribute("uploadData") UploadDataForm uploadData, BindingResult result, HttpServletRequest request,RedirectAttributes attr) 
	{
		String value=""; 
			Long userId=userData.getUserId();
			Integer upId = uploadData.getUploadId();
			
			//String recall = davaServices.totalRecall(upId,userId);
			UploadXmlInvoiceDtlDomain invDtls = davaServices.updateConsignmentDtls(upId,uploadData);
			System.err.println(invDtls.getStrInvoiceNo());
			attr.addFlashAttribute("flagConsignDtls", 1);
			return "redirect:/UploadedData";
			
	}
	
	/*
	 * @GetMapping(value = "/ConsignmentDetailPage") public String
	 * ConsignmentDetailPage(@ModelAttribute("uploadData") UploadDataForm
	 * uploadData, HttpServletRequest request) { String enUploadId =
	 * request.getParameter("enUploadId"); System.out.println(enUploadId);
	 * 
	 * String value2=decode(enUploadId); String value3=reverse(value2); int uploadId
	 * = Integer.parseInt(encodedservice.decode(value3));
	 * 
	 * System.err.println("uploadId-------   " + uploadId);
	 * request.setAttribute("uploadId", uploadId);
	 * 
	 * List<UploadXmlDataDtlDomain> upData = davaServices.getUploadedData(uploadId);
	 * String fileName = upData.get(0).getStrFilename();
	 * request.setAttribute("fileName", fileName);
	 * 
	 * List<RegionMstDomain> regionDtls = crmServ.loadRegion();
	 * request.setAttribute("regionDtls", regionDtls);
	 * 
	 * List<CountryMst> country = davaDao.getCountryNames();
	 * request.setAttribute("country", country);
	 * 
	 * List<PortOfExportDomain> port = davaDao.getAllPorts();
	 * request.setAttribute("port", port);
	 * 
	 * return "AddConsignmentDetails"; }
	 */
	
	
	
	  @PostMapping(value = "/ConsignmentDetailPage") 
	  public String ConsignmentDetailPage(@ModelAttribute("uploadData") UploadDataForm
	  uploadData, HttpServletRequest request) {
		  String enUploadId = request.getParameter("enUploadId"); 
		  System.out.println(enUploadId);
	  
	  String value2=decode(enUploadId); 
	  String value3=reverse(value2); 
	  int uploadId = Integer.parseInt(encodedservice.decode(value3));
	  
	  System.err.println("uploadId-------   " + uploadId);
	  request.setAttribute("uploadId", uploadId);
	  
	  List<UploadXmlDataDtlDomain> upData = davaServices.getUploadedData(uploadId);
	  String fileName = upData.get(0).getStrFilename();
	  request.setAttribute("fileName", fileName);
	  
	  List<RegionMstDomain> regionDtls = crmServ.loadRegion();
	  request.setAttribute("regionDtls", regionDtls);
	  
	  List<CountryMst> country = davaDao.getCountryNames();
	  request.setAttribute("country", country);
	  
	  List<PortOfExportDomain> port = davaDao.getAllPorts();
	  request.setAttribute("port", port);
	  
	  return "AddConsignmentDetails"; }
	 
	
	
	@RequestMapping(value = "/saveConsignmentDetailsPage", method = RequestMethod.POST)
	public String saveInstPremisesAddressDetails(@ModelAttribute("uploadData") UploadDataForm uploadData, BindingResult result, HttpServletRequest request,RedirectAttributes attr){

		System.out.println("IN Testing ACTION");
		String res = "";
		List<String> errorMessage = new ArrayList<String>();
		if (result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for(int i=0;i<errorList.size();i++)
			{
				String codes = errorList.get(i).getCodes()[1].substring(errorList.get(i).getCodes()[1].lastIndexOf(".")+1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors", errorMessage);
			res = "redirect:/ConsignmentDetailPage";
		}
		else{
			System.out.println(uploadData.getUploadId());
			
			System.out.println(uploadData.getAddedList_strCon());
			String addedListCon = uploadData.getAddedList_strCon();

			List<String> list_ewayBill = new ArrayList<String>() ;
			List<String> list_billDate = new ArrayList<String>() ;
			List<String> list_exportingRegion = new ArrayList<String>() ;
			List<String> list_exportingCountry = new ArrayList<String>() ;
			List<String> list_portName = new ArrayList<String>() ;
			List<String> list_landingPort = new ArrayList<String>() ;
			
			List<String> list_tertiaryPacks = new ArrayList<String>();
			List<String> list_s3packs = new ArrayList<String>();
			List<String> list_s2packs = new ArrayList<String>();
			List<String> list_s1packs = new ArrayList<String>();
			List<String> list_primaryPacks = new ArrayList<String>();
			try {
				JSONArray jArrCon = new JSONArray(addedListCon);
				System.out.println("JSON LENGTH - " + jArrCon.length());
				for (int i = 0; i < jArrCon.length(); i++) {
					JSONObject jobj = jArrCon.getJSONObject(i);
					list_ewayBill.add(jobj.getString("ewayBillText").toString());
					list_billDate.add(jobj.getString("billDateText").toString());
					list_exportingRegion.add(jobj.getString("exportingRegionText").toString());
					list_exportingCountry.add(jobj.getString("exportingCountryText").toString());
					list_portName.add(jobj.getString("portNameText").toString());
					list_landingPort.add(jobj.getString("landingPortText").toString());
					
					list_tertiaryPacks.add(jobj.getString("tertiary").toString());
					list_s3packs.add(jobj.getString("s3").toString());
					list_s2packs.add(jobj.getString("s2").toString());
					list_s1packs.add(jobj.getString("s1").toString());
					list_primaryPacks.add(jobj.getString("primary").toString());
			
				
				}
			} catch (Exception e) {
					e.printStackTrace();
			}
			
			
			uploadData.setList_ewayBill(list_ewayBill);
			uploadData.setList_billDate(list_billDate);
			uploadData.setList_exportingRegion(list_exportingRegion);
			uploadData.setList_exportingCountry(list_exportingCountry);
			uploadData.setList_portName(list_portName);
			uploadData.setList_landingPort(list_landingPort);
			uploadData.setList_tertiaryPacks(list_tertiaryPacks);
			uploadData.setList_s3packs(list_s3packs);
			uploadData.setList_s2packs(list_s2packs);
			uploadData.setList_s1packs(list_s1packs);
			uploadData.setList_primaryPacks(list_primaryPacks);
			
			UploadConsignDtlDomain consignDtl = davaServices.addConsignmentDtls(uploadData, request);

			System.out.println(uploadData.getAddedList_strPur());
			String appAddedListPur = uploadData.getAddedList_strPur();
			
			List<String> list_orderNo = new ArrayList<String>();
			List<String> list_orderDate = new ArrayList<String>();
			List<String> list_companyName = new ArrayList<String>();
			List<String> list_companyAdd = new ArrayList<String>();
			List<String> list_country = new ArrayList<String>();
			try {
				JSONArray jArrPur = new JSONArray(appAddedListPur);
				System.out.println("JSON LENGTH - " + jArrPur.length());
				for (int i = 0; i < jArrPur.length(); i++) {
					JSONObject jobj1 = jArrPur.getJSONObject(i);
					list_orderNo.add(jobj1.getString("orderNoText").toString());
					list_orderDate.add(jobj1.getString("orderDateText").toString());
					list_companyName.add(jobj1.getString("companyNameText").toString());
					list_companyAdd.add(jobj1.getString("companyAddText").toString());
					list_country.add(jobj1.getString("countryText").toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			uploadData.setList_orderNo(list_orderNo);
			uploadData.setList_orderDate(list_orderDate);
			uploadData.setList_companyName(list_companyName);
			uploadData.setList_companyAdd(list_companyAdd);
			uploadData.setList_country(list_country);
			
			UploadPurchaseOrderDtlDom purDtls = davaServices.addPurOrderDtls(uploadData, request);
			
			System.out.println(uploadData.getAddedList_strInv());
			String appAddedListInv = uploadData.getAddedList_strInv();
			
			List<String> list_invoiceNo = new ArrayList<String>();
			List<String> list_invoiceDate = new ArrayList<String>();
			List<String> list_purchaseInvNo = new ArrayList<String>();
			try {
				JSONArray jArrInv = new JSONArray(appAddedListInv);
				System.out.println("JSON LENGTH - " + jArrInv.length());
				for (int i = 0; i < jArrInv.length(); i++) {
					JSONObject jobj1 = jArrInv.getJSONObject(i);
					list_invoiceNo.add(jobj1.getString("invoiceNoText").toString());
					list_invoiceDate.add(jobj1.getString("invoiceDateText").toString());
					list_purchaseInvNo.add(jobj1.getString("purchaseInvNoText").toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			uploadData.setList_invoiceNo(list_invoiceNo);
			uploadData.setList_invoiceDate(list_invoiceDate);
			uploadData.setList_purchaseInvNo(list_purchaseInvNo);
			
			UploadInvoiceDtlDomain invDetls = davaServices.addInvoiceDetails(uploadData, request);
			
			//Call Procedure Here To update status and move data to main tables 
			
			res = "redirect:/Dashboard";
		}
		return res;

	}
	
	/*
	 * @RequestMapping(value="/fetchDataConsignmentDtls", method =
	 * RequestMethod.GET) public String
	 * consignDtlNoteSheet(@ModelAttribute("uploadData") UploadDataForm
	 * uploadData,HttpServletRequest request) { String finalstring = null; try {
	 * String enUploadId = request.getParameter("enUploadId");
	 * System.out.println(enUploadId); Integer uploadId =
	 * Integer.parseInt(encodedservice.decode(enUploadId));
	 * System.out.println("upload id - - - - - "+uploadId); String
	 * strXml="<roottag>"; String xmlString= davaDao.getConsignNotesheet(uploadId);
	 * System.out.println("xml string:::"+xmlString); strXml=strXml+
	 * xmlString+"</roottag>"; String strRealPathLogo =
	 * request.getSession().getServletContext().getRealPath(
	 * "/WEB-INF/JSP/UploadXml/"); String xslInput =
	 * strRealPathLogo+File.separator+"viewConsignmentDtls.xsl"; FileInputStream xsl
	 * = new FileInputStream(xslInput);
	 * 
	 * TransformerFactory tFactory = TransformerFactory.newInstance(); StreamSource
	 * styleSource = new StreamSource(xsl); Transformer transformer =
	 * tFactory.newTransformer(styleSource); String s = new
	 * String(strXml.getBytes(),"UTF-8"); InputStream is = new
	 * ByteArrayInputStream(s.getBytes()); StreamSource xmlSource = new
	 * StreamSource(is);
	 * 
	 * StringWriter outWriter = new StringWriter(); StreamResult result1 = new
	 * StreamResult( outWriter ); transformer.transform(xmlSource, result1);
	 * StringBuffer sb = outWriter.getBuffer();
	 * 
	 * finalstring = sb.toString();
	 * 
	 * System.out.println("response::::"+finalstring);
	 * request.setAttribute("viewdata", finalstring);
	 * 
	 * 
	 * return "redirect:/UploadedData"; } catch(Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return "redirect:/UploadedData"; }
	 */

	/*
	 * @RequestMapping(value = "/fetchDataConsignmentDtls/{enUploadId}",method =
	 * RequestMethod.GET)
	 * 
	 * @ResponseBody public String fetchDataConsignmentDtls(@PathVariable String
	 * enUploadId, HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	@PostMapping("/fetchDataConsignmentDtls")
	@ResponseBody
	public String fetchDataConsignmentDtls(@RequestParam("enUploadId") String data_, HttpServletRequest request,HttpServletResponse response) {
	{
		String finalstring = null;
		  try
			  {
			  
			  System.out.println("Id::::");
				System.out.println("data__=="+data_);
			    String enUploadId = request.getParameter("enUploadId");
				System.out.println("HELLO"+enUploadId);
				
				String value2=decode(enUploadId);
				String value3=reverse(value2);
				String value4 = decode(value3);
				int uploadId = Integer.parseInt(value4);
				
				 System.out.println("upload id - - - - - "+uploadId);
				
				/* Integer uploadId = Integer.parseInt(encodedservice.decode(enUploadId)); */
				 System.out.println("upload id - - - - - "+uploadId);
			     String strXml="<roottag>";
			     String xmlString= davaDao.getConsignNotesheet(uploadId);
			      System.out.println("xml string:::"+xmlString);
			      strXml=strXml+ xmlString+"</roottag>";
	    		  String strRealPathLogo = request.getSession().getServletContext().getRealPath("/WEB-INF/JSP/UploadXml/");
	    	      String xslInput = strRealPathLogo+File.separator+"viewConsignmentDtls.xsl";
			      FileInputStream xsl = new FileInputStream(xslInput);
			      
	    	       TransformerFactory tFactory = TransformerFactory.newInstance();
			       StreamSource styleSource = new StreamSource(xsl);
			       Transformer transformer = tFactory.newTransformer(styleSource);
			       String s = new String(strXml.getBytes(),"UTF-8");
				   InputStream is = new ByteArrayInputStream(s.getBytes());
 			       StreamSource xmlSource = new StreamSource(is);
 			       
				   StringWriter outWriter = new StringWriter();
				   StreamResult result1 = new StreamResult( outWriter );
	               transformer.transform(xmlSource, result1);
				   StringBuffer sb = outWriter.getBuffer(); 
				   
				   finalstring = sb.toString();
				   
				   System.out.println("response::::"+finalstring);
				   request.setAttribute("viewdata", finalstring);
				   
				   
				   return finalstring;
			  }
	    	  catch(Exception e)
	    	  {
	    		  
	    		  e.printStackTrace();  
	    	  }
		   
		    return finalstring;
	}
}
}
