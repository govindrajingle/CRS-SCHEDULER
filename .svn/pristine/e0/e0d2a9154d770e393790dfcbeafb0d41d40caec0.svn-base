package in.cdacnoida.dava.daoimpl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.PackUnitMasterDao;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.PackUnitMst;
import in.cdacnoida.dava.model.CountryMasterModel;
import in.cdacnoida.dava.model.PackUnitMasterModel;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.transactions.DavaTransactions;

@Service
public class PackUnitMasterDaoServiceImpl implements PackUnitMasterDao{
	
	@Autowired
	public DavaServices dSer;
	@Autowired
	public PackUnitMasterDao packUnitDao;
	
	@Autowired
	public DavaTransactions davaTransactions;

	@Override
	public String addPackUnitMasterDetail(PackUnitMasterModel packUnitMasterModel) {
		System.out.println("In service");
			PackUnitMst pgmd = new PackUnitMst();
			pgmd.setNumPackId(packUnitMasterModel.getNumPackId());
			pgmd.setPackName(WordUtils.capitalize(packUnitMasterModel.getPackName().trim()));
			pgmd.setRemarks(WordUtils.capitalize(packUnitMasterModel.getRemarks().trim()));
			pgmd.setNumIsValid(1);
			pgmd.setNumTrUserId(1001);
			pgmd.setDtTrDate(new Date());
				return davaTransactions.savepackUnitMaster(pgmd);
				
	}

	@Override
	public String ShowPUMaster(HttpServletRequest request) {
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
					
					String Query="select num_pack_unit_id, str_pack_unit_name, str_remarks  from pack_unit_mst where num_isvalid =1 ORDER BY str_pack_unit_name";
					String result =dSer.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
					return result.toString();
		}
	public List<PackUnitMst> getAllPackUnit() {
		List<PackUnitMst> lmd = davaTransactions.getPackUnitNames();
		return lmd;
	}

	@Override
	public String updatePackUnitMaster(PackUnitMasterModel packUnitMasterModel) {
		System.out.println("In service");
		PackUnitMst pgmd = new PackUnitMst();
		pgmd.setNumPackId(packUnitMasterModel.getNumPackId());
		pgmd.setPackName(WordUtils.capitalize(packUnitMasterModel.getPackName().trim()));
		pgmd.setRemarks(WordUtils.capitalize(packUnitMasterModel.getRemarks().trim()));
		pgmd.setNumIsValid(1);
			return davaTransactions.updatePackUnit(pgmd);
		
	}

	@Override
	public void deletePUForm(PackUnitMasterModel packUnitMasterModel) {
		System.out.println("in delete service");
		int count = packUnitMasterModel.getRadio().length;
		System.err.println("count====="+ packUnitMasterModel.getRadio().length);
	    for (int i = 0; i <count; i++) 
	    { 

	    	PackUnitMst pum = new PackUnitMst();
	    	pum.setNumPackId(packUnitMasterModel.getRadio()[i]);
	    	pum.setNumIsValid(0);
	    	
	    	davaTransactions.updatePackUnit(pum);
	  
	    }
		
	}
}
