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
				portCode : {
					validators : {
						notEmpty : {
							message : "Code is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 1,
							max : 50,
							message : "Code can contain maximum of 50 characters"
						}
					}
				},
				portName : {
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
				portAddress : {
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
				stateId : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify State',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('stateId').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  distId : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify District',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('distId').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  pincode : {
					validators : {
						notEmpty : {
							message : "Pin Code is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[0-9().\/,\s\-]+$/,
							message : 'Only numbers are permitted'
						},
						stringLength : {
							min : 1,
							max : 6,
							message : "Pin Code can contain maximum of 6 characters"
						}
					}
				},
				emailId : {
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
				},
				mobileNo : {
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
				remarks : {
					validators : {
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
				}
			}
		}); 
	
	loadDataTable(1);

	if('${flagSave}'== 1){
		ok_message("New Record Added Successfully.");
	}else if('${flagUpdate}'== 1){
		ok_message("Record Updated Successfully.");
	}else if('${flagDelete}'== 1){
		ok_message("Record Deleted Successfully.");
	}
	
	$("#modify").hide();
	$("#delete").hide();

	$('#save').click(function() {
		 var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
			}
			else{
			}
		});

	$('#modify').click(function() {
		var selectedval=$('input[name=uid]:checked', '#frm').val();
		var checked = [];
		$('#numRegionId').val(selectedval);
		$(".radio:radio").each(function() {
			if (this.checked) {
				checked.push($(this).val());
			}
		});
	
		$("#radio").val(checked);
		if (checked.length > 0) {
			 var bV = $("#frm").data('bootstrapValidator');
			   bV.validate();
				if(bV.isValid()){ 
					$("#radio").val(checked);
					confirm_alert('Do you Really want to modify?','modify');
				}
				else{
				}
			} 
		else {
	
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
		 
		 $('#portCode').val(resultArray1[1]);

		 $('#portName').val(resultArray1[2]);

		 $('#portAddress').val(resultArray1[3]);     

		 $('#stateId').each(function () {
			$('option', this).each(function () {
				if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[4]).toLowerCase()) 
				{
					$(this).prop('selected', 'selected');
					loadDistrict(resultArray1[8]);
					return false;
				};
			});
		});

		setTimeout(function() {
			$('#distId').each(function (){
				$('option', this).each(function () {
					if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[5]).toLowerCase()) 
					{
						$(this).prop('selected', 'selected');
						return false;
					}
				});
			});
		}, 1000);

		$('#pincode').val(resultArray1[6]);

		$('#emailId').val(resultArray1[7]);

	});
	
});

</script>

<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		 {
			"sTitle" : "",
			"mData" : "num_port_id"
		 },	
		 {
				"sTitle" : "Port Code",
				"mData" : "str_port_code"
		},
		{
			"sTitle" : "Port Name",
			"mData" : "str_port_name"
		},
		{
			"sTitle" : "Port Address",
			"mData" : "str_port_add"
		},
		{
			"sTitle" : "State Name",
			"mData" : "statename"
		},
		{
			"sTitle" : "District Name",
			"mData" : "districtname"
		},
		{
			"sTitle" : "Pin Code",
			"mData" : "num_pincode"
		},
		{
			"sTitle" : "Email",
			"mData" : "str_email"
		},
		{
			"sTitle" : "Contact Number",
			"mData" : "str_contact_number"
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
							return '<input type="radio" class="radio" name="uid" id ="radio"'
									+ row.num_port_id
									+ '" value="'
									+ $('<div/>').text(data).html()
									+ '">';
									
						}
					},
						{
							"targets": [6,7,8],
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
			url :"getPortOfExport",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}

function loadDistrict(){ 
	var stateId=$('#stateId').val(); 
	//alert(stateId);
		$.ajax({
			type : "GET",
			 url : "getDistrictData",
			data : {stateId:stateId},
		 success : function(response){
			 if(response.length>0){
			
				 for(var userlist in response){
					 $('#distId').append($("<option></option>").attr("value",response[userlist].num_district_id).text(response[userlist].str_district_name));
				 }  
				 
			 }
		 }
	});
}

function clearFeilds(){
	$("#portCode").val("");
	$("#portName").val("");
	$("#portAddress").val("");
	$("#stateId").val(0);
	$("#distId").val(0);
	$("#pincode").val("");
	$("#emailId").val("");
	$("#mobileNo").val("");
	$("#remarks").val("");
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
	document.getElementById("frm").action = "${pageContext.request.contextPath}/savePortOfExport";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

function submit_form_update(){
	document.getElementById("frm").action = "${pageContext.request.contextPath}/updatePortOfExport";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

function submit_form_delete(){
	document.getElementById("frm").action = "${pageContext.request.contextPath}/deletePortOfExport";
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
			<div class="float-left"><h3 class="tittle">Port of Export</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div>
							
		<div class="scroll-top-wrapper ">
			<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>

		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm" modelAttribute="portOfExportModel">
				<sec:csrfInput/>
				
				<form:hidden path="portId" id ="portId" ></form:hidden>	
				<form:input type="hidden" id="radio" path="radio" />
				<div class="panel panel-default " id="lic">
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
							
								<div class=" col-md-6">
									<label class="dvfrm-label">Port Code:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="portCode" type="text" class="form-control"
								 			id="portCode" placeholder="Enter Port Code"/>	
								</div>
							
								<div class=" col-md-6">
									<label class="dvfrm-label">Port Name:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input type="text" class="form-control m-input" path="portName" placeholder="Enter Full Name of Port" id="portName" autocomplete="off"></form:input>
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Port Address:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input type="text" class="form-control m-input" path="portAddress" placeholder="Enter Full Address" id="portAddress" autocomplete="off"></form:input>
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Port State:<span style="color:red;">*</span><span class="iconStyle"></span></label>
										<form:select path="stateId" class="form-control" id="stateId" onchange="loadDistrict();">
											<form:option value="0">--select State--</form:option>
											<c:forEach items="${state}" var="c">
												<option value='${c.num_state_id}'> ${c.str_state_name}</option>
											</c:forEach>
										</form:select>
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Port District:<span style="color:red;">*</span><span class="iconStyle"></span></label>
										<form:select path="distId" class="form-control" id="distId">
											<form:option value="0">--select District--</form:option>
											
										</form:select>
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Port Zip/Postal Code:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="pincode" type="text" class="form-control"
								 			id="pincode" placeholder="Enter Pin Code"/>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Port Email Id:<span class="iconStyle"></span></label>
									<form:input path="emailId" type="text" class="form-control"
								 			id="emailId" placeholder="Enter Email Id"/>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Port Contact Number:<span class="iconStyle"></span></label>
									<form:input path="mobileNo" type="text" class="form-control"
										 id="mobileNo" placeholder="Enter Number"/>	
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Remarks(If Any):<span class="iconStyle"></span></label>
									<form:textarea path="remarks" type="text" class="form-control"
								 			id="remarks" placeholder="Enter Remarks"/>	
								</div>
								
							</div>
						</div>	
				</div>
				
				<div class="text-center">
					<button type="button" class="btn btn-primary" id="save"> Save </button>
					<button type="button" id="modify" class="btn btn-success m-btn--wide"><i class="flaticon-edit" style="padding-right: 15%"></i>Modify</button>
					<button type="button" id="delete" class="btn btn-success m-btn--wide"><i class="flaticon-delete-1" style="padding-right: 15%"></i>Delete</button>
                	<button type="reset" class="btn btn-primary" id="reset"> Reset </button>
               	</div>
               	
               	<fieldset>
               	<legend>Port Of Export List</legend>
               	<table class="table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered dspit" id="m_table_1" style="margin-top: 1%;width:100%;">
					<thead class="theadTransacColor">
			  			<tr>				
				  		</tr>
					</thead>
				</table>
				</fieldset>
			</form:form>
		</div>
		
	</div>
	
	</section>
	
</div>
</body>
</html>