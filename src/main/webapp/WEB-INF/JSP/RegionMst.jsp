<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>Region Master</title>
<script type="text/javascript" src="js/validation/customValidation.js"></script>
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<script type="text/javascript" src="js/globalJs/globalJs.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	//alert("on load");
	
	$("#frm").bootstrapValidator({
			fields : {
				strRegionName : {
					validators : {
						notEmpty : {
							message : "Name is required and can\'t be empty"
						},
						regexp : {
							regexp : /^(?!.*\d{3})(?!.*[/.,()\-]{2})[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted, consecutive special characters not allowed"
						},	
						stringLength : {
							min : 2,
							max : 50,
							message : "Name can contain maximum of 50 characters"
						}
					}
				},
				strRegionCode : {
					validators : {
						notEmpty : {
							message : "Code is required and can\'t be empty"
						},
						regexp : {
							regexp : /^(?!.*\d{3})(?!.*[/.,()\-]{2})[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted, consecutive special characters not allowed"
						},	
						stringLength : {
							min : 2,
							max : 50,
							message : "Code can contain maximum of 50 characters"
						}
					}
				},
				strRemarks : {
					validators : {
						regexp : {
							regexp : /^(?!.*\d{3})(?!.*[/.,()\-]{2})[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted, consecutive special characters not allowed"
						},	
						stringLength : {
							min : 3,
							max : 50,
							message : "Remarks can contain maximum of 50 characters"
						}
					}
				}
			}
		}); 
	
	loadDataTable(1);

	if('${flagSave}'== 1){
		ok_message("New Record Added Successfully.");
	}else if('${flagUpdate}'== 1){
		ok_message("Record Updated Successfully.");
	}else if('${flagDelete}'== 1){
		ok_message("Record Deleted Successfully.");
	}
	
	$("#modify").hide();
	$("#delete").hide();
	$('#save').click(function() {
		//alert("saved");
		var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
			}
			else{
			}
	});

 
	$('#modify').click(function() {
		var selectedval=$('input[name=uid]:checked', '#frm').val();
		var checked = [];
		$('#numRegionId').val(selectedval);
		$(".radio:radio").each(function() {
			if (this.checked) {
				checked.push($(this).val());
			}
		});
	
		$("#radio").val(checked);
		if (checked.length > 0) {
			 var bV = $("#frm").data('bootstrapValidator');
			   bV.validate();
				if(bV.isValid()){ 
					$("#radio").val(checked);
					confirm_alert('Do you Really want to modify?','modify');
				}
				else{
				}
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
			confirm_alert('Do you Really want to delete?','delete');
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
		 
		 $('#strRegionName').val(resultArray1[1]);

		 $('#strRegionCode').val(resultArray1[2]);

		 $('#strRemarks').val(resultArray1[3]);
	});
	
	
    //Govind's edit to remove the ERROR OF SUBMITTING FORM AFTER PRESSING ENTERY ON EMPTY FIELD
    $(window).keydown(function(event){
      if(event.keyCode == 13) {
        event.preventDefault();
        return false;
      }
    }); 
});

</script>


<script>
var token_key = "NMD_TOKEN_KEY";

var createFHash = function(frmName){

  // alert("createFHash in same");
	 datastring = $("form[name='"+frmName+"']").serializeArray()
	var tokenval = getHexaCode(datastring);
	
	//alert("token saaa==="+tokenval);
	

	$('<input>').attr({
	    type: 'hidden',
	    id: token_key,
	    name: token_key,
	    value:tokenval
	}).appendTo('form');
	


	
 	
};

 
 var getHexaCode = function(datastring){
	//alert("in hex code"+datastring);
	 datastring.sort(function(a, b){
	        var a1= a.name.toLowerCase(), b1= b.name.toLowerCase();
	        if(a1== b1) return 0;
	        return a1> b1? 1: -1;
	    });
	     
	//alert(datastring);
	console.log(datastring);
	
	
	
	var myInput = "";
	var datalength=0;

	$.each(datastring, function( index, val ) {
		 
		if(val.name != token_key){
			
			////alert( index + ": " + val.name +" ="+val.value+"=");
			
			var newVal =  val.value;
			
			if(newVal!=''){
				
				newVal = newVal.replace(/ /gi, "_");
				newVal = newVal.replace(/\n|\r\n|\r/g, '_');
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

<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		  			{
						"sTitle" : "",
						"mData" : "num_region_id"
					},	
					{
						"sTitle" : "Region Name",
						"mData" : "str_region_name"
					},
					{
						"sTitle" : "Region Code",
						"mData" : "str_region_code"
					},
					{
						"sTitle" : "Remarks",
						"mData" : "str_remarks"
					}
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
										+ row.num_region_id
										+ '" value="'
										+ $('<div/>').text(data).html()
										+ '">';
										
							}
						},
						{
							"targets": [],
			                 "className": "none",
			             	  
			            }
			            ],
    	
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
			url :"getRegionMasterDetails",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}

function  confirm_alert(msg,type){
	var m = msg.split('.');
	    var msg1=m[0];
	    msg2=m[1];
		swal(
				{  		
				title: "Are you sure?",   text: msg1,   
				type: "warning",  
				showCancelButton: true,   
				confirmButtonColor: "#34A534",   
				confirmButtonText: "OK",   
				cancelButtonText: "Cancel",   
				closeOnConfirm: true,   
				closeOnCancel:true 
				}, 
				function(isConfirm){   
				    	  if (isConfirm) {
				    		  
				    		  if(type=="save")
								{				
								submit_form();
								}
							else if(type=="delete")
								{
								 flag=true; 
								 delete_form();
								}
							else if(type=="modify")
							{
								update_form();
							}
							else if(type=="ok")
							{
								 flag=true; 
								submit_form_delete();	
								}
					    	  } 

				    	  else {
				    		  imp=false;
				    	  }
				    	});
}

function submit_form(){
	
	//alert("submit_form");
	
	
	createFHash("frm");
	
	document.getElementById("frm").action = "${pageContext.request.contextPath}/saveRegionMaster";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();  
}

function update_form(){
	
	

	createFHash("frm");
	
	document.getElementById("frm").action = "${pageContext.request.contextPath}/updateRegionMaster";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}

function delete_form(){
	

	createFHash("frm");
	
	document.getElementById("frm").action = "${pageContext.request.contextPath}/deleteRegion";
	document.getElementById("frm").method = "POST";
	document.getElementById("frm").submit();
}
</script>

<div class="content-wrapper mt-0 pt-0">
<section class="regdv content content-tiles">
	<div class="page-title"><h1 class="fw-bold">Region Details</h1></div>
			<form:form method="post" id="frm" name="frm"  modelAttribute="RegionMstModel" autocomplete="off">
				<sec:csrfInput/>
				<form:hidden path="numRegionId" id ="numRegionId" aria-label="Number Region Id"></form:hidden>	
				<form:input type="hidden" id="radio" path="radio"  aria-label="Radio Button"/>
					
				<div class="panel panel-default " id="lic">
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
							
								<div class=" col-lg-4 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="strRegionName">Region Name<span style="color: #cd2026;">*</span></label>
									<form:input type="text" path="strRegionName"  class="form-control m-input" id="strRegionName" placeholder="Enter Region Name"/>
								</div>
							
								<div class=" col-lg-4 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="strRegionCode">Region Code<span style="color: #cd2026;">*</span></label>
									<form:input type="text" path="strRegionCode"  class="form-control m-input" id="strRegionCode" placeholder="Enter Region Code"/>
								</div>
								
								<div class=" col-lg-4 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="strRemarks">Remarks</label>
									<form:input type="text" path="strRemarks"  class="form-control m-input" id="strRemarks" placeholder="Enter Remarks"/>
								</div>
								
							</div>
						</div>	
				</div>
				
				<div class="text-center">
					<button type="button" id="save" class="btn_default btn-success">Save</button>
								<button type="button" id="modify" class="custom-btn position-relative">Modify</button>
								<button type="button" id="delete" class="btn_default btn-danger">Delete</button>
								<button type="button" id="reset" onclick= "resetSelect2()" class="btn_default">Reset</button>
               	</div>
               	
               	<fieldset class="mt-2">
               	<div class="section-title"><h2>Region List</h2></div>
               	<div class="bg_white">
               	<table class="w-100 table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered dspit" id="m_table_1">
							<thead class="theadTransacColor">
					  			<tr>				
						  		</tr>
							</thead>
						</table>
					</div>
				</fieldset>
			</form:form>
	</section>
	
</div>


<script>

	function resetSelect2(){

		location.reload(true);

		
	}
	</script>
	
	<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script>
</body>
</html>

 --%>