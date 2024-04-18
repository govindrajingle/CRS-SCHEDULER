package in.cdacnoida.dava.transactions;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdacnoida.dava.entities.HostRegistrationEntity;

public interface GuestRegistrationRepo extends JpaRepository<HostRegistrationEntity, Long> {

	HostRegistrationEntity findByEmail(String email);
	/*
	@Query("Select r from RegistrationDetails r where r.numEmailStatus=0")
	List<RegistrationDetails> getUsersWithoutVerification();*/
}
