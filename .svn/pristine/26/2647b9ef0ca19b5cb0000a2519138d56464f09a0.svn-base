package in.cdacnoida.dava.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.DavaDaoServices;
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
import in.cdacnoida.dava.transactions.DavaTransactions;
import in.cdacnoida.dava.transactions.RcmcDataRepository;
import in.cdacnoida.dava.transactions.UserRepository;

@Service
public class DavaDaoServicesImpl implements DavaDaoServices {

	@Autowired
	private DavaTransactions davaTransactions;

	@Autowired
	private RcmcDataRepository rcmcDataRepo;

	@Autowired
	public DaoHelper daoHelper;
	
	@Autowired
	private UserRepository userRepository;
	

	public List<CountryMst> getCountryNames() {
		List<CountryMst> countryMst = davaTransactions.getCountryNames();
		return countryMst;
	}

	public List<DistrictMst> getDistrictNames(Integer stateId) {
		List<DistrictMst> districtMst = davaTransactions.getDistrictNames(stateId);
		return districtMst;
	}

	public List<StatesMst> getStatedata(Integer countryId) {
		List<StatesMst> stateData = davaTransactions.getStatedata(countryId);
		return stateData;
	}
	// By Dipen
	public List<RegistrationDetails> getUserId() {
		List<RegistrationDetails> userData = davaTransactions.getUserId();
		return userData;
	}
	public RegistrationDetails saveUser(RegistrationDetails registrationDetails) {
		//RegistrationDetails getUserNameDetails=davaTransactions.findByUserId(registrationDetails.getUserName());
		
		
		RegistrationDetails status = davaTransactions.saveUser(registrationDetails);
		return status;
	}

	/*
	 * public RcmcRegistrationData getRcmcData(String rcmcNumber) {
	 * RcmcRegistrationData rcmcRegistrationData =
	 * rcmcDataRepo.findByRcmcNumber(rcmcNumber); return rcmcRegistrationData; }
	 */
	
	
	
	public RcmcRegistrationData getRcmcData(String rcmcNumber) {
		
		RcmcRegistrationData rcmcRegistrationData;
		
		System.out.println("rcmcNumber::::"+rcmcNumber.length());
		
		if(rcmcNumber.length()<=10)
		{
			System.out.println("inside iec number");
			
			 rcmcRegistrationData = rcmcDataRepo.findByIecNumber(rcmcNumber);
		}
					
		else
		{
			 rcmcRegistrationData = rcmcDataRepo.findByRcmcNumber(rcmcNumber);	
			 // G9 (07-FEB-24) if rcmc data is not present 
			 if (rcmcRegistrationData == null) {
			     return new RcmcRegistrationData();  
			 }
			 // END		
		}
		System.out.println(rcmcRegistrationData.toString());
		return rcmcRegistrationData;
	}
	
		
	
	
	public String generateJSONObject(String Fun, String searchTerm, String Query, int sAmount, int sStart) {
		String str = daoHelper.checklistJSON(Fun, searchTerm, Query, sAmount, sStart);
		return str;
	}

	@Override
	public List<ApplicantTypeMasterDomain> getApplicantTypeList() {
		List<ApplicantTypeMasterDomain> appType = davaTransactions.getApplicantTypeList();
		return appType;
	}

	@Override
	public List<ApplicantTypeMasterDomain> getApplicantTypeListName(int numUserTypeId) {
		List<ApplicantTypeMasterDomain> appType = davaTransactions.getApplicantTypeListName(numUserTypeId);
		return appType;
	}

	public List<LicenseTypeMstDomain> getLicTypeList() {
		List<LicenseTypeMstDomain> licType = davaTransactions.getLicTypeNames();
		return licType;
	}
	
	public List<LicenseTypeMstDomain> getLicTypeListForExp() {
		List<LicenseTypeMstDomain> licType = davaTransactions.getLicTypeNamesForExp();
		return licType;
	}

	public InstPremiseDtlDomain addPremisesDtls(InstPremiseDtlDomain instDom) {
		InstPremiseDtlDomain instPreDom = davaTransactions.savePrenisesDtls(instDom);
		return instPreDom;
	}

	public LicPremiseDtlDomain addLicwnsePremisesDtls(LicPremiseDtlDomain licPreDtlDom) {
		LicPremiseDtlDomain licPreDtls = davaTransactions.saveLicPrenisesDtls(licPreDtlDom);
		return licPreDtls;
	}

	public List<DrugTypeMst> getDrugType() {
		List<DrugTypeMst> drugType = davaTransactions.getAllDrugType();
		return drugType;
	}

	public List<DrugMonographMst> getDrugMonoType() {
		List<DrugMonographMst> drugMonoType = davaTransactions.getAllDrugMonographType();
		return drugMonoType;
	}

	public List<DrugScheduleMst> getDrugSchType() {
		List<DrugScheduleMst> drugSchType = davaTransactions.getAllDrugScheduleType();
		return drugSchType;
	}

	public List<PackUnitMst> getPackUnitType() {
		List<PackUnitMst> packUnitMst = davaTransactions.getPackUnitNames();
		return packUnitMst;
	}

	public List<DrugDosageMst> getDrugDoseType() {
		List<DrugDosageMst> drugDosageMst = davaTransactions.getDrugDosageMst();
		return drugDosageMst;
	}

	public DrugMst addDrugDtls(DrugMst drugDom) {
		DrugMst drugDtls = davaTransactions.saveDrugMstDtls(drugDom);
		return drugDtls;
	}

	public List<MemberTypeMasterDomain> getMemberTypeList() {
		List<MemberTypeMasterDomain> list = davaTransactions.getMemberTypeList();
		return list;
	}

	public List<NewsEventMstDomain> getEventTypeList() {
		List<NewsEventMstDomain> list = davaTransactions.getEventTypeList();
		return list;
	}

	public InstituteMemberDetailDomain addMemberDetails(InstituteMemberDetailDomain instMemDtlDomain) {
		InstituteMemberDetailDomain dtl = davaTransactions.saveMemDetails(instMemDtlDomain);
		return dtl;
	}

	public List<ApprovalTypeMst> getApprovalType() {
		List<ApprovalTypeMst> appType = davaTransactions.getAllAppTypes();
		return appType;
	}

	public ApprovalPremisesDetail addApprovalPremisesDtls(ApprovalPremisesDetail appPreDtls) {
		ApprovalPremisesDetail approvalPremises = davaTransactions.saveApprovalPremisesDtls(appPreDtls);
		return approvalPremises;
	}

	public List<InstPremiseDtlDomain> getInstPremisesDtls(Integer instId) {
		List<InstPremiseDtlDomain> instPremise = davaTransactions.getAllInstPremise(instId);
		return instPremise;
	}

	public DrugMst modifyDrugDetails(DrugMst drugDom) {
		DrugMst drug = davaTransactions.modifyDrugDtls(drugDom);
		return drug;
	}

	public DrugMst deleteDrugDetails(DrugMst drugDom) {
		DrugMst drug = davaTransactions.deleteDrugDtls(drugDom);
		return drug;
	}

	public String generateReportSiteDtlXML(Integer premisesNo) {
		String str = "";

		str = daoHelper.Viewxml1("Sitedtl_xml", premisesNo);

		System.out.println("viewxml" + str);
		return str;
	}

	// to persist document in Document Master
	public int addDocument(DocumentMasterDomain docDomain) 
	{
		DocumentMasterDomain docMaster = davaTransactions.saveDocumentInMaster(docDomain);
		return docMaster.getNumDocumentId();
	}

	public void updateDocumentSizeQuery(int doc_id, int doc_size) {
		davaTransactions.updateDocumentSizeQuery(doc_id, doc_size);

	}

	public void updateDocumentMstPath(String path, int numDocId) {
		davaTransactions.updateDocumentMstPath(path, numDocId);

	}

	public String getDocumentFileNameQuery(int doc_id) {

		return davaTransactions.getDocumentFileNameQuery(doc_id);
	}

	public String getDocumentFileNameForDownloadQuery(int doc_id) {
		// TODO Auto-generated method stub
		return davaTransactions.getDocumentFileNameForDownloadQuery(doc_id);
	}

	public List<OfficialForm> getMenu(int roleId) throws SQLException {
		return davaTransactions.getMenuList(roleId);
	}

	public List<SeatMaster> getSeatMstData(Integer numSeatId) {
		return davaTransactions.getSeatMstData(numSeatId);
	}

	public String AddSeatMaster(long userId) {
		// TODO Auto-generated method stub
		return davaTransactions.AddSeatMaster(userId);
	}

	// Added by manibhushan

	/*
	 * public String uniqueReportNumber(int problem_id) {
	 * 
	 * return davaTransactions.uniqueReportNumber(problem_id);
	 * 
	 * }
	 */

	public List<TileDomain> getTile(Integer numRoleId) {
		return davaTransactions.getTile(numRoleId);
	}

	public List<HSCodeDomain> getHSCodeDtls() {
		List<HSCodeDomain> hsCode = davaTransactions.getHSCodeDtls();
		return hsCode;
	}

	public List<StorageCondMstDom> getStorageCondition() {
		List<StorageCondMstDom> stDom = davaTransactions.getStorageDomain();
		return stDom;
	}

	public List<InstPremiseDtlDomain> getPremiseAddress(Integer manufactureId) {
		List<InstPremiseDtlDomain> premiseDtl = davaTransactions.getPremiseAddress(manufactureId);
		return premiseDtl;
	}

	public List<InstPremiseDtlDomain> getInstPremisesDtlsById(int manuUnit) {

		return davaTransactions.getInstPremisesDtlsById(manuUnit);
	}

	public List<RegistrationDetails> getUserDetails(String userName) {
		return davaTransactions.getUserDetail(userName);
	}

	public List<DataUploadTypeMstDomain> getDataUploadType() {
		return davaTransactions.getDataUploadType();
	}

	public InstituteMemberDetailDomain deleteMemberDetails(MemberDetailForm memDtlForm) {
		return davaTransactions.deleteMemberDetails(memDtlForm);
	}

	public RegistrationDetails deleteManufUserDetail(Long userId) {
		return davaTransactions.deleteManufUserDetail(userId);
	}
	
	//added by harshita on 13-02-2024
	
	public InstPremiseDtlDomain deletemanusitedetail(int premiseno) {
		return davaTransactions.deletemanufsitedetail(premiseno);
	}
	
	public List<InstituteMemberDetailDomain> getAddedMemberData(int memberId) {

		return davaTransactions.getAddedMemberData(memberId);
	}

	public InstituteMemberDetailDomain updateMemberDetails(InstituteMemberDetailDomain instMemDtlDomain) {

		return davaTransactions.updateMemberDetails(instMemDtlDomain);
	}

	public String createJSONManufacturingSiteDtls(Integer numPremiseNo) {
		String test = daoHelper.getListJSON("manufacturingsite_json", numPremiseNo);
		return test;
	}

	public List<InstPremiseDtlDomain> getInstPremiseDtls(Integer numPremiseNo) {
		List<InstPremiseDtlDomain> instPremises = davaTransactions.getInstPremiseDtls(numPremiseNo);
		return instPremises;
	}

	public UploadXmlDataDtlDomain saveUploadDtl(UploadXmlDataDtlDomain uploadDomain) {
		return davaTransactions.saveUploadDtl(uploadDomain);
	}

	public List<String> getuploadedDataDtl() {

		return davaTransactions.getUploadedDataDtl();
	}

	public void updateInstPremiseDtl(int manuUnit, Long userId) {
		davaTransactions.updateInstPremiseDtl(manuUnit, userId);

	}

	public List<InstPremiseDtlDomain> getInstPremisesDtlsForSublogin(Integer instId) {
		return davaTransactions.getInstPremisesDtlsForSublogin(instId);
	}

	public List<ReportProblemDomain> getProblemDeatil(int problem_id) {
		// TODO Auto-generated method stub
		return davaTransactions.getProblemDeatil(problem_id);
	}

	public String getRCMCRegData(String data) {
		String test = daoHelper.getListJSON("rcmc_data", data);
		return test;
	}

	public String getProfilePercentage(int seatId) {
		// TODO Auto-generated method stub

		return davaTransactions.getProfilePercentage(seatId);
	}

	public String saveProductInTable(Integer upId,String fileasString, Integer instId) {

		return davaTransactions.saveProductInTable(upId,fileasString,instId);
	}

	public void updateFinalStatus(int docId, String xmlPreview) {
		davaTransactions.updateFinalStatus(docId, xmlPreview);

	}

	public void updateFinalStatus(int docId, StringBuffer xmlPreview) {
		davaTransactions.updateFinalStatus(docId, xmlPreview);

	}

	public void saveConfigDtls(DesktopConfigDtlDom dskConDom) {
		davaTransactions.saveDeskConfigDtls(dskConDom);
	}

	public void saveOtherPromotionCouncil(OtherPromotionCouncilDetails otherPromotionCouncilDetails) {
		davaTransactions.insertPromotionCouncil(otherPromotionCouncilDetails);

	}

	public boolean saveManufacturingInTable(String fileasString) {
		return davaTransactions.saveManufacturingInTable(fileasString);
	}

	public boolean savePackagingInTable(String fileasString) {
		return davaTransactions.savePackagingInTable(fileasString);
	}

	public List<TherepueticClassDom> getTherepueticClass() {
		List<TherepueticClassDom> stDom = davaTransactions.getTherepueticClass();
		return stDom;
	}

	@Override
	public List<DrugMst> getProductNames() {
		List<DrugMst> getProductNames = davaTransactions.getProductNames();
		return getProductNames;
	}
	
	public List<DrugMst> getProductNames(Integer InstId) {
		List<DrugMst> getProductNames = davaTransactions.getProductNames(InstId);
		return getProductNames;
	}

	@Override
	public List<CountryMst> getCountrybasedOnRegion(Integer regionId) {
		List<CountryMst> getCountrybasedOnRegion = davaTransactions.getCountrybasedOnRegion(regionId);
		return getCountrybasedOnRegion;
	}

	@Override
	public boolean saveExportOrderDetails(ExportOrderDomain exportOrderDomain) {
		boolean result = davaTransactions.saveExportOrderDetails(exportOrderDomain);
		return result;
	}

	@Override
	public ConsignmentDetailDomain saveConsignmentDetails(ConsignmentDetailDomain consignmentDetailDomain) {
		ConsignmentDetailDomain consignmentDetailDomainOne=davaTransactions.saveConsignmentDetails(consignmentDetailDomain);
		return consignmentDetailDomainOne;
	}

	public InstPremiseDtlDomain savePremiseDetails(InstPremiseDtlDomain premiseDetails) {
		davaTransactions.saveManufacturingPremiseDetails(premiseDetails);
		return premiseDetails;
	}

	public void saveDrugMasterDetails(DrugMst drug) {
		davaTransactions.saveDrugDetails(drug);

	}

	public List<ExportOrderDomain> getExpOderDtl() {
		List<ExportOrderDomain> exp = davaTransactions.getExportOrderDtls();
		return exp;
	}

	public List<DrugMst> getProdCode(Integer drugId) {
		List<DrugMst> prodDtl = davaTransactions.getProdCode(drugId);
		return prodDtl;
	}

	public ProcurementMstDomain saveProcurementMasterDetails(ProcurementMstDomain pmDom) {
		ProcurementMstDomain procurementDetailDomain = davaTransactions.saveProcurementMasterDtls(pmDom);
		return procurementDetailDomain;
	}

	@Override
	public void persistConsignmentDetailEntities(EXP_TERTIARY_LIST_DETAILS exp,
			ConsignmentDetailsEntity consignmentDetailsEntity, EXPORT_DETAILS exportDetails) {
		davaTransactions.persistConsignmentDetailEntities(exp, consignmentDetailsEntity, exportDetails);

	}

	@Override
	public void addTertiaryDetails(TERTIRY_DETAILS tertiaryDetails) {
		davaTransactions.addTertiaryDetails(tertiaryDetails);
	}

	@Override
	public void addSecondary3Details(SECONDARY3_DETAILS secondary3Details) {
		davaTransactions.addSecondary3Details(secondary3Details);
	}

	@Override
	public void addSecondary2Details(SECONDARY2_DETAILS secondary2Details) {
		davaTransactions.addSecondary2Details(secondary2Details);
	}

	@Override
	public void addSecondary1Details(SECONDARY1_DETAILS secondary1Details) {
		davaTransactions.addSecondary1Details(secondary1Details);
	}

	@Override
	public void addProductdetails(ProductDetails productDetails) {
		davaTransactions.addProductdetails(productDetails);
	}

	@Override
	public Map<String, List<Long>> getStateStatistics(Long userId) {
		// TODO Auto-generated method stub
		Map<String, List<Long>> hm = new HashMap<String, List<Long>>();
		List<Object[]> objList = davaTransactions.getStateStatistics(userId);
		try {
			if (objList.size() > 0) {
				for (Object object : objList) {

					Object[] obj = (Object[]) object;

					List<Long> stateDtlList = new ArrayList<Long>();

					stateDtlList.add(Long.parseLong(obj[0].toString()));
					stateDtlList.add(Long.parseLong(obj[2].toString()));

					hm.put(obj[1].toString(), stateDtlList);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;
	}

	@Override
	public List<InstPremiseDtlDomain> getSitesDisplay(int stateID) {
		List<InstPremiseDtlDomain> instPremiseDtlDomains = davaTransactions.getAllInstStateDetails(stateID);
		return instPremiseDtlDomains;
	}

	@Override
	public Map<String, Integer> getCountryStatistics(Long userId) {
		Map<String, Integer> statcountry = new HashMap<String, Integer>();
		List<Object[]> objList = davaTransactions.getCountryStatistics(userId);
		// statcountry=davaTransactions.getCountryStatistics(userId);
		// TODO Auto-generated method stub
		try {
			if (objList.size() > 0) {
				for (Object object : objList) {
					Object[] obj = (Object[]) object;
					// List<Long> countryDtlList = new ArrayList<Long>();
					statcountry.put(obj[1].toString(), Integer.parseInt(obj[0].toString()));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return statcountry;
	}

	public void updateKeyinRegistration(Long userId, String mac_address, String publicKey) {
		davaTransactions.updateKeyinUR(userId, mac_address, publicKey);
	}

	@Override
	public String createJSONTilesData(String tilesfuncName, Integer numInstId, Long userId) {
		String test = daoHelper.getTilesDataJSON(tilesfuncName, numInstId, userId);
		return test;
	}

	public List<InstituteMasterDomain> getInstData(int instId) {
		return davaTransactions.getInstituteData(instId);
	}

	public List<RegistrationDetails> getRegistrationDetails(Long userId) {
		return davaTransactions.getUserDetailfromUserId(userId);
	}

	public WorkshopRegistrationDomain saveWorkshopRegistration(WorkshopRegistrationDomain wd,
			HttpServletRequest request) {
		WorkshopRegistrationDomain dom = davaTransactions.saveWorshopRegDetails(wd, request);
		return dom;
	}



	
	public CodeRequestMstDomain saveCodeRequest(CodeRequestMstDomain dom) {
		CodeRequestMstDomain crd = davaTransactions.saveCodeRequestDetails(dom);
		return crd;
	}

	public List<UploadXmlDataDtlDomain> getUploadedeData(int docId) {
		List<UploadXmlDataDtlDomain> upDom = davaTransactions.getUploadedDetails(docId);
		return upDom;
	}

	public Integer getUploadedDetails(Integer uploadId) {
		return davaTransactions.saveConsignmentDetailsInTable(uploadId);
	}

	public String getPackCode(Integer requestId) {
		String crd = davaTransactions.getPackCode(requestId);
		return crd;
	}
	
	public String getduplicateCodes(String xmlData) {
		String result = davaTransactions.getduplicateCodes(xmlData);
		return result;
	}
	
	public String getConsignmentDetails(int invoiceId) {
		String result = davaTransactions.getConsignmentDetails(invoiceId);
		return result;
	}

	
	public String getAckDocumentFileNameForDownload(int doc_id) {
		return davaTransactions.getAckDocumentFileNameForDownload(doc_id);
	}
	
	public void addEmailDetailsToDb(EmailDetailDomain emailDom) {
		davaTransactions.addEmailDetailsToDb(emailDom);
		
	}

	public EmailMstDomain saveEmailMst(EmailMstDomain emd) {
		
		return davaTransactions.saveEmailMstToDb(emd);
	}
	
	public PortOfExportDomain saveExportPort(PortOfExportDomain port) {
		return davaTransactions.addPortOfExport(port);
	}

	@Override
	public UploadXmlDataDtlLogDomain saveUploadDtl(UploadXmlDataDtlLogDomain uploadDomain) {
		return davaTransactions.saveUploadDtlLog(uploadDomain);
	}

	@Override
	public void savePasswordHistoryDetails(PasswordHistory passwordHistory) {
		davaTransactions.savePasswordHistoryDetails(passwordHistory);
		
	}
	public galleryFormentity savegalleryform(galleryFormentity entityobj) {
		galleryFormentity instgalleryDom = davaTransactions.savegalleryform(entityobj);
		return instgalleryDom;
	}
	
//	public List<galleryFormentity> getEventlist(String limit) {
//	List <galleryFormentity> galleryentity=davaTransactions.getEventlist(limit);
//		return galleryentity;
//		
//	}
	
	public galleryFormentity Updategalleryform(galleryFormentity entityobj) {
		galleryFormentity instgalleryDom = davaTransactions.Updategalleryform(entityobj);
		return instgalleryDom;
	}

	@Override
	public String deletegallerydetail(Long galleryId) {
		// TODO Auto-generated method stub
		String msg=null;
		try {
		galleryFormentity galentity=davaTransactions.deletegallerydetail(galleryId);
		
		if(galentity!=null) {
			msg="Deleted Successfully";
		}
		
		}catch (Exception e) {
			msg="Delete is Unsuccessfull";
			e.printStackTrace();
		}
		return msg;
	}
	


	public RegistrationDetails updateManfUserDetail(RegistrationDetails registrationDetails) {
		System.err.println("in dava dao ser imp");
		return davaTransactions.updateManfUserDetail(registrationDetails);
	}

	@Override
	public NewsEventsDomain saveNewsEvents(NewsEventsDomain news) {
		return davaTransactions.addNewsEvents(news);
	}
	
	public void addApprovalTypeMst(ApprovalTypeMst app) {
		davaTransactions.saveAppTypeMaster(app);
	}
	
	public List<SiteTypeMstDomain> getSiteAccUser(String applicantType) {
		List<SiteTypeMstDomain> siteMst = davaTransactions.getAllSites(applicantType);
		return siteMst;
	}
	
	public List<RegistrationDetails> getAllRegistrations() {
		List<RegistrationDetails> regDet = davaTransactions.getAllRegDet();
		return regDet;
	}
	
	@Override
	public String saveOfficialRegistration(RegistrationDetails registrationDetails,
			LocationMasterDomain locationMasterDomain, OfficialRegistrationDetails officialRegDetails) {
		
		String result="saved";
		try {
			RegistrationDetails getUserNameDetails=userRepository.findByUserName(registrationDetails.getUserName().toLowerCase());
			if(getUserNameDetails!=null)
				return "notSaved";
			
			RegistrationDetails regDtl=davaTransactions.saveRegDtl(registrationDetails);
			LocationMasterDomain locDtl=davaTransactions.saveLocDtl(locationMasterDomain);
			officialRegDetails.setRegistrationDetails(regDtl);
			officialRegDetails.setLocationMasterDomain(locDtl);
			davaTransactions.saveOfficialReg(officialRegDetails);
		} catch (Exception e) {
			e.printStackTrace();
			result="notSaved";
		}
		return result;
	}

	@Override
	public List<ZoneMst> getZoneDetails() {
		return davaTransactions.getZoneData();
	}

	@Override
	public List<PromotionCouncilMaster> getPromotionCouncil() {
		return davaTransactions.getPromotionCouncil();
	}

	@Override
	public PointOfDistributionMst savePointOfDistributionMaster(PointOfDistributionMst point) {
		return davaTransactions.saveAllPointOfDistribution(point);
	}
	
	public List<StaticsDataDomain> getAllStatisticsData() {
		return davaTransactions.getAllStatsData();
	}
	
	public void loadStatsFunc() {
		String fun = "dava.statistics_data()";
		daoHelper.loadFunction(fun);
	}

	/*
	 * public void expirelink() { String fun = "dava.expirelink_data()";
	 * daoHelper.loadFunction(fun); }
	 */
	
	 
	
	public List<ReportProblemDomain> getFeedbackResData() {
		return davaTransactions.getFeedbackdata();
	}

	public PortOfExportDomain updateExportPort(PortOfExportDomain port) {
		return davaTransactions.updatePortOfExp(port);
	}
	
	public UploadXmlInvoiceDtlDomain updateConsignDtls(UploadXmlInvoiceDtlDomain inv) {
		return davaTransactions.updateConsignmentDetails(inv);
	}
	
	public List<PortOfExportDomain> getAllPorts() {
		return davaTransactions.getAllPorts();
	}

	public UploadConsignDtlDomain addConDetails(UploadConsignDtlDomain conDtls) {
		return davaTransactions.saveConDtls(conDtls);
	}

	public UploadPurchaseOrderDtlDom addPODetails(UploadPurchaseOrderDtlDom purDtls) {
		
		return davaTransactions.savePODetails(purDtls);
	}
	
	public UploadInvoiceDtlDomain addInvoiceDetails(UploadInvoiceDtlDomain invDtls) {
		return davaTransactions.saveInvoiceDtls(invDtls);
	}
	
	public List<UploadXmlDataDtlDomain> getuploadedDataDtl(Integer uploadId) {

		return davaTransactions.getUploadedDataDtl(uploadId);
	}
	
	public String getConsignNotesheet(Integer uploadId) {
		String str="";
			str = daoHelper.Viewxml("upload_consigndtlxml",uploadId);
			System.out.println("viewxml"+str);
		return str;
	}
	public List<ReportProblemDomain> getFeedBackStatusData() {
		return davaTransactions.getFeedBackStatusData();
	}

	@Override
	public void updatefeedbackresponse(ReportProblemDomain dom) {
		davaTransactions.updatefeedbackresponses(dom);
		
	}

	@Override
	public List<DesktopConfigDtlDom> getDesktopCongDtls(Long uId) {
		return davaTransactions.getDesktopCongDtl(uId);
	}

	@Override
	public List<InstPremiseDtlDomain> getInstPremisesDtlsSubLogin(Integer instId, Integer premiseNo) {
		return davaTransactions.getInstPremisesDtlsSubLogin(instId,premiseNo);
	}

	@Override
	public List<galleryFormentity> getEventlist(String limit) {
		// TODO Auto-generated method stub
		return null;
	}




}
