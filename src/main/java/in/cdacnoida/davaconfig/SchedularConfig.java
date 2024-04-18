package in.cdacnoida.davaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedularConfig {
	
	
//	private static final Logger LOGGER=LoggerFactory.getLogger(SchedularConfig.class);
//	
//	@Autowired
//	private DavaServices davaServices;
//	
//	@Autowired
//	private DavaServices davaser;
//	
//	@Autowired
//	private Sendmail sendmail;
//
//	@Autowired
//	private EmailContent emailContent;
//	
//	@Autowired
//	StaticsDataDomainRepository staticsDataDomainRepository;
//	
//	@Autowired
//	UploadXmlDataDtlDomainRepository uploadXmlDataDtlDomainRepository;
//	
//	@Autowired
//	UserRepository userRepository;
//	
//	@Autowired
//	private Environment env;
//	
//	@Scheduled(cron = "${statistics.expression}")
//	public void statsData() {
//		List<StaticsDataDomain> statisticsData = staticsDataDomainRepository.findAll();
//		String path = env.getProperty("dashboard.count");
//		Properties properties = new Properties();
//		for (StaticsDataDomain data : statisticsData) {
//			properties.setProperty("numRegManuf", String.valueOf(data.getNumRegManuf()));
//			properties.setProperty("numRegExp", String.valueOf(data.getNumRegExp()));
//			properties.setProperty("numDataManuf", String.valueOf(data.getNumDataManuf()));
//			properties.setProperty("numDataExp", String.valueOf(data.getNumDataExp()));
//			properties.setProperty("numExpCh29Country", String.valueOf(data.getNumExpCh29Country()));
//			properties.setProperty("numExpCh30Country", String.valueOf(data.getNumExpCh30Country()));
//			properties.setProperty("numExpCh29Data", String.valueOf(data.getNumExpCh29Data()));
//			properties.setProperty("numExpCh30Data", String.valueOf(data.getNumExpCh30Data()));
//		}
//		try (OutputStream output = new FileOutputStream(path)) {
//			properties.store(output, null);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	  @Scheduled(cron = "${desktopfileupload.cron.expression}")
//		public void desktopXmlSchedule() {
//			try {
//				List<UploadXmlDataDtlDomain> records = uploadXmlDataDtlDomainRepository.findByNumVerifyBy(11); // getting list of pending tertiaries
//				//List<UploadXmlDataDtlDomain> filteredRecords = records.stream().filter(record -> record.getNumStatus() == 1).collect(Collectors.toList()); 
//				//NumStatus(1) == Didn't go through procedure(insert_pack_code_dtl)
//				//NumStatus(2) == Successfully added to pack_code_dtl
//				//NumStatus(3) == Failed to add because of duplicate sscc or codesrno or srno
//				List<Integer> numUploadIds = new ArrayList<>();
//				for (UploadXmlDataDtlDomain record : records) {
//					numUploadIds.add(record.getNumUploadId());
//				}
//				for (Integer numUploadId : numUploadIds) {
//					System.out.println(LocalDateTime.now()+" --- UPLOAD ID IN PROCESS ---"+numUploadId+" Check the status : \nif(success) then 22 else 33");
//					try {
//						Integer returnResult = davaServices.saveConsignmentDetailsInTable(numUploadId);
//						Long userId = uploadXmlDataDtlDomainRepository.findUserIdByNumUploadId(numUploadId);
//						String userName = userRepository.findUserNameByUserId(userId);
//						String finalName = uploadXmlDataDtlDomainRepository.findFilenameByNumUploadId(numUploadId);
//						if (returnResult == 1) {
//							System.out.println("Added into pack_code_dtl");
//							uploadXmlDataDtlDomainRepository.updateNumVerifyByForUploadIdForSuccess(numUploadId);
//							System.out.println(LocalDateTime.now()+" --- (SUCCESS) FLAG CHANGED TO 22 (num_is_verify) from 11 of num_upload_id --- "+numUploadId);
//							String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXML");
//		        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXML");
//		        			emailVerificationContent=emailVerificationContent.replaceAll("\\$FILE\\_NAME\\$", finalName);
//		        			sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
//						} else {
//							System.out.println("Error in adding into pack_code_dtl");
//							uploadXmlDataDtlDomainRepository.updateNumVerifyByForUploadIdForFailure(numUploadId);
//							System.out.println(LocalDateTime.now()+" --- (FAILED) FLAG CHANGED TO 33 (num_is_verify) from 11 of num_upload_id --- "+numUploadId);
//							String emailVerificationSubject=emailContent.getEmailContent().get("emailSubjectForXMLNotUploaded");
//		        			String emailVerificationContent=emailContent.getEmailContent().get("emailContentForXMLNotUploaded");
//		        			emailVerificationContent=emailVerificationContent.replaceAll("\\$FILE\\_NAME\\$", finalName);
//		        			sendmail.sendMailToUser(userName, emailVerificationSubject, emailVerificationContent);
//						}
//						System.out.println(LocalDateTime.now()+" --- Process of upload id "+numUploadId+" is completed");
//					} catch (Exception e) { 
//						System.err.println("Error processing uploadId: " + numUploadId);
//					}
//				}
//			} catch (Exception e) { 
//				System.err.println("Error in scheduled task");
//			}
//		}
	
	
//	@Scheduled(cron="${rcmc.cron.expression}")
//	public void rcmcDataImportTask() {
//		
//		LOGGER.info("rcmc data schedular called");
//		try {
//			
//			URL obj = new URL("https://pharmexcil.in/member/cdac_api/RCMCData?apikey=CDAC@Auth$2019");
//			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
//			conn.setRequestMethod("GET");
//			conn.setDoOutput(true);
//			conn.setRequestProperty("Content-Type", "application/json");
//
//			int responseCode = conn.getResponseCode();
//		
//			String output;
//			StringBuffer output1 = new StringBuffer();
//			if (responseCode == HttpURLConnection.HTTP_OK) {
//				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				StringBuffer response = new StringBuffer();
//				
//				while ((output = in.readLine()) != null) {
//					output1.append(output);
//					System.out.println(output);
//				}
//				in.close();
//				davaser.RCMCData(output1.toString());
//				LOGGER.info("RCMC data {}",output1);
//			
//			} else {
//				LOGGER.error("RCMC data import not working");
//			}
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//	}
	
	/*
	 * @Scheduled(cron="${expirelink.corn.expression}") public void expirelink() {
	 * davaServices.expirelink(); }
	 */
	
	
	

//	@Scheduled(cron="${solr.cron.expression}")
//	public void solrDataInportTask() {
//		davaServices.indexSearchPageDB("false");
//	}
	
	
	/*
	 * @Scheduled(cron="${email.resend.expression}") public void emailScheduler() {
	 * List<RegistrationDetails>
	 * registrationDetails=davaServices.getRegistrationDataWithoutRegEmail(); for
	 * (RegistrationDetails registrationDetails2 : registrationDetails) {
	 * 
	 * if(registrationDetails2.getVerificationLink()==null) continue;
	 * 
	 * EmailSchedulerEntity
	 * emailSchedulerEntity=davaServices.getSentEmailCount(registrationDetails2.
	 * getUserName()); Integer count=1; if(emailSchedulerEntity!=null &&
	 * emailSchedulerEntity.getSentEmailCount()<=3)
	 * count=emailSchedulerEntity.getSentEmailCount()+1; else { EmailSchedulerEntity
	 * emailScheduledEntity=new EmailSchedulerEntity();
	 * emailScheduledEntity.setEmailId(registrationDetails2.getUserName());
	 * emailScheduledEntity.setSentEmailCount(count);
	 * davaServices.saveEmailEntity(emailScheduledEntity); }
	 * davaServices.updateEmailCount(count);
	 * 
	 * String emailVerificationSubject=emailContent.getEmailContent().get(
	 * "emailVerificationSubject"); String
	 * emailVerificationContent=emailContent.getEmailContent().get(
	 * "emailVerificationContent");
	 * 
	 * emailVerificationContent=emailVerificationContent.replaceAll(
	 * "\\$USER\\_NAME\\$", registrationDetails2.getOrgName());
	 * 
	 * emailVerificationContent=emailVerificationContent.replaceAll(
	 * "\\$URL\\_LINK\\$", registrationDetails2.getVerificationLink());
	 * 
	 * boolean result=sendmail.sendMailToUser(registrationDetails2.getUserName(),
	 * emailVerificationSubject,emailVerificationContent);
	 * 
	 * LOGGER.info("scheduler email service {}",result);
	 * 
	 * } }
	 */
	
	
		
		/*
		 * @Scheduled(cron = "${db.cron.expression}") public void dbConnectionTimeOut()
		 * { Date currentDate = new Date();
		 * System.out.println("Statistics db connection" +currentDate +" "+
		 * staticsDataDomainRepository.count());
		 * 
		 * }
		 */

		
	//Schedular for feedback responses status pending
	/*
	 * @Scheduled(cron="${feedbackstatus.expression}") public void
	 * feedBackResponsePending() { System.out.println("check status");
	 * davaServices.loadPendingStatus_FeedbackResponses(); }
	 */
	
}
