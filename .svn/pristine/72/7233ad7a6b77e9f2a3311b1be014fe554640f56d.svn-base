package in.cdacnoida.dava.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.lowagie.text.pdf.PdfReader;

import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.UploadXmlDataDtlDomain;
import in.cdacnoida.dava.entities.WorkshopRegistrationDomain;
import in.cdacnoida.dava.model.FileUploadFlag;
import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.model.WorkshopRegistrationModel;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.GlobalService;
import in.cdacnoida.dava.util.FtpConnection;
import in.cdacnoida.dava.util.PDFUtility2;
//import in.cdacnoida.dava.util.SecurityUtil2;
import in.cdacnoida.dava.util.Sendmail;
import in.cdacnoida.davaconfig.EmailContent;
import in.cdacnoida.davaconfig.FtpDetailsProperties;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class GlobalAction {

	@Autowired
	public FtpConnection connection;

	/*
	 * @Autowired SecurityUtil2 SecurityUtil2;
	 */

	@Autowired
	DataEncoderService encodedservice;

	@Autowired
	FtpService ftpService;

	@Autowired
	GlobalService gService;

	@Autowired
	private DavaServices davaServices;

	@Autowired
	private Sendmail sendmail;

	@Autowired
	private FtpDetailsProperties ftpProps;

	@Autowired
	public DavaDaoServices davaDao;

	@Autowired
	private EmailContent emailContent;

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAction.class);

	@RequestMapping(value = "/uploadFile/{filename}/{docId}", method = RequestMethod.POST)
	public @ResponseBody List<FileUploadFlag> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile,
			@PathVariable String filename, @PathVariable int docId, HttpServletRequest request) throws Exception {

		List<FileUploadFlag> returnList = new ArrayList<FileUploadFlag>();
		int doc_size = 0, doc_id = 0;
		String fileSize = uploadfile.getSize() / 1024 + " Kb";
		String FileNameOriginal = uploadfile.getOriginalFilename();
		FileUploadFlag obj_FileUploadFlag = new FileUploadFlag();
System.out.println("FileNameOriginal::"+FileNameOriginal);
		String Value1=request.getParameter("hashValue");
		String value2=decode(Value1);
		String value3=reverse(value2);
		String hashValue=value3;
		System.out.println("hashValue:::"+hashValue);
		System.out.println("hashValue:::"+decode(hashValue));
		String hash=null;
		String hash2=null;
		String fileName=null;
		if (uploadfile != null) {
			String fakePath="C:\\fakepath\\"+FileNameOriginal;
			hash=encodedservice.encode(fakePath);
			System.out.println("hash:::"+hash);
		}
		
		String[] contentName = filename.split("shubham");

		if (contentName.length == 2) {
			filename = contentName[0];
			String xmldata = contentName[1];
			String ss=request.getParameter("xmlUploadData");
			System.out.println(xmldata+"::::::"+ss);
			String stChecksum = "";
			try {
				byte[] uploadBytes = uploadfile.getBytes();
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] digest = md5.digest(uploadBytes);
				String hashString = new BigInteger(1, digest).toString(16);
				stChecksum = hashString.trim();
				System.out.println("stChecksum::"+stChecksum);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!stChecksum.equals(xmldata)) {
				returnList.clear();
				obj_FileUploadFlag.setSuccessFlag(3);
				obj_FileUploadFlag.setFileName(FileNameOriginal);
				returnList.add(obj_FileUploadFlag);
				return returnList;

			}
		}

		returnList.clear();
		obj_FileUploadFlag.setFileName("");
		// obj_FileUploadFlag.setSuccessFlag(0);

		obj_FileUploadFlag.setSuccessFlag(5);

		returnList.add(obj_FileUploadFlag);
		int extsize = StringUtils.countMatches(uploadfile.getOriginalFilename(), ".");

		String check = null;
		int urlcheck = 0;
		String check1 = null;
		GlobalAction globalAction = new GlobalAction();
		if (uploadfile != null) {
			fileSize = uploadfile.getSize() / 1024 + " Kb";
			check = GlobalAction.validateFileContentType("pdf", uploadfile);
			urlcheck = GlobalAction.checkFileContainUrl(uploadfile);
		}

		if ((uploadfile.getContentType().equalsIgnoreCase("application/pdf"))
				&& FilenameUtils.isExtension(uploadfile.getOriginalFilename(), "pdf") && extsize == 1) {
			if ( hash.toString().equals(hashValue) ) {
			if(check != "12" && urlcheck != 19) {

			doc_size = Integer.parseInt(fileSize.split(" ")[0]);
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024 && Integer.parseInt(fileSize.split(" ")[0]) > 0) {

				try {

					String directory = /* request.getContextPath()+ */ftpProps.getDirectory() + "/";
					if (docId == 0) {
						doc_id = gService.addDocument(directory, doc_size, filename, "T", 1000001);
						System.err.println("in file upload doc id-- " + doc_id);

					} else {
						doc_id = docId;
						gService.updateDocumentSize(doc_id, doc_size);
					}
					String finalName = directory + doc_id + ".pdf";

					/*
					 * try { byte[] uploadBytes = uploadfile.getBytes(); String checkstring = new
					 * String(uploadBytes); ; // fileServices.cleanXSS(checkstring);
					 * cleanXSS(checkstring);
					 * 
					 * } catch (Exception e) { System.err.println("in not uploadddddd ");
					 * System.out.println("File not uloaded successfully dipen");
					 * returnList.clear(); obj_FileUploadFlag.setSuccessFlag(4);
					 * obj_FileUploadFlag.setFileName(FileNameOriginal);
					 * returnList.add(obj_FileUploadFlag); return returnList; }
					 */
					System.out.println("finalName::::" + finalName);
					System.out.println("directory::::" + directory);
					// boolean result =
					// connection.fileUplaodonFtp(uploadfile.getInputStream(),filename);
					boolean result = ftpService.uploadFile(finalName, uploadfile.getInputStream(), directory);
					davaServices.updateDocumentMstPath(finalName, doc_id);

					if (!result) {
						System.err.println("in not uploadddddd--3 ");
						System.out.println("File not uloaded successfully");
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(3);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return returnList;
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
			}else {
				returnList.clear();
				obj_FileUploadFlag.setSuccessFlag(4);
				obj_FileUploadFlag.setFileName(FileNameOriginal);
				returnList.add(obj_FileUploadFlag);
				return returnList;
			}
		}else {
			returnList.clear();
			obj_FileUploadFlag.setSuccessFlag(4);
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
		String docid=reverse(strDocId);
		String sId=encodedservice.encode(docid + "");
		obj_FileUploadFlag.setSuccessFlag(5);

		obj_FileUploadFlag.seteNSuccessFlag(sId);
		obj_FileUploadFlag.setFileName(FileNameOriginal);
		returnList.add(obj_FileUploadFlag);
		return returnList;
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
	// added by harshita
	/*
	 * @RequestMapping(value = "/addressProofFile/{filename}/{docId}/{haaPy}",
	 * method = RequestMethod.POST) public @ResponseBody List<FileUploadFlag>
	 * addressProofFile( @RequestParam("addressProofFile") MultipartFile
	 * addressProofFile,
	 * 
	 * @PathVariable String filename,@PathVariable int docId,String
	 * haaPy,HttpServletRequest request) {
	 */
	@RequestMapping(value = "/addressProofFile/{filename}/{docId}", method = RequestMethod.POST)
	public @ResponseBody List<FileUploadFlag> addressProofFile(
			@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			@RequestParam("addressProofFile") MultipartFile addressProofFile, @PathVariable String filename,
			@PathVariable int docId, HttpServletRequest request) {
		System.out.println("dfdferfedfdfdf");
		// System.out.println("haaPy"+haaPy);
		List<FileUploadFlag> returnList = new ArrayList<FileUploadFlag>();
		int doc_size = 0, doc_id = 0;
		String fileSize = addressProofFile.getSize() / 1024 + " Kb";
		String FileNameOriginal = addressProofFile.getOriginalFilename();
		System.out.println("FileNameOriginal::" + FileNameOriginal);
		FileUploadFlag obj_FileUploadFlag = new FileUploadFlag();

		System.out.println();
		String[] contentName = filename.split("shubham");
		System.out.println("contentName:::" + contentName);

		if (contentName.length == 2) {
			filename = contentName[0];
			String xmldata = contentName[1];
			String stChecksum = "";
			try {
				byte[] uploadBytes = addressProofFile.getBytes();
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] digest = md5.digest(uploadBytes);
				String hashString = new BigInteger(1, digest).toString(16);
				stChecksum = hashString.trim();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!stChecksum.equals(xmldata)) {
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
		int extsize = StringUtils.countMatches(addressProofFile.getOriginalFilename(), ".");

		if ((addressProofFile.getContentType().equalsIgnoreCase("application/pdf"))
				&& FilenameUtils.isExtension(addressProofFile.getOriginalFilename(), "pdf") && extsize == 1) {

			doc_size = Integer.parseInt(fileSize.split(" ")[0]);
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024 && Integer.parseInt(fileSize.split(" ")[0]) > 0) {

				try {

					String directory = /* request.getContextPath()+ */ftpProps.getDirectory() + "/";
					if (docId == 0) {
						doc_id = gService.addDocument(directory, doc_size, filename, "T", 1000001);
						System.err.println("in file upload doc id-- " + doc_id);

					} else {
						doc_id = docId;
						gService.updateDocumentSize(doc_id, doc_size);
					}
					String finalName = directory + doc_id + ".pdf";

					String addressFileHash = request.getParameter("addressProofDocument");
					System.out.println(":::::::::::::::::::::::::" + addressFileHash);
					boolean result = ftpService.addressProofFile(finalName, addressProofFile.getInputStream(),
							directory);
					davaServices.updateDocumentMstPath(finalName, doc_id);

					if (!result) {
						System.err.println("in not uploadddddd--1 ");
						System.out.println("File not uloaded successfully");
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(3);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return returnList;
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

	@RequestMapping(value = "/drugLicence/{filename}/{docId}", method = RequestMethod.POST)
	public @ResponseBody List<FileUploadFlag> drugLicence(@RequestParam("drugLicence") MultipartFile drugLicence,
			@PathVariable String filename, @PathVariable int docId, HttpServletRequest request) {

		List<FileUploadFlag> returnList = new ArrayList<FileUploadFlag>();
		int doc_size = 0, drugdoc_id = 0;
		String fileSize = drugLicence.getSize() / 1024 + " Kb";
		String FileNameOriginal = drugLicence.getOriginalFilename();
		FileUploadFlag obj_FileUploadFlag = new FileUploadFlag();

		String[] contentName = filename.split("shubham");

		if (contentName.length == 2) {
			filename = contentName[0];
			String xmldata = contentName[1];
			String stChecksum = "";
			try {
				byte[] uploadBytes = drugLicence.getBytes();
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] digest = md5.digest(uploadBytes);
				String hashString = new BigInteger(1, digest).toString(16);
				stChecksum = hashString.trim();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!stChecksum.equals(xmldata)) {
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
		int extsize = StringUtils.countMatches(drugLicence.getOriginalFilename(), ".");

		if ((drugLicence.getContentType().equalsIgnoreCase("application/pdf"))
				&& FilenameUtils.isExtension(drugLicence.getOriginalFilename(), "pdf") && extsize == 1) {

			doc_size = Integer.parseInt(fileSize.split(" ")[0]);
			obj_FileUploadFlag.setFileName(FileNameOriginal);
			if (Integer.parseInt(fileSize.split(" ")[0]) < 10 * 1024 && Integer.parseInt(fileSize.split(" ")[0]) > 0) {

				try {

					String directory = /* request.getContextPath()+ */ftpProps.getDirectory() + "/";
					if (docId == 0) {
						drugdoc_id = gService.addDocument(directory, doc_size, filename, "T", 1000001);
						System.err.println("in file upload doc id-- " + drugdoc_id);

					} else {
						drugdoc_id = docId;
						gService.updateDocumentSize(drugdoc_id, doc_size);
					}
					String finalName = directory + drugdoc_id + ".pdf";

					boolean result = ftpService.drugLicence(finalName, drugLicence.getInputStream(), directory);
					davaServices.updateDocumentMstPath(finalName, drugdoc_id);

					if (!result) {
						System.err.println("in not uploadddddd--2 ");
						System.out.println("File not uloaded successfully");
						returnList.clear();
						obj_FileUploadFlag.setSuccessFlag(3);
						obj_FileUploadFlag.setFileName(FileNameOriginal);
						returnList.add(obj_FileUploadFlag);
						return returnList;
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
		String strDocId = encodedservice.encode(drugdoc_id + "");
		obj_FileUploadFlag.setSuccessFlag(5);

		obj_FileUploadFlag.seteNSuccessFlag(strDocId);
		obj_FileUploadFlag.setFileName(FileNameOriginal);
		returnList.add(obj_FileUploadFlag);
		return returnList;
	}

//	@RequestMapping(value = "/downloadTmpFile_Secure/{ENdoc_id}/{fileType}", method = RequestMethod.GET)
	@RequestMapping(value = "/downloadTmpFile_Secure", method = RequestMethod.POST)
	public void downloadTmpFile_Secure(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.err.println("downloadTmpFile_Secure-------   ");
		
		
		String ENdoc_id = request.getParameter("ENdoc_id");
		String fileType2 = request.getParameter("fileType");
		int fileType = Integer.parseInt(fileType2);
		System.err.println("ENdoc_id-------   " + ENdoc_id);
		System.err.println("fileType-------   " + fileType);
		
	
		int BUFFER_SIZE = 4096;
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		
		
		String value2=decode(ENdoc_id);
		String value3=reverse(value2);
		int doc_id = Integer.parseInt(encodedservice.decode(value3));
		System.err.println("doc_id-------   " + doc_id);
		
		
		
		System.err.println("file type-------   " + fileType);
		String fileExtension = null;
		if (fileType == 2) {
			fileExtension = ".xml";
		} else
			fileExtension = ".pdf";
		// construct the complete absolute path of the file
		String strFileName = gService.getDocumentFileNameForDownload(doc_id) + fileExtension;
		System.out.println("str file name in down loa=-==== " + strFileName);

		String fullPath = gService.getDocumentFileNameQuery(doc_id);// tempPath + doc_id + ".pdf";
		System.err.println("full path in download-- " + fullPath);
		System.err.println("doc id in download-- " + doc_id);
		ServletOutputStream out = response.getOutputStream();
		response.setContentType(
				"application/" + strFileName.substring(strFileName.lastIndexOf(".") + 1, strFileName.length()));

		response.setHeader("Content-disposition", "attachment;filename=\"" + strFileName + "\"");

		// response.setHeader("Content-disposition", "inline");
		boolean fileExist = ftpService.checkFileExist(fullPath);
		if (fileExist) {
			boolean success = ftpService.downloadFiles(fullPath, out);

			/*
			 * System.err.println("dwnld file name-- "+strFileName); String a =
			 * "C:\\Users\\deepshikha.CDACNOIDA\\Downloads\\"+strFileName; Path temp =
			 * Files.move (Paths.get(a), Paths.get(
			 * "F:\\DAVA\\DAVA_PORTAL\\src\\main\\webapp\\WEB-INF\\XSD\\XmlFile.xml"));
			 * 
			 * if(temp != null) { System.out.println("File renamed and moved successfully");
			 * } else { System.out.println("Failed to move the file"); }
			 * 
			 */

		} else {
			System.out.println("File Does Not Exist");
		}
	}

	@RequestMapping(value = "/viewTmpFile_Secure/{ENdoc_id}/{fileType}", method = RequestMethod.GET)
	public void viewTmpFile_Secure(@PathVariable String ENdoc_id, @PathVariable int fileType,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		int BUFFER_SIZE = 4096;
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		int doc_id = Integer.parseInt(encodedservice.decode(ENdoc_id));
		System.err.println("file type-------   " + fileType);
		String fileExtension = null;
		if (fileType == 2) {
			fileExtension = ".xml";
		} else
			fileExtension = ".pdf";
		// construct the complete absolute path of the file
		String strFileName = gService.getDocumentFileNameForDownload(doc_id) + fileExtension;
		System.out.println("str file name in down loa=-==== " + strFileName);

		String fullPath = gService.getDocumentFileNameQuery(doc_id);// tempPath + doc_id + ".pdf";//updated by shruti on
																	// 21/06/2019 to set state-wise path
		System.err.println("full path in download-- " + fullPath);
		System.err.println("doc id in download-- " + doc_id);
		ServletOutputStream out = response.getOutputStream();
		response.setContentType(
				"application/" + strFileName.substring(strFileName.lastIndexOf(".") + 1, strFileName.length()));

		response.setHeader("Content-disposition", "inline");

		// response.setHeader("Content-disposition", "inline");
		boolean fileExist = ftpService.checkFileExist(fullPath);
		if (fileExist) {
			boolean success = ftpService.downloadFiles(fullPath, out);

			/*
			 * System.err.println("dwnld file name-- "+strFileName); String a =
			 * "C:\\Users\\deepshikha.CDACNOIDA\\Downloads\\"+strFileName; Path temp =
			 * Files.move (Paths.get(a), Paths.get(
			 * "F:\\DAVA\\DAVA_PORTAL\\src\\main\\webapp\\WEB-INF\\XSD\\XmlFile.xml"));
			 * 
			 * if(temp != null) { System.out.println("File renamed and moved successfully");
			 * } else { System.out.println("Failed to move the file"); }
			 * 
			 */

		} else {
			System.out.println("File Does Not Exist");
		}
	}

	@RequestMapping(value = "/WorkshopRegistration", method = RequestMethod.GET)
	public String ApprovedRegistrationData(
			@ModelAttribute("workshopRegistrationModel") WorkshopRegistrationModel workshopRegistrationModel,
			HttpServletRequest request) {
		String response = "";
		LoginBean loginBean = new LoginBean();
		response = "RegistrationOfWorkshop";
		request.setAttribute("loginBean", loginBean);
		request.setAttribute("generatedCaptcha", request.getSession().getAttribute("captcha"));
		return response;
	}

	@RequestMapping(value = "/saveWorkshopRegistration", method = RequestMethod.POST)
	public String saveDrugDetails(@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			@ModelAttribute("workshopRegistrationModel") WorkshopRegistrationModel workshopRegistrationModel,
			BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		System.out.println("IN Testing ACTION");
		String res = "";

		Long userId = registrationForm.getUserId();
		String userName = registrationForm.getUserName();
		WorkshopRegistrationDomain wDom = davaServices.addWorkshopRegistration(workshopRegistrationModel, request);
		String email = wDom.getEmailId();
		String emailVerificationSubject = emailContent.getEmailContent().get("emailSubjectForWorkshop");
		String emailVerificationContent = emailContent.getEmailContent().get("emailContentForWorkshop");

		emailVerificationContent = emailVerificationContent.replaceAll("\\$USER\\_NAME\\$", wDom.getStrName());
		emailVerificationContent = emailVerificationContent.replaceAll("\\$USER\\_NAME1\\$", wDom.getStrName2());
		emailVerificationContent = emailVerificationContent.replaceAll("\\$VENUE\\$", "will be diclosed later");
		emailVerificationContent = emailVerificationContent.replaceAll("\\$DATE\\_TIME\\$", "will be diclosed later");
		emailVerificationContent = emailVerificationContent.replaceAll("\\$BEFORE\\_DATE\\$", "will be diclosed later");
		sendmail.sendMailToUser(email, emailVerificationSubject, emailVerificationContent);
		// sendmail.transferToMailServer(email, "Your registration for Workshop is
		// completed.", "Dear User \n Link for feedback is provided here please fill
		// this form after attending the workshop. \n Team IVEDA \n
		// "+"https://docs.google.com/forms/d/e/1FAIpQLSe_JmUo3DBZ1Wj4EgiDsut6t9lt0-_jvrvKk2oI-VmnkG3jRg/viewform");

		davaServices.addDataToEmailMst("Workshop Registration Process", request);

		davaServices.addEmailDetailsToDb(userId, userName, "Your registration for Workshop is completed.",
				"Dear User \n Link for feedback is provided here please fill this form after attending the workshop. \n Team IVEDA \n                   "
						+ "https://docs.google.com/forms/d/e/1FAIpQLSe_JmUo3DBZ1Wj4EgiDsut6t9lt0-_jvrvKk2oI-VmnkG3jRg/viewform",
				request);

		attr.addFlashAttribute("flagSave", 1);
		res = "redirect:/WorkshopRegistration";
		return res;
	}

	/*
	 * @RequestMapping(value = "/checkifFileExists/{ENdoc_id}/{fileType}", method =
	 * RequestMethod.GET) public @ResponseBody String
	 * checkifFileExists(@PathVariable String ENdoc_id, @PathVariable int fileType,
	 * HttpServletRequest request, HttpServletResponse response) throws IOException
	 */ 
	
	@PostMapping("/checkifFileExists")
	@ResponseBody
	public String viewUploadedXML(@RequestParam("ENdoc_id") String data_, HttpServletRequest request,HttpServletResponse response) {
		
	
	{

		System.out.println("Id::::");
		System.out.println("data__=="+data_);
	    String ENdoc_id = request.getParameter("ENdoc_id");
	    String fileType = request.getParameter("fileType");
	    
	    System.out.println("Id::::"+ENdoc_id);
		String value2=decode(ENdoc_id);
		String value3=reverse(value2);
		String value4 = decode(value3);
		int doc_id = Integer.parseInt(value4);
		
		
		
	/*	int doc_id = Integer.parseInt(encodedservice.decode(ENdoc_id));*/
		System.err.println("file type-------   " + fileType);

		List<UploadXmlDataDtlDomain> dom = davaDao.getUploadedeData(doc_id);
		if (dom.size() > 0) {
			String strFileName = dom.get(0).getStrAckReceipt();
			if (strFileName == null || strFileName == "null")
				return "false";
			System.out.println("str file name in down loa=-==== " + strFileName);

			String fullPath = dom.get(0).getStrAckReceiptPath();
			System.err.println("full path in download-- " + fullPath);
			System.err.println("doc id in download-- " + doc_id);

			boolean fileExist = ftpService.checkFileExist(fullPath);
			if (fileExist)
				return "true";
			else
				return "false";
		}
		return "false";
	}
	}

	//@RequestMapping(value = "/downloadAckFile_Secure/{ENdoc_id}/{fileType}", method = RequestMethod.GET)
	@RequestMapping(value = "/downloadAckFile_Secure", method = RequestMethod.POST)
	public void downloadAckFile_Secure(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		
		

		String ENdoc_id = request.getParameter("ENdoc_id");
		String fileType1 = request.getParameter("fileType");
		int fileType = Integer.parseInt(fileType1);
		System.err.println("ENdoc_id-------   " + ENdoc_id);
		System.err.println("fileType-------   " + fileType);
		
		//added by harshita
		String value2=decode(ENdoc_id);
		String value3=reverse(value2);
		int doc_id = Integer.parseInt(encodedservice.decode(value3));
		System.err.println("doc_id-------   " + doc_id);
		
		System.err.println("file type-------   " + fileType);

		String strFileName = gService.getAckDocumentFileNameForDownload(doc_id);
		System.out.println("str file name in down loa=-==== " + strFileName);

		String dir = ftpProps.getTempupload();
		/* String fullPath = dir + doc_id + ".pdf"; */
		String fullPath = doc_id + ".pdf";
		System.err.println("full path in download-- " + fullPath);
		System.err.println("doc id in download-- " + doc_id);
		ServletOutputStream out = response.getOutputStream();
		response.setContentType(
				"application/" + strFileName.substring(strFileName.lastIndexOf(".") + 1, strFileName.length()));

		response.setHeader("Content-disposition", "attachment;filename=\"" + strFileName + "\"");

		boolean fileExist = ftpService.checkFileExist(fullPath);
		if (fileExist) {
			boolean success = ftpService.downloadFiles(fullPath, out);

		} else {
			System.out.println("File Does Not Exist");
		}
	}
	public static boolean validateFileExtention(String strFileExt) {
		if(!("JPEG".equalsIgnoreCase(strFileExt) || "JPG".equalsIgnoreCase(strFileExt)
				|| "PNG".equalsIgnoreCase(strFileExt) || "DOC".equalsIgnoreCase(strFileExt)
				|| "DOCX".equalsIgnoreCase(strFileExt) || "PDF".equalsIgnoreCase(strFileExt)
				|| "XLS".equalsIgnoreCase(strFileExt) || "XLSX".equalsIgnoreCase(strFileExt)
				|| "zip".equalsIgnoreCase(strFileExt) || "rar".equalsIgnoreCase(strFileExt))) {
			return false;
		}
		return true;
	}

	public static String validateFileContentType(String strFileExt, MultipartFile myFile) throws Exception {

		String err = null;
		String err1 = null;
		String err2 = null;
		Tika tika;
		String res="";
		try {
			if (strFileExt.equalsIgnoreCase("pdf")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
				System.out.println("filetype::"+filetype);
			//	logger2.info("Tika File Type -->>> " , filetype);
				res= cleanXSS(convertInputStreamToString(myFile.getInputStream()));
                String checkcontent = convertInputStreamToString(myFile.getInputStream());
				/*
				 * if (!checkcontent.contains("startxref")){ err2 ="File Tampered"; err="15";
				 * 
				 * }
				 */
				
				
				  boolean checkdta = PDFUtility2.isSafe(myFile.getInputStream()); 
				  if (checkdta== false)
				 { 
					  err1 ="File Tampered";
					 // err="17";
					 throw new IllegalStateException("Illegal Activity Not Allowed File Tampered");
				  }
				 
				
				
				if (!filetype.equals("application/pdf")) {
					err = "File Content Type [  " + filetype + " ] is not matching with File Ext :: " + strFileExt;
				}
			} else if (strFileExt.equalsIgnoreCase("jpeg") || strFileExt.equalsIgnoreCase("jpg")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
				//logger2.info("Tika File Type -->>> " , filetype);

				if (!filetype.equals("image/jpeg")) {
					err = "File Content Type [  " + filetype + " ] is not matching with File Ext :: " + strFileExt;
				}
			} else if (strFileExt.equalsIgnoreCase("png")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
			//	logger2.info("Tika File Type -->>> " , filetype);

				if (!filetype.equals("image/png")) {
					err = "File Content Type [  " + filetype + " ] is not matching with File Ext :: " + strFileExt;
				}
			} else if (strFileExt.equalsIgnoreCase("doc")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
			//	logger2.info("Tika File Type -->>> " , filetype);

				if (!filetype.equals("application/x-tika-msoffice")) {
					err = "File Content Type [  " + filetype + " ] is not matching with File Ext :: " + strFileExt;
				}
			} else if (strFileExt.equalsIgnoreCase("docx")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
			//	logger2.info("Tika File Type -->>> " , filetype);

				if (!filetype.equals("application/x-tika-ooxml")) {
					err = "File Content Type [  " + filetype + " ] is not matching with File Ext :: " + strFileExt;
				}
			} else if (strFileExt.equalsIgnoreCase("xls")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
		//		logger2.info("Tika File Type -->>> " , filetype);

				if (!filetype.equals("application/x-tika-msoffice")) {
					err = "File Content Type [  " + filetype + " ] is not matching with File Ext :: " + strFileExt;
				}
			} else if (strFileExt.equalsIgnoreCase("xlsx")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
			//	logger2.info("Tika File Type -->>> " , filetype);

				if (!filetype.equals("application/x-tika-ooxml")) {
					err = "File Content Type [  " + filetype + " ] is not matching with File Ext :: " + strFileExt;
				}
			} else if (strFileExt.equalsIgnoreCase("zip")) {
				tika = new Tika();

				// Detecting the file type using detect method
				String filetype = tika.detect(myFile.getInputStream());
		//		logger2.info("Tika File Type -->>> " , filetype);

				if (!filetype.equals("application/zip")) {
					err = "File Content Type [  " + filetype + " ] is Not Match With File Ext ::" + strFileExt;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		err= res;
		System.err.println("Return Value From Validate File Content From :"+err);
		return err;
	}

	private static String cleanXSS(String value) {
        String returnValue= "";
		Pattern scriptPattern = null;
		Matcher m = null;
    //  System.err.println("Content In a Uploaded File :"+value);
		scriptPattern = Pattern.compile("<.*>", Pattern.CASE_INSENSITIVE);
		m = scriptPattern.matcher(value);

		if (m.find()) {
			List<String> insecureWords = new ArrayList<String>();
		    insecureWords.add(".alert");
			insecureWords.add("<script>");
			insecureWords.add("</script>");
			insecureWords.add("href");
           
			for (String insecureWord : insecureWords) {
				if (value.toLowerCase().trim().contains(insecureWord)) {
					//throw new IllegalStateException("Illegal Activity Not Allowed 1222211111!!");
					returnValue= "12";
					return returnValue;
					 
				}
			}
		}
		scriptPatterns.forEach(pattern -> {
			Matcher matcher = pattern.matcher(value);

			if (matcher.find()) {
				//returnValue= "12";
				throw new IllegalStateException("Illegal Activity Not Allowed 11111111   !!");
				
			}
		});
		System.out.println("XSS Return Value: "+returnValue);
		return returnValue;
	}

	private static List<Pattern> scriptPatterns = new ArrayList<Pattern>();

	static {
		scriptPatterns.add(Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("</script>", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("<javascript>(.*?)</javascript>", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("</javascript>", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("/javascript>", Pattern.CASE_INSENSITIVE));
		scriptPatterns
				.add(Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(Pattern.compile("expression\\((.*?)\\)",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("Link/Rect", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE));
		scriptPatterns
				.add(Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onblur(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onClick(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(
				Pattern.compile("onmouseover(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(
				Pattern.compile("onmousedown(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onchange(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(
				Pattern.compile("ondblclick(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onfocus(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onkeydown(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onkeyup(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(
				Pattern.compile("onmouseout(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onmouseup(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(
				Pattern.compile("onmousemover(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns
				.add(Pattern.compile("onselect(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		scriptPatterns.add(Pattern.compile("<h1>(.*?)</h1>", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("</h1>", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("<h2>(.*?)</h2>", Pattern.CASE_INSENSITIVE));
		scriptPatterns.add(Pattern.compile("</h2>", Pattern.CASE_INSENSITIVE));
	}

	private static String convertInputStreamToString(InputStream is) throws IOException {

		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[5000];
		int length;

		while ((length = is.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		return result.toString("UTF-8");
	}
	
	
	public static int checkFileContainUrl(MultipartFile m) {
		int res=0;
		try (PDDocument document = PDDocument.load(new File(m.getOriginalFilename()))) {
	           List<PDAnnotation> annotations = document.getPage(0).getAnnotations();
	           for (PDAnnotation annotation : annotations) {
	               if (annotation instanceof PDAnnotationLink) {
	                  PDAnnotationLink link = (PDAnnotationLink) annotation;
	                  PDActionURI action = (PDActionURI) link.getAction();
	                    if (action != null) {
	                        URI uri = new URI(action.getURI());
	                        if (uri.getHost().contains(".com") || uri.getHost().contains(".in") || uri.getHost().contains(".net") || uri.getHost().contains(".io") || uri.getHost().contains(".global")) {
	                           // returnList.clear();
	                           //  returnList.add(19);
	                            res =19;
	                        }
	                    }
	                }
	            }
	        } catch (IOException | URISyntaxException e) {
	            e.printStackTrace();
	        }
		return res;
	}
	

}
