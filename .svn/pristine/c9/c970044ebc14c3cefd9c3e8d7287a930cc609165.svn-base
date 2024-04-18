<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>


<!DOCTYPE html>
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



	<script type="text/javascript" src="js/validation/customValidation.js"></script>

	<script type="text/javascript" src="js/Registration/registration.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
	<script type="text/javascript" src="js/globalJs/globalJs.js"></script>
	<script type="text/javascript" src="js/validation/bootstrapValidator.js"></script>
																				 
	
	
	
	

<title>IVEDA</title>
<style type="text/css">
		.alert-box {
	padding: 15px;
    margin-bottom: 20px;
    border: 1px solid transparent;
    border-radius: 4px;  
}
	#cimage {
    margin-left: 10px;
    margin-top: 1px;
    border: 1px solid gray;
    padding: 1px;
    background: #fff;
}

.success {
    color: #3c763d;
    background-color: #dff0d8;
    border-color: #d6e9c6;
    display: none;
}

.failure {
    color: #a94442;
    background-color: #f2dede;
    border-color: #ebccd1;
    display: none;
}

.warning {
    color: #8a6d3b;
    background-color: #fcf8e3;
    border-color: #faebcc;
    display: none;
}
.form #cimage{
background:transparent !important;
border:none !important;
}

canvas{
    border: 1px black solid;
}
#textCanvas{
    display: none;
}


	</style>
	
	 <style> 
        table { 
            margin: 25px 0; 
            width: 200px; 
        } 
  
        table th, table td { 
            padding: 10px; 
            text-align: center; 
        } 
  
        table, th, td { 
            border: 1px solid; 
        } 
    </style> 
    

 
</head>
<body>
<section class="reg_note regdv form-page" id="skiptomaincontent">
	<div class="container">
		<div class="page-title text-center">
      		<h1 class="fw-bold position-relative">${applicantTypeData} <span>Registration</span>  </h1>
									
		
													  
		
    	</div>
		
		<div class="alert alert-warning bg-white" role="alert">
			<div class="text-left">
				<p>As you  not a registered member of PHARMEXCIL and the application was selected as Merchant Exporter, then a corporate registration of account is mandatory from your organization. After that, the multiple user accounts can be created from the Merchant Exporter Dash board.</p>
			</div>
		
			<strong class="h4 pad-left double bold">Note:</strong>
				<ol>
		        	<li>For each organization only one corporate registration is allowed and from there multiple user accounts can be created according to the different locations etc.</li>
		        	<li>Authorized Signatory / Responsible person of the organization should fill the form.</li>
		        	<li>All fields marked with asterik (<span style="color:#cd2026;">*</span>) are mandatory. </li>
		        	
		        	<li><span class="bold">Registration Steps</span>
		        	<ol type="a">
			        	<li>You cannot edit the details, once you have continue to the next step</li>
			        	<li>After submitting the Registration Form, an E-mail Verification link will be sent to your Registered/Corporate email id </li>	
		        		<li>After successful verification of your email, the registration request will be sent to PHARMEXCIL for final verification.</li>
		        		<li>Once after PHARMEXCIL approves your request, you will get an email as your <b>Registration is Approved</b> along with a Unique Code.</li>
		        		<li>On the first login you will be required to change the Login Password.</li>
		        	</ol>
					<li>If you are a Manufacturer, this account is only for corporate registration. After this , multiple user accounts can be created from manufacturer dashboard.</li>
        	
		        	
			 
		        </ol>
				</div>
			</div>

	
	
	<div class="container reg_contain">
	
		<c:if test="${registrationStatus}">
			<div class="alert-box warning">Invalid Captcha Please try again</div>
		</c:if>
		<c:if test="${serversideValidationException}">
			<div class="alert-box warning">${serversideValidationExceptionMessage}</div>
		</c:if>
		<c:if test="${fileValidException}">
			<div class="alert-box warning">Unsupported file type</div>
		</c:if>
		
	
	<!-- 	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittle">Registration</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div> -->
							
		<div class="scroll-top-wrapper ">
			<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>

		</div>
		
		<div class="col-md-12 p-0">
			<form:form  method="post" id="frm" name="frm" modelAttribute="registrationForm" action="${pageContext.request.contextPath}/registration"  enctype="multipart/form-data" autocomplete="off">
													   
				<sec:csrfInput/>
				<div class="panel panel-default " id="Manufacture_Registration"> 
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Create your iVEDA Account .... Continue to access the iVEDA portal</b></div>
					<div class="panel-body dvfrm-panel-body">
						<div class="row">
	 
							<div class=" col-md-4 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label"  for="userName">User-Name:<span style="color:#cd2026;">*</span><small class="newsout">must be a working email id</small>
									<span class="iconStyle"></span>
										</label>
									<form:input path="userName" type="email" class="form-control"
										 id="userName" placeholder="Enter Corporate Email Id" required="required" onchange="checkUserExist(this)" style="text-transform:lowercase"/>
								</div>
							</div><!--end col1-->
	  
	  
							<div class="col-md-4 col-sm-12 col">
								<div class="form-group">
								<label class="dvfrm-label" for="Pswd">Password:<span style="color:#cd2026;">*</span> </label>
	   
												   
															 
								<form:input path="password" type="password" class="form-control col-md-10" name="Pswd" id="Pswd" placeholder="Enter Password" autocomplete="off" required="required"/>
								<div class="col-md-10" id="Pswd_strength_wrap" style="display: none;">
								
									<div id="passwordDescription">Password not entered</div>
										<div id="passwordStrength" class="strength0"></div>
										<div id="pswd_info">
											<strong>Strong Password Tips:</strong>
											<ul>
												<li class="invalid" id="length">At least 8 characters</li>
												<li class="invalid" id="pnum">At least one number</li>
												<li class="invalid" id="capital">At least one lowercase
													&amp; one uppercase letter</li>
												<li class="invalid" id="spchar">At least one special
													character ( ! @ # $ % ^ & * ( ) _ - )</li>
											</ul>
										</div>

									</div>
								</div>
							</div><!--end col3-->
							<div class="col-md-4 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label"  for="conPswd">Confirm Password:<span style="color:#cd2026;">*</span> </label>
									<input type="password" class="form-control" autocomplete="off" name="conPswd" id="conPswd" placeholder="Confirm Password" onchange="checkBothPasswords(this.value)" required="required"/>			
								</div>
							</div><!--end col3-->
		
						</div>
							   
																										 
																	  
																																   
		 
		
			
						
						
						<div class="row">
							
						</div>
						
					</div>
				</div>
				
				<div class="panel panel-default " id="organizationDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Corporate Address Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label"  for="applicantType">Applicant Type<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<%-- <label>${numUserTypeName}</label> --%>
										<c:choose>
											<c:when test="${registrationForm.applicantType=='100'}">
												<form:select path="applicantType" id="applicantType" class="form-control">
													<form:option value="100">Manufacturer Exporter</form:option>
												</form:select>
											</c:when>
											<c:when test="${registrationForm.applicantType=='101'}">
												<form:select path="applicantType" id="applicantType" class="form-control">
													<form:option value="101">Merchant Exporter</form:option>
												</form:select>
											</c:when>
										</c:choose>
										
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label"  for=orgName>Organization Name<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="orgName" type="text" class="form-control"
									 			id="orgName" placeholder="Enter Organization Full Name" onchange="" required="required"/>	
									</div>
								</div>
								
								
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label " for=orgAddress>Address<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
												<form:input path="orgAddress" type="text" class="form-control"
									 				id="orgAddress" placeholder="Enter Organization Full Address" onchange="" required="required"></form:input>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgCountryId>Country<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="orgCountryId" class="form-control" id="orgCountryId" required="required" onchange="selectState(this.value)">
											<form:option value="0">--select Organization Country--</form:option>
											<form:option value="193">India</form:option>
											<%-- <c:forEach items="${countryMst }" var="countryDetails">
												<form:option value="${countryDetails.num_country_id}">${countryDetails.str_country_name}</form:option>
											</c:forEach> --%>
										</form:select>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgStateId>State<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<form:select path="orgStateId" class="form-control" id="orgStateId" required="required" onchange="selectDistrict(this.value)">
												<form:option value="0">--select Organization State--</form:option>
												<c:forEach items="${OrgstatesNames }" var="statesDetails">
													<form:option value="${statesDetails.num_state_id}">${statesDetails.str_state_name}</form:option>
												</c:forEach>
											</form:select>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgDistId>District<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="orgDistId" class="form-control" id="orgDistId" required="required">
												<form:option value="0">--select Organization District--</form:option>
												<c:forEach items="${OrgdistrictNames}" var="districtDetails">
													<form:option value="${districtDetails.num_district_id}">${districtDetails.str_district_name}</form:option>
												</c:forEach>
											</form:select>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label"  for=orgPincode>Pin Code<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="orgPincode" type="number" class="form-control"
									 			id="orgPincode" placeholder="Enter Pin code"/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgContactNumber>Contact Numbers<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="orgContactNumber" type="text" class="form-control"
									 			id="orgContactNumber" placeholder="Enter Contact Number"/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgFaxNumber>Fax Number<span class="orange"></span><span class="iconStyle"></span></label>
										<form:input path="orgFaxNumber" type="number" class="form-control"
									 			id="orgFaxNumber" placeholder="Enter Fax Number" />	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgEmailId>Email Id<span style="color:#cd2026;"></span><span class="iconStyle"></span></label>
										<form:input path="orgEmailId" type="text" class="form-control"
									 			id="orgEmailId" placeholder="Enter Email Id" onchange=""/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgPanNumber>PAN Number<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<%-- <form:input path="orgPanNumber" type="text" class="form-control" --%>
										<form:input path="orgPanNumber" type="password" class="form-control"
									 			id="orgPanNumber" placeholder="Enter PAN Number" onchange=""/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgWebsite>Website:<span class="orange"></span><span class="iconStyle"></span></label>
										<form:input path="orgWebsite" type="url" class="form-control"
									 			id="orgWebsite" placeholder="Enter Website" onchange=""/>	
									</div>
								</div>
								
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=gstnumber>GSTIN Number<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="gstnumber" type="text" class="form-control"
									 			id="gstnumber" placeholder="Enter GSTIN Number" onchange=""/>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=gsOne>GS1 Company Prefix<span style="color:#cd2026;"></span><span class="iconStyle"></span></label>
										<form:input path="gsOne" type="text" class="form-control"
									 			id="gsOne" placeholder="Enter GS1 Company Prefix" onchange=""/>
									</div>
								</div>
								
								
								<input type="hidden" name="registeredWithRcmc" id="registeredWithRcmc" value="${registeredWithRcmc}" aria-label="registeredWithRcmc">
								
								
								<%-- <c:if test="${not registeredWithRcmc}"> --%>
								
									<div class="col-md-6 col-sm-12 col"  id="otherExportPromotionCouncil">
										<div class="form-group">
											<label class="dvfrm-label" for=memberOfOtherExportPromotionCouncil>Are you the member of any other Export Promotion Council/Association<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<form:select path="memberOfOtherExportPromotionCouncil" class="form-control" id="memberOfOtherExportPromotionCouncil" onchange="getFieoRcmcNumber(this.value)">
										  	<form:option value="0">--select--</form:option>
										  		<form:option value="yes">Yes</form:option>
										  		<form:option value="no">No</form:option>
											</form:select>
										</div>
									</div>
									
									<%-- <div class=" col-md-6" style="display: none;" id="rcmcOfFieo">
										<label class="dvfrm-label" for=rcmcOfFieo>Registration Number of FIEO/Chemiexcil/CAPEXIL/AIMED/others<span class="orange"></span><span class="iconStyle"></span></label>
										<form:input path="rcmcOfFieo" class="form-control" id="rcmcOfFieoOne"></form:input>
									</div> --%>
								
								<%-- </c:if> --%>
						
								
								<div id="otherPromostionCouncilTable" style="display: none;">
									<table class="table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered dspit" id="m_table_1" style="margin-top: 1%;width:100%;">
										<thead class="theadTransacColor">
										<tr>
											<th>Promotion Council's/Association's</th>
											<th>Registration No.</th>
											<th>Validity Date</th></tr>
										</thead>
										<tbody>
											<tr>
												<td>
												
										
										<select class="form-control" name="promotionCouncil" id="promotionCouncil_1">
										<option value="0">--Select Export Promotion Councils/Associations--</option>
										<c:forEach items="${councilList }" var="councilList">
											<option value="${councilList.id }">${councilList.councilName}</option>
										</c:forEach>
										</select>
										
												</td>
												<!--  added by govind -->
												<%-- <td><form:input type="text" path="registrationNumber" id="registrationNumber_${lineNo}" onchange="ValidateString(this)" class="form-control" aria-label="registration Number"></form:input></td> --%>
													<td><form:input  path="registrationNumber" id="registrationNumber_1"  onblur="ValidateString(this)" class="form-control" aria-label="registration Number"></form:input></td>
												<%-- <td><form:input  path="registrationNumber" id="registrationNumber_1"  class="form-control" aria-label="registration Number"></form:input></td> --%>
												<td> 
												<form:input path="" type="date" name="validityDuration" id="validityDate_1" class="form-control" placeholder="Validity Date" aria-label="validity Duration"/>
												</td>
											</tr>
										</tbody>
									</table>
									
									<input type="button" value="Add Row" class="add-row custom-btn position-relative" aria-label="Add Row button">
									<input type="button" value="Remove Last Row" class="remove-row custom-btn position-relative" aria-label="Remove Row button">
								</div>
							</div>
						</div>
				</div>
				
				<!-- manufacturing details -->
				
				
				<div class="panel panel-default " id="manufacturingDetails" style="display: none;">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Manufacturing Site Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfSiteName>Name<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="manfSiteName" type="text" class="form-control"
									 			id="manfSiteName" placeholder="Enter Manufacturing Site Name" onchange="ValidateString(this)"/>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfSiteAddress>Address<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:textarea path="manfSiteAddress" type="text" class="form-control"
									 			id="manfSiteAddress" placeholder="Enter Manufacturing Site Address"  onchange="addressVAlidation(this)"/>	
									</div>
								</div>
								
								
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label"  for=manfCountryId>Country<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="manfCountryId" class="form-control" id="manfCountryId" onchange="selectManfState(this.value)">
											<form:option value="0">--select Country--</form:option>
											<form:option value="193">India</form:option>
											<%-- <c:forEach items="${countryMst }" var="countryDetails">
												<form:option value="${countryDetails.num_country_id}">${countryDetails.str_country_name}</form:option>
											</c:forEach> --%>
										</form:select>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfStateId>State<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<form:select path="manfStateId" class="form-control" id="manfStateId"  onchange="selectManfDistrict(this.value)">
												<form:option value="0">--select State--</form:option>
		   
												<c:forEach items="${ManfstatesNames }" var="statesDetails">
													<form:option value="${statesDetails.num_state_id}">${statesDetails.str_state_name}</form:option>
												</c:forEach>
											</form:select>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfDistId>District<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="manfDistId" class="form-control" id="manfDistId">
												<form:option value="0">--select State--</form:option>
												<c:forEach items="${ManfdistrictNames }" var="districtDetails">
													<form:option value="${districtDetails.num_district_id}">${districtDetails.str_district_name}</form:option>
												</c:forEach>
											</form:select>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfSiteCity>City<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="manfSiteCity" type="text" class="form-control"
									 			id="manfSiteCity" placeholder="Enter Manufacturing Site City" />	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label"  for=manfSitePincode>Pin Code<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="manfSitePincode" type="number" class="form-control"
									 			id="manfSitePincode" placeholder="Enter Manufacturing Site Pin Code" onchange="numbersOnly(this)"/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfSiteContactNumber>Contact Number<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="manfSiteContactNumber" type="number" class="form-control"
									 			id="manfSiteContactNumber" placeholder="Enter Manufacturing Site Contact Number" onchange="numbersOnly(this)" maxlength="20" onkeydown="javascript: return ['Backspace','Delete','ArrowLeft','ArrowRight'].includes(event.code) ? true : !isNaN(Number(event.key)) && event.code!=='Space'" min="4"/>	
									</div>
									</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfSiteFaxNumber>Fax Number<span class="orange"></span><span class="iconStyle"></span></label>
										<form:input path="manfSiteFaxNumber" type="text" class="form-control"
									 			id="manfSiteFaxNumber" placeholder="Enter Manufacturing Site Fax Number" onchange="ValidateString(this)" />	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=manfLicNumber>LIC Number<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="manfLicNumber" type="text" class="form-control"
									 			id="manfLicNumber" placeholder="Enter Manufacturing LIC Number" onchange="ValidateString(this)"/>	
									</div>								
								</div>								
							</div>
						</div>
				</div>
				
								<!-- Contact Person details -->
				<div class="panel panel-default " id="ssiDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Contact Person Details (Authorized Signatory / Responsible person of the organization)</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label"  for=contactPersonName>Name<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="contactPersonName" type="text" class="form-control"
											 id="contactPersonName" placeholder="Enter Full Name with Surname" onchange="" required="required"/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=contactPerDesg>Designation<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="contactPerDesg" type="text" class="form-control"
											 id="contactPerDesg" placeholder="Enter Designation" onchange="" required="required"/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=contPerMobileNo>Mobile Number<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="contPerMobileNo" type="number" class="form-control"
											 id="contPerMobileNo" placeholder="Enter Mobile Number" onchange="" required="required"/>	
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=contPersEmail>Email Id<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="contPersEmail" type="email" class="form-control"
											 id="contPersEmail" placeholder="Enter Email Id" onchange="" required="required"/>	
									</div>
								</div>
							
							</div>
						</div>	
				</div>
				
				<!-- IEC details -->
				
				<div class="panel panel-default " id="iecDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>DGFT IEC Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class="col-md-4 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=iecNumber>IEC Number<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="iecNumber" type="text" class="form-control"
											 id="iecNumber" placeholder="Enter IEC Number" onchange="checkIecnumber(this.value)" required="required"/>	
									</div>
								</div>
								
									<div class="col-md-4 col-sm-12 col">
									 	<div class="form-group">
										<label class="dvfrm-label" for=iecIssueDate>IEC Issue Date<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
									
	       								 <div class='input-group date w-100' id='datetimepicker6'>
	        								<%-- <form:input path="iecIssueDate" type="text" class="form-control" value="${iecIssueDate}"
											 id="iecIssueDate" placeholder="Enter IEC Issuing Date" required="required"/><span class="input-group-addon"> --%>
											 
											  <%-- <input type="text" id="datetimepicker" name="iecIssueDate" class="form-control" value="${iecIssueDate}" placeholder="Enter IEC Issuing Date" required="required"><span class="input-group-addon"> 
	                        				<span class="glyphicon glyphicon-calendar"></span> --%>
	                        
	                        				<form:input path="" type="date" name="iecIssueDate" id="iecIssueDate" class="form-control" placeholder="Enter IEC Issuing Date"/><span class="input-group-addon p-0" ></span>					
	                        			</div>
      								</div>
								</div>

								<div class="col-md-4 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=iecIssueAuthority>IEC Issuing Authority<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
																			  
										<form:input path="iecIssueAuthority" type="text" class="form-control" id="iecIssueAuthority" placeholder="Enter IEC Issuing Authority" onchange="" required="required" value="DGFT Authority"/>
									</div>
								</div>
		
		
							</div>
						</div>
								
				</div>
				
				<form:hidden path="numRcmcFlag" value="${numRcmcFlag}"/>
				<form:hidden path="str_rcmc_fieo_no" value="${str_rcmc_fieo_no}"/>
				<!-- SSI details -->
				
				<div class="panel panel-default " id="ssiDetails">
					<!-- <div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>SSI(Small Scale Industry) Details</b></div> -->
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>MSME / IEM (Micro, Small and Medium Enterprises) Details</b></div>
					<div class="panel-body dvfrm-panel-body">
						<div class="row">
							<div class="col-md-6 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label" for=ssiNumber>MSME / IEM Number<span style="color:#cd2026;"></span><span class="iconStyle"></span></label>
									<form:input path="ssiNumber" type="text" class="form-control"
										 id="ssiNumber" placeholder="Enter MSME / IEM Number" onchange=""/>	
								</div>
							</div>
							
							<div class="col-md-6 col-sm-12 col">																	   
								<div class="form-group">
							        <div class='input-group date' id='datetimepicker7'>	
							        	<label class="dvfrm-label" for=ssiIssueDate>MSME / IEM Issue Date<span style="color:#cd2026;"></span><span class="iconStyle"></span></label>
							        	<form:input path="" type="date" name="ssiIssueDate" class="form-control" placeholder="Enter MSME / IEM Issuing Date" value="${ssiIssueDate}" id="ssiIssueDate"/><span class="input-group-addon" id="ssiIssueDate" aria-label="ssi Issue Date"></span>							   
							        </div>
  								</div>	
							</div>
							
							<div class="col-md-6 col-sm-12 col">																	   
								<div class="form-group">
								 	<label class="dvfrm-label">Enterprise Category</label>
								        <select class="form-control" id="categoryDropdown" name="categoryDropdown">
								        	<option value="0">--select--</option>
								            <option value="microEnterprise">Micro Enterprise</option>
								            <option value="smallEnterprise">Small Enterprise</option>
								            <option value="mediumEnterprise">Medium Enterprise</option>
								        </select>							        
  								</div>	
							</div>							
							
						</div>
					</div>	
				</div>
			
				<div class="panel panel-default " id="ssiDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Organization/Company Incorporation Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
							<div class="col-md-6 col-sm-12 col">																	   
								<div class="form-group">
								 	<label class="dvfrm-label">Organization Address Proof Type:<span style="color:#cd2026;">*</span></label>
								        <select class="form-control" id="orgDropdown" name="orgDropdown">
								        	<option value="0">--select--</option>
								            <option value="IEC">Importer Exporter Code(IEC) </option>
								            <!-- <option value="GST">Goods and Service Tax(GST)</option>
								            <option value="PAN">Permanent Account Number(PAN)</option> -->
								        </select>							        
  								</div>	
							</div>
																
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<form:hidden path="numDocId" id="numDocId"/>
										<form:hidden path="filename" id="filename"/>
										<form:hidden path="hppGeneratedData" id="hppGeneratedData"/>
										<form:hidden path="hashValue" id="hashValue"/>
				                		<form:hidden path="strDocId" id="strDocId"  value="-1" />									 
										<label class="dvfrm-label" for=addressProofId>Upload Address Proof:<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<input type="file" class="form-control" name="addressProofFile" id="addressProofId" placeholder="Please upload pdf only" 
												accept="application/pdf" onchange="fileValidation(this.id);getSignatureChecksum(this.id);filechecksum(this.id)"/>
										<input type="hidden" name="addressProofDocument" id="addressProofDocument" aria-label="addressProofDocument">
									</div>
								</div>
								
								
							</div>
						</div>
				</div>
				
				<c:if test="${registrationForm.applicantType=='101'}">
					<div class="panel panel-default " id="ssiDetails">
						<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Copy of the Drug licence(wholesale licence)</b></div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-md-6 col-sm-12 col">
										<div class="form-group">
											<form:hidden path="numDrugDocId" id="numDrugDocId"/>
											<form:hidden path="hppGeneratedData2" id="hppGeneratedData2"/>
										<form:hidden path="hashValue2" id="hashValue2"/>
				                    <form:hidden path="strDrugDocId" id="strDrugDocId"  value="-1" />											 
											<label class="dvfrm-label" for=drugLicence>Upload your Drug licence:<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<input type="file" class="form-control" name="drugLicence" id="drugLicence" placeholder="Please upload pdf only"  accept="application/pdf" onchange="fileValidation(this.id);getdrugChecksum(this.id);filechecksumm(this.id)"/>
																								  
											<input type="hidden" name="drugLiecenseDocument" id="drugLiecenseDocument" aria-label="drugLiecenseDocument">
										</div>
									</div>
								</div>
							</div>
					</div>
				</c:if>
				
  
	
	
				<div class="panel-body dvfrm-panel-body">
					<div class="row">
						<div class="form-group">
							<label class="dvfrm-label d-block" for="regCaptcha">Enter Security Code</label>
								<div class="col-md-3 col-sm-3 col-xs-12 col">
									<h4 id="registrationCaptchaOne" style="user-select:none;">${registrationCaptcha}</h4>
								</div>
								<%-- <input type="hidden" id="loginCaptcha" value="${registrationCaptcha}"> --%>
								<div class="col-md-9 col-sm-9 col-xs-12 col d-flex">
									<form:input path="regCaptcha" type="text" class="form-control"
									 id="regCaptcha" placeholder="Enter Captcha" required="required"/>
			   
									 <div class="refresh_reg" onclick="changeRegistrationCaptcha()"> 
	        						<i class="fa fa-refresh" aria-hidden="true"></i>
	        					</div>	
		
								</div>
						</div>
					</div>

					<div class="col-md-12 p-0">
					<div class="form-group">
<%-- 						<label for="agreementCheckBox"> <form:checkbox path="" value="" id="agreementCheckBox" aria-label="agreement CheckBox"/> <span class="pad-left">I
						agree to the <a id="TermsView" target="_blank" href="${pageContext.request.contextPath}/download/ivedaTermsAndConditions.pdf">terms, conditions and privacy policy </a> <span style="color:#cd2026;"></span> </span>  laid down by pharmaceutical Export Promotion Council of India  for availing the online services provided under this portal. <span style="color:#cd2026;">*</span>
						</label> --%>
						<label for="agreementCheckBox"> <form:checkbox path="" value="" id="agreementCheckBox" aria-label="agreement CheckBox"/> <span class="pad-left">I
						agree to the terms, conditions and privacy policy <span style="color:#cd2026;"></span> </span>  laid down by pharmaceutical Export Promotion Council of India  for availing the online services provided under this portal. <span style="color:#cd2026;">*</span>
						</label>
					</div>
				</div>
				</div>
				
   
									   
											  
														   
																																		
																							 
																												  
															  
			   
		  
	  
				<!-- Success message -->
				<div class="alert alert-success" role="alert" id="success_message" style="display: none;">Success <i class="glyphicon glyphicon-thumbs-up"></i></div> 
						
				<div class="text-center">
					<input type="button" class="custom-btn position-relative" id="infosavebutton" value="Submit" onclick="validform()"/>
	                <button type="reset" class="custom-btn position-relative">Reset </button>
		   
			  
               	</div>
			</form:form>
		</div>
		
	</div>
	
	</section>	
	
	
	
		<script>

 
$("input#Pswd").on("focus keyup", function () {
        var score = 0;
        var a = $(this).val();
        var desc = new Array();
 
        // strength desc
        desc[0] = "Too short";
        desc[1] = "Weak";
        desc[2] = "Good";
        desc[3] = "Strong";
        desc[4] = "Best";
 
        $("#Pswd_strength_wrap").fadeIn(400);
         
        // password length
        if (a.length >= 8) {
            $("#length").removeClass("invalid").addClass("valid");
            score++;
        } else {
            $("#length").removeClass("valid").addClass("invalid");
        }
 
        // at least 1 digit in password
        if (a.match(/\d/)) {
            $("#pnum").removeClass("invalid").addClass("valid");
            score++;
        } else {
            $("#pnum").removeClass("valid").addClass("invalid");
        }
 
        // at least 1 capital & lower letter in password
        if (a.match(/[A-Z]/) && a.match(/[a-z]/)) {
            $("#capital").removeClass("invalid").addClass("valid");
            score++;
        } else {
            $("#capital").removeClass("valid").addClass("invalid");
        }
 
        // at least 1 special character in password {
        if ( a.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/) ) {
                $("#spchar").removeClass("invalid").addClass("valid");
                score++;
        } else {
                $("#spchar").removeClass("valid").addClass("invalid");
        }
 
 
        if(a.length > 0) {
                //show strength text
                $("#passwordDescription").text(desc[score]);
                // show indicator
                $("#passwordStrength").removeClass().addClass("strength"+score);
        } else {
                $("#passwordDescription").text("Password not entered");
                $("#passwordStrength").removeClass().addClass("strength"+score);
        }
});
 

						 
									 
					
	  

																			   


		 
 
				 
								
						  
					   
				 
		  
				
							
							
								
						  

//Pswd																					  
	 
/* 												 
$("#Pswd").on("change", encodePass);

function encodePass() {
	var password=$('#Pswd').val();
	alert("password::"+password);
	var encodedPassword=btoa(password);
	alert("encodedPassword::"+encodedPassword);
	$("#Pswd").val(encodedPassword);
}

$("#conPswd").on("change", encodeConPswd);

function encodeConPswd() {
	var conPassword=$('#conPswd').val();
	alert("conPassword::"+conPassword);
	var encodedConPassword=btoa(conPassword);
	alert("encodedConPassword::"+encodedConPassword);
	$("#conPswd").val(encodedConPassword);
}
									   
 */							 
	  
										
	
	 
	 
	
	
 


$("input#Pswd").blur(function () {
        $("#Pswd_strength_wrap").fadeOut(400);
});
/* 
$("#orgPanNumber").on("change", encodePan);

function encodePan() {
	var panNumber=$('#orgPanNumber').val();
	alert("panNumber::"+panNumber);
	var encodedPanNumber=btoa(panNumber);
	alert("encodedPanNumber::"+encodedPanNumber);
	$("#orgPanNumber").val(encodedPanNumber);
}
	 
 */



/* 
//$("#addressProofId").on("change", addressProofFile);

function addressProofFile() {
	//getSignatureChecksum($(this).attr('id'));
	var filename = "addressProof";
	var docId = "";
	if($('#strDocId').val() == "-1")
		docId=0;
	else
		docId = $('#strDocId').val();
	//fileupload(filename);
	//data.append('hppGeneratedData',hppGeneratedData);
	//var haaPy=hppGeneratedData;
	//alert("haap"+haaPy);
	  $.ajax({
	  /*   url: "addressProofFile/"+filename+"/"+docId+"/"+haaPy, */
	    /* url: "addressProofFile/"+filename+"/"+docId,
	    type: "POST",
	    data: new FormData($("#frm")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function (response) {
		    
	    	var Obj_List = response; */ 
	  	  /*  alert("obj info "+Obj_List[0].eNSuccessFlag);
	  	   alert("obj info "+Obj_List[0].successFlag);
	  	   alert("obj info "+Obj_List[0].fileName); */
	  	  /*  var eNSuccessFlag = Obj_List[0].eNSuccessFlag;
	  	 	  var SuccessFlag = Obj_List[0].successFlag;
	  	 	  var FileName = Obj_List[0].fileName; */
	  	 	 /*  alert(FileName); */
	  		 

	  	
	  			/* if (SuccessFlag == 0 || SuccessFlag == 1){
	  		   	error_message("Please upload only PDF files");
	  		   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		  $("#addressProofId").val('');
	  		   	}
	  		   	if (SuccessFlag== 2){
	  		   	error_message("File size should be more than 0 and less than 10 MB  ");
	  		   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		  $("#addressProofId").val('');

	  		   	} 
	  		   	if (SuccessFlag == 3){
	  		   	error_message("There was some error in uploading the file. Please try again.");
	  		   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		  $("#addressProofId").val('');
	  		   	}
	  		 	if (SuccessFlag == 4){
	  		        error_message("PDF is Corrupted. Please try again.");
	  			   	$('#numDocId').closest('.form-group').addClass('has-error');
	  			  $("#addressProofId").val('');
	  		       	}
	  		 	if (SuccessFlag == 6){
	  		        error_message("Illegal Content !!!!");
	  			   	$('#numDocId').closest('.form-group').addClass('has-error');
	  			  $("#addressProofId").val('');
	  		       	}
	  		   	if (SuccessFlag >=5){
	  		   		/* alert("File Uploaded Successfully");	 */	  		
	  		   		/* $('#numDocId').closest('.form-group').removeClass('has-error').addClass('has-success');
	  		   	 	$('#strDocId').val(eNSuccessFlag);
	  		   	    $('#numDocId').val(5); */ 
	  		   	/* 	$('#fileuploadName').text(FileName); */
	  		  /*  		$('#fileuploadRemove').show();
	  	       		$('#fileupload').hide();
	  	       */ 		//alert("eNSuccessFlag---   "+eNSuccessFlag);
	  	      /*  		$('#fileuploadDownloadLink').attr('href','${pageContext.request.contextPath}/downloadTmpFile_Secure/'+eNSuccessFlag);
	  	       		$('#fileuploadDownloadLink').text('Download('+FileName+')'); */
	  	       		//$('#submit1').removeAttr('disabled');

	  	       		/* $('#progress1fileupload').show();
	  	       		setTimeout(
	  	       			  function() 
	  	       			  {
	  	       				$('#progress1fileupload').hide();
	  	    	       		$('#progress2fileupload').show();
	  	       			  }, 500);
	  	       		
	  	       		setTimeout(
	  	       			  function() 
	  	       			  {
	  	       				$('#progress2fileupload').hide();
	  	    	       		$('#progress3fileupload').show();
	  	       			  }, 1000); */
	  		   		//	 $('#fileupload').attr('disabled','disabled');	
	  		    	//}

		      
	  //  },
	  //  error: function () {
	      // Handle upload error
	      // ...
	   // }
	 // });
	//}

/* 
$("#drugLicence").on("change", drugLicence);

function drugLicence() {

	var filename = "DrugLicenseProof";
	var docId = "";
	if($('#strDrugDocId').val() == "-1")
		docId=0;
	else
		docId = $('#strDrugDocId').val();
	//alert("heloo")
	  $.ajax({
	    url: "drugLicence/"+filename+"/"+docId,
	    type: "POST",
	    data: new FormData($("#frm")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function (response) {
		    
	    	var Obj_List = response; */
	  	  /*  alert("obj info "+Obj_List[0].eNSuccessFlag);
	  	   alert("obj info "+Obj_List[0].successFlag);
	  	   alert("obj info "+Obj_List[0].fileName); */
	  	   /* var eNSuccessFlag = Obj_List[0].eNSuccessFlag;
	  	  var SuccessFlag = Obj_List[0].successFlag;
	  	 	  var FileName = Obj_List[0].fileName; */
	  	 	 /*  alert(FileName); */
	  		 

	  	/* 
	  			if (SuccessFlag == 0 || SuccessFlag == 1){
	  		   	error_message("Please upload only PDF files");
	  		   	$('#numDrugDocId').closest('.form-group').addClass('has-error');
	  		  $("#drugLicence").val('');
	  		  
	  		   	}
	  		   	if (SuccessFlag== 2){
	  		   	error_message("File size should be more than 0 and less than 10 MB  ");
	  		   	$('#numDrugDocId').closest('.form-group').addClass('has-error');
	  		  $("#drugLicence").val('');
	  		   return "";
	  		   	} 
	  		   	if (SuccessFlag == 3){
	  		   	error_message("There was some error in uploading the file. Please try again.");
	  		   	$('#numDrugDocId').closest('.form-group').addClass('has-error');
	  		 	 $("#drugLicence").val('');
	  		   	}
	  		 	if (SuccessFlag == 4){
	  		        error_message("PDF is Corrupted. Please try again.");
	  			   	$('#numDrugDocId').closest('.form-group').addClass('has-error');
	  			  $("#drugLicence").val('');
	  		       	}
	  		   	if (SuccessFlag >=5){ */
	  		   		/* alert("File Uploaded Successfully");	 */	  		
	  		   		/* $('#numDrugDocId').closest('.form-group').removeClass('has-error').addClass('has-success');
	  		   	 	$('#strDrugDocId').val(eNSuccessFlag);
	  		   	    $('#numDrugDocId').val(5); */
	  		   	/* 	$('#fileuploadName').text(FileName); */
	  		   		/* $('#fileuploadRemove').show();
	  	       		$('#fileupload').hide(); */
	  	       		//alert("eNSuccessFlag---   "+eNSuccessFlag);
	  	       	/* 	$('#fileuploadDownloadLink').attr('href','${pageContext.request.contextPath}/downloadTmpFile_Secure/'+eNSuccessFlag);
	  	       		$('#fileuploadDownloadLink').text('Download('+FileName+')'); */
	  	       		//$('#submit1').removeAttr('disabled');

	  	       		/* $('#progress1fileupload').show();
	  	       		setTimeout(
	  	       			  function() 
	  	       			  {
	  	       				$('#progress1fileupload').hide();
	  	    	       		$('#progress2fileupload').show();
	  	       			  }, 500);
	  	       		
	  	       		setTimeout(
	  	       			  function() 
	  	       			  {
	  	       				$('#progress2fileupload').hide();
	  	    	       		$('#progress3fileupload').show();
	  	       			  }, 1000); */
	  		   		//	 $('#fileupload').attr('disabled','disabled');	
	  		    	/* }

		      
	    },
	    error: function () { */
	 
	      // Handle upload error
	      // ...
	  //  }
	  //});
	//}		




</script>
													

	
	 
	<!-- <script type="text/javascript" src="js/validation/customValidation.js"></script>
	<script type="text/javascript" src="js/Registration/registration.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
	<script type="text/javascript" src="js/globalJs/globalJs.js"></script> -->
																				   
	

	
	<!-- Script to add table row -->
    <script> 
        let lineNo = 2; 
        $(document).ready(function () { 
            $(".add-row").click(function () { 
            	 //alert(${councilList}.length);
            	let couoncilTypeData=${appTypeJson};
            	let aa='';
            	for(let l = 0; l < couoncilTypeData.length; l++) {
            		aa=aa+'<option value='+couoncilTypeData[l].id+'>'+couoncilTypeData[l].councilName+'</option>';
				}
            	var opt = '<select class=form-control name=promotionCouncil id=promotionCouncil_'+lineNo+'><option value=0>--Select Export Promotion Councils/Associations--</option>'+aa+'</select>';
            	
            	 var markup = '<tr><td>'+opt+
            	 '</td><td><input type=text name=registrationNumber id=registrationNumber_'+lineNo+' onchange=ValidateString(this) class=form-control></td>'+
            	 '<td><input  type=date name=validityDuration id=validityDate_'+lineNo+' class=form-control placeholder=Validity Date/></td></tr>';
                 $("table tbody").append(markup);
                lineNo++; 
            	
            }); 
            
            $(".remove-row").click(function () { 
            	if(lineNo>2){
            		$("table tr:last").remove();
                	lineNo--;
                }
           });  






			  
        });  




		  
    </script> 
		
			  
							  
	<script>
		$(function(){
			var dtToday = new Date();

			var month = dtToday.getMonth() + 1;
			var day = dtToday.getDate();
			var year = dtToday.getFullYear();
			if(month < 10)
				month = '0' + month.toString();
			if(day < 10)
				day = '0' + day.toString();

			var minDate= year + '-' + month + '-' + day;

			$('#iecIssueDate').attr('max', minDate);
		});
		</script>	
		<script>
	$(function(){
	    var dtToday = new Date();

	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();

	    var minDate= year + '-' + month + '-' + day;

	    $('#ssiIssueDate').attr('max', minDate);
	});
	</script>
										
								 
									  
				   
<script>


 $("#orgWebsite").on("keyup", function() {
    if (this.checkValidity()) {
        // The url is valid
    } else {
    	//The url is invalid
    }
});  
</script>									
	<script>
function filechecksum() {
	//alert("Inside File Upload");
		var reader = new FileReader();
	reader.onload = readSuccess;
	console.log("ReadData=== "+ readSuccess);
     //alert("Reader value"+ reader.onload);
	fileToRead = $("[type='file']")[0].files
	fileToRead = fileToRead[0]
	/* somecheck=$('#addressProofId').val(); */
//	filehashing(somecheck);
	//alert(somecheck);
	//console.log('Going to Read:')
	//alert("File to read value: "+ fileToRead);
	//console.log(fileToRead)
	//alert("Data in file"+fileToRead);
	//alert("Reader value  "+ reader);
	
	readData = reader.readAsDataURL(fileToRead);
	};
	 function readSuccess(evt) {
		
		//alert('12121dd');
		var tempData = evt.target.result;
		var b64d = tempData.split(',')[1];
		b64d.replace(/[\r\n]/g, '');
		var inputCode = getInputCode(b64d);
		//console.log(inputCode);
		var origHPPCode = "file123#$";
		hppGeneratedData = getHPPCode(origHPPCode, inputCode % 1000);
		$('#hppGeneratedData').val(hppGeneratedData);
		//data.append('hppGeneratedData',hppGeneratedData);
		//alert(hppGeneratedData)
		somecheck=$('#addressProofId').val().toString();
		//var path=somecheck.toString();
		//alert('path::'+somecheck);
		var altpath=somecheck+hppGeneratedData;
		//alert("altpath::::::"+altpath);
		 var r1=btoa(altpath);
		// alert("r1::::"+r1);
		 var r2=reverseString(r1);
		 var r3=btoa(r2);
		 $('#hashValue').val(r3);
		return hppGeneratedData
	};

	function getInputCode(input) {
		
		var output = 0;

		for (var i = 0; i < input.length; i++) {
			var c = input.charCodeAt(i) + i;
			output += c;
		}
		return output;
	}

	function getHPPCode(hppCode, inputCode) {
		

		var n = parseInt(inputCode);

		for (var i = 0; i < n; i++) {
			hppCode = encode(hppCode, 3);
		}
		return hppCode;
	}

	function encode(input, key) {
		
		var output = "";

		for (var i = 0; i < input.length; i++) {
			var c = input.charCodeAt(i);

			if (c >= 65 && c <= 90) {
				output += String.fromCharCode((c - 65 + key) % 26 + 65);
			} else if (c >= 97 && c <= 122) {
				output += String.fromCharCode((c - 97 + key) % 26 + 97);
			} else {
				output += input.charAt(i); // Copy
			}
		}
		return output;
	}
	</script>			 
									
<script>
function filechecksumm() {
	//alert("Inside File Upload");
		var reader = new FileReader();
	reader.onload = readSuccess1;
	console.log("ReadData=== "+ readSuccess1);
     //alert("Reader value"+ reader.onload);
	fileToRead = $("[type='file']")[0].files
	fileToRead = fileToRead[0]
	/* somecheck=$('#addressProofId').val(); */
//	filehashing(somecheck);
	//alert(somecheck);
	//console.log('Going to Read:')
	//alert("File to read value: "+ fileToRead);
	//console.log(fileToRead)
	//alert("Data in file"+fileToRead);
	//alert("Reader value  "+ reader);
	
	readData = reader.readAsDataURL(fileToRead);
	};
	 function readSuccess1(evt) {
		
		//alert('12121dd');
		var tempData = evt.target.result;
		var b64d = tempData.split(',')[1];
		b64d.replace(/[\r\n]/g, '');
		var inputCode = getInputCode(b64d);
		//console.log(inputCode);
		var origHPPCode = "file123#$";
		hppGeneratedData = getHPPCodee(origHPPCode, inputCode % 1000);
		$('#hppGeneratedData2').val(hppGeneratedData);
		//data.append('hppGeneratedData',hppGeneratedData);
		//alert(hppGeneratedData)
		somecheck=$('#drugLicence').val().toString();
		//var path=somecheck.toString();
		//alert('path::'+somecheck);
		var altpath=somecheck+hppGeneratedData;
		//alert("altpath::::::"+altpath);
		 var r1=btoa(altpath);
		 var r2=reverseString(r1);
		 var r3=btoa(r2);
		 $('#hashValue2').val(r3);
		return hppGeneratedData
	};

	function getInputCode(input) {
		
		var output = 0;

		for (var i = 0; i < input.length; i++) {
			var c = input.charCodeAt(i) + i;
			output += c;
		}
		return output;
	}

	function getHPPCodee(hppCode, inputCode) {
		

		var n = parseInt(inputCode);

		for (var i = 0; i < n; i++) {
			hppCode = encode(hppCode, 3);
		}
		return hppCode;
	}

	function encode(input, key) {
		
		var output = "";

		for (var i = 0; i < input.length; i++) {
			var c = input.charCodeAt(i);

			if (c >= 65 && c <= 90) {
				output += String.fromCharCode((c - 65 + key) % 26 + 65);
			} else if (c >= 97 && c <= 122) {
				output += String.fromCharCode((c - 97 + key) % 26 + 97);
			} else {
				output += input.charAt(i); // Copy
			}
		}
		return output;
	}
	function reverseString(str) {
		//alert ('Hello');
	    var newString = "";
	    for (var i = str.length - 1; i >= 0; i--) {
	        newString += str[i];
	    }
	    return newString;
	}
	</script>
												 

				<script>
				/* GI - Start - 01  // Add this function id="registrationNumber_${lineNo}" onchange="ValidateString(this)" */
function ValidateString(input) {
          var regExp = /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/;
          if (!regExp.test(input.value)) {
            alert("Invalid input in Promotion Council's/Association's registration number. Only numbers and characters are allowed.");
            input.value = "";
          }
          if (input.value.length < 5 || input.value.length > 15) {
        	    alert("The registration number must be between 5 and 15 characters.");
        	    input.value = "";
          }
        }
</script>

    
		   
</body>
</html>