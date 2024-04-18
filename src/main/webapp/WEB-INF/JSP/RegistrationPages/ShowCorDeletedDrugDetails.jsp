<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>Deleted Drug Details</title>
<script type="text/javascript">
$(document).ready(function(){
	//alert("in location");
	loadDataTable(1);
});
</script>

<script>
	function initTable(id, x_size, y_size, statusID) {
		var Table = $(id)
				.DataTable(
						{

							columns : [
									{
										"sTitle" : "S.No.",
										"mData" : "num_drug_id",
										"bVisible" : false
									},
									{
										"sTitle" : "S.No.",
										"mData" : "rownum",
											"bVisible" : false
									},
									{
										"sTitle" : "Manufacturing Unit",
										"mData" : "premisenameadd",
										
									},
									{
										"sTitle" : "Drug Type",
										"mData" : "str_type_name"
									},

									{
										"sTitle" : "Generic Name",
										"mData" : "str_generic_name"
									},

									{
										"sTitle" : "Brand Name",
										"mData" : "str_brand_name"
									},
									{
										"sTitle" : "Dosage Form",
										"mData" : "str_dosage_name"
									},
									/* {
										"sTitle" : "Pharmacological classification of Drug",
										"mData" : "monograph_name"
									}, */ {
										"sTitle" : "Schedule Drug",
										"mData" : "str_schedule_name"
									}, {
										"sTitle" : "Strength",
										"mData" : "str_strength"
									}, {
										"sTitle" : "Storage Condition",
										"mData" : "str_condition_name"
									}, {
										"sTitle" : "Composition",
										"mData" : "str_composition"
									}, /* {
										"sTitle" : "Threpuetic Class",
										"mData" : "str_drug_class_name"
									}, */ {
										"sTitle" : "HS Code",
										"mData" : "hscode"
									},
									{
										"sTitle" : "manufacturing unit id",
										"mData" : "str_manufacturing_unit",
										"bVisible" : false
									},
									{
										"sTitle" : "h s code",
										"mData" : "num_hs_code",
										"bVisible" : false
									}
									 ],
							responsive : !0,
							columnDefs : [
									{
										"targets" : [8,9,10,11,12],
										"className" : "none",

									} ],

						});
		return Table;
	}
	function accept(id) {
		//alert("accpt  - "+id)
	}

	function resetAndDrawTable(dataTableId, data, statusID) {
		var sizeWidth, sizeHeight;
		sizeWidth = "100%";
		sizeHeight = "100%";
		var table = initTable(dataTableId, sizeWidth, sizeHeight, statusID);

		table.clear().draw();
		table.rows.add(data); // Add new data
		table.columns.adjust().draw();
	}
	function loadDataTable(statusID) {
		//alert("load data table");
		$.ajax({
			type : "GET",
			data : {
				status : statusID
			},
			url : "getDeletedDrugDetails",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1", JSONObject.aaData, statusID);// Redraw the DataTable
			}
		});
	}

</script>


<div class="content-wrapper mt-0 pt-0">
	<div class="regdv content content-tiles">
		<div class="page-title"><h1 class="fw-bold">Deleted Drug Details</h1></div>
		<!--begin::Portlet-->
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
				<form:form  id="frm" name="frm" modelAttribute="drugModel" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
	             
					<table class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1" >
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
					
				</form:form>
		</div>
		<!--end::Portlet-->
	</div> --%>