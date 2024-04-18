/*
 * package in.cdacnoida.dava.transactions;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Modifying; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import in.cdacnoida.dava.entities.BOOTCreitRegistrationHistory;
 * 
 * public interface BOOTCreitRegistrationHistoryRepository extends
 * JpaRepository<BOOTCreitRegistrationHistory, Long> {
 * 
 * 
 * @Modifying
 * 
 * @Transactional
 * 
 * @Query(value =
 * "insert into creit_registration_history (application_id,str_version,reg_date,reg_number,reg_cert_flag,str_status,trans_date,trans_user_id,dealing_officer,granting_officer,remarks,agree_form_flag,trans_type_id,num_sequence,surv_initiated,transaction_id,intimation_flag,letter_of_intimation,valid_up_to) select application_id,str_version,reg_date,reg_number,reg_cert_flag,str_status,trans_date,trans_user_id,dealing_officer,granting_officer,remarks,agree_form_flag,trans_type_id,num_sequence,surv_initiated,transaction_id,intimation_flag,letter_of_intimation,valid_up_to from creit_registration_master where application_id= ?1 and reg_number= ?2 and str_status= ?3"
 * , nativeQuery = true) void insertHistory(String appId, String regNumber,
 * String strStatus);
 * 
 * @Modifying
 * 
 * @Transactional
 * 
 * @Query("update CreitRegistrationMaster crm set crm.strStatus = ?1 where crm.applicationId = ?2 and crm.regNumber = ?3 and crm.strStatus = ?4"
 * ) int updateHistory(String newStatus, String appId, String regNumber, String
 * oldStatus);
 * 
 * }
 */