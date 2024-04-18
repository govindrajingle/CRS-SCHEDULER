<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>Show All Drugs</title>
<script type="text/javascript">
$(document).ready(function(){
	$('#loadTable').click(function() {
		if($('#companyProfile').val() == -1 ){
			error_message("Please Fill all the Mandatory details!");
		}else{
			$('#dataTableDiv').show();
			loadDataTable(1);
		}
	});
	$('#dataTableDiv').hide();
	$("#companyWise").hide();
	$("select#companyProfile").change(function() {
		$('#m_table_2').DataTable();
		$('#dataTableDiv').hide();
		if($("#companyProfile").val() == -1 || $("#companyProfile").val() == 0){
			$("#companyWise").hide();
		} else {
			$("#companyWise").show();
			//$('#m_table_1').DataTable().destroy();
			loadCompanyProfileData();
		}
	});
});

	function initTable(id, x_size, y_size, statusID) {
		var Table = $(id)
				.DataTable(
						{

							columns : [
									{
										"sTitle" : "",
										"mData" : "num_drug_id",
										"bVisible" : false
									},
									
									{
										"sTitle" : "Uploaded Date",
										"mData" : "dt_tr_date"
									},
									{
										"sTitle" : "Manufacturing Unit",
										"mData" : "premisenameadd"
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
									},{
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
													"targets" : [9,10,11,12,13],
													"className" : "none",
											 } 
										 ],
										  destroy: true
						});
		return Table;
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
		$.ajax({
			type : "GET",
			data : {
				status : statusID, company:$('#companyProfile').val()
			},
			url : "getAllDrugDetails",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				resetAndDrawTable("#m_table_1", JSONObject.aaData, statusID);// Redraw the DataTable
			}
		});
	}

	function loadCompanyProfileData(){ 
		var company=$('#companyProfile').val(); 
		//alert(company+"  id");
			$.ajax({
				type : "GET",
				url : "getCompanyProfileData",
				data : {company:company},
			 	success : function(response){   
					if(response.length>0){
						//alert("in func");
						for (i = 0; i < response.length; i++) {
							if (response[i].applicantType == 100 ) {
								$('#appType').text('Manufacturer');
							} else {
								$('#appType').text('Merchant Exporter');
							}

							if (response[i].orgName == null || response[i].orgName == '' ) {
								$('#orgName').text('Not Available');
							} else {
								$('#orgName').text(response[i].orgName);
							}

							if (response[i].orgAddress == null || response[i].orgAddress == '' ) {
								$('#orgAdd').text('Not Available');
							} else {
								$('#orgAdd').text(response[i].orgAddress);
							}

							if (response[i].orgEmailId == null || response[i].orgEmailId == '' ) {
								$('#email').text('Not Available');
							} else {
								$('#email').text(response[i].orgEmailId);
							}
						}
					}
			 	}
			});
	}

</script>

<div class="content-wrapper mt-0 pt-0">
<section class="regdv content content-tiles">
	<div class="page-title"><h1 class="fw-bold">Drug Details</h1></div>    
		<!--begin::Portlet-->
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
			</div>
				<form:form  id="frm" name="frm" modelAttribute="registrationForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
	             	<div class="m-portlet__body">	
						<div class="form-group m-form__group row bg_white"> 
							<div class="col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label" for="companyProfile">Company<span style="color: #cd2026;">*</span></label>
									<form:select class="form-control m-input"  id="companyProfile" path="" selectcheck="true"> 
										<form:option value="-1">Select User</form:option>
										<form:option value="0">All</form:option>
										<c:forEach items="${regList}" var="c">
											<form:option value='${c.userId}'>${c.orgName} -  ${c.userName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>	
						
						<div class="form-group m-form__group" id="companyWise">
							<fieldset class="mt-3">
									<div class="bg_white">
										<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit" id="m_table_2" style="width:100%;">
											<thead class="theadTransacColor">
												<tr>
													<th data-hide="all" >Applicant Type</th>
													<th data-hide="all" >Organization Name</th>
													<th data-hide="all" >Organization Address</th>
													<th data-hide="all" >E-mail</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td data-hide="all"  id="appType"></td>
													<td data-hide="all"  id="orgName"></td>
													<td data-hide="all"  id="orgAdd"></td>
													<td data-hide="all" id="email"></td>
												</tr>
											</tbody>
										</table>
									</div>
							</fieldset>
						</div>

					 </div>

		             <div class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
						<div class="text-center">
							<button type="button" id="loadTable" class="custom-btn position-relative">Show Data</button>
						</div>
					</div>
					
					<div id="dataTableDiv" class="bg_white mt-3">
					<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1" >
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
					</div>
					
				</form:form>
		</div>
		<!--end::Portlet-->       
</div>
</div>

<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script>