package in.cdacnoida.davaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:ftpdetails.properties")
@ConfigurationProperties(prefix = "ftp")
public class FtpDetailsProperties {

	
	private String path;
	private String directory;
	private String root;
	private String  hostname;
	private String username;
	private String password;
	private Integer port;
	private String jasperexportPath;
	private String tempupload;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getJasperexportPath() {
		return jasperexportPath;
	}
	public void setJasperexportPath(String jasperexportPath) {
		this.jasperexportPath = jasperexportPath;
	}
	public String getTempupload() {
		return tempupload;
	}
	public void setTempupload(String tempupload) {
		this.tempupload = tempupload;
	}
	
}
