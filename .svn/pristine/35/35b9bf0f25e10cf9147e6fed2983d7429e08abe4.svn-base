<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%>
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<title>Approved Registration</title>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("in location");
		loadDataTable(1);
	});
</script>

<script>
	function initTable(id, x_size, y_size, statusID) {

		jQuery.extend(jQuery.fn.dataTableExt.oSort,
				{
					"date-euro-pre" : function(a) {
						var date = a.split('-');
						return Date.parse(date[2] + '-' + date[1] + '-'
								+ date[0]) || 0;
					},
					"date-euro-asc" : function(a, b) {
						return a - b;
					},
					"date-euro-desc" : function(a, b) {
						return b - a;
					}
				});

		var Table = $(id)
				.DataTable(
						{

							columns : [

									{
										"sTitle" : "",
										"mData" : "user_id",
										"bVisible" : false
									},

									{
										"sTitle" : "Registration Date",
										"mData" : "createddate",
										"type" : "date-euro"
									},

									{
										"sTitle" : "User Name",
										"mData" : "user_name"
									},
									{
										"sTitle" : "Applicant Type",
										"mData" : "str_appl_type_name",

									},
									{
										"sTitle" : "Organisation Type",
										"mData" : "org_type",
										"bVisible" : false
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
										"sTitle" : "Phone Number",
										"mData" : "org_contact_number"
									},
									{
										"sTitle" : "Country",
										"mData" : "country"
									},
									{
										"sTitle" : "State",
										"mData" : "str_state_name"
									},
									{
										"sTitle" : "District",
										"mData" : "str_district_name"
									},
									{
										"sTitle" : "E-mail Address",
										"mData" : "org_email_id"
									},
									{
										"sTitle" : "Organisation FAX",
										"mData" : "org_fax_number"
									},
									/* {
										"sTitle" : "Organisation PAN Number",
										"mData" : "org_pan_number"
									}, */
									{
										"sTitle" : "Pincode",
										"mData" : "org_pincode"
									},
									{
										"sTitle" : "Website",
										"mData" : "org_website"
									},
									{
										"sTitle" : "RCMC Number",
										"mData" : "str_rcmc_no"
									}, /* {
																																								"sTitle" : "Manufacturing Unit",
																																								"mData" : "str_premise_code"
																																							}, */
									{
										"sTitle" : "Manufacturing Unit Name",
										"mData" : "str_premises_name"
									},

									/* G-CODE (Adding download button) */
									{
										"sTitle" : "Download Drug License",
										'targets' : 16,
										'render' : function(data, type, row) {

											// Create a hyperlink that calls xmlFunction with num_document_id as a parameter
											var a = '<a href="#" onclick="xmlFunction(\''
													+ row.num_document_id
													+ '\');">Manufacturing Site License</a>';
											return a;
										}
									}
							/* END */

							],
							responsive : !0,
							columnDefs : [

							{
								"targets" : [ 3, 4, 5, 8, 9, 10, 11, 14 ],
								"className" : "none",

							} ],
							order : [ [ 1, 'desc' ] ]
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
			url : "getApprovedRegistrationListing",
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
		<div class="page-title">
			<h1 class="fw-bold">Manufacturers/Exporters Registrations</h1>
		</div>
		<!--begin::Portlet-->
		<div
			class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile"
			id="main_portlet">
			<div class="m-portlet__head"
				style="background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
			</div>

			<form:form id="frm" name="frm" modelAttribute="registrationForm"
				method="POST"
				cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed">
				<form:hidden id="userId" path="userId" />
				<form:input type="hidden" id="ENdoc_id" path="ENdoc_id" />
				<form:input type="hidden" id="fileType" path="fileType" />
				<div class="bg_white">
					<table
						class="w-100 table table-striped table-bordered dt-responsive nowrap dspit"
						id="m_table_1" style="width: 100%;">
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

<script>
	function xmlFunction(num_document_id) {
		//alert(num_document_id);
		if (num_document_id == "null") {
			alert("Document not uploaded");
			// You can add additional logic or redirect to another page if needed
			location.reload(); // Reload the current page
		} else {
			var enFid1 = btoa(num_document_id);
			var reverseval = reverseString(enFid1);
			var enFid = btoa(reverseval);
			var fileType = 3;
			document.getElementById("frm").action = "${pageContext.request.contextPath}/downloadTmpFile_Secure";
			$("#ENdoc_id").val(enFid);
			$("#fileType").val(fileType);
			document.getElementById("frm").method = "POST";
			document.getElementById("frm").submit();
		}
	}
	function reverseString(str) {
		//alert ('Hello');
		var newString = "";
		for (var i = str.length - 1; i >= 0; i--) {
			newString += str[i];
		}
		return newString;
	}
</script>
<!-- Google tag (gtag.js) 
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
 // window.dataLayer = window.dataLayer || [];
 // function gtag(){dataLayer.push(arguments);}
 // gtag('js', new Date());
 // gtag('config', 'G-RRHHYLSBGG');
</script> -->