<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>.

<title>Official Registration</title>
<script type="text/javascript" src="js/Registration/officialRegistration.js"></script>


<!-- <script type="text/javascript" src="js/validation/customValidation.js"></script>
	<script type="text/javascript" src="js/Registration/registration.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
	<script type="text/javascript" src="js/globalJs/globalJs.js"></script> -->

<script>
	$(document)
			.ready(
					function() {
						//alert("on load");

						$("#frm")
								.bootstrapValidator(
										{
											fields : {
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
												Pswd : {
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
												strName : {
													validators : {
														notEmpty : {
															message : 'Name is required and cannot be empty'
														},
														stringLength : {
															max : 50,
															message : 'Name can contain maximum of 50 characters'
														},
														regexp : {
															regexp : /^[a-zA-Z\s]+$/,
															message : 'The Name can only consist of alphabets'
														}

													}
												},
												empDesg : {
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
												},

												empNo : {
													validators : {
														notEmpty : {
															message : "Employee Number is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 1,
															max : 20,
															message : "Employee Number can contain maximum of 20 characters"
														}
													}
												},
												empGender : {
													validators : {
														callback : {
															message : 'Please specify Gender',
															callback : function(
																	value,
																	validator,
																	$field) {

																var options = validator
																		.getFieldElements(
																				'empGender')
																		.val();

																return (options != 0);
															}
														}
													}
												},
												empMobileNo : {
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

						$("input#Pswd")
								.on(
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

											$("#Pswd_strength_wrap")
													.fadeIn(400);

											// password length
											if (a.length >= 8) {
												$("#length").removeClass(
														"invalid").addClass(
														"valid");
												score++;
											} else {
												$("#length").removeClass(
														"valid").addClass(
														"invalid");
											}

											// at least 1 digit in password
											if (a.match(/\d/)) {
												$("#pnum").removeClass(
														"invalid").addClass(
														"valid");
												score++;
											} else {
												$("#pnum").removeClass("valid")
														.addClass("invalid");
											}

											// at least 1 capital & lower letter in password
											if (a.match(/[A-Z]/)
													&& a.match(/[a-z]/)) {
												$("#capital").removeClass(
														"invalid").addClass(
														"valid");
												score++;
											} else {
												$("#capital").removeClass(
														"valid").addClass(
														"invalid");
											}

											// at least 1 special character in password {
											if (a
													.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/)) {
												$("#spchar").removeClass(
														"invalid").addClass(
														"valid");
												score++;
											} else {
												$("#spchar").removeClass(
														"valid").addClass(
														"invalid");
											}

											if (a.length > 0) {
												//show strength text
												$("#passwordDescription").text(
														desc[score]);
												// show indicator
												$("#passwordStrength")
														.removeClass()
														.addClass(
																"strength"
																		+ score);
											} else {
												$("#passwordDescription").text(
														"Password not entered");
												$("#passwordStrength")
														.removeClass()
														.addClass(
																"strength"
																		+ score);
											}
										});

						$("input#Pswd").blur(function() {
							$("#Pswd_strength_wrap").fadeOut(400);
						});

						$('#save').click(
								function() {
									//alert("in save");
									
									var bV = $("#frm").data('bootstrapValidator');
									
									bV.validate();
									
									if (bV.isValid()) {

										//alert("after valid");
										
										confirm_alert('Do you Really want to save?','save');

									} else {
									}

								});

						if ('${flagSave}' == 1) {
							ok_message("New Record Added Successfully.");

						}
						if ('${flagSave}' == 2) {
							ok_message("Entered user name already present , Please register with different user name");

						}

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


function reverseString(str) {
	//alert ('Hello');
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    return newString;
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

				if (type == "save") {

				//alert("in confirm");
				//alert("confirm pwd::"+$('#conPswd').val());
				
				//alert("pwd:::"+$('#Pswd').val())
				
				if($('#conPswd').val()=="" &&  $('#Pswd').val()==""){
					
					
					alert("Password can not be blank");
					
					return false;
		
		}
					
					$('#conPswd').val('');
					let Pswd = $('#Pswd').val();
					var Message = $('#Pswd').val();
					

				
					
					//var hashcheck =  CryptoJS.SHA256(Message);
					var randomNumber = Math.ceil(Math.random() * 10000);
					var base = window.btoa(randomNumber + ' ### ' + Message
							+ ' ### ' + Math.ceil(Math.random() * 10000));

					//alert(base);
					var reverseval=reverseString(base);
					//alert("reverseval:::"+reverseval);

					 var base2 = window.btoa(reverseval);
					// alert ("base2:::" + base2);

					 
					 $('#Pswd').val(base2);
					// alert ("base2:::" + base2);

				
					submit_form();
				} else if (type == "delete") {
					flag = true;
					submit_form_delete();
				} else if (type == "modify") {
					submit_form_update();
				} else if (type == "ok") {
					flag = true;
					submit_form_delete();
				}
			}

			else {
				imp = false;
			}
		});
	}

	function submit_form() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/saveOfficialReg";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}
</script>

	<div class="content-wrapper mt-0 pt-0">
		<section class="regdv content content-tiles">
			<div class="page-title">
				<h1 class="fw-bold">New official Registration</h1>
			</div>

			<form:form method="post" id="frm" name="frm" modelAttribute="offRegistration" autocomplete="off">
				<sec:csrfInput />
					<div class="panel panel-default " id="lic">
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="userType">User Type<span style="color: #cd2026;">*</span></label>
										<form:select class="form-control m-input" name="userType"
											id="userType" path="userType" selectcheck="true">
											<option value="0">Select</option>
											<c:forEach items="${instType}" var="c">
												<option value='${c.numInstTypeId}'>
													${c.strInstTypeName}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="userName">Username/E-mail
											(Only Official E-mail Id):<span style="color: #cd2026;">*</span>
										</label>
										<form:input path="userName" type="text" class="form-control"
											id="userName" placeholder="Enter Corporate Email Id"
											required="required" onchange="checkUserExist(this)" />
									</div>
								</div>
							</div>


								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="Pswd">Password:<span
												style="color: #cd2026;">*</span>
											</label>

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
											<!-- NO NEED TO ADD THIS <small class="newsout">Only Best Passwords are
												accepted</small> -->
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="conPswd">Confirm
												Password:<span style="color: #cd2026;">*</span>
											</label> 
											<input type="password" class="form-control"
												autocomplete="off" name="conPswd" id="conPswd"
												placeholder="Confirm Password"
												onchange="checkBothPasswords(this.value)" required="required" />
												<!-- NO NEED TO ADD THIS <small class="newsout">Only Best Passwords are
												accepted</small> -->
												
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="strName">Employee Name:<span
												style="color: #cd2026;">*</span></label>
											<%-- <div class="col-md-2">
										<form:select path="" class="form-control" id="manuUnit" required="required">
											<option value="Mr.">Mr.</option>
											<option value="Ms.">Ms.</option>
											<option value="Dr.">Dr.</option>
											<option value="Mrs.">Mrs.</option>
										</form:select>	
										</div> --%>
											<form:input type="text" class="form-control m-input"
												path="strName" placeholder="Full Name" id="strName"
												autocomplete="off"></form:input>
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="empNo">Employee No.:<span
												style="color: #cd2026;">*</span></label>
											<form:input path="empNo" type="text" class="form-control"
												id="empNo" placeholder="Enter Employee No." />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="empEmailId">Email Id:</label>
											<form:input path="empEmailId" type="text" class="form-control"
												id="empEmailId" placeholder="Enter Email Id" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="empGender">Gender:<span
												style="color: #cd2026;">*</span></label>
											<form:select path="" class="form-control" id="empGender">
												<form:option value="0">Select Gender</form:option>
												<form:option value="1">Male</form:option>
												<form:option value="2">Female</form:option>
												
												<!-- Added for future use -->
												<%-- <form:option value="3">Transgender</form:option> --%>
												
											</form:select>
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="empDesg">Designation:<span
												style="color: #cd2026;">*</span></label>
											<form:input path="empDesg" type="text" class="form-control"
												id="empDesg" placeholder="Enter Employee Designation" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="empMobileNo">Contact Number:<span
												style="color: #cd2026;">*</span></label>
											<form:input path="empMobileNo" type="number"
												class="form-control" id="empMobileNo"
												placeholder="Enter Employee Number" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="location">Location :<span
												style="color: #cd2026;">*</span></label>
											<form:select path="location" class="form-control"
												id="location">
												<form:option value="0">Select Location</form:option>
												<c:forEach items="${loc}" var="c">
													<option value='${c.numlocationId}'>${c.loc_name} -
														${c.loc_add}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>

									<%-- <div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
									<label class="dvfrm-label" for="">Login Role:<span style="color:#cd2026;">*</span></label>
									<form:select path="empRole" class="form-control" id="empRole" required="required">
										<form:option value="0">Select Role</form:option>
										<c:forEach items="${role}" var="c">
											<option value='${c.numRoleId}'> ${c.strRoleName}</option>
										</c:forEach>
									</form:select>	
									</div>
								</div> --%>

								</div>
							</div>
						</div>





						<div class="text-center">
							<button type="button" class="custom-btn position-relative" id="save">
								Save</button>
							<button type="reset" class="btn_default" id="reset" onclick= "resetSelect2()">
								Reset</button>
						</div>
					</form:form>
		</section>

	</div>
	
	<script>

	function resetSelect2(){

		location.reload(true);

		
	}
	</script>
