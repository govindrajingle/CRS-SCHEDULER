<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>
    	   
 <title>Product And Packaging Details</title>   
<script>
$(document).ready(function(){
	//alert("on load");
	//numInvoiceNo premiseName premiseAddress strPremiseName strPremiseAddress numDrugId prodCode strProdName strProdCode strBatchNumber dtExpDate
	//numInvoiceNo numPremisesNo numDrugId strBatchNumber dtExpDate
									$("#frm")
									.bootstrapValidator(
										{
											fields : {
												numInvoiceNo : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Invoice',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('numInvoiceNo').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  siteType : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify site type',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('siteType').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  numPremisesNo : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Premise',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('numPremisesNo').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  numDrugId : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Product',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('numDrugId').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  strBatchNumber : {
													validators : {
														notEmpty : {
															message : "Batch Number is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 3,
															max : 20,
															message : "Batch Number can contain minimum 3 and maximum of 20 characters"
														}
													}
												},
												drugLicense : {
														validators : {
															notEmpty : {
																message: "Drug License is required and can't be emply"
																	},
															regexp : {
																regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
																message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
															},
															stringLength : {
																min : 3,
																max : 30,
																message : "Drug licence can contain minimum 3 and maximum of 30 characters"
															}
														}
													},
													GSTIN : {
															validators : {
																notEmpty : {
																	message: "Please enter your GSTIN number"
																		},
																regexp : {
																	regexp :  /\d{2}[A-Z]{5}\d{4}[A-Z]{1}[A-Z\d]{1}[Z]{1}[A-Z\d]{1}/,
																	message : "Enter Valid GSTIN Number "
																},
																stringLength : {
																	min : 15,
																	max : 15,
																	message : "GSTIN number can contain only 15 characters"
																}
															}
														},
												dtExpDate : {
													selector : '#dtExpDate',
													validators : {
														notEmpty : {
															message : 'The Expiry Date is required'
														}
													}
												}
											}
										});
	
	$("#modify").hide();
	$("#delete").hide(); 
	$("#premiseAddress").prop( "disabled", true );
	$("#prodCode").prop( "disabled", true );
	loadDataTable(1);
	$('#save').click(function() {
		 var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
				
			}
			else{
			} 
		//confirm_alert('Do you Really want to save?','save');
	});

	if('${flagSave}'== 1){
		ok_message("New Record Added Successfully.");
	}
});

</script>


<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		  		{
			"sTitle" : "ID",
			"mData" : "num_procurement_id"
		 },	
		 {
				"sTitle" : "Site Type",
				"mData" : "sitetype"
		},
		{
			"sTitle" : "Invoice Number",
			"mData" : "str_invoice_no"
		},
		{
			"sTitle" : "Source Name",
			"mData" : "str_premises_name"
		},
		
		{
			"sTitle" : "Source Addresss",
			"mData" : "str_address"
		},
		
		{
			"sTitle" : "Product Name",
			"mData" : "str_generic_name"
		},
		{
			"sTitle" : "Product Code",
			"mData" : "str_prod_code"
		},
		{
			"sTitle" : "Batch Number",
			"mData" : "str_batch_number"
		},
		{
			"sTitle" : "Expiry Date",
			"mData" : "expdate"
		},
		{
			"sTitle" : "Drug License Number",
			"mData" : "str_drug_lic_no"
		},
		{
			"sTitle" : "GSTIN",
			"mData" : "str_gstin"
		}
	],
				responsive: !0,
				columnDefs : [
						
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
function loadDataTable(statusID){
	//alert("load data table");
	 $.ajax({
			type:"GET",
			data:{status :statusID},
			url :"getProcurementDetails",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}

function loadPremiseAddress(){
	var manId = $('#premiseName').val();
	$('#premiseAddress').find('option').remove().end();
	$.ajax({
		type : "GET",
		 url : "getManufactreData",
		data : {manId:manId},
	 success : function(response){
		 if(response.length>0){
			 for (var i = 0; i < response.length; ++i) {
				 //alert(response[i].numPremiseNo+"    "+response[i].strAddress);
					$('#premiseAddress').append(
							$('<option/>').prop("value",response[i].numPremiseNo).text(response[i].strAddress));
				}
		 }
	 }
	});
}	

function loadProductCode(){
	var drugId = $('#numDrugId').val();
	$('#prodCode').find('option').remove().end();
	$.ajax({
		type : "GET",
		url : "getProductData",
		data : {drugId:drugId},
		success : function(response){
		 if(response.length>0){
			for (var i = 0; i < response.length; ++i) {
				$('#prodCode').append($('<option/>').prop("value",response[i].numDrugId).text(response[i].drugCode));
			}
		 }
		}
	});
}

function clearFeilds(){    




		location.reload(true);

		
		
	
	
	
	/* $("#numInvoiceNo").val(0);
	$("#premiseName").val(0);
	$("#premiseAddress").val(0);
	$("#numDrugId").val(0);
	$("#prodCode").val(0);
	$("#dtExpDate").val("");
	$("#strPremiseName").val("");
	$("#strPremiseAddress").val("");
	$("#strProdName").val("");
	$("#strProdCode").val("");
	$('#strBatchNumber').val(""); */
	$("input[name='uid']").prop('checked', false);
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
	document.getElementById("frm").action = "${pageContext.request.contextPath}/saveProcurementDetails";
	document.getElementById("frm").method = "POST";
	$("#frm").submit();
}
</script>

<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Product and Packaging Details</h1>
		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm" modelAttribute="procurementMstModel" autocomplete="off">
				<form:hidden path="numProcurementId" id ="numProcurementId" ></form:hidden>	
				<form:input type="hidden" id="radio" path="radio" />
				<sec:csrfInput/>
				<div class="panel panel-default " id="">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Add Packaging Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
							
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="numInvoiceNo">Export Order:<span style="color:#cd2026;">*</span></label>
										<form:select path="numInvoiceNo" class="form-control" id="numInvoiceNo">
											<form:option value="0">Select Invoice</form:option>
											<c:forEach items="${expOrder}" var="c">
												<option value='${c.exp_id}'> ${c.invoice_no}</option>
											</c:forEach>
										</form:select>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="siteTypeId">Site Type:<span style="color:#cd2026;">*</span></label>
										<form:select path="siteType" class="form-control" id="siteTypeId">
											<form:option value="0">Select Address Type</form:option>
											<form:option value="1">Own Site</form:option>
											<form:option value="2">Loan Site</form:option>
											<form:option value="3">Whole-Sale Site</form:option>
										</form:select>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="premiseName">Procurement Source Name:</label>
										<form:select path="numPremisesNo" class="form-control" id="premiseName" onchange="loadPremiseAddress();">
											<form:option value="0">Select Premise Name</form:option>
											<c:forEach items="${instPreDtls}" var="c">
												<option value='${c.numPremiseNo}'>${c.premiseName}</option>
											</c:forEach>
										</form:select>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="premiseAddress">Procurement Source Address:</label>
										<form:select path="" class="form-control" id="premiseAddress">
											<form:option value="0">Select Premise Address</form:option>
											
										</form:select>	
									</div>
								</div>
						
								<%-- <div class=" col-lg-6 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="">Procurement Source Name:<span style="color:#cd2026;">*</span></label>
									<form:input path="strPremiseName" type="text" class="form-control" id="strPremiseName" placeholder="Enter Source Name"/>	
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="">Procurement Source Address:<span style="color:#cd2026;">*</span></label>
									<form:input path="strPremiseAddress" type="text" class="form-control" id="strPremiseAddress" placeholder="Enter Source Address"/>	
								</div> --%>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="numDrugId">Product Name:<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:select path="numDrugId" class="form-control" id="numDrugId" onchange="loadProductCode();">
											<form:option value="0">Select Drug </form:option>
											<c:forEach items="${getProductNames}" var="c">
												<option value='${c.numDrugId}'> ${c.strGenericName}</option>
											</c:forEach>
										</form:select>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="prodCode">Product Code:</label>
										<form:select path="" class="form-control" id="prodCode">
											<form:option value="0">Select Product Code </form:option>
											
										</form:select>	
									</div>
								</div>
								
								<%-- <div class=" col-lg-6 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="">Product Name:<span style="color:red;">*</span></label>
									<form:input path="strProdName" type="text" class="form-control" id="strProdName" placeholder="Enter Product Name"/>	
								</div>
							
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="">Product Code:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="strProdCode" type="text" class="form-control" id="strProdCode" placeholder="Enter Product Code"/>	
								</div> --%>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="strBatchNumber">Batch Number:<span style="color:#cd2026;">*</span></label>
										<form:input path="strBatchNumber" type="text" class="form-control" id="strBatchNumber" placeholder="Enter Batch Number"/>	
									</div>
								</div>
								
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="dtExpDate">Expiry Date<span style="color: #cd2026;">*</span></label>
										<div class="form-group">
	        								<div class='input-group date' id=''>	
	        									<form:input path="dtExpDate" type="date" class="form-control" value="" id="dtExpDate" placeholder=""/>
	          								</div>
	      								</div>
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="drugLicense">Drug License:<span style="color:#cd2026;">*</span></label>
										<form:input path="drugLicense" type="text" class="form-control" id="drugLicense" placeholder="Enter Drug License"/>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="GSTIN">GSTIN Number:<span style="color:#cd2026;">*</span></label>
										<form:input path="GSTIN" type="text" class="form-control" id="GSTIN" placeholder="Enter GSTIN Number"/>	
									</div>
								</div>
								
							</div>
						</div>
				</div>
				
				
				<div class="text-center">
					<button type="button" class="custom-btn position-relative" id="save"> Save </button>
                	<button type="button" id="modify" class="btn_default bnt-success">Modify</button>
					<button type="button" id="delete" class="btn_default btn-danger">Delete</button>
					<button type="reset" class="btn_default" id="reset" onclick = "clearFeilds()"> Reset </button>
               	</div>
               	
               		<fieldset class="mt-2">
               	<div class="section-title"><h2>Procurement List</h2></div>
               	<div class="bg_white">
               			<table class="w-100 table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered dspit" id="m_table_1" style="margin-top: 1%;width:100%;">
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
	<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script>
</body>
</html>