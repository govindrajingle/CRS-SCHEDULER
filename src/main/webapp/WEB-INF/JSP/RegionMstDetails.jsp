<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>Region Details</title>
<script type="text/javascript" src="js/validation/customValidation.js"></script>
<script type="text/javascript" src="js/Registration/updateProfile.js"></script>
<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script>
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<script type="text/javascript" src="js/globalJs/globalJs.js"></script>



<script type="text/javascript">

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
						"sTitle" : "",
						"mData" : "num_region_id",
						"bVisible" : false
					},
					{
						"sTitle" : "S No.",
						"mData" : "rownum"
					},	
					{
						"sTitle" : "Region Name",
						"mData" : "str_region_name"
					},
					{
						"sTitle" : "Region Code",
						"mData" : "str_region_code"
					},
					{
						"sTitle" : "Remarks",
						"mData" : "str_remarks"
					}
				],
				responsive: !0,
				columnDefs : [
						
						{
							"targets": [],
			                 "className": "none",
			             	  
			            }
			            ],
    	
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
			url :"getRegionMasterDetails",
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
	<div class="page-title"><h1 class="fw-bold">Region Details</h1></div>
			<form:form method="post" id="frm" name="frm" modelAttribute="RegionMstModel">
				<sec:csrfInput/>
				
               	<fieldset class="mt-2 border-0 p-0">
               	<div class="section-title"><h2>Region List</h2></div>
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