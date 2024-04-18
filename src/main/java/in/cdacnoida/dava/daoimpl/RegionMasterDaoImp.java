package in.cdacnoida.dava.daoimpl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.RegionMasterDao;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.model.RegionMasterModel;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class RegionMasterDaoImp implements RegionMasterDao{
	
	@Autowired
	private DavaTransactions davaTransactions;
	
	@Autowired
	public DavaServices dSer;

	public String addRegionMasterDetail(RegionMasterModel regionMstModel) {
		RegionMstDomain rm = new RegionMstDomain();
		rm.setStrRegionName(WordUtils.capitalize(regionMstModel.getStrRegionName().trim()));
		rm.setStrRegionCode(WordUtils.capitalize(regionMstModel.getStrRegionCode().trim()));
		rm.setStrRemarks(regionMstModel.getStrRemarks().trim());
		rm.setDtTrDate(new Date());
		rm.setNumTrUserId(1001);
		rm.setNumIsValid(1);
		return davaTransactions.saveRegionMstDetails(rm);
	}

	public String ShowRegionMaster(HttpServletRequest request) {
		int amount = 5; /* Amount in Show Entry drop down */
		int start = 0; /* Counter for Paging, initially 0 */
		int echo = 0; /* Maintains the request number, initially 0 */
		int col = 0; /* Column number in the datatable */
		/* Below variables store the options to create the Query */
		
		String dir = "asc";
		int sStart =  0;
		int sAmount =  5000000;
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");
		
		String individualSearch = "";
		if (request.getParameter("iDisplayStart") != null) 
		{
			start = sStart;
			if (start < 0)
				start = 0;
		}
 
		/* Total number of records to be fetched */
		if (request.getParameter("iDisplayLength") != null) 
		{
			amount = sAmount;
			if (amount < 5 || amount > 100)
				amount = 5;
		}
 
		/* Counter of the request sent from Data table */
		if (sEcho != null)
		{
			echo = Integer.parseInt(sEcho);
		}
 
		/* Column number */
		if (sCol != null)
		{
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
 
		/* Sorting order */
		if (sdir != null) 
		{
			if (!sdir.equals("asc"))
				dir = "desc";
		}
	
		
		String searchTerm ="";
		
		String Query="select rownum, num_region_id, str_region_name, nvl(str_region_code,'NA') str_region_code, nvl(str_remarks,'NA') str_remarks from region_mst where num_isvalid=1";
		String result =dSer.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}

	public String updateRegionMaster(RegionMasterModel regionMstModel) {
		RegionMstDomain rm = new RegionMstDomain();
		rm.setNumRegionId(regionMstModel.getNumRegionId());
		rm.setStrRegionName(WordUtils.capitalize(regionMstModel.getStrRegionName().trim()));
		rm.setStrRegionCode(WordUtils.capitalize(regionMstModel.getStrRegionCode().trim()));
		rm.setStrRemarks(regionMstModel.getStrRemarks().trim());
		rm.setDtTrDate(new Date());
		rm.setNumTrUserId(1001);
		rm.setNumIsValid(1);
		return davaTransactions.updateRegionMstDetails(rm);
	}

	public void deleteRegion(RegionMasterModel regionMstModel) {
		int count = regionMstModel.getRadio().length;
	    for (int i = 0; i <count; i++) 
	    { 

	    	RegionMstDomain rm = new RegionMstDomain();
	    	rm.setNumRegionId(regionMstModel.getRadio()[i]);
	    	rm.setNumIsValid(0);
	    	rm.setStrRegionName(WordUtils.capitalize(regionMstModel.getStrRegionName().trim()));
			rm.setStrRegionCode(WordUtils.capitalize(regionMstModel.getStrRegionCode().trim()));
			rm.setStrRemarks(regionMstModel.getStrRemarks().trim());
	  
	    	davaTransactions.updateRegionMstDetails(rm);
	    }
	}

}
