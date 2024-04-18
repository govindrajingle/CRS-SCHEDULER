package in.cdacnoida.davaconfig;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:emailContent.properties")
@ConfigurationProperties(prefix = "email")
public class EmailContent {

	
	private Map<String,String> emailContent;

	public Map<String, String> getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(Map<String, String> emailContent) {
		this.emailContent = emailContent;
	}
	
	
	
	
}
