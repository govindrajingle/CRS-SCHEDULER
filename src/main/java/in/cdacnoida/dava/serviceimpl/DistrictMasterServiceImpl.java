package in.cdacnoida.dava.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.DistrictMasterDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.model.DistrictMasterForm;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.DistrictMasterService;


@Service
public class DistrictMasterServiceImpl implements DistrictMasterService{

	@Autowired(required=false)
	public DistrictMasterDaoService distDao;
	
	@Autowired(required=false)
	public DavaServices dSer;

	
	public String addDistrictMaster(DistrictMasterForm districtMasterForm) {
		System.out.println("In save service");
		//System.err.println(WordUtils.capitalize(districtMasterForm.getStr_district_name().trim()));
		DistrictMst dmd = new DistrictMst();
		
		dmd.setNum_state_id(districtMasterForm.getNum_state_id());
		dmd.setNum_district_id(districtMasterForm.getNum_district_id());
		dmd.setStr_district_name(districtMasterForm.getStr_district_name());
		dmd.setStr_district_short_name(WordUtils.capitalize(districtMasterForm.getStr_district_short_name().trim()));
		dmd.setNum_tr_user_id(1001);
		dmd.setNum_isvalid(1);
		dmd.setDt_tr_date(new Date());
	
		
		return distDao.addDistrictMas(dmd);
		
	}
 
	public String ShowDistMaster(HttpServletRequest request) {
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
		
		 String Query="select num_district_id, str_district_name, str_district_short_name,(select str_state_name from states_mst s where s.num_state_id = d.num_state_id) as state_name from district_mst d where num_isvalid =1 ORDER BY str_district_name";
		 
		 String result =dSer.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
			return result.toString();
		
	}

	
	public String updateDistrictMaster(DistrictMasterForm districtMasterForm) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteDistForm(DistrictMasterForm districtMasterForm) {
		// TODO Auto-generated method stub
		
	}

	

}
