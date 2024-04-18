package in.cdacnoida.dava.daoservice;

import java.util.List;

import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.ZoneMst;


public interface LocationMasterDaoService {

	List<InstituteTypeMasterDomain> LoadLocationType();

	List<StatesMst> getState();

	String addLocationMas(LocationMasterDomain locDom);

	List<LocationMasterDomain> getLocations();

	String updateLocationMaster(LocationMasterDomain locDom);

	void deleteLocationUser(LocationMasterDomain locDom);

	List<RoleMaster> loadRole();

	List<ZoneMst> getZone();

	List<LocationMasterDomain> loadLocationMaster();

}
