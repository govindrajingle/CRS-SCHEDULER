package in.cdacnoida.davaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:uploadingpath.properties")
@ConfigurationProperties(prefix = "upload")
public class FileUploadingPath {

	public FileUploadingPath() {}
	
	private String xmlPath;
	private String xsdPath;
	private String certPath;
	private String dynamicPropertiesPath;
	
	public String getXmlPath() {
		return xmlPath;
	}
	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}
	public String getXsdPath() {
		return xsdPath;
	}
	public void setXsdPath(String xsdPath) {
		this.xsdPath = xsdPath;
	}
	public String getCertPath() {
		return certPath;
	}
	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}
	public String getDynamicPropertiesPath() {
		return dynamicPropertiesPath;
	}
	public void setDynamicPropertiesPath(String dynamicPropertiesPath) {
		this.dynamicPropertiesPath = dynamicPropertiesPath;
	}
	
}
