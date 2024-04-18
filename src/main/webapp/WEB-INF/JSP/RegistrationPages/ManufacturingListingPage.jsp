<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>Manufacturing Site Listing</title>
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
			"sTitle" : "",
			"mData" : "num_premises_no",
			"bVisible" : false
		},
		{
			"sTitle" : "Site Type",
			"mData" : "sitetype"
		},
		{
			"sTitle" : "Premise Name",
			"mData" : "str_premises_name"
		},
		{
			"sTitle" : "Premise Full Address",
			"mData" : "address"
		},
		/* {
			"sTitle" : "State",
			"mData" : "str_state_name"
		},
		{
			"sTitle" : "District",
			"mData" : "str_district_name"
		},
		{
			"sTitle" : "Pincode",
			"mData" : "num_pincode"
		}, */
		{
			"sTitle" : "Site Phone Number",
			"mData" : "str_contact_details"
		},
		{
			"sTitle" : "Fax Number",
			"mData" : "str_fax_details"
		},
		{
			"sTitle" : "E-mail Address",
			"mData" : "str_email"
		},
		{
			"sTitle" : "GSTIN Number",
			"mData" : "str_gstin_no"
		},
		{
			"sTitle" : "GLN Number",
			"mData" : "str_gln_no"
		},
		{
			"sTitle" : "Contact Person Name",
			"mData" : "str_cont_name"
		},
		{
			"sTitle" : "Contact Person Mobile Number",
			"mData" : "num_cont_mobile_no"
		},
		{
			"sTitle" : "Contact Person E-mail",
			"mData" : "str_cont_email"
		},
		{
			"sTitle" : "Contact Person Designation",
			"mData" : "str_cont_desg"
		},
		{
			"sTitle" : "Manufacturing Unit Code",
			"mData" : "str_premise_code"
		},
		{
			"sTitle" : "Action",
			"mData" : "",
			"responsivePriority" : "1",
			"sWidth" : "8%"
		}
		
				],
				responsive: !0,
				columnDefs : [
						
						{
							"targets": [3,5,6,7,8,10,11],
			                 "className": "none",
			             	  
			             } ,
			             {
		  	                	"targets": 14,
		  	             	    "render": function ( data, type, row ) {var c = "";

		  	             	 c = '<div class="btn-group dropleft"><button class="btn_default dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" aria-label="Dropdown Buttton"><i class="fa fa-angle-down"><span class="sr-only"></span></i></button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton">';
								c = c
										+ ""
										+ '<a class="dropdown-item" data-bs-toggle="" data-bs-target="#"  onclick="deleterecord(\''
										+ row.num_premises_no+'\');">Delete</a></div></div></td>';

								return c; }
			              }, ],
    	
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
			url :"getManufacturingSiteListing",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}
</script>



<script>

function confirm_alert(msg, type, premiseno) {
    //alert("hellodelete");
    var m = msg.split('.');
    var msg1 = m[0];
    msg2 = m[1];
    swal({
        title: "Are you sure?",
        text: msg1,
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#34A534",
        confirmButtonText: "OK",
        cancelButtonText: "Cancel",
        closeOnConfirm: true,
        closeOnCancel: true
    }, function(isConfirm) {
        if (isConfirm) {
            if (type == "delete") {
                //alert("hellodelete");
                deleterecord1();
            }
        } else if (type == "ok") {
            // Handle 'OK' button functionality
        } else {
            imp = false;
        }
    });
}


if ('${flagDelete}' == 1) {
	ok_message("Record is deleted succesfully.");
}


</script>

<div class="content-wrapper mt-0 pt-0">
	<div class="regdv content content-tiles">
		<div class="page-title"><h1 class="fw-bold">Manufacturing Site / Wholesale Site Details</h1></div>
		<!--begin::Portlet-->
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
			</div>
				<form:form  id="frm" name="frm" modelAttribute="manuList" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
						<form:hidden path="premiseno" id="premiseno" />
					<div class="bg_white">
						<table class="w-100 table table-striped table-bordered dt-responsive  dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
					</div>
					
				</form:form>
		</div>
		<!--end::Portlet-->
			    		    </div></div>
			    		    
<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script>

<script>
	function deleterecord(premiseno) 
	{
	//alert("hello" +premiseno );
	$('#premiseno').val(premiseno);
		confirm_alert('Do you Really want to delete this manufacturing site?','delete');
	}
	</script>
	
	


<script>


function deleterecord1() {
	
	document.getElementById("frm").action = "${pageContext.request.contextPath}/deletemanufacturingsite";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

</script>
