package in.cdacnoida.dava.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.model.LocationMasterForm;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.LocationMasterService;

@Service
public class LocationMasterServiceImpl implements LocationMasterService{
	
	@Autowired
	public LocationMasterDaoService locDao;
	
	@Autowired
	public DavaServices dSer;

	public String addLocationMaster(LocationMasterForm locationMasterForm) {
		LocationMasterDomain locDom = new LocationMasterDomain();
		locDom.setNumlocationId(locationMasterForm.getNumlocationId());
		locDom.setLoc_type(locationMasterForm.getLoc_type());
		locDom.setLoc_add(WordUtils.capitalize(locationMasterForm.getLoc_add().trim()));
		locDom.setLoc_contact_dtls(locationMasterForm.getLoc_contact_dtls());
		System.out.println(locationMasterForm.getManufactureCountry());
		locDom.setLoc_country(locationMasterForm.getLoc_country());
		//locDom.setLoc_country(locationMasterForm.getManufactureCountry());
		locDom.setLoc_dist(locationMasterForm.getLoc_dist());
		locDom.setLoc_email(locationMasterForm.getLoc_email().trim());
		locDom.setContactPersonName(WordUtils.capitalize(locationMasterForm.getContactPersonName().trim()));
		locDom.setLoc_fax_dtls(locationMasterForm.getLoc_fax_dtls());
		locDom.setLoc_name(WordUtils.capitalize(locationMasterForm.getLoc_name().trim()));
		locDom.setLoc_short_Name(WordUtils.capitalize(locationMasterForm.getLoc_short_Name().trim()));
		locDom.setLoc_state(locationMasterForm.getLoc_state());
		locDom.setLoc_zone(locationMasterForm.getLoc_zone());
		//locDom.setStrStateName(WordUtils.capitalize(locationMasterForm.getStrState().trim()));
		//locDom.setLoc_dist(locationMasterForm.getManufactureDistrict());
		//locDom.setLoc_state(locationMasterForm.getManufactureState());
		locDom.setDtTrDate(new Date());
		locDom.setNumTrUserId(10001);
		locDom.setNumIsValid(1);
		return locDao.addLocationMas(locDom);
	}
	
	public List<LocationMasterDomain> getAllLocations() {
		// TODO Auto-generated method stub
		return locDao.getLocations();
	}

	public String ShowLocMaster(HttpServletRequest request) {
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
				
				String Query="SELECT num_loc_id, (select str_inst_type_name from institute_type_mst q where q.num_inst_type_id = i.num_inst_type_id),str_address, str_loc_name, str_short_name, str_email_id, num_mob_no, str_fax_no, (select str_country_name from country_mst c where c.num_country_id = i.num_country_id), (select str_district_name from district_mst d where d.num_district_id = i.num_district_id) district,(select str_state_name from states_mst s where s.num_state_id = i.num_state_id) states,(select str_zone_name from zone_mst z where z.num_zone_id = i.num_zone_id) zones, str_officer_name from location_mst i where num_isvalid=1 ORDER BY str_inst_type_name";
				String result =dSer.generateJSONObject("find_val",searchTerm,Query,sAmount,sStart); 
				return result.toString();
	}
	
	public String updateLocationMaster(LocationMasterForm locationMasterForm) {
		LocationMasterDomain locDom = new LocationMasterDomain();
		locDom.setNumlocationId(locationMasterForm.getNumlocationId());
		locDom.setLoc_type(locationMasterForm.getLoc_type());
		locDom.setLoc_add(WordUtils.capitalize(locationMasterForm.getLoc_add().trim()));
		locDom.setLoc_contact_dtls(locationMasterForm.getLoc_contact_dtls());
		locDom.setLoc_country(locationMasterForm.getLoc_country());
		locDom.setLoc_dist(locationMasterForm.getLoc_dist());
		locDom.setLoc_email(locationMasterForm.getLoc_email().trim());
		locDom.setContactPersonName(WordUtils.capitalize(locationMasterForm.getContactPersonName().trim()));
		locDom.setLoc_fax_dtls(locationMasterForm.getLoc_fax_dtls());
		locDom.setLoc_name(WordUtils.capitalize(locationMasterForm.getLoc_name().trim()));
		locDom.setLoc_short_Name(WordUtils.capitalize(locationMasterForm.getLoc_short_Name().trim()));
		locDom.setLoc_state(locationMasterForm.getLoc_state());
		locDom.setLoc_zone(locationMasterForm.getLoc_zone());
		//locDom.setStrStateName(WordUtils.capitalize(locationMasterForm.getStrState().trim()));
		//locDom.setLoc_dist(locationMasterForm.getManufactureDistrict());
		//locDom.setLoc_state(locationMasterForm.getManufactureState());
		locDom.setDtTrDate(new Date());
		locDom.setNumTrUserId(10001);
		locDom.setNumIsValid(1);
		return locDao.updateLocationMaster(locDom);
	}
	
	public void deleteLocForm(LocationMasterForm locationMasterForm) {
		System.out.println("in delete service");
		int count = locationMasterForm.getRadio().length;
	    for (int i = 0; i <count; i++) 
	    { 

	    	LocationMasterDomain locDom = new LocationMasterDomain();
	    	locDom.setNumlocationId(locationMasterForm.getRadio()[i]);
	    	locDom.setNumIsValid(0);
	    	locDao.deleteLocationUser(locDom);
	    }
	}

}
