package in.cdacnoida.dava.transactions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.cdacnoida.dava.entities.UploadXmlDataDtlDomain;

@Repository
public interface UploadXmlDataDtlDomainRepository extends JpaRepository<UploadXmlDataDtlDomain, Integer> {
	// List<UploadXmlDataDtlDomain> findByNumStatus(int numStatus);

//	  Tertiary xml consignments scheduling
//	  1: success 
//	  2: Pending (Default from 26-02-24)
//	  3: failure to call procedure pack_code_dtl
	List<UploadXmlDataDtlDomain> findByNumVerifyBy(int numVerifyBy);

	@Transactional
	@Modifying
	@Query("UPDATE UploadXmlDataDtlDomain SET numVerifyBy = 22 WHERE numUploadId = :numUploadId")
	void updateNumVerifyByForUploadIdForSuccess(int numUploadId);
	
	@Transactional	
	@Modifying
	@Query("UPDATE UploadXmlDataDtlDomain SET numVerifyBy = 33 WHERE numUploadId = :numUploadId")
	void updateNumVerifyByForUploadIdForFailure(int numUploadId);	

	@Query("SELECT u.numUserId FROM UploadXmlDataDtlDomain u WHERE u.numUploadId = :numUploadId")
	Long findUserIdByNumUploadId(int numUploadId);

	@Query("SELECT u.strFilename FROM UploadXmlDataDtlDomain u WHERE u.numUploadId = :numUploadId")
	String findFilenameByNumUploadId(int numUploadId);
	
    @Query("SELECT u.strHashCode FROM UploadXmlDataDtlDomain u")
    List<String> findAllHashCodes();
    



}
