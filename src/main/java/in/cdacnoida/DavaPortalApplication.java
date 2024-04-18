package in.cdacnoida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"in.cdacnoida.home","in.cdacnoida.davaconfig","in.cdacnoida.dava.service",
							  "in.cdacnoida.dava.serviceimpl","in.cdacnoida.dava", "in.cdacnoida.dava.util", "in.cdacnoida.dava.sqls"})
@EntityScan(basePackages= { "in.cdacnoida.dava.entities"} )
@EnableAutoConfiguration
@SpringBootApplication
public class DavaPortalApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DavaPortalApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}

	
	
	

}
