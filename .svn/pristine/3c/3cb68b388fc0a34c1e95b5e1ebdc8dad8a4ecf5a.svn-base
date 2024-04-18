package in.cdacnoida.dava.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.daoservice.ReportProblemDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class ReportProblemDaoServiceImpl implements ReportProblemDaoService{
	
	@Autowired
	private DavaTransactions davaTransactions;

	@Override
	public ReportProblemDomain addReportProblem(ReportProblemDomain reportDom) {
		// TODO Auto-generated method stub
		return davaTransactions.saveReportProblem(reportDom);
	}
	
	public ReportProblemDomain updateReportProblem(ReportProblemDomain reportDom) {
		return davaTransactions.updateReportProblem(reportDom);
	}
	
	public List<ReportProblemDomain> getFeedbackMst(Integer problemId) {
		List<ReportProblemDomain> feedback=davaTransactions.getFeedbackMstData(problemId);
		return feedback;
	}
	
	
	
	
	

	/*
	 * @Override public List<ReportProblemDomain>
	 * addReportProblem(ReportProblemDomain reportDom) { // TODO Auto-generated
	 * method stub return davaTransactions.saveReportProblem(reportDom); }
	 */
	


}
