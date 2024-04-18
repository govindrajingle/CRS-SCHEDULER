<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>Show All Uploaded Data</title>
<style>
.modal-lg{
    max-width: 85%;
}
</style>

<script>
$(document).ready(function(){
	//alert("on load");
	$('#loadTable').click(function() {
		//$('#fromDate').val() +"  "+ $("#toDate").val()+"  "+$('#companyProfile').val()
		if($('#companyProfile').val() == -1 || $('#fromDate').val() == "" || $("#toDate").val() == ""){
			error_message("Please Fill all the Mandatory details!");
		}else{
			loadDataTable(1);
		}
	});
	$("#companyWise").hide();
	$("select#companyProfile").change(function() {
		//$('#m_table_2').DataTable();
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

$(document).ready(function() {
    $('#m_table_2').DataTable();
} );
</script>
<script>

function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({
		columns: [
			{
				"sTitle" : "",
				"mData" : "num_document_id",
				"bVisible": false
			},
			{
				"sTitle" : "Purpose Type",
				"mData" : "str_remarks"
			},
			{
				"sTitle" : "User Name",
				"mData" : "user_name"
			},
			{
				"sTitle" : "Company Name",
				"mData" : "org_name"
			},
			{
				"sTitle" : "User Code",
				"mData" : "str_manuf_code"
			},
			{
				"sTitle" : "Uploaded Date",
				"mData" : "createddate"
			},
			{
				"sTitle" : "Uploaded Time",
				"mData" : "createdtime"
			},
			{
				"sTitle" : "Uploaded Xml",
				"mData" :  ""
			}
		],
						         	responsive: !0,
									columnDefs : [
											{
												'targets' : 7,
												'searchable' : true,
												'orderable' : true,
												'className' : 'dt-body-top',
												'render' : function(data, type, row) {
													var a = "";
					    	    					a = '<a href="#" onclick="openDetails(\''+row.num_document_id+'\',\''+row.num_type_id+'\');">View Xml</a>';
					    	    				   	return a;
															
												}
											},
											{
												"targets": [],
								                "className": "none",  
								            }],	 
								            destroy: true
	});
	return Table;
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

	function GetFormattedDate(date) {
		var date = date.split("-").join(" ");
		var res = date.split(" ");
		//alert(res[0]+" "+res[1]+" "+res[2])
		var month = res[1];
		var year = res[0];
		var day = res[2];
		var fulldate = day + '-' +month + '-' + year;
		//alert(fulldate);
		return fulldate;
	}
	function reverseString(str) {
		//alert ('Hello');
	    var newString = "";
	    for (var i = str.length - 1; i >= 0; i--) {
	        newString += str[i];
	    }
	    return newString;
	}

function loadDataTable(statusID){
	$('#dataTableDiv').show();
	//alert($('#fromDate').val() +"  "+ $("#toDate").val()+"  "+$('#companyProfile').val());
	
	 $.ajax({
			type:"GET",
			data:{status :statusID, company:$('#companyProfile').val(),fromdate:$('#fromDate').val(), todate:$("#toDate").val()},
			url :"getAllUploadXmlDetails",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
} 

function xmlFunction(docId){//${pageContext.request.contextPath}/downloadTmpFile_Secure/'+row.num_document_id
//	alert(docId);
	//var enFid = DataEncoder.encode(docId);
	var enFid1 =  window.btoa(docId);
	
//alert(enFid1)
	var reverseval=reverseString(enFid1);
//alert(reverseval)
    var enFid = btoa(reverseval);  
//alert(enFid)
	//alert(enFid);
	var fileType = 2;
	document.getElementById("frm").action = "${pageContext.request.contextPath}/downloadTmpFile_Secure/"+enFid+"/"+fileType;
	//document.getElementById("frm").method = "GET";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit(); 
	//ok_message("Under Processing......");
}
</script>
<script>
function openTreeView(docId){
	
	document.getElementById("frm3").action = "${pageContext.request.contextPath}/ShowConsignmnetDetails?docId="+docId;
	document.getElementById("frm3").method = "POST";
	document.getElementById("frm3").submit(); 
}
</script>

<script>

function showModal(event) {
	//alert("in show modal");
	$(event).modal({
		backdrop : 'static',
		keyboard : false,
		show : true

	});
} 

</script>

<script>
		function openDetails(docId,typeId){

			var docId1 = btoa(docId);
			//alert(docId1);
		    var reverseval=reverseString(docId1);
			//alert(reverseval);
		    var enfId = btoa(reverseval); 
			//alert(enfId);
			
			$.ajax({
				type : "GET",
				data : {
					enfId : enfId
				},
				url : "viewUploadedXML",
				success : function(response) {
				$('#showData').html('');
				$('#showData2').html('');
				$('#showData3').html('');
				
					var tempDom = $('<output>').append($.parseHTML(response));
					 $(".modal-content #docID").val(docId);
					 $(".modal-content #typeID").val(typeId);
					var appContainer = $('#details', tempDom);
					$('#showData').html(appContainer[0]);
					
					appContainer = $('#tertiary', tempDom);
				    $('#showData2').html(appContainer[0]);
				    
					appContainer = $('#secondary', tempDom);
					$('#showData3').html(appContainer[0]);

					if(typeId==3){
					 $(".modal-content .btn-prev").removeClass('hide');
					  $(".modal-content .btn-next").removeClass('hide');
					}
					else{
					$(".modal-content .btn-prev").addClass('hide');
					  $(".modal-content .btn-next").addClass('hide');
					}
					$('#showDataModel').modal('show');
				}
				});
				}


		function checkDate(){
			if ($('#fromDate').val() != '' && $("#toDate").val() != '') {
				
				var mDate = $('#fromDate').val();
				var eDate = $('#toDate').val();
				var curDate = new Date();
				if (eDate < mDate) {
					warning_message("From Date can not be smaller than To Date!.");
					$('#fromDate').val("");
				} else {
				}
			}
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
<script>
function reverseString(str) {
	//alert ('Hello');
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    return newString;
}
</script>
<script>
$(document).ready(function(){
	$('#dataTableDiv').hide();
	$("div[id^='showDataModel']").each(function(){
  	var currentModal = $(this);
	  //click next
	  currentModal.find('.btn-next').click(function(){
	    currentModal.modal('hide');
	    currentModal.closest("div[id^='showDataModel']").nextAll("div[id^='showDataModel']").first().modal('show'); 
	  });
	  
	  //click prev
	  currentModal.find('.btn-prev').click(function(){
	    currentModal.modal('hide');
	    currentModal.closest("div[id^='showDataModel']").prevAll("div[id^='showDataModel']").first().modal('show'); 
	  });

	});
});
</script>

<div class="content-wrapper mt-0 pt-0">
<section class="regdv content content-tiles">
	<div class="page-title"><h1 class="fw-bold">Uploaded Data</h1></div>
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__body">
	                <form:form method="post" id="frm" name="frm" modelAttribute="uploadData" enctype="multipart/form-data" aria-label="Upload Data">
					<sec:csrfInput/>
	               	<form:hidden path="uploadId" id="uploadId" aria-label="upload Id"/>
	               	
	               	<div class="m-portlet__body bg_white">	
						<div class="m-form__group row"> 
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

						<div class="m-form__group" id="companyWise">
							<fieldset class="mt-3">
									<div class="bg_white">
										<table class="w-100 table table-striped table-bordered dt-responsive nowrap" id="m_table_2" style="width:100%;">
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
							<div class="row"> 
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="fromDate">From Date<span style="color: #cd2026;">*</span></label>
										<div class="form-group">
	        								<div class='input-group date' id=''>	
	        									<form:input path="" type="date" class="form-control" value=""
											 		id="fromDate" placeholder="" onchange="checkDate();"/>
	          								</div>
	      								</div>
									</div>
								</div>
						
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="toDate">To Date<span style="color: #cd2026;">*</span></label>
										<div class="form-group">
	        								<div class='input-group date' id=''>	
	        									<form:input path="" type="date" class="form-control" value=""
											 		id="toDate" placeholder="" onchange="checkDate();"/>
	          								</div>
	      								</div>
									</div>
								</div>
						</div> 
						
						
					
					 </div>
		             <div class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
						<div class="text-center">
							<button type="button" id="loadTable" class="custom-btn position-relative">Show Data</button>
						</div>
					</div>
	               	
	               	<fieldset id="dataTableDiv" class="mt-3">
		               	<div class="section-title"><h2 class="fw-bold">Uploaded Data List</h2></div>
		               	<div class="bg_white">
		               	<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
							<thead class="theadTransacColor">
					  			
							</thead>
						</table>
					</div>
					</fieldset>
					</form:form>
			</div>
		</div>

	<!--Begin: modal -->
		<!-- Modal -->

<!--Begin: modal -->
		<!-- Modal -->
				<div id="showDataModel" class="showDataModel modal" role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-bs-dismiss="modal" aria-label="modal Close button">
							<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
						</button>
					</div>
						<input type="hidden" name="docID" id="docID" aria-label="Doc ID"/>
						<input type="hidden" name="typeID" id="typeID"aria-label="TypeID"/>
						
					<div class="modal-body" id="showData">
						

					</div>
					<div class="modal-footer">
					<button type="button" class="custom-btn position-relative" onClick="xmlFunction($('#docID').val())">Download XML</button>
					
						<button type="button" class="hide btn-next btn_default btn-success">Next</button>
						<button type="button" class="btn_default" data-bs-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		
		<div id="showDataModel2" class="showDataModel modal " role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-bs-dismiss="modal" aria-label="modal Close button">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>

						

					</div>
					<input type="hidden" name="docID" id="docID" aria-label="Doc ID"/>
					<input type="hidden" name="typeID" id="typeID" aria-label="Type ID"/>
					<div class="modal-body" id="showData2">
						

					</div>
					<div class="modal-footer">
					<button type="button"  class="custom-btn position-relative" onClick="xmlFunction($('#docID').val())">Download XML</button>
					<button type="button" class="hide btn_default btn-prev">Prev</button>
					<button type="button" class="hide btn_default btn-success btn-next">Next</button>
						<button type="button" class="btn_default" data-bs-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		
				<div id="showDataModel3" class="showDataModel modal" role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
					
						<button type="button" class="close" data-bs-dismiss="modal" aria-label="modal Close button">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>

						

					</div>
					<input type="hidden" name="docID" id="docID" aria-label="Doc ID"/>
					<input type="hidden" name="typeID" id="typeID" aria-label="TypeID"/>
					<div class="modal-body" id="showData3">
						

					</div>
					<div class="modal-footer">
					<button type="button"  class="custom-btn position-relative" onClick="xmlFunction($('#docID').val())">Download XML</button>
					<button type="button" class="hide btn_default btn-prev">Prev</button>
						<button type="button" class=" btn_default" data-bs-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- End: modal -->


		

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