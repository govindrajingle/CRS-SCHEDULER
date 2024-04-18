package in.cdacnoida.davaconfig;

import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import in.cdacnoida.dava.controllers.BOOTCRSMainController;
import in.cdacnoida.dava.entities.BOOTCRSLogSchedulerRunnigTime;
import in.cdacnoida.dava.serviceimpl.BOOTCreitRegistrationMasterDaoServiceImpl;
import in.cdacnoida.dava.transactions.BOOTCRSGemReportDetailsRepository;
import in.cdacnoida.dava.transactions.BOOTCRSLogSchedulerRunnigTimeRepository;

@EnableScheduling
@Configuration
public class BOOTCRSScheduler {

	private static final Logger LOGGER = LoggerFactory.getLogger(BOOTCRSScheduler.class);

	@Autowired
	BOOTCRSLogSchedulerRunnigTimeRepository bootCRSLogSchedulerRunnigTimeRepository;

	@Autowired
	BOOTCRSGemReportDetailsRepository bOOTCRSGemReportDetailsRepository;

	@Autowired
	BOOTCreitRegistrationMasterDaoServiceImpl bOOTCreitRegistrationMasterDaoServiceImpl;

	@Autowired
	BOOTCRSMainController bOOTCRSMainController;

	@Scheduled(cron = "${sch_method_three_hours}")
	public void schMethodThreeHours() {
		String methodName = "SCH_THREE_HOURS";
		// 05-04-2024 (Update lapsing and defered records)
		System.out.println(LocalDateTime.now() + "   Deferment and Lapsing Service scheduler executed");
		System.out.println(LocalDateTime.now() + "   1). Deferment Service scheduler executed");
		//bOOTCreitRegistrationMasterDaoServiceImpl.DefermentQueryDataService();
		System.out.println(LocalDateTime.now() + "   2). Lapsing Service scheduler executed");
		//bOOTCreitRegistrationMasterDaoServiceImpl.updateLapsingService();
		System.out.println(LocalDateTime.now() + "  Data saved into " + methodName);
		BOOTCRSLogSchedulerRunnigTime bootCRSLogSchedulerRunnigTime = new BOOTCRSLogSchedulerRunnigTime();
		bootCRSLogSchedulerRunnigTime.setIsValid(0);
		bootCRSLogSchedulerRunnigTime.setMethodName(methodName);
		bootCRSLogSchedulerRunnigTime.setTransactionDate(LocalDateTime.now());
		this.bootCRSLogSchedulerRunnigTimeRepository.save(bootCRSLogSchedulerRunnigTime);
	}

	@Scheduled(cron = "${sch_method_six_hours}")
	public void schMethodSixHours() {
		String methodName = "SCH_SIX_HOURS";
		System.out.println(LocalDateTime.now() + "  Data saved into " + methodName);
		BOOTCRSLogSchedulerRunnigTime bootCRSLogSchedulerRunnigTime = new BOOTCRSLogSchedulerRunnigTime();
		bootCRSLogSchedulerRunnigTime.setIsValid(0);
		bootCRSLogSchedulerRunnigTime.setMethodName(methodName);
		bootCRSLogSchedulerRunnigTime.setTransactionDate(LocalDateTime.now());
		this.bootCRSLogSchedulerRunnigTimeRepository.save(bootCRSLogSchedulerRunnigTime);
	}

	@Scheduled(cron = "${sch_method_tweleve_hours}")
	public void schMethodTweleveHours() throws IOException {
		// 05-04-2024 (Update lapsing and defered records)
		// System.out.println(LocalDateTime.now() + "   Deferment and Lapsing Service scheduler executed");
		// System.out.println(LocalDateTime.now() + "   1). Deferment Service scheduler executed");
		// bOOTCreitRegistrationMasterDaoServiceImpl.DefermentQueryDataService();
		// System.out.println(LocalDateTime.now() + "   2). Lapsing Service scheduler executed");
		// bOOTCreitRegistrationMasterDaoServiceImpl.updateLapsingService();
		String methodName = "SCH_TWELEVE_HOURS";
		System.out.println(LocalDateTime.now() + "  Data saved into " + methodName);
		BOOTCRSLogSchedulerRunnigTime bootCRSLogSchedulerRunnigTime = new BOOTCRSLogSchedulerRunnigTime();
		bootCRSLogSchedulerRunnigTime.setIsValid(0);
		bootCRSLogSchedulerRunnigTime.setMethodName(methodName);
		bootCRSLogSchedulerRunnigTime.setTransactionDate(LocalDateTime.now());
		this.bootCRSLogSchedulerRunnigTimeRepository.save(bootCRSLogSchedulerRunnigTime);
	}

	@Scheduled(cron = "${sch_method_one_day}")
	public void schMethodOneDay() throws IOException {
		// 27-03-2024 (Creating Excel report)
		bOOTCRSMainController.getGemReportDetails();
		String methodName = "SCH_ONE_DAY";
		System.out.println(LocalDateTime.now() + "  Data saved into " + methodName);
		BOOTCRSLogSchedulerRunnigTime bootCRSLogSchedulerRunnigTime = new BOOTCRSLogSchedulerRunnigTime();
		bootCRSLogSchedulerRunnigTime.setIsValid(0);
		bootCRSLogSchedulerRunnigTime.setMethodName(methodName);
		bootCRSLogSchedulerRunnigTime.setTransactionDate(LocalDateTime.now());
		this.bootCRSLogSchedulerRunnigTimeRepository.save(bootCRSLogSchedulerRunnigTime);
	}
}
