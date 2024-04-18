<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>


<script>
$(document).ready(function(){
	//alert("on load");
	
	$("#frm")
	.bootstrapValidator(
		{
			fields : {
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
							min : 1,
							max : 50,
							message : "Name can contain maximum of 50 characters"
						}
					}
				},
				strName2 : {
					validators : {
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 1,
							max : 50,
							message : "Name can contain maximum of 50 characters"
						}
					}
				},
				gender : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Gender',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('gender').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  companyName : {
					validators : {
						notEmpty : {
							message : "Company Name is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 1,
							max : 200,
							message : "Company Name can contain maximum of 200 characters"
						}
					}
				},
				companyAdd : {
					validators : {
						notEmpty : {
							message : "Company Address is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},

						stringLength : {
							min : 1,
							max : 1000,
							message : 'Company Address can contain maximum of 1000 characters'
						}
					}
				},
				emailId : {
					validators : {
						notEmpty : {
							message : "Email is required and can\'t be empty"
						},
						regexp : {
							regexp : '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
							message : 'Please enter a valid email address'
						},
						stringLength : {
							min : 1,
							max : 30,
							message : "Email can contain maximum of 30 characters"
						}
					}
				},
				mobileNo : {
					validators : {
						notEmpty : {
							message : "Contact Number is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[0-9().\/,\s\-]+$/,
							message : 'Only numbers are permitted'
						},

						stringLength : {
							min : 10,
							max : 10,
							message : 'Contact Number can contain minimum 10 and maximum of 10 characters'
						}
					}
				},
				location : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Location',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('location').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }
			}
		});


	$('#save').click(function() {
		 var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
			}
			else{
			}
		});

	if ('${flagSave}' == 1) {
		ok_message("Registration Saved Successfully.");
	}
	
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
								submit_form();
								}
							else if(type=="ok")
							{
								 flag=true; 	
								}
					    	  } 

				    	  else {
				    		  imp=false;
				    	  }
				    	});
}

function submit_form(){
	document.getElementById("frm").action = "${pageContext.request.contextPath}/saveWorkshopRegistration";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

</script>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>

<link rel="stylesheet" href="css/homepage/pw.css">

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
<div class="content-wrapper">
<section class="regdv">
	
	
	<div class="container-fluid reg_contain">
	
		
	
		<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittle">WorkShop Registration</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div>
							
		<div class="scroll-top-wrapper ">
			<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>

		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm" modelAttribute="workshopRegistrationModel">
				<sec:csrfInput/>
				
				
				<div class="panel panel-default " id="lic">
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-md-6">
									<label class="dvfrm-label">First Key person Name to attend the Workshop:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input type="text" class="form-control m-input" path="strName" placeholder="Enter Full Name" id="strName" autocomplete="off"></form:input>
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Second Key person Name to attend the Workshop:<span class="iconStyle"></span></label>
									<form:input type="text" class="form-control m-input" path="strName2" placeholder="Enter Full Name" id="strName2" autocomplete="off"></form:input>
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Gender:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:select path="gender" class="form-control" id="gender">
										<form:option value="0">Select Gender</form:option>
										<form:option value="1">Male</form:option>
										<form:option value="2">Female</form:option>
									</form:select>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Email Id:<span style="color:red;">*</span><span class="iconStyle"><h5>Please correctly fill this email feedback form will be sent to this email after successfully registration.</h5></span></label>
									<form:input path="emailId" type="text" class="form-control"
								 			id="emailId" placeholder="Enter Email Id"/>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Contact Number:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="mobileNo" type="text" class="form-control"
										 id="mobileNo" placeholder="Enter Number"/>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Company Name:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="companyName" type="text" class="form-control"
								 			id="companyName" placeholder="Enter Company Name"/>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Company Address:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:textarea path="companyAdd" type="text" class="form-control"
								 			id="companyAdd" placeholder="Enter Company Address"/>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Location for Workshop:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:select path="location" class="form-control" id="location">
										<form:option value="0">Select Location</form:option>
										<form:option value="1">Chandigarh</form:option>
										<form:option value="2">Hyderabad</form:option>
										<form:option value="3">Ahemdabad</form:option>
										<form:option value="4">Mumbai</form:option>
									</form:select>	
								</div>
								
							</div>
						</div>	
				</div>
				
				<div class="text-center">
					<button type="button" class="btn btn-primary" id="save"> Save </button>
                	<button type="reset" class="btn btn-primary" id="reset"> Reset </button>
               	</div>
			</form:form>
		</div>
		
	</div>
	
	</section>
	
</div>
</body>
</html>