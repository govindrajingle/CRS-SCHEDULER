package in.cdacnoida.dava.model;


public class FileUploadFlag {
    
	String fileName;
	
	int successFlag;
	
	int fileSize;
	
	String eNSuccessFlag;
	String errorMsg;
	
	
	public String geteNSuccessFlag() {
		return eNSuccessFlag;
	}
	public void seteNSuccessFlag(String eNSuccessFlag) {
		this.eNSuccessFlag = eNSuccessFlag;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getSuccessFlag() {
		return successFlag;
	}
	public void setSuccessFlag(int successFlag) {
		this.successFlag = successFlag;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	
}