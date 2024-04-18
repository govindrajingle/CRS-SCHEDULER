package in.cdacnoida.dava.service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import in.cdacnoida.dava.entities.UploadXmlDataDtlDomain;
import in.cdacnoida.dava.model.FileUploadFlag;
import in.cdacnoida.dava.util.FileStorageException;
import in.cdacnoida.dava.util.MyFileNotFoundException;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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

import in.cdacnoida.dava.controllers.FtpService;
import in.cdacnoida.dava.controllers.MD5Hash;
import in.cdacnoida.dava.controllers.UploadXml;
import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.ConsignmentDetailDomain;
import in.cdacnoida.dava.entities.DataUploadTypeMstDomain;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.FileUploadLogEntity;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.UploadXmlDataDtlDomain;
import in.cdacnoida.dava.model.EXP_TERTIARY_LIST;
import in.cdacnoida.dava.model.FileParameters;
import in.cdacnoida.dava.model.FileUploadFlag;
import in.cdacnoida.dava.model.MANUFACTURE_SCHEMA_LIST;
import in.cdacnoida.dava.model.PRODUCT_SCHEMA_LIST;
import in.cdacnoida.dava.model.ProductDetailModel;
import in.cdacnoida.dava.model.ProductModel;
import in.cdacnoida.dava.model.UploadDataForm;
import in.cdacnoida.dava.model.XmlBean;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.GlobalService;
import in.cdacnoida.dava.springsecurity.LoggedInUserSession;
import in.cdacnoida.dava.transactions.DavaTransactions;
import in.cdacnoida.dava.util.Sendmail;
import in.cdacnoida.davaconfig.EmailContent;
import in.cdacnoida.davaconfig.FileUploadingPath;
import in.cdacnoida.davaconfig.FtpDetailsProperties;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
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


@Service
public class FileStorageService {
	
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
	public DavaDaoServices davaDao;
	
	@Autowired
	private FileUploadingPath uploadingPath;
	
	@Autowired
	private EmailContent emailContent;
	
	@Autowired
	DavaTransactions davaTran;
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UploadXml.class);
	
	@Value("${file.upload.dir}") 
	  private String UploadPath="";
	  
	  private final Path fileStorageLocation;
	 
	 
    
	public FileStorageService() {
        this.fileStorageLocation = Paths.get(UploadPath)
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println("fileName upload: " + fileName);
           
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            InputStream is1 =  file.getInputStream();
            String content1 = IOUtils.toString(is1);
            System.out.println("file.getInputStream()" + content1);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("file copied");
            
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    
    
    public @ResponseBody String storeFiles(MultipartFile uploadfile,HttpServletRequest request, FileParameters purpose) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(uploadfile.getOriginalFilename());
       
        
        String xmlResponse = null;
        int purposeType = purpose.getPurposeType();
        String userId = purpose.getUserId();
        String xmlData = purpose.getXmlData();
        
        long UserId = Long.parseLong(userId);
      
        int docId =0;
        
        int doc_size = 0, doc_id = 0;
		
		String fileSize = uploadfile.getSize() / 1024 + " Kb";
		String FileNameOriginal = uploadfile.getOriginalFilename();
		
		FileUploadLogEntity fileLog = new FileUploadLogEntity();
		fileLog.setDtTrDate(new Date());
		fileLog.setDtUploadDate(new Date());
		fileLog.setNumIsValid(1);
		fileLog.setNumTrUserId(1001);
		fileLog.setNumUserId(UserId);
		fileLog.setStrFileName(FileNameOriginal);
		FileUploadLogEntity logFile = davaTran.saveFileLogs(fileLog);
		System.err.println("Time at which file details hit server :--  "+logFile.getDtTrDate());

		FileUploadFlag obj_FileUploadFlag = new FileUploadFlag();
		List<FileUploadFlag> returnList = new ArrayList<FileUploadFlag>();
		returnList.clear();
		obj_FileUploadFlag.setFileName("");
		obj_FileUploadFlag.setSuccessFlag(0);
		returnList.add(obj_FileUploadFlag);
		//int extsize = StringUtils.countMatches(uploadfile.getOriginalFilename(), ".");
		boolean result = false ;
		String finalName =null;
		System.out.println(uploadfile.getContentType()+"      "+FilenameUtils.getExtension(uploadfile.getOriginalFilename()));
		if ((uploadfile.getContentType().equalsIgnoreCase("text/xml"))
				|| (uploadfile.getContentType().equalsIgnoreCase("application/octet-stream"))
						&& FilenameUtils.isExtension(uploadfile.getOriginalFilename(), "XML") /* && extsize == 1 */) {

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
				    	   
				            
				            System.out.println("in try block");
				            System.out.println("shubham");
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
						 
					System.out.println("finalName="+finalName);
					System.out.println(" uploadfile.getInputStream()="+ uploadfile.getInputStream());
					System.out.println("path="+path);
					System.out.println("path.toString()="+path);
					 
						  result= ftpService.uploadFile(finalName, uploadfile.getInputStream(), uploadingPath.getXmlPath() + uploadfile.getOriginalFilename()); // file upload on ftp temp folder
						  //result = true;
						
					if (!result) {
						xmlResponse = "File not uploaded!!!!" + " not uploaded";
						System.out.println("File not uploaded!!!!");
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(3);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return xmlResponse;
					}
					else {
						//xmlResponse = "File Uploaded Successfully!!!";
						//System.err.println("File Uploaded Successfully!!!");
						System.out.println(xmlfileString);
						davaServices.updateDocumentMstPath(finalName,doc_id);
						//boolean hashStatus = CheckHashValue(path1);
						//String codeList = davaDao.getduplicateCodes(xmlfileString);
						boolean hashStatus = true;
						String codeList = null;
						if(hashStatus == true) {
							UploadXmlDataDtlDomain uploadDomain = davaServices.saveUploadDesktopDataDtl(finalName,doc_size,doc_id,path1,purposeType,UserId,xmlData);
							System.out.println(uploadDomain.getNumUploadId());
				    		System.out.println(uploadDomain.getNumInstId());
				    		
							if(purposeType == 1) {
								/*
								 * PRODUCT_SCHEMA_LIST prod_schema_list = null; File multiFile=new
								 * File(uploadfile.getOriginalFilename()); try { multiFile.createNewFile();
								 * FileOutputStream fos = new FileOutputStream(multiFile);
								 * fos.write(uploadfile.getBytes()); fos.close(); } catch (IOException e1) {
								 * e1.printStackTrace(); } try { JAXBContext jaxbContext =
								 * JAXBContext.newInstance(PRODUCT_SCHEMA_LIST.class); Unmarshaller
								 * jaxbUnmarshaller = jaxbContext.createUnmarshaller();
								 * prod_schema_list=(PRODUCT_SCHEMA_LIST) jaxbUnmarshaller.unmarshal(multiFile);
								 * LOGGER.info("myXmlBean file name {}",prod_schema_list.getProductSchemaDtl().
								 * get(0).getComposition()); LOGGER.info("Product view {}",prod_schema_list);
								 * //xmlPreview=prod_schema_list.toString(); } catch (JAXBException e) {
								 * e.printStackTrace(); }
								 * 
								 * if(prod_schema_list!=null)
								 * davaServices.saveProductDetails(prod_schema_list,doc_id);
								 */
								
								List<RegistrationDetails> userDetails = davaDao.getRegistrationDetails(UserId);
								String userName = userDetails.get(0).getUserName();
				            	
				            	String response = davaServices.saveProductInTable(uploadDomain.getNumUploadId(),xmlfileString,uploadDomain.getNumInstId());
				            	if(response != null && response.length()>0) {
				            		xmlResponse = response;
				            		return xmlResponse;
				            	}
								
				            	//List<UploadXmlDataDtlDomain> uploaddata = davaServices.getUploadedData();
				            	List<UploadXmlDataDtlDomain> upData = davaTran.getUploadedDataDtlWitjoutStatus(uploadDomain.getNumUploadId());
				            	if(upData.get(0).getNumStatus()==1) {
				            		String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXML");
				        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXML");
				        			emailVerificationContent=emailVerificationContent.replaceAll("\\$FILE\\_NAME\\$", finalName);
				        			sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
				            	}else {
				            		String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXMLNotUploaded");
				        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXMLNotUploaded");
				        			emailVerificationContent=emailVerificationContent.replaceAll("\\$FILE\\_NAME\\$", finalName);
				        			sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
				            	}
				            	
				            	
				            	xmlResponse="File Uploaded Successfully";
			        			//sendmail.transferToMailServer(userName, "Product Detail XML", "Your Product Detail XML is uploaded succesfully.");
			            		
			            		//davaServices.addDataToEmailMst("Product Detail XML", request);
			            		
			            		//davaServices.addEmailDetailsToDb(UserId, userName, "Product Detail XML", "Your Product Detail XML is uploaded succesfully.", request);
			            		
				            	
				    		}else if(purposeType == 3){
				    			
				    			List<RegistrationDetails> userDetails = davaDao.getRegistrationDetails(UserId);
								String userName = userDetails.get(0).getUserName();
				    			
				    			if(codeList==null || codeList == "null" || codeList=="") {
				    				//Integer returnResult = 
				    				//davaServices.saveConsignmentDetailsInTable(uploadDomain.getNumUploadId());
			    				    //System.out.println(returnResult);
				    		        Integer returnResult = 1; //To schedule call above method in SchedulerConfig (saveConsignmentDetailsInTable).
				    				List<UploadXmlDataDtlDomain> upData = davaTran.getUploadedDataDtlWitjoutStatus(uploadDomain.getNumUploadId());//davaTran.getUploadedDetails(uploadDomain.getNumDocumentId());//
				    				System.out.println(upData.get(0).getNumStatus());
					            	if(returnResult==1) {
					            		String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXML");
					        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXML");
					        			emailVerificationContent=emailVerificationContent.replaceAll("\\$FILE\\_NAME\\$", finalName);
					        			//sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
					        			xmlResponse = "File Uploaded Successfully!!";
					            	}else {
					            		String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXMLNotUploaded");
					        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXMLNotUploaded");
					        			emailVerificationContent=emailVerificationContent.replaceAll("\\$FILE\\_NAME\\$", finalName);
					        			//sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
					        			xmlResponse = "File not Uploaded due to duplicate code!!";
					            	}
				        			
					            	//sendmail.transferToMailServer(userName, "Tertiary Packing Detail XML", "Your Tertiary Packing Detail XML is uploaded succesfully by "+UserName+" and your file name is "+fileName);
					            	
					            	//davaServices.addDataToEmailMst("Tertiary Packing Detail XML Process", request);
				            		
				            		//davaServices.addEmailDetailsToDb(UserId, userName, "Tertiary Packing Detail XML", "Your Tertiary Packing Detail XML is uploaded succesfully by "+userName+" and your file name is "+fileName, request);
					            	
				    			}else {
				    				xmlResponse = fileName + ": File has Duplicate Code";
				    				System.err.println("File has Duplicate Code.");
				    				return xmlResponse;
				    			}
				    		}
						}else {
							xmlResponse = fileName + ": File Content already exist";
							System.out.println("same file uploaded");
							return xmlResponse;
						}
						//return xmlResponse;
						
					}
					
					try {

					} catch (Exception e) {
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(4);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return xmlResponse;
					}
				} catch (IOException e) {
					e.printStackTrace();

				}

			} else {
				returnList.clear();
				obj_FileUploadFlag.setSuccessFlag(2);
				obj_FileUploadFlag.setFileName(FileNameOriginal);
				returnList.add(obj_FileUploadFlag);
				return xmlResponse;
			}
		} else {
			returnList.clear();
			obj_FileUploadFlag.setSuccessFlag(1);
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			returnList.add(obj_FileUploadFlag);
			return xmlResponse;
		}

		returnList.clear();
		String strDocId = encodedservice.encode(doc_id + "");
		obj_FileUploadFlag.setSuccessFlag(5);

		obj_FileUploadFlag.seteNSuccessFlag(strDocId);
		obj_FileUploadFlag.setFileName(FileNameOriginal);
		returnList.add(obj_FileUploadFlag);
      
		return xmlResponse;
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
			 * for (String modelListdata : uploaddata) {
			 * hashValues.add(modelListdata.getStrHashCode()); }
			 */
            if(uploaddata.contains(hashvalue)) 
            	response = false;
		return response;
	}
    
	/*
	 * public String saveXmlData(MultipartFile uploadfile, String enDocid,String
	 * purposeType,HttpServletRequest request, HttpServletResponse
	 * response,HttpSession session,RedirectAttributes attr) { String
	 * loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName
	 * (); List<RegistrationDetails> userDetails =
	 * davaDao.getUserDetails(loogedInUserId); String userName =
	 * userDetails.get(0).getUserName();
	 * 
	 * 
	 * EXP_TERTIARY_LIST exp_tertiary_list=null; MANUFACTURE_SCHEMA_LIST
	 * manufacture_schema_list = null; PRODUCT_SCHEMA_LIST prod_schema_list = null;
	 * System.err.println("  upload file------ "+uploadfile.getOriginalFilename());
	 * System.err.println("upload ---- --   "+uploadfile.getSize()); Path xmlPath =
	 * null ; int docId = Integer.parseInt(encodedservice.decode(enDocid)); Integer
	 * purpose = Integer.parseInt(purposeType);
	 * System.out.println("purpose          "+purpose); //Upload file locally try {
	 * // Get the file and save it somewhere byte[] bytes = uploadfile.getBytes();
	 * xmlPath = Paths.get(UPLOADED_FOLDER + uploadfile.getOriginalFilename());
	 * String fileasString = new String(Files.readAllBytes(xmlPath),
	 * StandardCharsets.UTF_8);
	 * 
	 * String xmlPreview=""; if(purpose == 1) { File multiFile=new
	 * File(uploadfile.getOriginalFilename()); try { multiFile.createNewFile();
	 * FileOutputStream fos = new FileOutputStream(multiFile);
	 * fos.write(uploadfile.getBytes()); fos.close(); } catch (IOException e1) {
	 * e1.printStackTrace(); }
	 * 
	 * 
	 * try { JAXBContext jaxbContext =
	 * JAXBContext.newInstance(PRODUCT_SCHEMA_LIST.class); Unmarshaller
	 * jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	 * prod_schema_list=(PRODUCT_SCHEMA_LIST) jaxbUnmarshaller.unmarshal(multiFile);
	 * LOGGER.info("myXmlBean file name {}",prod_schema_list.getProdEnvelope().
	 * getProductSchemaDtl().get(0).getComposition());
	 * LOGGER.info("Product view {}",prod_schema_list);
	 * xmlPreview=prod_schema_list.toString(); } catch (JAXBException e) {
	 * e.printStackTrace(); }
	 * 
	 * if(prod_schema_list!=null) { DrugMst
	 * drug=davaServices.saveProductDetails(prod_schema_list,docId);
	 * attr.addFlashAttribute("flag", 1); sendmail.transferToMailServer(userName,
	 * "Product Detail XML", "Your Product Detail XML is uploaded succesfully."); }
	 * 
	 * 
	 * }else if(purpose == 2) {
	 * 
	 * File multiFile=new File(uploadfile.getOriginalFilename()); try {
	 * multiFile.createNewFile(); FileOutputStream fos = new
	 * FileOutputStream(multiFile); fos.write(uploadfile.getBytes()); fos.close(); }
	 * catch (IOException e1) { e1.printStackTrace(); }
	 * 
	 * 
	 * try { JAXBContext jaxbContext =
	 * JAXBContext.newInstance(MANUFACTURE_SCHEMA_LIST.class); Unmarshaller
	 * jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	 * manufacture_schema_list=(MANUFACTURE_SCHEMA_LIST)
	 * jaxbUnmarshaller.unmarshal(multiFile);
	 * LOGGER.info("myXmlBean file name {}",manufacture_schema_list.
	 * getInstitutePremiseDtl().get(0).getManufAdd());
	 * xmlPreview=manufacture_schema_list.toString(); } catch (JAXBException e) {
	 * e.printStackTrace(); }
	 * 
	 * if(manufacture_schema_list!=null) { InstPremiseDtlDomain
	 * premiseDomain=davaServices.saveManufacturePremiseDetails(
	 * manufacture_schema_list,docId); attr.addFlashAttribute("flag", 2);
	 * sendmail.transferToMailServer(userName, "Manufacturing Site Detail XML",
	 * "Your Manufacturing Site Detail XML is uploaded succesfully."); }
	 * 
	 * }else if(purpose == 3){
	 * 
	 * }else { System.out.println("no purpose type match.................."); }
	 * 
	 * davaServices.updateFinalStatus(docId,fileasString);
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
	 * 
	 * private ProductModel convertXmlToBean(Path xmlPath) {
	 * 
	 * System.out.println("in convert bean");
	 * System.out.println("in side try block");
	 * System.out.println("Deserialized data: ");
	 * 
	 * return null; }
	 */

    public Resource loadFileAsResource(String fileName) throws MyFileNotFoundException {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}