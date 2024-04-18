package in.cdacnoida.dava.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface GlobalService {
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public String getDocumentFileNameForDownload(int doc_id);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int addDocument(String fileName, int doc_size, String remarks, String status, int UserId);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateDocumentSize(int doc_id, int doc_size);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void renameDocument(int doc_id, String fileName);
	
	@Transactional(propagation=Propagation.REQUIRED)
	//public String pathForDocuments(int formId, int formNo, int userId, String purpose);
	public String pathForDocuments(int formId, int formNo, int userId, String purpose,int stateID);
		
	 @Transactional(propagation=Propagation.REQUIRED)
	 public void generatePdf(HttpServletRequest request, HttpServletResponse response, ArrayList<String> list);
	 
	 @Transactional(propagation=Propagation.REQUIRED)
	 public String getDocumentFileName(int doc_id);

	 @Transactional(propagation=Propagation.REQUIRED)
	 public void movefile(String path, ArrayList<Integer> list);
	 
	 @Transactional(propagation=Propagation.REQUIRED)
	public void updateDocumentMstPath(String newpath, ArrayList<Integer> list);
	 @Transactional(propagation=Propagation.REQUIRED)
	public String getDocumentFileNameQuery(int doc_id);

	 @Transactional(propagation=Propagation.REQUIRED)
	public String getAckDocumentFileNameForDownload(int doc_id);

		
}
