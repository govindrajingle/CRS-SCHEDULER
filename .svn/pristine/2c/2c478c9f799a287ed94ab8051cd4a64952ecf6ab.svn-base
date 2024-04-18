<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%>
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>Location Master</title>
<script type="text/javascript" src="js/validation/customValidation.js"></script>
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<script type="text/javascript" src="js/globalJs/globalJs.js"></script>


<!-- Creating token and validating with FormFieldValidationFilter.java G9 -->

<script>
var token_key = "NMD_TOKEN_KEY";

var createFHash = function(frmName){

   //alert("createFHash in same");
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
$(document).ready(function(){
	//alert("in location");
	      
							$("#frm")
									.bootstrapValidator({
											fields : {
												loc_type : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Location Type',

																 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('loc_type').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  loc_name : {
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
															max : 20,
															message : "Name can contain maximum of 20 characters"
														}
													}
												},
												loc_add : {
													validators : {
														notEmpty : {
															message : "Address is required and can\'t be empty"
														},
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 1,
															max : 250,
															message : "Address can contain maximum of 250 characters"
														}
													}
												},
												loc_country : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Country',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('loc_country').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  loc_state : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify State',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('loc_state').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  }, 
											  loc_dist : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify District',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('loc_dist').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  },
											  loc_zone : {
									 				validators : {
									 					callback: {
									 				           message: 'Please specify Zone',
									 				           callback: function(value, validator, $field) {
									 				               
									 				               var options = validator.getFieldElements('loc_zone').val();

									 				               return (options != 0);
									 				           }
									 					}
									 				}
											  },  
											  loc_short_Name : {
													validators : {
														regexp : {
															regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
															message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
														},
														stringLength : {
															min : 1,
															max : 50,
															message : "Short Name can contain maximum of 50 characters"
														}
													}
												},
												contactPersonName : {
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
												loc_contact_dtls : {
													validators : {
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
												
												loc_fax_dtls : {
													validators : {
														regexp : {
															regexp : /^[0-9().\/,\s\-]+$/,
															message : 'Only numbers are permitted'
														},

														stringLength : {
															min : 1,
															max : 6,
															message : 'Contact Number can contain minimum 1 and maximum of 6 characters'
														}
													}
												},
												loc_email : {
													validators : {
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
												}
											}
									
						});
								//Govind's edit to remove the ERROR OF SUBMITTING FORM AFTER PRESSING ENTERY ON EMPTY FIELD
									$(window).keydown(function(event) {
										if (event.keyCode == 13) {
											event.preventDefault();
											return false;
										}
									});
				
	loadDataTable(1);
	$("#modify").hide();
	$("#delete").hide();
	$('#save').click(function() {
		//alert("in save");
		var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
			}
			else{
			}
	});

	$('#modify').click(function() {
			//var selectedval=$('input[name=uid]:checked', '#frm').val();
			var selectedval = $("input[name=uid]:checked"). val();
			//alert(selectedval);
			var checked = [];
			//alert("in mod");
			$('#numlocationId').val(selectedval);
			
			$(".radio:radio").each(function() {
				if (this.checked) {
					checked.push($(this).val());
				}
			});
			$("#radio").val(checked);
			if (checked.length > 0) {
				//alert($('#numlocationId').val());
				 var bV = $("#frm").data('bootstrapValidator');
				   bV.validate();
					if(bV.isValid()){ 
						$("#radio").val(checked);
						confirm_alert('Do you Really want to modify?','modify');
					}
					else{
					}
			} else {

			}

		});

	$('#delete').click(function() {
				var checked = [];
				$(".radio:radio").each(function() {
					if (this.checked) {
						checked.push($(this).val());
					}
				});
				$("#radio").val(checked);
				if (checked.length > 0) {
					$("#radio").val(checked);

					confirm_alert('Do you Really want to delete?','delete');

				} else {

				}
	});

	$(document).on('click','#radio',function(e){
			        $("#save").prop("style").display="none";
			        $("#modify").show();
			        $("#delete").show();
				   
				 var resultArray1 = $(this).closest('tr').find('td').map( function(){
							return $(this).text();
						}).get();
				 var checkID = $(this).closest('tr').find('input[type=radio]').map( function(){
							return $(this).val();
						}).get();
				//alert(resultArray1[1]);
				 $('#loc_type').each(function () {
					$('option', this).each(function () {
						if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[1]).toLowerCase()) 
						{
							$(this).prop('selected', 'selected');
							return false;
						};
					});
				}); 

				 $('#loc_name').val(resultArray1[2]);
					
				 $('#loc_short_Name').val(resultArray1[3]);
				
				 $('#loc_add').val(resultArray1[4]);
				 
				 
					 $('#loc_country').each(function () {
							$('option', this).each(function () {
							if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[5]).toLowerCase()) 
							{
								$(this).prop('selected', 'selected');
								return false;
							};
							});
					}); 

					 $('#loc_zone').each(function () {
							$('option', this).each(function () {
							if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[6]).toLowerCase()) 
							{
								$(this).prop('selected', 'selected');
								return false;
							};
							});
					}); 

					 $('#loc_state').each(function () {
							$('option', this).each(function () {
								
							if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[7]).toLowerCase()) 
							{
								
								$(this).prop('selected', 'selected');
								  loadDistrict(resultArray1[8]);
								return false;
							};
							});
					});

					 setTimeout(function() {
						 
						   $('#loc_dist').each(function (){
							  
								$('option', this).each(function () {
									
								if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[8]).toLowerCase()) 
								{
									
									$(this).prop('selected', 'selected');
									return false;
								}
								});
								});
					}, 1000);

					 $('#contactPersonName').val(resultArray1[12]);
						
						$('#loc_email').val(resultArray1[11]);
						
						$('#loc_contact_dtls').val(resultArray1[9]);
						
						$('#loc_fax_dtls').val(resultArray1[10]);
     });

	if ('${flagSave}' == 1) {
		ok_message("Record Saved Successfully.");
	}

	if ('${flagUpdate}' == 1) {
		ok_message("Record Updated Successfully.");
	}

	if ('${flagDelete}' == 1) {
		ok_message("Record Deleted Successfully.");
	}
	
});

function loadDistrict(stateId){ 
 
	var stateId=$('#loc_state').val(); 
						   
	//alert(stateId);
 
 
 //added by harshita
	$('#loc_dist')
		    .find('option')
		    .remove()
		    .end() 
		
		$.ajax({
			type : "GET",
			 url : "getDistrictData",
			data : {stateId:stateId},
		 success : function(response){
			 if(response.length>0){
			
				 for(var userlist in response){
					 $('#loc_dist').append($("<option></option>").attr("value",response[userlist].num_district_id).text(response[userlist].str_district_name));
				 }  
				 
			 }
		 }
	});
}


</script>

<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		  		{
			"sTitle" : "",
			"mData" : "num_loc_id"
		 },	
		{
			"sTitle" : "Location Type",
			"mData" : "str_inst_type_name"
		},
		{
			"sTitle" : "Location Name",
			"mData" : "str_loc_name"
		},
		
		{
			"sTitle" : "Short Name",
			"mData" : "str_short_name"
		},
		
		{
			"sTitle" : "Location Address",
			"mData" : "str_address"
		},
		
		
		{
			"sTitle" : "Country",
			"mData" : "str_country_name"
		},
		
		{
			"sTitle" : "Zone",
			"mData" : "zones"
		},

		{
			"sTitle" : "State",
			"mData" : "states"
		},

		{
			"sTitle" : "District",
			"mData" : "district"
		},
		{
			"sTitle" : "Mobile No.",
			"mData" : "num_mob_no"
		},
		
		{
			"sTitle" : "Fax No.",
			"mData" : "str_fax_no"
		},
		
		{
			"sTitle" : "E-mail",
			"mData" : "str_email_id"
		},
		{
			"sTitle" : "Contact Person Name",
			"mData" : "str_officer_name"
		}
				],
				responsive: !0,
				columnDefs : [
						{
							'targets' : 0,
							'searchable' : true,
							'orderable' : true,
							'className' : 'dt-body-top',
							'render' : function(
									data, type, row) {
								return '<input type="radio" class="radio" aria-label="Radio Select table row" name="uid" id ="radio"'
										+ row.num_loc_id
										+ '" value="'
										+ $('<div/>').text(data).html()
										+ '">';
										
							}
						},
						{
							"targets": [5,7,8,9,10,11],
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
			url :"getLocationMaster",
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
								 delete_form();
								}
							else if(type=="modify")
							{
								update_form();
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
	
	createFHash("frm");
	document.getElementById("frm").action = "${pageContext.request.contextPath}/saveLocationType";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit(); 
}

function update_form(){
	
	createFHash("frm");
	document.getElementById("frm").action = "${pageContext.request.contextPath}/updateLocationMaster";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

function delete_form(){
	
	createFHash("frm");
	document.getElementById("frm").action = "${pageContext.request.contextPath}/deleteLocation";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}
</script>

<div class="content-wrapper mt-0 pt-0">
	<div class="regdv content content-tiles">
		<div class="page-title"><h1 class="fw-bold">User Location Details</h1></div>

			<!--begin::Portlet-->
			<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
				<div class="m-portlet__body">
					<form:form id="frm" name="frm" modelAttribute="locationMasterForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" autocomplete="off">
					<c:forEach items="${errors }" var="error">
						<div class="alert alert-success" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<div class="text-danger">
								<c:out value="${error }"></c:out>
							</div>
						</div>
					</c:forEach>

					<div class="panel panel-default">
						<div class="panel-body dvfrm-panel-body">
							<form:hidden path="numlocationId" id="numlocationId" aria-label="Num location Id"></form:hidden>
							<form:input type="hidden" id="radio" path="radio" aria-label="Radio Btn"/>

							<div class="row">
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_type">User Type<span
											style="color: #cd2026;">*</span></label>
										<form:select class="form-control m-input" name="loc_type"
											id="loc_type" path="loc_type" selectcheck="true">
											<option value="0">Select</option>
											<c:forEach items="${instType}" var="c">
												<option value='${c.numInstTypeId}'>
													${c.strInstTypeName}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>

								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_name">Location Name<span
											style="color: #cd2026;">*</span></label>
										<form:input type="text" path="loc_name"
											class="form-control m-input" id="loc_name"
											placeholder="Enter Location Name" />

									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_short_Name">Location Short Name</label>
										<form:input type="text" path="loc_short_Name"
											class="form-control m-input" id="loc_short_Name"
											placeholder="Enter Name" />

									</div>
								</div>

								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_add">Location Address<span
											style="color: #cd2026;">*</span></label>
										<form:input type="text" path="loc_add"
											class="form-control m-input" id="loc_add"
											placeholder="Enter Address" />

									</div>
								</div>
							</div>

							<div class="row" id="notManu">
								<div class="col-lg-3 col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_country">Country<span
											style="color: #cd2026;">*</span></label>
										<form:select class="form-control m-input" id="loc_country"
											path="loc_country" selectcheck="true">
											<option value="193" Selected>India</option>
										</form:select>
									</div>
								</div>

								<div class="col-lg-3 col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_zone">Zone<span
											style="color: #cd2026;">*</span></label>
										<form:select class="form-control m-input" name="loc_zone"
											id="loc_zone" path="loc_zone" selectcheck="true">
											<option value="0">Select</option>
											<c:forEach items="${zone}" var="c">
												<option value='${c.zoneId}'>${c.zoneName}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>

								<div class="col-lg-3 col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_state">State<span
											style="color: #cd2026;">*</span></label>
										<form:select class="form-control m-input" name="loc_state"
											id="loc_state" path="loc_state" selectcheck="true"
											onchange="loadDistrict();">
											<option value="0">Select</option>
											<c:forEach items="${state}" var="c">
												<option value='${c.num_state_id}'>
													${c.str_state_name}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>

								<div class="col-lg-3 col-md-6 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_dist">District<span
											style="color: #cd2026;">*</span></label>
										<form:select class="form-control m-input" id="loc_dist"
											path="loc_dist">
											<option value="0">Select</option>
										</form:select>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="contactPersonName">Contact Person Name</label>
										<form:input type="text" path="contactPersonName"
											class="form-control m-input" id="contactPersonName"
											placeholder="Enter Name" />

									</div>
								</div>

								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_contact_dtls">Mobile No.</label>
										<form:input type="text" path="loc_contact_dtls"
											class="form-control m-input" id="loc_contact_dtls"
											placeholder="State Code - Contact Number"
											autocomplete="off" />

									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_fax_dtls">Fax No.</label>
										<form:input type="text" path="loc_fax_dtls"
											class="form-control m-input" id="loc_fax_dtls"
											placeholder="State Code - Fax Number" />

									</div>
								</div>

								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="loc_email">Email</label>
										<form:input type="email" path="loc_email"
											class="form-control m-input" id="loc_email"
											placeholder="E-mail" autocomplete="off" />

									</div>
								</div>
							</div>
						</div>
						<div class="text-center pb-3">
							<button type="button" id="save" class="custom-btn position-relative">Save	</button>
							<button type="button" id="modify" class="btn_default btn-success">Modify</button>
							<button type="button" id="delete" class="btn_default btn-danger">Delete</button>
							<button type="button" id="reset" onclick= "resetSelect2()" class="btn_default">Reset
							</button>
						</div>
					</div>


								</form:form>
							</div>
					<!--end::Portlet-->

			<fieldset class="w-100 mt-4">
				<div class="section-title"><h2 class="fw-bold">Location Details:</h2></div>
				<div class="bg_white p-2" >
					<table class="w-100 table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered"
					id="m_table_1" style="margin-top: 1%; width: 100%;">
					<thead class="theadTransacColor">
						<tr>

						</tr>
					</thead>


				</table>
				</div>

			</fieldset>
		</div>
</div>

<script>
	function resetSelect2(){
		location.reload(true);
	}
</script>


	
