package in.cdacnoida.dava.transactions;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.cdacnoida.dava.entities.RegistrationDetails;

public interface UserRepository extends JpaRepository<RegistrationDetails, Long> {

	RegistrationDetails findByUserName(String userName);

	@Query("Select r from RegistrationDetails r where r.userName = ?1 and r.randomNumber = ?2")
	RegistrationDetails findByRandomNumberAndUserName(String userName, int randomNumber);

	RegistrationDetails findByStrRcmcNumber(String rcmcNumber);

	// added by harshita 03072023

	RegistrationDetails findByPassword(String password);

	RegistrationDetails findByIecNumber(String iecNumber);

	RegistrationDetails findByGstnumber(String gstnNumber);

	@Query("Select r from RegistrationDetails r where r.numEmailStatus=0")
	List<RegistrationDetails> getUsersWithoutVerification();

	// Govind 080923
	@Query("SELECT r.expirationTime FROM RegistrationDetails r WHERE r.userName = ?1")
	LocalDateTime findExpirationTimeByUsername(String userName);

	@Modifying
	@Transactional
	@Query("UPDATE RegistrationDetails SET addressProffId = :docId WHERE userId = :userId")
	void updateAddressProffId(Long userId, int docId);

	@Modifying
	@Transactional
	@Query("UPDATE RegistrationDetails SET drugLicenseId = :drugLicenseId WHERE userId = :userId")
	void updateDrugLicenseId(Long userId, Integer drugLicenseId);

	@Query("SELECT u.userName FROM RegistrationDetails u WHERE u.userId = :userId")
	String findUserNameByUserId(Long userId);

	@Query("SELECT applicantType FROM RegistrationDetails WHERE userId = :userId")
	String findApplicantTypeByUserId(Long userId);

	@Modifying
	@Transactional
	@Query("UPDATE RegistrationDetails SET publicKey = null WHERE userId = :userId")
	void setPublicKeyNull(Long userId);
	
	@Modifying
	@Transactional
	@Query("UPDATE RegistrationDetails SET publicKey = :newPublicKey WHERE userId = :userId")
	void updatePublicKey(@Param("userId") Long userId, @Param("newPublicKey") String newPublicKey);

	// DesktopConfigDtlDom findDeskDetailsByUserId(Long numUserId);

}
