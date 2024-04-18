package in.cdacnoida.dava.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.service.ExportServices;

@Service
public class ExportServiceImpl implements ExportServices {

	@Autowired
	private DavaDaoServices davaDaoServices;
	
	@Override
	public String getExportOrderDetails(HttpServletRequest request) {
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
	
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDaoServices.getUserDetails(loogedInUserId);
		int instId = userDetails.get(0).getNumInstId();
		
		String searchTerm ="";
		
		//String Query="select num_distribution_id, str_region_name,  dava.country_ids_name( str_country_id) countryname, str_cont_per_name, str_address, str_contact_number, str_email_id, str_cont_per_desg from distribution_mst d JOIN region_mst r ON(d.num_region_id = r.num_region_id) where d.num_isvalid = 1";
		String Query="select num_exp_id,dava.country_ids_name( str_country_id) str_country_name,str_region_name,to_char(dt_invoice_date,'dd-Mon-YYYY')invoicedate ,str_invoice_no,dava.product_ids_name(str_product_id) str_generic_name from export_order_mst e  JOIN region_mst r ON(e.num_export_region_id=r.num_region_id) where e.num_isvalid=1 and e.num_inst_id="+instId;
		
		String result =davaDaoServices.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
		return result.toString();
	}

}
