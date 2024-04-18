package in.cdacnoida.dava.daoservice;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.entities.StatesMst;



public interface ReportProblemDaoService {

	//List<InstituteTypeMasterDomain> LoadLocationType();

	//List<StatesMst> getState();

	ReportProblemDomain addReportProblem(ReportProblemDomain reportDom);

	ReportProblemDomain updateReportProblem(ReportProblemDomain reportDom);

	List<ReportProblemDomain> getFeedbackMst(Integer problemId);

}
