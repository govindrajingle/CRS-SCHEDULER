package in.cdacnoida.dava.transactions;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.cdacnoida.dava.entities.InstPremiseDtlDomain;

public interface InstPremiseDtlRepository extends JpaRepository<InstPremiseDtlDomain, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE InstPremiseDtlDomain SET numDocumentId = :newDocId WHERE numInstid = :numInstid AND numDocId = 99")
	void updateNumDocumentId(@Param("numInstid") int numInstid, @Param("newDocId") int newDocId);


    @Modifying
    @Transactional
    @Query("UPDATE InstPremiseDtlDomain SET numDocId = 0 WHERE numInstid = :numInstid  AND numDocId = 99")
    void setZero(int numInstid);
	
}
