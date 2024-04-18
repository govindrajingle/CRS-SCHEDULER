<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>


<title>All Product Report</title>
<script type="text/javascript">
$(document).ready(function(){
	$('#loadTable').click(function() {
		if($('#prodType').val() == 0 || $('#hsCode').val() == 0){
			error_message("Please Fill all the Mandatory details!");
		}else{
			$('#dataTableDiv').show();
			loadDataTable(1);
		}
	});
	$('#dataTableDiv').hide();

	 $('#genPdf').click(function() {

		 
		// alert("hello");
		if($('#prodType').val() == 0 || $('#hsCode').val() == 0){
			error_message("Please Fill all the Mandatory details!");
		}else{
		
			//alert("download report "+$('#prodType').val());
			
			var prodid = $('#prodType').val();
		   var hscode = $('#hsCode').val();
		 	var enProdId1 = window.btoa(prodid);//DataEncoder.encode(statusid);
		 	var reverseval1=reverseString(enProdId1);
		 	var enProdId = window.btoa(reverseval1);
		 	//alert("prodid"+prodid);
		 	//alert("hscode"+hscode);
		 	
		 	var enHscodeId1 = window.btoa(hscode);

		 	var reverseval2=reverseString(enHscodeId1);
		 	var enHscodeId = window.btoa(reverseval2);
			//alert("enProdId"+enProdId);
		 	//alert("enHscodeId1"+enHscodeId1);
		 	
		 	//window.btoa(enFid);
		 	//alert(enProdId+"   "+enHscodeId);
			  var windowSizeArray = [
				        				"width=200,height=200",
	//			        				"width=300,height=400,scrollbars=yes",
				        				'margin=0px auto,width=' + window.outerWidth / 1.20
				        						+ ',height=' + window.outerHeight / 1.20
				        						+ ',scrollbars=yes' ]; 
				
			 // alert("download report11 "+windowSizeArray[2]);
		  				//window.open("${pageContext.request.contextPath}/generateAllProductPdf/"+enProdId+"/"+enHscodeId,"ProductDetails",windowSizeArray[2]);
		  				
		  				
			 document.forms[0].action="${pageContext.request.contextPath}/generateAllProductPdf";

			 	//alert(prodid);
				//alert(hscode);
         
             $("#enProdType").val(enProdId);
             $("#enHSCode").val(enHscodeId);


             
             createFHash("frm"); 
             document.forms[0].method="post";
             document.forms[0].submit();
			           
		  				//openWindowWithPost('POST', "${pageContext.request.contextPath}/generateAllProductPdf",{"enProdId":enProdId,"enHscodeId": enHscodeId },createFHash("frm"),'_blank');  	
		  				// createFHash("frm");
		  				// $('#frm').submit();
		  				
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
										"sTitle" : "Manufacturing Unit",
										"mData" : "manufacturingunit"
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
													"targets" : [8,9,10,11,12],
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
				status : statusID, prodType:$('#prodType').val(), hscode:$('#hsCode').val()
			},
			url : "getAllProductData",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				resetAndDrawTable("#m_table_1", JSONObject.aaData, statusID);// Redraw the DataTable
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
		<h1 class="fw-bold">Drug Details</h1>
	</div>

	<!--begin::Portlet-->
	<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
			</div>
			
			<form:form  id="frm" name="frm" modelAttribute="registrationForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
	             	
	             	<div class="m-portlet__body bg_white">	
						<div class="row"> 
							<div class="col-lg-6 col-md-12 col-sm-12 col">
						
								<div class="form-group">
									<label class="dvfrm-label" for="prodType">Product Type<span style="color: #cd2026;">*</span></label>
									<form:select class="form-control m-input" for ="prodType" id="prodType" path="" > 
										<form:option value="0">Select</form:option>
										<form:option value="12">Bulk Drug</form:option>
										<form:option value="11">Finished Formulation</form:option>
									</form:select>
								</div>
							</div>
							
							<div class="col-lg-6 col-md-12 col-sm-12 col">
								<div class="form-group">
						
							
								
									<label class="dvfrm-label" for="hsCode">H S Code<span style="color: #cd2026;">*</span></label>
									<form:select class="form-control m-input" for ="hsCode" id="hsCode" path="" > 
										<form:option value="0">Select Code</form:option>
										<c:forEach items="${hsCodeDtls}" var="c">
											<form:option value='${c.numHSCode}'>${c.numHSCode} ${c.strCommodityName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>	
					 </div>
					 
								<div class="col-lg-12" align="center">
									<button type="button" id="loadTable" class="custom-btn position-relative">Show Data</button>
									<button type="button" id="genPdf" class="btn_default btn-success">Generate Report</button>

								</div>
					
					<div id="dataTableDiv" class="bg-light mt-4">
					<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1" >
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
					</div>

							<form:input type="hidden" id="enProdType" path="enProdType" />
						<form:input type="hidden" id="enHSCode" path="enHSCode" />	
						
				</form:form>
		</div>
		<!--end::Portlet-->
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
