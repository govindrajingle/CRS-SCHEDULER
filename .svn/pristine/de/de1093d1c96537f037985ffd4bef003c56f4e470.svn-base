package in.cdacnoida.dava.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AppUserLogsForm {

	@NotNull
	@NotBlank(message = "Serial Number is mandatory")
	private String serialNumber;
	
	@NotNull
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
