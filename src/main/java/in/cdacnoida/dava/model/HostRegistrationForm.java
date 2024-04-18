package in.cdacnoida.dava.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class HostRegistrationForm {

	private Long userId;
	
	@NotNull
	@NotBlank(message = "Name is mandatory")
	@Pattern(message="Please enter a valid name", regexp = "^[a-zA-Z\\s]+$")
	private String name;
	
	@NotNull
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;
	
	@NotNull
	@NotBlank(message = "City is mandatory")
	@Pattern(message="Please enter a valid city name", regexp = "^[a-zA-Z\\s]+$")
	private String city;
	
	@NotNull
	@NotBlank(message = "Country is mandatory")
	@Pattern(message="Please enter a valid country name", regexp = "^[a-zA-Z\\s]+$")
	private String country;
	
	private Integer otp;
	
	
	private boolean isActive;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email.toLowerCase();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

	
	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "HostRegistrationForm [userId=" + userId + ", name=" + name + ", email=" + email + ", city=" + city
				+ ", country=" + country + ", isActive=" + isActive + "]";
	}
	

}
