
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>Generate Packing Code</title>

 <script>
var token_key = "NMD_TOKEN_KEY";
var createFHash = function(frmName){
//alert("createFHash same");
	 datastring = $("form[name='"+frmName+"']").serializeArray()
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





<script>
	$(document)
			.ready(
					function() {
						//alert("on load");
						loadDataTable(1);
						$("#frm")
								.bootstrapValidator(
										{
											fields : {
												packLevel : {
													validators : {
														callback : {
															message : 'Please specify pack level',
															callback : function(
																	value,
																	validator,
																	$field) {

																var options = validator
																		.getFieldElements(
																				'packLevel')
																		.val();

																return (options != 0);
															}
														}
													}
												},
												packType : {
													validators : {
														callback : {
															message : 'Please specify pack type',
															callback : function(
																	value,
																	validator,
																	$field) {

																var options = validator
																		.getFieldElements(
																				'packType')
																		.val();

																return (options != 0);
															}
														}
													}
												},
												dispatchDate : {
													selector : '#dispatchDate',
													validators : {
														notEmpty : {
															message : 'Dispatch date is required.'
														}
													}
												},
												codeCount : {
													validators : {
														notEmpty : {
															message : "Please specify code count."
														},
														regexp : {
															regexp : /^[0-9]{1,3}$/,
															message : "Only numbers are permitted."
														},
														stringLength : {
															min : 1,
															max : 3,
															message : "Code Count can contain maximum of 3 digits."
														}
													}
												}
											}
										});

						$('#save').click(
								function() {
									var bV = $("#frm").data(
											'bootstrapValidator');
									bV.validate();
									if (bV.isValid()) {
										confirm_alert(
												'Do you Really want to save?',
												'save');
									} else {
									}
								});

						if ('${flagSave}' == 1) {
							ok_message("Request saved succesfully.");
						}

						//Govind's edit to remove the ERROR OF SUBMITTING FORM AFTER PRESSING ENTERY ON EMPTY FIELD
						$(window).keydown(function(event) {
							if (event.keyCode == 13) {
								event.preventDefault();
								return false;
							}
						});

					});

	function confirm_alert(msg, type) {
		var m = msg.split('.');
		var msg1 = m[0];
		msg2 = m[1];
		swal({
			title : "Are you sure?",
			text : msg1,
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#34A534",
			confirmButtonText : "OK",
			cancelButtonText : "Cancel",
			closeOnConfirm : true,
			closeOnCancel : true
		}, function(isConfirm) {
			if (isConfirm) {
				if (type == "save") {
					submitForm();
				} else if (type == "ok") {
				}
			} else {

				imp = false;
			}
		});

	}

	function submitForm() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/saveGeneratePackCode";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}
</script>

<script>
	function initTable(id, x_size, y_size, statusID) {
		var Table = $(id)
				.DataTable(
						{

							columns : [

							{
								"sTitle" : "",
								"mData" : "num_req_id",
								"bVisible" : false
							}, {
								"sTitle" : "Pack Level",
								"mData" : "pack_level"
							}, {
								"sTitle" : "Pack Type",
								"mData" : "pack_type"
							}, {
								"sTitle" : "Dispatch Date",
								"mData" : "dispatchdate"
							}, {
								"sTitle" : "Code Count",
								"mData" : "num_noofcode_req"
							}, {
								"sTitle" : "Action",
								"mData" : "",
								"responsivePriority" : "1",
								"sWidth" : "8%"
							}

							],
							responsive : !0,
							order : [],
							columnDefs : [

									{
										"targets" : [],
										"className" : "none",

									},
									{
										"targets" : 5,
										"render" : function(data, type, row) {
											var c = "";

											c = '<div class="btn-group dropleft"><button class="dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-angle-down"><span class="sr-only">DropDown Doggle</span></i></button><div class="dropdown-menu " aria-labelledby="dropdownMenuButton">';
											c = c
													+ ""
													+ '<a class="dropdown-item" onclick = "downloadReqCode(\''+row.num_req_id+'\');">Download</a></div></div>';

											return c;

										}
									} ],
							destroy : true
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
			url : "getGeneratePackCode",
			success : function(response) {
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1", JSONObject.aaData, statusID);// Redraw the DataTable
			}
		});
	}

	function downloadReqCode(reqId) {
        //alert("hello");
        
		$('#packId').val(reqId);
		
		document.getElementById("frm").action = "${pageContext.request.contextPath}/downloadExcelGeneratePack";
		document.getElementById("frm").method = "POST";
		//createFHash("frm3");
		$("#frm").submit();
	}
</script>

<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Generate Packing Code</h1>
		</div>
		
		<form:form method="post" id="frm" name="frm" modelAttribute="generatePackModel" autocomplete="off">
			<sec:csrfInput />
			<form:hidden path="packId" id="packId" />

			<div class="panel panel-default " id="lic">
				<div class="panel-body dvfrm-panel-body">
					<div class="row">

						<div class=" col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="packLevel">Pack Level:<span
									style="color: #cd2026;">*</span></label>
								<form:select path="packLevel" class="form-control"
									id="packLevel">
									<form:option value="0">Select Level</form:option>
									<form:option value="1">Tertiary level</form:option>
									<form:option value="2">Secondary level 3</form:option>
									<form:option value="3">Secondary level 2</form:option>
									<form:option value="4">Secondary level 1</form:option>
									<%-- <form:option value="5">Primary Level</form:option> --%>
								</form:select>
							</div>
						</div>

						<div class=" col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="packType">Pack Type<span
									style="color: #cd2026;">*</span></label>
								<form:select path="packType" class="form-control"
									id="packType">
									<form:option value="0">Select Type</form:option>
									<form:option value="1">Homogeneous</form:option>
									<form:option value="2">Heterogeneous</form:option>
								</form:select>
							</div>
						</div>

						<div class="col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<div class="form-group">
									<label class="dvfrm-label" for="dispatchDate">Expected Dispatch Date<span
									style="color: #cd2026;">*</span></label>
								
									<div class='input-group date' id=''>
										<form:input path="dispatchDate" type="date"
											class="form-control" value="" id="dispatchDate" 
											placeholder="" />
										<!-- <span class="input-group-addon">
	                						<span class="glyphicon glyphicon-calendar"></span>
	  									</span>	 -->
									</div>
								</div>
							</div>
						</div>

						<div class=" col-lg-6 col-md-12 col-sm-12 col">
							<div class="form-group">
								<label class="dvfrm-label" for="codeCount">Code Count:<span
									style="color: #cd2026;">*</span></label>
								<form:input path="codeCount" type="text" class="form-control"
									id="codeCount" placeholder="Enter Number" />
							</div>
						</div>

					</div>
				</div>
			</div>

			<div class="text-center">
				<button type="button" class="custom-btn position-relative" id="save">
					Save</button>
				<button type="reset" class="btn btn_default" id="reset" onclick= "resetSelect2()">
					Reset</button>
			</div>

			<div class="bg_white">
				<table
				class="w-100 table table-striped table-borde#cd2026 dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed"
				id="m_table_1">
				<thead class="theadTransacColor">
					<tr>
					</tr>
				</thead>
			</table>
			</div>
		</form:form>
	</section>
</div>
	<script>
	$(function(){
	    var dtToday = new Date();

	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();

	    var minDate= year + '-' + month + '-' + day;

	    $('#dispatchDate').attr('min', minDate);
	});
	</script>
	
	
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