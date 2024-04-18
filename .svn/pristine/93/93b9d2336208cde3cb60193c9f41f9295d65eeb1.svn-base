<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>


 <link rel="stylesheet" href="css/dataTable/datatables.bundle.css" rel="stylesheet">
<script type="text/javascript" src="css/dataTable/datatables.bundle.js"></script> 

<script>
$(document).ready(function(){	
	//alert("page is loading...");
	loadDataTable(1);
	$("#modify").hide();
	$("#delete").hide();
	$('#save').click(function() {
		//alert("saved");
		document.getElementById("frm").action = "saveDistrictMaster";
		document.getElementById("frm").method = "POST";
		document.getElementById("frm").submit();
	});

	$("#num_state_id") .change(function () {    
		//alert("in change");
		loadDistrict();
	});
});


function loadDistrict(){ 
	var stateId=$('#num_state_id').val(); 
	//alert(stateId);
		$.ajax({
			type : "GET",
			 url : "getDistrictData",
			data : {stateId:stateId},
		 success : function(response){
			 
			 if(response.length>0){
			
				 for(var userlist in response){
					 $('#str_district_name').append($("<option></option>").attr("value",response[userlist].num_district_id).text(response[userlist].str_district_name));
				 }  
				 
			 }
		 }
	});
}

</script>

<script>

function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
			{
				"sTitle" : "Select",
				"mData" : "num_district_id"
			},

			 {
				"sTitle" : "State",
				"mData" : "str_state_name"
			}, 
			{
				"sTitle" : "District Name",
				"mData" : "str_district_name"
			},
			{
				"sTitle" : "District Short Code",
				"mData" : "str_district_short_name"
			} ],
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
										+ row.num_district_id
										+ '" value="'
										+ $('<div/>').text(data).html()
										+ '">';
										
							}
						},
						{
							"targets": [],
			                 "className": "none",
			             	  
			             }],
    	
	});
       return Table;
  }
  function accept(id){
	alert("accpt  - "+id)
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
				url :"getDistrictMaster",
				success: function(response){
					var JSONObject = JSON.parse(response);
					alert(JSON.stringify(JSONObject.aaData));
					 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
				}
			});
	}

</script>


<div class="m-grid__item m-grid__item--fluid m-wrapper">
	<div class="m-content">
		<div class="row">
			<div class="col-lg-12">
				<!-- begin::Portlet -->
				<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
					<div class="m-portlet__head headerColor">
						<div class="m-portlet__head-progress">
							<!-- here can place a progress bar-->
						</div>
						<div class="m-portlet__head-wrapper">
							<div class="m-portlet__head-caption">
								<div class="m-portlet__head-title">
									<h2 class="m-portlet__head-text">District Master</h2>
								</div>
							</div>
						</div>
				</div>
					<div class="m-portlet__body">
						<form:form id="frm" name="frm" modelAttribute="districtMasterForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed">
							 <%-- <c:forEach items="${errors }" var="error">
                    	<div class="alert alert-success" role="alert">
  							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  						<div class="text-danger">
							<c:out value="${error }"></c:out>
						</div>
						</div>	
					</c:forEach>  --%>
					 
					 	<%-- <form:hidden path="num_district_id" id ="num_district_id" ></form:hidden>	
					    <form:input type="hidden" id="radio" path="radio" /> --%>
					 
					 
					 
				<div class="m-portlet__body">	
					<div class="form-group m-form__group row">
						 <div class="col-lg-6">
							<label class="label-class">State<span style="color:red;">*</span></label>
							 
							<form:select class="form-control m-input"  id="num_state_id" path="num_state_id" selectcheck="true"> 
								<form:option value="0">Select State</form:option>
								<c:forEach items="${state}" var="c">
									<form:option value='${c.num_state_id}'> ${c.str_state_name}</form:option>
								</c:forEach>
							</form:select>
						</div>
						
								 
					<div class="col-lg-6">
							<label class="label-class">District Name<span style="color:red;">*</span></label>
							<form:select  class="form-control m-input" path="str_district_name"  id="str_district_name" >
							<option value="0">Select</option>
							</form:select>
						</div>
					</div>	 
					<div class="form-group m-form__group row">
					 <div class="col-lg-6">
							<label class="label-class">District Short Name<span style="color:red;">*</span></label>
							<form:input type="text" path="str_district_short_name"  class="form-control m-input" id="str_district_short_name" placeholder="Enter District Sort Name"/>
							
						</div>
					</div>	                
	            </div>
							<div
								class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
								<div class="m-form__actions m-form__actions--solid">
									<div class="row">
										<div class="col-lg-12" align="center">
											<button type="button" id="save"
												class="btn btn-success m-btn--wide">
												<i class="flaticon-folder" style="padding-right: 15%"></i>Save
											</button>
											<button type="button" id="modify"
												class="btn btn-success m-btn--wide">
												<i class="flaticon-edit" style="padding-right: 15%"></i>Modify
											</button>
											<button type="button" id="delete"
												class="btn btn-success m-btn--wide">
												<i class="flaticon-delete-1" style="padding-right: 15%"></i>Delete
											</button>
											<button type="reset" id="reset"
												class="btn btn-success m-btn--wide">
												<i class="flaticon-refresh" style="padding-right: 15%"></i>Reset
											</button>
										</div>
									</div>
								</div>
							</div>
							<table
								class="table table-striped- table-bordered table-hover table-checkable"
								id="m_table_1" style="margin-top: 1%">
								<thead class="theadTransacColor">
									<tr>

									</tr>
								</thead>


							</table>
						</form:form>
					</div>
				</div>
</div>		        </div>
			    		    </div></div>

