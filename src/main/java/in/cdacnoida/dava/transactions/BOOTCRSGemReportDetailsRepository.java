package in.cdacnoida.dava.transactions;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.cdacnoida.dava.entities.BOOTCRSGemReportDetails;

public interface BOOTCRSGemReportDetailsRepository extends JpaRepository<BOOTCRSGemReportDetails, Integer> {

	@Query("SELECT b FROM BOOTCRSGemReportDetails b WHERE b.isValid = 1")
    List<BOOTCRSGemReportDetails> findValidDetails();	
	
	@Query("SELECT b FROM BOOTCRSGemReportDetails b WHERE b.isValid = 1")
	Page<BOOTCRSGemReportDetails> findValidDetailsTopFive(Pageable pageable);	
}
