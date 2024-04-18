package in.cdacnoida.dava.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.CountryRegionMapDomain;
import in.cdacnoida.dava.entities.DistributionMstDomain;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.model.CountryRegionMapModel;
import in.cdacnoida.dava.model.PointsOfDisModel;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class CountryRegionMapServiceImpl implements CountryRegionMapService {

	@Autowired
	public DavaServices dSer;

	@Autowired
	private DavaTransactions davaTransactions;

	/*
	 * @Override public String ShowPointsOfDistributionDtls(HttpServletRequest
	 * request) { // TODO Auto-generated method stub int amount = 5; Amount in Show
	 * Entry drop down int start = 0; Counter for Paging, initially 0 int echo = 0;
	 * Maintains the request number, initially 0 int col = 0; Column number in the
	 * datatable Below variables store the options to create the Query
	 * 
	 * String dir = "asc"; int sStart = 0; int sAmount = 5000000; String sEcho =
	 * request.getParameter("sEcho"); String sCol =
	 * request.getParameter("iSortCol_0"); String sdir =
	 * request.getParameter("sSortDir_0");
	 * 
	 * String individualSearch = ""; if (request.getParameter("iDisplayStart") !=
	 * null) { start = sStart; if (start < 0) start = 0; }
	 * 
	 * Total number of records to be fetched if
	 * (request.getParameter("iDisplayLength") != null) { amount = sAmount; if
	 * (amount < 5 || amount > 100) amount = 5; }
	 * 
	 * Counter of the request sent from Data table if (sEcho != null) { echo =
	 * Integer.parseInt(sEcho); }
	 * 
	 * Column number if (sCol != null) { col = Integer.parseInt(sCol); if (col < 0
	 * || col > 5) col = 0; }
	 * 
	 * Sorting order if (sdir != null) { if (!sdir.equals("asc")) dir = "desc"; }
	 * 
	 * 
	 * String searchTerm ="";
	 * 
	 * String
	 * Query="select num_distribution_id, str_region_name,  dava.country_ids_name( str_country_id) countryname, str_cont_per_name, str_address, str_contact_number, str_email_id, str_cont_per_desg from distribution_mst d JOIN region_mst r ON(d.num_region_id = r.num_region_id) where d.num_isvalid = 1"
	 * ; String result
	 * =dSer.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); return
	 * result.toString(); }
	 */

	public List<RegionMstDomain> loadRegion() {
		List<RegionMstDomain> regionMst = davaTransactions.getRegionMstDtls();
		return regionMst;
	}

	public List<CountryMst> loadCountry() {
		List<CountryMst> countryMst = davaTransactions.getCountryNames();
		return countryMst;
	}

	public DistributionMstDomain addDistributionMstDetail(PointsOfDisModel pointsOfDisModel,
			HttpServletRequest request) {
		
		
		DistributionMstDomain dmDom = new DistributionMstDomain();
		dmDom.setNumRegionId(pointsOfDisModel.getExpReg());
		// dmDom.setNumCountryId(pointsOfDisModel.getExpCountry());
		dmDom.setStrName(pointsOfDisModel.getOrgName());
		dmDom.setStrAddress(pointsOfDisModel.getExpSiteAdd());
		dmDom.setStrContPerName(pointsOfDisModel.getExpName());
		dmDom.setStrContactNumber(pointsOfDisModel.getExpNumber());
		dmDom.setStrContPerDesg(pointsOfDisModel.getExpDesignation());
		dmDom.setStrEmailId(pointsOfDisModel.getExpEmail());

		List<String> countries = pointsOfDisModel.getListExpCountry();
		String str = null;
		if (countries.size() > 0) {
			str = countries.get(0);
			System.err.println("str--" + str);
			System.err.println("protocols size--" + countries.size());
			for (int i = 0; i < countries.size() - 1; i++) {
				str += "," + countries.get(i + 1);
				System.err.println("str-" + str);
			}
			dmDom.setStrCountryId(str);
		} else {
			dmDom.setStrCountryId("");
		}

		dmDom.setDtTrDate(new Date());
		dmDom.setNumIsValid(1);
		dmDom.setNumTrUserId(1001);
		return davaTransactions.savePointsOfDistributionDtls(dmDom);
	}

	@Override
	public CountryRegionMapDomain addMappingDetail(CountryRegionMapModel countryRegionMapModel,
			HttpServletRequest request)  {
		
		
		

		
		CountryRegionMapDomain crDom=new CountryRegionMapDomain();
		crDom.setCountry_Id(countryRegionMapModel.getCountry_id());
		crDom.setRegion_Id(countryRegionMapModel.getRegion_id());
		
		List<String> countries = countryRegionMapModel.getListExpCountry();
		String str = null;
		if (countries.size() > 0) {
			str = countries.get(0);
			System.err.println("str--" + str);
			System.err.println("protocols size--" + countries.size());
			for (int i = 0; i < countries.size() - 1; i++) {
				str += "," + countries.get(i + 1);
				System.err.println("str-" + str);
			
				
				
			}
			
			  try {
			        int val=Integer.parseInt(str);
			        crDom.setCountry_Id(val);
			        System.err.println(val+"countryId");
					
			      }catch (NumberFormatException e){
			       System.out.println("not a number"); 
			     } 
			
			
			
			
		}		
			
			 
		
		
		
		crDom.setDtTrDate(new Date());
		crDom.setNumIsValid(1);
		crDom.setNumTrUserId(1001);
		return davaTransactions.saveMappingDtls(crDom);
		
		
		
	}

}
