package in.cdacnoida.dava.service;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import in.cdacnoida.dava.entities.ConsignmentDetailDomain;
import in.cdacnoida.dava.entities.AppUserLogs;
import in.cdacnoida.dava.entities.ApplicantTypeMasterDomain;
import in.cdacnoida.dava.entities.ApprovalPremisesDetail;
import in.cdacnoida.dava.entities.CodeRequestMstDomain;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DesktopConfigDtlDom;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.EmailMstDomain;
import in.cdacnoida.dava.entities.EmailSchedulerEntity;
import in.cdacnoida.dava.entities.NewsEventMstDomain;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.InstituteMasterDomain;
import in.cdacnoida.dava.entities.InstituteMemberDetailDomain;
import in.cdacnoida.dava.entities.LicPremiseDtlDomain;
import in.cdacnoida.dava.entities.LicenseTypeMstDomain;
import in.cdacnoida.dava.entities.MemberTypeMasterDomain;
import in.cdacnoida.dava.entities.NewsEventsDomain;
import in.cdacnoida.dava.entities.PasswordHistory;
import in.cdacnoida.dava.entities.PointOfDistributionMst;
import in.cdacnoida.dava.entities.PortOfExportDomain;
import in.cdacnoida.dava.entities.ProcurementMstDomain;
import in.cdacnoida.dava.entities.PromotionCouncilMaster;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.entities.SeatMaster;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.TileDomain;
import in.cdacnoida.dava.entities.UploadConsignDtlDomain;
import in.cdacnoida.dava.entities.UploadInvoiceDtlDomain;
import in.cdacnoida.dava.entities.UploadPurchaseOrderDtlDom;
import in.cdacnoida.dava.entities.UploadXmlDataDtlDomain;
import in.cdacnoida.dava.entities.UploadXmlDataDtlLogDomain;
import in.cdacnoida.dava.entities.UploadXmlInvoiceDtlDomain;
import in.cdacnoida.dava.entities.WorkshopRegistrationDomain;
import in.cdacnoida.dava.entities.ZoneMst;
import in.cdacnoida.dava.entities.galleryFormentity;
import in.cdacnoida.dava.model.AppUserLogsForm;
import in.cdacnoida.dava.model.ConfigDtl;
import in.cdacnoida.dava.model.DrugDtlsModel;
import in.cdacnoida.dava.model.EXP_TERTIARY_LIST;
import in.cdacnoida.dava.model.ExportOrderModel;
import in.cdacnoida.dava.model.GeneratePackModel;
import in.cdacnoida.dava.model.HibernateSearchModel;
import in.cdacnoida.dava.model.HostRegistrationForm;
import in.cdacnoida.dava.model.MANUFACTURE_SCHEMA_LIST;
import in.cdacnoida.dava.model.MemberAddDtlModel;
import in.cdacnoida.dava.model.MemberDetailForm;
import in.cdacnoida.dava.model.NewsEventsModel;
import in.cdacnoida.dava.model.OffRegModel;
import in.cdacnoida.dava.model.OfficialForm;
import in.cdacnoida.dava.model.PRODUCT_SCHEMA_LIST;
import in.cdacnoida.dava.model.PointOfDistributionModel;
import in.cdacnoida.dava.model.PortOfExportModel;
import in.cdacnoida.dava.model.ProcurementMstModel;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.model.UploadDataForm;
import in.cdacnoida.dava.model.WorkshopRegistrationModel;
import in.cdacnoida.dava.model.galleryForm;

public interface DavaServices {

	List<CountryMst> getCountryNames();

	List<DistrictMst> getDistrictNames(Integer stateId);

	List<StatesMst> getStatedata(Integer countryId);
	
	List<RegistrationDetails> getUserId();

	RegistrationDetails saveUser(RegistrationForm registrationForm);

	RegistrationForm getRcmcData(String rcmcNumber);

	RegistrationDetails verifyUserEmail(String decode, int randomCode);

	
	void verifyUserEmailfail(String decode, int randomCode);
	
	boolean checkUserNameExist(String userName);

	String generateJSONObject(String string, String searchTerm, String query, int sAmount, int sStart);
	
	String RCMCData(String data);

	String ShowRCMCData(HttpServletRequest request);

	List<ApplicantTypeMasterDomain> getApplicantTypeList();

	List<ApplicantTypeMasterDomain> getApplicantTypeListName(int numUserTypeId);

	List<LicenseTypeMstDomain> getLicenseType();
	
	List<LicenseTypeMstDomain> getLicenseTypeForExp();

	InstPremiseDtlDomain addInstPreDetail(MemberAddDtlModel memberAddDtlModel, HttpServletRequest request);

	LicPremiseDtlDomain addLicPreDetail(MemberAddDtlModel memberAddDtlModel, Integer premisesNo, HttpServletRequest request);

	List<MemberTypeMasterDomain> getMemberType();

	List<NewsEventMstDomain> getEventType();

	InstituteMemberDetailDomain saveMemberDetails(MemberDetailForm memDtlForm, HttpServletRequest request);

	String addDrugMstDetail(DrugDtlsModel drugDtlsModel, HttpServletRequest request);

	void updateDocumentMstPath(String path, int numDocId);

	ApprovalPremisesDetail addAppPremisesDtls(MemberAddDtlModel memberAddDtlModel, Integer premisesNo, HttpServletRequest request);

	String ShowDrugDetails(HttpServletRequest request);
	
	String ShowDrugDetailsBD(HttpServletRequest request);
	
	String ShowAllDrugDetails(HttpServletRequest request, Long UserId);
	
	String ShowUploadXmlDetails(HttpServletRequest request, int numTypeId);
	
	String ShowAllUploadXmlDetails(HttpServletRequest request, Integer company, Date dateFromDate, Date dateToDate);
	
	String ShowXmlDiscription(HttpServletRequest request);

	DrugMst updateDrugDetails(DrugDtlsModel drugDtlsModel, HttpServletRequest request);

	DrugMst deleteDrugDetails(DrugDtlsModel drugDtlsModel, HttpServletRequest request);

	String getMemberSiteDtlXML(Integer premisesNo);

	RegistrationDetails findByUserName(String loogedInUserId);

	List<OfficialForm> getMenu(int roleId) throws SQLException;

	List<SeatMaster> getSeatMstData(Integer numSeatId);

	String updateSeatMaster(long userId);

	List<TileDomain> getTile(Integer numRoleId);

	List<InstPremiseDtlDomain> getPremiseAddress(Integer manufactureId);
	
	RegistrationDetails saveManufUser(RegistrationForm registrationForm,String VarificatioLink);
	
	RegistrationDetails saveOffReg(OffRegModel registrationForm);
	

	String showManufSiteUserList(HttpServletRequest request);

	String showAddedMemberList(HttpServletRequest request);

	InstituteMemberDetailDomain deleteMemberDetails(MemberDetailForm memDtlForm);

	List<InstituteMemberDetailDomain> getAddedMemberData(int memberId);

	String ShowManufacturingSiteListing(HttpServletRequest request);

	InstituteMemberDetailDomain updateMemberDetails(MemberDetailForm memDtlForm, HttpServletRequest request);

	List<ReportProblemDomain> getProblemDeatil(int problem_id);

	UploadXmlDataDtlDomain saveUploadDataDtl(String finalName, int doc_size, int doc_id, Path path1, int purposeType) throws IOException;
	
	UploadXmlDataDtlDomain saveUploadDesktopDataDtl(String finalName, int doc_size, int doc_id, Path path1, int purposeType, long userId, String xmlData) throws IOException;

	List<String> getUploadedData();
	
	String createJSONManufacturingSiteDetail(Integer numPremiseNo);

	List<InstPremiseDtlDomain> getAllPremiseDtls(Integer numPremiseNo);

	String ShowRegistrationPendingListing(HttpServletRequest request);

	String ShowApprovedRegistrationListing(HttpServletRequest request);
	
	String ShowRejectedRegistrationListing(HttpServletRequest request);

	String ShowFeedbackResponseListing(HttpServletRequest request);

	void updateUserRegForApprovalDetails(RegistrationForm registrationForm, Long userId,String userName, HttpServletRequest request);

	void updateUserRegForRejectionDetails(RegistrationForm registrationForm, Long userId, String userName,HttpServletRequest request);

	boolean updatePasswordcnf(RegistrationForm registrationForm);

	void updateInstPremiseDtl(int manuUnit, Long userId);

	

	
	

	String saveProductInTable(Integer upId,String fileasString, Integer instId);
	
	void updateFinalStatus(int docId, String xmlPreview);
	
	void updateFinalStatus(int docId, StringBuffer xmlPreview);

	String setConfigDetails(ConfigDtl configdtl);
	
	boolean saveManufacturerInTable(String fileasString);

	boolean verifyPasswords(String rawPassword, String encodedPassword);

	boolean savePackingInTable(String fileasString);
	
	List<DrugMst> getProductNames(Integer InstId);
	
	List<DrugMst> getProductNames();

	List<CountryMst> getCountrybasedOnRegion(Integer regionId);

	boolean saveExportOrderDetails(ExportOrderModel exportOrderModel);

	ConsignmentDetailDomain saveConsignmentDetails(EXP_TERTIARY_LIST exp_tertiary_list, int docId);

	InstPremiseDtlDomain saveManufacturePremiseDetails(MANUFACTURE_SCHEMA_LIST manufacture_schema_list, int docId);

	DrugMst saveProductDetails(PRODUCT_SCHEMA_LIST prod_schema_list, int docId);

	List<DrugMst> getProductCode(Integer drugId);

	ProcurementMstDomain addProcurementDetailDom(ProcurementMstModel procurementMstModel, HttpServletRequest request);

	String ShowProcurementDetails(HttpServletRequest request);
	
	
	Map<String,List<Long>> getStateStatistics(Long userId);
	List<MemberAddDtlModel> getSitesDisplay(int stateID);

	Map<String, Integer> getCountryStatistics(Long userId);

	String checkAlreadtRegWithNumber(String rcmcNumber);

	String findByiecNumber(String iecNumber);

	String findBygstnNumber(String gstnNumber);

	String checkIecNumber(String iecNumber);

	String checkGstnNumber(String gstnNumber);

	List<RegistrationDetails> getRegistrationData();

	boolean checkIfValidOldPassword(RegistrationDetails registrationDetails, String oldPassword);

	String createJSONTilesData(String tilesfuncName, Integer numInstId, Long userId);

	List<HibernateSearchModel> getSolrSearchResults(String searchInput, String string, boolean b);

	List<HibernateSearchModel> getDatabaseSearchResults(String searchString);

	List<InstituteMasterDomain> getInstituteData(int instId);

	WorkshopRegistrationDomain addWorkshopRegistration(WorkshopRegistrationModel workshopRegistrationModel,
			HttpServletRequest request);	
	

	void updatePublicKeyInUR(Long userId, String mac_address, String publicKey);

	CodeRequestMstDomain addGeneratePackCode(GeneratePackModel generatePackModel, HttpServletRequest request);

	String ShowGeneratePackCode(HttpServletRequest request);

	Integer saveConsignmentDetailsInTable(Integer uploadId);

	UploadXmlDataDtlDomain saveUploadACkDtl(String finalName, int doc_id,String path);

	RegistrationForm getUserDetails(Long userId);

	void updateUserProfile(RegistrationForm registrationForm);
	void addEmailDetailsToDb(Long userId, String userName, String subject, String body, HttpServletRequest req);

	EmailMstDomain addDataToEmailMst(String string, HttpServletRequest req);

	String showEmailData(HttpServletRequest request);
	galleryFormentity savegalleryform(galleryForm fv,HttpServletRequest request);
	String formattedDate(Date date);

	List<galleryForm> getEventlist(String limit);
	String deletegallerydetail(Long galleryId);

	PortOfExportDomain savePortOfExport(PortOfExportModel portOfExportModel, HttpServletRequest request);

	NewsEventsDomain saveNewsEvents(NewsEventsModel newsEventsModel, HttpServletRequest request);

	String ShowPortOfExport(HttpServletRequest request);

	String totalRecall(Integer upId, Long userId);

	UploadXmlDataDtlLogDomain saveUploadDataLogDtl(String finalName, int doc_size, int doc_id, Path path1,
			int purposeType, String xmlfileString) throws IOException;

	UploadXmlDataDtlLogDomain getUploadedDataLog(int docId);

	UploadXmlDataDtlDomain saveUploadDataDtlfromLog(UploadXmlDataDtlLogDomain dom);

	void indexSearchPageDB(String freshImport);

	boolean checkPasswordHistory();

	boolean checkPasswordHistory(List<PasswordHistory> passwordList, String password);

	RegistrationDetails updateManufUserDetail(RegistrationForm registrationForm, HttpServletRequest request);

	RegistrationDetails deleteManufUserDetail(RegistrationForm registrationForm);
	
	
	InstPremiseDtlDomain deletemanusite(MemberAddDtlModel MemberAddDtlModel);

	Object getSearchXMLResults(String searchString);
	
	String GetRecalledUploadedXML(HttpServletRequest request, int numTypeId);

	void saveApprovalTypeMst(String type, String remarks, HttpServletRequest request);

	List<RegistrationDetails> fetchRegistrationData(Long company, HttpServletRequest request);

	String saveOfficialRegistration(RegistrationForm registrationForm);

	List<ZoneMst> getZoneDetails();

	List<PromotionCouncilMaster> getPromotionCouncil();

	List<RegistrationDetails> getRegistrationDataWithoutRegEmail();

	EmailSchedulerEntity getSentEmailCount(String userName);

	void updateEmailCount(Integer count);

	void saveEmailEntity(EmailSchedulerEntity emailScheduledEntity);

	PointOfDistributionMst savePointOfDistributionMst(PointOfDistributionModel distributionModel, HttpServletRequest request);

	String loadAllPointsOfDistributionDetails(HttpServletRequest request);

	void loadStatisticsFunc();
	
	//void expirelink();

	String loadDeletedDrugDetails(HttpServletRequest request);
	
	List<ReportProblemDomain> getFeedbackResData();

	PortOfExportDomain updatePortOfExport(PortOfExportModel portOfExportModel, HttpServletRequest request);

	void deletePortOfExport(PortOfExportModel portOfExportModel, HttpServletRequest request);

	UploadXmlInvoiceDtlDomain updateConsignmentDtls(Integer upId, UploadDataForm uploadData);
	
	String ShowConsignUploadXmlDetails(HttpServletRequest request);

	String saveOfficialRegistration(@Valid HostRegistrationForm hostRegForm);

	String verifyOtp(HostRegistrationForm hostRegForm);

	String resendOtp(String emailId);

	String saveUserAppLogs(AppUserLogsForm appUserLogsForm);

	List<AppUserLogs> getAppSearchLogs();

	UploadConsignDtlDomain addConsignmentDtls(UploadDataForm uploadData, HttpServletRequest request);

	UploadPurchaseOrderDtlDom addPurOrderDtls(UploadDataForm uploadData, HttpServletRequest request);

	UploadInvoiceDtlDomain addInvoiceDetails(UploadDataForm uploadData, HttpServletRequest request);
	
	List<UploadXmlDataDtlDomain> getUploadedData(Integer uploadId);

	String ShowAllRegistrationDataListing(HttpServletRequest request, Integer i);
	
	String ShowAllUploadXmlDetails(HttpServletRequest request, Integer company);

	String ShowAllProductData(HttpServletRequest request, Integer prodType, Integer hscode);

	List<DesktopConfigDtlDom> findDesktopCongDtls(String userId);
	
	void loadPendingStatus_FeedbackResponses();

}
