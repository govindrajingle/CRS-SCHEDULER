<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<link rel="stylesheet" href="css/dataTable/datatables.bundle.css" rel="stylesheet">
<script type="text/javascript" src="css/dataTable/datatables.bundle.js"></script>

<script>

 $(document).ready(function(){	
	alert("page is loading...");
	loadDataTable(1);
	$("#modify").hide();
	$("#delete").hide();
	$('#save').click(function() {
		alert("saved");
		document.getElementById("frm").action = "saveStateType";
		document.getElementById("frm").method = "POST";
		document.getElementById("frm").submit();
	});

   $('#modify').click(function() {
		var selectedval=$('input[name=uid]:checked', '#frm').val();
		alert(selectedval);
		var checked = [];
		//alert("in mod");
		$('#num_state_id').val(selectedval);
		
		$(".radio:radio").each(function() {
			if (this.checked) {
				checked.push($(this).val());
			}
		});
		
		$("#radio").val(checked);
		if (checked.length > 0) {
			$("#radio").val(checked);
			document.getElementById("frm").action = "${pageContext.request.contextPath}/updateStateMaster";
			document.getElementById("frm").method = "POST";
			document.getElementById("frm").submit();

		} else {

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

					document.getElementById("frm").action = "${pageContext.request.contextPath}/deleteState";
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
			
	 
	 $('#num_zone_id').each(function () {
			$('option', this).each(function () {
				if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[3]).toLowerCase()) 
				{
					$(this).prop('selected', 'selected');
					return false;
				};
			});
	 }); 
     
	 $('#str_state_name').val(resultArray1[1]);
		
	 $('#str_state_short_name').val(resultArray1[2]);
	
	});

});

</script>

<script>
  function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns : [ {
			"sTitle" : "Select",
			"mData" : "num_state_id"
		}, {
			"sTitle" : "State Name",
			"mData" : "str_state_name"
		}, {
			"sTitle" : "State Code",
			"mData" : "str_state_short_name"
		}, {
			"sTitle" : "Zone",
			"mData" : "str_zone_name"
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
										+ row.num_state_id
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
	//alert("load data table");
	 $.ajax({
			type:"GET",
			data:{status :statusID},
			url :"getStateMaster",
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
				<!-- begin::Portlet -->
				<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
					<div class="m-portlet__head headerColor">
						<div class="m-portlet__head-progress">
							<!-- here can place a progress bar-->
						</div>
						<div class="m-portlet__head-wrapper">
							<div class="m-portlet__head-caption">
								<div class="m-portlet__head-title">
									<h2 class="m-portlet__head-text">State Master</h2>
								</div>
							</div>
						</div>
					</div>
					<div class="m-portlet__body">
						<form:form id="frm" name="frm" modelAttribute="StateMasterForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed">
							<form:hidden path="num_state_id" id ="num_state_id" ></form:hidden>	
							<form:input type="hidden" id="radio" path="radio" />

							<div class="m-portlet__body">
								<div class="form-group m-form__group row">
									<div class="col-lg-6">
										<label class="label-class">Country</label>
										<form:select class="form-control m-input" id="num_country_id"
											path="num_country_id" selectcheck="true" readonly="">
											<option value="193" Selected>India</option>
										</form:select>

									</div>
									
									
									<div class=" col-md-6">
                                        <label class="label-class">Zone <span
								        style="color: red;">*</span></label>
			                      	<form:select path="num_zone_id" class="form-control" id="num_zone_id" required="required">
										<form:option value="0">--select Zone-</form:option>
										<c:forEach items="${zone}" var="c">
												<form:option value="${c.zoneId}">${c.zoneName}</form:option>
										</c:forEach>
									</form:select>	
								</div>
								
									
									
								</div>

								<div class="form-group m-form__group row">
									<div class="col-lg-6">
										<label class="label-class">State Name<span
											style="color: red;">*</span></label>
										<form:input type="text" path="str_state_name"
											class="form-control m-input" id="str_state_name"
											placeholder="Enter State Name" />

									</div>
									<div class="col-lg-6">
										<label class="label-class">State Code<span
											style="color: red;">*</span></label>
										<form:input type="text" path="str_state_short_name"
											class="form-control m-input" id="str_state_short_name"
											placeholder="Enter State Code" />

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
											<button type="button" id="reset"
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
				<!--end::Portlet-->
			</div>
		</div>
	</div>
</div>