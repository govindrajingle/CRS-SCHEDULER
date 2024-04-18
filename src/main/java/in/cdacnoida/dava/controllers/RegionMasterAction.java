package in.cdacnoida.dava.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.daoservice.RegionMasterDao;
import in.cdacnoida.dava.model.RegionMasterModel;

@Controller
public class RegionMasterAction {
	
	@Autowired
	public RegionMasterDao regDao;
	
	@RequestMapping(value = "/RegionMaster", method = RequestMethod.GET)
	public String RegionMaster(@ModelAttribute("RegionMstModel")RegionMasterModel RegionMstModel, HttpServletRequest request) {
		
		String response = "";
		
		response= "RegionMst";
		return response;
	}
	
	@RequestMapping(value = "/saveRegionMaster",method = RequestMethod.POST)
	public String saveCountryMaster(@ModelAttribute("RegionMstModel")RegionMasterModel RegionMstModel ,BindingResult result, RedirectAttributes redirectAttributes
	 ,HttpServletRequest request) { 
		 String res="";
		 System.out.println("in save region =========     "+RegionMstModel.getStrRegionName());
		 try{
			 String add = regDao.addRegionMasterDetail(RegionMstModel);
			 redirectAttributes.addFlashAttribute("flagSave", 1);
		 }
		 catch(Exception e){
				e.printStackTrace();
				return "ErrorPage";
		 }
	  res = "redirect:/RegionMaster";
	  return res;
	  }
	
	@RequestMapping(value = "/getRegionMasterDetails",method = RequestMethod.GET)
	@ResponseBody
	public String getRegionMasterDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = regDao.ShowRegionMaster(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	@RequestMapping(value = "/updateRegionMaster", method = RequestMethod.POST)
	public String updateRegionMaster(@ModelAttribute("RegionMstModel")RegionMasterModel RegionMstModel , BindingResult result,RedirectAttributes redirectAttributes ,HttpServletRequest request)
	{	
		String res="";
			System.err.println("in modify action");
			String update = regDao.updateRegionMaster(RegionMstModel);
			redirectAttributes.addFlashAttribute("flagUpdate", 1);
		    res = "redirect:/RegionMaster";
		return res;
	}
	
	@RequestMapping(value = "/deleteRegion", method = RequestMethod.POST)
	public String deleteRegion(RegionMasterModel RegionMstModel,HttpServletRequest request,RedirectAttributes redirectAttributes) 
	{
		regDao.deleteRegion(RegionMstModel);
		redirectAttributes.addFlashAttribute("flagDelete", 1);
		return "redirect:/RegionMaster";
	}
	
	@RequestMapping(value = "/ShowRegionMstDetails", method = RequestMethod.GET)
	public String ShowRegionMstDetails(@ModelAttribute("RegionMstModel")RegionMasterModel RegionMstModel, HttpServletRequest request) {
		
		String response = "";
		
		response= "ShowRegionMstDtls";
		return response;
	}

}
