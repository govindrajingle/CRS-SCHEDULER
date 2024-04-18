package in.cdacnoida.dava.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.model.LocationMasterForm;
import in.cdacnoida.dava.model.ReportProblemForm;
import in.cdacnoida.dava.model.ReportProblemForm2;



public interface ReportProblemService {

	ReportProblemDomain addReportMaster(ReportProblemForm reportProblemForm);
	
	ReportProblemDomain addReportMaster(ReportProblemForm2 reportProblemForm2);

	List<ReportProblemDomain> getAllReports();

	ReportProblemDomain updateFeedbackMaster(ReportProblemForm reportForm, List<ReportProblemDomain> list, HttpServletRequest request);

	List<ReportProblemDomain> getFeedbackData(Integer problemId);

	ReportProblemDomain addReportProblem(ReportProblemForm rp);

	ReportProblemDomain updateFeedbackMasterForCDAC(ReportProblemForm reportForm, List<ReportProblemDomain> list,
			HttpServletRequest request);

	ReportProblemDomain updateFeedbackMasterProblemStatus(ReportProblemForm reportForm, List<ReportProblemDomain> list,
			HttpServletRequest request);


	/*
	 * String ShowLocMaster(HttpServletRequest request);
	 * 
	 * String updateLocationMaster(LocationMasterForm locationMasterForm);
	 * 
	 * void deleteLocForm(LocationMasterForm locationMasterForm);
	 */

}
