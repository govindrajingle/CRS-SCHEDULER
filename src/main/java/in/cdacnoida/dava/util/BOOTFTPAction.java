package in.cdacnoida.dava.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BOOTFTPAction {

	private BOOTAccessPaths bOOTAccessPaths;

	@Autowired
	public BOOTFTPAction(BOOTAccessPaths bOOTAccessPaths) {
		this.bOOTAccessPaths = bOOTAccessPaths;
	}

	public boolean ftpConnection(final FTPClient ftpClient) {
		boolean result = false;
		final String ftpServer = bOOTAccessPaths.getFTP_HOST();
		final String ftpUser = bOOTAccessPaths.getFTP_USER();
		final String ftpPassword = bOOTAccessPaths.getFTP_PWD();
		final String ftpDir = bOOTAccessPaths.getFTP_DIR();
		try {
			ftpClient.connect(ftpServer);
			result = ftpClient.login(ftpUser, ftpPassword);
			final int replyCode = ftpClient.getReplyCode();
			System.out.println("reply Code =" + replyCode);
			ftpClient.enterLocalPassiveMode();
			if (result) {
				System.out.println("Successfully logged in!");
				System.out.println("current working directory  " + ftpClient.printWorkingDirectory());
			} else {
				System.out.println("Login Fail!");
				result = false;
			}
			final String newDir = ftpDir;
			result = ftpClient.changeWorkingDirectory(newDir);
			if (result) {
				System.out.println(
						"Working directory is changed.Your New working directory:" + ftpClient.printWorkingDirectory());
			} else {
				System.out.println("Unable to change");
				result = false;
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return result;
	}
	
	public OutputStream createFile(final String fileName) {
		final FTPClient ftpClient = new FTPClient();
		OutputStream outputStream = null;
		try {
			final boolean login = ftpConnection(ftpClient);
			final String ftpRoot = bOOTAccessPaths.getFTP_DIR();
			if (login) {
				ftpClient.setFileType(2);
				System.out.println("Connection established inside createFiles...");
				System.out.println("File Path...." + fileName);
				final boolean success = this.makeDirectories(ftpClient,
						fileName.substring(0, fileName.lastIndexOf("/")));
				System.out.println(ftpClient.getReplyString());
				if (success) {
					System.out.println("Directory Created");
				} else {
					System.out.println("Directory Not Created");
				}
				ftpClient.changeWorkingDirectory(ftpRoot);
				outputStream = ftpClient.storeFileStream(fileName);
				System.out.println(ftpClient.getReplyString());
			} else {
				System.out.println("Connection fail...");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return outputStream;
	}
	
	public boolean makeDirectories(final FTPClient ftpClient, final String dirPath) throws IOException {
		final String[] pathElements = dirPath.split("/");
		String dir = "";
		if (pathElements != null && pathElements.length > 0) {
			final String[] arr$ = pathElements;
			for (int len$ = arr$.length, i$ = 0; i$ < len$; ++i$) {
				final String singleDir = dir = arr$[i$];
				if (!singleDir.equals("")) {
					ftpClient.sendSiteCommand("chmod 755 " + dir);
					final boolean existed = ftpClient.changeWorkingDirectory(dir);
					System.out.println(dir + ":" + existed);
					if (!existed) {
						final boolean created = ftpClient.makeDirectory(dir);
						if (!created) {
							System.out.println("COULD NOT create directory: " + dir);
							return false;
						}
						System.out.println("CREATED directory: " + dir);
						ftpClient.changeWorkingDirectory(dir);
					}
				}
			}
		}
		return true;
	}	

}