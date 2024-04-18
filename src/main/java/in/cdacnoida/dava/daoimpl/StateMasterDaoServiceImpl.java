package in.cdacnoida.dava.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.StateMasterDaoService;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.ZoneMst;
//import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
//import in.cdacnoida.dava.entities.LocationMasterDomain;
//import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class StateMasterDaoServiceImpl implements StateMasterDaoService
{
	@Autowired
	private DavaTransactions davaTransactions;

	
	public List<InstituteTypeMasterDomain> LoadStateType() {
		List<InstituteTypeMasterDomain> instMst =davaTransactions.getInstituteTypeName();
		return instMst;
	}
	
	
	public List<ZoneMst> getZone() {
		 return davaTransactions.getZone();
	}
	
	
	public String addStateMas(StatesMst stateDom) {
		return davaTransactions.saveStateMaster(stateDom);
	}
	

	public List<StatesMst> getState() {
		int countryId = 193;
	  List<StatesMst> stateMst =davaTransactions.getStatedata(countryId);
	return stateMst;
		
	}
	

	 public String updateStateMaster(StatesMst stateDom) { 
		 return davaTransactions.updateStateMaster(stateDom);
	}
	  
	
	  public void deleteStateUser(StatesMst stateDom) { 
		  davaTransactions.updateStateMaster(stateDom);
	  
	  }
	

     
}
