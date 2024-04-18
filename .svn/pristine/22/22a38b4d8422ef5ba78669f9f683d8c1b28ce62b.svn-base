<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>


<script type="text/javascript">
$(document).ready(function(){
	//alert("in location");
	$('#dataTableDiv').hide();
	$('#loadTable').click(function() {
		//alert("1   "+$('#finalApprovalStatus').val());
		if($('#finalApprovalStatus').val() == -1 ){
			error_message("Please Fill all the Mandatory details!");
		}else{
			loadDataTable(1);
		}
	});

	$('#genPdf').click(function() {
		//alert("download report "+$('#finalApprovalStatus').val());
		if($('#finalApprovalStatus').val() == -1 ){
			error_message("Please Fill all the Mandatory details!");
		}else{
			var statusid = $('#finalApprovalStatus').val();
			//alert(statusid);
		 	var enFid1 = window.btoa(statusid);//DataEncoder.encode(statusid);
		 //	alert(enFid1);
		 	var reverseval=reverseString(enFid1);
		 	//alert(reverseval);
		 	var enFid = window.btoa(reverseval);
		 	//alert(enFid);
		 	//window.btoa(enFid);
		 	//alert(statusid+"   "+enFid);
			  var windowSizeArray = [
				        				"width=200,height=200",
				        				"width=300,height=400,scrollbars=yes",
				        				'margin=0px auto,width=' + window.outerWidth / 1.20
				        						+ ',height=' + window.outerHeight / 1.20
				        						+ ',scrollbars=yes' ]; 
		  				//window.open("${pageContext.request.contextPath}/generateCorporatePdf/"+enFid,"CorporateDetails",windowSizeArray[2]);
		 	//window.location.href='${pageContext.request.contextPath}/generateCorporatePdf?enFid='+enFid;

			  document.forms[0].action="${pageContext.request.contextPath}/generateCorporatePdf";

			 	//alert(prodid);
				//alert(hscode);
     
         $("#status").val(enFid);
       
        
         createFHash("frm"); 
         document.forms[0].method="post";
         document.forms[0].submit();
				




				}
		  			
	 });
});
</script>

<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		  		
		{
			"sTitle" : "",
			"mData" : "user_id",
			"bVisible" : false
		},
		{
			"sTitle" : "User Name",
			"mData" : "user_name"
		},
		{
			"sTitle" : "Applicant Type",
			"mData" : "str_appl_type_name"
		},
		{
			"sTitle" : "Organisation Type",
			"mData" : "org_type"
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
		},
		{
			"sTitle" : "Status",
			"mData" : "pharmstatus"
		},
		{
			"sTitle" : "",
			"mData" : "num_approval_status_pharmaexil",
			"bVisible" : false
		}
		
				],
				responsive: !0,
				columnDefs : [
						
						{
							"targets": [3,4,5,8,9,10,11,14],
			                 "className": "none",
			             	  
			             }
			             ],
							destroy: true
    	
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
	//alert("2"+ $('#finalApprovalStatus').val());
	$('#dataTableDiv').show();
		$.ajax({
			type:"GET",
			data:{status :statusID, appstatus:$('#finalApprovalStatus').val()},
			url :"getAllRegistrationDataListing",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}
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
<div class="content-wrapper mt-0 pt-0">
	<div class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Corporate/Users Details</h1>
		</div>
		<!--begin::Portlet-->
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
			</div>
			
			<form:form  id="frm" name="frm" modelAttribute="registrationForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
				<form:hidden id="userId" path="userId" aria-label="userId"/>
	             		<div class="row bg_white"> 
							<div class="col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
									<label class="dvfrm-label w-100" for="finalApprovalStatus">Select Status<span style="color:#cd2026;">*</span></label>
									<form:select class="form-control m-input"  id="finalApprovalStatus" path="finalApprovalStatus" selectcheck="true"> 
										<%-- <form:option value="5">All</form:option> --%>
										<form:option value="-1">Select</form:option>
										<form:option value="0">Pending</form:option>
										<form:option value="1">Approved</form:option>
										<form:option value="2">Rejected</form:option>
									</form:select>
								</div>
							</div>

							<div class="col-lg-12 col-md-12 col-sm-12 col mt-2 text-center">
								<button type="button" id="loadTable" class="custom-btn position-relative">Show Data</button>
								<button type="button" id="genPdf" class="btn-success btn_default">Generate Report</button>
							</div>
					</div>

						</div>
						
					
					<div id="dataTableDiv" class="bg_white mt-3">	
					<table class="w-100 table table-striped table-bordered dt-responsive" id="m_table_1" style="width:100%;" >
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
					</div>
					
						<form:input type="hidden" id="status" path="status" />
						
				</form:form>
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
