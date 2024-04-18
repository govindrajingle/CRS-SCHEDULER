package in.cdacnoida.dava.transactions;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.cdacnoida.dava.entities.EmailSchedulerEntity;


public interface EmailSchedulerRepo extends JpaRepository<EmailSchedulerEntity, Long> {

	EmailSchedulerEntity findByEmailId(String emailId);
	
	@Modifying
	@Transactional
	@Query("update EmailSchedulerEntity u set u.sentEmailCount = ?1")
	void setEmailCount(Integer emailCount);

	
}
