package in.cdacnoida.dava.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.StateMasterDaoService;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.model.StateMasterForm;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.StateMasterService;

@Service
public class StateMasterServiceImpl implements StateMasterService{

	@Autowired
	public StateMasterDaoService stateDao;
	
	@Autowired
	public DavaServices dSer;
	

	public String addStateMaster(StateMasterForm stateMasterForm) {
		
		System.out.println("In Save service");
		
		StatesMst smd = new StatesMst();
		
		  smd.setNum_country_id(193);
		  smd.setNum_state_id(stateMasterForm.getNum_state_id());
		  smd.setNum_zone_id(stateMasterForm.getNum_zone_id());
		  smd.setStr_state_name(WordUtils.capitalize(stateMasterForm.getStr_state_name().trim()));
		  smd.setStr_state_short_name(WordUtils.capitalize(stateMasterForm.getStr_state_short_name().trim())); 
		  smd.setNum_isvalid(1);
		  smd.setDt_tr_date(new Date());
		  smd.setNum_tr_user_id(10001); 
		 
			
		return stateDao.addStateMas(smd);
	}

	
	public List<StatesMst> getAllState() {
		return stateDao.getState();
	}

	
	public String ShowStateMaster(HttpServletRequest request) {
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
		
		 String Query="select num_state_id,(select str_zone_name from zone_mst zm where zm.num_zone_id=sm.num_zone_id), str_state_name, str_state_short_name from states_mst sm where num_isvalid=1 ORDER BY str_state_name";
		 
		 String result =dSer.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
			return result.toString();
		
	}

	
	public String updateStateMaster(StateMasterForm stateMasterForm) {
		System.out.println("IN SERVICE MODIFY");
		StatesMst stateDom = new StatesMst();
		
		stateDom.setNum_state_id(stateMasterForm.getNum_state_id());
		stateDom.setNum_zone_id(stateMasterForm.getNum_zone_id());
		stateDom.setStr_state_name(WordUtils.capitalize(stateMasterForm.getStr_state_name().trim()));
		stateDom.setStr_state_short_name(WordUtils.capitalize(stateMasterForm.getStr_state_short_name().trim()));
		stateDom.setNum_tr_user_id(10001);
		stateDom.setNum_isvalid(1);
		stateDom.setDt_tr_date(new Date());	
		
		return stateDao.updateStateMaster(stateDom);
	}

	
	public void deleteStateForm(StateMasterForm stateMasterForm) {
		System.out.println("in delete service");
		int count = stateMasterForm.getRadio().length;
	    for (int i = 0; i <count; i++) 
	    { 

	    	StatesMst stateDom = new StatesMst();
	    	stateDom.setNum_state_id(stateMasterForm.getRadio()[i]);
	    	stateDom.setNum_isvalid(0);
	    	stateDao.deleteStateUser(stateDom);
	    }
	}
	
	
}
