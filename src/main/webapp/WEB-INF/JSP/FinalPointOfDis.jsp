<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>Add Point Of Distribution</title>
<script>
$(document).ready(function(){
	//alert("on load");
			loadDataTable(1);
			$('.js-example-basic-multiple').select2({
				multiple : true,
				placeholder : '-- Select --',
				allowClear : true
			});
	 	      	
			$('#hsCode').select2();		 		
			$('#toCountry').select2();	
			$('#fromCountry').select2();		

			$("#frm")
			.bootstrapValidator(
				{
					fields : {
						genName : {
			 				validators : {
			 					callback: {
			 				           message: 'Please specify Generic Name',
			 				           callback: function(value, validator, $field) {
			 				               
			 				               var options = validator.getFieldElements('genName').val();

			 				               return (options != 0);
			 				           }
			 					}
			 				}
					  }, 
					  hsCode : {
			 				validators : {
			 					callback: {
			 				           message: 'Please specify H S Code',
			 				           callback: function(value, validator, $field) {
			 				               
			 				               var options = validator.getFieldElements('hsCode').val();

			 				               return (options != 0);
			 				           }
			 					}
			 				}
					  }, 
					  goodsName : {
							validators : {
								notEmpty : {
									message : " Name is required and can\'t be empty"
								},
								regexp : {
									regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
									message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
								},
								stringLength : {
									min : 1,
									max : 50,
									message : " Name can contain maximum of 50 characters"
								}
							}
						},
						goodsAdd : {
							validators : {
								notEmpty : {
									message : " Address is required and can\'t be empty"
								},
								regexp : {
									regexp : /^(?!.*\d{3})(?!.*[/.,()\-]{2})[a-zA-Z0-9().\/,\s\-]+$/,
									message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted, consecutive special characters not allowed"
								},
								stringLength : {
									min : 1,
									max : 250,
									message : " Address can contain maximum of 250 characters"
								}
							}
						}, 
						goodsCity : {
							validators : {
								notEmpty : {
									message : "City is required and can\'t be empty"
								},
								regexp : {
									regexp : /^[a-zA-Z]+$/,
									message : "Only alphabets and white spaces are permitted"
								},
								stringLength : {
									min : 2,
									max : 50,
									message : "City can contain maximum of 50 characters"
								}
							}
						},
						pinCode : {
							validators : {
								notEmpty : {
									message : "Pin Code or Postal Code is required and can't be empty"
								},
								regexp : {
									regexp : /^[0-9().\/,\s\-]+$/,
									message : 'Only numbers are permitted'
								},
								stringLength : {
									min : 6,
									max : 6,
									message : 'Pin Code or Postal Code can contain only 6 digits.'
								}
							}
						},
						expReg : {
			 				validators : {
			 					callback: {
			 				           message: 'Please specify exporting region',
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
			 				           message: 'Please specify exporting country',
			 				           callback: function(value, validator, $field) {
			 				               
			 				               var options = validator.getFieldElements('listExpCountry').val();

			 				               return (options != 0);
			 				           }
			 					}
			 				}
					  	},
					  	meansTransport : {
			 				validators : {
			 					callback: {
			 				           message: 'Please specify mode of transport.',
			 				           callback: function(value, validator, $field) {
			 				               
			 				               var options = validator.getFieldElements('meansTransport').val();

			 				               return (options != 0);
			 				           }
			 					}
			 				}
					  	},
					  	fromCity : {
							validators : {
								notEmpty : {
									message : "City is required and can't be empty"
								},
								regexp : {
									regexp : /^[a-zA-Z]+$/,
									message : "Only alphabets and white spaces are permitted"
								},
								stringLength : {
									min : 2,
									max : 50,
									message : "City can contain maximum of 50 characters"
								}
							}
						},
						fromCountry : {
			 				validators : {
			 					callback: {
			 				           message: 'Please specify country',
			 				           callback: function(value, validator, $field) {
			 				               
			 				               var options = validator.getFieldElements('fromCountry').val();

			 				               return (options != 0);
			 				           }
			 					}
			 				}
					  	},
					  	toCity : {
							validators : {
								notEmpty : {
									message : "City is required and can't be empty"
								},
								regexp : {
									regexp : /^[a-zA-Z]+$/,
									message : "Only alphabets and white spaces are permitted"
								},
								stringLength : {
									min : 1,
									max : 50,
									message : "City can contain maximum of 50 characters"
								}
							}
						},           
						toCountry : {
			 				validators : {
			 					callback: {
			 				           message: 'Please specify country',
			 				           callback: function(value, validator, $field) {
			 				               
			 				               var options = validator.getFieldElements('toCountry').val();

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
						confirm_alert('Do you really want to save?','save');
						
					}
					else{
					}
			});

			if ('${flagSave}' == 1) {
				ok_message("Record Saved Successfully.");
			}
			
			
	
});

//Govind's edit to remove the ERROR OF SUBMITTING FORM AFTER PRESSING ENTERY ON EMPTY FIELD
$(window).keydown(function(event){
  if(event.keyCode == 13) {
    event.preventDefault();
    return false;
  }
});

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
			"sTitle" : "Generic Name",
			"mData" : "str_genric_name"
		},
		{
			"sTitle" : "H S Code",
			"mData" : "hscode"
		},
		{
			"sTitle" : "Goods Consigned Name",
			"mData" : "str_goods_name"
		},
		{
			"sTitle" : "Goods Consigned Address",
			"mData" : "str_goods_address"
		},
		{
			"sTitle" : "Goods Consigned City",
			"mData" : "str_goods_city"
		},
		{
			"sTitle" : "Pin Code",
			"mData" : "str_pincode"
		},
		{
			"sTitle" : "Region",
			"mData" : "str_region_name"
		},
		{
			"sTitle" : "Countries of Distrubution",
			"mData" : "countryname"
		},
		{
			"sTitle" : "Means Of Transport",
			"mData" : "transport"
		},
		{
			"sTitle" : "Transport from City",
			"mData" : "str_from_transport_city"
		},
		{
			"sTitle" : "Transport from Country",
			"mData" : "from_transport_country"
		},
		{
			"sTitle" : "Transport to City",
			"mData" : "str_to_transport_city"
		},
		{
			"sTitle" : "Transport to Country",
			"mData" : "to_transport_country"
		}
	],
				responsive: !0,
				columnDefs : [
						{
							"targets": [7,8,9,10,11,12,13],
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
			url :"getAllPointOfDistDetails",
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
	document.getElementById("frm").action = "${pageContext.request.contextPath}/saveDistrubutionPoints";
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
			<div class="page-title"><h1 class="fw-bold">Add Point Of Distribution</h1></div>
					<form:form method="post" id="frm" name="frm"
						modelAttribute="distributionModel" autocomplete="off">
						<sec:csrfInput />

						<div class="panel panel-default" id="pointDistributionDetails">
							<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>Add Point Of Distribution Details</b>
							</div>

							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="genName">Generic Name:<span
												 style="color:#cd2026;">*</span></label>
											<form:select path="genName" class="form-control" id="genName">
												<form:option value="0">Select Generic Name</form:option>
												<c:forEach items="${getProductNames}" var="c">
													<option value='${c.numDrugId}'>${c.strGenericName}</option>
												</c:forEach>getProductNames
										</form:select>
										</div>
									</div>
									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="hsCode">H S Code:<span
												 style="color:#cd2026;">*</span></label>
											<form:select path="hsCode" class="form-control" id="hsCode">
												<form:option value="0">Select H S Code</form:option>
												<c:forEach items="${hsCodeDtls}" var="c">
													<option value='${c.numHSCode}'>${c.numHSCode}
														${c.strCommodityName}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- distribution details -->
						<div class="panel panel-default " id="distributionDetails">
							<div
								class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>Add Distribution Details</b>
							</div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="goodsName">Goods Consigned Name:<span
												 style="color:#cd2026;">*</span></label>
											<form:input path="goodsName" type="text" class="form-control"
												id="goodsName" placeholder="Enter Name" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="goodsAdd">Goods Consigned Address:<span
												 style="color:#cd2026;">*</span></label>
											<form:textarea path="goodsAdd" type="text"
												class="form-control" id="goodsAdd"
												placeholder="Enter Address" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="goodsCity">Goods Consigned City:<span
												 style="color:#cd2026;">*</span></label>
											<form:input path="goodsCity" type="text" class="form-control"
												id="goodsCity" placeholder="Enter City" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="pinCode">Goods Consigned Zip/Postal
												Code:<span  style="color:#cd2026;">*</span>
											</label>
											<form:input path="pinCode" type="text" class="form-control"
												id="pinCode" placeholder="Enter Zip/Postal Code" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="expReg">Exports Region:<span
												 style="color:#cd2026;">*</span></label>
											<form:select path="expReg" class="form-control" id="expReg"
												onchange="getCountryBasedOnRegion();">
												<form:option value="0">Select Exports Region</form:option>
												<c:forEach items="${region}" var="c">
													<option value='${c.numRegionId}'>
														${c.strRegionName}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group	">
											<label class="dvfrm-label" for="expCountry">Exports Country:<span
												 style="color:#cd2026;">*</span></label>
											<form:select class="custom-select js-example-basic-multiple"
												multiple="multiple" id="expCountry" path="listExpCountry">

											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="panel panel-default " id="transportDetails">
							<div
								class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading">
								<b>Add Transport Details</b>
							</div>
							<div class="panel-body dvfrm-panel-body">
								<div class="row">
									<div class=" col-md-12">
										<div class="form-group">
											<label class="dvfrm-label" for="meansTransport">Means of Transport:<span
												 style="color:#cd2026;">*</span></label>
											<form:select path="meansTransport" class="form-control"
												id="meansTransport">
												<form:option value="0">Select Mode of Transport</form:option>
												<form:option value="1">Air</form:option>
												<form:option value="2">Sea</form:option>
											</form:select>
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="fromCity">From City:<span
												 style="color:#cd2026;">*</span></label>
											<form:input path="fromCity" type="text" class="form-control"
												id="fromCity" placeholder="Enter City" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="fromCountry">From Country:<span
												 style="color:#cd2026;">*</span></label>
											<form:select path="fromCountry" class="form-control"
												id="fromCountry">
												<form:option value="0">Select Country</form:option>
												<c:forEach items="${country}" var="c">
													<option value='${c.num_country_id}'>
														${c.str_country_name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>

								</div>

								<div class="row">
									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="toCity">To City:<span
												 style="color:#cd2026;">*</span></label>
											<form:input path="toCity" type="text" class="form-control"
												id="toCity" placeholder="Enter City" />
										</div>
									</div>

									<div class="col-lg-6 col-md-12 col-sm-12 col">
										<div class="form-group">
											<label class="dvfrm-label" for="toCountry">To Country:<span
												 style="color:#cd2026;">*</span></label>
											<form:select path="toCountry" class="form-control"
												id="toCountry">
												<form:option value="0">Select Country</form:option>
												<c:forEach items="${country}" var="c">
													<option value='${c.num_country_id}'>
														${c.str_country_name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="text-center">
							<button type="button" class="custom-btn position-relative" id="save">
								Save</button>
							<button type="reset" class="btn_default" id="reset" onclick= "resetSelect2()" >
								Reset</button>
						</div>

						<fieldset class="mt-2 border-0 p-0">
							<div class="section-title"><h2>Points of Distribution List</h2></div>
							<div class="bg_white">
								<table
								class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed"
								id="m_table_1">
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

		location.reload(true);

		/* $("#fromCountry").select2("val", "0");
		$("#toCountry").select2("val", "0");
		$("#expCountry").select2("val", "0");
		$("#hsCode").select2("val", "0"); */
		
		
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