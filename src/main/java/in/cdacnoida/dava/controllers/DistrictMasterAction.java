package in.cdacnoida.dava.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.daoservice.DistrictMasterDaoService;
import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.entities.InstituteTypeMasterDomain;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.model.DistrictMasterForm;
import in.cdacnoida.dava.model.LocationMasterForm;
import in.cdacnoida.dava.model.StateMasterForm;
import in.cdacnoida.dava.service.DistrictMasterService;


@Controller
public class DistrictMasterAction {
	

	@Autowired(required=false)
	public DistrictMasterDaoService distDao;
	
	@Autowired(required=false)
	public DistrictMasterService distServ;
	
	
	@RequestMapping(value = "/DistrictMaster", method = RequestMethod.GET)
	public String DistrictMaster(@ModelAttribute("districtMasterForm")DistrictMasterForm districtMasterForm,HttpServletRequest request) 
	{   
		System.out.println(" In action service");
		List<StatesMst> state = distDao.getState();
		request.setAttribute("state",state);
		
		return "DistrictMaster";
	}
	
	@RequestMapping(value = "/saveDistrictMaster", method = RequestMethod.POST)
	 public String saveDistrictMaster(@ModelAttribute("districtMasterForm")DistrictMasterForm districtMasterForm,BindingResult result, HttpServletRequest request,RedirectAttributes attr) 
	{ 
		
		String res="";
		System.out.println("in action save district  "  );
		String add =distServ.addDistrictMaster(districtMasterForm); 
		res ="redirect:/DistrictMaster"; 
		return res;
	   }
	
	
	@RequestMapping(value = "/getDistrictMaster",method = RequestMethod.GET)
	@ResponseBody
	public String viewDistrictMaster(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = distServ.ShowDistMaster(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
}
		
	