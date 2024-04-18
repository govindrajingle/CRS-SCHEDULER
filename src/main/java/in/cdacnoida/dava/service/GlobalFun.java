package in.cdacnoida.dava.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;

import in.cdacnoida.davaconfig.FtpDetailsProperties;


public class GlobalFun {
	
	
	@Autowired
	private static FtpDetailsProperties ftpProps;

	
	public static boolean ftpConnection(FTPClient ftpClient)
	{		
		boolean login = false; 
		//ResourceBundle bundle2 = ResourceBundle.getBundle("in.cdacnoida.serb.gl.misc.FTP_Server_details");
		/*
		 * String ftpServer = ResourceBundleFile.getValueFromKey("FTP_HOST_NAME");
		 * String ftpUser = ResourceBundleFile.getValueFromKey("FTP_USER_NAME"); String
		 * ftpPassword = ResourceBundleFile.getValueFromKey("FTP_PASSWORD");
		 */
		
		// Changes done by Deepshikha 
		System.err.println("ftpProps.getHostname()--------    "+ftpProps.getHostname());
		System.err.println("ftpProps.getUsername()--------    "+ftpProps.getUsername());
		System.err.println("ftpProps.getPassword()--------    "+ftpProps.getPassword());
		
		String ftpServer = ftpProps.getHostname();
		String ftpUser = ftpProps.getUsername();
		String ftpPassword = ftpProps.getPassword();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try 
		{  
			// pass directory path on server to connect  
			ftpClient.connect(ftpServer);  
		  
			// pass username and password, returned true if authentication is  
			// successful  
			login = ftpClient.login(ftpUser, ftpPassword);  
			int replyCode = ftpClient.getReplyCode();
			System.out.println("reply Code ="+replyCode);
			ftpClient.enterLocalPassiveMode();
		}
		catch (SocketException e) 
		{  
			 e.printStackTrace();  
		} 
		catch (IOException e) 
		{  
			e.printStackTrace();  
		} 
		return login;
	}
}
