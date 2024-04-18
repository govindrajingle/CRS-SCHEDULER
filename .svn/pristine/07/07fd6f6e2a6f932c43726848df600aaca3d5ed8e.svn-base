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
				purposeType : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Purpose of Excel',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('purposeType').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  },
			  uploadfile: {
	          	validators: {
	               /* file: {
	                 extension: 'xlsx',
	                 type: 'application/xlsx',
	                 maxSize: 1024*1024*10,
	                 message: 'Please choose a Excel file with a size less than 10 MB.'
	               }, */
	               notEmpty : {
					 message : 'Please upload Excel File Only',
					}
	             }
	          }
			}
		}); 

	$('#fileuploadRemoveBtn').click(function() {
		var bV = $("#frm").data('bootstrapValidator');
		bV.validate();
		if(bV.isValid()){ 
			confirm_alert('Do you Really want to Convert?','convert');
		}
		else{}
	});

	$('#reset').click(function() {
		clearFeilds();
	});
	
	
	let exception = '${errorStatus}';
	if (exception == 'true') {
		error_message('${errorMsg}');
	}
	
	
});

</script>

<script>


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
				    		  
				    		if(type=="convert")
								{		
									//alert("purpose   "+$('#purposeType').val());
									if($('#purposeType').val() == 1){
										submit_form_tertiary();
									}		
									else{
										submit_form_product();
									}
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

function submit_form_tertiary(){
	document.getElementById("frm").action = "${pageContext.request.contextPath}/convertExcelToXML";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

function submit_form_product(){
	document.getElementById("frm").action = "${pageContext.request.contextPath}/convertProductExcelToXML";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

function clearFeilds(){
	$("#purposeType").val(0);
	$("#fileupload").val("");
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
			<div class="float-left"><h3 class="tittle">Convert Excel TO XML</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div>
							
		<div class="scroll-top-wrapper ">
			<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>

		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm"  enctype="multipart/form-data">
				<sec:csrfInput/>
				
				
				<div class="panel panel-default " id="lic">
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-md-6">
									<label class="dvfrm-label">Purpose Type:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<select class="form-control" name="purposeType" id="purposeType" required="required">
										<option value="0">Select Purpose Type</option>
										<option value="1">Packing Detail</option>
										<option value="2">Product Detail</option>
										 
									</select>	
								</div>
								
								<div class=" col-md-6"  id="tertiary">
									<label class="dvfrm-label">Select Excel File</label>
									<div id="idUpload">
										<input class="form-control" id="fileupload" type="file" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" name="uploadfile" />
									</div>	
								</div>
								
							</div>
						</div>	
				</div>
				
				<div class="text-center">
					<button type="button" id="fileuploadRemoveBtn" class="btn btn-primary" onclick="">Click to Convert</button>
					<button type="button" id="reset" class="btn btn-primary" onclick="">Reset</button>
               	</div>
               	
			</form:form>
		</div>
		
	</div>
	
	</section>
	
</div>
</body>
</html>