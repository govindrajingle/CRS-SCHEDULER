package in.cdacnoida.dava.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dynamicHomepage.properties")
@ConfigurationProperties(prefix = "homepage")
public class DynamicHomepage {	

			private String aboutus;

			public String getAboutus() {
				return aboutus;
			}
			public void setAboutus(String aboutus) {
				this.aboutus = aboutus;
			}
			
			
			

}
