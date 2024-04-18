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
	function initTable(id, x_size, y_size, statusID) {
		var Table = $(id)
				.DataTable(
						{

							columns : [
									{
										"sTitle" : "",
										"mData" : "num_drug_id"
									},
									{
										"sTitle" : "Manufacturing Unit",
										"mData" : "manufacturingunit"
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
									{
										"sTitle" : "Pharmacological classification of Drug",
										"mData" : "monograph_name"
									}, {
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
									}, {
										"sTitle" : "Threpuetic Class",
										"mData" : "str_drug_class_name"
									}, {
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
									/* {
										'targets' : 0,
										'searchable' : true,
										'orderable' : true,
										'className' : 'dt-body-top',
										'render' : function(data, type, row) {
											return '<input type="radio" class="radio" name="uid" id ="radio" onclick="manufUnitId(\''+row.str_manufacturing_unit+'\',\''+row.num_hs_code+'\');"' 
													+ row.num_drug_id
													+ '" value="'
													+ $('<div/>').text(data)
															.html() + '">';

										}
									}, */ {
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
			url : "getDrugDetails",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1", JSONObject.aaData, statusID);// Redraw the DataTable
			}
		});
	}

</script>


<div class="content-wrapper regdv">


<div class="container-fluid reg_contain">
			    			    
<div class="m-content">
<div class="row">
	<div class="col-lg-12">
		<!--begin::Portlet-->
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
				<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
					<div class="float-left"><h3 class="tittle">Drug Details</h3></div>
				<div class="title-icon float-left">					
				<img class="mb-10" src="images/icontab2.png" alt="">
				</div>
				</div>
			</div>
			<div class="container-fluid">
				<form:form  id="frm" name="frm" modelAttribute="registrationForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
	             
					<table class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1" >
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
					
				</form:form>
			</div>
		</div>
		<!--end::Portlet-->
	</div>
</div>		        </div>
			    		    </div></div>
			    		    
			    		    <!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script>