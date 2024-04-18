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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.daoservice.StateMasterDaoService;
import in.cdacnoida.dava.entities.StatesMst;
import in.cdacnoida.dava.entities.ZoneMst;
import in.cdacnoida.dava.model.LocationMasterForm;
import in.cdacnoida.dava.model.StateMasterForm;
import in.cdacnoida.dava.service.StateMasterService;


@Controller
public class StateMasterAction {
	@Autowired(required=false)
	public StateMasterDaoService stateDao;

	@Autowired(required=false)
	public StateMasterService stateServ;
	
	

	@RequestMapping(value = "/StateMaster", method = RequestMethod.GET)
	public String StateMaster(@ModelAttribute("StateMasterForm") StateMasterForm stateMasterForm,
			HttpServletRequest request) {
		String response = "";

		List<ZoneMst> zone = stateDao.getZone(); 
		 request.setAttribute("zone",zone);
	
		return "StateMaster";
	}


	@RequestMapping(value = "/saveStateType", method = RequestMethod.POST)
	 public String saveStateType(@ModelAttribute("StateMasterForm")StateMasterForm stateMasterForm,
                                  BindingResult result, HttpServletRequest request,RedirectAttributes attr) 
	{ 
		
		String res="";
		 System.out.println("in action save state   ++"+stateMasterForm.getStr_state_name());
		
		 String add =stateServ.addStateMaster(stateMasterForm); 
		
		 res ="redirect:/StateMaster"; 
		 return res;
	   }
	
	@GetMapping("/getStateData1")
	public  ResponseEntity<List<StatesMst>>  getState(){
		
		  List<StatesMst> statesNames=stateServ.getAllState(); 
		  return new ResponseEntity<List<StatesMst>>(statesNames,HttpStatus.OK);
		 
		
	}
	
	
	
	@RequestMapping(value = "/getStateMaster",method = RequestMethod.GET)
	@ResponseBody
	public String viewStateMaster(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = stateServ.ShowStateMaster(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	@RequestMapping(value = "/updateStateMaster", method = RequestMethod.POST)
	public String updateStateMaster(@ModelAttribute("stateMasterForm")StateMasterForm stateMasterForm , BindingResult result,RedirectAttributes redirectAttributes ,HttpServletRequest request)
	{	
		String res="";
			System.err.println("in modify action     "  +stateMasterForm.getNum_state_id());
			String update = stateServ.updateStateMaster(stateMasterForm);
			System.err.println("item name :: -- "+stateMasterForm.getStr_state_name());
			
		    res = "redirect:/StateMaster";
		return res;
	}
	

	@RequestMapping(value = "/deleteState", method = RequestMethod.POST)
	public String deleteStateMaster(StateMasterForm stateMasterForm,HttpServletRequest request,RedirectAttributes redirectAttributes) 
	{
		stateServ.deleteStateForm(stateMasterForm);
		return "redirect:/StateMaster";
	}
	
}
	

	