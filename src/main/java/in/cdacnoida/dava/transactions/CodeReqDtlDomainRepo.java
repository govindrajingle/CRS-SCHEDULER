package in.cdacnoida.dava.transactions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdacnoida.dava.entities.CodeReqDtlDomain;

public interface CodeReqDtlDomainRepo extends JpaRepository<CodeReqDtlDomain, Integer>{

	List<CodeReqDtlDomain> findByInstId(Integer id);
	
}
