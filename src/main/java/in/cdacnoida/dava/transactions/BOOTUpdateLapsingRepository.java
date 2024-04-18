package in.cdacnoida.dava.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cdacnoida.dava.entities.BOOTCreitRegistrationMaster;

@Repository
public interface BOOTUpdateLapsingRepository extends JpaRepository<BOOTCreitRegistrationMaster, Integer> {

	/*
	 * @Query("SELECT b FROM BOOTCreitRegistrationMaster b WHERE b.regNumber = 'R-72001031'"
	 * ) List<BOOTCreitRegistrationMaster> findByRegNumber();
	 */

}
