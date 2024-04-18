

package in.cdacnoida.dava.transactions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.cdacnoida.dava.daoimpl.DaoHelper;
import in.cdacnoida.dava.entities.ApplicantTypeMasterDomain;
import in.cdacnoida.dava.entities.ApprovalPremisesDetail;
import in.cdacnoida.dava.entities.ApprovalTypeMst;
import in.cdacnoida.dava.entities.CodeRequestMstDomain;
import in.cdacnoida.dava.entities.ConsignmentDetailDomain;
import in.cdacnoida.dava.entities.ConsignmentDetailsEntity;
//import in.cdacnoida.dava.entities.CountryMasterDomain;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.CountryRegionMapDomain;
import in.cdacnoida.dava.entities.DataUploadTypeMstDomain;
import in.cdacnoida.dava.entities.DesktopConfigDtlDom;
import in.cdacnoida.dava.entities.DistributionMstDomain;
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
import in.cdacnoida.dava.entities.FileUploadLogEntity;
import in.cdacnoida.dava.entities.HSCodeDomain;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.InstituteMasterDomain;
import in.cdacnoida.dava.entities.InstituteMemberDetailDomain;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
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
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.ReportProblemDomain;
import in.cdacnoida.dava.entities.RoleMaster;
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

@Repository
@Transactional
public class DavaTransactions {

	@Autowired
	private EntityManager em;
 
	@Autowired
	private DaoHelper daoHelper;
		   
	@Autowired
	CodeReqDtlDomainRepo codeReqDtlDomainRepo;

	private static final Logger LOGGER=LoggerFactory.getLogger(DavaTransactions.class);
	
	public List<CountryMst> getCountryNames() {
		
		TypedQuery<CountryMst> fetchCountryData=em.createQuery("select c from CountryMst c order by c.str_country_name",CountryMst.class);
		List<CountryMst> countryNamesList=fetchCountryData.getResultList();
		LOGGER.info("Country List Size {} ",countryNamesList.size());
		
		return countryNamesList;
	}

	public List<DistrictMst> getDistrictNames(Integer stateId) {
		
		TypedQuery<DistrictMst> districtMaster=
				em.createQuery("select d from DistrictMst d where d.num_state_id=?1 order by d.str_district_name",DistrictMst.class);
		districtMaster.setParameter(1, stateId);
		List<DistrictMst> districtMst=districtMaster.getResultList();
		LOGGER.info("District List size {} ",districtMst.size());
		return districtMst;
	}

	public List<StatesMst> getStatedata(Integer countryId) {
		System.out.println("c id------"+countryId);
		TypedQuery<StatesMst> statesMaster= em.createQuery("select d from StatesMst d where d.num_country_id=?1 and d.num_isvalid=1 order by d.str_state_name",StatesMst.class);
																						  
		statesMaster.setParameter(1, countryId);
		List<StatesMst> statesMst=statesMaster.getResultList();
		LOGGER.info("State List size {} ",statesMst.size());
		return statesMst;
	}
	
    public List<ZoneMst> getZone() {
		
	    TypedQuery<ZoneMst> fetchCountryData=em.createQuery("select c from ZoneMst c  order by c.zoneName",ZoneMst.class);
		List<ZoneMst> countryNamesList=fetchCountryData.getResultList();
		LOGGER.info("Country List Size {} ",countryNamesList.size());
		
		return countryNamesList;
	}

	public RegistrationDetails saveUser(RegistrationDetails registrationDetails) {
		System.out.println("registrationDetails.getUserId()::::"+registrationDetails.getUserId());
		System.out.println("registrationDetails.getUserName()::::"+registrationDetails.getUserName());
		try {
			if(registrationDetails.getUserId()!=null) 
				em.merge(registrationDetails);
			else
				em.persist(registrationDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return registrationDetails;
		}
		return registrationDetails;
	}

	public List<InstituteTypeMasterDomain> getInstituteTypeName() {
		TypedQuery<InstituteTypeMasterDomain> fetchData=em.createQuery("select c from InstituteTypeMasterDomain c where numIsValid=1",InstituteTypeMasterDomain.class);
		List<InstituteTypeMasterDomain> InstTypeList=fetchData.getResultList();
		LOGGER.info("Country List Size {} ",InstTypeList.size());
		
		return InstTypeList;
	}

	public String saveLocationMaster(LocationMasterDomain locDom) {
		String response = "";
		System.out.println("location domain ========   "+locDom.getLoc_add());
		em.persist(locDom);
		return response;
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	public List<LocationMasterDomain> getLocationsData() {
		Query q = em.createNativeQuery("SELECT num_loc_id, (select str_inst_type_name from institute_type_mst q where q.num_inst_type_id = i.num_inst_type_id),str_address, str_loc_name, str_short_name, str_email_id, num_mob_no, str_fax_no, (select str_country_name from country_mst c where c.num_country_id = i.num_country_id), (select str_district_name from district_mst d where d.num_district_id = i.num_district_id) district,(select str_state_name from states_mst s where s.num_state_id = i.num_state_id) states, str_officer_name from location_mst i where num_isvalid=1 ORDER BY str_inst_type_name");
		List<LocationMasterDomain> authors = q.getResultList();
		/*
		 * TypedQuery<LocationMasterDomain> fetchData=em.
		 * createQuery("select c from LocationMasterDomain c where numIsValid=1"
		 * ,LocationMasterDomain .class); List<LocationMasterDomain>
		 * locMst=fetchData.getResultList();
		 * LOGGER.info("Country List Size {} ",locMst.size());
		 */
		return authors;
	}

	public String updateLocationMaster(LocationMasterDomain locDom) {
		String response = "";
		System.out.println("location domain ========   "+locDom.getNumlocationId());
		if(locDom.getNumlocationId() != 0) {
			em.merge(locDom);
		}else {
			System.out.println("null value exist");
		}
		return response;
	}
	// Added by Pratima 
	public String saveCountryMasterRecord(CountryMst cmd) {
		
			String response = "";
			System.out.println("country domain ========   "+cmd.getStr_country_name());
			em.persist(cmd);
			return response;
		
	}

	public String updateCountryMaster(CountryMst cmd) {
		String response = "";
													  
											   
		
		System.err.println("in update error occurred");
		System.out.println("country domain ========   "+cmd.getNum_country_id());
		try{
			if(cmd.getNum_country_id() != 0) {
			
				em.merge(cmd);
			}else {
			System.out.println("null value exist");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "ErrorPage.jsp";
		}
		return response;
	}
	
	public String savepackUnitMaster(PackUnitMst pum) {
		String response = "";
		System.out.println("In SAVE Dao");
		em.persist(pum);
		return response;
	}

	public List<ApplicantTypeMasterDomain> getApplicantTypeList() {
		TypedQuery<ApplicantTypeMasterDomain> fetchApplicantType=em.createQuery("select a from ApplicantTypeMasterDomain a",ApplicantTypeMasterDomain.class);
		List<ApplicantTypeMasterDomain> appType=fetchApplicantType.getResultList();
		LOGGER.info("appType List Size {} ",appType.size());
		return appType;
	}

	public List<ApplicantTypeMasterDomain> getApplicantTypeListName(int numUserTypeId) {
		TypedQuery<ApplicantTypeMasterDomain> fetchApplicantType=em.createQuery("select a from ApplicantTypeMasterDomain a where a.numApplTypeId=?1" ,ApplicantTypeMasterDomain.class);
		fetchApplicantType.setParameter(1, numUserTypeId);
		List<ApplicantTypeMasterDomain> appType=fetchApplicantType.getResultList();
		LOGGER.info("appType List Size {} ",appType.size());
		return appType;
	}

	

	public String saveStateMaster(StatesMst stateDom) {
		 String response = "";
		  System.out.println("state domain ========   "+stateDom.getStr_state_name()+" ===== state name =========="); 
		  em.persist(stateDom); 
		 return response;
	}

	public String updateStateMaster(StatesMst stateDom) {
		String response = "";
		System.out.println("state update domain ========   "+stateDom.getNum_state_id());
	  try {
			if(stateDom.getNum_state_id() != 0) {
		
				em.merge(stateDom);
		
			}else {
				System.out.println("null value exist");
			}
	  }
			catch(Exception e){
                e.printStackTrace();
                return "ErrorPage";
			}  
		return response;
	}

	public String saveDistrictMasterForm(DistrictMst dmd) 
	{
		 String response = "";
		  System.err.println("district domain ========   "+dmd.getStr_district_name()+" ===== district name =========="); 
																															
																					 
		  em.persist(dmd); 
						
		 return response;
	}

	public List<PackUnitMst> getPackUnitNames() {
		TypedQuery<PackUnitMst> fetchPackUnitData=em.createQuery("select c from PackUnitMst c where numIsValid=1",PackUnitMst.class);
		List<PackUnitMst> PackUnitNamesList=fetchPackUnitData.getResultList();
		LOGGER.info("Pack Unit List Size {} ",PackUnitNamesList.size());
		
		return PackUnitNamesList;
	}
	public String updatePackUnit(PackUnitMst pum) {
		String response = "";
		
		System.err.println("in update error occurred");
		System.out.println("pack unit domain ========   "+pum.getNumPackId());
		try{
			if(pum.getNumPackId() != 0) {
			
				em.merge(pum);
			}else {
			System.out.println("null value exist");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "ErrorPage.jsp";
		}
		return response;
	}
	
	public List<RoleMaster> getAllRoles() {
		TypedQuery<RoleMaster> fetchData=em.createQuery("select c from RoleMaster c where num_isvalid=1",RoleMaster.class);
		List<RoleMaster> roleList=fetchData.getResultList();
		LOGGER.info("List Size {} ",roleList.size());
		return roleList;  
	}
	
	public List<LicenseTypeMstDomain> getLicTypeNames() {
		TypedQuery<LicenseTypeMstDomain> fetchData=em.createQuery("select c from LicenseTypeMstDomain c where numIsValid=1 and licenseTypeFlag = 1",LicenseTypeMstDomain.class);
		List<LicenseTypeMstDomain> licTypeList=fetchData.getResultList();
		LOGGER.info("List Size {} ",licTypeList.size());					
		return licTypeList; 
	}
	// By Dipen
		public List<RegistrationDetails> getUserId() {
			TypedQuery<RegistrationDetails> Registration= em.createQuery("select d FROM RegistrationDetails d where numIsValied in (0,1) order by userId desc ",RegistrationDetails.class);
			//Registration.setMaxResults(1);																		  
			List<RegistrationDetails> RegistrationDetails=Registration.getResultList();
			LOGGER.info("Registration List size {} ",RegistrationDetails.size());
			return RegistrationDetails;
		}
	public List<LicenseTypeMstDomain> getLicTypeNamesForExp() {
		TypedQuery<LicenseTypeMstDomain> fetchData=em.createQuery("select c from LicenseTypeMstDomain c where numIsValid=1 and licenseTypeFlag = 2",LicenseTypeMstDomain.class);
		List<LicenseTypeMstDomain> licTypeList=fetchData.getResultList();
		LOGGER.info("List Size {} ",licTypeList.size());					
		return licTypeList; 
	}
	
	public InstPremiseDtlDomain savePrenisesDtls(InstPremiseDtlDomain instDom) {
		//ArrayList<Object> paraList=new ArrayList<Object>();
		//InstPremiseDtlDomain instDtlDom = null;
		//InstPremiseDtlDomain instDtlDom = daoHelper.persist(InstPremiseDtlDomain.class, instDom);
		//System.out.println("location domain ========   "+instDtlDom.getContactPerDesg());
		em.persist(instDom);
		//em.persist(instDom);
		return instDom;
	}

	public LicPremiseDtlDomain saveLicPrenisesDtls(LicPremiseDtlDomain licPreDtlDom) {
		//LicPremiseDtlDomain licPremisesDtls = null;
		//LicPremiseDtlDomain licPremisesDtls = daoHelper.persist(LicPremiseDtlDomain.class, licPreDtlDom);
		em.persist(licPreDtlDom);
		return licPreDtlDom;	  
	}

	public List<MemberTypeMasterDomain> getMemberTypeList() {
		TypedQuery<MemberTypeMasterDomain> fetchData=em.createQuery("select c from MemberTypeMasterDomain c where numIsValid=1",MemberTypeMasterDomain.class);
		List<MemberTypeMasterDomain> licTypeList=fetchData.getResultList();
		LOGGER.info("List Size {} ",licTypeList.size());					
		return licTypeList;
	}

	public List<NewsEventMstDomain> getEventTypeList() {
		TypedQuery<NewsEventMstDomain> fetchData=em.createQuery("select c from NewsEventMstDomain c where numIsValid=1",NewsEventMstDomain.class);
		List<NewsEventMstDomain> licTypeList=fetchData.getResultList();
		LOGGER.info("List Size {} ",licTypeList.size());					
		return licTypeList;
	}

	public InstituteMemberDetailDomain saveMemDetails(InstituteMemberDetailDomain instMemDtlDomain) {
		System.err.println("in final--- "+instMemDtlDomain.getStrEmail());
		em.persist(instMemDtlDomain);
		//em.flush();
		return instMemDtlDomain;
	}

	public List<DrugTypeMst> getAllDrugType() {
		TypedQuery<DrugTypeMst> fetchData=em.createQuery("select c from DrugTypeMst c where numIsValid=1",DrugTypeMst.class);
		List<DrugTypeMst> drugTypeList=fetchData.getResultList();
		LOGGER.info("List Size {} ",drugTypeList.size());					
		return drugTypeList; 
	}

	public List<DrugMonographMst> getAllDrugMonographType() {
		TypedQuery<DrugMonographMst> fetchData=em.createQuery("select c from DrugMonographMst c where numIsValid=1",DrugMonographMst.class);
		List<DrugMonographMst> drugMonoTypeList=fetchData.getResultList();
		LOGGER.info("List Size {} ",drugMonoTypeList.size());					
		return drugMonoTypeList;
	}

	public List<DrugScheduleMst> getAllDrugScheduleType() {
		TypedQuery<DrugScheduleMst> fetchData=em.createQuery("select c from DrugScheduleMst c where numIsValid=1",DrugScheduleMst.class);
		List<DrugScheduleMst> drugSchTypeList=fetchData.getResultList();
		LOGGER.info("List Size {} ",drugSchTypeList.size());					
		return drugSchTypeList;
	}

	public List<DrugDosageMst> getDrugDosageMst() {
		TypedQuery<DrugDosageMst> fetchData=em.createQuery("select c from DrugDosageMst c where numIsValid=1 ORDER BY strDosageName",DrugDosageMst.class);
		List<DrugDosageMst> drugDosageMst=fetchData.getResultList();
		LOGGER.info("List Size {} ",drugDosageMst.size());					
		return drugDosageMst;
	}

	public DrugMst saveDrugMstDtls(DrugMst drugDom) {
		em.persist(drugDom);
		return drugDom;	  
	}

	public DocumentMasterDomain saveDocumentInMaster(DocumentMasterDomain docDomain) {
		
		em.persist(docDomain);
		return docDomain;
	}

	public void updateDocumentSizeQuery(int doc_id, int doc_size) {
		TypedQuery<DocumentMasterDomain> fetchData=em.createQuery("select c from DocumentMasterDomain c where numIsValid=1 and c.numDocumentId=?1",DocumentMasterDomain.class);
		fetchData.setParameter(1, doc_id);
		List<DocumentMasterDomain> docList=fetchData.getResultList();
		Iterator<DocumentMasterDomain> itr = docList.iterator();
		while (itr.hasNext()) {
			DocumentMasterDomain dmd = itr.next();
			dmd.setDtTrDate(new Date());
			dmd.setNumDocSize(doc_size);
		em.merge(dmd);
		}
	}

	public void updateDocumentMstPath(String path, int numDocId) {
		TypedQuery<DocumentMasterDomain> fetchData=em.createQuery("select c from DocumentMasterDomain c where numIsValid=1 and c.numDocumentId=?1",DocumentMasterDomain.class);
		fetchData.setParameter(1, numDocId);
		List<DocumentMasterDomain> docList=fetchData.getResultList();
		Iterator<DocumentMasterDomain> itr = docList.iterator();
		while (itr.hasNext()) {
			DocumentMasterDomain dmd = itr.next();
			dmd.setDtTrDate(new Date());
			dmd.setStrFilename(path);
		em.merge(dmd);
		}
	}

	public String getDocumentFileNameQuery(int doc_id) {
		TypedQuery<DocumentMasterDomain> fetchData=em.createQuery("select c from DocumentMasterDomain c where numIsValid=1 and c.numDocumentId=?1",DocumentMasterDomain.class);
		fetchData.setParameter(1, doc_id);
		List<DocumentMasterDomain> docList=fetchData.getResultList();
		
		return docList.get(0).getStrFilename();
	}

	public String getDocumentFileNameForDownloadQuery(int doc_id) {
		TypedQuery<DocumentMasterDomain> fetchData=em.createQuery("select c from DocumentMasterDomain c where numIsValid=1 and c.numDocumentId=?1",DocumentMasterDomain.class);
		fetchData.setParameter(1, doc_id);
		List<DocumentMasterDomain> docList=fetchData.getResultList();
		Iterator<DocumentMasterDomain> itr = docList.iterator();
		while (itr.hasNext()) {
			DocumentMasterDomain dmd = itr.next();
			return dmd.getStrRmarks();
		}
		return "str";
	}

	public List<ApprovalTypeMst> getAllAppTypes() {
		TypedQuery<ApprovalTypeMst> fetchData=em.createQuery("select c from ApprovalTypeMst c where numIsValid=1",ApprovalTypeMst.class);
		List<ApprovalTypeMst> appMst=fetchData.getResultList();
		LOGGER.info("List Size {} ",appMst.size());					
		return appMst;
	}

	public ApprovalPremisesDetail saveApprovalPremisesDtls(ApprovalPremisesDetail appPreDtls) {
		em.persist(appPreDtls);
		return appPreDtls;
	}

	public List<InstPremiseDtlDomain> getAllInstPremise(Integer instId) {
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where numIsValid=1 and c.numInstid=?1",InstPremiseDtlDomain.class);
		fetchData.setParameter(1, instId);
		List<InstPremiseDtlDomain> instPremiseDtl=fetchData.getResultList();
		LOGGER.info("List Size {} ",instPremiseDtl.size());					
		return instPremiseDtl;
	}

	public DrugMst modifyDrugDtls(DrugMst drugDom) {
		if(drugDom.getNumDrugId() != 0) {
			em.merge(drugDom);
		}else {
			System.out.println("null value exist");
		}
		return drugDom;
	}

	public DrugMst deleteDrugDtls(DrugMst drugDom) {
		if(drugDom.getNumDrugId() != 0) {
			em.merge(drugDom);
		}else {
			System.out.println("null value exist");
		}
		return drugDom;
	}

	public List<OfficialForm> getMenuList(int roleId) throws SQLException {
		List<Object[]> glist = getMenu(roleId);
		List<OfficialForm> lOfficial = new ArrayList<OfficialForm>();
		int gID = 0;
		for (int i = 0; i < glist.size(); i++) {

			OfficialForm of = new OfficialForm();
			gID = (Integer) glist.get(i)[0];
			of.setNumGroupId(gID);
			of.setGroupName(glist.get(i)[1].toString());
			String strProcessName[] = glist.get(i)[2].toString().split(",");
			of.setArrProcessName(strProcessName);
			of.setArrProcessURL(glist.get(i)[3].toString().split(","));
			lOfficial.add(of);
		}

		return lOfficial;
	}

	private List<Object[]> getMenu(int roleId) throws SQLException {
		
		ArrayList<Object> paraList=new ArrayList<Object>();
		String query="select DISTINCT a.NUM_GROUP_ID, b.STR_GROUP_NAME , string_agg(p.str_process_name,',' order by num_seq_no ) as process_name , string_agg(p.str_process_path,',' order by num_seq_no ) as process_url from ROLE_MENU_MST a, GROUP_MST b , process_mst p where a.NUM_GROUP_ID=b.NUM_GROUP_ID and a.num_isvalid=1 and b.num_isvalid=1 and a.num_role_id = ? and  p.num_process_id   =ANY ( string_to_array(a.STR_PROCESS_ID, ',') ) GROUP BY a.NUM_GROUP_ID, b.STR_GROUP_NAME order by a.NUM_GROUP_ID";
		paraList.add(0, roleId);
		return daoHelper.getData(query, paraList);

		
	}

	public List<SeatMaster> getSeatMstData(Integer numSeatId) {
		
		TypedQuery<SeatMaster> fetchData=em.createQuery("select c from SeatMaster c where numIsValid=1 and c.numSeatId=?1",SeatMaster.class);
		fetchData.setParameter(1, numSeatId);
		List<SeatMaster> sm=fetchData.getResultList();
		LOGGER.info("numSeatId {} ",numSeatId);
		
		LOGGER.info("List Size {} ",sm.size());					
		return sm;
	}

	public String AddSeatMaster(long userId) {
		String fun = "call dava.dml_userregistration(?)";
		//int userid = userId.intValue();
		daoHelper.callProcedure(fun, userId);
		return "success";
	}
	
	public String getProfilePercentage(int seatId) {
		
		String fun = "call dava.profile_per(?)";
		//System.out.println("testing stored procedure and function");
		
		
		 String a=daoHelper.ViewxmlForFunction("profile_per",seatId);
		 //System.out.println("working stored procedure and function");
		 //System.err.println("Profile Completeness"+a);
		 return a;
	}
	
	

	public List<TileDomain> getTile(Integer numRoleId) {
		TypedQuery<TileDomain> fetchData=em.createQuery("select t from TileDomain t where numIsValid=1 and t.numRoleId=?1 order by numSeqNo",TileDomain.class);
		fetchData.setParameter(1, numRoleId);
		List<TileDomain> sm=fetchData.getResultList();
		LOGGER.info("numSeatId {} ",numRoleId);
		
		LOGGER.info("List Size {} ",sm.size());					
		return sm;
	}
	
	
	public List<HSCodeDomain> getHSCodeDtls() {
		TypedQuery<HSCodeDomain> fetchData=em.createQuery("select c from HSCodeDomain c where numIsValid=1",HSCodeDomain.class);
		List<HSCodeDomain> HSCodeDtls=fetchData.getResultList();
		
		
		
		
		
		
		LOGGER.info("List Size {} ",HSCodeDtls.size());					
		return HSCodeDtls;
	}

	public List<RegionMstDomain> getRegionMstDtls() {
		TypedQuery<RegionMstDomain> fetchData=em.createQuery("select c from RegionMstDomain c where numIsValid=1",RegionMstDomain.class);
		List<RegionMstDomain> regionDtls=fetchData.getResultList();
		LOGGER.info("List Size {} ",regionDtls.size());					
		return regionDtls;
	}

	public DistributionMstDomain savePointsOfDistributionDtls(DistributionMstDomain dmDom) {
		em.persist(dmDom);
		return dmDom;
	}
	
	public ReportProblemDomain saveReportProblem(ReportProblemDomain locDom) {
		//List<ReportProblemDomain> response = null;
		System.out.println("problem domain ========   "+locDom.getProblem_id());
		em.persist(locDom);
	//	List<ReportProblemDomain> roleList=getResultList();
	//	List<ReportProblemDomain>list=saveReportProblem(locDom);
		
		return locDom;
	}
	

	public List<StorageCondMstDom> getStorageDomain() {
		TypedQuery<StorageCondMstDom> fetchData=em.createQuery("select c from StorageCondMstDom c where numIsValid=1",StorageCondMstDom.class);
		List<StorageCondMstDom> storageDtls=fetchData.getResultList();
		LOGGER.info("List Size {} ",storageDtls.size());					
		return storageDtls;
	}

	public List<InstPremiseDtlDomain> getPremiseAddress(Integer manufactureId) {
		TypedQuery<InstPremiseDtlDomain> premiseDtl= em.createQuery("select d from InstPremiseDtlDomain d where d.numPremiseNo=?1",InstPremiseDtlDomain.class);
		premiseDtl.setParameter(1, manufactureId);
		List<InstPremiseDtlDomain> preDtl=premiseDtl.getResultList();
		LOGGER.info("Premise List size {} ",preDtl.size());
		return preDtl;
	}

	public List<InstPremiseDtlDomain> getInstPremisesDtlsById(int manuUnit) {
		System.err.println("num premises no- --- "+manuUnit);
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where numIsValid=1 and c.numPremiseNo=?1",InstPremiseDtlDomain.class);
		fetchData.setParameter(1, manuUnit);
		List<InstPremiseDtlDomain> instPremiseDtl=fetchData.getResultList();
		
		LOGGER.info("List Size {} ",instPremiseDtl.size());					
		return instPremiseDtl;
	}

	/*
	 * select ipd.num_premises_no from institute_premises_dtl ipd inner join
	 * user_registration usr on usr.manf_site_name = ipd.str_premises_name where
	 * usr.user_id = 1254; public int getManuName(int userId) {
	 * TypedQuery<RegistrationDetails> fetchData=em.
	 * createQuery("select c.manf_site_name from user_registration c where numIsValid=1 and c.user_id=?1"
	 * ,RegistrationDetails.class); fetchData.setParameter(1, userId);
	 * List<RegistrationDetails> userDetail=fetchData.getResultList(); int manuName
	 * = userDetail.get(0). LOGGER.info("List Size {} ",userDetail.size()); return
	 * manuName; }
	 */
	 

	public List<RegistrationDetails> getUserDetail(String userName) {
		System.err.println("userName-----------    "+userName);
		TypedQuery<RegistrationDetails> fetchData=em.createQuery("select c from RegistrationDetails c where numIsValied=1 and c.userName=?1",RegistrationDetails.class);
		fetchData.setParameter(1, userName);
		List<RegistrationDetails> userDetail=fetchData.getResultList();
		LOGGER.info("List Size {} ",userDetail.size());					
		return userDetail;
	}
	
	public List<RegistrationDetails> getUserDetailfromUserId(Long userId) {
		System.err.println("userIddddddddd-----------    "+userId);
		TypedQuery<RegistrationDetails> fetchData=em.createQuery("select c from RegistrationDetails c where numIsValied=1 and c.userId=?1",RegistrationDetails.class);
		fetchData.setParameter(1, userId);
		List<RegistrationDetails> userDetail=fetchData.getResultList();
		LOGGER.info("List Size {} ",userDetail.size());					
		return userDetail;
	}

	public List<DataUploadTypeMstDomain> getDataUploadType() {
		TypedQuery<DataUploadTypeMstDomain> fetchData=em.createQuery("select c from DataUploadTypeMstDomain c where numIsValid=1",DataUploadTypeMstDomain.class);
		List<DataUploadTypeMstDomain> dataTypeList=fetchData.getResultList();
		
		LOGGER.info("List Size {} ",dataTypeList.size());					
		return dataTypeList;
	}

	public InstituteMemberDetailDomain deleteMemberDetails(MemberDetailForm memDtlForm) {
		TypedQuery<InstituteMemberDetailDomain> fetchData=em.createQuery("select c from InstituteMemberDetailDomain c where numIsValid=1 and c.numMemberId=?1",InstituteMemberDetailDomain.class);
		fetchData.setParameter(1, memDtlForm.getNumMemberId());
		List<InstituteMemberDetailDomain> docList=fetchData.getResultList();
		Iterator<InstituteMemberDetailDomain> itr = docList.iterator();
		while (itr.hasNext()) {
			InstituteMemberDetailDomain md = itr.next();
			md.setNumIsValid(0);
			
		em.merge(md);
		}
		return null;
		
	}

	public RegistrationDetails deleteManufUserDetail(Long userId) {
		System.err.println("in dava trans");
		System.err.println("userId in trans : " + userId);
		TypedQuery<RegistrationDetails> fetchData=em.createQuery("select c from RegistrationDetails c where numIsValied=1 and c.userId=?1",RegistrationDetails.class);
		fetchData.setParameter(1, userId);
		List<RegistrationDetails> userDetail=fetchData.getResultList();
		Iterator<RegistrationDetails> itr = userDetail.iterator();
		while (itr.hasNext()) {
			RegistrationDetails rd = itr.next();
			rd.setUserName(userDetail.get(0).getUserName()+"_old");
			rd.setNumIsValied(0);
			
		em.merge(rd);
		}
		return null;
	}
 
 public InstPremiseDtlDomain deletemanufsitedetail(int premiseno) {
		System.err.println("in dava trans");
		System.err.println("userId in trans : " + premiseno);
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where numIsValid=1 and c.numPremiseNo=?1",InstPremiseDtlDomain.class);
		fetchData.setParameter(1, premiseno);
		List<InstPremiseDtlDomain> instdetail=fetchData.getResultList();
		Iterator<InstPremiseDtlDomain> itr = instdetail.iterator();
		while (itr.hasNext()) {
			InstPremiseDtlDomain rd = itr.next();
			//rd.setUserName(userDetail.get(0).getUserName()+"_old");
			rd.setNumIsValid(0);
			
		em.merge(rd);
		}
		return null;
	}

	
	
	
	public List<InstituteMemberDetailDomain> getAddedMemberData(int memberId) {
		TypedQuery<InstituteMemberDetailDomain> fetchData=em.createQuery("select c from InstituteMemberDetailDomain c where numIsValid=1 and c.numMemberId=?1",InstituteMemberDetailDomain.class);
		fetchData.setParameter(1,memberId);
		List<InstituteMemberDetailDomain> dataList=fetchData.getResultList();

		return dataList;
		
	}

	public InstituteMemberDetailDomain updateMemberDetails(InstituteMemberDetailDomain instMemDtlDomain) {
		
		
		  if(instMemDtlDomain.getNumMemberId() != 0) {
			  em.merge(instMemDtlDomain); 
			  }
		  else
		  {
			  System.out.println("null value exist"); 
			  }
		  return instMemDtlDomain;
		 
	}

	public RegistrationDetails updateManfUserDetail(RegistrationDetails registrationDetails) {
		System.err.println("in dava trans");
		System.out.println("registrationDetails.getUserId() : " + registrationDetails.getUserId());
		if(registrationDetails.getUserId()!= null) 
			em.merge(registrationDetails);
		else
		{
			System.out.println("null value exist"); 
		}
		return registrationDetails;
	}


	public List<ReportProblemDomain> getProblemDeatil(int problem_id) {
		TypedQuery<ReportProblemDomain> fetchData=em.createQuery("select c from ReportProblemDomain c where numIsValid=1 and c.problem_id=?1",ReportProblemDomain.class);
		fetchData.setParameter(1,problem_id);
		List<ReportProblemDomain> dataList=fetchData.getResultList();
		System.err.println("dataList size= "+dataList.size());
		//System.err.println(dataList.get(0).getProblem_no()+"11111");
		return dataList;
		
	}

	public List<InstPremiseDtlDomain> getInstPremiseDtls(Integer numPremiseNo) {
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where numIsValid=1 and c.numPremiseNo=?1",InstPremiseDtlDomain.class);
		fetchData.setParameter(1,numPremiseNo);
		List<InstPremiseDtlDomain> dataList=fetchData.getResultList();

		return dataList;
	}
	
	public UploadXmlDataDtlDomain saveUploadDtl(UploadXmlDataDtlDomain uploadDomain) {
		em.persist(uploadDomain);
		return uploadDomain;
	}

	public List<String> getUploadedDataDtl() {
		TypedQuery<String> fetchData=em.createQuery("select c.strHashCode from UploadXmlDataDtlDomain c ",String.class);
		List<String> dataList=fetchData.getResultList();

		return dataList;
		
	}

	public CountryRegionMapDomain saveMappingDtls(CountryRegionMapDomain crDom) {
		// TODO Auto-generated method stub
		em.persist(crDom);
		
		return crDom;
	}

	public void updateInstPremiseDtl(int manuUnit, Long userId) {
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where numIsValid=1 and c.numPremiseNo=?1",InstPremiseDtlDomain.class);
		fetchData.setParameter(1, manuUnit);
		List<InstPremiseDtlDomain> docList=fetchData.getResultList();
		Iterator<InstPremiseDtlDomain> itr = docList.iterator();
		while (itr.hasNext()) {
			InstPremiseDtlDomain md = itr.next();
			md.setNumSubloginUserid(userId.intValue());
			
		em.merge(md);
		}
		
		
	}

	public List<InstPremiseDtlDomain> getInstPremisesDtlsForSublogin(int InstId) {
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where numIsValid=1 and c.numInstid=?1",InstPremiseDtlDomain.class);
		fetchData.setParameter(1, InstId);
		List<InstPremiseDtlDomain> instPremiseDtl=fetchData.getResultList();
		LOGGER.info("List Size {} ",instPremiseDtl.size());					
		return instPremiseDtl;
	}
	
	public List<UploadXmlDataDtlDomain> getUploadedDataDtl(Integer uploadId) {
		TypedQuery<UploadXmlDataDtlDomain> fetchData=em.createQuery("select c from UploadXmlDataDtlDomain c where c.numUploadId=?1",UploadXmlDataDtlDomain.class);
		fetchData.setParameter(1, uploadId);
		List<UploadXmlDataDtlDomain> dataList=fetchData.getResultList();

		return dataList;
		
	}
	
	public List<UploadXmlDataDtlDomain> getUploadedDataDtlWitjoutStatus(Integer uploadId) {
		
		
		TypedQuery<UploadXmlDataDtlDomain> fetchData=em.createQuery("select c from UploadXmlDataDtlDomain c where c.numUploadId=?1",UploadXmlDataDtlDomain.class);
		
		
		fetchData.setParameter(1, uploadId);
		List<UploadXmlDataDtlDomain> dataList=fetchData.getResultList();
		
		return dataList;
		
	}

	public ReportProblemDomain updateReportProblem(ReportProblemDomain reportDom) {
		em.merge(reportDom);
		return reportDom;
	}

	public List<ReportProblemDomain> getFeedbackMstData(Integer problemId) {
		TypedQuery<ReportProblemDomain> feedbackMaster= em.createQuery("select d from ReportProblemDomain d where d.problem_id=?1",ReportProblemDomain.class);
		feedbackMaster.setParameter(1, problemId);
		List<ReportProblemDomain> feedbackMst=feedbackMaster.getResultList();
		LOGGER.info("Report problem List size {} ",feedbackMst.size());
		return feedbackMst;
	}
	
	public String totalRecall(Integer upId, Long UserId) {
		Integer uId= UserId.intValue();
		String fun = "dava.dml_total_recall";
		//int userid = userId.intValue();
		daoHelper.callProcedure1(fun, upId, uId);
		return "success";
	}

	
	
	
	public String saveProductInTable(Integer upId,String fileasString, Integer instId) {
		//System.err.println("mani789bansal sir");
		//dml_insert_product(uploadid int4, input_xml varchar, instid int4, errorflag int4, errormsg varchar)
		String fun = "dava.dml_insert_product";
		String errormsg="";
		//int userid = userId.intValue(); callProcdureWith2Param
		//boolean result=	daoHelper.callProcdureString(fun, fileasString);
		
		String result=	daoHelper.callProcedure2(fun,upId,fileasString,instId);
		System.err.println("mani789"+result);
		return result;
	}


	public void updateFinalStatus(int docId, String xmlPreview) {
		TypedQuery<UploadXmlDataDtlDomain> fetchData=em.createQuery("select c from UploadXmlDataDtlDomain c where numIsValid=1 and c.numDocumentId=?1",UploadXmlDataDtlDomain.class);
		fetchData.setParameter(1, docId);
		List<UploadXmlDataDtlDomain> docList=fetchData.getResultList();
		Iterator<UploadXmlDataDtlDomain> itr = docList.iterator();
		while (itr.hasNext()) {
			UploadXmlDataDtlDomain dmd = itr.next();
			dmd.setNumStatus(1);
			//dmd.setUploaded_xml(xmlPreview);
			dmd.setXmlData(xmlPreview);
			em.merge(dmd);
		}
	}
	
	public void updateFinalStatus(int docId, StringBuffer xmlPreview) {
		TypedQuery<UploadXmlDataDtlDomain> fetchData=em.createQuery("select c from UploadXmlDataDtlDomain c where numIsValid=1 and c.numDocumentId=?1",UploadXmlDataDtlDomain.class);
		fetchData.setParameter(1, docId);
		List<UploadXmlDataDtlDomain> docList=fetchData.getResultList();
		Iterator<UploadXmlDataDtlDomain> itr = docList.iterator();
		while (itr.hasNext()) {
			UploadXmlDataDtlDomain dmd = itr.next();
			dmd.setNumStatus(1);
			//dmd.setUploaded_xml(xmlPreview);
			//dmd.setXmlData(xmlPreview);
			em.merge(dmd);
		}
	}

	public void saveDeskConfigDtls(DesktopConfigDtlDom dskConDom) {
		em.persist(dskConDom);
	}
	
	public void insertPromotionCouncil(OtherPromotionCouncilDetails otherPromotionCouncilDetails) {
		if(otherPromotionCouncilDetails.getId()!=null) {
			em.merge(otherPromotionCouncilDetails);
		}else {
			em.persist(otherPromotionCouncilDetails);
		}
	}

	public boolean saveManufacturingInTable(String fileasString) {
		String fun = "call dava.dml_insert_manufacturer(?)";
		boolean result=	daoHelper.callProcdureString(fun, fileasString);
		return result;
	}
	

	public boolean savePackagingInTable(String fileasString) {
		String fun = "call dava.dml_insert_consignment(?)";
		boolean result=	daoHelper.callProcdureString(fun, fileasString);
		return result;
	}

	public List<TherepueticClassDom> getTherepueticClass() {
		TypedQuery<TherepueticClassDom> fetchData=em.createQuery("select c from TherepueticClassDom c where numIsValid=1",TherepueticClassDom.class);
		List<TherepueticClassDom> theClassList=fetchData.getResultList();
		LOGGER.info("Therepietic Class List Size {} ",theClassList.size());
		return theClassList;
	}

	public ConsignmentDetailDomain saveConsignmentDetails(ConsignmentDetailDomain consignmentDetailDomain) {
		em.persist(consignmentDetailDomain);
		return consignmentDetailDomain;
	}
	

	public List<DrugMst> getProductNames() {
		
		TypedQuery<DrugMst> fetchData=em.createQuery("select c from DrugMst c where c.numIsValid=1 ",DrugMst.class);
		List<DrugMst> dataTypeList=fetchData.getResultList();
		return dataTypeList;
	}
	
	public List<DrugMst> getProductNames(Integer InstId) {
		
		TypedQuery<DrugMst> fetchData=em.createQuery("select c from DrugMst c where c.numIsValid=1 and numInstId = ?1",DrugMst.class);
		fetchData.setParameter(1, InstId);
		List<DrugMst> dataTypeList=fetchData.getResultList();
		return dataTypeList;
	}

	public List<CountryMst> getCountrybasedOnRegion(Integer regionId) {
		TypedQuery<CountryRegionMapDomain> fetchData=em.createQuery("select c from CountryRegionMapDomain c where c.region_Id=?1",CountryRegionMapDomain.class);
		fetchData.setParameter(1, regionId);
		
		List<CountryRegionMapDomain> countrybasedOnRegion=fetchData.getResultList();
		
		List<Integer> countryId=new ArrayList<>();
		
		for (CountryRegionMapDomain countryRegionMapDomain : countrybasedOnRegion) {
			countryId.add(countryRegionMapDomain.getCountry_Id());
		}
		
		TypedQuery<CountryMst> fetchCountryData=em.createQuery("select c from CountryMst c where c.num_country_id in (:ids)",CountryMst.class);
		fetchCountryData.setParameter("ids", countryId);
		
		List<CountryMst> countryData=fetchCountryData.getResultList();
		LOGGER.info("get Country size=="+countryData.size());
		return countryData;
	}

	public boolean saveExportOrderDetails(ExportOrderDomain exportOrderDomain) {
		boolean result=false;
		try {
			if(exportOrderDomain.getExp_id()!=null) 
				em.merge(exportOrderDomain);
			else
				em.persist(exportOrderDomain);
			result=true;
		} catch (Exception e) {
			result=false;
			return result;
		}
		
		return result;
	}

	public List<ExportOrderDomain> getExportOrderDtls() {
		TypedQuery<ExportOrderDomain> fetchCountryData=em.createQuery("select c from ExportOrderDomain c where c.numIsValid=1",ExportOrderDomain.class);
		List<ExportOrderDomain> expList=fetchCountryData.getResultList();
		LOGGER.info("Export order List Size {} ",expList.size());
		return expList;
	}

	public List<DrugMst> getProdCode(Integer drugId) {
		TypedQuery<DrugMst> prodDtl= em.createQuery("select d from DrugMst d where d.numDrugId=?1",DrugMst.class);
		prodDtl.setParameter(1, drugId);
		List<DrugMst> proDtl=prodDtl.getResultList();
		LOGGER.info("Prod List size {} ",proDtl.size());
		return proDtl;
	}

	public ProcurementMstDomain saveProcurementMasterDtls(ProcurementMstDomain pmDom) {
		em.persist(pmDom);
		return pmDom;
	}

	public void saveDrugDetails(DrugMst drug) {
		em.persist(drug);
	}

	public void saveManufacturingPremiseDetails(InstPremiseDtlDomain premiseDetails) {
		em.persist(premiseDetails);
	}

	public void persistConsignmentDetailEntities(EXP_TERTIARY_LIST_DETAILS exp,
			ConsignmentDetailsEntity consignmentDetailsEntity, EXPORT_DETAILS exportDetails) {
		em.persist(exp);
		em.persist(consignmentDetailsEntity);
		em.persist(exportDetails);
		
	}

	public void addTertiaryDetails(TERTIRY_DETAILS tertiaryDetails) {
		em.persist(tertiaryDetails);
	}

	public void addSecondary3Details(SECONDARY3_DETAILS secondary3Details) {
		em.persist(secondary3Details);
	}

	public void addSecondary2Details(SECONDARY2_DETAILS secondary2Details) {
		em.persist(secondary2Details);
	}

	public void addSecondary1Details(SECONDARY1_DETAILS secondary1Details) {
		em.persist(secondary1Details);
	}

	public void addProductdetails(ProductDetails productDetails) {
		em.persist(productDetails);
	}
	
	public List<Object[]> getStateStatistics(Long userId) {
		
		List<Object[]> result=new ArrayList<Object[]>();
		ArrayList<Object> paraList=new ArrayList<Object>();
		String tt="1001";
		String query="SELECT count(institute_premises_dtl.num_state_id),states_mst.str_state_name,institute_premises_dtl.num_state_id from dava.institute_premises_dtl, dava.states_mst where institute_premises_dtl.num_state_id=states_mst.num_state_id" + 
				" and institute_premises_dtl.num_tr_user_id=? GROUP BY states_mst.str_state_name ,institute_premises_dtl.num_state_id";
		paraList.add(0, tt);
		result= daoHelper.getData(query, paraList);
		return result;
		
		
		
		
		
		
		
		
		/*
		 * try { //String
		 * query="SELECT count(a.numStateId),b.str_state_name from InstPremiseDtlDomain a ,StatesMst b where b.num_state_id=a.numStateId and a.numTrUserId=?1 GROUP BY b.str_state_name"
		 * ; //Query stateStatisticsMaster=em.createQuery(query); Query
		 * stateStatisticsMaster= em.
		 * createQuery("SELECT count(a.numStateId),b.str_state_name from InstPremiseDtlDomain a ,StatesMst b where b.num_state_id=a.numStateId and a.numTrUserId=?1 GROUP BY b.str_state_name"
		 * ); stateStatisticsMaster.setParameter(1, 1001);
		 * 
		 * List<Object> statestMst=stateStatisticsMaster.getResultList();
		 * LOGGER.info("statewise statistics List size {} ",statestMst.size()); return
		 * statestMst;} catch(Exception e) { e.printStackTrace(); }
		 */
		//
	}
	

	
	public List<InstPremiseDtlDomain> getAllInstStateDetails(int stateID) {
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where c.numIsValid=1 and c.numStateId=?1",InstPremiseDtlDomain.class);
		fetchData.setParameter(1, stateID);
		List<InstPremiseDtlDomain> instPremiseDtl=fetchData.getResultList();
		LOGGER.info("List Size {} ",instPremiseDtl.size());					
		return instPremiseDtl;
	}

	public List<Object[]> getCountryStatistics(Long userId) {
		//Map<String, Integer> result=new HashMap<String, Integer>();
		List<Object[]> result=new ArrayList<Object[]>();
		ArrayList<Object> paraList=new ArrayList<Object>();
		//List<Object> paraList=new ArrayList<Object>();
		String tt="1001";
		String query="SELECT count(a.num_country_id),b.str_country_name from dava.export_order_mst a, dava.country_mst b where a.num_country_id=b.num_country_id" + 
				" and a.num_tr_user_id=? GROUP BY b.str_country_name";
		paraList.add(0, tt);
		result= daoHelper.getData(query, paraList);
 		return result;
		
	}
	
	
	public String getRoleName(int seatId) {
		
		String fun = "call dava.getrolename(?)";
		String roleName = daoHelper.ViewxmlForFunction("getrolename",seatId);
		System.out.println("working stored procedure and function");
		return roleName;
	}

	public void updateKeyinUR(Long userId, String mac_address, String publicKey) {
		String fun = "call dava.dml_userconfig_pk(?)";
		String UR = daoHelper.getListJSON3Param("dml_userconfig_pk",userId,mac_address,publicKey);
		System.out.println("working stored procedure and function   "+UR.length());
	}
	
	
	//added by harshita
	
	public Boolean updatePasswordcnf(RegistrationDetails RegistrationDetails) {
        
        try{
                daoHelper.merge(RegistrationDetails.class, RegistrationDetails);
                
                return true;
        }catch(Exception e){
                return false;
        }
}




	
	public List<InstituteMasterDomain> getInstituteData(Integer instId) {
		TypedQuery<InstituteMasterDomain> instMaster= em.createQuery("select d from InstituteMasterDomain d where d.numInstId=?1 and d.numIsValid=1",InstituteMasterDomain.class);
																						  
		instMaster.setParameter(1, instId);
		List<InstituteMasterDomain> instMst=instMaster.getResultList();
		LOGGER.info("Institute List size {} ",instMst.size());
		return instMst;
	}

	public WorkshopRegistrationDomain saveWorshopRegDetails(WorkshopRegistrationDomain dom, HttpServletRequest request) {
		em.persist(dom);
		return dom;
	}

	
	


	public CodeRequestMstDomain saveCodeRequestDetails(CodeRequestMstDomain dom) {
		em.persist(dom);
		return dom;
	}

	public List<UploadXmlDataDtlDomain> getUploadedDetails(int docId) {
		TypedQuery<UploadXmlDataDtlDomain> uploadDtl= em.createQuery("select d from UploadXmlDataDtlDomain d where d.numDocumentId=?1 and d.numIsValid=1",UploadXmlDataDtlDomain.class);
		 
		
		uploadDtl.setParameter(1, docId);
		List<UploadXmlDataDtlDomain> upload=uploadDtl.getResultList();
		LOGGER.info("Institute List size {} ",upload.size());
		return upload;
	}
	
	public Integer saveConsignmentDetailsInTable(Integer uploadId) {
		String fun = "exec dava.dml_insert_pack_dtl(?)";
		//int userid = userId.intValue();
		System.out.println("uploadId of xml file - " + uploadId);
		Integer result=	daoHelper.callProcdureInteger(fun, uploadId);
		return result;
	}

	public String getPackCode(Integer requestId) {
		String test=daoHelper.getListJSON("codelist",requestId);
		return test;
	}
	public String getduplicateCodes(String xmlData) {
		String result=	daoHelper.getListJSON("checkForDuplicateCodes", xmlData);
		return result;
	}
	
	public String getConsignmentDetails(int invoiceId) {
		String result=	daoHelper.getListJSON("getconsignmnetdetails", invoiceId);
		return result;
	}

	public String getAckDocumentFileNameForDownload(int doc_id) {
		TypedQuery<String> fetchCountryData=em.createQuery("select c.strAckReceipt from UploadXmlDataDtlDomain c where c.numIsValid=1 and c.numDocumentId="+doc_id,String.class);
		if(fetchCountryData.getResultList().size()>0) {
		String expList=fetchCountryData.getResultList().get(0);
		return expList;
		}else
			return null;
	}
	

	public void addEmailDetailsToDb(EmailDetailDomain emailDom) {
		em.persist(emailDom);		
	}

	public EmailMstDomain saveEmailMstToDb(EmailMstDomain emd) {
		em.persist(emd);	
		return emd;
	}
	
	

	public List<DrugMst> checkDuplicateRecordDrugMst(DrugMst drugDom) {
		
		Query query=em.createNamedQuery("checkdupDrug");
		query.setParameter(1, drugDom.getStrBrandName());
		query.setParameter(2, drugDom.getStrGenericName());
		List<DrugMst> obj=query.getResultList();
		return obj;
	}

	public PortOfExportDomain addPortOfExport(PortOfExportDomain port) {
		em.persist(port);
		return port;
	}
	
	public UploadXmlDataDtlLogDomain saveUploadDtlLog(UploadXmlDataDtlLogDomain uploadDomain) {
		em.persist(uploadDomain);
		return uploadDomain;
	}

	public void savePasswordHistoryDetails(PasswordHistory passwordHistory) {
		em.persist(passwordHistory);
		System.out.println("savePasswordHistoryDetails::"+passwordHistory);
	}

	public galleryFormentity savegalleryform(galleryFormentity entityobj) {
		em.persist(entityobj);		
		return entityobj;
	}

	/*
	 * public List<galleryFormentity> getEventlist(String limit) {
	 * 
	 * TypedQuery<galleryFormentity> fetchData=null; if(limit.equals("3")) {
	 * fetchData=em.
	 * createQuery("select c from galleryFormentity c where c.num_isvalid=1 order by c.eventDate DESC"
	 * ,galleryFormentity.class); fetchData.setMaxResults(3); } else { fetchData=em.
	 * createQuery("select c from galleryFormentity c where c.num_isvalid=1 order by c.eventDate DESC"
	 * ,galleryFormentity.class); fetchData.setMaxResults(10); }
	 * //fetchData.setParameter(1, stateID); List<galleryFormentity>
	 * galleryEventDtl=fetchData.getResultList();
	 * LOGGER.info("List Size {} ",galleryEventDtl.size()); return galleryEventDtl;
	 * 
	 * }
	 */

	public galleryFormentity Updategalleryform(galleryFormentity entityobj) {
		em.merge(entityobj);		
		return entityobj;
	}
	

	public galleryFormentity deletegallerydetail(Long galleryId) {
		TypedQuery<galleryFormentity> fetchData=em.createQuery("select c from galleryFormentity c where num_isvalid=1 and c.galleryId=?1",galleryFormentity.class);
		fetchData.setParameter(1, galleryId);
		List<galleryFormentity> docList=fetchData.getResultList();
		Iterator<galleryFormentity> itr = docList.iterator();
		galleryFormentity dmd=null;
		while (itr.hasNext()) {
			dmd = itr.next();
			dmd.setNum_isvalid(0);
			
			
			em.merge(dmd);
		}
		return dmd;
	}
	public NewsEventsDomain addNewsEvents(NewsEventsDomain news) {
		em.persist(news);
		return news;
	}
	
	public List<ZoneMst> getZoneData() {
		TypedQuery<ZoneMst> zoneMaster= em.createQuery("select d from ZoneMst d where d.num_isvalid=1",ZoneMst.class);
												
		List<ZoneMst> zonesMst=zoneMaster.getResultList();
		LOGGER.info("Zone List size {} ",zonesMst.size());
		return zonesMst;
	}

	public List<LocationMasterDomain> getLocationMstData() {
		TypedQuery<LocationMasterDomain> locMaster= em.createQuery("select d from LocationMasterDomain d where d.numIsValid=1",LocationMasterDomain.class);
		List<LocationMasterDomain> locsMst=locMaster.getResultList();
		LOGGER.info("Location List size {} ",locsMst.size());
		return locsMst;
	}

	public void saveAppTypeMaster(ApprovalTypeMst app) {
		em.persist(app);	
	}

	public List<SiteTypeMstDomain> getAllSites(String applicantType) {
		TypedQuery<SiteTypeMstDomain> siteMaster = null ; 
		if(applicantType.equals("100")) {
			siteMaster = em.createQuery("select d from SiteTypeMstDomain d where d.numIsValid=1 and siteTypeFlag = 1",SiteTypeMstDomain.class);
		}else {
			siteMaster = em.createQuery("select d from SiteTypeMstDomain d where d.numIsValid=1 and siteTypeFlag = 2",SiteTypeMstDomain.class);
		}
		List<SiteTypeMstDomain> siteMst=siteMaster.getResultList();
		LOGGER.info("Site List size {} ",siteMst.size());
		return siteMst;
	}

	public List<RegistrationDetails> getAllRegDet() {
		TypedQuery<RegistrationDetails> reg = em.createQuery("select d from RegistrationDetails d where d.numIsValied=1 and applicantType in(100,101)",RegistrationDetails.class);
		List<RegistrationDetails> regDet =reg.getResultList();
		LOGGER.info("Registration List size {} ",regDet.size());
		return regDet;
	}
	
	public List<Object> nativeQuery(String query)
	{
		Query q=em.createNativeQuery(query);
		return q.getResultList();
	}
	
	public RegistrationDetails saveRegDtl(RegistrationDetails registrationDetails) {
		em.persist(registrationDetails);
		return registrationDetails;
	}

	public LocationMasterDomain saveLocDtl(LocationMasterDomain locationMasterDomain) {
		em.persist(locationMasterDomain);
		return locationMasterDomain;
	}

	public List<ZoneMst> getZoneDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOfficialReg(OfficialRegistrationDetails officialRegDetails) {
		em.persist(officialRegDetails);
	}

	public List<PromotionCouncilMaster> getPromotionCouncil() {
		TypedQuery<PromotionCouncilMaster> promCouncil= em.createQuery("select d from PromotionCouncilMaster d",PromotionCouncilMaster.class);
		List<PromotionCouncilMaster> promCouncilList=promCouncil.getResultList();
		LOGGER.info("Promotion Council List size {} ",promCouncilList.size());
		return promCouncilList;
	}

	public PointOfDistributionMst saveAllPointOfDistribution(PointOfDistributionMst point) {
		em.persist(point);
		return point;
	}

	public List<StaticsDataDomain> getAllStatsData() {
		TypedQuery<StaticsDataDomain> statistics= em.createQuery("select d from StaticsDataDomain d",StaticsDataDomain.class);
		List<StaticsDataDomain> stats=statistics.getResultList();
		LOGGER.info("Statistics List size {} ",stats.size());
		return stats;
	}

	public RegistrationDetails findByUserId(String userName) {
			TypedQuery<RegistrationDetails> registrationEntity=
					em.createQuery("select d from RegistrationDetails d where d.userName=?1",RegistrationDetails.class);
			registrationEntity.setParameter(1, userName);
			RegistrationDetails entity=null;
			try {
				entity=registrationEntity.getSingleResult();
			} catch (NoResultException e) {
				LOGGER.info("No result found against user name {} ",userName);
				return entity;
			}
			
			return entity;
	}

	public List<ReportProblemDomain> getFeedbackdata() {
		TypedQuery<ReportProblemDomain> registrationEntity=
				em.createQuery("select d from ReportProblemDomain d where",ReportProblemDomain.class);
		return registrationEntity.getResultList();
	}

	public String saveRegionMstDetails(RegionMstDomain rm) {
		String response = "";
			em.persist(rm);
		return response;
	}

	public String updateRegionMstDetails(RegionMstDomain rm) {
		String response = "";
			em.merge(rm);
		return response;
	}

	public PortOfExportDomain updatePortOfExp(PortOfExportDomain port) {
		PortOfExportDomain response = em.merge(port);
		return response;
	}
	
	public List<UploadXmlInvoiceDtlDomain> getInvoiceDetails(Integer uploadId) {
		TypedQuery<UploadXmlInvoiceDtlDomain> uploadDtl= em.createQuery("select d from UploadXmlInvoiceDtlDomain d where d.numUploadId=?1 ",UploadXmlInvoiceDtlDomain.class);
		uploadDtl.setParameter(1, uploadId);
		List<UploadXmlInvoiceDtlDomain> invoiceDtl=uploadDtl.getResultList();
		LOGGER.info("List size {} ",invoiceDtl.size());
		return invoiceDtl;
	}

	public UploadXmlInvoiceDtlDomain updateConsignmentDetails(UploadXmlInvoiceDtlDomain inv) {
		UploadXmlInvoiceDtlDomain response = em.merge(inv);
		return response;
	}

	public List<PortOfExportDomain> getAllPorts() {
		TypedQuery<PortOfExportDomain> portDtl = em.createQuery("select p from PortOfExportDomain p where p.numIsValid=1",PortOfExportDomain.class);
		List<PortOfExportDomain> portList = portDtl.getResultList();
		return portList;
	}

	public UploadConsignDtlDomain saveConDtls(UploadConsignDtlDomain conDtls) {
		em.persist(conDtls);
		return conDtls;
	}

	public UploadPurchaseOrderDtlDom savePODetails(UploadPurchaseOrderDtlDom purDtls) {
		em.persist(purDtls);
		return purDtls;
	}

	public UploadInvoiceDtlDomain saveInvoiceDtls(UploadInvoiceDtlDomain invDtls) {
		em.persist(invDtls);
		return invDtls;
	}

	public List<DesktopConfigDtlDom> getDesktopCongDtl(Long uId) {
		TypedQuery<DesktopConfigDtlDom> deskDtl= em.createQuery("select d from DesktopConfigDtlDom d where d.numUserId=?1 ",DesktopConfigDtlDom.class);
		deskDtl.setParameter(1, uId);
		List<DesktopConfigDtlDom> dDtl=deskDtl.getResultList();
		LOGGER.info("List size {} ",dDtl.size());
		return dDtl;
	}

	public FileUploadLogEntity saveFileLogs(FileUploadLogEntity fileLog) {
		em.persist(fileLog);
		return fileLog;
	}

	public List<InstPremiseDtlDomain> getInstPremisesDtlsSubLogin(Integer instId, Integer premiseNo) {
		TypedQuery<InstPremiseDtlDomain> fetchData=em.createQuery("select c from InstPremiseDtlDomain c where numIsValid=1 and c.numInstid=?1 and c.numPremiseNo=?2",InstPremiseDtlDomain.class);
		fetchData.setParameter(1, instId);
		fetchData.setParameter(2, premiseNo);
		List<InstPremiseDtlDomain> instPremiseDtl=fetchData.getResultList();
		LOGGER.info("List Size {} ",instPremiseDtl.size());					
		return instPremiseDtl;
	}

	
	public List<ReportProblemDomain> getFeedBackStatusData() {
		TypedQuery<ReportProblemDomain> registrationEntity=
				em.createQuery("select d from ReportProblemDomain d where d.numIssueStatus IS null",ReportProblemDomain.class);
		return registrationEntity.getResultList();
	}

	public void updatefeedbackresponses(ReportProblemDomain dom) {
		em.merge(dom);
	}



	

}
