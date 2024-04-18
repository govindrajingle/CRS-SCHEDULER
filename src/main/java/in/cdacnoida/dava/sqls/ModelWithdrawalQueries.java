package in.cdacnoida.dava.sqls;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelWithdrawalQueries {

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	String currentDate = formatter.format(new Date());
	
	//First Query
	private String queryForNewRecords = "SELECT model_withdrawal_ref_id from creit_model_withdrawal_master where str_status in('N','IE')  and (to_char(sysdate,'yyyymmdd')-to_char(req_date,'yyyymmdd')) > 2 and is_paused=0";

	//Second Query
	private String qryAppID = "select application_id from creit_model_withdrawal_master where model_withdrawal_ref_id= '?' ";
	
	//Third Query (assignment by GA)
	private String trackerUpdate ="update creit_model_withdrawal_tracker set str_status='RV' where num_proposal_id= '1?' and str_version_id='2?' and str_user_type='G' and mw_id='3?' and str_status<>'RV' ";
	
	//Fourth Query
	private String trackerInsert = "insert into creit_model_withdrawal_tracker (STR_ASSIGNED_TO, DT_ALLOTMENT_DATE, "
		    + "NUM_ALLOTED_DAYS, DT_TR_DATE, STR_TR_USER_ID, NUM_PROPOSAL_ID, STR_STATUS, STR_VERSION_ID, str_user_type, mw_id) "
		    + "values('dataclean', sysdate, 15, sysdate, 'Automatic', '1?', 'FO', '2?', 'G', '3?')";
	
	//Fifth Query
	private String trackerUpdateFive = "update creit_model_withdrawal_master set str_status='IE' where application_id= '1?' and str_version= '2?' and model_withdrawal_ref_id= '3?' ";
	
	//Sixth Query (decision by GA)
	private String trackerUpdateSix = "update creit_model_withdrawal_tracker set status_id='16',str_status='AC',dt_tr_date=sysdate,selected_models=(select String_agg(product_model,',') from creit_model_withdrawal_models where req_id= '1?') where str_assigned_to='dataclean' and num_proposal_id= '2?' and str_user_type='G' and mw_id= '3?'";
	
	//Seventh Query 
	private String trackerUpdateSeven = "update creit_model_withdrawal_master set str_status='AC',trans_date=sysdate where application_id= '1?'  and model_withdrawal_ref_id= '2?' ";
	
	//Eight Query
	private String trackerUpdateEight = "update creit_model_withdrawal_models set is_valid=1 where req_id= '1?' ";
	
	//Ninth Query (letter grant)
	private String trackerUpdateNine = "update creit_model_withdrawal_master set str_status='gr',trans_date=sysdate,trans_user_id='Automatic',endorsement_no= '1?',endorsement_dt=sysdate where application_id= '2?' and model_withdrawal_ref_id= '3?' ";

	//Tenth Query (mail content list)
	private String trackerUpdateTen = "select cmwm.model_withdrawal_ref_id,cmwm.application_id,cmwm.reg_number,to_char(cmwm.req_date,'dd-Mon-yyyy') as f1,trck.selected_models, " + 
            "to_char(trck.dt_tr_date,'dd-Mon-yyyy') as f2,get_user_email(cmwm.req_user_id ) from creit_model_withdrawal_master cmwm,creit_model_withdrawal_tracker trck " + 
            "WHERE trck.str_user_type='G' and trck.str_status='AC' and trck.num_proposal_id=cmwm.application_id and cmwm.application_id= '1?' "+
            "and cmwm.model_withdrawal_ref_id= '2?' and cmwm.model_withdrawal_ref_id=trck.mw_id";
	
	//Eleventh Query
	private String trackerUpdateEleven = "update creit_model_withdrawal_master set endorsement_mail= '1?',endorsement_mail_to_id= '2?',endorsement_mail_on_dt=sysdate,endorsement_mail_subject= '3?' "
            + "where application_id= '4?' and model_withdrawal_ref_id= '5?' ";
	
	//Twelfth Query
	private String trackerUpdateTwelfth = "update creit_model_withdrawal_master set str_status='RD' where application_id= '1?'and model_withdrawal_ref_id= '2?' ";
	
	public String getQueryForNewRecords() {
		return queryForNewRecords;
	}

	public void setQueryForNewRecords(String queryForNewRecords) {
		this.queryForNewRecords = queryForNewRecords;
	}

	public String getQryAppID() {
		return qryAppID;
	}

	public void setQryAppID(String qryAppID) {
		this.qryAppID = qryAppID;
	}

	public String getTrackerUpdate() {
		return trackerUpdate;
	}

	public void setTrackerUpdate(String trackerUpdate) {
		this.trackerUpdate = trackerUpdate;
	}

	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getTrackerInsert() {
		return trackerInsert;
	}

	public void setTrackerInsert(String trackerInsert) {
		this.trackerInsert = trackerInsert;
	}

	public String getTrackerUpdateFive() {
		return trackerUpdateFive;
	}

	public void setTrackerUpdateFive(String trackerUpdateFive) {
		this.trackerUpdateFive = trackerUpdateFive;
	}

	public String getTrackerUpdateSix() {
		return trackerUpdateSix;
	}

	public void setTrackerUpdateSix(String trackerUpdateSix) {
		this.trackerUpdateSix = trackerUpdateSix;
	}

	public String getTrackerUpdateSeven() {
		return trackerUpdateSeven;
	}

	public void setTrackerUpdateSeven(String trackerUpdateSeven) {
		this.trackerUpdateSeven = trackerUpdateSeven;
	}

	public String getTrackerUpdateEight() {
		return trackerUpdateEight;
	}

	public void setTrackerUpdateEight(String trackerUpdateEight) {
		this.trackerUpdateEight = trackerUpdateEight;
	}

	public String getTrackerUpdateNine() {
		return trackerUpdateNine;
	}

	public void setTrackerUpdateNine(String trackerUpdateNine) {
		this.trackerUpdateNine = trackerUpdateNine;
	}

	public String getTrackerUpdateTen() {
		return trackerUpdateTen;
	}

	public void setTrackerUpdateTen(String trackerUpdateTen) {
		this.trackerUpdateTen = trackerUpdateTen;
	}

	public String getTrackerUpdateEleven() {
		return trackerUpdateEleven;
	}

	public void setTrackerUpdateEleven(String trackerUpdateEleven) {
		this.trackerUpdateEleven = trackerUpdateEleven;
	}

	public String getTrackerUpdateTwelfth() {
		return trackerUpdateTwelfth;
	}

	public void setTrackerUpdateTwelfth(String trackerUpdateTwelfth) {
		this.trackerUpdateTwelfth = trackerUpdateTwelfth;
	}
}
