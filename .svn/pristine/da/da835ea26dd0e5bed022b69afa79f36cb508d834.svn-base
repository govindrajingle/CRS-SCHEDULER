package in.cdacnoida.dava.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "desktop_config_dtl")
public class DesktopConfigDtlDom extends TransactionInfoDomain implements Serializable {

	private static final long serialVersionUID = -9170913258269305131L;

	@Id
	@Column(name = "num_config_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")  
	@TableGenerator(name = "generator", initialValue = 1000, allocationSize = 1)
	int numConfigId; //Primary Key
	
	@Column(name = "ip_address") 
	String ipAddress;
	
	@Column(name = "mac_address") 
	String macAddress;
	
	@Column(name = "java_version") 
	String javaVersion;
	
	@Column(name = "os_version") 
	String osVersion;
	
	@Column(name = "app_version") 
	String appVersion;
	
	@Column(name = "num_user_id")
	Long numUserId;
	
	
	@Column(name = "public_key") 
	String publicKey;
	
	@Column(name = "directory_path") 
	String directoryPath;
	
	
	@Column(name = "xsd_path") 
	String xsdPath;

	
	@Column(name = "folder_path") 
	String folderPath;
	
	@Column(name = "input_path") 
	String inputPath;
	
	@Column(name = "output_path") 
	String outputPath;
	
	@Column(name = "log_path") 
	String logPath;

	@Column(name = "element_name") 
	String elementName;
	
	@Column(name = "file_type") 
	String fileType;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonIgnore
	private RegistrationDetails registrationDetails;
	
	public int getNumConfigId() {
		return numConfigId;
	}

	public void setNumConfigId(int numConfigId) {
		this.numConfigId = numConfigId;
	}

	public Long getNumUserId() {
		return numUserId;
	}

	public void setNumUserId(Long numUserId) {
		this.numUserId = numUserId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	
	public String getPublicKey() { 
		return publicKey; 
	}
	 
	public void setPublicKey(String publicKey) { 
		 this.publicKey = publicKey; 
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	
	  public String getXsdPath() { return xsdPath; }
	  
	  public void setXsdPath(String xsdPath) { this.xsdPath = xsdPath; }
	 

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public RegistrationDetails getRegistrationDetails() {
		return registrationDetails;
	}

	public void setRegistrationDetails(RegistrationDetails registrationDetails) {
		this.registrationDetails = registrationDetails;
	}
	 	
	
}
