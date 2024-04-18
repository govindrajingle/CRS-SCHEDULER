package in.cdacnoida.dava.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.daoservice.CountryMasterDao;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.LocationMasterDomain;
import in.cdacnoida.dava.model.CountryMasterModel;
import in.cdacnoida.dava.model.LocationMasterForm;
//import in.cdacnoida.dava.validator.UserFormValidator;


@Controller
public class CountryMasterAction {
	
	@Autowired
	public CountryMasterDao CountryDao;
	
	/*
	 * @Autowired UserFormValidator userFormValidator;
	 */
	
	//Set a form validator
	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.setValidator(userFormValidator); }
	 */
	
	@RequestMapping(value = "/CountryMaster", method = RequestMethod.GET)
	public String CountryMaster(@ModelAttribute("CountryMstModel")CountryMasterModel CountryMstModel, HttpServletRequest request) {
		
		String response = "";
		
		response= "CountryMaster";
		return response;
	}
	
	
	 @RequestMapping(value = "/saveCountryMaster",method = RequestMethod.POST)
	 public String saveCountryMaster(@ModelAttribute("CountryMstModel")CountryMasterModel CountryMstModel ,BindingResult result, RedirectAttributes redirectAttributes
	 ,HttpServletRequest request) { 
		 String res="";
		 System.out.println("in save country =========     "+CountryMstModel.getStr_country_name());
		 try{
			 String add = CountryDao.addCountryMasterDetail(CountryMstModel);
			 System.err.println("country name :: -- "+CountryMstModel.getStr_country_name());
			 System.err.println("message :: --"+add);
		 }
		 catch(Exception e){
				e.printStackTrace();
				return "ErrorPage";
		 }
	  res = "redirect:/CountryMaster";
	  return res;
	  }
	 
	 @GetMapping("/getCountryData")
		public ResponseEntity<List<CountryMst>> getCountry(){
			List<CountryMst> cmd=CountryDao.getAllCountry();
			return new ResponseEntity<List<CountryMst>>(cmd,HttpStatus.OK);
		}
		
		@RequestMapping(value = "/getCountryMaster",method = RequestMethod.GET)
		@ResponseBody
		public String viewCountryMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			System.out.println("in data table code");
			String jsonResponse = CountryDao.ShowConMaster(request);
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-store");
			return jsonResponse;
		}	
		
		@RequestMapping(value = "/updateCountryMaster", method = RequestMethod.POST)
		public String updateCountryMaster(@ModelAttribute("CountryMstModel")CountryMasterModel CountryMstModel , BindingResult result,RedirectAttributes redirectAttributes ,HttpServletRequest request)
		{	
			String res="";
				System.err.println("in modify action");
				String update = CountryDao.updateCountryMaster(CountryMstModel);
				System.err.println("new country name :: -- "+ CountryMstModel.getStr_country_name());
				
			    res = "redirect:/CountryMaster";
			return res;
		}
		
		@RequestMapping(value = "/deleteCountry", method = RequestMethod.POST)
		public String deleteCountryMaster(CountryMasterModel CountryMstModel,HttpServletRequest request,RedirectAttributes redirectAttributes) 
		{
			CountryDao.deleteConForm(CountryMstModel);
			return "redirect:CountryMaster";
		}
}
