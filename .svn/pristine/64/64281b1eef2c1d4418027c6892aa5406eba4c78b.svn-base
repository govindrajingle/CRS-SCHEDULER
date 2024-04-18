package in.cdacnoida.dava.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.controllers.FtpService;
import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.DocumentMasterDomain;
import in.cdacnoida.dava.service.GlobalService;
import in.cdacnoida.davaconfig.FtpDetailsProperties;

@Service
public class GlobalServiceImp implements GlobalService {

	@Autowired
	private DavaDaoServices davaDaoServices;
	 
	@Autowired
	public FtpService ftpService;
	
	@Autowired
	private FtpDetailsProperties ftpProps;
	
	 

	/*
	 * public List<StateMasterForm> getManufState() { List<StateMasterForm>
	 * stateList = new ArrayList();
	 * 
	 * List<StateMaster> stlist = gDao.getStates(); System.err.println("stlist" +
	 * stlist.size()); for (int i = 0; i < stlist.size(); i++) { StateMasterForm smf
	 * = new StateMasterForm(); smf.setNumStateId(stlist.get(i).getNumStateId());
	 * smf.setStrStateName(stlist.get(i).getStrStateName().toLowerCase());
	 * stateList.add(smf); } System.err.println("stateList--" + stateList);
	 * 
	 * return stateList; }
	 */
	/*
	 * public List<UserIdProofTypeForm> getManufUserIdProofType() {
	 * List<UserIdProofTypeForm> userList = new ArrayList();
	 * 
	 * List<UserIdProofType> utd = gDao.getIdProof();
	 * 
	 * for (int i = 0; i < utd.size(); i++) { UserIdProofTypeForm ut = new
	 * UserIdProofTypeForm();
	 * ut.setNumIdProffTypeId(utd.get(i).getNumIdProffTypeId());
	 * ut.setStrIdProffTypeName(utd.get(i).getStrIdProffTypeName());
	 * userList.add(ut); } return userList; }
	 * 
	 * public List<ManufConstitutionMasterForm> getManufConstitution() {
	 * List<ManufConstitutionMasterForm> stateList = new
	 * ArrayList<ManufConstitutionMasterForm>();
	 * 
	 * List<ConstitutionMaster> stlist = gDao.getConstitution();
	 * 
	 * for (int i = 0; i < stlist.size(); i++) { ManufConstitutionMasterForm smf =
	 * new ManufConstitutionMasterForm();
	 * smf.setNumConsId(stlist.get(i).getNumConsId());
	 * smf.setStrConsName(stlist.get(i).getStrConsName()); stateList.add(smf); }
	 * return stateList; }
	 * 
	 * public List<DistrictMasterDomain> ViewDistrictListByState(int stateID) {
	 * System.out.println("In Service"); return
	 * gDao.LoadDistrictListByState(stateID); }
	 */

	public String getDocumentFileNameForDownload(int doc_id) {
		
		  String FileName; FileName = davaDaoServices.getDocumentFileNameForDownloadQuery(doc_id);
		  return FileName;
		}

	public int addDocument(String fileName, int doc_size, String remarks, String status, int UserId) {
		
		  DocumentMasterDomain docMst = new DocumentMasterDomain();
		  docMst.setNumDocSize(doc_size); docMst.setNumFileSlno(1);
		  docMst.setStrFilename(fileName); docMst.setNumIsValid(1);
		  docMst.setNumTrUserId(UserId); docMst.setStrRmarks(remarks);
		  docMst.setStrStatus(status); docMst.setDtTrDate(new Date());
		  //docMst.setNumSignFlag(0); added by govind to check for scheduling the unchecked files
		  try { 
			  int doc_id  = davaDaoServices.addDocument(docMst);
			  return doc_id; 
			  } 
		  catch (Exception e) 
		  { 
			  return 0;
		  }
		 
		}

	/**
	 * This is the service which calls GlobalDao class method to the document size
	 * in document_mst table based on doc_id.
	 * 
	 * @param doc_id, doc_size.
	 */
	public void updateDocumentSize(int doc_id, int doc_size) {
		
		davaDaoServices.updateDocumentSizeQuery(doc_id, doc_size);
		 }

	/*
	 * public List<TileDomain> getTile(int numRoleId, int instId, int userId) { //
	 * TODO Auto-generated method stub List<TileDomain> getTile =
	 * gDao.getTile(numRoleId, instId, userId); return getTile; }
	 */

	public void renameDocument(int doc_id, String fileName) {
		/*
		 * 
		 * gDao.renameDocumentQuery(doc_id, fileName);
		 */}

	public String pathForDocuments(int formId, int formNo, int userId, String purpose, int stateID) {
		/*
		 * String fullPath = ""; // To check condition Regarding Registration if (formId
		 * == 0 && formNo == 0) { fullPath = globalPath + stateID + "/public/";
		 * 
		 * if (purpose.equals("TEMPUPLOAD")) { String folderName =
		 * ResourceBundleFile.getValueFromKey(purpose); fullPath = folderName; } else {
		 * String folderName = ResourceBundleFile.getValueFromKey(purpose); if (userId
		 * == 0) { fullPath = globalPath + folderName; } else { fullPath = globalPath +
		 * folderName + userId + "/"; } System.out.println("Full Path in if is - " +
		 * fullPath); }
		 * 
		 * } else { // This will for transactional forms
		 * 
		 * fullPath = globalPath + stateID + "/" + formNo + "/" + getYear() + "/" +
		 * userId + "/" + formId + "/"; System.out.println("Full Path is - " +
		 * fullPath);
		 * 
		 * } if (purpose.equals("MEETING")) { String folderName =
		 * ResourceBundleFile.getValueFromKey(purpose); fullPath = globalPath +
		 * folderName + userId + "/"; } return fullPath;
		 */
		return null;}

	public int getYear() {

		DateFormat df = new SimpleDateFormat("dd/MMMM/yyyy");
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

	/*
	 * public List<SeatMaster> viewRoles(int userId) { return gDao.viewRole(userId);
	 * }
	 * 
	 * public SeatMaster getSeatDetail(int strSeatName, int seatId) {
	 * 
	 * return gDao.getSeatDetail(strSeatName, seatId); }
	 */

	public void generatePdf(HttpServletRequest request, HttpServletResponse response, ArrayList<String> list) {
		/*
		 * String jrxmlpath = ResourceBundleFile.getValueFromKey("JRXML_PATH"); String
		 * pdfpath = ResourceBundleFile.getValueFromKey("JRXML_PDF_PATH");
		 * 
		 * Map parameters = new HashMap(); InputStream imgInputStream = null; String
		 * formid = list.get(0);
		 * 
		 * String formno = list.get(1);
		 * 
		 * String inputFileName = list.get(2);
		 * 
		 * String strOutputFileName = list.get(3); // String stateId=list.get(4);
		 * 
		 * String realContextPath = "";
		 * 
		 * String strJasperPath = jrxmlpath;
		 * 
		 * parameters.put("formId", formid); parameters.put("formNo", formno);
		 * 
		 * strJasperPath = strJasperPath + File.separator + inputFileName + ".jasper";
		 * System.out.println("Final Jasper Path = " + strJasperPath);
		 * 
		 * System.out.println("Final Output File Path = " + pdfpath);
		 * System.out.println("Final Output File Name = " + strOutputFileName); try {
		 * 
		 * generatePdf(strJasperPath, parameters, pdfpath + File.separator +
		 * strOutputFileName); response.setContentType("application/" +
		 * strOutputFileName.substring(strOutputFileName.lastIndexOf(".") + 1,
		 * strOutputFileName.length()));
		 * 
		 * response.setHeader("Content-disposition", "attachment;filename=\"" +
		 * strOutputFileName);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } File fileFound = new
		 * File(pdfpath + File.separator + strOutputFileName); FileInputStream
		 * fileinputstream = null; ByteArrayOutputStream bytearrayoutputstream = null;
		 * ServletOutputStream out = null; try { out = response.getOutputStream();
		 * fileinputstream = new FileInputStream(fileFound); bytearrayoutputstream = new
		 * ByteArrayOutputStream(); byte abyte0[] = new byte[0x500000]; do { int i =
		 * fileinputstream.read(abyte0); if (i != -1) {
		 * bytearrayoutputstream.write(abyte0, 0, i); bytearrayoutputstream.close(); }
		 * else { byte abyte1[] = bytearrayoutputstream.toByteArray();
		 * response.setContentLength(abyte1.length); out.write(abyte1, 0,
		 * abyte1.length); out.flush(); out.close(); bytearrayoutputstream.close();
		 * return; } } while (true);
		 * 
		 * } catch (Exception e) {
		 * System.out.println("inside Exception of writing file in response");
		 * e.printStackTrace(); } finally { if (fileFound.exists()) fileFound.delete();
		 * try { fileinputstream.close(); out.close(); } catch (Exception ex) {
		 * ex.printStackTrace(); } }
		 */}

	@SuppressWarnings("finally")
	public String generatePdf(String strJasperPath, Map parameters, String strOutputFilePath) throws Exception {
		/*
		 * ConnectionManager cm = new ConnectionManager(); Connection _conn =
		 * cm.getConnection(); String strStatus = ""; try { JRFileVirtualizer
		 * fileVirtualizer = new JRFileVirtualizer(50,
		 * ResourceBundleFile.getValueFromKey("JRXML_PDF_PATH"));
		 * parameters.put(JRParameter.REPORT_VIRTUALIZER, fileVirtualizer); JasperPrint
		 * printFileName = JasperFillManager.fillReport(strJasperPath, parameters,
		 * _conn); JasperExportManager.exportReportToPdfFile(printFileName,
		 * strOutputFilePath); strStatus = "File Created Successfully"; } catch
		 * (Exception e) { System.out.println("Inside Exception"); e.printStackTrace();
		 * strStatus = "Error in creating "; } finally {
		 * 
		 * if (!_conn.isClosed()) _conn.close();
		 * 
		 * System.out.println("Final Status=" + strStatus); return strStatus; }
		 */
		return null;}

	public String getDocumentFileName(int doc_id) {
		/*
		 * String FileName; FileName = gDao.getDocumentFileNameQuery(doc_id); return
		 * FileName;
		 */
		return null;}

	// Added By Deepshikha
	public void movefile(String path, ArrayList<Integer> list) {
		System.out.println("inside file moved");
		String tempPath = ftpProps.getTempupload();
		String currentFile = tempPath;
		String destination = path;
		try {

			FTPFile[] files = ftpService.getFilesInFolder(tempPath);
			for (FTPFile file : files) {
				destination = path;
				currentFile = tempPath;
				for (int i = 0; i < list.size(); i++) {
					if (file.getName().equals(list.get(i) + ".pdf")) {
						currentFile += list.get(i) + ".pdf";
						destination += list.get(i) + ".pdf";
						boolean success = ftpService.moveFiles(currentFile, destination, path);
						if (!success) {
							System.out.println("The File not moved successfully");

						}
						System.out.println("Flag og the file movement" + success);
						renameDocument(list.get(i), destination);

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 * public void copyFileFtpToApplicationServerForDigitalVarification(int docId) {
	 * String remoteFile = tempPath + docId + ".pdf";
	 * 
	 * // Code To copy FTP file in the local server InputStream inputStream = null;
	 * OutputStream outputStream = null; try { // read this file into InputStream
	 * inputStream = ftpService.getFiles(remoteFile); // write the inputStream to a
	 * FileOutputStream File f = new File(fileForSWFCreation); f.mkdirs(); f = new
	 * File(fileForSWFCreation + docId + ".pdf"); // String newFileName =
	 * fileForSWFCreation +docId +".pdf"; outputStream = new FileOutputStream(f);
	 * int read = 0; byte[] bytes = new byte[1024]; while ((read =
	 * inputStream.read(bytes)) != -1) { outputStream.write(bytes, 0, read); }
	 * System.out.println("Done! File has been copied "); } catch (Exception e) { //
	 * TODO: handle exception e.printStackTrace();
	 * System.out.println("Not Done! File has not been copied "); }
	 * 
	 * }
	 * 
	 */

	public String pathForDocuments(int formId, int formNo, int userId, String purpose) {
		/*
		 * String fullPath = ""; // To check condition Regarding Registration if (formId
		 * == 0 && formNo == 0) { if (purpose.equals("TEMPUPLOAD")) { String folderName
		 * = ResourceBundleFile.getValueFromKey(purpose); fullPath = folderName; } else
		 * { String folderName = ResourceBundleFile.getValueFromKey(purpose); if (userId
		 * == 0) { fullPath = globalPath + folderName; } else { fullPath = globalPath +
		 * folderName + userId + "/"; } System.out.println("Full Path in if is - " +
		 * fullPath); } } else { int year = Calendar.getInstance().get(Calendar.YEAR);
		 * fullPath = globalPath + formNo + "/" + year + "/" + userId + "/" + formId +
		 * "/"; System.out.println("Full Path is - " + fullPath);
		 * 
		 * } return fullPath;
		 */
		return null;}

	@Override
	public void updateDocumentMstPath(String newpath, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDocumentFileNameQuery(int doc_id) {
		
		return davaDaoServices.getDocumentFileNameQuery(doc_id);
	}

	@Override
	public String getAckDocumentFileNameForDownload(int doc_id) {
		String FileName; FileName = davaDaoServices.getAckDocumentFileNameForDownload(doc_id);
		  return FileName;
	}



}
