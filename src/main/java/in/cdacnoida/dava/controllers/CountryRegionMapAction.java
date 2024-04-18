package in.cdacnoida.dava.controllers;

import java.util.List;
import java.util.Optional;

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

import in.cdacnoida.dava.daoimpl.DavaDaoServicesImpl;
import in.cdacnoida.dava.entities.CountryMst;
import in.cdacnoida.dava.entities.CountryRegionMapDomain;
import in.cdacnoida.dava.entities.DistributionMstDomain;
import in.cdacnoida.dava.entities.DrugMst;
import in.cdacnoida.dava.entities.RegionMstDomain;
import in.cdacnoida.dava.entities.RegistrationDetails;
import in.cdacnoida.dava.entities.RoleMaster;
import in.cdacnoida.dava.entities.SeatMaster;
import in.cdacnoida.dava.model.CountryRegionMapModel;
import in.cdacnoida.dava.model.DrugDtlsModel;
import in.cdacnoida.dava.model.PointsOfDisModel;
import in.cdacnoida.dava.service.CountryRegionMapService;
import in.cdacnoida.dava.service.PointsOfDisService;
import in.cdacnoida.dava.springsecurity.LoggedInUserSession;
import in.cdacnoida.dava.transactions.DavaTransactions;
import in.cdacnoida.dava.transactions.UserRepository;

@Controller
public class CountryRegionMapAction {


	
	@Autowired
	public CountryRegionMapService crmServ;
	
	
	
	  @Autowired private LoggedInUserSession userData;
	  
	  
	  @Autowired
	  private UserRepository userRepository;
	  
	  @Autowired 
	  DavaTransactions davaTransaction;
	 
	@RequestMapping(value = "/CountryRegionMap", method = RequestMethod.GET)
	public String CountryRegionMap(@ModelAttribute("countryRegionMapModel") CountryRegionMapModel countryRegionMapModel,
			HttpServletRequest request) {
		String response = "";

		List<RegionMstDomain> region = crmServ.loadRegion();
		request.setAttribute("region", region);

		List<CountryMst> country = crmServ.loadCountry();
		request.setAttribute("country", country);

		response = "CountryRegionMap";

		return response;
	}

	
	@RequestMapping(value ="/saveCountryRegionMap",method = RequestMethod.POST)
	public String saveMappingDetails(@ModelAttribute("countryRegionMapModel")CountryRegionMapModel countryRegionMapModel, BindingResult result, HttpServletRequest request,RedirectAttributes attr) {

		System.err.println("IN Testing ACTION");
		String res="";
		
		
		//	DistributionMstDomain drugDom = podServ.addDistributionMstDetail(pointsOfDisModel,request);
		//	attr.addFlashAttribute("flagSave", 1);
		//	res= "redirect:/PointsOfDistribution";
			
			CountryRegionMapDomain crDom=crmServ.addMappingDetail(countryRegionMapModel,request);
			attr.addFlashAttribute("flagSave", 1);
			res= "redirect:/CountryRegionMap";
			
			
			
		
		  Long userId=userData.getUserId();
		  
		 
		  
		  Optional<RegistrationDetails> registrationDetails= userRepository.findById(userId);
		  
		  
		  
		  RegistrationDetails rg=registrationDetails.get();
		 
		  int x= rg.getNumSeatId();
		
		 
		 System.err.println(rg.getNumSeatId()+"LoggedInSeatId");
		
		 String profileCom =  davaTransaction.getProfilePercentage(x);
		 System.err.println("ABC"+profileCom);
		// request.setAttribute("profileCom", profileCom);
		 
		
		 return res;
		 
		 
		
	}	
	

}
