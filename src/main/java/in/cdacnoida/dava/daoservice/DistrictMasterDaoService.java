package in.cdacnoida.dava.daoservice;

import java.util.List;

import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
//import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.StatesMst;

public interface DistrictMasterDaoService {
	
    List<StatesMst> getState();

	String addDistrictMas(DistrictMst distDom);

	String updateDistrictMaster(DistrictMst distDom);

	void deleteDistrictUser(DistrictMst distDom);

}
