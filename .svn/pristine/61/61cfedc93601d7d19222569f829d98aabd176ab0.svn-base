<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>


<html>
<body>
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<!--<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> -->
<script>
$(document).ready(function(){
	//alert("in bootstrap validator ");
	
	//loadDataTable(1);
	//$("#modify").hide();
	//$("#delete").hide();
   $("#frm")
	.bootstrapValidator({
			fields : {
				user_name : {
					validators : {
						notEmpty : {
							message : "Name is required and can\'t be empty"
						},
						regexp: {
						    regexp: /^[a-zA-Z\s]+$/,
						    message: "Only alphabets and spaces are permitted"
						},
						stringLength : {
							min : 2,
							max : 50,
							message : "Name can contain min 2 and  maximum of 50 characters"
								
						}
					}
				},


				designation : {
						validators : {
							notEmpty : {
								message : "Designation is required and can\'t be empty"
							},
							regexp: {
							    regexp: /^(?![0-9]{2,})(?!.*\d{2})[a-zA-Z0-9().\/,\s\-]+$/,
							    message: "Only alphabets, single numbers, special characters( / , . () - ) and spaces are permitted, and consecutive numbers are not allowed"
							},
							stringLength : {
								min : 2,
								max : 50,
								message : "Designation can contain min 2 and  maximum of 50 characters"
							}
						}
					},


					email_id : {
						validators : {
							notEmpty : {
								message : "Email is required and can\'t be empty"
							},
							regexp : {
								regexp :'^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 5,
								max : 50,
								message : "Email can contain min 5 and  maximum of 50 characters"
							}
						}
					},	



					mobile_no : {
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


					org_name : {
						validators : {
							notEmpty : {
								message : "Organization name  is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 2,
								max : 100,
								message : "Organization name  can contain min 2 and  maximum of 100 characters"
							}
						}
					},	


/* 
					org_name : {
						validators : {
							notEmpty : {
								message : "Organization name  is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 1,
								max : 20,
								message : "Organization name  can contain maximum of 20 characters"
							}
						}
					},	 */




					address : {
						validators : {
							notEmpty : {
								message : "Address  is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 10,
								max : 100,
								message : "Address name  can contain minimum 10 and  maximum of 100 characters"
							}
						}
					},	



					 pincode : {
						validators : {
							notEmpty : {
								message : "Pincode  is required and can\'t be empty"
							},
							regexp : {
								regexp : "^[a-zA-Z0-9]*$",
								message : "Only alphabet and numbers are permitted"
							},
							stringLength : {
								min : 4,
								max : 10,
								message : "Pin Code can contain min 4 and maximum of 10 characters"
							}
						}
					},	 
                     

					


					problem : {
						validators : {
							notEmpty : {
								message : "Problem  is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							stringLength : {
								min : 10,
								max : 300,
								message : "Problem name can contain maximum of 300 characters"
							}
						}
					},	


					subject:{
							validators: {
			                	 callback: {
			                            message: 'Please choose an option',
			                            callback: function(value, validator, $field) {
			                                // Get the selected options
			                                var options = validator.getFieldElements('subject').val();
			                                return (options != 0 );
			                            }
			                        }
			                }
						},
						
						countryTypeId:{
							validators: {
			                	 callback: {
			                            message: 'Please choose an option',
			                            callback: function(value, validator, $field) {
			                                // Get the selected options
			                                var options = validator.getFieldElements('countryTypeId').val();
			                                return (options != 0 );
			                            }
			                        }
			                }
						},


/* 
					subject : {
						validators : {
							notEmpty : {
								message : "Subject  is required and can\'t be empty"
							},
							regexp : {
								regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
								message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							},
							 stringLength : {
								min : 2,
								max : 200,
								message : "Subject name  can contain min 2 and  maximum of 200 characters"
							
						}
					},	 */

					uploadfile : {
						validators : {
							notEmpty : {
								message : "Please Upload the file"
							},
						}
					},


					contact_number : {
						validators : {
							notEmpty : {
								message : "Multiple contact number can be added"
							},
							regexp : {
								regexp :  /^[0-9().\/,\s\-]+$/,
								message : "Only  numbers are permitted"
							},
							stringLength : {
								min : 10,
								max : 15,
								message : "Contact Number can contain minimum 10 and maximum of 15 digits"
							}
						}
					}

			}

	});


	
                       
	$('#save').click(function() {
		//alert("in save");
		var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){
             //	alert("check11111");
				confirm_alert('Do you Really want to save?','save');
				/* document.getElementById("frm").action = "/DAVA/saveReportType";
				document.getElementById("frm").method = "POST";
				document.getElementById("frm").submit();   */
			}
			else{
			}
	});


	if('${flagSave}'== 1){
		//alert("inside if")
	
		alert("New Record Added Successfully.");
		  location.href = "http://localhost:8080/IVEDA/login";
	}
	
	if('${flagError}'== 1){
		error_message("Invalid Captcha.");
	}
	if('${flagFile}'== 1){
		error_message("PDF is Corrupted. Please try again.");
	}
	if('${tampFile}'== 1){
		error_message("Tampred File.");
	}
	if('${fileSize}'== 1){
		error_message("File size should be more than 0 and less than 10 MB.");
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
					    		  //alert("type==="+type);
					    		  if(type=="save")
									{	
								//alert("check 2222222222222");	
										//createFHash("frm");
										//$('#frm').submit();
										submit_form();
										//document.forms[0].submit();
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

	function submit_form(){
	//	alert('hgh');
		document.getElementById("frm").action = "${pageContext.request.contextPath}/saveReportType";
		document.getElementById("frm").method = "POST";
		createFHash("frm");
		document.getElementById("frm").submit();
		// $('#frm').submit();
	}

	//alert("on load<<<<<<<<<<<<<<<<<");
	$("#fileupload").on("change", uploadFile);
	$('#fileuploadRemove').hide();
	
	});

function uploadFile() {
	var filename = "Grievance Document";
	var docId = "";
	if($('#strDocId').val() == "-1")
		docId=0;
	else
		docId = $('#strDocId').val();
	 var somecheck=$('#fileupload').val().toString();
			// alert(somecheck);
				var path=somecheck.toString();
				 var r1=btoa(somecheck);
				// alert("r1:::"+r1);
				 var r2=reverseString(r1);
	 				var r3=btoa(r2);
				 $('#hashValue').val(r3);
	//alert("heloo")
	  $.ajax({
	    url: "uploadFile/"+filename+"/"+docId,
	    type: "POST",
	    data: new FormData($("#frm")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function (response) {
		    
	    	var Obj_List = response;
	  	  /*  alert("obj info "+Obj_List[0].eNSuccessFlag);
	  	   alert("obj info "+Obj_List[0].successFlag);
	  	   alert("obj info "+Obj_List[0].fileName); */
	  	   var eNSuccessFlag = Obj_List[0].eNSuccessFlag;
	  	 	  var SuccessFlag = Obj_List[0].successFlag;
	  	 	  var FileName = Obj_List[0].fileName;
	  	 	 //alert("hello" + SuccessFlag);
	  		 	  	
	  			if (SuccessFlag == 0 || SuccessFlag == 1){
	  		   	error_message("Please upload only PDF files");
	  		   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		   	}
	  		   	if (SuccessFlag == 2){
	  		   	error_message("File size should be more than 0 and less than 10 MB");
	  		   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		  
	  		   	} 
	  		   	if (SuccessFlag == 3){
	  		   	error_message("There was some error in uploading the file. Please try again.");
	  		   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		   	}
	  		 	if (SuccessFlag == 4){
	  		        error_message("PDF is Corrupted. Please try again.");
	  			   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		       	}
	  		   	if (SuccessFlag >=5){
	  		   		/* alert("File Uploaded Successfully");	 */	  		
	  		   		$('#numDocId').closest('.form-group').removeClass('has-error').addClass('has-success');
	  		   	 	$('#strDocId').val(eNSuccessFlag);
	  		   	    $('#numDocId').val(5);
	  		   	/* 	$('#fileuploadName').text(FileName); */
	  		   		$('#fileuploadRemove').show();
	  	       		$('#fileupload').hide();
	  	       		//alert("eNSuccessFlag---   "+eNSuccessFlag);
	  	       		$('#fileuploadDownloadLink').attr('href','${pageContext.request.contextPath}/downloadTmpFile_Secure/'+eNSuccessFlag);
	  	       		$('#fileuploadDownloadLink').text('Download('+FileName+')');
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
	  		    	}

		      
	    },
	    error: function () {
	      // Handle upload error
	      // ...
	    }
	  });
	}


function showAppFile(divName, divfile) {

		$('#fileupload').val('');
		$('#' + divName).hide();
		$('#' + divfile).show();
	
	}

function validform() {
	let userName = $('#loc_name').val();
	if (userName == null || userName == "") {
		alert('please enter username');
		return false;
	}

	let desiGnation = $('#desig').val();
	if (desiGnation == null || desiGnation == "") {
		alert('please enter the designation');
		return false;
	}

	let eMail = $('#email').val();
	if (eMail == null || eMail == "") {
		alert('please enter your email id');
		return false;
	}

	let mobileNo = $('#mblno').val();
	if (mobileNo == null || mobileNo == "") {
		alert('please enter your contact number');
		return false;
	}

	let organizationName = $('#orgname').val();
	if (organizationName == null || organizationName == "") {
		alert('please Enter the Organization Name');
		return false;
	}
	let address = $('#address').val();
	if (address == null || address == "") {
		alert('please enter your address');
		return false;
	}
	let countryName = $('#countryName').val();
	if (countryName == null || countryName == "") {
		alert('please select the country');
		return false;
	}
	
	let pincode = $('#pincode').val();
	if (pincode == null || pincode == "") {
		alert('please enter your postal/zipcode');
		return false;
	}
	
	let contactNo = $('#contactno').val();
	if (contactNo == null || contactNo == "") {
		alert('please Enter your Contact No.');
		return false;
	}
	
	let prblm = $('#prblm').val();
	if (prblm == null || prblm == "") {
		alert('please Define Your Problem/Issue');
		return false;
	}
	let fileId = $('#fileupload').val();
	if (fileId == null || fileId == "") {
		alert('please Upload pdf file');
		return false;
	}
	var bV = $("#frm").data('bootstrapValidator');
	bV.validate();
	if (bV.isValid()) {
		confirm_alert('Do you want to continue?', 'save');
	}
	else {

	}
}

</script>
<section class="regdv reg_note help-reach_page" id="aboutus">
  <div class="container">
    <div class="page-title text-center">
      <h1 class="fw-bold position-relative">Online <span>Help/Reach</span> out Help Desk </h1>
    </div>
    <form:form id="frm" name="frm" modelAttribute="reportProblemForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" enctype="multipart/form-data" autocomplete="off">
      <input type="hidden" id="TOKEN_KEY" value="" name="TOKEN_KEY" aria-label="hidden Field"/>
      <div class="panel panel-default">
        <div class="panel-body dvfrm-panel-body">
          <div class="row">

            <div class=" col-md-6 col-sm-12 col">
              <div class="form-group">
              	<label class="dvfrm-label" for="loc_name">Name <span style="color:#cd2026;">*</span>
                <span class="iconStyle"></span>
              </label>
              <form:input type="text" path="user_name" class="form-control m-input" id="loc_name" placeholder="Enter User Name" />
              </div>
            </div>

            <div class=" col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="desig">Designation <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:input type="text" path="designation" class="form-control m-input" id="desig" placeholder="Designation" />
	            </div>
	        </div>

	        <div class=" col-md-6 col-sm-12 col">
		        <div class=" form-group">
	              <label class="dvfrm-label" for="email">E-mail <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:input type="email" path="email_id" class="form-control m-input" id="email" placeholder="E-mail" />
	            </div>
            </div>
            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="mblno">Mobile <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:input type="number" path="mobile_no" class="form-control m-input" id="mblno" placeholder="Mobile No."/>
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="orgname">Organization <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:input type="text" path="org_name" class="form-control m-input" id="orgname" placeholder="Organization Name" />
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="address">Address <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:input type="text" path="address" class="form-control m-input" id="address" placeholder="Maximum of 100 characters are allowed." />
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="countryName">Country <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:select path="countryTypeId" class="form-control" id="countryName" placeholder="Country Name" required="required">
	                <form:option value="0">--select Country--</form:option>
	                <c:forEach items="${countryMst}" var="c">
	                  <option value='${c.num_country_id}'> ${c.str_country_name}</option>
	                </c:forEach>
	              </form:select>
	              <!-- <input id="countname" name="strOrgName" placeholder="Country Name" class="form-control" type="text" onblur="toUpper(this.value,this.id);"  value=""/> -->
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="pincode">Zip/Postalcode <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:input path="pincode" type="number" class="form-control" id="pincode" placeholder="Enter Pin Code" />
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="contactno">Contact No. <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:input path="contact_number" type="number" class="form-control" id="contactno" name="strLandlineNo" placeholder="STD Code - Contact Number" />
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="sub">Subject <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:select path="subject" class="form-control" id="sub" placeholder="Select  subject" required="required">
	                <form:option value="0">--Select Subject--</form:option>
	                <option value="Registration">Registration </option>
	                <option value="Verification">Verification</option>
	                <option value="Data upload at Tertiary/Secondary level">Data upload at Tertiary/Secondary level</option>
	                <option value="Serialisation Codes">Serialisation Codes</option>
	                <option value="Schema file download/upload">Schema file download/upload</option>
	                <option value="File Formats Issues">File Formats Issues</option>
	                <option value="Other Technical issues">Other Technical issues</option>
	                <option value="Suggestions, if any or Others">Suggestions, if any or Others</option>
	              </form:select><%-- 
								<form:textarea path="subject"  class="form-control m-input" id="sub"/>	 --%>
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <label class="dvfrm-label" for="prblm">Problem/Issue <span style="color:#cd2026;">*</span>
	                <span class="iconStyle"></span>
	              </label>
	              <form:textarea path="problem" class="form-control m-input" id="prblm" placeholder="Maximum of 300 characters are allowed." />
	            </div>
            </div>

            <div class="col-md-6 col-sm-12 col">
	            <div class="form-group">
	              <form:hidden path="numDocId" id="numDocId" />
	              <form:hidden path="strDocId" id="strDocId" value="-1" />
	              <label class="dvfrm-label">Upload Document<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
	              <div id="idUpload">
	                <input class="form-control" id="fileupload" type="file" accept="application/pdf" onchange="fileValidation(this.id)" name="uploadfile" aria-label="File Upload"/>
	             	 <input type="hidden" name="hashValue" id="hashValue">
	              </div>
	              <div id="fileuploadRemove">
	              <!--   <a id="fileuploadDownloadLink" href="#">Download</a> -->
	                <button type="button" id="fileuploadRemoveBtn" class="btn btn-primary" onclick="showAppFile('fileuploadRemove','fileupload')">Remove</button>
	              </div>
	            </div>
            </div>

            <div class="col-md-12 col-sm-12 p-0">
             <div class="form-group">
              <div class="row clear">
	              	 <label class="dvfrm-label d-block" for="registrationCaptchaOne">Enter Security Code</label>
	                <div class="col-md-3 col-sm-3 col-xs-12 col">
	                  <h4 id="registrationCaptchaOne" style="user-select:none;" class="d-flex">${generatedCaptcha}</h4>
	                </div>
	                <div class="col-md-9 col-sm-9 col-xs-12 col d-flex">
	                  <input name="feedbackResponseCaptcha" type="text" class="form-control" id="feedbackResponse" placeholder="Enter Captcha" required="required" aria-label="feedbackResponse"/>
	                  <div class="refresh_reg" onclick="changeCaptcha()">
	                  	<i class="fa fa-refresh" aria-hidden="true"></i>
	                	</div>
	                </div>
	              </div>
              </div>
            </div>
            <div class="form-group col-md-12 text-center">
              <button type="button" id="save" class="custom-btn position-relative" onclick="validform()" >Submit</button>
              <!-- <div class="email_us_btn"><a href="tel:01202210888" class="btn_default btn-success" title="Email Us"><i class="fas fa-email-us"></i>support[AT]iveda-india[DOT]in</a></div> -->
              <!-- <div class="call_us_btn"><a href="mailto:support@iveda-india.in" class="btn_default btn-success" title="Email Us">support[AT]iveda-india[DOT]in</a></div> -->
            </div>
          </div>
        </div>
        <!-- row closed -->
      </div>
    </form:form>
  </div>
</section>	



<script type="text/javascript">
function changeRegistrationCaptcha(){
	$.ajax({
		type:"GET",
		url:"getCaptcha",
		success:function(data){
			document.getElementById("registrationCaptchaOne").innerHTML = data;
			
		}
	
	});

}

function changeCaptcha() {
    var captcha = Math.random().toString(36).substring(7);
    document.getElementById("registrationCaptchaOne").innerHTML = captcha; 
  }
window.onload = function() {
	  changeRegistrationCaptcha();
};


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

</script>
 <script>
var token_key = "NMD_TOKEN_KEY";
var createFHash = function(frmName){
//alert("createFHash same");


	 datastring = $("form[name='"+frmName+"']").serializeArray()
	 
	 
	 
	 //alert("createFHash same" + datastring);
	var tokenval = getHexaCode(datastring);
												
	
	//alert("token==="+tokenval);
 

	$('<input>').attr({
	    type: 'hidden',
	    id: token_key,
	    name: token_key,
	    value:tokenval
	}).appendTo('form');
	
 	
};
 
 var getHexaCode = function(datastring){
	
	 datastring.sort(function(a, b){
	        var a1= a.name.toLowerCase(), b1= b.name.toLowerCase();
	        if(a1== b1) return 0;
				   
				   
	        return a1> b1? 1: -1;
	    });
	     
	//alert(datastring);
	console.log(datastring);
	
	
	
	var myInput = "";
	var datalength=0;
	$.each(datastring, function( index, val ) {
		 
		if(val.name != token_key){
			
			////alert( index + ": " + val.name +" ="+val.value+"=");
			
			var newVal =  val.value;
			
			if(newVal!=''){
				
				newVal = newVal.replace(/ /gi, "_");
				newVal = newVal.replace(/\n|\r\n|\r/g, '_');
				myInput = myInput+""+newVal;
				datalength=datalength+1;
			}
			
		}
		
		  
	});
	
	//console.log("str :: "+myInput);
	//alert(myInput);
	return hex_md5(myInput);
	
	//return myInput;
	
	
 };
 
 
var submitForm = function(){
	
	////alert("inside submitForm");
	 		
	document.forms[0].submit();
	
	
};
 
var getQueryParameters = function(str){
	str = str.split('?')[1];
	
	var outputArray = new Array();
	
	var strVals = str.split("&");
	
	for(var i=0; i< strVals.length; i++){
		
		var newVals = strVals[i].split("=");
		
		var obj = {name:""+newVals[0] , value:""+newVals[1]} ;
		
		outputArray[i] = obj;
		
	} 
	
	return outputArray;
	
};
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

	<!-- File Upload -->

</html>