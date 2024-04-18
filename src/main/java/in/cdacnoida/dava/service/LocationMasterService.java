package in.cdacnoida.dava.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.model.LocationMasterForm;

public interface LocationMasterService {

	String addLocationMaster(LocationMasterForm locationMasterForm);

	List<LocationMasterDomain> getAllLocations();

	String ShowLocMaster(HttpServletRequest request);

	String updateLocationMaster(LocationMasterForm locationMasterForm);

	void deleteLocForm(LocationMasterForm locationMasterForm);

}
