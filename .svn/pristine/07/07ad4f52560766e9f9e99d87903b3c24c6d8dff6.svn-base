package in.cdacnoida.dava.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidation {
	
	public boolean validatePdfFile(MultipartFile file) {
		//System.out.println("File name"+file);
		//System.out.println("File Type:::::::"+file.getContentType());
		boolean result = false;
		int extsize = StringUtils.countMatches(file.getOriginalFilename(), ".");
		System.out.println("extsize:::::::::"+extsize);
		System.out.println("file.getOriginalFilename()::::"+file.getOriginalFilename());
		if(extsize == 1 && (file.getContentType().equalsIgnoreCase("application/pdf")) && 
			  FilenameUtils.isExtension(file.getOriginalFilename(), "pdf")) {
			result=true;
		}
		return result;
	}

	public boolean validateAddressFileContent(MultipartFile file, String addressFileHash) {
		return compairFileContent(file,addressFileHash);
	}

	public boolean validateDrugFileContent(MultipartFile drugLicence, String drugFileHash) {
		return compairFileContent(drugLicence,drugFileHash);
	} 
	
	
	public boolean compairFileContent(MultipartFile file, String hash) {
		boolean result=false;
		String stChecksum = "";
		try {
			byte[] uploadBytes = file.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(uploadBytes);
			String hashString = new BigInteger(1,digest).toString(16);
			stChecksum = hashString.trim();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(stChecksum.equals(hash))
			result=true;
		
		return result;
	}
	
}
