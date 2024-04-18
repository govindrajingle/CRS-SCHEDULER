package in.cdacnoida.dava.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.model.DistrictMasterForm;


public interface DistrictMasterService {
  
	String addDistrictMaster(DistrictMasterForm districtMasterForm);

	//List<DistrictMst> getAllDistrict();

	String ShowDistMaster(HttpServletRequest request);

	String updateDistrictMaster(DistrictMasterForm districtMasterForm);

	void deleteDistForm(DistrictMasterForm districtMasterForm);

}
