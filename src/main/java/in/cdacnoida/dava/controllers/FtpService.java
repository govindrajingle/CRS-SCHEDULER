package in.cdacnoida.dava.controllers;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

import org.apache.commons.net.ftp.FTPFile;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface FtpService {
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean checkFileExist(String remoteFile);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean downloadFiles(String remoteFile, ServletOutputStream out);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean uploadFile(String path,InputStream inputStream,String directory);

	//added by harshita
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addressProofFile(String path,InputStream inputStream,String directory);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean drugLicence(String path,InputStream inputStream,String directory);
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean moveFiles(String currentFileName,String finalName,String finalPath);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public FTPFile[] getFilesInFolder(String sourceLocation);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public InputStream getFiles(String remoteFile);
	
	@Transactional(propagation=Propagation.REQUIRED)
	public OutputStream getFilesimage(String remoteFile);

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteFile(String docPath);

}
