<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>


<title>Port Of Export Details</title>
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
			"mData" : "num_port_id",
			"bVisible" : false
		},
		{
			"sTitle" : "S.No.",
			"mData" : "rownum"
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

<div class="content-wrapper mt-0 pt-0">
<section class="regdv content content-tiles">
	<div class="page-title"><h1 class="fw-bold">Port of Export Details</h1></div>
			<form:form method="post" id="frm" name="frm" modelAttribute="portOfExportModel">
				<sec:csrfInput/>
			
               	<fieldset class="mt-2 border-0 p-0">
               	<div class="section-title"><h2>Port Of Export List</h2></div>
               	<div class="bg_white">
               			<table class="table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered dspit" id="m_table_1" style="margin-top: 1%;width:100%;">
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

<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script> --%>