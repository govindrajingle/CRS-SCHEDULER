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


import in.cdacnoida.dava.daoservice.PackUnitMasterDao;
import in.cdacnoida.dava.entities.PackUnitMst;
import in.cdacnoida.dava.model.CountryMasterModel;
import in.cdacnoida.dava.model.PackUnitMasterModel;

@Controller
public class PackUnitMasterAction {
	
	@Autowired
	public PackUnitMasterDao packUnitDao;
	
	
	@RequestMapping(value = "/PackUnitMaster", method = RequestMethod.GET)
	public String PackUnitMaster(@ModelAttribute("packUnitMasterModel")PackUnitMasterModel  packUnitMasterModel,HttpServletRequest request) 
	{		
		String response = "";
		response =  "PackUnitMaster";
		return response;
	}
	
	@RequestMapping(value ="/savePackUnitMaster",method = RequestMethod.POST)
	public String savePackUnitMaster(@ModelAttribute("packUnitMasterModel")PackUnitMasterModel packUnitMasterModel, BindingResult result, HttpServletRequest request,RedirectAttributes attr) {
		
		String res="";
		System.out.println("in save pack unit =========     "+packUnitMasterModel.getPackName());
		try{
			 String add = packUnitDao.addPackUnitMasterDetail(packUnitMasterModel);
			 System.err.println("pack unit name :: -- "+packUnitMasterModel.getPackName());
			 System.err.println("message :: --"+add);
		 }
		 catch(Exception e){
				e.printStackTrace();
				return "ErrorPage";
		 }
	  res = "redirect:/PackUnitMaster";
	  return res;
	  }
	

	 @GetMapping("/getPackUnitData")
		public ResponseEntity<List<PackUnitMst>> getPackUnit(){
			List<PackUnitMst> pum = packUnitDao.getAllPackUnit();
			return new ResponseEntity<List<PackUnitMst>>(pum,HttpStatus.OK);
		}
		
		@RequestMapping(value = "/getPackUnitMaster",method = RequestMethod.GET)
		@ResponseBody
		public String viewPackUnitMaster(HttpServletRequest request, HttpServletResponse response) 
		{
			System.out.println("in data table code");
			String jsonResponse = packUnitDao.ShowPUMaster(request);
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-store");
			return jsonResponse;
		}
		
		@RequestMapping(value = "/updatePackUnitMaster", method = RequestMethod.POST)
		public String updateCountryMaster(@ModelAttribute("packUnitMasterModel")PackUnitMasterModel packUnitMasterModel , BindingResult result,RedirectAttributes redirectAttributes ,HttpServletRequest request)
		{	
			String res="";
				System.err.println("in modify action");
				String update = packUnitDao.updatePackUnitMaster(packUnitMasterModel);
				System.err.println("new country name :: -- "+ packUnitMasterModel.getPackName());
				
			    res = "redirect:/PackUnitMaster";
			return res;
		}
		
		@RequestMapping(value = "/deletePackUnit", method = RequestMethod.POST)
		public String deletePackUnitMaster(PackUnitMasterModel packUnitMasterModel,HttpServletRequest request,RedirectAttributes redirectAttributes) 
		{
			packUnitDao.deletePUForm(packUnitMasterModel);
			return "redirect:PackUnitMaster";
		}
		
}
