<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<link rel="stylesheet" href="css/dataTable/datatables.bundle.css" rel="stylesheet">
<script type="text/javascript" src="css/dataTable/datatables.bundle.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
	alert("on load");
	loadDataTable(1);
	$("#modify").hide();
	$("#delete").hide();
	$('#save').click(function() {
		alert("saved");
	
		 document.getElementById("frm").action = "${pageContext.request.contextPath}/savePackUnitMaster";
		 document.getElementById("frm").method = "POST";
		 document.getElementById("frm").submit();  
	
	});

	$('#modify').click(function() {
		var selectedval=$('input[name=uid]:checked', '#frm').val();
		var checked = [];
		$('#numPackId').val(selectedval);
		$(".radio:radio").each(function() {
			if (this.checked) {
				checked.push($(this).val());
			}
		});

		$("#radio").val(checked);
		if (checked.length > 0) {
		
			document.getElementById("frm").action = "${pageContext.request.contextPath}/updatePackUnitMaster";
			document.getElementById("frm").method = "POST";
			document.getElementById("frm").submit();

			} 
		else {

			}
		});
	$('#delete').click(function() {
		var checked = [];
		$(".radio:radio").each(function() {
			if (this.checked) {
				checked.push($(this).val());
			}
		});
		$("#radio").val(checked);
		if (checked.length > 0) {
			$("#radio").val(checked);

			document.getElementById("frm").action = "${pageContext.request.contextPath}/deletePackUnit";
			document.getElementById("frm").method = "POST";
			document.getElementById("frm").submit();

		} else {

		}
	});
	
	$(document).on('click','#radio',function(e){
    	$("#save").prop("style").display="none";
    	$("#modify").show();
    	$("#delete").show();
   
 var resultArray1 = $(this).closest('tr').find('td').map( function(){
			return $(this).text();
		}).get();
 var checkID = $(this).closest('tr').find('input[type=radio]').map( function(){
			return $(this).val();
		}).get();
//alert(resultArray1[1]);
 
 $('#packName').val(resultArray1[1]);
 $('#remarks').val(resultArray1[2]);
});
});
</script>


<script>
	
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		  		{
			"sTitle" : "",
			"mData" : "num_pack_unit_id"
		 },	
		{
			"sTitle" : "Package",
			"mData" : "str_pack_unit_name"
		},
		{
			"sTitle" : "remarks",
			"mData" : "str_remarks"
		},

				],
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
										+ row.num_pack_unit_id
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
	alert("load data table");
	 $.ajax({
			type:"GET",
			data:{status :statusID},
			url :"getPackUnitMaster",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}
</script>


<div class="m-grid__item m-grid__item--fluid m-wrapper">
			    			    
<div class="m-content">
<div class="row">
	<div class="col-lg-12">
		<!--begin::Portlet-->
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
				<div class="m-portlet__head-wrapper">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<h2 class="m-portlet__head-text">
								Pack Unit Master
							</h2>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="m-portlet__body">
				<form:form  id="frm" name="frm" modelAttribute="packUnitMasterModel" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
					<c:forEach items="${errors }" var="error">
                    	<div class="alert alert-success" role="alert">
  							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  						<div class="text-danger">
							<c:out value="${error }"></c:out>
						</div>
						</div>	
					</c:forEach>
					<form:hidden path="numPackId" id ="numPackId" ></form:hidden>	
					 <form:input type="hidden" id="radio" path="radio" /> 
			
			
			
			<div class="m-portlet__body">
				<form:form  id="frm" name="frm" modelAttribute="packUnitMasterModel" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
					
	    			<form:input type="hidden" id="numPackId" path="numPackId" /> 
				<div class="m-portlet__body">	
					<div class="form-group m-form__group row"> 
					<div class="col-lg-6">
							<label class="label-class">Pack Unit Name<span style="color:red;">*</span></label>
							<form:input type="text" path="packName"  class="form-control m-input" id="packName" placeholder="Enter Packaging Name"/>
					</div>
						
						<div class="col-lg-6">
							<label class="label-class">Remarks</label>
							<form:input type="text" path="remarks"  class="form-control m-input" id="remarks" placeholder="Enter Remarks"/>
							
						</div>
					</div>	 
				 </div>
				 </div>
	             <div class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
					<div class="m-form__actions m-form__actions--solid">
						<div class="row">
							<div class="col-lg-12" align="center">
								<button type="button" id="save" class="btn btn-success m-btn--wide"><i class="flaticon-folder" style="padding-right: 15%"></i>Save</button>
								<button type="button" id="modify" class="btn btn-success m-btn--wide"><i class="flaticon-edit" style="padding-right: 15%"></i>Modify</button>
								<button type="button" id="delete" class="btn btn-success m-btn--wide"><i class="flaticon-delete-1" style="padding-right: 15%"></i>Delete</button>
								<button type="button" id="reset" class="btn btn-success m-btn--wide"><i class="flaticon-refresh" style="padding-right: 15%"></i>Reset</button>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered" id="m_table_1" style="margin-top: 1%">
								<thead class="theadTransacColor">
			  						<tr>
				  									
				  						</tr>
						</thead>
			
			
					</table>
					</form:form>
					</form:form>
			</div>
		</div>
		<!-- end::Portlet -->
	</div>
</div>		        </div>
			    		    </div>
