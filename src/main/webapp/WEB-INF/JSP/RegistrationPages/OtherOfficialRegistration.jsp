<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>


<script>
$(document).ready(function(){

	
});

</script>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Officials</title>

    <style type="text/css">
      .alert-box {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
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
    </style>
  </head>
  <body>
    <section class="reg_note" id="skiptomaincontent">
      <div class="container">
      	<div class="page-title text-center">
	      <h1 class="fw-bold position-relative">Official Registration </h1>
	    </div>

        <div class="alert alert-warning bg-white " role="alert">
          <div class="float-left">
            <h4 class="fw-bold">Welcome to iVEDA portal!</h4>
              <br>
              <p>Integrated Validation of Export of Drugs from India and its Authentication (iVEDA), a project of the Ministry of Commerce & Industry developed by PHARMEXCIL with technical support from CDAC for facilitating the implementation of Track and Trace for Pharmaceutical products, instituted by the Commerce Ministry.</p>
              <p>PHARMEXCIL has been entrusted with the responsibility of developing the Web Portal through CDAC. PHARMEXCIL and CDAC conducted series of meetings and analyzed all the issues, suggestions and recommendations of the industry and has developed this portal.</p>
              <p>iVEDA is a well-refined and built-in system, replacing the DAVA portal. This is a simplified system for authentication of drug packages exported from India- Tertiary/ Secondary. The objective of the proposed application is to develop a user-friendly system and also to facilitate the Manufacturers (MA) and the Merchant Exporters (ME) upload the tertiary and secondary level barcoding data with ease.</p>
              <p>
                <b>Registration</b> for Integrated Validation of Exports of Drugs from India and its Authentication.
              </p>
              <p>As a Regulatory Official, you are requested to create your account (registration), which is mandatory on behalf of your Regulatory Agency.</p>
              <p>After that you can start availing the online services provided under this iVEDA portal.</p>
              <p>We, Pharmaceuticals Export Promotion Council of India (PHARMEXCIL) . </p>
              <p><b>THANKS YOU</b></p>
            
          </div>
        </div>
      </div>

    <div class="content-wrapper">
        <div class="container reg_contain">
          <div class="scroll-top-wrapper ">
            <span class="scroll-top-inner">
              <i class="fa fa-2x "></i>
            </span>
          </div>
          <div class="col-md-12">
            <form:form method="post" action="${pageContext.request.contextPath}/officialRegistration" id="frm" name="frm" modelAttribute="regForm">
              <div class="panel panel-default " id="personDetails">
                <div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
                  <b>Create your iVEDA Account... Continue to access the iVEDA portal</b>
                </div>
                <div class="panel-body dvfrm-panel-body">
                  <div class="row">
                    <div class="col-md-4 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="userName">Username/E-mail (Only Official E-mail Id): <span style="color:#cd2026;">*</span>
	                        <span class="iconStyle"></span>
	                      </label>
	                      <form:input path="userName" type="text" class="form-control" id="userName" placeholder="Enter Regulatory Email Id" required="required" onchange="checkUserExist(this)" />
	                    </div>
                    </div><!--end col2-->

                    <div class="col-md-4 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="Pswd">Password: <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:input path="password" type="password" class="form-control" name="" id="Pswd" placeholder="Enter Password" autocomplete="off" onchange="" required="required" />
	                      <div class="col-md-10" id="Pswd_strength_wrap" style="display: none;">
	                        <div id="passwordDescription">Password not entered</div>
	                        <div id="passwordStrength" class="strength0"></div>
	                        <div id="pswd_info">
	                          <strong>Strong Password Tips:</strong>
	                          <ul>
	                            <li class="invalid" id="length">At least 8 characters</li>
	                            <li class="invalid" id="pnum">At least one number</li>
	                            <li class="invalid" id="capital">At least one lowercase &amp; one uppercase letter</li>
	                            <li class="invalid" id="spchar">At least one special character ( ! @ # $ % ^ & * ( ) _ - )</li>
	                          </ul>
	                        </div>
	                      </div>
	                      <small class="newsout"></small>
	                    </div>
                    </div><!--end col2-->

                    <div class="col-md-4 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="conPswd">Confirm Password: <span style="color:#cd2026;">*</span>
	                      </label>
	                      <input type="password" class="form-control" autocomplete="off" name="conPswd" id="conPswd" placeholder="Confirm Password" onchange="checkBothPasswords(this.value)" required="required" />
	                      <small class="newsout"></small>
	                    </div>
                    </div><!--end col3-->

                  </div><!--end row-->
                </div><!--end panel body-->
              </div><!--end panel-->

              <div class="panel panel-default " id="">
                <div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
                  <b>Regulatory Agency Details</b>
                </div>
                <div class="panel-body dvfrm-panel-body">
                  <div class="row">
                    <div class="col-md-4 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="applicantType">Official Type <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:select class="form-control m-input" name="" id="applicantType" path="applicantType" selectcheck="true">
	                        <option value="201">Regulatory Authority</option>
	                      </form:select>
	                    </div>
                    </div>
                    <div class="col-md-4 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="locName">Regulatory Agency Name <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:input type="text" path="locationName" class="form-control m-input" id="locName" placeholder="Enter Location Name" />
	                    </div>
                    </div>
                    <div class="col-md-4 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="locShortName">Regulatory Agency Short Name</label>
	                      <form:input type="text" path="locationShortName" class="form-control m-input" id="locShortName" placeholder="Enter Name" />
	                    </div>
                    </div>
                  </div><!--end row-->
                </div><!--end panel body-->
              </div><!--end panel-->



              <div class="panel panel-default " id="">
                <div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
                  <b>Regulatory Authority Location Details</b>
                </div>
                <div class="panel-body dvfrm-panel-body">
                  <div class="row">
                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="locAdd">Address <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:textarea type="text" path="locationAddress" class="form-control m-input" id="locAdd" placeholder="Enter Regulatory Authority Full Address" />
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="orgCountryId">Country <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:select class="form-control m-input" id="orgCountryId" path="orgCountryId" selectcheck="true" onchange="selectState(this.value)">
	                        <option value="0">Select</option>
	                        <option value="193">India</option>
	                      </form:select>
	                    </div>
                    </div>
                  </div>

                  <div class="row">

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="locZoneId">Zone <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:select class="form-control m-input" name="loc_zone" id="locZoneId" path="locZoneId" selectcheck="true">
	                        <option value="0">Select</option>
	                        <c:forEach var="zoneMst" items="${zoneMst}">
	                          <option value="${zoneMst.zoneId}">${zoneMst.zoneName}</option>
	                        </c:forEach>
	                      </form:select>
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="orgStateId">State <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:select class="form-control m-input" name="" id="orgStateId" path="orgStateId" selectcheck="true" onchange="selectDistrict(this.value)">
	                        <option value="0">Select</option>
	                      </form:select>
	                    </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="orgDistId">District <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:select class="form-control m-input" id="orgDistId" path="orgDistId">
	                        <option value="0">Select</option>
	                      </form:select>
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="orgFaxNumber">Fax Number</label>
	                      <form:input type="number" path="orgFaxNumber" class="form-control m-input" id="orgFaxNumber" placeholder="Fax Number"/>
	                    </div>
                    </div>

                  </div>

                  <div class="row">
                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="orgPincode">Pin Code <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:input type="number" path="orgPincode" class="form-control m-input" id="orgPincode" placeholder="Pin Code" autocomplete="off" />
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="locContactNumber">Contact Number <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:input type="number" path="locContactNumber" class="form-control m-input" id="locContactNumber" placeholder="Enter Contact Number" autocomplete="off" />
	                    </div>
                    </div>
                   </div>

                   <div class="row">
                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="locEmailId">Email Id <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:input type="email" path="locEmailId" class="form-control m-input" id="locEmailId" placeholder="Enter email Id" autocomplete="off" />
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="locWebsiteLink">Website <span style="color:#cd2026;">*</span>
	                      </label>
	                      <form:input type="text" path="locWebsiteLink" class="form-control m-input" id="locWebsiteLink" placeholder="Enter Link" autocomplete="off" />
	                    </div>
                    </div>
                  </div>

                </div><!--end panel body-->
              </div><!--end panel-->



              <div class="panel panel-default " id="">
                <div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
                  <b>Contact Person Details</b>
                </div>
                <div class="panel-body dvfrm-panel-body">
                  <div class="row">
                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="empName">Officer Name: <span style="color:#cd2026;">*</span>
	                        <span class="iconStyle"></span>
	                      </label>
	                      <form:input type="text" class="form-control m-input" path="empName" placeholder="Enter Officer's Full Name" id="empName" autocomplete="off"></form:input>
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="empNo">Officer Id No.: <span style="color:#cd2026;">*</span>
	                        <span class="iconStyle"></span>
	                      </label>
	                      <form:input path="empNo" type="text" class="form-control" id="empNo" placeholder="Enter Officer's Id No." />
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="empEmailId">Officer Email Id: <span class="iconStyle"></span>
	                      </label>
	                      <form:input path="empEmailId" type="email" class="form-control" id="empEmailId" placeholder="Enter Email Id" />
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="empDesg">Officer Designation: <span style="color:#cd2026;">*</span>
	                        <span class="iconStyle"></span>
	                      </label>
	                      <form:input path="empDesg" type="text" class="form-control" id="empDesg" placeholder="Enter Officer Designation" />
	                    </div>
                    </div>

                    <div class="col-md-6 col-sm-12 col">
	                    <div class="form-group">
	                      <label class="dvfrm-label" for="orgContactNumber">Officer Mobile Number: <span style="color:#cd2026;">*</span>
	                        <span class="iconStyle"></span>
	                      </label>
	                      <form:input path="orgContactNumber" type="number" class="form-control" id="orgContactNumber" placeholder="Enter Officer Mobile Number" />
	                    </div>
                    </div>

                    <div class="col-md-12 col">
                    	<div class="form-group">
			                <label>
			                  <form:checkbox path="" value="" id="agreementCheckBox" aria-label="Agreement CheckBox"/>
			                  <span class="pad-left">I agree to the <a id="TermsView" target="_blank" href="${pageContext.request.contextPath}/download/ivedaTermsAndConditions.pdf"> terms, conditions and privacy policy </a>
			                    <span style="color:#cd2026;"></span>
			                  </span> laid down by pharmaceutical Export Promotion Council of India for availing the online services provided under this portal. <span style="color:#cd2026;">*</span>
			                </label>
		              	</div>
		             </div>
                  </div><!--end row-->
                </div><!--end panel body-->
              </div><!--end panel-->

              
              <div class="text-center">
                <button type="submit" class="custom-btn position-relative" id="saveOne"> Submit </button>
                <button type="reset" class="custom-btn position-relative">Reset</button>
              </div>
            </form:form>
          </div>
        </div>
    </div>
    </section>
    <script type="text/javascript" src="js/Registration/officialRegistration.js"></script>
  </body>
</html>