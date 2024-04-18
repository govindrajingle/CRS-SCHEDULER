package in.cdacnoida.dava.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdacnoida.dava.entities.BOOTCRSGemReportDetails;
import in.cdacnoida.dava.service.BOOTCRSExcelService;
import in.cdacnoida.dava.serviceimpl.BOOTCreitRegistrationMasterDaoServiceImpl;
import in.cdacnoida.dava.serviceimpl.BOOTModelWithdrawalActionImpl;
import in.cdacnoida.dava.transactions.BOOTCRSGemReportDetailsRepository;
import in.cdacnoida.dava.transactions.BOOTLogSchedularDefermentLapsedDtlRepository;

@RestController
public class BOOTCRSMainController {

	@Autowired
	BOOTCRSGemReportDetailsRepository bOOTCRSGemReportDetailsRepository;

	@Autowired
	BOOTCRSExcelService bOOTCRSExcelService;

	@Autowired
	BOOTCreitRegistrationMasterDaoServiceImpl bOOTCreitRegistrationMasterDaoServiceImpl;
	
	@Autowired
	BOOTModelWithdrawalActionImpl bOOTModelWithdrawalActionImpl;	

	@Autowired
	BOOTLogSchedularDefermentLapsedDtlRepository bOOTLogSchedularDefermentLapsedDtlRepository;

	
	@GetMapping("/showTestData")
	public List<HashMap<String, Object>> displayDataInBrowser() {
		List<HashMap<String, Object>> dataReceived = bOOTModelWithdrawalActionImpl.queryForNewRecordsData();
		return dataReceived;
	}

	// 03-04-2024 (Lapsing and Deferred query service)
	@GetMapping("/LapsingAndDeferredDataDetails")
	public List<HashMap<String, Object>> updateLapsing() {

		List<HashMap<String, Object>> receivedInfoLapsing = bOOTCreitRegistrationMasterDaoServiceImpl.updateLapsingService();
//		List<HashMap<String, Object>> receivedInfoDefered = bOOTCreitRegistrationMasterDaoServiceImpl.DefermentQueryDataService();
//		if (receivedInfoLapsing.size() > 0) {
//			for (int index = 0; index < receivedInfoLapsing.size(); index++) {
//				HashMap<String, Object> record = receivedInfoLapsing.get(index);
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//				String app_id = (String) record.get("application_id");
//				LocalDateTime regDateDateTime = (LocalDateTime) record.get("reg_date");
//				LocalDateTime validUptodate = (LocalDateTime) record.get("valid_up_to");
//				String reg_date = regDateDateTime.format(formatter);
//				String valid_up_to = validUptodate.format(formatter);
//				LocalDateTime validUptoDate = (LocalDateTime) record.get("reg_date");
//				String str_status = (String) record.get("str_status");
//				String reg_number = (String) record.get("reg_number");
//			}
//		}
//
//		if (receivedInfoDefered.size() > 0) {
//			for (int index = 0; index < receivedInfoDefered.size(); index++) {
//				HashMap<String, Object> record = receivedInfoDefered.get(index);
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//				String app_id = (String) record.get("application_id");
//				LocalDateTime regDateDateTime = (LocalDateTime) record.get("reg_date");
//				LocalDateTime validUptodate = (LocalDateTime) record.get("valid_up_to");
//				String reg_date = regDateDateTime.format(formatter);
//				// String valid_up_to = validUptodate.format(formatter);
//				String str_status = (String) record.get("str_status");
//				String reg_number = (String) record.get("reg_number");
//			}
//		}
		return receivedInfoLapsing;
	}

	// 26-03-2024 (Excel report generation)
	@GetMapping("/GemReportDetailsData")
	public ResponseEntity<String> getGemReportDetails() throws IOException {
		List<BOOTCRSGemReportDetails> listTable = bOOTCRSGemReportDetailsRepository.findValidDetails();
		ByteArrayInputStream in = bOOTCRSExcelService.gemReportDetailsToExcel(listTable);
		byte[] bytes = toByteArray(in);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=GemReport.xlsx");
		// return ResponseEntity.ok().headers(headers).body(bytes);
		String htmlResponse = "<html><body><div style='text-align: center;'><h2>Excel sheet is created at FTP server</h2></div></body></html>";
		return ResponseEntity.ok().body(htmlResponse);
	}

	public static byte[] toByteArray(ByteArrayInputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		return out.toByteArray();
	}

}
