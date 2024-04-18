package in.cdacnoida.dava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.daoservice.LocationMasterDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.ZoneMst;
import in.cdacnoida.dava.model.LocationMasterForm;
import in.cdacnoida.dava.service.LocationMasterService;
import in.cdacnoida.dava.misc.ValidationGroups.LocationMaster;

@Controller
public class LocationMasterAction {
	
	@Autowired
	public LocationMasterDaoService locDao;
	
	@Autowired
	public LocationMasterService locServ;
	
	
	@RequestMapping(value = "/LocationMaster", method = RequestMethod.GET)
	public String LocationMaster(@ModelAttribute("locationMasterForm")LocationMasterForm locationMasterForm,HttpServletRequest request) 
	{
		String response = "";
		
		
		  List<InstituteTypeMasterDomain> instType = locDao.LoadLocationType();
		  request.setAttribute("instType",instType);
		 /* 
		 * List<CountryMstDomain> counType = locMstDao.LoadCountryType(usrinfo);
		 * System.out.println(counType.size());
		 * request.setAttribute("counType",counType);
		 */ 
		 List<StatesMst> state = locDao.getState(); 
		 request.setAttribute("state",state);
		 
		
		 List<ZoneMst> zone = locDao.getZone(); 
		 request.setAttribute("zone",zone);
		 
		 //List<LocationMasterDomain> locations=locServ.getAllLocations();
		// request.setAttribute("locations",locations);
			
			response= "LocationMaster";
		
		return response;
	}
		
		@RequestMapping(value = "/saveLocationType",method = RequestMethod.POST)
		public String saveLocationType(@Validated(LocationMaster.class)@ModelAttribute("locationMasterForm")LocationMasterForm locationMasterForm ,BindingResult result, RedirectAttributes redirectAttributes ,HttpServletRequest request) {
			String res="";
			
			List<String> errorMessage = new ArrayList<String>();
			if(result.hasErrors()){
				List<ObjectError> errorList = result.getAllErrors();
				for(int i=0;i<errorList.size();i++)
				{
					String codes = errorList.get(i).getCodes()[1].substring(errorList.get(i).getCodes()[1].lastIndexOf(".")+1, errorList.get(i).getCodes()[1].length());
					errorMessage.add(errorList.get(i).getDefaultMessage());
				}
				redirectAttributes.addFlashAttribute("errors",errorMessage);
				res= "redirect:/LocationMaster";
			}
			else{
				String add = locServ.addLocationMaster(locationMasterForm);
				redirectAttributes.addFlashAttribute("flagSave", 1);
			    res = "redirect:/LocationMaster";
			}
			return res;
		}
	
		@GetMapping("/getLocationData")
		public ResponseEntity<List<LocationMasterDomain>> getDistrictData(){
			List<LocationMasterDomain> locations=locServ.getAllLocations();
			return new ResponseEntity<List<LocationMasterDomain>>(locations,HttpStatus.OK);
		}
		
		@RequestMapping(value = "/getLocationMaster",method = RequestMethod.GET)
		@ResponseBody
		public String viewLocMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			System.out.println("in data table code");
			String jsonResponse = locServ.ShowLocMaster(request);
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-store");
			return jsonResponse;
		}
		
		@RequestMapping(value = "/updateLocationMaster", method = RequestMethod.POST)
		public String updateLocationMaster(@ModelAttribute("locationMasterForm")LocationMasterForm locationMasterForm , BindingResult result,RedirectAttributes redirectAttributes ,HttpServletRequest request)
		{	
			String res="";
			
				System.err.println("in modify action");
				System.out.println(locationMasterForm.getNumlocationId());
				String update = locServ.updateLocationMaster(locationMasterForm);
				System.err.println("item name :: -- "+locationMasterForm.getLoc_name());
				redirectAttributes.addFlashAttribute("flagUpdate", 1);
			    res = "redirect:/LocationMaster";
			return res;
		}
		
		@RequestMapping(value = "/deleteLocation", method = RequestMethod.POST)
		public String deleteLocationMaster(LocationMasterForm locationMasterForm,HttpServletRequest request,RedirectAttributes redirectAttributes) 
		{
			locServ.deleteLocForm(locationMasterForm);
			redirectAttributes.addFlashAttribute("flagDelete", 1);
			return "redirect:/LocationMaster";
		}
}
