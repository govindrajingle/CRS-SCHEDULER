package in.cdacnoida.davaconfig;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import in.cdacnoida.dava.springsecurity.ActiveUserStore;
import in.cdacnoida.dava.springsecurity.CustomUsernamePasswordAuthFilter;
import in.cdacnoida.dava.springsecurity.MyLogoutSuccessHandler;
import in.cdacnoida.dava.springsecurity.SessionRegistryDetails;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	private RequestMatcher requestMatcher;
	
	@Autowired
	MyLogoutSuccessHandler logoutSuccessHandeller;
	
	@Autowired
	private SessionRegistryDetails sessionRegistryDetails;
	 	
	/*
	 * String[] requestNotToBeAuthenticated=new String[] {
	 * "/login","/getregistration","/rcmcRegistration","/registration","/css/**",
	 * "/js/**", "/images/**","/download/**","/RegistrationOfficials",
	 * "/getStateData","/getDistrictData","/emailVerification","/getCaptcha",
	 * "/getUserNameStatus","/ReportProblem","/getRcmcNumberStatus",
	 * "/saveReportType","/saveReportProblem","/WorkshopRegistration",
	 * "/uploadFile/**","/addressProofFile/**","/drugLicence/**","/forgotPassword",
	 * "/updatePassword","/faq", "/UserLogin", "/ConfigDetails", "/updatePublicKey",
	 * "/uploadFileData", "/uploadFileXml/**", "/androidRest",
	 * "/saveWorkshopRegistration",
	 * "/androidRest","/checkIecNumber","/download/IVEDA_UM.docx",
	 * "/checkGstnNumber","/ivedaRegistrationData","/PerformSolrSearch","/gallery",
	 * "/getSignatureChecksum","/PerformDBSearch","/test","/getdrugChecksum",
	 * "/getStatisticsData",
	 * "/download/PROSchema.xsd","/videotutorial","/download/PROSchema.xml",
	 * "/download/IVEDAExporterPackingDtl.xsd",
	 * "/download/IVEDAExporterPackingDtl.xml",
	 * "/download/ExporterTertiaryExcel.xlsx","/getgalleryimage",
	 * "/getmaingalleryimage","/officialRegistration",
	 * "/download/Product.xlsx","/guest/resendotp/**","/guest/**","/RCMCData",
	 * "/desktopConfigDtls","/getVersionDetls","/app/user/logs","/screenreader" };
	 */
	
	
	String[] requestNotToBeAuthenticated=new String[] {
			"/login","/getregistration","/rcmcRegistration","/registration","/css/**", "/js/**", "/images/**","/download/**","/RegistrationOfficials",
			"/getStateData","/getDistrictData","/emailVerification","/getCaptcha","/getUserNameStatus","/ReportProblem","/getRcmcNumberStatus","/saveReportType","/saveReportProblem","/WorkshopRegistration",
			"/uploadFile/**","/addressProofFile/**","/drugLicence/**","/forgotPassword","/updatePassword","/faq", "/UserLogin", "/ConfigDetails", "/updatePublicKey", "/uploadFileData", "/uploadFileXml/**", "/androidRest", "/saveWorkshopRegistration",
			"/androidRest","/checkIecNumber","/download/IVEDA_UM.docx", "/checkGstnNumber","/ivedaRegistrationData","/PerformSolrSearch","/gallery","/getSignatureChecksum","/PerformDBSearch","/test","/getdrugChecksum","/getStatisticsData",
			"/download/PROSchema.xsd","/videotutorial","/download/PROSchema.xml","/download/IVEDAExporterPackingDtl.xsd","/download/IVEDAExporterPackingDtl.xml","/download/ExporterTertiaryExcel.xlsx","/getgalleryimage","/getmaingalleryimage","/officialRegistration",
			"/download/Product.xlsx","/guest/resendotp/**","/guest/**","/RCMCData","/desktopConfigDtls","/getVersionDetls","/app/user/logs","/screenreader","/HashCodeCheck","/receivedHash","/GemReportDetailsData","/showTestData","/LapsingAndDeferredDataDetails"
	};
	
	
	
	@Bean
	BCryptPasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(getEncoder());
		return provider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.headers()
        	.contentTypeOptions().disable() // Disable X-Content-Type-Options
        	.xssProtection().disable()       // Disable X-XSS-Protection
            .and()
			.addFilterBefore(authenticationFilter(),UsernamePasswordAuthenticationFilter.class)
			.csrf().requireCsrfProtectionMatcher(requestMatcher)
			.and()
			.authorizeRequests().antMatchers(requestNotToBeAuthenticated).permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.successHandler(authenticationSuccessHandler)
				.failureHandler(authenticationFailureHandler)
			.and()
			.logout().invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessHandler(logoutSuccessHandeller)
				.logoutSuccessUrl("/logout-success")
				.deleteCookies("cdacid")
			.and()
				.sessionManagement()
					.sessionFixation().migrateSession() //on authentication a new HTTP Session is created, the old one is invalidated and the attributes from the old session are copied over.
					.invalidSessionUrl("/login") 
					.maximumSessions(2)
					.maxSessionsPreventsLogin(true)
					.expiredUrl("/login")
					.sessionRegistry(sessionRegistryDetails);
		
	}

	public CustomUsernamePasswordAuthFilter authenticationFilter() throws Exception {
		
		CustomUsernamePasswordAuthFilter filter=
				new CustomUsernamePasswordAuthFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setAuthenticationFailureHandler(authenticationFailureHandler);
		filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		return filter;
	}
	
	
	@Bean
	public ActiveUserStore activeUserStore(){
	    return new ActiveUserStore();
	}
	
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
	
}
