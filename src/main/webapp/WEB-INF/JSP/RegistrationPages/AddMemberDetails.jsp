<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>Add Member Details</title>
	<!-- File Upload -->
	<script src="js/homepage/jquery.ui.widget.js"></script>
	<script src="js/homepage/jquery.iframe-transport.js"></script>
	<script src="js/homepage/jquery.fileupload.js"></script>
	<script src="js/homepage/moment.min.js"></script>
	<script src="js/homepage/date.js"></script>	
<!--<script src="https://momentjs.com/downloads/moment.js"></script>
	<script src="http://www.datejs.com/build/date.js" type="text/javascript"></script> -->
<script>
$(document).ready(function(){


	//alert("on load");
	$("#fileupload").on("change", uploadFile);
	$('#fileuploadRemove').hide();
	$("#modify").hide();
	$("#delete").hide();
	loadDataTable(1);
	
	       
	$("#frm")
	.bootstrapValidator(
		{
			fields : {
				numMemberType : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Member Type',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('numMemberType').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  numGender : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Gender',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('numGender').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  strMemberName : {
					validators : {
						notEmpty : {
							message : "Name is required and can\'t be empty"
						},
						regexp: {
						    regexp: /^[a-zA-Z\s]+$/,
						    message: "Only alphabets and spaces are permitted"
						},
						stringLength : {
							min : 2,
							max : 50,
							message : "Name can contain maximum of 50 characters"
						}
					}
				},
				numstatus : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Status',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('numstatus').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  strDesignation : {
					validators : {
						notEmpty : {
							message : "Department name is required and can\'t be empty"
						},
						regexp: {
						    regexp: /^(?![0-9]{2,})(?!.*\d{2})[a-zA-Z0-9().\/,\s\-]+$/,
						    message: "Only alphabets, single numbers, special characters( / , . () - ) and spaces are permitted, and consecutive numbers are not allowed"
						},
						stringLength : {
							min : 2,
							max : 20,
							message : "Department name can contain maximum of 20 characters"
						}
					}
				},
				numContactNo : {
					validators : {
						notEmpty : {
							message : "Contact Number is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[0-9().\/,\s\-]+$/,
							message : 'Only numbers are permitted'
						},

						stringLength : {
							min : 10,
							max : 10,
							message : 'Contact Number can contain minimum 10 and maximum of 10 characters'
						}
					}
				},
				idProofTypeId : {
					validators : {
						callback: {
	 				           message: 'Please specify ID Proof Type',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('idProofTypeId').val();

	 				               return (options != 0);
	 				           }
						}
					}
				},strCardNumber : {
					validators : {
						notEmpty : {
							message : "ID Proof No is required and can\'t be empty"
						},
						regexp : {
							regexp :/^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/,
							//regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							//message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
							message : "Please enter valid pan number"
						},
						stringLength : {
							min : 10,
							max : 10,
							message : 'Card Number can contain maximum of 10 characters'
						}
					}
				},numFaxNo : {
					validators : {
						regexp : {
							regexp : /^[0-9().\/,\s\-]+$/,
							message : 'Only numbers are permitted'
						},

						stringLength : {
							min : 6,
							max : 6,
							message : 'Fax Number can contain maximum of 6 characters'
						}
					}
				},
				dateOfJoining : {
					/* selector : '#dateOfJoining', */
					//addedbyharshita
				 selector : '#joiningDate',
					validators : {
						notEmpty : {
							message : 'The Date is required'
						}
					}
				},
				strEmail : {
					validators : {
						notEmpty : {
							message : "Email is required and can\'t be empty"
						},
						regexp : {
							regexp : '^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$',
							message : 'Please enter a valid email address'
						},
						stringLength : {
							min : 1,
							max : 50,
							message : "Email can contain maximum of 50 characters"
						}
					}
				}
			}
		});
	
	/* $("select#joiningDate").change(function() {
		alert("kufygh");
		if ($('#joiningDate').val() != '') {
			alert("check date");
			var curDate = new Date();
			alert(curDate);
			var joinDate = $('#joiningDate').val();
			alert(joinDate);
		}
	}); */
	
	$(document).on('click','#radio',function(e){

		//alert("in radio");
        $("#save").prop("style").display="none";
        $("#modify").show();
        $("#delete").show();

	 	var resultArray1 = $(this).closest('tr').find('td').map( function(){
			return $(this).text();
		}).get();
 		var checkID = $(this).closest('tr').find('input[type=radio]').map( function(){
			return $(this).val();
		}).get();
 		//alert("checkID------  "+checkID);
 		
 		$('#numMemberId').val(checkID);
 		$('#memName').val(resultArray1[2]);

 		getDetails(checkID);
		// $('#brandName').val(resultArray1[4]);
		//alert("resultArray1[5]--- "+resultArray1[5]);
		//alert("resultArray1[6]--- "+resultArray1[6]);
		  	
		$('#memDesg').val(resultArray1[3]);
		$('#contactNumber').val(resultArray1[6]);
		$('#faxNumber').val(resultArray1[8]);
		$('#idCardNo').val(resultArray1[10]);
		$('#emailId').val(resultArray1[7]);


		
		var date = resultArray1[5];
		<%java.text.DateFormat df = new java.text.SimpleDateFormat("mm/dd/yyyy"); %>
		<%= df.format(date) %>



		/*  DateFormat sourceFormat = new SimpleDateFormat("mm/dd/yyyy");
		var date = sourceFormat.format(resultArray1[5]);
		alert("date::::"+date); */
   


	        $("#joiningDate").val(resultArray1[5]);
		
		//alert("hello" + resultArray1[5] );
		
		if(resultArray1[9]=="NA"){

			$('#idProof').each(function () {
				$('option', this).each(function () {
					if ($.trim($(this).text().toLowerCase()) == $.trim("Select").toLowerCase()) 
					{
						$(this).prop('selected', 'selected');
						return false;
					};
				});
			});
			
			}
		else{

			$('#idProof').each(function () {
				$('option', this).each(function () {
					if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[9]).toLowerCase()) 
					{
						$(this).prop('selected', 'selected');
						return false;
					};
				});
			});
			}
		

		$('#gender').each(function () {
			$('option', this).each(function () {
				if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[4]).toLowerCase()) 
				{
					$(this).prop('selected', 'selected');
					return false;
				};
			});
		});

		$('#memberType').each(function () {
			$('option', this).each(function () {
				if ($.trim($(this).text().toLowerCase()) == $.trim(resultArray1[1]).toLowerCase()) 
				{
					$(this).prop('selected', 'selected');
					return false;
				};
			});
		});

    	
	});
	
		function getDetails(memId){

			//alert("getDetails");
			
			 $.ajax({
				type:"GET",
				data:{memId :memId},
				url :"getAddedMemberData/"+memId,
				success: function(response){

					if(response.length!=0)
					{
					if(response[0].numDocumentId != '-1'){
						
						$('#fileuploadRemove').show();
		  	       		$('#fileupload').hide();
		  	       		$('#fileuploadDownloadLink').attr('href',"${pageContext.request.contextPath}/downloadTmpFile_Secure/" +response[0].numDocumentId+ "/"+1);
						$('#strDocId').val(response[0].numDocumentId);
						}
					
					
					}
				}
			});
	 		}

	$('#modify').click(function() {
		var selectedval=$('input[name=uid]:checked', '#frm').val();
		//alert(selectedval);
		var checked = [];
		//alert("in mod "+$("#manuUnit").val());
			$('#numMemberId').val(selectedval);
		
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

		} else {
		}

	});

	$('#delete').click(function() {
		var selectedval=$('input[name=uid]:checked', '#frm').val();
		var checked = [];
		$('#numMemberId').val(selectedval);
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


	 $('#save').click(function() {
		 var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
			}
			else{
			}
		});
	
	
	if('${flagSave}'== 1){
		ok_message("New Record Added Successfully.");
		
	}

	if('${flagUpdate}'== 1){
		ok_message("Record is Updated succesfully.");
	}
	
	if('${flagDelete}'== 1){
		ok_message("Record is deleted succesfully.");
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
					    			  var pan1=btoa($('#idCardNo').val());
					  				var pan2=reverseString(pan1);
					  				$("#idCardNo").val(btoa(pan2)); 
									submit_form();
									}
								else if(type=="delete")
									{
									 flag=true; 
									submit_form_delete();
									}
								else if(type=="modify")
								{
									var pan1=btoa($('#idCardNo').val());
					  				var pan2=reverseString(pan1);
					  				$("#idCardNo").val(btoa(pan2));


					  				 var somecheck=$('#fileupload').val().toString();
					  				//alert(somecheck);
					  						var path=somecheck.toString();
					  						 var r1=btoa(somecheck);
					  						// alert("r1:::"+r1);
					  						 var r2=reverseString(r1);
					  			 				var r3=btoa(r2);
					  						 $('#hashValue').val(r3);
									
									submit_form_update();
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
		document.getElementById("frm").action = "${pageContext.request.contextPath}/saveMemberDetail";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}

	function submit_form_update() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/updateMemberDetails";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}

	function submit_form_delete() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/deleteMemberDetails";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}
	
	
	
	//Govind's edit to remove the ERROR OF SUBMITTING FORM AFTER PRESSING ENTERY ON EMPTY FIELD
	$(window).keydown(function(event){
	  if(event.keyCode == 13) {
	    event.preventDefault();
	    return false;
	  }
	});    
	
});


function getSignatureChecksum(res){
	 
	 var form = $('#frm')[0];
	 var data = new FormData(form);
	 
	 $.ajax({
		  	type: "POST",
			url : "xmlChecksum",
			enctype: 'multipart/form-data',
		    data : data,	
		    cache : false,
         processData : false,
         contentType : false,
         timeout: 600000,
		 	success : function(response){
			 if(response.length>0){
				 $('#xmlUploadData').val(response);
				 res=response;
				 
				 
			 }else{
				 alert("Error");
			 }
		 }
		});
	
}



function uploadFile() {
	
	var form = $('#frm')[0];
	 var data = new FormData(form);
	
	 $.ajax({
		  	type: "POST",
			url : "xmlChecksum",
			enctype: 'multipart/form-data',
		    data : data,	
		    cache : false,
        processData : false,
        contentType : false,
        timeout: 600000,
		 	success : function(response){
			 if(response.length>0){
				 $('#xmlUploadData').val(response);
				 let res=response;
				 
				 var somecheck=$('#fileupload').val().toString();
			//alert(somecheck);
					var path=somecheck.toString();
					 var r1=btoa(somecheck);
					// alert("r1:::"+r1);
					 var r2=reverseString(r1);
		 				var r3=btoa(r2);
					 $('#hashValue').val(r3);
					 
				 var filename = "IdProofshubham"+res;
					var docId = "";
					if($('#strDocId').val() == "-1")
						docId=0;
					else
						docId = $('#strDocId').val();
					
					  $.ajax({
					    url: "uploadFile/"+filename+"/"+docId,
					    type: "POST",
					    data: new FormData($("#frm")[0]),
					    enctype: 'multipart/form-data',
					    processData: false,
					    contentType: false,
					    cache: false,
					    success: function (response) {
						    
					    	var Obj_List = response;
					  	  /*  alert("obj info "+Obj_List[0].eNSuccessFlag);
					  	   alert("obj info "+Obj_List[0].successFlag);
					  	   alert("obj info "+Obj_List[0].fileName); */
					  	   var eNSuccessFlag = Obj_List[0].eNSuccessFlag;
					  	 	  var SuccessFlag = Obj_List[0].successFlag;
					  	 	  var FileName = Obj_List[0].fileName;
					  	 	 /*  alert(FileName); */
					  	 	 //alert("obj info "+Obj_List[0].successFlag);
					  		 

					  	
					  			if (SuccessFlag == 0 || SuccessFlag == 1){
					  		   	error_message("Please upload only PDF files");
					  		   	$('#numDocId').closest('.form-group').addClass('has-error');
					  		  $("#fileupload").val('');
					  		   	}
					  		   	if (SuccessFlag== 2){
					  		   	error_message("File size should be more than 0 and less than 10 MB  ");
					  		   	$('#numDocId').closest('.form-group').addClass('has-error');
					  		  $("#fileupload").val('');
					  		   	} 
					  		   	if (SuccessFlag == 3){
					  		   	error_message("There was some error in uploading the file. Please try again.");
					  		   	$('#numDocId').closest('.form-group').addClass('has-error');
					  		  $("#fileupload").val('');
					  		   	}
					  		 	if (SuccessFlag == 4){
					  		        error_message("PDF is Corrupted. Please try again.");
					  			   	$('#numDocId').closest('.form-group').addClass('has-error');
					  			 	 $("#fileupload").val('');
					  		       	}
					  		   	if (SuccessFlag >=5){
					  		   		/* alert("File Uploaded Successfully");	 */	  		
					  		   		$('#numDocId').closest('.form-group').removeClass('has-error').addClass('has-success');
					  		   	 	$('#strDocId').val(eNSuccessFlag);
					  		   	 	$('#numDocId').val(5);
					  		   	/* 	$('#fileuploadName').text(FileName); */
					  		   		$('#fileuploadRemove').show();
					  	       		$('#fileupload').hide();
					  	       		//alert("eNSuccessFlag---   "+eNSuccessFlag);
					  	       		$('#fileuploadDownloadLink').attr('href',"${pageContext.request.contextPath}/downloadTmpFile_Secure/" +eNSuccessFlag+ "/"+1);
					  	       		$('#fileuploadDownloadLink').text('Download('+FileName+')');
					  	       		//$('#submit1').removeAttr('disabled');

					  	       		/* $('#progress1fileupload').show();
					  	       		setTimeout(
					  	       			  function() 
					  	       			  {
					  	       				$('#progress1fileupload').hide();
					  	    	       		$('#progress2fileupload').show();
					  	       			  }, 500);
					  	       		
					  	       		setTimeout(
					  	       			  function() 
					  	       			  {
					  	       				$('#progress2fileupload').hide();
					  	    	       		$('#progress3fileupload').show();
					  	       			  }, 1000); */
					  		   		//	 $('#fileupload').attr('disabled','disabled');	
					  		    	}

						      
					    },
					    error: function () {
					      // Handle upload error
					      // ...
					    }
					  });
				 
				 
			 }else{
				 alert("Error");
			 }
		 }
		});
	
	}



function reverseString(str) {
	//alert ('Hello');
    var newString = "";
    for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
    }
    return newString;
}



function showAppFile(divName, divfile) {

	$('#fileupload').val('');
	$('#' + divName).hide();
	$('#' + divfile).show();

}

</script>
<script>

function test(){
		$("#modify").hide();
		 $("#delete").hide();
		 $("#save").show();
	 	showAppFile('fileuploadRemove','fileupload');
		$('#frm')[0].resetForm();
	 
}


function checkJoinDate(){
	if ($('#joiningDate').val() != '') {
		var curDate = new Date();
		var joinDate = $('#joiningDate').val();
		var joinDateSplit = joinDate.split("-");
		objJoinDate = new Date(joinDateSplit[1] + " " + joinDateSplit[2] + " " + joinDateSplit[0]);
		if (curDate < objJoinDate) {
			warning_message("Joining Date cannot be greater than current date!.");
			$('#joiningDate').val("");
		} else {
		}
	
	}
} 
</script>

<script>
function initTable(id,x_size,y_size,statusID){
	var Table = $(id).DataTable({

		columns: [
		  		{"sTitle" : "Select", "mData" : "num_memb_id"},
		  		{"sTitle" : "Member Type",   "mData" : "membertype"},
				{"sTitle" : "Member Name",   "mData" : "str_member_name"},
				{"sTitle" : "Designation",   "mData" : "str_member_desig"},
				{"sTitle" : "Gender",    "mData" : "gender"},
				{"sTitle" : "Date Of joining",    "mData" : "joiningdate"},
				{"sTitle" : "Mobile No",     "mData" : "str_contact_no"},
				{"sTitle" : "Email",       "mData" : "str_email"},
				{"sTitle" : "FAX No",       "mData" : "str_fax_no"},
				{"sTitle" : "Id Proof",      "mData" : "idprooftype" , "bVisible": false},
				{"sTitle" : "Id Proof No",      "mData" : "str_idcard_no", "bVisible": false},
				
				
				
				
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
								return '<input type="radio" class="radio" aria-label="Radio Button" name="uid" id ="radio"'
										+ row.user_id
										+ '" value="'
										+ $('<div/>').text(data).html()
										+ '">';
										
							}
						},
						{
							"targets": [2,3,4,9,10],
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
			url :"getAddedMemberList",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}
</script>
<div class="content-wrapper mt-0 pt-0">
<section class="regdv content content-tiles">
	<div class="page-title">
		<h1 class="fw-bold">Add Authorized Signatory / Responsible Person</h1>
	</div>
			<form:form method="post" id="frm" name="frm" modelAttribute="memberDtlForm" enctype="multipart/form-data" autocomplete="off">
				<c:forEach items="${errors }" var="error">
                    	<div class="alert alert-success" role="alert">
  							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  						<div class="text-danger">
							<c:out value="${error }"></c:out>
						</div>
						</div>	
				</c:forEach>
				<sec:csrfInput/>
					<form:hidden path="numMemberId" id="numMemberId" />
				<div class="panel panel-default " id="addressDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Add Authorized Signatory/Responsible Person Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="memDesg">Department:<span style="color: #cd2026;">*</span></label>
									
											<form:input path="strDesignation" type="text" class="form-control"
											 id="memDesg" placeholder="Enter Department" required="required"/>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="memName">Name:<span style="color: #cd2026;">*</span></label>
										<form:input path="strMemberName" type="text" class="form-control"
									 			id="memName" placeholder="Enter Authorized Person Name" required="required"/>	
									</div>
								</div>

								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="gender">Gender:<span style="color: #cd2026;">*</span></label>
										<form:select path="numGender" class="form-control" id="gender" required="required">
											<form:option value="0">Select Gender</form:option>
											<form:option value="1">Male</form:option>
											<form:option value="2">Female</form:option>
										</form:select>	
									</div>
								</div>

								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="memberType">Designation:<span style="color: #cd2026;">*</span></label>
										<form:select path="numMemberType" class="form-control" id="memberType" required="required">
											<form:option value="0">Select Authorized Person Designation</form:option>
											<c:forEach items="${memTypeList}" var="s">
												<option value='${s.numTypeId}'>${s.strTypeName}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="contactNumber">Mobile Number:<span style="color: #cd2026;">*</span></label>
										<form:input path="numContactNo" type="text" class="form-control"
									 			id="contactNumber" placeholder="Enter Authorized Person Mobile Number"/>	
									</div>
								</div>

								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="emailId">Email Id:<span style="color: #cd2026;">*</span></label>
										<form:input path="strEmail" type="text" class="form-control"
									 			id="emailId" placeholder="Enter Authorized Person EmailId" required="required"/>	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class=" form-group">
										<label class="dvfrm-label" for="faxNumber">Fax Number:</label>
										<form:input path="numFaxNo" type="text" class="form-control"
									 			id="faxNumber" placeholder="Enter Fax Number" />	
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<label class="dvfrm-label" for="idProof">Status:<span style="color: #cd2026;">*</span></label>
										<form:select path="numstatus" class="form-control" id="idProof" required="required" >
											<form:option value="0">--select One--</form:option>
											<form:option value="1">Active</form:option>
											<form:option value="2">Inactive</form:option>
										</form:select>
								</div>
								
								<div class="col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="joiningDate">Date of Joining<span style="color: #cd2026;">*</span></label>
										<div class="form-group">
	        								<div class='input-group date' id=''>	
	        									<form:input path="dateOfJoining" type="date" class="form-control" value=""
											 	id="joiningDate" placeholder="" onchange="checkJoinDate();"/>
											 	<span class="input-group-addon">
	                        						<!-- <span class="glyphicon glyphicon-calendar"></span> -->
	          									</span>	
	          								</div>
	      								</div>
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="idProof">Id Proof Details:<span style="color: #cd2026;">*</span></label>
											<form:select path="idProofTypeId" class="form-control" id="idProof" required="required" >
												<form:option value="0">Select</form:option>
												<form:option value="1">PAN Card</form:option>
												<form:option value="2">PassPort</form:option>
											</form:select>
									</div>
								</div>
								
								<div class=" col-lg-6 col-md-12 col-sm-12 col">
									<div class="form-group">
										<label class="dvfrm-label" for="idCardNo">ID Proof No:<span style="color: #cd2026;">*</span></label>
										<form:input path="strCardNumber" type="text" class="form-control"
										<form:input path="strCardNumber" type="password" class="form-control"
									 			id="idCardNo" placeholder="Enter ID Card Number" />	
									</div>
								</div>
								
								  <div class="col-lg-6 col-md-12 col-sm-12 col">
									  <div class="form-group">
										<form:hidden path="numDocId" id="numDocId" />
										<form:hidden  path="strDocId" id="strDocId"  value="-1" />
										<label class="dvfrm-label" for="fileupload">Company ID Card<span style="color: #cd2026;">*</span></label>
											<div id="idUpload">
												<input class="form-control" id="fileupload"
													type="file" accept="application/pdf" name="uploadfile" />
												<input type="hidden" name="xmlUploadData" id="xmlUploadData">
												<input type="hidden" name="hashValue" id="hashValue">
											</div>
											<div id="fileuploadRemove">
												<!-- <a id="fileuploadDownloadLink" href="#">download</a> -->
												<button type="button" id="fileuploadRemoveBtn" class="btn btn-primary"
														onclick="showAppFile('fileuploadRemove','fileupload')">Remove</button>
											</div>
										</div> 
									</div> 
									
								
								
							</div>
						</div>
				</div>
				
				
				<div class="text-center">
					<button type="button" class="custom-btn position-relative" id="save"> Save </button>
					<button type="button" id="modify" class="btn_default btn-success">Modify</button>
					<button type="button" id="delete" class="btn_default btn-danger">Delete</button>
                	<button type="reset" class="btn_default" id="reset" onClick="test()"> Reset </button>
               	</div>
               	
               	<fieldset class="mt-2">
               		<div class="section-title"><h2>Member Detail List</h2></div>
               	<div class="bg_white">
                	<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1" >
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

 <!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script> --%>