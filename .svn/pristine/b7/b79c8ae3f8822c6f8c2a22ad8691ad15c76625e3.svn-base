package in.cdacnoida.dava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.DistributionMstDomain;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.misc.ValidationGroups.MemberDetails;
import in.cdacnoida.dava.misc.ValidationGroups.PointOfDistribution;
import in.cdacnoida.dava.model.DrugDtlsModel;
import in.cdacnoida.dava.model.PointsOfDisModel;
import in.cdacnoida.dava.model.RegistrationForm;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.service.PointsOfDisService;

@Controller
public class PointsOfDisAction {
	
	@Autowired
	public PointsOfDisService podServ;
	
	@Autowired
	private DavaServices davaServices;
	
	@RequestMapping(value = "/PointsOfDistribution", method = RequestMethod.GET)
	public String PointsOfDistribution(@ModelAttribute("pointsOfDisModel")PointsOfDisModel pointsOfDisModel,HttpServletRequest request) 
	{
		String response = "";
		
			List<RegionMstDomain> region = podServ.loadRegion();
			request.setAttribute("region",region);
			
			List<CountryMst> country = podServ.loadCountry();
			request.setAttribute("country",country);
		 
			response= "PointsOfDistribution";
		
		return response;
	}
	
	@RequestMapping(value = "/getPointsOfDistributionDtls",method = RequestMethod.GET)
	@ResponseBody
	public String viewPointsOfDistributionDtls(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = podServ.ShowPointsOfDistributionDtls(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
	
	@RequestMapping(value ="/savePoinstOfDistribution",method = RequestMethod.POST)
	public String saveDrugDetails(@Validated(PointOfDistribution.class)@ModelAttribute("pointsOfDisModel")PointsOfDisModel pointsOfDisModel, BindingResult result, HttpServletRequest request,RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res="";
		List<String> errorMessage = new ArrayList<String>();
		if(result.hasErrors()){
			List<ObjectError> errorList = result.getAllErrors();
			for(int i=0;i<errorList.size();i++)
			{
				String codes = errorList.get(i).getCodes()[1].substring(errorList.get(i).getCodes()[1].lastIndexOf(".")+1, errorList.get(i).getCodes()[1].length());
				errorMessage.add(errorList.get(i).getDefaultMessage());
			}
			attr.addFlashAttribute("errors",errorMessage);
			res= "redirect:/PointsOfDistribution";
		}
		else{
			DistributionMstDomain drugDom = podServ.addDistributionMstDetail(pointsOfDisModel,request);
			attr.addFlashAttribute("flagSave", 1);
			res= "redirect:/PointsOfDistribution";
		}
		return res;
		
	}
	
	@RequestMapping(value = "/PointsOfDistributionDetails", method = RequestMethod.GET)
	public String PointsOfDistributionDetails(@ModelAttribute("pointsOfDisModel")PointsOfDisModel pointsOfDisModel,HttpServletRequest request) 
	{
		String response = "";
			
			response= "PointsOfDistributionData";
		
		return response;
	}	

}
