<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>


<script type="text/javascript" src="js/validation/customValidation.js"></script>
<!--    <script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> -->
   <script type="text/javascript" src="js/formFieldValidation/md5.js"></script>

<script>

var token_key = "NMD_TOKEN_KEY";

var createFHash = function(frmName){

//alert("createFHash");
	 datastring = $("form[name='"+frmName+"']").serializeArray()
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


</head>
<body>
	
<section class="reg_note regdv" id="skiptomaincontent">
  	<div class="container">
	    <div class="page-title text-center">
	      <h1 class="fw-bold position-relative">User  <span>Registration</span> </h1>
	    </div>
	    <div class="alert alert-warning bg-white" role="alert">
	      <strong class="h4 pad-left double bold">Note:</strong>
	      <ol>
	        <li> Authorized Signatory / Responsible person of the organization should fill the form.</li>
	        <li>All fields marked with asterik ( <span style="color:#cd2026;">*</span>) are mandatory. </li>
	        <li>
	          <span class="bold">Registration Steps</span>
	          <ol type="a">
	            <li>If you are registered with RCMC, you will have to enter your RCMC number. </li>
	          </ol>
	      </ol>
	       <div class="regvd">
	        <span>
	          <a class="custom-btn position-relative" href="https://www.youtube.com/watch?v=EitLDLSm3YY" target="_blank">Watch registration video, Click here!</a>
	        </span>
	        <span>
	          <a class="custom-btn position-relative" href="${pageContext.request.contextPath}/download/Manuals_iveda/User_Manual_for_Registration_v1.0.pdf" target="_blank">Click here to download registration guidelines</a>
	        </span>
	    </div>
	    </div>
	   
  </div>

		
	  
 
  <div class="container reg_contain">
						
    <div class="col-md-12 p-0">
      <form:form action="${pageContext.request.contextPath}/getregistration" method="post" id="frm" name="frm" modelAttribute="registrationForm" onkeydown="return event.key != 'Enter';">
        <div class="panel panel-default " id="Manufacture_Registration">
          <div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
            <b></b>
		
          </div>
          <div class="panel-body dvfrm-panel-body">
            <div class="row">
                <div class=" col-md-4 col-sm-12 col">
	                <div class="form-group">
	                  <label class="dvfrm-label" for=registeredWithRcmc>Are you a member of Pharmexcil? <span style="color:#cd2026;">*</span>
	                    <span class="iconStyle"></span>
	                  </label>
	                  <form:select path="registeredWithRcmc" class="form-control" id="registeredWithRcmc" onchange="getRcmcNumber(this.value)" autocomplete="off">
	                    <form:option value="0">--select--</form:option>
	                    <form:option value="yes">Yes</form:option>
	                    <form:option value="no">No</form:option>
	                  </form:select>
	                </div>
                </div><!--end col1-->

                <div class="col-md-4 col-sm-12 col"id="rcmcNumber" style="display: none;">
	                <div class="form-group">
	                  <label class="dvfrm-label" for=rcmcNumberone>RCMC Number <span class="orange" style="color: red;">*</span>
	                    <span class="iconStyle"></span>
	                  </label>
	                  <form:input path="rcmcNumber" autocomplete="off" class="form-control" id="rcmcNumberone" placeholder="Enter RCMC Number"></form:input>
	                </div>
                </div><!--end col2-->

                <div class="col-md-4 col-sm-12 col" id="applicantTypeDiv" style="display: none;">
	                <div class="form-group">
	                  <label class="dvfrm-label" for=applicantTypeId>Registration Type <span class="orange" style="color: red;">*</span>
	                    <span class="iconStyle"></span>
	                  </label>
	                   <form:select class="form-control" id="applicantTypeId" path="applicantType">
	                    <option value="-1">--select--</option>
	                    <c:forEach items="${appType}" var="s">
	                      <option value='${s.numApplTypeId}'>${s.strApplTypeName}</option>
	                    </c:forEach>
	                  </form:select>
	                </div>
                </div><!--end col3-->

		   
			 
				 
              </div>
	
	
					  
																	   
																																					
																																																																			   
          </div>
        </div>
			  
						
 
									
  
 
  
						
																		  
																	  
											
																	
																								 
											 
					  
							  
							  
																					 
																				  
				
			 
							 
																																
														 
													
												  
					  
			 
			
		   
	 
	 
	 
	 
															 
							  
							  
																
																				  
				
			 
							  
																							
			 
			
		   
	 
																   
							  
							  
																	  
																				  
				
			 
							  
																					
												
											   
																		 
					 
					  
			 
			
		   
	
		   
		 
        <div class="text-center">
          <button type="button" class="custom-btn position-relative" id="save" onclick="checkValidations()">Continue</button>
        </div>
      </form:form>
    </div>
  </div>
</section>

<script>
	function getRcmcNumber(data) {
		if(data=='yes'){
			
			document.getElementById('rcmcNumber').style.display="block";
			
			$('#applicantTypeDiv').show();
			
			$('#applicantTypeDiv').val('-1');
			
		}else if(data=='no'){
			
			$('#rcmcNumberone').val('');
			
			$('#applicantTypeDiv').show();
			
			document.getElementById('rcmcNumber').style.display="none";
			
		}else{
			alert("9");
			$('#rcmcNumber').val('');
			document.getElementById('rcmcNumber').style.display="none";
		}
	}
	
	
	function getRcmcStatus(data){
		 var token = $("meta[name='_csrf']").attr("content");
		 var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			type : "GET",
			 url : "getRcmcNumberStatus",
			data : {"rcmcNumber":data},
			 beforeSend: function(xhr){
		        	xhr.setRequestHeader(header, token);
		        	
	       },
		 success : function(response){
			 if(response.length>0){
				if(response=='invalidRcmcNumber'){
					alert('Entered RCMC number is not valid');
					$('#rcmcNumberone').val('');
					return false;
				}else if(response=='alreadyRegistered'){
					alert('Someone has already registered with same RCMC number');
					$('#rcmcNumberone').val('');
					return false;
				}else{
					document.getElementById("frm").submit();
				}
			 }
		 }
		});
	}
	
	function checkValidations() {

		//alert("1213");

		 createFHash("frm");
		
		
		let registeredWithRcmc=$("#registeredWithRcmc").val();



  
		let rcmcNumberone=$("#rcmcNumberone").val();
		
  
		if(registeredWithRcmc=='yes'){
		if(rcmcNumberone.length <10){
			alert("RCMC Number cannot be smaller than 10 characters")
			return false;
			}	
		if(rcmcNumberone.length >35){
			
			alert("RCMC Number cannot be greater than 35 characters")
				return false;
			}

		if(rcmcNumberone.match(/^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[/&-]).{10,}$/) == null) {
		            alert("Please Enter Valid RCMC Number (Only alphabet, numbers, special characters( /  - ) and white spaces are permitted)")
		            return false;
		            }  	
  
         else {

             
			document.getElementById("frm").submit();
       }
	
		}						
							   
															
				
	 
   
  
		let applicantTypeId=$("#applicantTypeId").val();
		
		if(registeredWithRcmc=='0'){
				alert('Please select Are you member with PharmaExcil?');
				return false;
		}
		
		if(registeredWithRcmc=='yes'){
			if(rcmcNumberone=='' || rcmcNumberone==null){
				alert('Please enter RCMC number');
				return false;
			}
			if(applicantTypeId=='-1'){
				alert('Please select registration type');
				return false;
			}
			
			if(applicantTypeId=='201'){
				window.location.href='${pageContext.request.contextPath}/RegistrationOfficials';
			}else{
				document.getElementById("frm").submit();
			}
				
				
			//getRcmcStatus(rcmcNumberone);
			
		}
		
		if(registeredWithRcmc=='no'){
			if(applicantTypeId=='-1'){
				alert('Please select registration type');
				return false;
			}
			
			if(applicantTypeId=='201'){
				window.location.href='${pageContext.request.contextPath}/RegistrationOfficials';
			}else{
				document.getElementById("frm").submit();
			}	
		}
	}

	$(document).ready(function() {
		$('#applicantTypeDiv').hide();
  
		});
	
	
	
</script>

</body>
					 
														
															   
														 
																			   
																			 
</html>