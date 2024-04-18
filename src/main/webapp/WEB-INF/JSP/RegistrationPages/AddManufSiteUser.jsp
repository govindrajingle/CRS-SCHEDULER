<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

	<script type="text/javascript" src="js/validation/customValidation.js"></script>
	<script type="text/javascript" src="js/Registration/registration.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
	<script type="text/javascript" src="js/globalJs/globalJs.js"></script>
	
	<script>
		$(document)
				.ready(
						function() {				

							$("#modify").hide();
							$("#delete").hide();

							$("#frm")
									.bootstrapValidator(
											{
												fields : {
													manuUnit : {
														validators : {
															callback : {
																message : 'Please specify Manufacturing Unit',
																callback : function(
																		value,
																		validator,
																		$field) {

																	var options = validator
																			.getFieldElements(
																					'manuUnit')
																			.val();

																	return (options != 0);
																}
															}
														}
													},

													userName : {
														validators : {
															notEmpty : {
																message : 'Username is required and can\'t be empty'
															},
															stringLength : {
																max : 50,
																message : 'Username can contain maximum of 50 characters'
															},
															regexp : {
																regexp : '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
																message : 'Please enter a valid email address'
															}
														}

													},
													password : {
														validators : {
															notEmpty : {
																message : 'The password is required and can\'t be empty'
															},
															stringLength : {
																min : 6,
																max : 20,
																message : 'Password can contain minimum 6 and maximum of 20 characters'
															},
															regexp : {
																regexp : /^(?=.*[A-Z])(?=.*[!@#$%^&*()-_])(?=.*[0-9])(?=.*[a-z]).{6,20}$/

															}

														}
													},
													conPswd : {
														validators : {
															notEmpty : {
																message : 'The confirm password is required and can\'t be empty'
															},
															identical : {
																field : 'strPass',
																message : 'The password and its confirm are not the same'
															},
															stringLength : {
																min : 6,
																max : 20,
																message : 'Password can contain minimum 6 and maximum of 20 characters'
															}
														}
													},
/* 													contactPersonName : {
														validators : {
															notEmpty : {
																message : 'First Name is required and cannot be empty'
															},
															stringLength : {
																max : 50,
																message : 'First Name can contain maximum of 50 characters'
															},
															regexp : {
																regexp : /^[a-zA-Z\s]+$/,
																message : 'The First Name can only consist of alphabets'
															}

														}
													},
													contactPerDesg : {
														validators : {
															notEmpty : {
																message : "Designation is required and can\'t be empty"
															},
															regexp : {
																regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
																message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
															},
															stringLength : {
																min : 1,
																max : 20,
																message : "Designation can contain maximum of 20 characters"
															}
														}
													},  */

													contPerMobileNo : {
														validators : {
															notEmpty : {
																message : 'The mobile number is required and cannot be empty'
															},
															stringLength : {
																min : 10,
																max : 10,
																message : 'The mobile number shall consist of 10 digits'
															},
															regexp : {
																regexp : /^(?!0+$)[0-9]{10}$/,
																message : 'Mobile Number can only contain numbers except all zeros'
															}
														}
													} 

												}
											});

							loadDataTable(1);

							$(document)
									.on(
											'click',
											'#radio',
											function(e) {
												$("#save").prop("style").display = "none";
												$("#reset").prop("style").display = "none";
												$("#modify").show();
												$("#delete").show();

												$("#manuUnitFields").hide();
												$("#passFields").hide();
												$("#conPswdFields").hide();

												var selectedval = $(
														'input[name=uid]:checked',
														'#frm').val();
												//alert("selectedval  :" +  selectedval)

												var resultArray1 = $(this)
														.closest('tr')
														.find('td')
														.map(
																function() {
																	return $(
																			this)
																			.text();
																}).get();

												$('#contactPersonName').val(
														resultArray1[1]);
												$('#userName').val(
														resultArray1[2]);
												$('#contactPerDesg').val(
														resultArray1[3]);
												$('#contPerMobileNo').val(
														resultArray1[4]);
												$("#userName").prop("disabled",
														true);
												//$("#Pswd").prop( "disabled", true );
												//$("#conPswd").prop( "disabled", true );

												var ids = mUnitId;
												//alert(ids);
												//alert("resultArray1[5]--- "+resultArray1[5]);
												/* $('#manuUnit').each(function () {
												$('option', this).each(function () {
													if ($.trim($(this).text().toLowerCase()) == $.trim(ids).toLowerCase()) 
													{
														$("#manuUnit").attr("readonly", true);
														$("#manuUnit").prop("disabled", true)
														return false;
													};
												});
												}); */

												/* $('#manuUnit').each(function () {
												$('option', this).each(function () {
													if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[5]).toLowerCase()) 
													{
														$(this).prop('selected', 'selected');
														return false;
													};
												});
												}); */
											});

							//Govind's edit to remove the ERROR OF SUBMITTING FORM AFTER PRESSING ENTERY ON EMPTY FIELD
							$(window).keydown(function(event) {
								if (event.keyCode == 13) {
									event.preventDefault();
									return false;
								}
							});

						});
	</script>

	<script>
		function initTable(id, x_size, y_size, statusID) {
			var Table = $(id)
					.DataTable(
							{

								columns : [ {
									"sTitle" : "",
									"mData" : "user_id"
								},

								{
									"sTitle" : "Name",
									"mData" : "contact_person_name"
								},

								{
									"sTitle" : "User Name",
									"mData" : "user_name"
								},

								{
									"sTitle" : "Designation",
									"mData" : "contact_per_desg"
								},

								{
									"sTitle" : "Mobile No",
									"mData" : "cont_per_mobile_no"
								}, {
									"sTitle" : "Manufacturing Unit",
									"mData" : "premisesname"
								}
								/* ,
								{
									"sTitle" : "",
									"mData" : "num_premises_no"
								} */

								],
								responsive : !0,
								columnDefs : [
										{
											'targets' : 0,
											'searchable' : true,
											'orderable' : true,
											'className' : 'dt-body-top',
											'render' : function(data, type, row) {
												return '<input type="radio" class="radio" name="uid" id ="radio" onclick="manufUnitId(\''
														+ row.num_premises_no
														+ '\');"'
														+ row.user_id
														+ '" value="'
														+ $('<div/>')
																.text(data)
																.html() + '">';

											}
										}, {
											"targets" : [],
											"className" : "none",

										} ],

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
			$
					.ajax({
						type : "GET",
						data : {
							status : statusID
						},
						url : "getManufSiteUserList",
						success : function(response) {
							var JSONObject = JSON.parse(response);
							//alert(JSON.stringify(JSONObject.aaData));
							resetAndDrawTable("#m_table_1", JSONObject.aaData,
									statusID);// Redraw the DataTable
						}
					});
		}

		function checkUserExist(data) {

			let userName = data.value;
			let id = '#' + data.id;
			$
					.ajax({
						type : "GET",
						url : "getUserNameStatus",
						data : {
							userName : userName
						},
						success : function(response) {
							if (response == true) {
								alert('This user name already present , please choose another one');
								$(id).val('');
							}
						}
					});
		}
	</script>

	<div class="content-wrapper mt-0 pt-0">
		<section class="regdv content content-tiles">
			<div class="page-title"><h1 class="fw-bold">Create Sub Logins according to different Manufacturing Sites</h1></div>
				<div class="col-md-12">
					<form:form method="post" id="frm" name="frm" modelAttribute="registrationForm" autocomplete="off">
						<sec:csrfInput />
						<form:hidden path="userManuId" id="userManuId" />
						<!-- Select unit and license -->

						<div class="panel panel-default" id="lic">
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col" id="manuUnitFields">
										<div class="form-group">
											<label class="dvfrm-label" for="manuUnit">Manufacturing Unit: <span style="color:#cd2026;">*</span></label>
											<form:select path="manuUnit" class="form-control"
												id="manuUnit" required="required">
												<form:option value="0">Select Manufacturing Unit</form:option>
												<c:forEach items="${instPreDtls}" var="c">
													<option value='${c.numPremiseNo}'>${c.premiseName}
														- ${c.strAddress} ${c.numPincode}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div><!-- end panel -->

						<div class="panel panel-default " id="addressDetails">
							<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>Manufacturing Site User Details</b>
							</div>

							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-12 col-md-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="userName">Username/E-mail
												(Only Official E-mail Id):<span style="color:#cd2026;">*</span>
											</label>
											<form:input path="userName" type="text" class="form-control"
												id="userName" placeholder="Enter Corporate Email Id"
												required="required" onchange="checkUserExist(this)" />
										</div>
									</div>
								</div><!-- end row -->

								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col" id="passFields">
										<div class="form-group">
											<label class="dvfrm-label" for="Pswd">Password: <span style="color:#cd2026;">*</span> </label>

											<form:input path="password" type="password"
												class="form-control" name="Pswd" id="Pswd"
												placeholder="Enter Password" autocomplete="off" onchange=""
												required="required" />
											<div class="col-md-10" id="Pswd_strength_wrap"
												style="display: none;">
												<div id="passwordDescription">Password not entered</div>
												<div id="passwordStrength" class="strength0"></div>
												<div id="pswd_info">
													<strong>Strong Password Tips:</strong>
													<ul>
														<li class="invalid" id="length">At least 8 characters</li>
														<li class="invalid" id="pnum">At least one number</li>
														<li class="invalid" id="capital">At least one
															lowercase &amp; one uppercase letter</li>
														<li class="invalid" id="spchar">At least one special
															character ( ! @ # $ % ^ & * ( ) _ - )</li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col" id="conPswdFields">
										<div class="form-group">
											<label class="dvfrm-label" for="conPswd">Confirm Password:<span style="color:#cd2026;">*</span> </label> 
											<input type="password" class="form-control"
												autocomplete="off" name="conPswd" id="conPswd"
												placeholder="Confirm Password"
												onchange="checkBothPasswords(this.value)" required="required" />
										</div>
									</div>
								</div><!-- end row -->

								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=contactPersonName>Name:<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
											<form:input path="contactPersonName" type="text"
												class="form-control" id="contactPersonName"
												placeholder="Enter Contact Person Name" onchange=""
												required="required" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for=contactPerDesg>Designation:<span style="color:#cd2026;">*</span></label>
											<form:input path="contactPerDesg" type="text"
												class="form-control" id="contactPerDesg"
												placeholder="Enter Contact Person Designation" onchange=""
												required="required" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="contPerMobileNo">Mobile Number:<span style="color:#cd2026;">*</span>
											</label>
											<form:input path="contPerMobileNo" type="number"
												class="form-control" id="contPerMobileNo"
												placeholder="Enter Contact Person Mobile Number" onchange=""
												required="required"  />
										</div>
									</div>
								</div><!-- end row -->
							</div>
						</div><!-- end panel -->


						<div class="text-center">
							<button type="button" class="custom-btn position-relative" id="save">Save</button>
							<button type="button" id="modify" class="btn_default btn-success">Modify</button>
							<button type="button" id="delete" class="btn_default btn-danger">Delete</button>
							<button type="reset" class="btn_default" id="reset"onClick="test()">Reset</button>
						</div>

						<fieldset class="mt-2 border-0 p-0">
							<div class="section-title"><h2>Manufacturing Site Users List</h2></div>
							<div class="bg_white">
								<table class=" w-100 table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered"
									id="m_table_1">
									<thead class="theadTransacColor">
										<tr>
										</tr>
									</thead>
								</table>
							</div>
						</fieldset>
					</form:form>
				</div>
		</section>

	</div>

	<script type="text/javascript" src="js/Registration/registration.js"></script>

	<script>
		$("input#Pswd").on(
				"focus keyup",
				function() {
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
					if (a.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/)) {
						$("#spchar").removeClass("invalid").addClass("valid");
						score++;
					} else {
						$("#spchar").removeClass("valid").addClass("invalid");
					}

					if (a.length > 0) {
						//show strength text
						$("#passwordDescription").text(desc[score]);
						// show indicator
						$("#passwordStrength").removeClass().addClass(
								"strength" + score);
					} else {
						$("#passwordDescription").text("Password not entered");
						$("#passwordStrength").removeClass().addClass(
								"strength" + score);
					}
				});

		$("input#Pswd").blur(function() {
			$("#Pswd_strength_wrap").fadeOut(400);
		});

		$('#modify').click(function() {
			var selectedval = $('input[name=uid]:checked', '#frm').val();
			//alert(selectedval);

			var checked = [];
			//alert("in mod "+$("#manuUnit").val());
			$('#userManuId').val(selectedval);

			$(".radio:radio").each(function() {
				if (this.checked) {
					checked.push($(this).val());
				}
			});
			$("#radio").val(checked);

			if (checked.length > 0) {
				var bV = $("#frm").data('bootstrapValidator');
				bV.validate();
				if (bV.isValid()) {
					$("#radio").val(checked);
					confirm_alert('Do you Really want to modify?', 'modify');
				} else {
				}

			} else {
			}

		});

		$('#delete').click(function() {
			var selectedval = $('input[name=uid]:checked', '#frm').val();
			var checked = [];
			$('#userManuId').val(selectedval);
			$(".radio:radio").each(function() {
				if (this.checked) {
					checked.push($(this).val());
				}
			});
			$("#radio").val(checked);
			if (checked.length > 0) {
				$("#radio").val(checked);
				confirm_alert('Do you Really want to delete?', 'delete');

			} else {

			}
		});

		/* $('#reset').click(function() {
			alert("inreset");
			$('#frm').data('bootstrapValidator').resetForm();
			clearFeilds();
			$("#modify").hide();
			$("#delete").hide();
			$("#save").show();
		}); */

		$('#save').click(function() {

			var bV = $("#frm").data('bootstrapValidator');
			bV.validate();
			if (bV.isValid()) {
				if ($("#manuUnit").val() != 0) {
					confirm_alert('Do you Really want to save?', 'save');
				} else {
					warning_message("Please select Manufacturing site.");
				}
			} else {
			}

		});

		if ('${flagSave}' == 1) {
			//ok_message("New record added successfully. E-mail verification link is sent to the corporate email id please verify. ");
			ok_message("New record added successfully. You can proceed to Login now. ");
			

		}

		if ('${flagSave}' == 2) {
			ok_message("Entered user name already present , Please user different user name.");

		}

		if ('${flagUpdate}' == 1) {
			ok_message("Record is Updated succesfully.");
		}

		if ('${flagDelete}' == 1) {
			ok_message("Record is deleted succesfully.");
		}

		function test() {
			//alert("in test");
			location.reload(true);
			$("#modify").hide();
			$("#delete").hide();
			$("#save").show();
		/* 	$('#frm')[0].resetForm(); */

		}
		function reverseString(str) {
			//alert ('Hello');
		    var newString = "";
		    for (var i = str.length - 1; i >= 0; i--) {
		        newString += str[i];
		    }
		    return newString;
		}
		/* function clearFeilds() {
			$("#contactPersonName").val("");
			$("#contactPerDesg").val("");
			$("#contPerMobileNo").val("");					
			$("input[name='uid']").prop('checked', false); */

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
			}, 

			function(isConfirm) {
				if (isConfirm) {

					if (type == "save") {
						//alert(type);
						$('#conPswd').val('');
						let Pswd = $('#Pswd').val();
						
						var Message = $('#Pswd').val();
						//var hashcheck =  CryptoJS.SHA256(Message);
						var randomNumber = Math.ceil(Math.random() * 10000);
						var base = window.btoa(randomNumber + ' ### ' + Message
								+ ' ### ' + Math.ceil(Math.random() * 10000));
						
						//alert(base);
						var reverseval=reverseString(base);
					//	alert("reverseval:::"+reverseval);

						 var base2 = window.btoa(reverseval);
						// alert ("base2:::" + base2);

						 
						 $('#Pswd').val(base2);
					//	 alert ("base2:::" + base2);
//for username encoding
                     let username =$('#userName').val();


           		  var un = window.btoa(username); 
           		  // alert("un"+ un)
           			var un1 =reverseString(un);
           		   //alert("un1"+ un1)
           			 var un2  = window.btoa(un1);
           		  // alert("un2"+ un2)
           			 $('#userName').val(un2);

							
						submit_form();
					} else if (type == "delete") {
						flag = true;
						submit_form_delete();
					} else if (type == "modify") {
						submit_form_update();
					} else if (type == "ok") {
						flag = true;
						//submit_form_delete();	
					}
				}

				else {
					imp = false;
				}
			});
		}

		function submit_form() {
			document.getElementById("frm").action = "${pageContext.request.contextPath}/saveManufUserDetail";
			document.getElementById("frm").method = "POST";
			$("#frm").submit();
		}

		function submit_form_update() {
			document.getElementById("frm").action = "${pageContext.request.contextPath}/updateManufUserDetail";
			document.getElementById("frm").method = "POST";
			$("#frm").submit();
		}

		function submit_form_delete() {
			document.getElementById("frm").action = "${pageContext.request.contextPath}/deleteManufUserDetail";
			document.getElementById("frm").method = "POST";
			$("#frm").submit();
		}

		var mUnitId;

		function manufUnitId(manufUnit) {
			//alert(manufUnit);
			mUnitId = manufUnit;
		}
	</script>

</body>

</html> --%>