<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<div class="content-wrapper mt-0 pt-0">
		<section class="regdv content content-tiles">
			<div class="page-title">
				<h1 class="fw-bold">User Profile</h1>
			</div>

				<div class="p-0">
					<form:form method="post" id="frm" name="frm" modelAttribute="registrationForm" action="${pageContext.request.contextPath}/updateProfile" enctype="multipart/form-data" autocomplete="off">
						<%-- <sec:csrfInput /> --%>

						<div class="panel panel-default " id="manuUser">
							<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>MANUFACTURERS PROFILE</b>
							</div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label">User Name: <span >${UserName}</span></label>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="panel panel-default " id="expUser">
							<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>Pharmexcil Official's Profile</b>
							</div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label">User Name: <span >${UserName}</span></label>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="panel panel-default " id="organizationDetails">
							<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>Corporate Address Details</b>
							</div>
							<div class="panel-body dvfrm-panel-body row">
								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=applicantType>Applicant Type:<span style="color:#cd2026;">*</span><span
											class="iconStyle"></span>
										</label>
										<%-- <label>${numUserTypeName}</label> --%>
										<c:choose>
											<c:when test="${registrationForm.applicantType=='100'}">
												<form:select path="applicantType" id="applicantType"
													class="form-control">
													<form:option value="100">Manufacturer</form:option>
												</form:select>
											</c:when>
											<c:when test="${registrationForm.applicantType=='101'}">
												<form:select path="applicantType" id="applicantType"
													class="form-control">
													<form:option value="101">Exporter</form:option>
												</form:select>
											</c:when>
											<c:when test="${registrationForm.applicantType=='200'}">
												<form:select path="applicantType" id="applicantType"
													class="form-control">
													<form:option value="200">Pharmaexcil Officer</form:option>
												</form:select>
											</c:when>
										</c:choose>
									</div>
								</div>

								<form:hidden path="userName" />

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgName>Organization Name:<span style="color:#cd2026;">*</span><span
											class="iconStyle"></span>
										</label>
										<form:input path="orgName" type="text" class="form-control"
											id="orgName" placeholder="Enter Organization name" onchange=""
											required="required" />
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label " for=orgAddress>Address:<span
											 style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="orgAddress" type="text" class="form-control"
											id="orgAddress" placeholder="Enter Address" onchange=""
											required="required"></form:input>
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgStateId>State:<span  style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="orgStateId" class="form-control"
											id="orgStateId" required="required"
											onchange="selectDistrict(this.value)" value="${stateId}">
											<form:option value="0">--select Organization State--</form:option>
											<c:forEach items="${OrgstatesNames }" var="statesDetails">
												<form:option value="${statesDetails.num_state_id}">${statesDetails.str_state_name}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgDistId>District:<span  style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="orgDistId" class="form-control"
											id="orgDistId" required="required">
											<form:option value="0">--select Organization District--</form:option>
											<c:forEach items="${OrgdistrictNames}" var="districtDetails">
												<form:option value="${districtDetails.num_district_id}">${districtDetails.str_district_name}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgPincode>Pin Code:<span  style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="orgPincode" type="text" class="form-control" id="orgPincode" placeholder="Enter Pin code" />
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgCountryId>Country:<span  style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="orgCountryId" class="form-control"
											id="orgCountryId" required="required"
											onchange="selectState(this.value)">
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
										<label class="dvfrm-label" for=orgContactNumber>Contact Number:<span style="color:#cd2026;"></span><span
											class="iconStyle"></span>
										</label>
										<form:input path="orgContactNumber" type="text" class="form-control" id="orgContactNumber" placeholder="Enter Contact Number" maxlength="12" />
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgFaxNumber>Fax
											Number:<span class="orange"></span><span class="iconStyle"></span>
										</label>
										<form:input path="orgFaxNumber" type="text"
											class="form-control" id="orgFaxNumber"
											placeholder="Enter Fax Number" />
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="orgEmailId">Email Id:<span
											 style="color:#cd2026;"></span><span class="iconStyle"></span></label>
										<form:input path="orgEmailId" type="text" class="form-control"
											id="orgEmailId" placeholder="Enter Email Id" onchange="" />
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgWebsite>Website:<span
											class="orange"></span><span class="iconStyle"></span></label>
										<form:input path="orgWebsite" type="url" class="form-control"
											id="orgWebsite" placeholder="Enter Website Link" onchange="" />
									</div>
								</div>

								<div class="col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=orgPanNumber>PAN
											Number:<span style="color:#cd2026;">*</span><span
											class="iconStyle"></span>
										</label>
										<%-- <form:input path="orgPanNumber" type="text" --%>
										<form:input path="orgPanNumber" type="password"
											class="form-control" id="orgPanNumber"
											placeholder="Enter PAN Number" onchange="" maxlength = "10" />
									</div>
								</div>


								<div class="col-lg-6 col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=gstnumber>GSTIN Number:<span
											 style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:input path="gstnumber" type="text" class="form-control"
											id="gstnumber" placeholder="Enter GSTIN Number" onchange=""  maxlength = "15"/>
									</div>
								</div>

								<div class="col-lg-6 col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for=gsOne>GS1 Number:<span
											 style="color:#cd2026;"></span><span class="iconStyle"></span></label>
										<form:input path="gsOne" type="text" class="form-control"
											id="gsOne" placeholder="Enter GS1 Number" onchange="" />
									</div>
								</div>


								<input type="hidden" name="registeredWithRcmc" id="registeredWithRcmc" value="${registeredWithRcmc}">
								<%-- <c:if test="${not registeredWithRcmc}"> --%>

								<div class="col-lg-6 col-md-6 col-sm-12 col" id="otherExportPromotionCouncil">
									<div class="form-group">
										<label class="dvfrm-label" for=memberOfOtherExportPromotionCouncil>Are you the
											member of any other export Promotion Council?<span
											class="orange"></span><span class="iconStyle"></span>
										</label>
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
										<table
											class="table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered dspit"
											id="m_table_1" style="margin-top: 1%; width: 100%;">
											<thead class="theadTransacColor">
												<tr>
													<th>Promotion Council</th>
													<th>Registration No.</th>
													<th>Validity Date</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td><select class="form-control"
														name="promotionCouncil" id="promotionCouncil_1">
															<option value="0">select</option>
															<option value="a">select a</option>
															<option value="b">select b</option>

													</select></td>
													<td><form:input path="registrationNumber" id="registrationNumber_1" class="form-control" onchange="ValidateString(this)" aria-label="registrationNumber_1"></form:input></td>
													<td><form:input path="" type="date" name="validityDuration" id="validityDate_1" class="form-control" placeholder="Validity Date" aria-label="validityDate_1"/></td>
												</tr>
											</tbody>
										</table>

										<input type="button" value="Add Row" class="add-row">
										<input type="button" value="Remove Last Row"
											class="remove-row">
									</div>
								</div>
							</div>
						
						<!-- Contact Person details -->
						<div class="panel panel-default " id="ssiDetails">
							<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>Contact Person Details <sub>Authorized
									Signatory / Responsible person of the organization</sub></b> 
							</div>

							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=contactPersonName>Name:<span
												 style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<form:input path="contactPersonName" type="text"
												class="form-control" id="contactPersonName"
												placeholder="Enter Name" onchange="" required="required" />
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=contactPerDesg>Designation:<span
												 style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<form:input path="contactPerDesg" type="text"
												class="form-control" id="contactPerDesg"
												placeholder="Enter Designation" onchange=""
												required="required" />
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=contPerMobileNo>Mobile
												Number:<span style="color:#cd2026;">*</span><span
												class="iconStyle"></span>
											</label>
											<form:input path="contPerMobileNo" type="text"
												class="form-control" id="contPerMobileNo"
												placeholder="Enter Mobile Number" onchange=""
												required="required" maxlength="12"/>
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=contPersEmail>Email Id:<span
												 style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<form:input path="contPersEmail" type="text"
												class="form-control" id="contPersEmail"
												placeholder="Enter Email Id" onchange="" required="required" />
										</div>
									</div>

								</div>
							</div>
						</div>

						<!-- IEC details -->

						<div class="panel panel-default " id="iecDetails">
							<div
								class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>DGFT IEC Details <sub>Directorate General of Foreign Trade (DGFT) Importer Exporter Code (IEC)</sub></b>
							</div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-4 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=iecNumber>DGFT IEC
												Number:<span style="color:#cd2026;">*</span><span
												class="iconStyle"></span>
											</label>
											<form:input path="iecNumber" type="text" class="form-control"
												id="iecNumber" placeholder="Enter IEC Number"
												onchange="checkIecnumber(this.value)" required="required" />
										</div>
									</div>

									<div class="col-lg-4 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=iecIssueDate>DGFT IEC
												Issue Date:<span style="color:#cd2026;">*</span><span
												class="iconStyle"></span>
											</label>
												<div class='input-group date' id='datetimepicker6'>
													<%-- <form:input path="iecIssueDate" type="text" class="form-control" value="${iecIssueDate}"
											 id="iecIssueDate" placeholder="Enter IEC Issuing Date" required="required"/><span class="input-group-addon"> --%>

													<%-- <input type="text" id="datetimepicker" name="iecIssueDate" class="form-control" value="${iecIssueDate}" placeholder="Enter IEC Issuing Date" required="required"><span class="input-group-addon"> 
	                        <span class="fas fa-calendar"></span> --%>

													<form:input path="" type="date" name="iecIssueDate"
														id="iecIssueDate" class="form-control"
														placeholder="Enter IEC Issuing Date"
														value="${iecIssueDate}" />
													<!-- <span class="input-group-addon"> </span> -->
												</div>
										</div>
									</div>

									<div class="col-lg-4 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=iecIssueAuthority>DGFT
												IEC Issuing Authority:<span style="color:#cd2026;">*</span><span
												class="iconStyle"></span>
											</label>
											<form:input path="iecIssueAuthority" type="text"
												class="form-control" id="iecIssueAuthority"
												placeholder="Enter IEC Issuing Authority" onchange=""
												required="required" />

										</div>
									</div>


								</div>
							</div>

						</div>

						<form:hidden path="numRcmcFlag" value="${numRcmcFlag}" aria-label="Number RCMC Flag"/>
						<form:hidden path="str_rcmc_fieo_no" value="${str_rcmc_fieo_no}" aria-label="STR RCMC No."/>
						<!-- SSI details -->

						<div class="panel panel-default " id="ssiDetails">
							<div
								class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>MSME / IEM Details<sub> (Micro, Small and Medium Enterprises)</sub></b>
							</div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=ssiNumber>MSME / IEM Number:<span
												 style="color:#cd2026;"></span><span class="iconStyle"></span></label>
											<form:input path="ssiNumber" type="text" class="form-control"
												id="ssiNumber" placeholder="Enter MSME / IEM Number" onchange="" />
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
												<div class='input-group date' id='datetimepicker7'>

													<label class="dvfrm-label w-100" for=ssiIssueDate>MSME / IEM Issue
												Date:<span style="color:#cd2026;"></span><span class="iconStyle"></span>
											</label>
													<form:input path="" type="date" name="ssiIssueDate"
														class="form-control" placeholder="Enter MSME / IEM Issuing Date"
														value="${ssiIssueDate}" id="ssiIssueDate"/>
													<!-- <span class="input-group-addon"> </span> -->
												</div>
										</div>
									</div>

								</div>
							</div>
						</div>

						<div class="panel panel-default " id="ssiDetails">
							<div
								class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>ORGANIZATION/COMPANY INCORPORATION CERTIFICATE</b>
							</div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
										<form:hidden path="numDocId" id="numDocId"/>
										<form:hidden path="hppGeneratedData" id="hppGeneratedData"/>
										<form:hidden path="hashValue" id="hashValue"/>
										  <form:hidden path="strDocId" id="strDocId"  value="-1" />	
											<label class="dvfrm-label" for=addressProofId>Upload your
												corporate address proof detail:<span style="color:#cd2026;">*</span><span
												class="iconStyle"></span>
											</label> <input type="file" class="form-control"
												name="addressProofFile" id="addressProofId"
												placeholder="Please upload pdf only" accept="application/pdf"
												onchange="fileValidation(this.id);getSignatureChecksum(this.id);filechecksum(this.id)" />
											<input type="hidden" name="addressProofDocument"
												id="addressProofDocument">
										</div>
									</div>

									<div class="col-lg-6 col-md-6 col-sm-12 col">
										<div class="form-group">
											<c:if test="${addressProof=='present'}">
													<a
														href="${pageContext.request.contextPath}/downloadPdf?fileName=${userId}_addressProof"
														target="_blank"><span>Download Uploaded Address
															Proof</span></a>
												<input type="hidden" id="ap" value="${addressProof}">

											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>

						<c:if test="${registrationForm.applicantType=='101'}">
							<div class="panel panel-default " id="ssiDetails">
								<div
									class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
									<b>Copy of the Drug licence(wholesale licence)</b>
								</div>
								<div class="panel-body dvfrm-panel-body">
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-12 col">
											<div class="form-group">											
									<form:hidden path="numDrugDocId" id="numDrugDocId"/>
									<form:hidden path="hppGeneratedData2" id="hppGeneratedData2"/>
										<form:hidden path="hashValue2" id="hashValue2"/>
				                    <form:hidden path="strDrugDocId" id="strDrugDocId"  value="-1" />
												<label class="dvfrm-label" for=drugLiecenseDocument>Upload your
													Drug licence:<span style="color:#cd2026;">*</span><span
													class="iconStyle"></span>
												</label> <input type="file" class="form-control" name="drugLicence"
													id="drugLicence" placeholder="Please upload pdf only"
													accept="application/pdf"
													onchange="fileValidation(this.id);getdrugChecksum(this.id);filechecksumm(this.id)" />
												<input type="hidden" name="drugLiecenseDocument"
													id="drugLiecenseDocument">
											</div>
										</div>

										<div class="col-lg-6 col-md-6 col-sm-12 col">
											<div class="form-group">
												<c:if test="${drugPdf=='present'}">
														<a
															href="${pageContext.request.contextPath}/downloadPdf?file=${userId}_drug"
															target="_blank">Download Drug License</a>
													<input type="hidden" id="dl" value="${drugPdf}">
												</c:if>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:if>

						<!-- Success message -->
						<div class="alert alert-success" role="alert" id="success_message"
							style="display: none;">
							Success <i class="fas fa-thumbs-up"></i>
						</div>

						<div class="text-center">
							<input type="button" class="position-relative custom-btn" id="infosavebutton"
								value="Update" onclick="validform()" aria-label="Update Button"/>



						</div>
					</form:form>
		</section>
	</div>


	<script type="text/javascript" src="js/validation/customValidation.js"></script>
	<!-- <script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> -->
	<script type="text/javascript" src="js/Registration/updateProfile.js"></script>
	<!-- <script type="text/javascript" src="js/formFieldValidation/md5.js"></script> -->
	<script type="text/javascript" src="js/globalJs/globalJs.js"></script>
	
	<script> 
        let lineNo = 2; 
        $(document).ready(function () { 
            $(".add-row").click(function () { 
            	 var markup = '<tr><td><select class=form-control name=promotionCouncil id=promotionCouncil_'+lineNo+'>'+
            	 '<option value=0>select</option><option value=a>select a</option><option value=b>select b</option></select>'+
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
            
           let updatedResult='${updated}'; 
           let error='${error}';
           if (updatedResult == 'true') {
				ok_message("User Profile Updated Successfuly")
			}
           if(error == 'true'){
        	   error_message("Error in uploading file... Please try again");
           }

           $('#manuUser').hide();
    	   $('#expUser').hide();
           if(${registrationForm.applicantType=='100'}){
        	   $('#manuUser').show();
        	   $('#expUser').hide();
           }else{
        	   $('#manuUser').hide();
        	   $('#expUser').show();
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
	</script>
	
	<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script>
</body>
</html>