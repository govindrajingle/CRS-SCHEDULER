package in.cdacnoida.dava.serviceimpl;

import java.beans.Encoder;
import java.security.spec.EncodedKeySpec;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.controllers.ReportProblemAction;
import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.daoservice.ReportProblemDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.model.LocationMasterForm;
import in.cdacnoida.dava.model.ReportProblemForm;
import in.cdacnoida.dava.model.ReportProblemForm2;
import in.cdacnoida.dava.service.DataEncoderService;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.LocationMasterService;
import in.cdacnoida.dava.service.ReportProblemService;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class ReportProblemServiceImpl implements ReportProblemService {


	
	@Autowired
	public ReportProblemDaoService reportDao;
	

	@Autowired
	public DavaServices dSer;
	
	
	
      @Autowired
      public DavaDaoServices dDao;
      
    

      @Autowired
      public DavaTransactions dt;
      
      
      @Autowired
      public ReportProblemService repServ;
      
      @Autowired
  	  DataEncoderService encodedservice;
  	  
    
   

	@Override
	public List<ReportProblemDomain> getAllReports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  ReportProblemDomain addReportMaster(ReportProblemForm reportProblemForm) {
		// TODO Auto-generated method stub
		
		
		ReportProblemDomain reportDom = new ReportProblemDomain();
		
	   // reportDom.setProblem_id(reportProblemForm.getProblem_id());
		reportDom.setUser_name(reportProblemForm.getUser_name());
		reportDom.setOrg_name(reportProblemForm.getOrg_name());
		reportDom.setProblem(reportProblemForm.getProblem());
		reportDom.setAddress(reportProblemForm.getAddress());
		reportDom.setDesignation(reportProblemForm.getDesignation());
		reportDom.setEmail_id(reportProblemForm.getEmail_id());
		
		reportDom.setProblem(reportProblemForm.getProblem());
		reportDom.setNumIsValid(1);
		reportDom.setDtTrDate(new Date());
		reportDom.setNumTrUserId(100);
		reportDom.setMobile(reportProblemForm.getMobile_no());
	
		
		//  System.out.println("Doc Id " + reportProblemForm.getNumDocId());
		//  if
		//  (reportProblemForm.getNumDocId() == 0)
		//  {
		//	  reportDom.setDoc_id(0);
		// }
		//  else
		//  {
		//  reportDom.setDoc_id(reportProblemForm.getNumDocId());
		//  }
		
		
			
			System.err.println("Doc Id " +reportProblemForm.getStrDocId().trim());
			
		
			if (reportProblemForm.getStrDocId().equals("-1"))
			{
				reportDom.setDoc_id(0);
			}
			else
			{
				
				String sId=encodedservice.decode(reportProblemForm.getStrDocId());
				System.err.println("sId " +sId);
				String sId2=reverse(sId);
				System.err.println("sId2 " +sId2);
				String sID3 = encodedservice.decode(sId2);
				
				reportDom.setDoc_id(Integer.parseInt(sID3));
				
				
			}
	      
	      
	     reportDom.setLandline_no(reportProblemForm.getContact_number());
	      
	     reportDom.setSubject(reportProblemForm.getSubject());
	      
	      reportDom.setEntry_date(new Date());
	     
	      reportDom.setPincode(reportProblemForm.getPincode());
	      
	      reportDom.setCountry_id(reportProblemForm.getCountryTypeId());
	      
	      
	      
	    
	      
	      
	      
		  return reportDao.addReportProblem(reportDom);
		
		

		
	}
	
	public ReportProblemDomain updateFeedbackMaster(ReportProblemForm reportForm,List<ReportProblemDomain> list, HttpServletRequest request) {
		ReportProblemDomain reportDom = new ReportProblemDomain();
		
		reportDom.setUser_name(list.get(0).getUser_name());
		reportDom.setOrg_name(list.get(0).getOrg_name());
		reportDom.setProblem(list.get(0).getProblem());
		reportDom.setAddress(list.get(0).getAddress());
		reportDom.setDesignation(list.get(0).getDesignation());
		reportDom.setEmail_id(list.get(0).getEmail_id());
		reportDom.setNumIsValid(1);
		reportDom.setDtTrDate(new Date());
		reportDom.setNumTrUserId(100);
		reportDom.setMobile(list.get(0).getMobile());
	    System.out.println("Doc Id " + list.get(0).getDoc_id());
		reportDom.setDoc_id(list.get(0).getDoc_id());
	    reportDom.setLandline_no(list.get(0).getLandline_no());
	    reportDom.setSubject(list.get(0).getSubject());
	    reportDom.setEntry_date(new Date());
	    reportDom.setPincode(list.get(0).getPincode());
	    reportDom.setCountry_id(list.get(0).getCountry_id());
	    reportDom.setProblem_no(list.get(0).getProblem_no());
	    reportDom.setNumIssueStatus(3);
		reportDom.setProblem_id(reportForm.getProblem_id());
		reportDom.setReplyStatus(1);
		
		/*
		 * String strReply = reportForm.getStrRemarks(); strReply =
		 * strReply.replaceFirst("/(?:\\r\\n|\\r|\\n)/g", " ");
		 * reportDom.setStrReply(strReply);
		 */
		reportDom.setStrReply(reportForm.getStrRemarks());
		
		return reportDao.updateReportProblem(reportDom);
	}
	
	public List<ReportProblemDomain> getFeedbackData(Integer problemId) {
		List<ReportProblemDomain> feedbackMst=reportDao.getFeedbackMst(problemId);
		return feedbackMst;
	}

	
	public ReportProblemDomain addReportProblem(ReportProblemForm rp) {
		ReportProblemDomain rpd = new ReportProblemDomain();
		rpd.setUser_name(rp.getuName().get(0));
		rpd.setDesignation(rp.getuDesignation().get(1));
		rpd.setEmail_id(rp.getuEmail().get(2));
		rpd.setMobile(rp.getuMobile().get(3));
		rpd.setOrg_name(rp.getuOrganization().get(4));
		rpd.setAddress(rp.getuAddress().get(5));
	    rpd.setPincode(rp.getuPostalCode().get(6));
	    rpd.setLandline_no(rp.getuContact().get(7));
	    rpd.setSubject(rp.getuSubject().get(8));
	    rpd.setProblem(rp.getuProblem().get(9));
	  // rpd.setDoc_id(rp.getuUpload().get(10));
	    
	    
	    System.out.println("helooo8976");
	
			
		
		
		return   reportDao.addReportProblem(rpd);
	}

	@Override
	public ReportProblemDomain addReportMaster(ReportProblemForm2 reportProblemForm2) {
		
		
		ReportProblemDomain reportDom = new ReportProblemDomain();
		
		   // reportDom.setProblem_id(reportProblemForm.getProblem_id());
		  
			reportDom.setUser_name(reportProblemForm2.getName());
			reportDom.setDesignation(reportProblemForm2.getDesignation());
			reportDom.setEmail_id(reportProblemForm2.getEmail());
			reportDom.setMobile(reportProblemForm2.getMobile());
			reportDom.setOrg_name(reportProblemForm2.getMobile());
			reportDom.setAddress(reportProblemForm2.getAddress());
			reportDom.setCountry_id(reportProblemForm2.getCountryId());
			reportDom.setPincode(reportProblemForm2.getZipcode());
			reportDom.setLandline_no(reportProblemForm2.getContact());
			reportDom.setSubject(reportProblemForm2.getSubject());
			reportDom.setProblem(reportProblemForm2.getProblem());
			reportDom.setNumIsValid(1);
			reportDom.setDtTrDate(new Date());
			reportDom.setNumTrUserId(100);
			reportDom.setMobile(reportProblemForm2.getMobile());
		
			
			//  System.out.println("Doc Id " + reportProblemForm.getNumDocId());
			//  if
			//  (reportProblemForm.getNumDocId() == 0)
			//  {
			//	  reportDom.setDoc_id(0);
			// }
			//  else
			//  {
			//  reportDom.setDoc_id(reportProblemForm.getNumDocId());
			//  }
			
			
				
			//	System.err.println("Doc Id " +reportProblemForm.getStrDocId().trim());
				
			
			//	if (reportProblemForm.getStrDocId().equals("-1"))
			//	{
			//		reportDom.setDoc_id(0);
			//	}
			//	else
			//	{
			//		reportDom.setDoc_id(Integer.parseInt(encodedservice.decode(reportProblemForm.getStrDocId().trim().toString())));
					
					
			//	}
		      
		      
		     reportDom.setLandline_no(reportProblemForm2.getContact());
		      
		     reportDom.setSubject(reportProblemForm2.getSubject());
		      
		      reportDom.setEntry_date(new Date());
		     
		      reportDom.setPincode(reportProblemForm2.getZipcode());
		      
		      reportDom.setCountry_id(reportProblemForm2.getCountryId());
			  return reportDao.addReportProblem(reportDom);
	}

	public ReportProblemDomain updateFeedbackMasterForCDAC(ReportProblemForm reportForm, List<ReportProblemDomain> list, HttpServletRequest request) {
		ReportProblemDomain reportDom = new ReportProblemDomain();
		reportDom.setUser_name(list.get(0).getUser_name());
		reportDom.setOrg_name(list.get(0).getOrg_name());
		reportDom.setProblem(list.get(0).getProblem());
		reportDom.setAddress(list.get(0).getAddress());
		reportDom.setDesignation(list.get(0).getDesignation());
		reportDom.setEmail_id(list.get(0).getEmail_id());
		reportDom.setNumIsValid(1);
		reportDom.setDtTrDate(new Date());
		reportDom.setNumTrUserId(100);
		reportDom.setMobile(list.get(0).getMobile());
	    System.out.println("Doc Id " + list.get(0).getDoc_id());
		reportDom.setDoc_id(list.get(0).getDoc_id());
	    reportDom.setLandline_no(list.get(0).getLandline_no());
	    reportDom.setSubject(list.get(0).getSubject());
	    reportDom.setEntry_date(new Date());
	    reportDom.setPincode(list.get(0).getPincode());
	    reportDom.setCountry_id(list.get(0).getCountry_id());
	    reportDom.setProblem_no(list.get(0).getProblem_no());
	    reportDom.setStrReply(list.get(0).getStrReply());
	    reportDom.setReplyStatus(list.get(0).getReplyStatus());
	    
		reportDom.setProblem_id(reportForm.getProblem_id());
		//reportDom.setNumCdacIssueType(reportForm.getCdacIssueType());
		reportDom.setNumCdacStatus(1);
		
		/*
		 * String strCdacRem = reportForm.getCdacRemarks(); strCdacRem =
		 * strCdacRem.replaceFirst("\\n", " "); reportDom.setStrCdacRemarks(strCdacRem);
		 */
		reportDom.setStrCdacRemarks(reportForm.getCdacRemarks());
		reportDom.setNumIssueStatus(4);
		//reportDom.setStrAssignedTo(reportForm.getAssignedTo().trim());
		return reportDao.updateReportProblem(reportDom);
	}
	
	public ReportProblemDomain updateFeedbackMasterProblemStatus(ReportProblemForm reportForm, List<ReportProblemDomain> list, HttpServletRequest request) {
		ReportProblemDomain reportDom = new ReportProblemDomain();
		reportDom.setUser_name(list.get(0).getUser_name());
		reportDom.setOrg_name(list.get(0).getOrg_name());
		reportDom.setProblem(list.get(0).getProblem());
		reportDom.setAddress(list.get(0).getAddress());
		reportDom.setDesignation(list.get(0).getDesignation());
		reportDom.setEmail_id(list.get(0).getEmail_id());
		reportDom.setNumIsValid(1);
		reportDom.setDtTrDate(new Date());
		reportDom.setNumTrUserId(100);
		reportDom.setMobile(list.get(0).getMobile());
	    System.out.println("Doc Id " + list.get(0).getDoc_id());
		reportDom.setDoc_id(list.get(0).getDoc_id());
	    reportDom.setLandline_no(list.get(0).getLandline_no());
	    reportDom.setSubject(list.get(0).getSubject());
	    reportDom.setEntry_date(new Date());
	    reportDom.setPincode(list.get(0).getPincode());
	    reportDom.setCountry_id(list.get(0).getCountry_id());
	    reportDom.setProblem_no(list.get(0).getProblem_no());
	    reportDom.setStrReply(list.get(0).getStrReply());
	    reportDom.setReplyStatus(list.get(0).getReplyStatus());
		reportDom.setNumCdacIssueType(list.get(0).getNumCdacIssueType());
		reportDom.setNumCdacStatus(list.get(0).getNumCdacStatus());
		reportDom.setStrCdacRemarks(list.get(0).getStrCdacRemarks());
	    
		reportDom.setProblem_id(reportForm.getProblem_id());
		reportDom.setNumIssueStatus(reportForm.getIssueStaus());
		reportDom.setStrAssignedTo(reportForm.getAssignedTo().trim());
		return reportDao.updateReportProblem(reportDom);
	}
	public static String reverse(String input) {
		char[] in = input.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}
}
