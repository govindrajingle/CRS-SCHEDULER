package in.cdacnoida.dava.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.ZoneMst;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class LocationMasterDaoServiceImpl implements LocationMasterDaoService{
	
	@Autowired
	private DavaTransactions davaTransactions;

	public List<InstituteTypeMasterDomain> LoadLocationType() {
		List<InstituteTypeMasterDomain> instMst =davaTransactions.getInstituteTypeName();
		return instMst;
	}

	public List<StatesMst> getState() {
		Integer countryId = 193;
		List<StatesMst> stateMst =davaTransactions.getStatedata(countryId);
		return stateMst;
	}
	
	public List<ZoneMst> getZone() {
		List<ZoneMst> zoneMst =davaTransactions.getZoneData();
		return zoneMst;
	}

	public String addLocationMas(LocationMasterDomain locDom) {
		return davaTransactions.saveLocationMaster(locDom);
	}
	
	public List<LocationMasterDomain> getLocations() {
		List<LocationMasterDomain> lmd = davaTransactions.getLocationsData();
		return lmd;
	}
	
	public String updateLocationMaster(LocationMasterDomain locDom) {
		return davaTransactions.updateLocationMaster(locDom);
	}
	
	public void deleteLocationUser(LocationMasterDomain locDom) {
		davaTransactions.updateLocationMaster(locDom);
	}
	
	public List<RoleMaster> loadRole() {
		List<RoleMaster> role = davaTransactions.getAllRoles();
		return role;
	}
	
	public List<LocationMasterDomain> loadLocationMaster() {
		List<LocationMasterDomain> locMst =davaTransactions.getLocationMstData();
		return locMst;
	}

}
