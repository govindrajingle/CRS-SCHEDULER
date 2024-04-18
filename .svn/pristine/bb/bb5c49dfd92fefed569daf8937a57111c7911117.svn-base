package in.cdacnoida.dava.daoimpl;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.CountryMasterDao;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.model.CountryMasterModel;
import in.cdacnoida.dava.model.LocationMasterForm;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class CountryMasterDaoServiceImpl implements CountryMasterDao {
	
	@Autowired
	private DavaTransactions davaTransactions;

	@Autowired
	public DavaServices dSer;
	
	
	@Autowired
	public CountryMasterDao CountryDao;
	
	public List<InstituteTypeMasterDomain> LoadCountryType() {
		List<InstituteTypeMasterDomain> instMst =davaTransactions.getInstituteTypeName();
		return instMst;
	}
	
	public String addCountryMasterDetail(CountryMasterModel CountryMstModel) {
		System.out.println("In Save service");
		CountryMst cmd = new CountryMst();
	
		cmd.setStr_country_name(WordUtils.capitalize(CountryMstModel.getStr_country_name().trim()));
		cmd.setNum_isvalid(1);
		
		return davaTransactions.saveCountryMasterRecord(cmd);
		
	}
	
	public List<CountryMst> getAllCountry() {
		List<CountryMst> lmd = davaTransactions.getCountryNames();
		return lmd;
	}
	

	public String ShowConMaster(HttpServletRequest request) {
		// TODO Auto-generated method stub
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
				
				String Query="select num_country_id, str_country_name from country_master where num_isvalid=1 ORDER BY str_country_name";
				String result =dSer.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}

	@Override
	public String updateCountryMaster(CountryMasterModel countryMstModel) {
		CountryMst cmd = new CountryMst();
		cmd.setNum_country_id(countryMstModel.getNum_country_id());
		cmd.setStr_country_name(WordUtils.capitalize(countryMstModel.getStr_country_name().trim()));
		System.out.println("counrtry name=======" + countryMstModel.getStr_country_name() );
		cmd.setNum_isvalid(1);
		
		return davaTransactions.updateCountryMaster(cmd);
	}

	@Override
	public void deleteConForm(CountryMasterModel countryMstModel) {
		System.out.println("in delete service");
		int count = countryMstModel.getRadio().length;
	    for (int i = 0; i <count; i++) 
	    { 

	    	CountryMst cmd = new CountryMst();
	    	cmd.setNum_country_id(countryMstModel.getRadio()[i]);
	    	cmd.setNum_isvalid(0);
	  
		davaTransactions.updateCountryMaster(cmd);
	}

}
}