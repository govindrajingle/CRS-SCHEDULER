<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<link rel="stylesheet" href="css/dataTable/datatables.bundle.css" rel="stylesheet">
<script type="text/javascript" src="css/dataTable/datatables.bundle.js"></script>

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
			"sTitle" : "Applicant Type",
			"mData" : "applicanttype"
		},
		{
			"sTitle" : "RCMC Number",
			"mData" : "rcmc_number"
		},
		
		{
			"sTitle" : "RCMC Issue Date",
			"mData" : "rcmc_issuedt"
		},
		
		{
			"sTitle" : "RCMC Re-Issue Due Date",
			"mData" : "rcmc_duedtrenew"
		},
		
		
		{
			"sTitle" : "Organisation Name",
			"mData" : "org_name"
		},

		{
			"sTitle" : "Organisation Address",
			"mData" : "org_address"
		},

		{
			"sTitle" : "PAN Number",
			"mData" : "org_pan_number"
		},
		{
			"sTitle" : "Website",
			"mData" : "org_website"
		},
		
		{
			"sTitle" : "Manufacturing Site Name",
			"mData" : "manf_site_name"
		},
		
		{
			"sTitle" : "Manufacturing License Number",
			"mData" : "manf_lic_number"
		},
		{
			"sTitle" : "Contact Person Name",
			"mData" : "contact_person_name"
		}
				],
				responsive: !0,
				columnDefs : [
						
						{
							"targets": [5,7,8,9,10],
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
			url :"getRCMCData",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
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
					<div class="float-left"><h3 class="tittle">RCMC Data</h3></div>
				<div class="title-icon float-left">					
				<img class="mb-10" src="images/icontab2.png" alt="">
				</div>
				</div>
			</div>
			<div class="container-fluid">
				<form:form  id="frm" name="frm" modelAttribute="login" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
				
	             
				<table class="table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered dspit" id="m_table_1">
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