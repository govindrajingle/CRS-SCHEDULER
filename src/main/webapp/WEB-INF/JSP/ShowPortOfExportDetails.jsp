<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>


<script>
$(document).ready(function(){
	//alert("on load");
	loadDataTable(1);

});

</script>

<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		 {
			"sTitle" : "ID",
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



</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>


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
			<div class="float-left"><h3 class="tittle">Port of Export Details</h3></div>
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
</html> --%>