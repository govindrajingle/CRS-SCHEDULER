package in.cdacnoida.dava.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import in.cdacnoida.dava.entities.BOOTCRSGemReportHistory;

public interface BOOTCRSGemReportHistoryRepository extends JpaRepository<BOOTCRSGemReportHistory, Integer> {
	
	@Modifying
	@Query(value = "insert into gemreporthistory(download_id,validity,log_dt) values(to_char(current_timestamp, 'YYYYMMDDHHMMSS'),(current_timestamp + '3 days'::interval),current_timestamp)", nativeQuery = true)
	void insertRecord();
	

	@Transactional
	@Query(value = "select download_id from gemreporthistory where isvalid=1 order by id desc limit 1", nativeQuery = true)
	String getLatestValidDownloadId();
}
