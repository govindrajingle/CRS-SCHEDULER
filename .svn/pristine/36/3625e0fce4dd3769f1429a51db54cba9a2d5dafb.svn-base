<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>exportOrder</title>
	<div class="content-wrapper mt-0 pt-0">
		<section class="regdv content content-tiles">
			<div class="page-title">
				<h1 class="fw-bold">Shipment Details</h1>
			</div>
			<form:form  id="frm" name="frm" modelAttribute="exportOrderModel" method="POST" autocomplete="off">
				<c:forEach items="${errors }" var="error">
        			<div class="alert alert-success" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<div class="text-danger">
						<c:out value="${error }"/>
						</div>
					</div>	
				</c:forEach>
				
				<div class="panel panel-default " id="distributionDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Add Shipment Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_name">Export Reference Number:<span style="color:cd2026;">*</span></label>
										<form:input type="text" path="invoice_no"  class="form-control" id="loc_name" placeholder="Enter Export Reference Number"/> 	
									</div>
								</div>


				 				<div class=" col-lg-6 col-md-12 col-sm-12 col">
					 				<div class="form-group">
										<label class="dvfrm-label" for="desig">Export Reference Date:<span style="color:cd2026;">*</span></label>
										 <form:input type="date" path="invoice_date"  class="form-control" id="desig" placeholder="Enter Export Reference Date"/> 	
									</div> 
								</div> 
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="productId">Product Name:<span style="color:cd2026;">*</span></label>
											<form:select path="productId" id="productId" class="custom-select js-example-basic-multiple"
																multiple="multiple" onchange="productNameChange(this.value)">
											<!--	<form:option value="0">-select Product Name-</form:option> -->
												<c:forEach items="${getProductNames}" var="p">
													<form:option value="${p.numDrugId}">${p.strGenericName}</form:option>
												</c:forEach>
												<form:option value="-1">other</form:option>
											</form:select>
											<div id="productNameDiv" style="display: none;">
												<form:input type="text" path="productName"  class="form-control" id="productName" placeholder="Enter Product Name" aria-label="productName"/>
											</div>		
									</div>
								</div>

							  	<div class=" col-lg-6 col-md-12 col-sm-12 col">
								  	<div class="form-group">
										<label class="dvfrm-label" for="exportingRegion">Destination Region:<span style="color:cd2026;">*</span></label>
											<form:select path="exportingRegion" id="exportingRegion" class="form-control" onchange="getCountryBasedOnRegion(this.value)">
												<form:option value="0">-select Export region-</form:option>
												<c:forEach items="${regionDtls}" var="p">
													<form:option value="${p.numRegionId}">${p.strRegionName}</form:option>
												</c:forEach>
												<%-- <form:option value="-1">other</form:option> --%>
											</form:select>
									</div>							
								</div>							
				
								 <div class=" col-lg-6 col-md-12 col-sm-12 col">
									 <div class="form-group">
											<label class="dvfrm-label" for="exportingCountry">Destination Country :<span style="color:cd2026;">*</span></label>
												<form:select path="country_id" class="custom-select js-example-basic-multiple"
																	multiple="multiple" id="exportingCountry">
													<form:option value="0">-select country-</form:option>
												</form:select>	 
									 </div>	
								 </div>	

			  <%-- <div class=" col-lg-6 col-md-12 col-sm-12 col">
			  	<div class="form-group">
					<label class="dvfrm-label" for="pincode">Exporting Country Address:<span style="color:cd2026;">*</span></label>
	     			<form:input path="ExportingCountryAddress" type="text" class="form-control" id="pincode" placeholder="Enter ExportingCountryAddress"/>
	     			</div>	
	     			</div>	
							 		
			  <div class=" col-lg-6 col-md-12 col-sm-12 col">
			  	<div class="form-group">
								<label class="dvfrm-label" for="contactno">Exporting Country Contact<span style="color:cd2026;">*</span></label>
								
			<form:input path="ExportingCountryContact" type="text" class="form-control" id="contactno" name="strLandlineNo"  placeholder="STD Code - Contact Number"/>	
								
			</div>
			</div>	 --%>
								
			
				

				</div>

				<div class="text-center">
					<button type="button" id="save" class="custom-btn position-relative">Save</button>
					<button type="button" id="cancel" class="btn_default">Cancel</button>
				</div>
									</div>
							</div>


				<fieldset class="mt-2">
	               <div class="section-title">	<h2>Export Order Details List</h2></div>
	               <div class="bg_white">
	               	<table class="w-100 table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered" id="m_table_1">
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
	
	<script type="text/javascript">
		function productNameChange(productId) {
			if(productId!=null && productId=='-1'){
				$('#productNameDiv').show();
			}else{
				$('#otherproductName').val('');
				$('#productNameDiv').hide();
			}
		}
		
		function getCountryBasedOnRegion(regionId) {
				$.ajax({
					type:"GET",
					url :"countrybasedOnRegion",
					data:{regionId:regionId},
				 success: function (response) {
					 for(var country in response){
						 $('#exportingCountry').append($("<option></option>").attr("value",response[country].num_country_id).text(response[country].str_country_name));
						 
					 }
				}
			});
		}
	</script>
	<script>
$(document).ready(function(){

	                               $("#frm")
									.bootstrapValidator({
											fields : {
												invoice_no : {
													validators : {
														notEmpty : {
															message : "Invoice Number is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+(?<![/.,()-]{2})$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 3,
															max : 20,
															message : "Invoice number can contain minimum 3 and maximum of 20 characters"
																
														}
													}
												},
												productName : {
														validators : {
															notEmpty : {
																message : "Invoice Number is required and can\'t be empty"
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
												invoice_date : {
														validators : {
															notEmpty : {
																message : "Invoice date is required and can\'t be empty"
															},stringLength : {
																min : 1,
																max : 50,
																message : "Designation can contain maximum of 50 characters"
															}
														}
													},country_id : {
										 				validators : {
										 					callback: {
										 				           message: 'Please specify country',
										 				           callback: function(value, validator, $field) {
										 				               
										 				               var options = validator.getFieldElements('exportingCountry').val();

										 				               return (options != 0);
										 				           }
										 					}
										 				}
												  },exportingRegion : {
										 				validators : {
										 					callback: {
										 				           message: 'Please specify country',
										 				           callback: function(value, validator, $field) {
										 				               
										 				               var options = validator.getFieldElements('exportingRegion').val();

										 				               return (options != 0);
										 				           }
										 					}
										 				}
												  },ExportingCountryAddress : {
														validators : {
															notEmpty : {
																message : "Address  is required and can\'t be empty"
															},
															regexp : {
																regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
																message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
															},
															stringLength : {
																min : 1,
																max : 100,
																message : "Address name  can contain maximum of 100 characters"
															}
														}
													},ExportingCountryContact : {
														validators : {
															notEmpty : {
																message : "Multiple Contect number can be Added"
															},
															regexp : {
																regexp :  /^[0-9().\/,\s\-]+$/,
																message : "Only  numbers are permitted"
															},
															stringLength : {
																min : 1,
																max : 50,
																message : "Contact Number  can contain maximum of 50 characters"
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
	});

	
	let flagSave='${flagSave}';
	if(flagSave== '1'){
		ok_message("New Record Added Successfully.");
		loadDataTable(1);
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
								//alert("check 2222222222222");					
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
		
		document.getElementById("frm").action = "${pageContext.request.contextPath}/exportOrder";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}

});

</script>
<script>
	$('#m_select2_7').multiselect({  // options here
	});
</script>

<script>
	$('.js-example-basic-multiple').select2({
				multiple : true,
				placeholder : '-- Select --',
				allowClear : true
			});

</script>

<script type="text/javascript">

function loadDataTable(statusID){
	//alert("load data table");
	 $.ajax({
			type:"GET",
			data:{status :statusID},
			url :"getExportOrderDetails",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}
function resetAndDrawTable(dataTableId,data,statusID){
	var sizeWidth,sizeHeight;
		sizeWidth="100%";
		sizeHeight="100%";
		if ( ! $.fn.DataTable.isDataTable( dataTableId ) ) {
	var table = initTable(dataTableId,sizeWidth,sizeHeight,statusID);
		}
		else
		var table=dataTableId.DataTable();
	table.clear().draw();
	table.rows.add(data); // Add new data
	table.columns.adjust().draw();
}


function initTable(id,x_size,y_size,statusID){
	
	var Table = $(id).DataTable({

		columns: [
		  		{
			"sTitle" : "ID",
			"mData" : "num_exp_id"
		 },	
		/* {
			"sTitle" :"Address",
			"mData" : "str_exp_comp_add"
		},
		{
			"sTitle" : "Contact",
			"mData" : "str_exp_comp_contact"
		}, */
		{
			"sTitle" : "Country",
			"mData" : "str_country_name"
		},
		{
			"sTitle" : "Invoice Date ",
			"mData" : "invoicedate"
		},
		{
			"sTitle" : "Region",
			"mData" : "str_region_name"
		},
		{
			"sTitle" : "Shipment/Exp Reference Number",
			"mData" : "str_invoice_no"
		},
		{
			"sTitle" : "Product",
			"mData" : "str_generic_name"
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
							"targets": [],
			                 "className": "none",
			             	  
			             }],
    	
	});
	return Table;
}
	
	
function accept(id){
	//alert("accpt  - "+id)
}
</script>



	<!-- File Upload -->
	<script src="js/homepage/jquery.ui.widget.js"></script>
	<script src="js/homepage/jquery.iframe-transport.js"></script>
	<script src="js/homepage/jquery.fileupload.js"></script>	
	<script src="js/homepage/select2.js"></script> 
	<script src="js/homepage/select2.min.js"></script>
	
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