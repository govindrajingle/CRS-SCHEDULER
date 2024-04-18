package in.cdacnoida.dava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.cdacnoida.dava.daoservice.DavaDaoServices;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.ExportOrderDomain;
import in.cdacnoida.dava.entities.InstPremiseDtlDomain;
import in.cdacnoida.dava.entities.ProcurementMstDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.model.ProcurementMstModel;
import in.cdacnoida.dava.service.DavaServices;


@Controller
public class ProcurementMstAction {
	
	@Autowired
	public DavaDaoServices davaDao;	
	
	@Autowired
	private DavaServices service;

	@RequestMapping(value = "/ProcurementDetails", method = RequestMethod.GET)
	public String CountryMaster(@ModelAttribute("procurementMstModel")ProcurementMstModel procurementMstModel, HttpServletRequest request) {
		
		String response = "";
		
		String loogedInUserId=SecurityContextHolder.getContext().getAuthentication().getName();
		List<RegistrationDetails> userDetails = davaDao.getUserDetails(loogedInUserId);
		Integer instId = userDetails.get(0).getNumInstId();
		
		List<DrugMst> getProductNames=service.getProductNames();
		request.setAttribute("getProductNames",getProductNames);
		
		List<ExportOrderDomain> expOrder = davaDao.getExpOderDtl();
		request.setAttribute("expOrder", expOrder);
		
		List<InstPremiseDtlDomain> instPreDtls = davaDao.getInstPremisesDtls(instId);
		request.setAttribute("instPreDtls", instPreDtls);
		
		response= "ProccurementMaster";
		return response;
	}
	
	@RequestMapping(value ="/saveProcurementDetails",method = RequestMethod.POST)
	public String saveDrugDetails(@ModelAttribute("procurementMstModel")ProcurementMstModel procurementMstModel, BindingResult result, HttpServletRequest request,RedirectAttributes attr) {

		System.out.println("IN Testing ACTION");
		String res="";
		
			ProcurementMstDomain proDom = service.addProcurementDetailDom(procurementMstModel,request);
			
			attr.addFlashAttribute("flagSave", 1);
			res= "redirect:/ProcurementDetails";
		
		return res;
		
	}
	
	@RequestMapping(value = "/getProcurementDetails",method = RequestMethod.GET)
	@ResponseBody
	public String getDrugDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("in data table code");
		String jsonResponse = service.ShowProcurementDetails(request);
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store");
		return jsonResponse;
	}
}
