package in.cdacnoida.dava.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.cdacnoida.dava.daoimpl.DaoHelper;
import in.cdacnoida.dava.model.UserDetails;
import in.cdacnoida.dava.springsecurity.LoggedUser;

/**
 * Servlet Filter implementation class FormFieldValidationFilter
 */
@Component
@Order(2)
public class FormFieldValidationFilter implements Filter {

	@Autowired
	private DaoHelper daoHelper;

	private static Set<String> keys = new HashSet<String>();

	private static Map<String, Integer> checkIp = new HashedMap<String, Integer>();

	static {
		keys.add("varssoticketgrantingticket");
		keys.add("go.x");
		keys.add("go.y");
	}

	private static final String TOKEN_KEY = "NMD_TOKEN_KEY";

	/**
	 * Default constructor.
	 */
	public FormFieldValidationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String method = ((HttpServletRequest) request).getMethod();
		if (method == null)
			method = "";
		String spath = ((HttpServletRequest) request).getServletPath();

		if (!method.equalsIgnoreCase("POST")) {

			if (!shouldExclude((HttpServletRequest) request)) {
				HttpServletRequest req = (HttpServletRequest) request;
				LoggedUser loggedInUser = (LoggedUser) req.getSession().getAttribute("user");
				if (loggedInUser != null) {
					if (daoHelper != null) {

						int data = daoHelper.getListJSONUrl("validurl", "/IVEDA" + spath, loggedInUser.getUserId());
						boolean result = checkHijack(request, response);
						if (data == 0) {
							HttpServletResponse res = (HttpServletResponse) response;
							res.setContentType("text/html");
							PrintWriter pw = res.getWriter();
							pw.write(
									"<html><head><title>Error</title></head><body><h1>You are not allowed to view this page</h1></body></html>");
						} else if (result == false) {
							HttpServletResponse res = (HttpServletResponse) response;
							res.setContentType("text/html");
							PrintWriter pw = res.getWriter();
							pw.write(
									"<html><head><title>Error</title></head><body><h1>Bad Request. Kindly Login Again</h1></body></html>");
						} else {
							chain.doFilter(request, response);
						}
					}
				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			if (spath.equals("/ConfigDetails") /* || spath.equals("/IVEDA/uploadFile") */ ) {

				chain.doFilter(request, response);
			} else {

				boolean result = checkHijack(request, response);

				if (result == false) {
					HttpServletResponse res = (HttpServletResponse) response;
					res.setContentType("text/html");
					PrintWriter pw = res.getWriter();
					pw.write(
							"<html><head><title>Error</title></head><body><h1>Bad Request. Kindly Login Again</h1></body></html>");
				} else {

					String strURI = ((HttpServletRequest) request).getRequestURI();

					String fHTokenVal = "";

					List<ParamObject> paramMap = null;

					if (paramMap == null) {
						paramMap = getParamsFromSimpleForm((HttpServletRequest) request);
					}

					StringBuffer sb = new StringBuffer("");

					if (paramMap != null && paramMap.size() > 0) {
						Collections.sort(paramMap, new Comparator<ParamObject>() {
							public int compare(ParamObject s1, ParamObject s2) {
								return s1.getName().toLowerCase().toString()
										.compareTo(s2.getName().toLowerCase().toString());
							}
						});

						int x = 0;

						for (ParamObject paramObject : paramMap) {
							// System.out.println("username1::" + TOKEN_KEY);
							if (TOKEN_KEY.equalsIgnoreCase(paramObject.getName())) {
								// System.out.println("username1::" + TOKEN_KEY);
								//System.out.println("paramObject.getName() :: " + paramObject.getName());
								//System.out.println("paramObject.getValue() :: " + paramObject.getValue());
								if (paramObject.getValue() != null && !paramObject.getValue().equals("")) {
									fHTokenVal = paramObject.getValue();
									//System.out.println("fHTokenVal (paramObject.getValue()):: " + fHTokenVal);
								}

							} else {
								String val = paramObject.getValue().replaceAll(" ", "_");
								//System.out.println("paramObject.getValue() in else" + paramObject.getValue());
								val = val.replaceAll("\\r?\\n", "_");
								sb.append(val);
								//System.out.println("val val :: " + val);
								//System.out.println("sb ::" + sb.toString());
							}

						}

					}
					String fToken = "";
					System.out.println("spath::"+spath);
					String addMemberPath = "/uploadFile/IdProof";   //report problem jsp file
					String xmlDownload = "/downloadTmpFile_Secure"; //download xml
					String receiptDownload = "/downloadAckFile_Secure"; //download receipt
					String uploadReceipt = "/uploadFile";
					String guest = "/guest"; //mobile login
					if (!fHTokenVal.equals("")) {
						if(spath.equals("/saveInstPremisesAddressDetails")) {
							fToken = fHTokenVal;
						} else {
						fToken = sb.toString().isEmpty() ? "" : SecurityUtil.getMd5Hash(sb.toString());
						//System.out.println("sb.toString() :: " + sb.toString());
						}
					}
					
					  else if (!(spath.contains(addMemberPath) ||
							  spath.equals("/finalSubmitMemberSiteDetails") ||
							  spath.contains(xmlDownload) ||
							  spath.contains(uploadReceipt) ||
							  spath.contains(guest) || //mobile app apis
							  spath.equals("/returnRegistrationOfUser") || //application returned by Pharmexcil officer
							  spath.equals("/updateUserRegForRejection") || //application rejected by Pharmexcil officer
							  spath.equals("/deletemanufacturingsite") || //SITE DELETE by MANUFACTURE officer															 
							  spath.equals("/getSignatureChecksum") || //update profile 
							  spath.equals("/xmlChecksum") || //add member details
							  spath.equals("/getdrugChecksum")||
							  spath.equals("/saveReportProblem")||// mobile report problem
							  spath.equals("/updatePublicKey")||
							  spath.equals("/receivedHash")||
							  spath.equals("/HashCodeCheck")||
					          spath.equals("/UserLogin"))){
						  
					  fToken = "EmptyToken";
					  System.out.println("Empty Token Received");
					  }
					  
					 
					System.out.println("fToken :: " + fToken);

					System.out.println("fHTokenVal jsp :: " + fHTokenVal);

					/*
					 * if (fToken.toString().equals(fHTokenVal) || fToken.equals("")) {
					 * chain.doFilter(request, response); }
					 */

					/* if (fToken.toString().equals(fHTokenVal) || fToken.equals("")) { */
					if (fToken.toString().equals(fHTokenVal)) {
						//System.out.println("fHTokenVal jsp :: " + fHTokenVal);
						chain.doFilter(request, response);
					} else {

						HttpServletResponse res = (HttpServletResponse) response;

						HttpServletRequest incomingReq = (HttpServletRequest) request;

						String browserInfo = incomingReq.getHeader("User-Agent");
						HttpSession session = incomingReq.getSession(false);

						res.setContentType("text/html");
						//System.out.println("HttpServletResponse->>>"+res.toString());
						
						PrintWriter pw = res.getWriter();
						pw.write(
								"<html><head><title>Error</title></head><body><h1>Form Data Tampered</h1></body></html>");

						session.invalidate();

					}

				}
			}

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

	private static List<ParamObject> getParamsFromSimpleForm(HttpServletRequest request) {

		Enumeration<String> paramNames = request.getParameterNames();

		List<ParamObject> paramMap = new ArrayList<ParamObject>();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();

			if (!keys.contains(paramName.toLowerCase())) {

				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() > 0)

						paramMap.add(new ParamObject(paramName.toLowerCase(), paramValue));

				} else {
					for (int i = 0; i < paramValues.length; i++) {
						if (!("hmode".equalsIgnoreCase(paramName) && i == 0))
							paramMap.add(new ParamObject(paramName.toLowerCase(), paramValues[i]));
					}

				}

			}

		}

		return paramMap;
	}

	private static List<ParamObject> getParamsFromMultipartForm(HttpServletRequest request) {

		Enumeration<String> paramNames = request.getParameterNames();

		List<ParamObject> paramMap = new ArrayList<ParamObject>();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();

			if (!keys.contains(paramName.toLowerCase())) {

				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() > 0)

						//System.out.println(paramName + "  >>  " + paramValue);
					paramMap.add(new ParamObject(paramName.toLowerCase(), paramValue));

				} else {
					for (int i = 0; i < paramValues.length; i++) {
						if (!("hmode".equalsIgnoreCase(paramName) && i == 0))
							paramMap.add(new ParamObject(paramName.toLowerCase(), paramValues[i]));

						//System.out.println(paramName + "  >>  " + paramValues[i]);

					}

				}

			}

		}

		return paramMap;
	}

	public boolean checkHijack(ServletRequest request, ServletResponse response) throws IOException {

		HttpServletRequest incomingReq = (HttpServletRequest) request;
		HttpServletResponse outRes = (HttpServletResponse) response;
		// Session Highjacking code
		boolean result = false;

		// 11111111111111

		Cookie jSessionCookie = null;
		Cookie[] cookies = incomingReq.getCookies();
		String originalUserId = "";
		String sessionId = "";
		String decodedSessionId = "";
		String originalSessionId = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("window_count_save")) {
					originalUserId = cookie.getValue();
				} else if (cookie.getName().equals("hit_count_save")) {
					sessionId = cookie.getValue();
					byte[] decodedSessionByte = Base64.decodeBase64(cookie.getValue().getBytes());
					decodedSessionId = new String(decodedSessionByte);
				} else if (cookie.getName().equals("JSESSIONID") || cookie.getName().equalsIgnoreCase("cdacid")) {
					jSessionCookie = cookie;
					originalSessionId = cookie.getValue();
				}
			}
		} else {
			System.out.println("Cookies are null");
		}
		String browserInfo = incomingReq.getHeader("User-Agent");
		HttpSession session = incomingReq.getSession(false);
		if (null != session) {
			UserDetails usrInfo = (UserDetails) session.getAttribute("SessInfo");

			if (null != usrInfo) {
				Long newUserId = usrInfo.getUserId();
				String encUserId = usrInfo.getEncUserId();
				String encSessionId = usrInfo.getEncSessionId();
				String tomcatSessId = usrInfo.getTomcatSessId();
				if (StringUtils.isNotBlank(originalUserId) && StringUtils.isNotBlank(sessionId)) {
					if ((!originalUserId.equals(encUserId)) || (!sessionId.equals(encSessionId))
							|| (!browserInfo.equals(usrInfo.getBrowserInfo()))
							|| (!originalSessionId.equals(tomcatSessId))) {

						Cookie userIdCookie = new Cookie("window_count_save", originalUserId);
						Cookie sessionCookie = new Cookie("hit_count_save", sessionId);

						if (jSessionCookie == null)
							System.out.println("jsessioncookie is null");

						jSessionCookie.setValue(sessionId);
						jSessionCookie.setVersion(jSessionCookie.getVersion() + 1);

						outRes.addCookie(userIdCookie);
						outRes.addCookie(sessionCookie);

						result = false;
					} else {
						result = true;
					}
				} else {
					result = false;
				}
			} else {
				result = true;
			}
		} else {
			result = true;
		}

		return result;
	}

	private boolean shouldExclude(HttpServletRequest hreq) {
		if (hreq.getRequestURI().endsWith(".css") || hreq.getRequestURI().endsWith(".xlsx")
				|| hreq.getRequestURI().endsWith(".docx") || hreq.getRequestURI().endsWith(".js")
				|| hreq.getRequestURI().endsWith(".png") || hreq.getRequestURI().endsWith(".json")
				|| hreq.getRequestURI().endsWith(".jpg") || hreq.getRequestURI().endsWith(".jpeg")
				|| hreq.getRequestURI().equals("/IVEDA/getcntstat") || hreq.getRequestURI().equals("/IVEDA/DummyCharts")
				|| hreq.getRequestURI().endsWith(".woff2") || hreq.getRequestURI().equals("/IVEDA/error")
				|| hreq.getRequestURI().endsWith(".ttf") || hreq.getRequestURI().equals("/IVEDA/css/")
				|| hreq.getRequestURI().equals("/IVEDA/login") || hreq.getRequestURI().equals("/IVEDA/")
				|| hreq.getRequestURI().contains("/IVEDA/updatePassword")
				|| hreq.getRequestURI().equals("/IVEDA/rcmcRegistration")
				|| hreq.getRequestURI().equals("/IVEDA/getCompanyProfileData")
				|| hreq.getRequestURI().equals("/IVEDA/getRCMCData")
				|| hreq.getRequestURI().equals("/IVEDA/getRegistrationPendingListing")
				|| hreq.getRequestURI().contains("/IVEDA/emailVerification")
				|| hreq.getRequestURI().equals("/IVEDA/getApprovedRegistrationListing")
				|| hreq.getRequestURI().equals("/IVEDA/getPointsOfDistributionDtls")
				|| hreq.getRequestURI().contains("/IVEDA/getFeedbackResponseListing")
				|| hreq.getRequestURI().contains("/IVEDA/getManufacturingSiteListing")
				|| hreq.getRequestURI().contains("/IVEDA/getStateData")
				|| hreq.getRequestURI().contains("/IVEDA/getDistrictData")
				|| hreq.getRequestURI().contains("/IVEDA/countrybasedOnRegion")
				|| hreq.getRequestURI().contains("/IVEDA/getManufactreData")
				|| hreq.getRequestURI().contains("/IVEDA/getProductData")
				|| hreq.getRequestURI().contains("/IVEDA/getAllDrugDetails")
				|| hreq.getRequestURI().contains("/IVEDA/getDrugDetails")
				|| hreq.getRequestURI().contains("/IVEDA/getUploadXmlDetails")
				|| hreq.getRequestURI().contains("/IVEDA/getAllUploadXmlDetails")
				|| hreq.getRequestURI().contains("/IVEDA/PreviewPremisesDetails")
				|| hreq.getRequestURI().contains("/IVEDA/finalSubmitMemberSiteDetails")
				|| hreq.getRequestURI().contains("/IVEDA/getConsignmentUploadXmlDetails")
				|| hreq.getRequestURI().contains("/IVEDA/getGeneratePackCode")
				|| hreq.getRequestURI().contains("/IVEDA/getExportOrderDetails")
				|| hreq.getRequestURI().contains("/IVEDA/getLocationMaster")
				|| hreq.getRequestURI().contains("/IVEDA/getProcurementDetails")
				|| hreq.getRequestURI().contains("/IVEDA/downloadExcelGeneratePack")
				|| hreq.getRequestURI().contains("/IVEDA/getPortOfExport")
				|| hreq.getRequestURI().contains("/IVEDA/PerformSolrSearch")
				|| hreq.getRequestURI().contains("/IVEDA/downloadAckFile_Secure")
				|| hreq.getRequestURI().contains("/IVEDA/RegistrationOfficials")
				|| hreq.getRequestURI().contains("/IVEDA/PerformDBSearch")
				|| hreq.getRequestURI().contains("/IVEDA/getRecalledUploadXML")
				|| hreq.getRequestURI().contains("/IVEDA/ConsignmentDetailPage")
				|| hreq.getRequestURI().contains("/IVEDA/downloadTmpFile_Secure")
				|| hreq.getRequestURI().contains("/IVEDA/getSignatureChecksum")
				|| hreq.getRequestURI().contains("/IVEDA/viewTmpFile_Secure")
				|| hreq.getRequestURI().contains("/IVEDA/getdrugChecksum")
				|| hreq.getRequestURI().contains("/IVEDA/uploadFileXml")
				|| hreq.getRequestURI().contains("/IVEDA/saveAppTypeMst")
				|| hreq.getRequestURI().contains("/IVEDA/uploadFile")
				|| hreq.getRequestURI().contains("IVEDA/addressProofFile)")
				|| hreq.getRequestURI().contains("/IVEDA/drugLicence")
				|| hreq.getRequestURI().contains("/IVEDA/viewUploadedXML")
				|| hreq.getRequestURI().contains("/IVEDA/getStatisticsData")
				|| hreq.getRequestURI().contains("/IVEDA/EmailData")
				|| hreq.getRequestURI().contains("/IVEDA/getManufSiteUserList")
				|| hreq.getRequestURI().contains("/IVEDA/getUserNameStatus")
				|| hreq.getRequestURI().contains("/IVEDA/getAddedMemberData")
				|| hreq.getRequestURI().contains("/IVEDA/getAddedMemberList")
				|| hreq.getRequestURI().contains("/IVEDA/downloadPdf")
				|| hreq.getRequestURI().contains("/IVEDA/getUploadExporterDetails")
				|| hreq.getRequestURI().contains("/IVEDA/HSAPDF")
				|| hreq.getRequestURI().contains("/IVEDA/getAllPointOfDistDetails")
				|| hreq.getRequestURI().contains("/IVEDA/ReportProblem")
				|| hreq.getRequestURI().contains("/IVEDA/getCaptcha")
				|| hreq.getRequestURI().contains("/IVEDA/getDynamicHomepage")
				|| hreq.getRequestURI().contains("/IVEDA/faq")
				|| hreq.getRequestURI().contains("/IVEDA/WorkshopRegistration")
				|| hreq.getRequestURI().contains("/IVEDA/gallery")
				|| hreq.getRequestURI().contains("/IVEDA/saveAboutUs")
				|| hreq.getRequestURI().contains("/IVEDA/NewsEvents")
				//|| hreq.getRequestURI().contains("/IVEDA/getgalleryimage")
				|| hreq.getRequestURI().contains("/IVEDA/getmaingalleryimage")
				|| hreq.getRequestURI().contains("/IVEDA/deletegallerydata")
				|| hreq.getRequestURI().contains("/IVEDA/gallery")
				|| hreq.getRequestURI().contains("/IVEDA/saveReportProblem")
				|| hreq.getRequestURI().contains("/IVEDA/saveAboutUs") || hreq.getRequestURI().contains("/IVEDA/test")
				|| hreq.getRequestURI().contains("/IVEDA/NewsEvents")
				|| hreq.getRequestURI().contains("/IVEDA/download/IVEDA_UM.docx")
				|| hreq.getRequestURI().contains("/IVEDA/download/Product.xlsx")
				|| hreq.getRequestURI().contains("/IVEDA/getEmailData")
				|| hreq.getRequestURI().contains("/IVEDA/AddMemberDetails")
				|| hreq.getRequestURI().contains("/IVEDA/download/")
				|| hreq.getRequestURI().contains("/IVEDA/getRegionMasterDetails")
				|| hreq.getRequestURI().contains("/download/PN 66_0.pdf")
				|| hreq.getRequestURI().contains("/IVEDA/getRejectedRegistrationListing")
				|| hreq.getRequestURI().contains("/IVEDA/getVersionDetls")
				|| hreq.getRequestURI().contains("/IVEDA/queryMst")
				|| hreq.getRequestURI().contains("/IVEDA/videotutorial")
				|| hreq.getRequestURI().contains("/guest/resendotp") || hreq.getRequestURI().contains("/IVEDA/RCMCData")
				|| hreq.getRequestURI().contains("/IVEDA/fetchDataConsignmentDtls/*")
				|| hreq.getRequestURI().contains("/IVEDA/getAllRegistrationDataListing")
				|| hreq.getRequestURI().contains("/IVEDA/screenreader")
				|| hreq.getRequestURI().contains("/IVEDA/HashCodeCheck")
				|| hreq.getRequestURI().contains("/IVEDA/receivedHash")
				|| hreq.getRequestURI().contains("/IVEDA/resetDongle")
				// ALL CRS-BIS CONTROLLERS
				|| hreq.getRequestURI().contains("/IVEDA/showTestData")
				|| hreq.getRequestURI().contains("/IVEDA/LapsingAndDeferredDataDetails")
				|| hreq.getRequestURI().contains("/IVEDA/GemReportDetailsData"))
			return true;
		return false;
	}

	/*
	 * private boolean shouldExclude(HttpServletRequest hreq) {
	 * if(hreq.getRequestURI().endsWith(".css") ||
	 * hreq.getRequestURI().endsWith(".xlsx")||
	 * hreq.getRequestURI().endsWith(".docx")||
	 * hreq.getRequestURI().endsWith(".js")||
	 * hreq.getRequestURI().endsWith(".png")||
	 * hreq.getRequestURI().endsWith(".json")
	 * ||hreq.getRequestURI().endsWith(".jpg") ||
	 * hreq.getRequestURI().endsWith(".jpeg") ||
	 * hreq.getRequestURI().equals("/IVEDA/getcntstat") ||
	 * hreq.getRequestURI().equals("/IVEDA/DummyCharts") ||
	 * hreq.getRequestURI().endsWith(".woff2") ||
	 * hreq.getRequestURI().equals("/IVEDA/error") ||
	 * hreq.getRequestURI().endsWith(".ttf") ||
	 * hreq.getRequestURI().equals("/IVEDA/css/") ||
	 * hreq.getRequestURI().equals("/IVEDA/login") ||
	 * hreq.getRequestURI().equals("/IVEDA/") ||
	 * hreq.getRequestURI().equals("/IVEDA/updateProfile") ||
	 * hreq.getRequestURI().equals("/IVEDA/changePassword") ||
	 * hreq.getRequestURI().contains("/IVEDA/updatePassword") ||
	 * hreq.getRequestURI().equals("/IVEDA/rcmcRegistration")||
	 * hreq.getRequestURI().equals("/IVEDA/getCompanyProfileData") ||
	 * hreq.getRequestURI().contains("/IVEDA/RCMCRegData") ||
	 * hreq.getRequestURI().equals("/IVEDA/getRCMCData") ||
	 * hreq.getRequestURI().equals("/IVEDA/getRegistrationPendingListing") ||
	 * hreq.getRequestURI().contains("/IVEDA/emailVerification") ||
	 * hreq.getRequestURI().equals("/IVEDA/getApprovedRegistrationListing") ||
	 * hreq.getRequestURI().equals("/IVEDA/getPointsOfDistributionDtls") ||
	 * hreq.getRequestURI().contains("/IVEDA/FeedbackResponse") ||
	 * hreq.getRequestURI().contains("/IVEDA/getFeedbackResponseListing") ||
	 * hreq.getRequestURI().contains("/IVEDA/getManufacturingSiteListing") ||
	 * hreq.getRequestURI().contains("/IVEDA/getStateData") ||
	 * hreq.getRequestURI().contains("/IVEDA/getDistrictData") ||
	 * hreq.getRequestURI().contains("/IVEDA/countrybasedOnRegion") ||
	 * hreq.getRequestURI().contains("/IVEDA/getManufactreData") ||
	 * hreq.getRequestURI().contains("/IVEDA/getProductData")||
	 * hreq.getRequestURI().contains("/IVEDA/getAllDrugDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/getDrugDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/getUploadXmlDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/getAllUploadXmlDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/PreviewPremisesDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/finalSubmitMemberSiteDetails")||
	 * hreq.getRequestURI().contains("/IVEDA/getConsignmentUploadXmlDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/getGeneratePackCode") ||
	 * hreq.getRequestURI().contains("/IVEDA/getExportOrderDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/getLocationMaster") ||
	 * hreq.getRequestURI().contains("/IVEDA/getProcurementDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/downloadExcelGeneratePack") ||
	 * hreq.getRequestURI().contains("/IVEDA/getPortOfExport") ||
	 * hreq.getRequestURI().contains("/IVEDA/PerformSolrSearch") ||
	 * hreq.getRequestURI().contains("/IVEDA/downloadAckFile_Secure")||
	 * hreq.getRequestURI().contains("/IVEDA/RegistrationOfficials") ||
	 * hreq.getRequestURI().contains("/IVEDA/PerformDBSearch") ||
	 * hreq.getRequestURI().contains("/IVEDA/getRecalledUploadXML")||
	 * hreq.getRequestURI().contains("/IVEDA/ConsignmentDetailPage") ||
	 * hreq.getRequestURI().contains("/IVEDA/downloadTmpFile_Secure") ||
	 * hreq.getRequestURI().contains("/IVEDA/getSignatureChecksum") ||
	 * hreq.getRequestURI().contains("/IVEDA/viewTmpFile_Secure") ||
	 * hreq.getRequestURI().contains("/IVEDA/getdrugChecksum") ||
	 * hreq.getRequestURI().contains("/IVEDA/uploadFileXml")||
	 * hreq.getRequestURI().contains("/IVEDA/saveAppTypeMst") ||
	 * hreq.getRequestURI().contains("/IVEDA/uploadFile")
	 * ||hreq.getRequestURI().contains("IVEDA/addressProofFile)")||
	 * hreq.getRequestURI().contains("/IVEDA/drugLicence") ||
	 * hreq.getRequestURI().contains("/IVEDA/viewUploadedXML") ||
	 * hreq.getRequestURI().contains("/IVEDA/getStatisticsData") ||
	 * hreq.getRequestURI().contains("/IVEDA/EmailData") ||
	 * hreq.getRequestURI().contains("/IVEDA/getManufSiteUserList") ||
	 * hreq.getRequestURI().contains("/IVEDA/getUserNameStatus") ||
	 * hreq.getRequestURI().contains("/IVEDA/getAddedMemberData") ||
	 * hreq.getRequestURI().contains("/IVEDA/getAddedMemberList") ||
	 * hreq.getRequestURI().contains("/IVEDA/downloadPdf") ||
	 * hreq.getRequestURI().contains("/IVEDA/getUploadExporterDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/HSAPDF") ||
	 * hreq.getRequestURI().contains("/IVEDA/getAllPointOfDistDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/ReportProblem") ||
	 * hreq.getRequestURI().contains("/IVEDA/getCaptcha") ||
	 * hreq.getRequestURI().contains("/IVEDA/getDynamicHomepage") ||
	 * hreq.getRequestURI().contains("/IVEDA/AboutUs") ||
	 * hreq.getRequestURI().contains("/IVEDA/faq") ||
	 * hreq.getRequestURI().contains("/IVEDA/WorkshopRegistration") ||
	 * hreq.getRequestURI().contains("/IVEDA/gallery") ||
	 * hreq.getRequestURI().contains("/IVEDA/saveAboutUs") ||
	 * hreq.getRequestURI().contains("/IVEDA/NewsEvents") ||
	 * hreq.getRequestURI().contains("/IVEDA/getgalleryimage") ||
	 * hreq.getRequestURI().contains("/IVEDA/getmaingalleryimage")||
	 * hreq.getRequestURI().contains("/IVEDA/deletegallerydata") ||
	 * hreq.getRequestURI().contains("/IVEDA/gallery") ||
	 * hreq.getRequestURI().contains("/IVEDA/saveReportProblem") ||
	 * hreq.getRequestURI().contains("/IVEDA/saveAboutUs") ||
	 * hreq.getRequestURI().contains("/IVEDA/test") ||
	 * hreq.getRequestURI().contains("/IVEDA/NewsEvents") ||
	 * hreq.getRequestURI().contains("/IVEDA/download/IVEDA_UM.docx") ||
	 * hreq.getRequestURI().contains("/IVEDA/download/Product.xlsx") ||
	 * hreq.getRequestURI().contains("/IVEDA/download/PROSchema.xsd") ||
	 * hreq.getRequestURI().contains("/IVEDA/download/PROSchema.xml") ||
	 * hreq.getRequestURI().contains("/IVEDA/download/IVEDAExporterPackingDtl.xsd")
	 * ||
	 * hreq.getRequestURI().contains("/IVEDA/download/IVEDAExporterPackingDtl.xml")
	 * ||
	 * hreq.getRequestURI().contains("/IVEDA/download/ExporterTertiaryExcel.xlsx")||
	 * hreq.getRequestURI().contains("/IVEDA/getEmailData") ||
	 * hreq.getRequestURI().contains("/IVEDA/ShowDrugDetails") ||
	 * hreq.getRequestURI().contains("/IVEDA/download/")||
	 * hreq.getRequestURI().contains("/IVEDA/getRegionMasterDetails") ||
	 * hreq.getRequestURI().contains("/download/PN 66_0.pdf") ||
	 * hreq.getRequestURI().contains("/IVEDA/getRejectedRegistrationListing") ||
	 * hreq.getRequestURI().contains("/IVEDA/RejectedRegistration")||
	 * hreq.getRequestURI().contains("/IVEDA/getVersionDetls") ||
	 * hreq.getRequestURI().contains("/IVEDA/queryMst")||
	 * hreq.getRequestURI().contains("/IVEDA/videotutorial") ||
	 * hreq.getRequestURI().contains("/guest/resendotp") ||
	 * hreq.getRequestURI().contains("/IVEDA/AllUploadedDataReport") ||
	 * hreq.getRequestURI().contains("/IVEDA/RCMCData")||
	 * hreq.getRequestURI().contains("/IVEDA/fetchDataConsignmentDtls/*")||
	 * hreq.getRequestURI().contains("/IVEDA/getAllRegistrationDataListing") ||
	 * hreq.getRequestURI().contains("/IVEDA/screenreader")) return true; return
	 * false; }
	 */

}
