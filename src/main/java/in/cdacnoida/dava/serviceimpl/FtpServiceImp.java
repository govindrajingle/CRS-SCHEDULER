package in.cdacnoida.dava.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import javax.servlet.ServletOutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.cdacnoida.dava.controllers.FtpService;
import in.cdacnoida.dava.service.GlobalFun;
import in.cdacnoida.davaconfig.FtpDetailsProperties;

@Service
public class FtpServiceImp implements FtpService {

	@Autowired
	private FtpDetailsProperties ftpProps;
	
	
	public boolean checkFileExist(String remoteFile)
	{
		FTPClient ftpClient = new FTPClient();    
		boolean success = false; 
		try 
		{  
			 
			boolean login = ftpConnection(ftpClient);  
		  
			if (login) 
			{  
			 
				
				InputStream inputStream = ftpClient.retrieveFileStream(remoteFile);
			    int returnCode = ftpClient.getReplyCode();
			    if (inputStream == null || returnCode == 550) 
			    {
			        System.out.println("File doesnot exist");
			    }
			    else
			    {
			    	success = true;
			    	inputStream.close();
			    }
			    boolean logout = ftpClient.logout();  
				if (logout) 
				{  
					System.out.println("Connection close...");  
				}  
			}
			else 
			{  				
				System.out.println("Connection fail...");  
			}  
		}
		catch (SocketException e) 
		{  
		   e.printStackTrace();  
		} 
		catch (IOException e) 
		{  
		   e.printStackTrace();  
		} 
		finally 
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
		return success;
	}
	
	/*
	 * Download Files from FTP Server
	 */
	public boolean downloadFiles(String remoteFile, ServletOutputStream out)
	{
		FTPClient ftpClient = new FTPClient();  
		FileOutputStream fos = null;  
		boolean success = false; 
		try 
		{  
			  
			boolean login =ftpConnection(ftpClient);  
		  
			if (login) 
			{  
				System.out.println("Connection established...");  
				
		    	ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			
				success = ftpClient.retrieveFile(remoteFile, out);
		    
				out.close();
				if (success) 
				{
					System.out.println("File #1 has been downloaded successfully.");
				}
			    
				// logout the user, returned true if logout successfully  
				boolean logout = ftpClient.logout();  
				if (logout) 
				{  
					System.out.println("Connection close...");  
				}  
			} 
			else 
			{  				
				System.out.println("Connection fail...");  
			}  
		  
		} 
		catch (SocketException e) 
		{  
		   e.printStackTrace();  
		} 
		catch (IOException e) 
		{  
		   e.printStackTrace();  
		} 
		finally 
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
		  
		  return success;
	}
	
	/*
	 * Function to upload file on FTP Server
	 */
	public boolean uploadFile(String path,InputStream inputStream,String directory)
	{
		 FTPClient ftpClient = new FTPClient();
		 boolean uploaded = false;
		 try 
		 {   
		String ftpRoot = ftpProps.getRoot();
		
			
			 boolean login = ftpConnection(ftpClient);
			// ResourceBundle bundle2 = ResourceBundle.getBundle("in.cdacnoida.serb.gl.misc.FTP_Server_details");
			//String ftpRoot =ResourceBundleFile.getValueFromKey("FTP_ROOT");
			// String ftpRoot = ftpProps.getPath();
			 
			 	
			 if (login) 
			 {  
				 ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				 //ftpClient.enterLocalPassiveMode();
				 System.out.println("Connection established...");  
				 System.out.println("File Path...."+path);
				 System.out.println("Directory Path...."+directory);
				 
				 
				
				 
				 //path=directory+path;
					
					
				 boolean success = makeDirectories(ftpClient,directory);
				 
				 System.out.println(ftpClient.getReplyString());
				 
				 if(success)
				 {
					 System.out.println("Directory Created");
				 }
				 else
				 {
					 System.out.println("Directory Not Created");
				 }
				 ftpClient.changeWorkingDirectory(ftpRoot);
				 //inputStream = new FileInputStream(mpf.getOriginalFilename());  
				
				 
				 uploaded = ftpClient.storeFile(path,inputStream);
				 System.out.println(ftpClient.getReplyString());
	
				 if (uploaded) 
				 {  
					 System.out.println("File uploaded successfully !");  					 
				 } 
				 else 
				 {  
					 System.out.println("Error in uploading file !");  
				 }  
	  
				 // logout the user, returned true if logout successfully  
				 boolean logout = ftpClient.logout();  
				 if (logout) 
				 {  
					 System.out.println("Connection close...");  
				 }  
			 } 
			 else 
			 {  
				 System.out.println("Connection fail...");  
			 }  
	  
		 } 
		 catch (SocketException e) 
		 {  
			 e.printStackTrace();  
		 } 
		 catch (IOException e) 
		 {  
			 e.printStackTrace();  
		 } 
		 finally 
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
		 
		 return uploaded;

	}
	
//added by harshita
	public boolean addressProofFile(String path,InputStream inputStream,String directory)
	{
		 FTPClient ftpClient = new FTPClient();
		 boolean uploaded = false;
		 try 
		 {   
		String ftpRoot = ftpProps.getRoot();
		
			
			 boolean login = ftpConnection(ftpClient);
			// ResourceBundle bundle2 = ResourceBundle.getBundle("in.cdacnoida.serb.gl.misc.FTP_Server_details");
			//String ftpRoot =ResourceBundleFile.getValueFromKey("FTP_ROOT");
			// String ftpRoot = ftpProps.getPath();
			 
			 	
			 if (login) 
			 {  
				 ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				 //ftpClient.enterLocalPassiveMode();
				 System.out.println("Connection established...");  
				 System.out.println("File Path...."+path);
				 System.out.println("Directory Path...."+directory);
				 
				 
				
				 
				 //path=directory+path;
					
					
				 boolean success = makeDirectories(ftpClient,directory);
				 
				 System.out.println(ftpClient.getReplyString());
				 
				 if(success)
				 {
					 System.out.println("Directory Created");
				 }
				 else
				 {
					 System.out.println("Directory Not Created");
				 }
				 ftpClient.changeWorkingDirectory(ftpRoot);
				 //inputStream = new FileInputStream(mpf.getOriginalFilename());  
				
				 
				 uploaded = ftpClient.storeFile(path,inputStream);
				 System.out.println(ftpClient.getReplyString());
	
				 if (uploaded) 
				 {  
					 System.out.println("File uploaded successfully !");  					 
				 } 
				 else 
				 {  
					 System.out.println("Error in uploading file !");  
				 }  
	  
				 // logout the user, returned true if logout successfully  
				 boolean logout = ftpClient.logout();  
				 if (logout) 
				 {  
					 System.out.println("Connection close...");  
				 }  
			 } 
			 else 
			 {  
				 System.out.println("Connection fail...");  
			 }  
	  
		 } 
		 catch (SocketException e) 
		 {  
			 e.printStackTrace();  
		 } 
		 catch (IOException e) 
		 {  
			 e.printStackTrace();  
		 } 
		 finally 
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
		 
		 return uploaded;

	}
	
	public boolean drugLicence(String path,InputStream inputStream,String directory)
	{
		 FTPClient ftpClient = new FTPClient();
		 boolean uploaded = false;
		 try 
		 {   
		String ftpRoot = ftpProps.getRoot();
		
			
			 boolean login = ftpConnection(ftpClient);
			// ResourceBundle bundle2 = ResourceBundle.getBundle("in.cdacnoida.serb.gl.misc.FTP_Server_details");
			//String ftpRoot =ResourceBundleFile.getValueFromKey("FTP_ROOT");
			// String ftpRoot = ftpProps.getPath();
			 
			 	
			 if (login) 
			 {  
				 ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				 //ftpClient.enterLocalPassiveMode();
				 System.out.println("Connection established...");  
				 System.out.println("File Path...."+path);
				 System.out.println("Directory Path...."+directory);
				 
				 
				
				 
				 //path=directory+path;
					
					
				 boolean success = makeDirectories(ftpClient,directory);
				 
				 System.out.println(ftpClient.getReplyString());
				 
				 if(success)
				 {
					 System.out.println("Directory Created");
				 }
				 else
				 {
					 System.out.println("Directory Not Created");
				 }
				 ftpClient.changeWorkingDirectory(ftpRoot);
				 //inputStream = new FileInputStream(mpf.getOriginalFilename());  
				
				 
				 uploaded = ftpClient.storeFile(path,inputStream);
				 System.out.println(ftpClient.getReplyString());
	
				 if (uploaded) 
				 {  
					 System.out.println("File uploaded successfully !");  					 
				 } 
				 else 
				 {  
					 System.out.println("Error in uploading file !");  
				 }  
	  
				 // logout the user, returned true if logout successfully  
				 boolean logout = ftpClient.logout();  
				 if (logout) 
				 {  
					 System.out.println("Connection close...");  
				 }  
			 } 
			 else 
			 {  
				 System.out.println("Connection fail...");  
			 }  
	  
		 } 
		 catch (SocketException e) 
		 {  
			 e.printStackTrace();  
		 } 
		 catch (IOException e) 
		 {  
			 e.printStackTrace();  
		 } 
		 finally 
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
		 
		 return uploaded;

	}
		
	
	public boolean ftpConnection(FTPClient ftpClient)
	{		
		boolean login = false; 
		//ResourceBundle bundle2 = ResourceBundle.getBundle("in.cdacnoida.serb.gl.misc.FTP_Server_details");
		//String ftpServer = ResourceBundleFile.getValueFromKey("FTP_HOST_NAME");
		//String ftpUser = ResourceBundleFile.getValueFromKey("FTP_USER_NAME");
		//String ftpPassword = ResourceBundleFile.getValueFromKey("FTP_PASSWORD");
		System.out.println(ftpClient);
		// Changes done by Deepshikha 
		String ftpServer = ftpProps.getHostname();
		String ftpUser = ftpProps.getUsername();
		String ftpPassword = ftpProps.getPassword();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try 
		{  
			// pass directory path on server to connect  
			ftpClient.connect(ftpServer);  
		  
			// pass username and password, returned true if authentication is successful  
			login = ftpClient.login(ftpUser, ftpPassword);  
			int replyCode = ftpClient.getReplyCode();
			ftpClient.enterLocalPassiveMode();
		}
		catch (Exception e) 
		{  
			 e.printStackTrace();  
		} 
		/*
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		return login;
	}
	
	/*
	 * Creating new directories on ftpserver
	 */
	public boolean makeDirectories(FTPClient ftpClient, String dirPath)throws IOException 
	{
		
		String[] pathElements = dirPath.split("/");
		String dir="";
		if (pathElements != null && pathElements.length > 0) 
		{
			for (String singleDir : pathElements) 
			{
				//if(!singleDir.equals(""))
					dir = singleDir;
				
				if(singleDir.equals(""))
					continue;
				//ftpClient.sendSiteCommand("chmod " + "755 " + dir);
				boolean existed = ftpClient.changeWorkingDirectory(dir);
				System.out.println(dir + ":"+existed);
				if (!existed) 
				{
					boolean created = ftpClient.makeDirectory(dir);
					if (created) 
					{
						System.out.println("CREATED directory: " + dir);
						ftpClient.changeWorkingDirectory(dir);
					} 
					else 
					{
						System.out.println("COULD NOT create directory: " + dir);
						return false;
					}
				}
			}
		}
		return true;
	}
	

	/*
	 * Move Files from one location to other
	 */
	public boolean moveFiles(String currentFileName,String finalName,String finalPath)
	{
		FTPClient ftpClient = new FTPClient();    
		boolean success = false; 
		try 
		{  
			boolean login = GlobalFun.ftpConnection(ftpClient);	
			/*ResourceBundle bundle2 = ResourceBundle.getBundle("in.cdacnoida.serb.gl.misc.FTP_Server_details");*/
			//String ftpRoot = ResourceBundleFile.getValueFromKey("FTP_ROOT");// bundle2.getString("FTP_ROOT");
			
			String ftpRoot = ftpProps.getPath();
			if (login) 
			{  
				System.out.println("Connection established...");  
				
			    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			    
			    makeDirectories(ftpClient, finalPath);
			    
			    ftpClient.changeWorkingDirectory(ftpRoot);
				
			    success=ftpClient.rename(currentFileName, finalName);
			    
			    if(success)
			    { 
			    	System.out.println("File Copied successfully");
			    }
			    else
			    	System.out.println("File not Copied successfully");
			    
			    boolean logout = ftpClient.logout();  
				 if (logout) 
				 {  
					 System.out.println("Connection close...");  
				 }  
			}
			else 
			{  
				System.out.println("Connection fail...");  
			}			
		}
		catch (SocketException e) 
		{  
			 e.printStackTrace();  
		} 
		catch (IOException e) 
		{  
			e.printStackTrace();  
		} 
		finally 
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
		return success;
	}
	
	
	/*
	 * returns a list of files
	 */
	public FTPFile[] getFilesInFolder(String sourceLocation)
	{
		FTPClient ftpClient = new FTPClient();
	    ArrayList<String> list = new ArrayList<String>();
	    FTPFile[] files1 = null;
		try 
		{  
            boolean success = GlobalFun.ftpConnection(ftpClient);
            
 
            if (!success) {
                System.out.println("Could not login to the server");
                
            }
            files1 = ftpClient.listFiles(sourceLocation);
            
		}
		catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        } finally {
            // logs out and disconnects from server
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		return files1;
	}

	public InputStream getFiles(String remoteFile)
	{
		FTPClient ftpClient = new FTPClient();  
		boolean success = false; 
		InputStream is = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		try 
		{  
			  
			boolean login = ftpConnection(ftpClient);			  
			if (login) 
			{  
				System.out.println("Connection established...");  
				System.out.println("File Name::::::"+remoteFile);
		    	ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			
				success = ftpClient.retrieveFile(remoteFile, outputStream);
				
				if(success)
				{		    
					System.out.println("File Retrieved");
					is = new ByteArrayInputStream(outputStream.toByteArray());					
				}
				else
					System.out.println("File Not Retrieved");
				
				outputStream.close();
				
			    
				// logout the user, returned true if logout successfully  
				boolean logout = ftpClient.logout();  
				if (logout) 
				{  
					System.out.println("Connection close...");  
				}  
			} 
			else 
			{  				
				System.out.println("Connection fail...");  
			}  
		  
		} 
		catch (SocketException e) 
		{  
		   e.printStackTrace();  
		} 
		catch (IOException e) 
		{  
		   e.printStackTrace();  
		} 
		finally 
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
		  
		  return is;
	}
	
	// Added by Deepshikha for post Submission change
		public boolean deleteFile(String currentFilePath) {			
			FTPClient ftpClient = new FTPClient();
			boolean deleted = false;
			

			 try 
			 {  
				 boolean login = ftpConnection(ftpClient);  
				 System.err.println("in ftp login--- "+login);
				 if (login) 
				 {  
					 System.err.println("in side ftp if condition");
					 if (checkFileExist(currentFilePath)) 
					 {			System.err.println("currentFilePath===== "+currentFilePath);		 
						 deleted = ftpClient.deleteFile(currentFilePath);
						 if (deleted) 
						 {
							 System.out.println("The file was deleted successfully.");
						 } 
						 else 
						 {
							 System.out.println("Could not delete the file.");
						 }
					 }
					 else
						 System.out.println("File Does not exist");
					 
					 boolean logout = ftpClient.logout();  
					 if (logout) 
					 {  
						 System.out.println("Connection close...");  
					 }  
				 }
				 else 
				 {  
					 System.out.println("Connection fail...");  
				 }  

			 } 
			 catch (SocketException e) 
			 {  
				 e.printStackTrace();  
			 } 
			 catch (IOException e) 
			 {  
				 e.printStackTrace();  
			 } 
			 finally 
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
			 return deleted;
		}

		@Override
		public OutputStream getFilesimage(String remoteFile) {
			FTPClient ftpClient = new FTPClient();  
			boolean success = false; 
			OutputStream is = null;
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try 
			{  
				  
				boolean login = ftpConnection(ftpClient);			  
				if (login) 
				{  
					System.out.println("Connection established...");  
					System.out.println("File Name::::::"+remoteFile);
			    	ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				
					success = ftpClient.retrieveFile(remoteFile, outputStream);
					
					if(success)
					{		    
						System.out.println("File Retrieved");
						is =outputStream;				
					}
					else
						System.out.println("File Not Retrieved");
					
					outputStream.close();
					
				    
					// logout the user, returned true if logout successfully  
					boolean logout = ftpClient.logout();  
					if (logout) 
					{  
						System.out.println("Connection close...");  
					}  
				} 
				else 
				{  				
					System.out.println("Connection fail...");  
				}  
			  
			} 
			catch (SocketException e) 
			{  
			   e.printStackTrace();  
			} 
			catch (IOException e) 
			{  
			   e.printStackTrace();  
			} 
			finally 
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
			  
			  return is;

		}
	
}
