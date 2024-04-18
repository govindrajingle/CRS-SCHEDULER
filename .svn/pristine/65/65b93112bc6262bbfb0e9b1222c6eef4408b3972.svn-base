<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%>
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>Registration Pending</title>
<!-- 
<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> -->
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<script>
	var token_key = "NMD_TOKEN_KEY";
	var createFHash = function(frmName) {
		//alert("createFHash same");
		datastring = $("form[name='" + frmName + "']").serializeArray()
		var tokenval = getHexaCode(datastring);

		//alert ( "datastring" + datastring )
		//alert("token==="+tokenval);

		$('<input>').attr({
			type : 'hidden',
			id : token_key,
			name : token_key,
			value : tokenval
		}).appendTo('form');

	};

	var getHexaCode = function(datastring) {

		datastring.sort(function(a, b) {
			var a1 = a.name.toLowerCase(), b1 = b.name.toLowerCase();
			if (a1 == b1)
				return 0;

			return a1 > b1 ? 1 : -1;
		});

		//alert(datastring);
		console.log(datastring);

		var myInput = "";
		var datalength = 0;
		$.each(datastring, function(index, val) {

			if (val.name != token_key) {

				////alert( index + ": " + val.name +" ="+val.value+"=");

				var newVal = val.value;

				if (newVal != '') {

					newVal = newVal.replace(/ /gi, "_");
					newVal = newVal.replace(/\n|\r\n|\r/g, '_');
					myInput = myInput + "" + newVal;
					datalength = datalength + 1;
				}

			}

		});

		//console.log("str :: "+myInput);
		//alert(myInput);
		return hex_md5(myInput);

		//return myInput;

	};

	var submitForm = function() {

		////alert("inside submitForm");

		document.forms[0].submit();

	};

	var getQueryParameters = function(str) {
		str = str.split('?')[1];

		var outputArray = new Array();

		var strVals = str.split("&");

		for (var i = 0; i < strVals.length; i++) {

			var newVals = strVals[i].split("=");

			var obj = {
				name : "" + newVals[0],
				value : "" + newVals[1]
			};

			outputArray[i] = obj;

		}

		return outputArray;

	};
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//alert("in location");

						$('#frm')
								.bootstrapValidator(
										{
											message : 'This value is not valid',
											feedbackIcons : {
												valid : 'fa fa-check',
												invalid : 'fa fa-remove',
												validating : 'fa fa-refresh'
											},
											fields : {
												strReason : {
													validators : {
														notEmpty : {
															message : 'Reason is required and can\'t be empty'
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
														},

														stringLength : {
															min : 1,
															max : 250,
															message : 'Reason can contain minimum 1 and maximum of 250 characters'
														}
													}
												}
											}
										});

						$('#modalfrm2')
								.bootstrapValidator(
										{
											message : 'This value is not valid',
											feedbackIcons : {
												valid : 'fa fa-check',
												invalid : 'fa fa-remove',
												validating : 'fa fa-refresh'
											},
											fields : {
												strReason : {
													validators : {
														notEmpty : {
															message : 'Reason is required and can\'t be empty'
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
														},

														stringLength : {
															min : 1,
															max : 250,
															message : 'Reason can contain minimum 1 and maximum of 250 characters'
														}
													}
												}
											}
										});

						loadDataTable(1);

						if ('${flagUpdateApp}' == 1) {
							ok_message("User is approved succesfully");
						}

						if ('${flagUpdateReject}' == 1) {
							ok_message("User is rejected succesfully");
						}

						if ('${dataViolation}' == 1) {
							error_message("Data Validation failled");
						}

						if ('${errors}' == 2) {
							error_message("Please try again after 1 hour");
						}

						if ('${errors}' == 3) {
							error_message("Your email verification limit has been exceeded, Kindly contact admin for any queries");
						}

						if ('${errors}' == 4) {
							error_message("Invalid request");
						}

						if ('${ResendLink}' == 1) {
							ok_message("Verification link Re-send Successfully.");
						}

						$('#saveReason')
								.click(
										function() {
											var bV = $("#frm").data(
													'bootstrapValidator');
											bV.validate();
											if (bV.isValid()) {
												confirm_alert(
														'Do you Really want to Approve?',
														'approve');
											} else {
											}
										});

						$('#saveReasonReject')
								.click(
										function() {
											var bV = $("#modalfrm2").data(
													'bootstrapValidator');
											bV.validate();
											if (bV.isValid()) {
												confirm_alert(
														'Do you Really want to Reject?',
														'reject');
											} else {
											}
										});

						$('#sendLink')
								.click(
										function() {
											//createFHash("frm");
											//added by harshita

											let username = $(
													'#userNameVerifyLink')
													.val();

											//alert("hello" + username);
											var base = btoa(username);
											//alert("hello" + base);
											var reverseval = reverseString(base);
											//alert("hello" + reverseval);
											var base2 = btoa(reverseval);
											//alert("hello" + base2);
											$('#userNameVerifyLink').val(base2);
											//createFHash("frm");
											confirm_alert(
													'Do you Really want to Re-send Link?',
													'resend');

										});

						$('#returnRegis')
								.click(
										function() {
											confirm_alert(
													'Do you Really want to Return the Registration?',
													'returnregistration');
										});
					});
</script>

<script>
	function initTable(id, x_size, y_size, statusID) {
		var Table = $(id)
				.DataTable(
						{

							columns : [

							{
								"sTitle" : "",
								"mData" : "user_id",
								"bVisible" : false
							},

							{
								"sTitle" : "Registration Date",
								"mData" : "createddate"
							},

							{
								"sTitle" : "User Name",
								"mData" : "user_name"
							}, {
								"sTitle" : "Applicant Type",
								"mData" : "str_appl_type_name"
							}, {
								"sTitle" : "Organisation Type",
								"mData" : "org_type",
								"bVisible" : false
							}, {
								"sTitle" : "Organisation Name",
								"mData" : "org_name"
							}, {
								"sTitle" : "Organisation Address",
								"mData" : "org_address"
							}, {
								"sTitle" : "Phone Number",
								"mData" : "org_contact_number"
							}, {
								"sTitle" : "Country",
								"mData" : "country"
							}, {
								"sTitle" : "State",
								"mData" : "str_state_name"
							}, {
								"sTitle" : "District",
								"mData" : "str_district_name"
							}, {
								"sTitle" : "E-mail Address",
								"mData" : "org_email_id"
							}, {
								"sTitle" : "Organisation FAX",
								"mData" : "org_fax_number"
							},
							/* {
								"sTitle" : "Organisation PAN Number",
								"mData" : "org_pan_number"
							}, */
							{
								"sTitle" : "Pincode",
								"mData" : "org_pincode"
							}, {
								"sTitle" : "Website",
								"mData" : "org_website"
							}, {
								"sTitle" : "RCMC Number",
								"mData" : "str_rcmc_no"
							},

							{
								"sTitle" : "Download",
								"mData" : "",

							}, {
								"sTitle" : "Action",
								"mData" : "",
								"responsivePriority" : "1",
								"sWidth" : "8%"
							}, {
								"sTitle" : "",
								"mData" : "num_email_status",
								"bVisible" : false
							}

							],
							responsive : !0,
							order : [],
							columnDefs : [

									{
										"targets" : [ 3, 4, 5, 7, 8, 9, 10, 11,
												14, 15 ],
										"className" : "none",

									},

									{
										'targets' : 16,
										'searchable' : true,
										'orderable' : true,
										'className' : 'dt-body-top',
										'render' : function(data, type, row) {

											if (row.applicant_type == 100) {
												var a = "";
												row.str_appl_type_name = "Merchant Manufacturer";
												a = '<a href="#" onclick="xmlFunction(\''
														+ row.address_proof_id
														+ '\');">1.Address Proof</a> ';
												//${pageContext.request.contextPath}/uploadXmlPage/
												return a;
											} else {

												var a = "";
												row.str_appl_type_name = "Merchant Exporter";
												a = '<a href="#" onclick="xmlFunction(\''
														+ row.address_proof_id
														+ '\');">1.Address Proof</a>  <a href="#" onclick="xmlFunction(\''
														+ row.drug_license_id
														+ '\');">2.Drug License</a>';
												//${pageContext.request.contextPath}/uploadXmlPage/
												return a;

											}
										}
									},

									{
										"targets" : 17,
										"render" : function(data, type, row) {

											if (row.num_email_status == 1) {
												var c = "";

												c = '<div class="btn-group dropleft"><button class="btn_default dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" aria-label="Dropdown Buttton"><i class="fa fa-angle-down"><span class="sr-only"></span></i></button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton">';
												c = c
														+ ""
														+ '<a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForFirstChat" onclick="editUserRegistrationApprove(\''
														+ row.user_id
														+ '\',\''
														+ row.user_name
														+ '\',\''
														+ row.str_appl_type_name
														+ '\',\''
														+ row.org_name
														+ '\',\''
														+ row.org_address
														+ '\');">Approve</a><a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForViewDtls" onclick="editUserRegistrationReject(\''
														+ row.user_id
														+ '\',\''
														+ row.user_name
														+ '\',\''
														+ row.str_appl_type_name
														+ '\',\''
														+ row.org_name
														+ '\',\''
														+ row.org_address
														+ '\');"">Reject</a></div></div>';
												return c;
											} else {
												var c = "";

												c = '<div class="btn-group dropleft"><button class="btn_default dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  aria-label="Dropdown Buttton"><i class="fa fa-angle-down"><span class="sr-only"></span></i></button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton">';
												c = c
														+ ""
														+ '<a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForVericationPending" onclick="verificationPending(\''
														+ row.user_id
														+ '\',\''
														+ row.user_name
														+ '\',\''
														+ row.str_appl_type_name
														+ '\',\''
														+ row.org_name
														+ '\',\''
														+ row.org_address
														+ '\');">Email verification pending</a></div></div>';
												return c;
											}

										}
									} ],
							destroy : true
						});
		return Table;
	}
	function accept(id) {
		//alert("accpt  - "+id)
	}

	function resetAndDrawTable(dataTableId, data, statusID) {
		var sizeWidth, sizeHeight;
		sizeWidth = "100%";
		sizeHeight = "100%";
		var table = initTable(dataTableId, sizeWidth, sizeHeight, statusID);

		table.clear().draw();
		table.rows.add(data); // Add new data
		table.columns.adjust().draw();
	}
	function loadDataTable(statusID) {
		//alert("load data table");
		$.ajax({
			type : "GET",
			data : {
				status : statusID
			},
			url : "getRegistrationPendingListing",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1", JSONObject.aaData, statusID);// Redraw the DataTable
			}
		});
	}

	function editUserRegistrationApprove(userId, userName, applicantType,
			orgName, orgAddress) {
		//alert("userId     "+userId);UserName applicant orgName orgAdd
		//alert("user name     "+userName);
		$("#userId").val(userId);
		$("#userName").val(userName);

		$("#UserId").val(userId);
		$("#UserName").val(userName);

		$("#UserNameView").text(userName);
		$('#applicant').text(applicantType);
		$('#orgName').text(orgName);
		$('#orgAdd').text(orgAddress);

		showModal('#modelForFirstChat');

		//confirm_alert('Do you Really want to Approve?','approve');
	}

	function verificationPending(userId, userName, applicantType, orgName,
			orgAddress) {
		//alert("userId     "+userId);
		//alert("user name     "+userName);
		$("#userIdVerifyLink").val(userId);
		$("#userNameVerifyLink").val(userName);

		$("#UserNameVer").text(userName);
		$('#applicantVer').text(applicantType);
		$('#orgNameVer').text(orgName);
		$('#orgAddVer').text(orgAddress);

		showModal('#modelForVericationPending');

		//confirm_alert('Do you Really want to Approve?','approve');
	}

	function editUserRegistrationReject(userId, userName, applicantType,
			orgName, orgAddress) {
		//alert("userId     "+userId);      	
		//alert("user name     "+userName);
		$("#userId").val(userId);
		$("#userName").val(userName);

		$("#UserIdReject").val(userId);
		$("#UserNameReject").val(userName);

		$("#UserNameViewReject").text(userName);
		$('#applicantReject').text(applicantType);
		$('#orgNameReject').text(orgName);
		$('#orgAddReject').text(orgAddress);

		showModal('#modelForViewDtls');
		//confirm_alert('Do you Really want to Reject?','reject');
	}

	function confirm_alert(msg, type) {
		var m = msg.split('.');
		var msg1 = m[0];
		msg2 = m[1];
		swal({
			title : "Are you sure?",
			text : msg1,
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#34A534",
			confirmButtonText : "OK",
			cancelButtonText : "Cancel",
			closeOnConfirm : true,
			closeOnCancel : true
		}, function(isConfirm) {
			if (isConfirm) {
				if (type == "approve") {
					editUserRegApp();
				} else if (type == "reject") {
					editUserRegReject();
				} else if (type == "resend") {

					createFHash("modelVerify");
					resendVerification();
				} else if (type == "returnregistration") {
					returnRegisteredUser();
				} else if (type == "ok") {
				}
			} else {

				imp = false;
			}
		});

	}

	function checkData(objOne) {

		var reg = /^[a-zA-Z0-9().\/,\s\-]+$/;
		let obj = objOne.value;
		let id = "#" + objOne.id;
		if (!reg.test(obj)) {
			//alert("Special Characters not allowed");
			$(id).val("");
		}
	}

	function editUserRegApp() {
		
		//alert("hello");
		document.getElementById("frm").action = "${pageContext.request.contextPath}/updateUserRegForApproval";
		document.getElementById("frm").method = "POST";

		//added by harshita on 140723
		let username = $('#UserName').val();
		let reason = $('#strReason').val();
		let token = $('#token').val();

		var base = window.btoa(username + ' ### ' + reason + ' ### ' + token);
		// alert( "basee" + base);

		var reverseval = reverseString(base);
		// alert ("reverseval" + reverseval);

		var base2 = window.btoa(reverseval);
		//   alert ("base 2" + base2);

		$('#strReason').val(base2);

		$("#frm").submit();
	}

	function editUserRegReject() {
		document.getElementById("modalfrm2").action = "${pageContext.request.contextPath}/updateUserRegForRejection";
		document.getElementById("modalfrm2").method = "POST";

		//added by harshita on 140723
		let username = $('#UserNameReject').val();
		let reason = $('#strReason2').val();
		let token = $('#token').val();

		var base = window.btoa(username + ' ### ' + reason + ' ### ' + token);
		// alert( "basee" + base);

		var reverseval = reverseString(base);
		// alert ("reverseval" + reverseval);

		var base2 = window.btoa(reverseval);
		//   alert ("base 2" + base2);

		$('#strReason2').val(base2);

		document.getElementById("modalfrm2").submit();
	}

	function showModal(event) {
		//alert("in show modal");
		$(event).modal({
			backdrop : 'static',
			keyboard : false,
			show : true

		});
	}

	function resendVerification() {
		document.getElementById("modelVerify").action = "${pageContext.request.contextPath}/resendVerificationLink";
		document.getElementById("modelVerify").method = "POST";
		document.getElementById("modelVerify").submit();
	}

	function returnRegisteredUser() {
		document.getElementById("modelVerify").action = "${pageContext.request.contextPath}/returnRegistrationOfUser";
		document.getElementById("modelVerify").method = "POST";
		document.getElementById("modelVerify").submit();
	}
</script>


<div class="content-wrapper mt-0 pt-0">
	<div class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Registration Pending</h1>
		</div>
		<!--begin::Portlet-->
		<div
			class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile"
			id="main_portlet">
			<div class="m-portlet__head"
				style="background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
			</div>



			<form:form id="frm1" name="frm1" modelAttribute="registrationForm"
				method="POST"
				cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed">
				<form:input type="hidden" id="ENdoc_id" path="ENdoc_id" />
				<form:input type="hidden" id="fileType" path="fileType" />
				<div class="bg_white">
					<table
						class="w-100 table table-striped table-bordered dt-responsive nowrap dspit"
						id="m_table_1" style="width: 100%;">
						<thead class="theadTransacColor">
							<tr>

							</tr>
						</thead>

					</table>
			</form:form>

		</div>
		<!--end::Portlet-->




		<!-- --------------------------------------------- Model for Approval of registration ----------------------------------------------- -->

		<div class="modal modallg fade seminor-login-modal"
			data-backdrop="static" id="modelForFirstChat"
			data-easein="slideDownBigIn">
			<div class="modal-dialog modal-dialog-centered modal_wd">
				<div class="modal-content">
					<form:form class="seminor-login-form" method="post"
						modelAttribute="registrationForm" id="frm" name="frm">
						<div class="modal-header theadTransacColor">
							<h3 class="modal-title">Registration Pending for Approval</h3>
							<button type="button" class="close" data-bs-dismiss="modal"
								aria-label="modal Close button">
								<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
							</button>
						</div>
						<form:hidden path="userId" id="UserId" aria-label="User ID"></form:hidden>
						<form:hidden path="userName" id="UserName" aria-label="User Name"></form:hidden>

						<!-- added by harshita 140723 -->
						<form:hidden path="token" id="token" />


						<div class="modal-body">

							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">User
											Name:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="UserNameView"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Applicant
											Type:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="applicant"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Organization
											Name:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="orgName"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Organization
											Address:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="orgAdd" class="dvfrm-label"></span>
									</div>
								</div>


								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Reason:-<span
											style="color: red;">*</span></label>
									</div>
									<div class="col-md-6">
										<form:textarea path="strReason"
											cssClass="form-control m-input" id="strReason"
											placeholder="Reason" onkeyup="checkData(this)"
											aria-label="Reason" />
									</div>

								</div>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" id="saveReason"
								class="custom-btn position-relative" value="forward">
								Submit</button>
							<button type="button" class="btn_default" data-bs-dismiss="modal">Close
							</button>

						</div>
					</form:form>
				</div>



			</div>
		</div>

		<!-- ------------------------------------------------------------------------------------------------------------------------------ -->

		<!-- --------------------------------------------- Model for rejection of registration ----------------------------------------------- -->


		<div class="modal modallg fade seminor-login-modal"
			data-backdrop="static" id="modelForViewDtls"
			data-easein="slideDownBigIn">
			<div class="modal-dialog modal-dialog-centered modal_wd">
				<div class="modal-content">
					<form:form class="seminor-login-form" method="post"
						modelAttribute="registrationForm" id="modalfrm2" name="modalfrm2">
						<div class="modal-header theadTransacColor">
							<h3 class="modal-title">Registration Pending for Rejection</h3>
							<button type="button" class="close" data-bs-dismiss="modal"
								aria-label="modal Close button">
								<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
							</button>
						</div>
						<form:hidden path="userId" id="UserIdReject"
							aria-label="User Id Reject"></form:hidden>
						<form:hidden path="userName" id="UserNameReject"
							aria-label="User Name Reject"></form:hidden>
						<!-- added by harshita 140723 -->
						<form:hidden path="token" id="token" />
						<div class="modal-body">
							<div class="panel-body">

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">User
											Name:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="UserNameViewReject"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Applicant
											Type:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="applicantReject"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Organization
											Name:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="orgNameReject"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Organization
											Address:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="orgAddReject"
											class="dvfrm-label"></span>
									</div>
								</div>


								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Reason:-<span
											style="color: red;">*</span></label>
									</div>
									<div class="col-md-6">
										<form:textarea path="strReason"
											cssClass="form-control m-input" id="strReason2"
											placeholder="Reason" onkeyup="checkData(this)"
											aria-label="Reason" />
									</div>
								</div>
							</div>

						</div>

						<div class="modal-footer">
							<button type="button" id="saveReasonReject"
								class="custom-btn position-relative" value="forward">

								Submit</button>
							<button type="button" class="btn_default" data-bs-dismiss="modal">
								Close</button>

						</div>
					</form:form>

				</div>
			</div>
		</div>
		<!-- ------------------------------------------------------------------------------------------------------------------------------ -->

		<!-- --------------------------------------------- Model for Verification List Pending ----------------------------------------------- -->


		<div class="modal modallg fade seminor-login-modal"
			data-backdrop="static" id="modelForVericationPending"
			data-easein="slideDownBigIn">
			<div class="modal-dialog modal-dialog-centered modal_wd">
				<div class="modal-content">


					<form:form class="seminor-login-form" method="post"
						modelAttribute="registrationForm" id="modelVerify"
						name="modelVerify">
						<div class="modal-header theadTransacColor">
							<h3 class="modal-title">Registration Email verification
								pending</h3>
							<button type="button" class="close" data-bs-dismiss="modal"
								aria-label="modal Close button">
								<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
							</button>
						</div>
						<form:hidden path="userId" id="userIdVerifyLink"
							aria-label="user IdVerify Link"></form:hidden>
						<form:hidden path="userName" id="userNameVerifyLink"
							aria-label="user Name Verify Link2"></form:hidden>
						<div class="modal-body">

							<div class="panel-body">

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">User
											Name:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="UserNameVer"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Applicant
											Type:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="applicantVer"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Organization
											Name:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="orgNameVer"
											class="dvfrm-label"></span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<label for="example-text-input" class="dvfrm-label">Organization
											Address:-</label>
									</div>
									<div class="col-md-6">
										<span for="example-text-input" id="orgAddVer"
											class="dvfrm-label"></span>
									</div>
								</div>


								<%-- <div class="row">
							
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Reason:-<span style="color:red;">*</span></label></div>
								<div class="col-md-6"><form:textarea path="strReason" cssClass="form-control m-input" id="strReason" placeholder="Reason" onkeyup="checkData(this)"/></div>
									
							</div>							  
						</div> --%>

							</div>
						</div>
						<div class="modal-footer">
							<button type="button" id="returnRegis"
								class="custom-btn position-relative" value="forward">
								Return</button>
							<button type="button" id="sendLink"
								class="btn_default btn-success" value="forward">
								Re-send Verification link</button>
							<button type="button" class="btn_default" data-bs-dismiss="modal">
								Close</button>

						</div>
					</form:form>
				</div>
			</div>
		</div>


	</div>
</div>

<script>
	//added by harshita
	function reverseString(str) {
		//alert ('Hello');
		var newString = "";
		for (var i = str.length - 1; i >= 0; i--) {
			newString += str[i];
		}
		return newString;
	}
</script>

<!-- Google tag (gtag.js) -->
<script async
	src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'G-RRHHYLSBGG');
</script>




<script>
	function xmlFunction(docId) {//${pageContext.request.contextPath}/downloadTmpFile_Secure/'+row.num_document_id
		//alert(docId);
		//var enFid = DataEncoder.encode(docId);
		//var enFid =  window.btoa(docId);
		//added by harshita 18-08-23
		var enFid1 = btoa(docId);
		//alert("enFid1" + enFid1)
		var reverseval = reverseString(enFid1);
		//alert("reverseval" + reverseval)
		var enFid = btoa(reverseval);
		//alert("enFid" + enFid)

		//alert(enFid);
		var fileType = 3;

		document.getElementById("frm1").action = "${pageContext.request.contextPath}/downloadTmpFile_Secure";
		$("#ENdoc_id").val(enFid);
		$("#fileType").val(fileType);

		document.getElementById("frm1").method = "POST";

		document.getElementById("frm1").submit();

	}
</script>
