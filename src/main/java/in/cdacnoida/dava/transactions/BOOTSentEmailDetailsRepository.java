package in.cdacnoida.dava.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import in.cdacnoida.dava.entities.BOOTSentEmailDetails;

public interface BOOTSentEmailDetailsRepository extends JpaRepository<BOOTSentEmailDetails, Integer>{

    @Query(value = "SELECT COALESCE(MAX(mail_counter), 0) + 1 FROM sent_email_details", nativeQuery = true)
    Integer getNextMailCounter();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sent_email_details(email_id, subject, message, status, status_after_sent, date_before_sent, mail_counter) VALUES (?1, ?2, ?3, 0, 0, CURRENT_TIMESTAMP, ?4)", nativeQuery = true)
    void insertEmailDetails(String emailId, String subject, String message, Integer mailCounter);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sent_email_details SET status = 1, status_after_sent = 1, date_after_sent = CURRENT_TIMESTAMP WHERE mail_counter = ?1", nativeQuery = true)
    void updateEmailDetails(Integer mailCounter);
}