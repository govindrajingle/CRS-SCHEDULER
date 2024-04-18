package in.cdacnoida.dava.transactions;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdacnoida.dava.entities.RcmcRegistrationData;

/*public interface RcmcDataRepository extends JpaRepository<RcmcRegistrationData, Long> {

	RcmcRegistrationData findByRcmcNumber(String rcmcNumber);
	
}
*/

public interface RcmcDataRepository extends JpaRepository<RcmcRegistrationData, Long> {

	RcmcRegistrationData findByRcmcNumber(String rcmcNumber);
	
	RcmcRegistrationData findByIecNumber(String rcmcNumber);

}



