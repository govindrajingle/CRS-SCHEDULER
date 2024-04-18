package in.cdacnoida.dava.daoservice;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import in.cdacnoida.dava.entities.ApplicantTypeMasterDomain;
import in.cdacnoida.dava.entities.ApprovalPremisesDetail;
import in.cdacnoida.dava.entities.ApprovalTypeMst;
import in.cdacnoida.dava.entities.CodeRequestMstDomain;
import in.cdacnoida.dava.entities.ConsignmentDetailDomain;
import in.cdacnoida.dava.entities.ConsignmentDetailsEntity;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DataUploadTypeMstDomain;
import in.cdacnoida.dava.entities.DesktopConfigDtlDom;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.DocumentMasterDomain;
import in.cdacnoida.dava.entities.DrugDosageMst;
import in.cdacnoida.dava.entities.DrugMonographMst;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.DrugScheduleMst;
import in.cdacnoida.dava.entities.DrugTypeMst;
import in.cdacnoida.dava.entities.EXPORT_DETAILS;
import in.cdacnoida.dava.entities.EXP_TERTIARY_LIST_DETAILS;
import in.cdacnoida.dava.entities.EmailDetailDomain;
import in.cdacnoida.dava.entities.EmailMstDomain;
import in.cdacnoida.dava.entities.ExportOrderDomain;
import in.cdacnoida.dava.entities.HSCodeDomain;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.InstituteMasterDomain;
import in.cdacnoida.dava.entities.InstituteMemberDetailDomain;
import in.cdacnoida.dava.entities.LicPremiseDtlDomain;
import in.cdacnoida.dava.entities.LicenseTypeMstDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.MemberTypeMasterDomain;
import in.cdacnoida.dava.entities.NewsEventMstDomain;
import in.cdacnoida.dava.entities.NewsEventsDomain;
import in.cdacnoida.dava.entities.OfficialRegistrationDetails;
import in.cdacnoida.dava.entities.OtherPromotionCouncilDetails;
import in.cdacnoida.dava.entities.PackUnitMst;
import in.cdacnoida.dava.entities.PasswordHistory;
import in.cdacnoida.dava.entities.PointOfDistributionMst;
import in.cdacnoida.dava.entities.PortOfExportDomain;
import in.cdacnoida.dava.entities.ProcurementMstDomain;
import in.cdacnoida.dava.entities.ProductDetails;
import in.cdacnoida.dava.entities.PromotionCouncilMaster;
import in.cdacnoida.dava.entities.RcmcRegistrationData;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.entities.SECONDARY1_DETAILS;
import in.cdacnoida.dava.entities.SECONDARY2_DETAILS;
import in.cdacnoida.dava.entities.SECONDARY3_DETAILS;
import in.cdacnoida.dava.entities.SeatMaster;
import in.cdacnoida.dava.entities.SiteTypeMstDomain;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.StaticsDataDomain;
import in.cdacnoida.dava.entities.StorageCondMstDom;
import in.cdacnoida.dava.entities.TERTIRY_DETAILS;
import in.cdacnoida.dava.entities.TherepueticClassDom;
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
import in.cdacnoida.dava.model.MemberDetailForm;
import in.cdacnoida.dava.model.OfficialForm;

public interface DavaDaoServices {

	List<CountryMst> getCountryNames();

	List<DistrictMst> getDistrictNames(Integer stateId);

	List<StatesMst> getStatedata(Integer countryId);
	
	List<RegistrationDetails> getUserId();

	RegistrationDetails saveUser(RegistrationDetails registrationDetails);

	RcmcRegistrationData getRcmcData(String rcmcNumber);

	String generateJSONObject(String fun, String searchTerm, String query, int sAmount, int sStart);

	List<ApplicantTypeMasterDomain> getApplicantTypeList();

	List<ApplicantTypeMasterDomain> getApplicantTypeListName(int numUserTypeId);

	List<LicenseTypeMstDomain> getLicTypeList();
	
	List<LicenseTypeMstDomain> getLicTypeListForExp();

	InstPremiseDtlDomain addPremisesDtls(InstPremiseDtlDomain instDom);

	LicPremiseDtlDomain addLicwnsePremisesDtls(LicPremiseDtlDomain licPreDtlDom);

	List<MemberTypeMasterDomain> getMemberTypeList();

	List<NewsEventMstDomain> getEventTypeList();

	InstituteMemberDetailDomain addMemberDetails(InstituteMemberDetailDomain instMemDtlDomain);

	List<DrugTypeMst> getDrugType();

	List<DrugMonographMst> getDrugMonoType();

	List<DrugScheduleMst> getDrugSchType();

	List<PackUnitMst> getPackUnitType();

	List<DrugDosageMst> getDrugDoseType();

	DrugMst addDrugDtls(DrugMst drugDom);

	int addDocument(DocumentMasterDomain docMst);

	void updateDocumentSizeQuery(int doc_id, int doc_size);

	void updateDocumentMstPath(String path, int numDocId);

	String getDocumentFileNameQuery(int doc_id);

	String getDocumentFileNameForDownloadQuery(int doc_id);

	List<ApprovalTypeMst> getApprovalType();

	ApprovalPremisesDetail addApprovalPremisesDtls(ApprovalPremisesDetail appPreDtls);

	List<InstPremiseDtlDomain> getInstPremisesDtls(Integer InstituteId);

	DrugMst modifyDrugDetails(DrugMst drugDom);

	DrugMst deleteDrugDetails(DrugMst drugDom);

	String generateReportSiteDtlXML(Integer premisesNo);
	
	List<OfficialForm> getMenu(int roleId) throws SQLException;

	List<SeatMaster> getSeatMstData(Integer numSeatId);

	String AddSeatMaster(long userId);
	
	// Added by Manibhusahn
	
	String getProfilePercentage(int seatId);
	
	
	List<TileDomain> getTile(Integer numRoleId);


	List<HSCodeDomain> getHSCodeDtls();

	List<InstPremiseDtlDomain> getInstPremisesDtlsById(int manuUnit);

	/* int getManuName(int userId); */

	List<RegistrationDetails> getUserDetails(String loogedInUserId);
	
	List<RegistrationDetails> getRegistrationDetails(Long UserId);
	
	List<DataUploadTypeMstDomain> getDataUploadType();

	List<StorageCondMstDom> getStorageCondition();

	List<InstPremiseDtlDomain> getPremiseAddress(Integer manufactureId);

	InstituteMemberDetailDomain deleteMemberDetails(MemberDetailForm memDtlForm);

	List<InstituteMemberDetailDomain> getAddedMemberData(int memberId);

	InstituteMemberDetailDomain updateMemberDetails(InstituteMemberDetailDomain instMemDtlDomain);
	
	UploadXmlDataDtlDomain saveUploadDtl(UploadXmlDataDtlDomain uploadDomain);

	List<String> getuploadedDataDtl();

	void updateInstPremiseDtl(int manuUnit, Long userId);

	List<InstPremiseDtlDomain> getInstPremisesDtlsForSublogin(Integer InstId);

	String createJSONManufacturingSiteDtls(Integer numPremiseNo);

	List<InstPremiseDtlDomain> getInstPremiseDtls(Integer numPremiseNo);

	List<ReportProblemDomain> getProblemDeatil(int problem_id);

	String getRCMCRegData(String data);
	
	String saveProductInTable(Integer upId,String fileasString, Integer instId);

	void updateFinalStatus(int docId, String previewXml);
	
	void updateFinalStatus(int docId, StringBuffer previewXml);

	void saveConfigDtls(DesktopConfigDtlDom dskConDom);

	void saveOtherPromotionCouncil(OtherPromotionCouncilDetails otherPromotionCouncilDetails);

	boolean saveManufacturingInTable(String fileasString);
	
	boolean savePackagingInTable(String fileasString);

	List<TherepueticClassDom> getTherepueticClass();

	ConsignmentDetailDomain saveConsignmentDetails(ConsignmentDetailDomain consignmentDetailDomain);
	
	List<DrugMst> getProductNames();
	
	List<DrugMst> getProductNames(Integer InstId);

	List<CountryMst> getCountrybasedOnRegion(Integer regionId);

	boolean saveExportOrderDetails(ExportOrderDomain exportOrderDomain);

	InstPremiseDtlDomain savePremiseDetails(InstPremiseDtlDomain premiseDetails);

	void saveDrugMasterDetails(DrugMst drug);

	List<ExportOrderDomain> getExpOderDtl();

	List<DrugMst> getProdCode(Integer drugId);

	ProcurementMstDomain saveProcurementMasterDetails(ProcurementMstDomain pmDom);

	void persistConsignmentDetailEntities(EXP_TERTIARY_LIST_DETAILS exp,
			ConsignmentDetailsEntity consignmentDetailsEntity, EXPORT_DETAILS exportDetails);

	void addTertiaryDetails(TERTIRY_DETAILS tertiaryDetails);

	void addSecondary3Details(SECONDARY3_DETAILS secondary3Details);

	void addSecondary2Details(SECONDARY2_DETAILS secondary2Details);

	void addSecondary1Details(SECONDARY1_DETAILS secondary1Details);

	void addProductdetails(ProductDetails productDetails);

	Map<String, List<Long>> getStateStatistics(Long userId);

	List<InstPremiseDtlDomain> getSitesDisplay(int stateID);

	Map<String, Integer> getCountryStatistics(Long userId);

	void updateKeyinRegistration(Long userId, String mac_address, String publicKey);

	String createJSONTilesData(String tilesfuncName, Integer numInstId, Long numTrUserId);

	List<InstituteMasterDomain> getInstData(int instId);

	WorkshopRegistrationDomain saveWorkshopRegistration(WorkshopRegistrationDomain wd, HttpServletRequest request);


	

	CodeRequestMstDomain saveCodeRequest(CodeRequestMstDomain dom);
	List<UploadXmlDataDtlDomain> getUploadedeData(int docId);

	Integer getUploadedDetails(Integer uploadId);

	String getPackCode(Integer requestId);

	String getduplicateCodes(String xmlData);
	
	String getConsignmentDetails(int invId);

	String getAckDocumentFileNameForDownload(int doc_id);
	void addEmailDetailsToDb(EmailDetailDomain emailDom);

	EmailMstDomain saveEmailMst(EmailMstDomain emd);
	PortOfExportDomain saveExportPort(PortOfExportDomain port);

	UploadXmlDataDtlLogDomain saveUploadDtl(UploadXmlDataDtlLogDomain uploadDomain);

	void savePasswordHistoryDetails(PasswordHistory passwordHistory);
	galleryFormentity Updategalleryform(galleryFormentity entityobj);

	String deletegallerydetail(Long galleryId);

	galleryFormentity savegalleryform(galleryFormentity entityobj);
	
	List<galleryFormentity> getEventlist(String limit);
	RegistrationDetails updateManfUserDetail(RegistrationDetails registrationDetails);
	
	RegistrationDetails deleteManufUserDetail(Long userId);
	
	InstPremiseDtlDomain deletemanusitedetail(int premiseno);
	
	NewsEventsDomain saveNewsEvents(NewsEventsDomain news);
	
	void addApprovalTypeMst(ApprovalTypeMst app);
	
	List<SiteTypeMstDomain> getSiteAccUser(String applicantType);

	List<RegistrationDetails> getAllRegistrations();

	String saveOfficialRegistration(RegistrationDetails registrationDetails, LocationMasterDomain locationMasterDomain,
			OfficialRegistrationDetails officialRegDetails);

	List<ZoneMst> getZoneDetails();

	List<PromotionCouncilMaster> getPromotionCouncil();

	PointOfDistributionMst savePointOfDistributionMaster(PointOfDistributionMst point);

	List<StaticsDataDomain> getAllStatisticsData();

	void loadStatsFunc();
	
	//void expirelink (); 

	List<ReportProblemDomain> getFeedbackResData();

	PortOfExportDomain updateExportPort(PortOfExportDomain port);

	UploadXmlInvoiceDtlDomain updateConsignDtls(UploadXmlInvoiceDtlDomain inv);

	List<PortOfExportDomain> getAllPorts();

	UploadConsignDtlDomain addConDetails(UploadConsignDtlDomain conDtls);

	UploadPurchaseOrderDtlDom addPODetails(UploadPurchaseOrderDtlDom purDtls);

	UploadInvoiceDtlDomain addInvoiceDetails(UploadInvoiceDtlDomain invDtls);
	
	List<UploadXmlDataDtlDomain> getuploadedDataDtl(Integer uploadId);

	String getConsignNotesheet(Integer uploadId);
	
	List<DesktopConfigDtlDom> getDesktopCongDtls(Long uId);

	List<InstPremiseDtlDomain> getInstPremisesDtlsSubLogin(Integer instId, Integer premiseNo);

	List<ReportProblemDomain> getFeedBackStatusData();

	void updatefeedbackresponse(ReportProblemDomain dom);




}