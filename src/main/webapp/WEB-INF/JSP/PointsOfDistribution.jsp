<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>Add In-Charge for Exporting Region</title>
<!-- <link rel="stylesheet" href="css/dashboard/style.bundle.css" rel="stylesheet">-->
<script type="text/javascript" src="js/validation/customValidation.js"></script>
<!-- <script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> -->
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<script type="text/javascript" src="js/globalJs/globalJs.js"></script>
    	   
<script>
$(document).ready(function(){
	//alert("on load");
	$('.js-example-basic-multiple').select2({
				multiple : true,
				placeholder : '-- Select --',
				allowClear : true
			});
	 	      	
									$("#frm")
									.bootstrapValidator(
										{
											fields : {
												expReg : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Region',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('expReg').val();

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
												expName : {
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
															regexp : /^[0-9]+$/,
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
														regexp: {
														    regexp: /^(?![0-9]{2,})(?!.*\d{2})(?!.*[/.,()\-]{2})[a-zA-Z0-9().\/,\s\-]+$/,
														    message: "Only alphabets, single numbers, special characters( / , . () - ) and spaces are permitted, and consecutive numbers are not allowed"
														},
														stringLength : {
															min : 2,
															max : 20,
															message : "Designation can contain minimum 2 and maximum of 20 characters "
														}
													}
												},
												expEmail : {
													validators : {
														notEmpty : {
															message : "Email is required and can\'t be empty"
														},
														regexp : {
															regexp : '^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$',
															message : 'Please enter a valid email address'
														},
														stringLength : {
															min : 1,
															max : 50,
															message : "Email can contain maximum of 50 characters"
														}
													}
												}
											}
										});
							
	loadDataTable(1);
	$('#save').click(function() {
		 var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
				
			}
			else{
			}
	});

	if('${flagSave}'== 1){
		ok_message("New Record Added Successfully.");
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

<!-- Creatiing token and validating with FormFieldValidationFilter.java G9 -->
	
<script>
var token_key = "NMD_TOKEN_KEY";
var createFHash = function(frmName){
  // alert("createFHash in same");
	 datastring = $("form[name='"+frmName+"']").serializeArray()
	var tokenval = getHexaCode(datastring);	
	//alert("token saaa==="+tokenval);
	$('<input>').attr({
	    type: 'hidden',
	    id: token_key,
	    name: token_key,
	    value:tokenval
	}).appendTo('form');
};
var getHexaCode = function(datastring){
	//alert("in hex code"+datastring);
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
	createFHash("frm");
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
		
		{
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
		}
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
							"targets": [1,2],
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
function loadDataTable(statusID){
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
	document.getElementById("frm").action = "${pageContext.request.contextPath}/savePoinstOfDistribution";
	document.getElementById("frm").method = "POST";
	$("#frm").submit();
}

function getCountryBasedOnRegion() {
	var regionId = $('#expReg').val();


	//added by harshita
		$('#expCountry')
	    .find('option')
	    .remove()
	    .end() 
	
	$.ajax({
		type:"GET",
		url :"countrybasedOnRegion",
		data:{regionId:regionId},
		 success: function (response) {
			 if(response.length>0){
				 for (var i = 0; i < response.length; ++i) {
					 $('#expCountry').append(
								$('<option/>').prop("value",response[i].num_country_id).text(response[i].str_country_name)); 
				 }
			 }
			
		 }
	});
}
</script>

<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">
		<div class="page-title"><h1 class="fw-bold"> Add In-Charge for Exporting Region</h1></div>
			<form:form method="post" id="frm" name="frm" modelAttribute="pointsOfDisModel" autocomplete="off">
				<c:forEach items="${errors }" var="error">
                    	<div class="alert alert-success" role="alert">
  							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  						<div class="text-danger">
							<c:out value="${error }"></c:out>
						</div>
						</div>	
				</c:forEach>
				<sec:csrfInput/>
				
				<div class="panel panel-default " id="distributionDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Add Member In-Charge for that Exporting Region Details</b></div>
					<div class="panel-body dvfrm-panel-body">
						<div class="row">
							<div class=" col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label" for="expReg">Exports Region:<span  style="color:#cd2026;">*</span></label>
									 <form:select path="expReg" class="form-control" id="expReg" onchange="getCountryBasedOnRegion();">
									 <form:select path="expReg" class="form-control" id="expReg" >
										<form:option value="0">Select Exports Region</form:option>
										<c:forEach items="${region}" var="c">
											<option value='${c.numRegionId}'> ${c.strRegionName}</option>
										</c:forEach>
									</form:select>	
								</div>
							</div>
							
							<div class=" col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label" for="expCountry">Exports Country:<span  style="color:#cd2026;">*</span></label>
									<form:select class="custom-select js-example-basic-multiple" multiple="multiple" id="expCountry" path="listExpCountry">
									</form:select>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- Member details -->
				<div class="panel panel-default " id="personDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>In-Charge Details for that Exporting Region</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="expName">Name:<span  style="color:#cd2026;">*</span></label>
										<form:input path="expName" type="text" class="form-control"
									 			id="expName" placeholder="Enter Name"/>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="expNumber">Mobile Number:<span  style="color:#cd2026;">*</span></label>
										<form:input path="expNumber" type="text" class="form-control"
									 			id="expNumber" placeholder="Enter Contact Number"/>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="expDesignation">Designation:<span  style="color:#cd2026;">*</span></label>
										<form:input path="expDesignation" type="text" class="form-control"
									 			id="expDesignation" placeholder="Enter Designation"/>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="expEmail">Email:<span  style="color:#cd2026;">*</span></label>
										<form:input path="expEmail" type="text" class="form-control"
									 			id="expEmail" placeholder="Enter Email"/>	
									</div>
								</div>
							</div>
						</div>	
				</div>
				
				<div class="text-center">
					<button type="button" class="custom-btn postion-relative" id="save"> Save </button>
                	<!-- <button type="button" id="modify" class="btn btn-primary">Modify</button>
					<button type="button" id="delete" class="btn btn-primary">Delete</button> -->
					<button type="reset" class="btn_default" id="reset"onclick=resetSelect2()> Reset </button>
               	</div>
               	
               	<fieldset class="mt-2 border-0 p-0">
               		<div class="section-title"><h2>In-Charge for Exporting Region List</h2></div>
	               	<div class="bg_white">
		       			<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
							<thead class="theadTransacColor">
					  			<tr>				
						  		</tr>
							</thead>
						</table>
	               	</div>
				</fieldset>
			</form:form>

	
	</section>
	</div>
	
	
	<script>
		$('#expCountry').multiselect({  // options here
		});
	</script>
	
	<script>
	function resetSelect2(){

		$("#expCountry").select2("val", "0");
		
		
	}
	</script>
<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script> --%>