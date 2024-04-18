package in.cdacnoida.dava.transactions;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.cdacnoida.dava.entities.DocumentMasterDomain;

public interface DocumentMasterDomainRepository extends JpaRepository<DocumentMasterDomain, Integer>{
	List<DocumentMasterDomain> findByNumSignFlag(int numSignFlag);//to get the all records from numFlag
	Optional<DocumentMasterDomain> findByStrFilename(String strFilename);//to get file contents via file name
	@Query("SELECT d.strRmarks FROM DocumentMasterDomain d")
    List<String> findStrRemarksWithXml();
}	
