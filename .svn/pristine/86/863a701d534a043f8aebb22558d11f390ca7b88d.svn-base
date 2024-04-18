package in.cdacnoida.dava.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sun.misc.BASE64Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.cdacnoida.dava.entities.DistrictMst;
import in.cdacnoida.dava.model.HibernateSearchModel;
import in.cdacnoida.dava.model.LoginBean;
import in.cdacnoida.dava.service.DavaServices;
import in.cdacnoida.dava.util.Captcha;
import sun.misc.BASE64Encoder;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
@RestController
public class SearchController {

	@Autowired
	private DavaServices davaServices;
	
	@GetMapping("/Search")
    public ModelAndView   getSearchForm(HibernateSearchModel hibernateSearchModel,String searchInput,  HttpServletRequest request) {
		LoginBean loginBean=new LoginBean();
		ModelAndView mv=new ModelAndView();
		mv.addObject("loginBean", loginBean);

		mv.setViewName("searchPage");
		return mv;
	
    }
	
//added by gi
	
	
	
	public String decode(String strString_p) {
		  
		
		  

		if (strString_p == null)
			strString_p = "";
		else {

			try {

				strString_p = new String((new sun.misc.BASE64Decoder()).decodeBuffer(strString_p));

			} catch (Exception e) {
			}
		}
		return strString_p;
	}


  

	public static String reverse(String input) {
		char[] in = input.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}

	/*@GetMapping("/PerformSolrSearch")
	public @ResponseBody List<String> getDistrictData(@RequestParam("searchString") String searchString) {
		System.out.println("searchString"+searchString);
		
		return null;
	}*/
	
	
	@GetMapping("/PerformSolrSearch")
    public @ResponseBody String  performSolrSearch(@RequestParam("searchString") String searchString,HttpServletRequest request) {
		
		List<HibernateSearchModel> lhsf=new ArrayList<HibernateSearchModel>();
		
		//String ReceivedStr = request.getParameter(searchString);
		
		//System.out.println("ReceivedSearchString || " + searchString);	
		
		/*
		 * String decodedkey = decode(searchString);
		 * System.out.println("DecodedSearchString || " + decodedkey);
		 */
		
		 String decodedkey1 = reverse(searchString);
		  
		 String decodedkey2 = decode(decodedkey1);
		 //System.out.println("DecodedSearchString || " + decodedkey2);
		
		
		System.err.println("inside performSolrSearch Search Controller");
		lhsf = davaServices.getSolrSearchResults(decodedkey2,"printcd",true);
		  System.out.println("lhsf:::"+lhsf+"lhsf222"+lhsf.size());
		
		//lhsf = davaServices.getDatabaseSearchResults(searchString);
		
		String finalstring="No Data Found";
		
		
		String strRealPathLogo = request.getSession().getServletContext().getRealPath("/WEB-INF/JSP/RegistrationPages/");
		 //String strXml="<roottag>";
		
		
		if(lhsf.size()>0) {
	      String strXml= lhsf.get(0).getXmlString();
	      System.out.println("xml string:::"+strXml);
	      //strXml=strXml+ xmlString+"</roottag>";
	      
		String xslInput = strRealPathLogo+File.separator+"SearchXML.xsl";
		
		
	      FileInputStream xsl;
	      
		try {
				xsl = new FileInputStream(xslInput);
			 TransformerFactory tFactory = TransformerFactory.newInstance();
		       StreamSource styleSource = new StreamSource(xsl);
		       Transformer transformer = tFactory.newTransformer(styleSource);
		       String s = new String(strXml.getBytes(),"UTF-8");
			   InputStream is = new ByteArrayInputStream(s.getBytes());
			   StreamSource xmlSource = new StreamSource(is);
			       
			   StringWriter outWriter = new StringWriter();
			   StreamResult result1 = new StreamResult( outWriter );
			   transformer.transform(xmlSource, result1);
			   StringBuffer sb = outWriter.getBuffer(); 
			   
			   finalstring = sb.toString();
			   
			   request.setAttribute("viewdata", finalstring);
			   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		}
		
		/*
		 * List <String>al=new <String>ArrayList(); System.out.println(al);
		 * al.add(finalstring);
		 */
		
		return finalstring;
	
    }
	
	// changed on 09 Aug - GI
	/*@GetMapping("/PerformSolrSearch")
    public @ResponseBody String  performSolrSearch(@RequestParam("searchString") String searchString,HttpServletRequest request) {
		
		List<HibernateSearchModel> lhsf=new ArrayList<HibernateSearchModel>();
		
		System.err.println("inside performSolrSearch Search Controller");
		lhsf = davaServices.getSolrSearchResults(searchString,"printcd",true);
		  System.out.println("lhsf:::"+lhsf+"lhsf222"+lhsf.size());
		
		//lhsf = davaServices.getDatabaseSearchResults(searchString);
		
		String finalstring="No Data Found";
		
		
		String strRealPathLogo = request.getSession().getServletContext().getRealPath("/WEB-INF/JSP/RegistrationPages/");
		 //String strXml="<roottag>";
		
		
		if(lhsf.size()>0) {
	      String strXml= lhsf.get(0).getXmlString();
	      System.out.println("xml string:::"+strXml);
	      //strXml=strXml+ xmlString+"</roottag>";
	      
		String xslInput = strRealPathLogo+File.separator+"SearchXML.xsl";
		
		
	      FileInputStream xsl;
	      
		try {
				xsl = new FileInputStream(xslInput);
			 TransformerFactory tFactory = TransformerFactory.newInstance();
		       StreamSource styleSource = new StreamSource(xsl);
		       Transformer transformer = tFactory.newTransformer(styleSource);
		       String s = new String(strXml.getBytes(),"UTF-8");
			   InputStream is = new ByteArrayInputStream(s.getBytes());
			   StreamSource xmlSource = new StreamSource(is);
			       
			   StringWriter outWriter = new StringWriter();
			   StreamResult result1 = new StreamResult( outWriter );
			   transformer.transform(xmlSource, result1);
			   StringBuffer sb = outWriter.getBuffer(); 
			   
			   finalstring = sb.toString();
			   
			   request.setAttribute("viewdata", finalstring);
			   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		}
		
		
		return finalstring;
	
    }*/ 
	
	
	
	
	@GetMapping("/GetSearchXML")
    public @ResponseBody Object  GetSearchXML(@RequestParam("searchString") String searchString,HttpServletRequest request) {
		
		
		System.err.println("hellooooooo1");
		//lhsf = davaServices.getSolrSearchResults(searchString,"printcd",true);
		Object lhsf = davaServices.getSearchXMLResults(searchString);
		 System.out.println(lhsf);
		
		return lhsf;
	
    }
	
	@GetMapping("/PerformDBSearch")
    public @ResponseBody String  performDBSearch(@RequestParam("searchString") String searchString,HttpServletRequest request) {
		
		List<HibernateSearchModel> lhsf=new ArrayList<HibernateSearchModel>();
		
		System.err.println("hellooooooo2");
		//lhsf = davaServices.getSolrSearchResults(searchString,"printcd",true);
		lhsf = davaServices.getSolrSearchResults(searchString,"printcd",true);
		 String finalstring="No Data Found";
		 String strXml = "No Data Found";
		if(lhsf.size()>0) {
	       strXml= lhsf.get(0).getXmlString();
	      System.out.println("xml string:::"+strXml);
	      //strXml=strXml+ xmlString+"</roottag>";
		
	      
		}
		
		return strXml;
	
    }
	

}
