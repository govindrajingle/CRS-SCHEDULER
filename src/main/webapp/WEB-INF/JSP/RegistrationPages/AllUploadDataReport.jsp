<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>All Uploaded Data Report</title>
<style>
.modal-lg{
    max-width: 85%;
}
</style>

<script>
$(document).ready(function(){
	//alert("on load");
	$('#loadTable').click(function() {
		if($('#companyProfile').val() == -1 ){
			error_message("Please Fill all the Mandatory details!");
		}else{
			loadDataTable(1);
		}
	});
	$('#dataTableDiv').hide();
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

	$('#genPdf').click(function() {
		//alert("download report "+$('#companyProfile').val());
		if($('#companyProfile').val() == -1 ){
			error_message("Please Fill all the Mandatory details!");
		}else{
			var statusid = $('#companyProfile').val();
		 	var enFid1 = window.btoa(statusid);//DataEncoder.encode(statusid);
		 	var reverseval=reverseString(enFid1);
		 	var enFid = window.btoa(reverseval);
		 	//window.btoa(enFid);
		 	//alert(statusid+"   "+enFid);
			  var windowSizeArray = [
				        				"width=200,height=200",
				        				"width=300,height=400,scrollbars=yes",
				        				'margin=0px auto,width=' + window.outerWidth / 1.20
				        						+ ',height=' + window.outerHeight / 1.20
				        						+ ',scrollbars=yes' ]; 
		  			/* 	window.open("${pageContext.request.contextPath}/generateUploadedXMLPdf/"+enFid,"UploadedXMLData",windowSizeArray[2]); */


			  document.forms[0].action="${pageContext.request.contextPath}/generateUploadedXMLPdf";

			 	//alert(prodid);
				//alert(hscode);
       
           $("#userId").val(enFid);
         
          
           createFHash("frm"); 
           document.forms[0].method="post";
           document.forms[0].submit();
				
		}			
	 });
});

$(document).ready(function() {
    $('#m_table_2').DataTable();
} );
</script>
<script> 

//added by harshita  
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
			}
		],
						         	responsive: !0,
									columnDefs : [
											
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


function loadDataTable(statusID){
	
	$('#dataTableDiv').show();
	//alert($('#fromDate').val() +"  "+ $("#toDate").val()+"  "+$('#companyProfile').val());
	
	 $.ajax({
		
			type:"GET",
			data:{status :statusID, company:$('#companyProfile').val()},
			url :"getAllUploadXmlData",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
} 

</script>



<script>
		
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
	<div class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Uploaded Details</h1>
		</div>

		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__body bg_white">
	                <form:form method="post" id="frm" name="frm" modelAttribute="uploadData" enctype="multipart/form-data">
					<sec:csrfInput/>
	               	<form:hidden path="uploadId" id="uploadId"/>
	               	
	               	<div class="m-portlet__body">	
						<div class="row"> 
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
						<div id="companyWise">
								<table class="w-100 table table-striped table-bordered dt-responsive" id="m_table_2" style="width:100%;">
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
			

					<div align="center" class="mt-3">
						<button type="button" id="loadTable" class="custom-btn position-relative">Show Data</button>
						<button type="button" id="genPdf" class="btn btn-success btn_default">Generate Report</button>
					</div>
	               </div>
	               	<div id="dataTableDiv" class="mt-3">
		               	<div class="section-title"><h2>Uploaded Data List</h2></div>
		               		<table class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
							<thead class="theadTransacColor">
					  			
							</thead>
						</table>
					</div>
					
					
							<form:input type="hidden" id="userId" path="userId" />
						
					</form:form>

			</div>
		</div>
	</div>
</div>

<script>
var token_key = "NMD_TOKEN_KEY";
var createFHash = function(frmName){
//alert("createFHash same"+frmName);
	 datastring = $("form[name='"+frmName+"']").serializeArray();
	 
	 
	var tokenval = getHexaCode(datastring);
												
	
	//alert("token==="+tokenval);			 
	
	$('<input>').attr({
	    type: 'hidden',
	    id: token_key,
	    name: token_key,
	    value:tokenval
	}).appendTo('form');
	
 	
};
 
 var getHexaCode = function(datastring){
	
	 datastring.sort(function(a, b){
	        var a1= a.name.toLowerCase(), b1= b.name.toLowerCase();
	        if(a1== b1) return 0;
				   
				   
	        return a1> b1? 1: -1;
	    });
	     
	//alert("aaa"+datastring);
	console.log(datastring);
	
	
	
	var myInput = "";
	var datalength=0;
	$.each(datastring, function( index, val ) {
		 
		if(val.name != token_key){
			
			//alert( index + ": " + val.name +" ="+val.value+"=");
			
			var newVal =  val.value;
			
			if(newVal!=''){
				
				newVal = newVal.replace(/ /gi, "_");
				newVal	 = newVal.replace(/\n|\r\n|\r/g, '_');
				myInput = myInput+""+newVal;
				datalength=datalength+1;
			}
			
		}
		
		  
	});
	
	//console.log("str :: "+myInput);
	//alert(myInput);
	return hex_md5(myInput);
	
	//return myInput;
	
	
 };
 
 
var submitForm = function(){
	
	////alert("inside submitForm");
	 		
	document.forms[0].submit();
	
	
};
 
var getQueryParameters = function(str){
	str = str.split('?')[1];
	
	var outputArray = new Array();
	
	var strVals = str.split("&");
	
	for(var i=0; i< strVals.length; i++){
		
		var newVals = strVals[i].split("=");
		
		var obj = {name:""+newVals[0] , value:""+newVals[1]} ;
		
		outputArray[i] = obj;
		
	} 
	
	return outputArray;
	
};
</script>
 


      <script type="text/javascript" src="js/formFieldValidation/md5.js"></script> 

  --%>