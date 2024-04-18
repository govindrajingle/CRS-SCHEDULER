package in.cdacnoida.dava.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.DistrictMasterDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
//import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.transactions.DavaTransactions;
@Service
public  class DistrictMasterDaoServiceImpl implements DistrictMasterDaoService
{
	
	@Autowired
	private DavaTransactions davaTransactions;

	

	  public List<StatesMst> getState() { 
		  Integer countryId = 193;
	      List<StatesMst> stateMst =davaTransactions.getStatedata(countryId);
	      return stateMst;
	  
	 }
	 
	public String addDistrictMas(DistrictMst dmd) {
		return davaTransactions.saveDistrictMasterForm(dmd);
		
	}


	
	public String updateDistrictMaster(DistrictMst distDom) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteDistrictUser(DistrictMst distDom) {
		// TODO Auto-generated method stub
		
	}
  
}
