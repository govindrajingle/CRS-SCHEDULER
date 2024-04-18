<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<!-- <link rel="stylesheet" href="css/dashboard/style.bundle.css" rel="stylesheet">-->
<link rel="stylesheet" href="css/dashboard/select2.css">

<script src="js/homepage/select2.js"></script> 
<script src="js/homepage/select2.min.js"></script>

<link href="css/dashboard/jquery.multiselect.css" rel="stylesheet" />
<script src="js/dashboard/jquery.multiselect.js"></script>
    	   
<!-- <script>
$(document).ready(function(){
	
	 	      	
									$("#frm")
									.bootstrapValidator(
										{
											fields : {
												region_id : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Region',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('region_id').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  listExpCountry : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Country',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('listExpCountry').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  /* orgName : {
													validators : {
														notEmpty : {
															message : "Organization Name is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 1,
															max : 20,
															message : "Organization Name can contain maximum of 20 characters"
														}
													}
												},
												expSiteAdd : {
													validators : {
														notEmpty : {
															message : "Site Address is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 1,
															max : 20,
															message : "Site Address can contain maximum of 20 characters"
														}
													}
												}, */
												/* expName : {
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
												expNumber : {
													validators : {
														notEmpty : {
															message : "Number is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[0-9().\/,\s\-]+$/,
															message : 'Only numbers are permitted'
														},
														stringLength : {
															min : 10,
															max : 10,
															message : 'Number can contain minimum 10 and maximum of 10 characters'
														}
													}
												},
												expDesignation : {
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
												}, */
											/* 	expEmail : {
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
															max : 50,
															message : "Email can contain maximum of 50 characters"
														}
													}
												} */
											}
										});



	
							
	//loadDataTable(1);
	
	if('${flagSave}'== 1){
		ok_message("New Record Added Successfully.");
	}
});




/* function loadCountry(regionId){ 

	alert("I m from load country");
	var stateId=$('#loc_state').val(); 
	//alert(stateId);
		$.ajax({
			type : "GET",
			 url : "getDistrictData",
			data : {regionId:regionId},
		 success : function(response){
			 if(response.length>0){
			
				 for(var userlist in response){
					 $('#loc_dist').append($("<option></option>").attr("value",response[userlist].num_district_id).text(response[userlist].str_district_name));
				 }  
				 
			 }
		 }
	});
} */

</script>


<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		  		{
			"sTitle" : "ID",
			"mData" : "num_distribution_id"
		 },	
		{
			"sTitle" : "Region Name",
			"mData" : "str_region_name"
		},
		{
			"sTitle" : "Country Name",
			"mData" : "countryname"
		},
		
		/* {
			"sTitle" : "Site Address",
			"mData" : "str_address"
		}, */
		
		/* {
			"sTitle" : "Name",
			"mData" : "str_cont_per_name"
		},
		{
			"sTitle" : "Contact Number ",
			"mData" : "str_contact_number"
		},
		{
			"sTitle" : "Email",
			"mData" : "str_email_id"
		},
		{
			"sTitle" : "Designation",
			"mData" : "str_cont_per_desg"
		} */
	],
				responsive: !0,
				columnDefs : [
						/* {
							'targets' : 0,
							'searchable' : true,
							'orderable' : true,
							'className' : 'dt-body-top',
							'render' : function(
									data, type, row) {
								return '<input type="radio" class="radio" name="uid" id ="radio"'
										+ row.num_drug_id
										+ '" value="'
										+ $('<div/>').text(data).html()
										+ '">';
										
							}
						}, */
						{
							"targets": [],
			                 "className": "none",
			             	  
			             }],
    	
	});
	return Table;
}
function accept(id){
	//alert("accpt  - "+id)
}

function resetAndDrawTable(dataTableId,data,statusID){
	var sizeWidth,sizeHeight;
		sizeWidth="100%";
		sizeHeight="100%";
	var table = initTable(dataTableId,sizeWidth,sizeHeight,statusID);
	
	table.clear().draw();
	table.rows.add(data); // Add new data
	table.columns.adjust().draw();
}
/* function loadDataTable(statusID){
	//alert("load data table");
	 $.ajax({
			type:"GET",
			data:{status :statusID},
			url :"getPointsOfDistributionDtls",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
} */

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
	document.getElementById("frm").action = "/DAVA/saveCountryRegionMap";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}


</script>

 -->





<%-- 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>


</head>
<body>
<div class="content-wrapper">
<section class="regdv">
	
	
	<div class="container-fluid reg_contain">
	
		
	
		<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittle">CountryRegionMap</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
	
		
		</div>
							
		<div class="scroll-top-wrapper ">
			<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>

		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm" modelAttribute="countryRegionMapModel">
				
				<sec:csrfInput/>
				
				<div class="panel panel-default " id="distributionDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Mapping Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-md-6">
									<label class="dvfrm-label">Region:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:select path="region_id" class="form-control" id="expReg">
										<form:option value="0">Select Region</form:option>
										<c:forEach items="${region}" var="c">
											<option value='${c.numRegionId}'> ${c.strRegionName}</option>
										</c:forEach>
									</form:select>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Country:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									
									<form:select class="form-control m-select2" cssStyle="width:100% !important;" name="param"
												multiple="multiple" id="m_select2_7" path="listExpCountry">
										<option value="0">Select Country</option>
										<c:forEach items="${country}" var="c">
											<option value='${c.num_country_id}'> ${c.str_country_name}</option>
										</c:forEach>
									</form:select>
								</div>
		
								<div class=" col-md-6">
									<label class="dvfrm-label">Organization Name:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="orgName" type="text" class="form-control"
								 			id="orgName" placeholder="Enter Name" required="required"/>	
								</div>
							
								<div class=" col-md-6">
									<label class="dvfrm-label">Exporting Site Address:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:textarea path="expSiteAdd" type="text" class="form-control"
								 			id="expSiteAdd" placeholder="Enter Exporting Site Address" required="required"/>	
								</div>
								
								
						
							</div>
						</div>
				</div>
			
				
				<div class="text-center">
					<button type="Submit" class="btn btn-primary" id="save">Save</button>
                	<!-- <button type="button" id="modify" class="btn btn-primary">Modify</button>
					<button type="button" id="delete" class="btn btn-primary">Delete</button> -->
					<button type="reset" class="btn btn-primary" id="reset">Reset</button>
               	</div>

			</form:form>
		</div>
		
	</div>
	
	</section>
	</div>
	
	
	<script>
	$('#m_select2_7').multiselect({  // options here
	});
</script>
</body>
</html>

 --%>





<!-- <script>
$('#save').click(function() {

	alert("Save button is clicked");
	 var bV = $("#frm").data('bootstrapValidator');
	   bV.validate();
		if(bV.isValid()){ 
			confirm_alert('Do you Really want to save?','save');
			
		}
		else{
		}
});

</script> -->

