function selectState(countryId) {
	$.ajax({
		type: "GET",
		url: "getStateData",
		data: { countryId: 193 },
		success: function(response) {
			if (response.length > 0) {

				for (var userlist in response) {
					$('#orgStateId').append($("<option></option>").attr("value", response[userlist].num_state_id).text(response[userlist].str_state_name));
				}

			}
		}
	});
}



function selectDistrict(stateId) {
	
	$.ajax({
		type: "GET",
		url: "getDistrictData",
		data: { stateId: stateId },
		success: function(response) {
			if (response.length > 0) {
				$('#orgDistId').empty();
				for (var userlist in response) {
					$('#orgDistId').append($("<option></option>").attr("value", response[userlist].num_district_id).text(response[userlist].str_district_name));
				}

			}
		}
	});
}


function selectManfState(countryId) {
	$.ajax({
		type: "GET",
		url: "getStateData",
		data: { countryId: countryId },
		success: function(response) {
			if (response.length > 0) {

				for (var userlist in response) {
					$('#manfStateId').append($("<option></option>").attr("value", response[userlist].num_state_id).text(response[userlist].str_state_name));
				}

			}
		}
	});
}


function selectManfDistrict(stateId) {
	$.ajax({
		type: "GET",
		url: "getDistrictData",
		data: { stateId: stateId },
		success: function(response) {
			if (response.length > 0) {
				for (var userlist in response) {
					$('#manfDistId').append($("<option></option>").attr("value", response[userlist].num_district_id).text(response[userlist].str_district_name));
				}

			}
		}
	});
}


/*function checkBothPasswords(data) {
	let passOne = $('#Pswd').val();
	let passTwo = data;
	if (passOne == null || passOne == '') {
		alert('Please fill the password field first');
		$('#conPswd').val('');
		return false;
	} else if (passOne != passTwo) {
		alert('Both passwords do not match!');
		$('#conPswd').val('');
		return false;
	} else {
		return true;
	}

}*/


function checkBothPasswords(data){
	
	//alert("111");
	let passOne=$('#Pswd').val();
	let passTwo=data;
	if(passOne==null || passOne==''){
		alert('Please fill the password field first');
		$('#conPswd').val('');
		return false;
	}else if(passOne!=passTwo){
		alert('Both passwords do not match!');
		$('#conPswd').val('');		
		$('#Pswd').val('');
		return false;
	}else{
		return true;
	}
	
}



function changeCaptcha() {

	$.ajax({
		type: "GET",
		url: "getCaptcha",
		success: function(data) {
			document.getElementById("loginCaptcha").value = data;

		}

	});
}

function changeRegistrationCaptcha() {
	$.ajax({
		type: "GET",
		url: "getCaptcha",
		success: function(data) {
			document.getElementById("registrationCaptchaOne").innerHTML = data;

		}

	});
}

function checkUserExist(data) {

	let userName = data.value;
	let id = '#' + data.id;
	$.ajax({
		type: "GET",
		url: "getUserNameStatus",
		data: { userName: userName },
		success: function(response) {
			if (response == true) {
				alert('This user name already present , please choose another one');
				$(id).val('');
			}
		}
	});
}


window.onload = function() {
	const myInput = document.getElementById('regCaptcha');
	myInput.onpaste = function(e) {
		e.preventDefault();
	}
}

function getImage() {
	var tCtx = document.getElementById('textCanvas').getContext('2d'),
		imageElem = document.getElementById('image');
	var dd = $("#loginCaptcha").val();
	tCtx.canvas.width = tCtx.measureText(this.value).width;
	tCtx.fillText(dd, 0, 10);
	imageElem.src = tCtx.canvas.toDataURL();
}

$(document).ready(function() {


	$("div.success").fadeIn(300).delay(1500).fadeOut(400);
	$("div.failure").fadeIn(300).delay(1500).fadeOut(400);
	$("div.warning").fadeIn(300).delay(1500).fadeOut(400);

	history.pushState(null, null, location.href);
	window.onpopstate = function() {
		history.go(1);
	};

	$('#Icaptchaa').bind("cut copy paste", function(e) {
		e.preventDefault();
	});

	//new edit
	$(window).keydown(function(event) {
		if (event.keyCode == 13) {
			event.preventDefault();
			return false;
		}
	});


});


$(document).ready(function() {
	$("#frm")
	.bootstrapValidator(
		{
			fields : {
			
				userName : {
					validators : {
						emailAddress: {
	                        message: 'Please enter a valid email address'
	                    },
						notEmpty : {
							message : "User Name is required and can't be empty"
						}
					}
				},
				password : {
					validators : {
						notEmpty : {
							message : "Password is required and can't be empty"
						},
						regexp : {
							regexp : /^(?=.*[A-Z])(?=.*[!@#$%^&*()-_])(?=.*[0-9])(?=.*[a-z]).{8,25}$/,
							message : "Password not in proper format"
						},
						stringLength : {
							min : 8,
							max : 25,
							message : "Password can contain maximum of 25 characters"
		
						}
					}
				},
				orgName : {
					validators : {
						notEmpty : {
							message : "Organization name is required and can't be empty"
						},
regexp: {
    regexp: /^(?!.*\d{2})[a-zA-Z][a-zA-Z0-9().\/,\s\-]*$/,
    message: "Enter valid organization name "
},
						stringLength : {
							min : 5,
							max : 50,
							message : "Organization name can contain minimum 5 and maximum of 50 characters"
		
						}
					}
				},
				orgAddress : {
					validators : {
						notEmpty : {
							message : "Address is required and can\'t be empty"
						},
regexp: {
    regexp: /^(?!.*\d{2})[a-zA-Z][a-zA-Z0-9().\/,\s\-]*$/,
    message: "Enter valid address "
},
						stringLength : {
							min : 5,
							max : 200,
							message : "Address can contain minimum 5 and maximum of 200 characters"
						}
					}
				},
				orgCountryId : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify country',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('orgCountryId').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  },
			  orgDistId : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify district',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('orgDistId').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  orgStateId : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify state',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('orgStateId').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  },
			  orgPincode: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please enter your zip code'
	                    },
	                    regexp : {
							regexp : /^[0-9]+$/,
							message : "Only numbers are allowed"
						},
						stringLength : {
							min : 6,
							max : 6,
							message : "Pincode must be of 6 digits"
		
						}
	                }
	           },
	           orgContactNumber: {
	                validators: {
	                	 notEmpty: {
		                        message: 'Please enter your contact number'
		                },
regexp : {
	regexp : /^[0-9,]{10}(,[0-9]{10}){0,1}$/,
	message : "Add two numbers separated by [comma] "
},
						stringLength : {
							min : 10,
							max : 21,
							message : "Minumum 10 numbers required  "
		
						}
	                }
	            },
	            orgFaxNumber: {
	                validators: {
	                   
	                    regexp : {
							regexp : /^[a-zA-Z0-9().\\/,\\+\\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 4,
							max : 10,
							message : "Fax number can contain minimum 4 and maximum of 10 numbers"
		
						}
	                }
	            },
	            orgEmailId : {
					validators : {
						emailAddress: {
	                        message: 'Please enter a valid email address'
	                    },
						stringLength : {
							min : 5,
							max : 50,
							message : "email id can contain maximum of 50 characters"
		
						}
					}
				}, 
				orgPanNumber : {
						validators : {
							 notEmpty: {
			                        message: 'Please enter your pan number'
			                    },
			                    regexp : {
									regexp : /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/,
									message : "Please enter valid pan number"
								},
								stringLength : {
									min : 10,
									max : 10,
									message : "PAN number can contain 10 characters"
								}
						}
				}, 
				orgWebsite : {
					validators : {
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-\//\:]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 11,
							max : 30,
							message : "Website name can contain maximum of 30 characters"
		
						}
					}
				},
				gstnumber : {
					validators : {
						notEmpty: {
	                        message: 'Please enter your GSTIN number'
	                    },
						regexp : {
							regexp : /\d{2}[A-Z]{5}\d{4}[A-Z]{1}[A-Z\d]{1}[Z]{1}[A-Z\d]{1}/,
							message : "Enter Valid GSTIN Number"
						},
						stringLength : {
							min : 15,
							max : 15,
							message : "GSTIN number can contain only 15 characters"
		
						}
					}
				},
				gsOne : {
					validators : {
						regexp : {
							regexp : /^[a-zA-Z0-9().\\/,\\+\\-]+$/,
							message : "Only alphabet, numbers, special characters ( / , . () - ) are permitted"
						},
						stringLength : {
							min : 3,
							max : 10,
							message : "GS1 number can contain minimum 3 and maximum of 10 characters"
		
						}
					}
				},
				contactPersonName : {
					validators : {
						notEmpty : {
							message : "Contact Person Name is required and can't be empty"
						},
regexp: {
    regexp: /^[a-zA-Z\s]+$/,
    message: "Only alphabets and spaces are permitted"
},
						stringLength : {
							min : 2,
							max : 50,
							message : "Name can contain minimum 2 and maximum of 50 characters"
		
						}
					}
				},
				contPersEmail : {
					validators : {
						notEmpty : {
							message : "Contact Person Email is required and can't be empty"
						},
						emailAddress: {
	                        message: 'Please enter a valid email address'
	                    },
						stringLength : {
							min : 5,
							max : 50,
							message : "Email id can contain maximum of 50 characters"
		
						}
					}
				},
				contactPerDesg : {
					validators : {
						notEmpty : {
							message : "Contact Person's Designation is required and can\'t be empty"
						},
regexp: {
    regexp: /^(?!.*\d{2})[a-zA-Z][a-zA-Z0-9().\/,\s\-]*$/,
    message: "Enter Valid Designation "
},
						stringLength : {
							min : 2,
							max : 50,
							message : "Designation can contain minimum 2 and maximum of 50 characters"
		
						}
					}
				},
				contPerMobileNo: {
		                validators: {
		                	notEmpty : {
								message : "Contact person mobile number is required and can\'t be empty"
							},
		                    regexp : {
								regexp : /^[0-9\-]+$/,
								message : "Please enter valid numbers"
							},
							stringLength : {
								min : 10,
								max : 12,
								message : "Number can must be in between 10 to 12 characters"
							}
		                }
		         },
		         iecNumber: {
		                validators: {
		                	notEmpty : {
								message : "IEC number is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 10,
								max : 10,
								message : "IEC can contain only 10 characters"
							}
		                }
		         },
		         iecIssueDate: {
		                validators: {
		                	notEmpty : {
								message : "IEC Issue Date is required and can\'t be empty"
							}
		                }
		         },
		         iecIssueAuthority: {
		                validators: {
		                	notEmpty : {
								message : "IEC Issuing Authority is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 1,
								max : 50,
								message : "IEC Issuing authority can contain maximum of 50 characters"
							}
		                }
		         },
		         rcmcOfFieo: {
		                validators: {
		                
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 1,
								max : 50,
								message : "RCMC of FIEO can contain maximum of 50 characters"
							}
		                }
		         },
		         ssiNumber: {
		                validators: {
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 5,
								max : 50,
								message : "MSME/ IEM number can contain minimum 5 and maximum of 50 characters"
							}
		                }
		         },
		         ssiType : {
		 				validators : {
		 					callback: {
		 				           message: 'Please specify SSI type',
		 				           callback: function(value, validator, $field) {	
		 				               
		 				               var options = validator.getFieldElements('ssiType').val();

		 				               return (options != 0);
		 
		 				           }
		 					}
		 				}
				  },
				  				  /*
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
													},*/
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
																min : 8,
																max : 25,
																message : 'Password can contain minimum 8 and maximum of 25 characters'
															}
														}
													}
				  
				  
			}
		});
});

function getFieoRcmcNumber(data) {
	if (data == 'yes') {
		//$('#rcmcOfFieo').show();
		$('#otherPromostionCouncilTable').show();
	} else {
		//$('#rcmcOfFieoOne').val('');
		//$('#rcmcOfFieo').hide();
		$('#otherPromostionCouncilTable').hide();
	}
}


function validform() {


	let userName = $('#userName').val();
	if (userName == null || userName == "") {
		alert('please enter username');
		return false;
	}
	let Pswd = $('#Pswd').val();
	if (Pswd == null || Pswd == "") {
		alert('please enter Password');
		return false;
	}
	let conPswd = $('#conPswd').val();
	if (conPswd == null || conPswd == "") {
		alert('please enter Confirm Password');
		return false;
	}
	let orgName = $('#orgName').val();
	if (orgName == null || orgName == "") {
		alert('please enter Organization Name');
		return false;
	}

	let orgAddress = $('#orgAddress').val();
	if (orgAddress == null || orgAddress == "") {
		alert('please enter Organization Address');
		return false;
	}

	let manfCountryId = $('#orgCountryId').val();
	if (manfCountryId == '0') {
		alert('Please select country');
		return false;
	}

	let manfStateId = $('#orgStateId').val();
	if (manfStateId == '0') {
		alert('Please select State');
		return false;
	}

	let manfDistId = $('#orgDistId').val();
	if (manfDistId == '0') {
		alert('Please select District');
		return false;
	}


	let orgPincode = $('#orgPincode').val();
	if (orgPincode == null || orgPincode == "") {
		alert('please enter Organization Pin Code');
		return false;
	}
	let orgPanNumber = $('#orgPanNumber').val();
	if (orgPanNumber == null || orgPanNumber == "") {
		alert('please enter Organization PAN number');
		return false;
	}

	let contactPersonName = $('#contactPersonName').val();
	if (contactPersonName == null || contactPersonName == "") {
		alert('please enter Contact Person Name');
		return false;
	}

	let contactPerDesg = $('#contactPerDesg').val();
	if (contactPerDesg == null || contactPerDesg == "") {
		alert('please enter Contact Person Designation');
		return false;
	}

	let contPerMobileNo = $('#contPerMobileNo').val();
	if (contPerMobileNo == null || contPerMobileNo == "") {
		alert('please enter Contact Person Mobile Number');
		return false;
	}

	let contPersEmail = $('#contPersEmail').val();
	if (contPersEmail == null || contPersEmail == "") {
		alert('please enter Contact Person Email');
		return false;
	}

	let iecNumber = $('#iecNumber').val();
	if (iecNumber == null || iecNumber == "") {
		alert('please enter Contact IEC Number');
		return false;
	}

	let iecIssueDate = $('#iecIssueDate').val();
	if (iecNumber == null || iecIssueDate == "") {
		alert('please enter Contact IEC Issue Date');
		return false;
	}

	let iecIssueAuthority = $('#iecIssueAuthority').val();
	if (iecIssueAuthority == null || iecIssueAuthority == "") {
		alert('please enter Contact IEC Issueing Authority');
		return false;
	}

	let addressProofId = $('#addressProofId').val();
	if (addressProofId == null || addressProofId == "") {
		alert('please Upload Address Proof pdf');
		return false;
	}


    let orgDropdown1 = $('#orgDropdown').val();
   if (orgDropdown1 == '0') {
		alert('please Upload Address proof type');
		return false;
	}

	let registeredWithRcmc = $('#registeredWithRcmc').val();
	//if(registeredWithRcmc=='false'){
	let exportPromoCheck = $('#memberOfOtherExportPromotionCouncil').val();
	let rcmcOfFieo = $('#rcmcOfFieoOne').val();
	if (exportPromoCheck == '0') {
		alert('Please select are you the member of any other export Promotion Council');
		return false;
	}
	if (exportPromoCheck == 'yes') {

		let rowCount = $('#m_table_1 tr').length;
		let actualRowCount = rowCount - 1;
		for (let i = 1; i <= actualRowCount; i++) {
			let promotionCouncil = '#promotionCouncil_' + actualRowCount;
			let registrationNumber = '#registrationNumber_' + actualRowCount;
			let validityDate = '#validityDate_' + actualRowCount;
			let promotionCouncilData = $(promotionCouncil).val();
			let registrationNumberData = $(registrationNumber).val();
			let ValidityDateData = $(validityDate).val();
			if (promotionCouncilData == null || promotionCouncilData == '0') {
				alert('Please enter Promotion Council');
				return false;
			}
			if (registrationNumberData == null || registrationNumberData == '') {
				alert('Please enter Registration No.');
				return false;
			}
			if (ValidityDateData == null || ValidityDateData == '') {
				alert('Please enter Validity Date');
				return false;
			}
		}


		/* if(rcmcOfFieo==null || rcmcOfFieo==''){
			 alert('Please select Registration Number of FIEO/Chemiexcil/CAPEXIL/AIMED/others');
			 return false;
		 }*/
	}
	//}

	let applicantType = $('#applicantType').val();
	if (applicantType == '101') {
		let drugDetails = $('#drugLicence').val();
		if (drugDetails == null || drugDetails == "") {
			alert('please upload Drug licence pdf');
			return false;
		}
	}


	let checkBoxOne = document.getElementById("agreementCheckBox");
	if (checkBoxOne.checked == false) {
		alert("Please Tick aggrement checkbox");
		return false;
	}

	let regCaptcha = $('#regCaptcha').val();
	if (regCaptcha == '') {
		alert('please enter captcha');
		return false;
	}

	var bV = $("#frm").data('bootstrapValidator');
	bV.validate();
	if (bV.isValid()) {
		confirm_alert('You are going to Submit Registration Form .. Do you want to continue?', 'save');
	}
	else {

	}

							  
	
								 
						
}
   

							 
										
 
  
 
function confirm_alert(msg, type) {
	var m = msg.split('.');
	var msg1 = m[0];
	msg2 = m[1];
	swal(
		{
			title: "Are you sure?", text: msg1,
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#34A534",
			confirmButtonText: "OK",
			cancelButtonText: "Cancel",
			closeOnConfirm: true,
			closeOnCancel: true
		},
		function(isConfirm) {
			if (isConfirm) {

				if (type == "save") {

					$("#infosavebutton").attr("disabled", true);
					let userName=$('#userName').val();
					let Pswd=$('#Pswd').val();
					$('#conPswd').val(0);
					var Message=$('#Pswd').val();
					//var hashcheck =  CryptoJS.SHA256(Message);
					var randomNumber=Math.ceil(Math.random() * 10000);
					var base = window.btoa(randomNumber+' ### '+Message+' ### '+Math.ceil(Math.random() * 10000));
					//alert("base:::" + base)
					var reverseval=reverseString(base);
					//alert("reverseval:::"+reverseval);
					var base2 = window.btoa(reverseval);
					//alert ("base2222:::" + base2);
					$('#Pswd').val(base2);

		    		  var un = window.btoa(userName); 
		    		   //alert("un"+ un)
		    			var un1 =reverseString(un);
		    		  // alert("un1"+ un1)
		    			 var un2  = window.btoa(un1);
		    		 // alert("un2"+ un2)
		    			 $('#userName').val(un2);
		    			 
					
				//	var base2 = window.btoa(base);
				//	var base3 = window.btoa(base2);
				//	var base4 = window.btoa(base3);
					//$('#Pswd').val(base4);*/


					var pan1=btoa($('#orgPanNumber').val());
					var pan2=reverseString(pan1);
					$("#orgPanNumber").val(btoa(pan2));				 

					$('#frm').submit();
				}
				else if (type == "delete") {
					flag = true;
					submit_form_delete();
				}
				else if (type == "modify") {
					submit_form_update();
				}
				else if (type == "ok") {
					flag = true;
					submit_form_delete();
				}
			}

			else {
				imp = false;
			}
		});
}

function checkIecnumber(data) {
	$.ajax({
		type: "get",
		url: "checkIecNumber",
		data: { iecNumber: data },
		success: function(response) {
			if (response == 'alreadyPresent') {
				alert("This IEC Number is already registered with some other company");
				$('#iecNumber').val('');
			}
		}
	});
}

function checkGstnNumber(data) {
	$.ajax({
		type: "get",
		url: "checkGstnNumber",
		data: { gstnNumber: data },
		success: function(response) {
			if (response == 'alreadyPresent') {
				alert("This GSTN Number is already registered with some other company");
				$('#gstnumber').val('');
			}
		}
	});
}


function fileValidation(id) {
	var fileInput = document.getElementById(id);
	var filePath = fileInput.value;
	var file = fileInput.files[0];
	var allowedExtensions = /(\.pdf)$/i;
	if(file.size==0)
        {
         alert('File size should be more than 0 and less than 10 MB ');
       // error_message('Please upload file having extensions .pdf only');
        fileInput.value = '';
        return false;
        }
	if (!allowedExtensions.exec(filePath)) {
		alert('Please upload file having extensions .pdf only.');

		fileInput.value = '';
		return false;
	}
	// alert(filePath);
}


function getSignatureChecksum() {

	var form = $('#frm')[0];
	var data = new FormData(form);

	$.ajax({
		type: "POST",
		url: "getSignatureChecksum",
		enctype: 'multipart/form-data',
		data: data,
		cache: false,
		processData: false,
		contentType: false,
		timeout: 600000,
		success: function(response) {
			if (response.length > 0) {

				$('#addressProofDocument').val(response);
			} else {
				alert("Error");
			}
		}
	});
}

function getdrugChecksum() {

	var form = $('#frm')[0];
	var data = new FormData(form);

	$.ajax({
		type: "POST",
		url: "getdrugChecksum",
		enctype: 'multipart/form-data',
		data: data,
		cache: false,
		processData: false,
		contentType: false,
		timeout: 600000,
		success: function(response) {
			if (response.length > 0) {
				$('#drugLiecenseDocument').val(response);
			} else {
				alert("Error");
			}
		}
	});
}
function reverseString(str) {
	//alert ('Hello');
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    return newString;
}
