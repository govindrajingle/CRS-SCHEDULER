<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>In-Charge For Exporting Region Details</title>
<script type="text/javascript">
$(document).ready(function(){
	//alert("in location");
	loadDataTable(1);
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

</script>
<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">In-Charge for Exporting Region Details</h1>
		</div>			    			    
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile bg_white" id="main_portlet">
				<form:form  id="frm" name="frm" modelAttribute="pointsOfDisModel" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
				
	             
					<table class="w-100 table table-striped table-bordered dt-responsive dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
					
				</form:form>
		</div>

</div>

<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script> --%>