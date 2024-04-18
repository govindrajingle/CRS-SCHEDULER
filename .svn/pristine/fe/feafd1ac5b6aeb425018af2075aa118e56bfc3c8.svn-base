function selectState(countryId){
			$.ajax({
				type : "GET",
				 url : "getStateData",
				data : {countryId:193},
			 success : function(response){
				 if(response.length>0){
				
					 for(var userlist in response){
						 $('#orgStateId').append($("<option></option>").attr("value",response[userlist].num_state_id).text(response[userlist].str_state_name));
					 }  
					 
				 }
			 }
			});
		}


function selectDistrict(stateId){
	$.ajax({
		type : "GET",
		 url : "getDistrictData",
		data : {stateId:stateId},
	 success : function(response){
		 if(response.length>0){
			 $('#orgDistId').empty();
			 for(var userlist in response){				 
				 $('#orgDistId').append($("<option></option>").attr("value",response[userlist].num_district_id).text(response[userlist].str_district_name));
			 }  
			 
		 }
	 }
	});
}	


function selectManfState(countryId){
	$.ajax({
		type : "GET",
		 url : "getStateData",
		data : {countryId:countryId},
	 success : function(response){
		 if(response.length>0){
		
			 for(var userlist in response){
				 $('#manfStateId').append($("<option></option>").attr("value",response[userlist].num_state_id).text(response[userlist].str_state_name));
			 }  
			 
		 }
	 }
	});
}


function selectManfDistrict(stateId){
	$.ajax({
		type : "GET",
		url : "getDistrictData",
		data : {stateId:stateId},
		success : function(response){
			if(response.length>0){
				for(var userlist in response){
					$('#manfDistId').append($("<option></option>").attr("value",response[userlist].num_district_id).text(response[userlist].str_district_name));
				}  
	 
			}
		}
	});
}


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


function changeCaptcha()
{
	
	$.ajax({
		type:"GET",
		url:"getCaptcha",
		success:function(data){
			document.getElementById("loginCaptcha").value = data;
			
		}
	
	});
}


function changeRegistrationCaptcha(){
	$.ajax({
		type:"GET",
		url:"getCaptcha",
		success:function(data){
			document.getElementById("registrationCaptchaOne").innerHTML = data;
			
		}
	
	});
}

function checkUserExist(data){
	
	let userName=data.value;
	let id='#'+data.id;
	$.ajax({
		type : "GET",
		url  : "getUserNameStatus",
		data : {userName:userName},
	 success : function(response){
		if(response==true){
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
	var dd=$("#loginCaptcha").val();
	tCtx.canvas.width = tCtx.measureText(this.value).width;
	tCtx.fillText(dd, 0, 10);
	imageElem.src = tCtx.canvas.toDataURL();
}

$(document).ready( function() {
	
	
	$( "div.success" ).fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
	 $( "div.failure" ).fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
	 $( "div.warning" ).fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
  
	 history.pushState(null, null, location.href);
	    window.onpopstate = function () {
	        history.go(1);
	    };

	    $('#Icaptchaa').bind("cut copy paste",function(e) {
	        e.preventDefault();
	    });
	    
	    
	    
});





function getFieoRcmcNumber(data){
	if(data=='yes'){
		//$('#rcmcOfFieo').show();
		$('#otherPromostionCouncilTable').show();
	}else{
		//$('#rcmcOfFieoOne').val('');
		//$('#rcmcOfFieo').hide();
		$('#otherPromostionCouncilTable').hide();
	}
}


function validform() {
	
	
	 let userName=$('#userName').val();
	 if(userName==null || userName==""){
		 alert('please enter username');
		 return false;
	 }
	 let Pswd=$('#Pswd').val();
	 if(Pswd==null || Pswd==""){
		 alert('please enter Password');
		 return false;
	 }
	 let conPswd=$('#conPswd').val();
	 if(conPswd==null || conPswd==""){
		 alert('please enter Confirm Password');
		 return false;
	 }
	 let orgName=$('#orgName').val();
	 if(orgName==null || orgName==""){
		 alert('please enter Organization Name');
		 return false;
	 }
	 
	 let orgAddress=$('#orgAddress').val();
	 if(orgAddress==null || orgAddress==""){
		 alert('please enter Organization Address');
		 return false;
	 }

	 let manfCountryId=$('#orgCountryId').val();
	 if(manfCountryId=='0'){
		 alert('Please select country');
		 return false;
	 }
	 
	 let manfStateId=$('#orgStateId').val();
	 if(manfStateId=='0'){
		 alert('Please select State');
		 return false;
	 } 
	 
	 let manfDistId=$('#orgDistId').val();
	 if(manfDistId=='0'){
		 alert('Please select District');
		 return false;
	 }
	 
	 
	 let orgPincode=$('#orgPincode').val();
	 if(orgPincode==null || orgPincode==""){
		 alert('please enter Organization Pin Code');
		 return false;
	 }
	 let orgPanNumber=$('#orgPanNumber').val();
	 if(orgPanNumber==null || orgPanNumber==""){
		 alert('please enter Organization PAN number');
		 return false;
	 }
	 
	 let contactPersonName=$('#contactPersonName').val();
	 if(contactPersonName==null || contactPersonName==""){
		 alert('please enter Contact Person Name');
		 return false;
	 }
	 
	 let contactPerDesg=$('#contactPerDesg').val();
	 if(contactPerDesg==null || contactPerDesg==""){
		 alert('please enter Contact Person Designation');
		 return false;
	 }
	 
	 let contPerMobileNo=$('#contPerMobileNo').val();
	 if(contPerMobileNo==null || contPerMobileNo==""){
		 alert('please enter Contact Person Mobile Number');
		 return false;
	 }
	 
	 let contPersEmail=$('#contPersEmail').val();
	 if(contPersEmail==null || contPersEmail==""){
		 alert('please enter Contact Person Mobile Email');
		 return false;
	 }
	 
	 let iecNumber=$('#iecNumber').val();
	 if(iecNumber==null || iecNumber==""){
		 alert('please enter Contact IEC Number');
		 return false;
	 }
	 
	 let iecIssueDate=$('#iecIssueDate').val();
	 if(iecNumber==null || iecIssueDate==""){
		 alert('please enter Contact IEC Issue Date');
		 return false;
	 }
	 
	 let iecIssueAuthority=$('#iecIssueAuthority').val();
	 if(iecIssueAuthority==null || iecIssueAuthority==""){
		 alert('please enter Contact IEC Issueing Authority');
		 return false;
	 }
	 
	 let addressProofId=$('#addressProofId').val();
	 if(addressProofId==null || addressProofId==""){
		 alert('please Upload Address Proof pdf');
		 return false;
	 }
	 
	
	 let registeredWithRcmc=$('#registeredWithRcmc').val();
	 //if(registeredWithRcmc=='false'){
		 let exportPromoCheck=$('#memberOfOtherExportPromotionCouncil').val();
		 let rcmcOfFieo=$('#rcmcOfFieoOne').val();
		 if(exportPromoCheck=='0'){
			 alert('Please select are you the member of any other export Promotion Council');
			 return false;
		 }
		 if(exportPromoCheck=='yes'){
			 
			 let rowCount = $('#m_table_1 tr').length;
			 let actualRowCount=rowCount-1;
			 for(let i=1;i<=actualRowCount;i++){
				 let promotionCouncil='#promotionCouncil_'+actualRowCount;
				 let registrationNumber='#registrationNumber_'+actualRowCount;
				 let validityDate='#validityDate_'+actualRowCount;
				 let promotionCouncilData=$(promotionCouncil).val();
				 let registrationNumberData=$(registrationNumber).val();
				 let ValidityDateData=$(validityDate).val();
				 if(promotionCouncilData==null || promotionCouncilData=='0'){
					 alert('Please enter Promotion Council');
					 return false;
				 }
				 if(registrationNumberData==null || registrationNumberData==''){
					 alert('Please enter Registration No.');
					 return false;
				 }
				 if(ValidityDateData==null || ValidityDateData==''){
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
	 
	 let applicantType=$('#applicantType').val();
	 if(applicantType=='101'){
		 let drugDetails=$('#drugLicence').val();
		 if(drugDetails==null || drugDetails==""){
			 alert('please upload Drug licence pdf');
			 return false;
		 }
	 }
	 
	 
	 let checkBoxOne = document.getElementById("agreementCheckBox");
	 if (checkBoxOne.checked == false){
		 alert("Please Tick aggrement checkbox");
		 return false; 
	 }
	 
	 let regCaptcha=$('#regCaptcha').val();
	 if(regCaptcha==''){
		 alert('please enter captcha');
		 return false;
	 }
	 
	 var bV = $("#frm").data('bootstrapValidator');
	 bV.validate();
	 if(bV.isValid()){ 
			confirm_alert('Do you Really want to save?','save');
		}
		else{
			
		}
	 
	
}

function  confirm_alert(msg,type){
	var m = msg.split('.');
	    var msg1=m[0];
	    msg2=m[1];
		swal(
				{  		
				title: "Are you sure?",   text: msg1,   
				type: "warning",  
				showCancelButton: true,   
				confirmButtonColor: "#34A534",   
				confirmButtonText: "OK",   
				cancelButtonText: "Cancel",   
				closeOnConfirm: true,   
				closeOnCancel:true 
				}, 
				function(isConfirm){   
				    	  if (isConfirm) {
				    		  
				    		  if(type=="save")
								{				
				    			  $("#infosavebutton").attr("disabled", true);
				    			  let userName=$('#userName').val();
				    			  let Pswd=$('#Pswd').val();
				    			  var Message=$('#Pswd').val();
				    			  //var hashcheck =  CryptoJS.SHA256(Message);
				    			  var randomNumber=Math.ceil(Math.random() * 10000);
				    			  var base = window.btoa(randomNumber+' ### '+Message+' ### '+Math.ceil(Math.random() * 10000));
				    			  var base2 = window.btoa(base);
				    			  var base3 = window.btoa(base2);
				    			  var base4 = window.btoa(base3);
				    			  $('#Pswd').val(base4);
				    			  
				    			  
				    			  $('#frm').submit();
								}
							else if(type=="delete")
								{
								 flag=true; 
								submit_form_delete();
								}
							else if(type=="modify")
							{
								submit_form_update();
							}
							else if(type=="ok")
							{
								 flag=true; 
								submit_form_delete();	
								}
					    	  } 

				    	  else {
				    		  imp=false;
				    	  }
				    	});
}

function checkIecnumber(data){
	$.ajax({
		type : "get",
		 url : "checkIecNumber",
	    data : {iecNumber:data},
	 success : function(response){
		 if(response=='alreadyPresent'){
			 alert("This IEC Number is already registered with some other company");
			 $('#iecNumber').val('');
		 }
	 }
	});
}

function checkGstnNumber(data){
	$.ajax({
		type : "get",
		 url : "checkGstnNumber",
	    data : {gstnNumber:data},
	 success : function(response){
		 if(response=='alreadyPresent'){
			 alert("This GSTIN Number is already registered with some other company");
			 $('#gstnumber').val('');
		 }
	 }
	});
}


function fileValidation(id){
	var fileInput = document.getElementById(id);
	var filePath = fileInput.value;
	var allowedExtensions = /(\.pdf)$/i;
	 if(!allowedExtensions.exec(filePath)){
	        alert('Please upload file having extensions .pdf only.');
	 
	        fileInput.value = '';
	        return false;
	  }
}


function getSignatureChecksum(){
	 
	 var form = $('#frm')[0];
	 var data = new FormData(form);
	 
	 $.ajax({
		  	type: "POST",
			url : "getSignatureChecksum",
			enctype: 'multipart/form-data',
		    data : data,	
		    cache : false,
           processData : false,
           contentType : false,
           timeout: 600000,
		 	success : function(response){
			 if(response.length>0){
				 
				
				 $('#addressProofDocument').val(response);
			 }else{
				 alert("Error");
			 }
		 }
		});
}

function getdrugChecksum(){
	 
	 var form = $('#frm')[0];
	 var data = new FormData(form);
	 
	 $.ajax({
		  	type: "POST",
			url : "getdrugChecksum",
			enctype: 'multipart/form-data',
		    data : data,	
		    cache : false,
          processData : false,
          contentType : false,
          timeout: 600000,
		 	success : function(response){
			 if(response.length>0){
				 $('#drugLiecenseDocument').val(response);
			 }else{
				 alert("Error");
			 }
		 }
		});
}



$(document).ready(function() {
	$("#frm")
	.bootstrapValidator(
		{
			fields : {
			
				userName : {
					validators : {
						emailAddress: {
	                        message: 'Please supply a valid email address'
	                    },
						notEmpty : {
							message : "User Name is required and can\'t be empty"
						}
					}
				},
				password : {
					validators : {
						notEmpty : {
							message : "Password is required and can\'t be empty"
						},
						regexp : {
							regexp : /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,25}$/,
							message : "Password not in proper format"
						},
						stringLength : {
							min : 8,
							max : 25,
							message : "Password can contain maximum of 25 characters"
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
	                        message: 'Please supply your zip code'
	                    },
	                    regexp : {
							regexp : /^[0-9]+$/,
							message : "Only numbers are allowed"
						},
						stringLength : {
							min : 4,
							max : 6,
							message : "pincode must be of 4 to 6 degits"
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
							max : 20,
							message : "Fax number can contain maximim of 10 numbers"
						}
	                }
	            },				  locationName : {
						validators : {
							notEmpty : {
								message : "Location Name is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 1,
								max : 50,
								message : "Location Name can contain maximum of 50 characters"
							}
						}
					},
					locationShortName : {
						validators : {
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 1,
								max : 5,
								message : "Location Short Name can contain maximum of 5 characters"
							}
						}
					},
					locationAddress : {
						validators : {
							notEmpty : {
								message : "Location Address is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 1,
								max : 50,
								message : "Location Address can contain maximum of 50 characters"
							}
						}
					},
					locZoneId : {
			 				validators : {
			 					callback: {
			 				           message: 'Please specify zone',
			 				           callback: function(value, validator, $field) {
			 				               
			 				               var options = validator.getFieldElements('locZoneId').val();

			 				               return (options != 0);
			 				           }
			 					}
			 				}
					 },
					 empName : {
							validators : {
								notEmpty : {
									message : "Employee Name is required and can\'t be empty"
								},
								regexp : {
									regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
									message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
								},
								stringLength : {
									min : 1,
									max : 50,
									message : "Employee Name can contain maximum of 50 characters"
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
								max : 15,
								message : "Employee Number can contain maximum of 15 characters"
							}
						}
					},
					empDesg : {
						validators : {
							notEmpty : {
								message : "Employee Designation is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 1,
								max : 50,
								message : "Employee Designation can contain maximum of 50 characters"
							}
						}
					},
					empEmailId : {
						validators : {
							emailAddress: {
		                        message: 'Please supply a valid email address'
		                    }
						}
					},orgContactNumber: {
			                validators: {
			                	 notEmpty: {
				                        message: 'Please supply your contact number'
				                },
			                    regexp : {
									regexp : /^[0-9\-]+$/,
									message : "Only numbers are allowed"
								},
								stringLength : {
									min : 5,
									max : 10,
									message : "contact number can contain maximim 10 numbers"
								}
			                }
			       },locEmailId : {
						validators : {
							emailAddress: {
		                        message: 'Please supply a valid email address'
		                    },
							notEmpty : {
								message : "Location Email Id is required and can\'t be empty"
							}
						}
					},locContactNumber: {
		                validators: {
		                	 notEmpty: {
			                        message: 'Please supply your Location contact number'
			                },
		                    regexp : {
								regexp : /^[0-9\-]+$/,
								message : "Only numbers are allowed"
							},
							stringLength : {
								min : 5,
								max : 10,
								message : "contact number can contain maximim 10 numbers"
							}
		                }
		       },locWebsiteLink : {
					validators : {
						notEmpty : {
							message : "Website Link is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 1,
							max : 100,
							message : "Website Link can contain maximum of 100 characters"
						}
					}
			},
			
				empMobileNo : {
						validators : {
							notEmpty : {
								message : "Mobile no.  is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[0-9().\/,\s\-]+$/,
								message : "Only numbers are permitted"
							},
							stringLength : {
								min : 10,
								max : 10,
								message : "Mobile Number can contain minimum 10 and maximum of 10 characters"
							}
						}
					},	
					
					strName : {
					validators : {
						notEmpty : {
							message : "Name is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 2,
							max : 50,
							message : "Name can contain min 2 and  maximum of 50 characters"
								
						}
					}
				},
				
				userType:{
							validators: {
			                	 callback: {
			                            message: 'Please choose an option',
			                            callback: function(value, validator, $field) {
			                                // Get the selected options
			                                var options = validator.getFieldElements('userType').val();
			                                return (options != 0 );
			                            }
			                        }
			                }
						},
						
						
							location:{
							validators: {
			                	 callback: {
			                            message: 'Please choose an option',
			                            callback: function(value, validator, $field) {
			                                // Get the selected options
			                                var options = validator.getFieldElements('location').val();
			                                return (options != 0 );
			                            }
			                        }
			                }
						},
						
						empGender:{
							validators: {
			                	 callback: {
			                            message: 'Please choose an option',
			                            callback: function(value, validator, $field) {
			                                // Get the selected options
			                                var options = validator.getFieldElements('location').val();
			                                return (options != 0 );
			                            }
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
						
						
					
					
					
					
			
			
			
			}
		});
});




$(document).ready(function() {
    $('#save').click(function(e) {  
    	
    	 var bV = $("#frm").data('bootstrapValidator');
    	 bV.validate();
    	 if(bV.validate())
    		 confirm_alert('Do you Really want to save?','save')
    });
    
    
    
    function  confirm_alert(msg,type){
    	var m = msg.split('.');
    	    var msg1=m[0];
    	    msg2=m[1];
    		swal(
    				{  		
    				title: "Are you sure?",   text: msg1,   
    				type: "warning",  
    				showCancelButton: true,   
    				confirmButtonColor: "#34A534",   
    				confirmButtonText: "OK",   
    				cancelButtonText: "Cancel",   
    				closeOnConfirm: true,   
    				closeOnCancel:true 
    				}, 
    				function(isConfirm){   
    				    	  if (isConfirm) {
    				    		  
    				    		  if(type=="save")
    								{		
    				    			
    				    			 // $("#save").attr("disabled", true);
    				    			  $('#frm').submit();
    								}
    							else if(type=="delete")
    								{
    								 flag=true; 
    								submit_form_delete();
    								}
    							else if(type=="modify")
    							{
    								submit_form_update();
    							}
    							else if(type=="ok")
    							{
    								 flag=true; 
    								submit_form_delete();	
    								}
    					    	  } 

    				    	  else {
    				    		  imp=false;
    				    	  }
    				    	});
    }
    
    
});


