package in.cdacnoida.dava.model;

public  class RCMCModel {
	/*
	 * private String IEC_no; private String SSI_No;
	 */
		 private String RCMC_No;
		 
		 public String getRCMC_No() { return RCMC_No; }
		 public void setRCMC_No(String RCMC_No) { this.RCMC_No = RCMC_No; }
	/*
	 * private String Org_Name; private String SSI_type; private String Cont_Desg;
	 * private String Org_FaxNo; private String Org_PAN_No; private String
	 * IEC_Issuedt; private String Member_Code; private String Org_Address; private
	 * String Org_EmailID; private String Org_PinCode; private String Org_Website;
	 * private String Org_stateid; private String RCMC_Status; private String
	 * SSI_Issuedt; private String Cont_EmailID; private String RCMC_IssueDt;
	 * Manf_SiteData Manf_SiteDataObject; private String Org_ContactNo; private
	 * String Applicant_Type; private String Cont_Mobile_no; private String
	 * RCMC_ReIssueDt; private String Cont_personname; private String
	 * RCMC_DueDtRenew; private String IEC_IssueAthority;
	 * 
	 * 
	 * // Getter Methods
	 * 
	 * public String getIEC_no() { return IEC_no; }
	 * 
	 * public String getSSI_No() { return SSI_No; }
	 * 
	 * public String getRCMC_No() { return RCMC_No; }
	 * 
	 * public String getOrg_Name() { return Org_Name; }
	 * 
	 * public String getSSI_type() { return SSI_type; }
	 * 
	 * public String getCont_Desg() { return Cont_Desg; }
	 * 
	 * public String getOrg_FaxNo() { return Org_FaxNo; }
	 * 
	 * public String getOrg_PAN_No() { return Org_PAN_No; }
	 * 
	 * public String getIEC_Issuedt() { return IEC_Issuedt; }
	 * 
	 * public String getMember_Code() { return Member_Code; }
	 * 
	 * public String getOrg_Address() { return Org_Address; }
	 * 
	 * public String getOrg_EmailID() { return Org_EmailID; }
	 * 
	 * public String getOrg_PinCode() { return Org_PinCode; }
	 * 
	 * public String getOrg_Website() { return Org_Website; }
	 * 
	 * public String getOrg_stateid() { return Org_stateid; }
	 * 
	 * public String getRCMC_Status() { return RCMC_Status; }
	 * 
	 * public String getSSI_Issuedt() { return SSI_Issuedt; }
	 * 
	 * public String getCont_EmailID() { return Cont_EmailID; }
	 * 
	 * public String getRCMC_IssueDt() { return RCMC_IssueDt; }
	 * 
	 * public Manf_SiteData getManf_SiteData() { return Manf_SiteDataObject; }
	 * 
	 * public String getOrg_ContactNo() { return Org_ContactNo; }
	 * 
	 * public String getApplicant_Type() { return Applicant_Type; }
	 * 
	 * public String getCont_Mobile_no() { return Cont_Mobile_no; }
	 * 
	 * public String getRCMC_ReIssueDt() { return RCMC_ReIssueDt; }
	 * 
	 * public String getCont_personname() { return Cont_personname; }
	 * 
	 * public String getRCMC_DueDtRenew() { return RCMC_DueDtRenew; }
	 * 
	 * public String getIEC_IssueAthority() { return IEC_IssueAthority; }
	 * 
	 * // Setter Methods
	 * 
	 * public void setIEC_no(String IEC_no) { this.IEC_no = IEC_no; }
	 * 
	 * public void setSSI_No(String SSI_No) { this.SSI_No = SSI_No; }
	 * 
	 * public void setRCMC_No(String RCMC_No) { this.RCMC_No = RCMC_No; }
	 * 
	 * public void setOrg_Name(String Org_Name) { this.Org_Name = Org_Name; }
	 * 
	 * public void setSSI_type(String SSI_type) { this.SSI_type = SSI_type; }
	 * 
	 * public void setCont_Desg(String Cont_Desg) { this.Cont_Desg = Cont_Desg; }
	 * 
	 * public void setOrg_FaxNo(String Org_FaxNo) { this.Org_FaxNo = Org_FaxNo; }
	 * 
	 * public void setOrg_PAN_No(String Org_PAN_No) { this.Org_PAN_No = Org_PAN_No;
	 * }
	 * 
	 * public void setIEC_Issuedt(String IEC_Issuedt) { this.IEC_Issuedt =
	 * IEC_Issuedt; }
	 * 
	 * public void setMember_Code(String Member_Code) { this.Member_Code =
	 * Member_Code; }
	 * 
	 * public void setOrg_Address(String Org_Address) { this.Org_Address =
	 * Org_Address; }
	 * 
	 * public void setOrg_EmailID(String Org_EmailID) { this.Org_EmailID =
	 * Org_EmailID; }
	 * 
	 * public void setOrg_PinCode(String Org_PinCode) { this.Org_PinCode =
	 * Org_PinCode; }
	 * 
	 * public void setOrg_Website(String Org_Website) { this.Org_Website =
	 * Org_Website; }
	 * 
	 * public void setOrg_stateid(String Org_stateid) { this.Org_stateid =
	 * Org_stateid; }
	 * 
	 * public void setRCMC_Status(String RCMC_Status) { this.RCMC_Status =
	 * RCMC_Status; }
	 * 
	 * public void setSSI_Issuedt(String SSI_Issuedt) { this.SSI_Issuedt =
	 * SSI_Issuedt; }
	 * 
	 * public void setCont_EmailID(String Cont_EmailID) { this.Cont_EmailID =
	 * Cont_EmailID; }
	 * 
	 * public void setRCMC_IssueDt(String RCMC_IssueDt) { this.RCMC_IssueDt =
	 * RCMC_IssueDt; }
	 * 
	 * public void setManf_SiteData(Manf_SiteData Manf_SiteDataObject) {
	 * this.Manf_SiteDataObject = Manf_SiteDataObject; }
	 * 
	 * public void setOrg_ContactNo(String Org_ContactNo) { this.Org_ContactNo =
	 * Org_ContactNo; }
	 * 
	 * public void setApplicant_Type(String Applicant_Type) { this.Applicant_Type =
	 * Applicant_Type; }
	 * 
	 * public void setCont_Mobile_no(String Cont_Mobile_no) { this.Cont_Mobile_no =
	 * Cont_Mobile_no; }
	 * 
	 * public void setRCMC_ReIssueDt(String RCMC_ReIssueDt) { this.RCMC_ReIssueDt =
	 * RCMC_ReIssueDt; }
	 * 
	 * public void setCont_personname(String Cont_personname) { this.Cont_personname
	 * = Cont_personname; }
	 * 
	 * public void setRCMC_DueDtRenew(String RCMC_DueDtRenew) { this.RCMC_DueDtRenew
	 * = RCMC_DueDtRenew; }
	 * 
	 * public void setIEC_IssueAthority(String IEC_IssueAthority) {
	 * this.IEC_IssueAthority = IEC_IssueAthority; } } class Manf_SiteData { private
	 * String Manf_Licno; private String Manuf_site_City; private String
	 * Manuf_site_Name; private String Manuf_site_Address; private String
	 * Manuf_site_PinCode; private String Manuf_site_stateid;
	 * 
	 * 
	 * // Getter Methods
	 * 
	 * public String getManf_Licno() { return Manf_Licno; }
	 * 
	 * public String getManuf_site_City() { return Manuf_site_City; }
	 * 
	 * public String getManuf_site_Name() { return Manuf_site_Name; }
	 * 
	 * public String getManuf_site_Address() { return Manuf_site_Address; }
	 * 
	 * public String getManuf_site_PinCode() { return Manuf_site_PinCode; }
	 * 
	 * public String getManuf_site_stateid() { return Manuf_site_stateid; }
	 * 
	 * // Setter Methods
	 * 
	 * public void setManf_Licno(String Manf_Licno) { this.Manf_Licno = Manf_Licno;
	 * }
	 * 
	 * public void setManuf_site_City(String Manuf_site_City) { this.Manuf_site_City
	 * = Manuf_site_City; }
	 * 
	 * public void setManuf_site_Name(String Manuf_site_Name) { this.Manuf_site_Name
	 * = Manuf_site_Name; }
	 * 
	 * public void setManuf_site_Address(String Manuf_site_Address) {
	 * this.Manuf_site_Address = Manuf_site_Address; }
	 * 
	 * public void setManuf_site_PinCode(String Manuf_site_PinCode) {
	 * this.Manuf_site_PinCode = Manuf_site_PinCode; }
	 * 
	 * public void setManuf_site_stateid(String Manuf_site_stateid) {
	 * this.Manuf_site_stateid = Manuf_site_stateid; }
	 */
		}
	
	
	

