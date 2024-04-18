package in.cdacnoida.dava.util;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletOutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import in.cdacnoida.davaconfig.FtpDetailsProperties;

@Component
public class FtpConnection {

	@Autowired
	private FtpDetailsProperties ftpProps;
	
	
	
	public boolean fileUplaodonFtp(InputStream inputStream,String fileName) {
		boolean result=false;
		String path=ftpProps.getPath();
		String directory=ftpProps.getDirectory();
		path=path+fileName;
		FTPClient ftpClient=new FTPClient();
		String[] dir=fileName.split("_");
		directory=directory+"//"+dir[0];
		try {
			boolean login =ftpConnection(ftpClient);
			String ftpRoot = ftpProps.getRoot();
			if(login) {
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
					boolean success = makeDirectories(ftpClient,directory);
					ftpClient.changeWorkingDirectory(ftpRoot);
				//FileInputStream inputStream=new FileInputStream(inputStream);
				
				try {
					result = ftpClient.storeFile(fileName,inputStream);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				 if (result) 
				 {  
					 System.out.println("File uploaded successfully !");
					 ftpClient.logout();
				 } 
				 else 
				 {  
					 System.out.println("Error in uploading file !");  
					 ftpClient.logout();
				 }  
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	
	public boolean ftpConnection(FTPClient ftpClient) {
		boolean login = false; 
		String ftpServer=ftpProps.getHostname();
		String ftpUser =ftpProps.getUsername();
		String ftpPassword =ftpProps.getPassword();
		try {
			// pass directory path on server to connec
			ftpClient.connect(ftpServer);
			//pass username and password, returned true if authentication is  successful  
			login = ftpClient.login(ftpUser, ftpPassword);  
			ftpClient.enterLocalPassiveMode();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;
	}
	
	
	public boolean makeDirectories(FTPClient ftpClient, String directory) throws IOException {
		String[] pathElements = directory.split("/");
		String dir="";
		if (pathElements != null && pathElements.length > 0) {
			for (String singleDir : pathElements) {
				dir = singleDir;
				if(singleDir.equals(""))
					continue;
				ftpClient.sendSiteCommand("chmod " + "755 " + dir);
				boolean existed = ftpClient.changeWorkingDirectory(dir);
				System.out.println(dir + ":"+existed);
				if (!existed) {
					boolean created = ftpClient.makeDirectory(dir);
					if (created) 
					{
						System.out.println("CREATED directory: " + dir);
						ftpClient.changeWorkingDirectory(dir);

					}else {
						System.out.println("COULD NOT create directory: " + dir);
						return false;
					}

				}

			}

		}
		return true;
	}


	public boolean findFile(Long userId,String pathOne) {
		boolean fileCheck=false;
		boolean result=false;
		String path=ftpProps.getPath();
		String directory=ftpProps.getDirectory();
		FTPClient ftpClient=new FTPClient();
		directory=directory+"//"+pathOne;
		String realPath=path+pathOne+"//"+pathOne+"_"+userId+".jpg";
		try {
			boolean login =ftpConnection(ftpClient);
			if(login) {
				InputStream inputStream = ftpClient.retrieveFileStream(realPath);
				int returnCode = ftpClient.getReplyCode();
				 if (inputStream == null || returnCode == 550) 
				    {
				        System.out.println("File doesnot exist");
				    }
				    else
				    {
				    	fileCheck = true;
				    	inputStream.close();
				    }
				   boolean logout = ftpClient.logout();  
				   if (logout) 
					{  
						System.out.println("Connection close...");  
					}  
			}else {
				System.out.println("Connection fail..."); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally 
		{  
			try 
			{  
				ftpClient.disconnect();  
			} 
			catch (IOException e) 
			{  
				e.printStackTrace();  
			}  
		}

		return fileCheck;
	}


	public void returnImage(String fileName, ServletOutputStream out) {
		String path=ftpProps.getPath();
		String directory=ftpProps.getDirectory();
		FTPClient ftpClient=new FTPClient();
		directory=directory+"//"+"image";
		String realPath=path+"image"+"//"+fileName;
		InputStream inputStream=null;
		boolean success=false;
		try {
			boolean login =ftpConnection(ftpClient);
			if(login) {	
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				inputStream= ftpClient.retrieveFileStream(realPath);
				int returnCode = ftpClient.getReplyCode();
				 if (inputStream == null || returnCode == 550) 
				    {
				        System.out.println("File doesnot exist");
				    }else {
				    	success = ftpClient.retrieveFile(realPath, out);
				    	out.close();
				    	if (success) 
						{
							System.out.println("File #1 has been downloaded successfully.");
						}
				    }
				   
				   boolean logout = ftpClient.logout();  
				   if (logout) 
					{  
						System.out.println("Connection close...");  
					}  
			}else {
				System.out.println("Connection fail..."); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
