<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>


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
			"sTitle" : "Username",
			"mData" : "str_sendto"
		},	
		{
			"sTitle" : "Mail Type Name",
			"mData" : "str_mail_type_name"
		},		
		{
			"sTitle" : "Mail Subject",
			"mData" : "str_subject"
		},
		{
			"sTitle" : "Mail Content",
			"mData" : "str_body"
		},					
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
			url :"getEmailData",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}
</script>


<div class="content-wrapper mt-0 pt-0">
	<div class="regdv content content-tiles">  
		<div class="page-title">
			<h1 class="fw-bold">Email Data</h1>
		</div>  			    
		<div class="m-content">
			<!--begin::Portlet-->
			<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
				<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
					<div class="m-portlet__head-progress">
						<!-- here can place a progress bar-->
					</div>
				</div>
					<form:form  id="frm" name="frm" modelAttribute="emailDetialForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
		             
						<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
							<thead class="theadTransacColor">
					  			<tr>
						  									
						  		</tr>
							</thead>
							
						</table>
						
					</form:form>
			</div>
			<!--end::Portlet-->
		</div>
	</div>
</div>
