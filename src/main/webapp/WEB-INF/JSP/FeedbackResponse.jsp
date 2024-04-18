<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%> 


<title>Feedback Response</title>
<script type="text/javascript" src="js/validation/customValidation.js"></script>
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<script type="text/javascript" src="js/globalJs/globalJs.js"></script>




<script type="text/javascript">
$(document).ready(function(){
	//alert("in location");
	
	$('#frm').bootstrapValidator({
			message : 'This value is not valid',	
			feedbackIcons : {
				valid : 'fa fa-check',
				invalid : 'fa fa-remove',
				validating : 'fa fa-refresh'
			},
			fields : {
				strRemarks : {
		                 validators: {
		                     notEmpty: {
		                         message: 'Reply is required and can\'t be empty'
		                     },
		                     regexp :{
			                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
									message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
								},
		                     
		                     stringLength: {
		                         min:1,
		                         max: 250,
		                         message: 'Details of Issue can contain minimum 1 and maximum of 250 characters'
		                     }
		                 }
		        }
			}
		}); 

	$('#frmCDAC').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'fa fa-check',
			invalid : 'fa fa-remove',
			validating : 'fa fs-refresh'
		},
		fields : { 
			cdacIssueType : {
 				validators : {
 					callback: {
 				           message: 'Please specify State',
 				           callback: function(value, validator, $field) {
 				               
 				               var options = validator.getFieldElements('cdacIssueType').val();

 				               return (options != 0);
 				           }
 					}
 				}
		  	}, 
			cdacRemarks : {
	                 validators: {
	                     notEmpty: {
	                         message: 'Remarks is required and can\'t be empty'
	                     },
	                     regexp :{
		                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
								message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
							},
	                     
	                     stringLength: {
	                         min:1,
	                         max: 1000,
	                         message: 'Remarks can contain minimum 1 and maximum of 1000 characters'
	                     }
	                 }
	        }
		}
	});  
	
	loadDataTable(1);

	$('#saveReply').click(function() {
		var bV = $("#frm").data('bootstrapValidator');
		bV.validate();
		if (bV.isValid()) {
			confirm_alert('Do you Really want to save?','reply');
		} else {
		}
	});

	$('#updateCdacRemarks').click(function() {
		var bV = $("#frmCDAC").data('bootstrapValidator');
		bV.validate();
		if (bV.isValid()) {
			confirm_alert('Do you Really want to send this technical query to CDAC?','updateRemarks');
		} else {
		}
	});
	$('#updateProbStatus').hide();
	$('#viewStatus').show();

	$('#updateIssueStat').hide();
	$('#updateIssueStatus').click(function() {
		$('#updateProbStatus').show();
		$('#viewStatus').hide();
		$('#updateIssueStatus').hide();
		$('#updateIssueStat').show();
	});

	$('#updateIssueStat').click(function() {
		confirm_alert('Do you Really want to update?','updateProblemStatus');
	});

	if('${flagUpdate}'== 1){
		ok_message("Reply saved succesfully");
	}

	 /* $('#m_table_1').DataTable( {
	        dom: 'Bfrtip',
	        buttons: [
	            'excel'
	        ]
	 }); */
});
</script>

<script>
function initTable(id,x_size,y_size,statusID){
	
	jQuery.extend(jQuery.fn.dataTableExt.oSort, {
	    "date-euro-pre": function (a) {
	        var dateArray = a.split('-');
	        return Date.parse(dateArray[2] + '-' + dateArray[1] + '-' + dateArray[0]) || 0;
	    },
	    "date-euro-asc": function (a, b) {
	        return a - b;
	    },
	    "date-euro-desc": function (a, b) {
	        return b - a;
	    }
	});
	 
	 
	var Table = $(id).DataTable({

		columns: [
		  		
		{
			"sTitle" : "",
			"mData" : "num_problem_id",
			"bVisible" : false
		},
		
		{
			"sTitle" : "Feedback Registered Date",
			"mData" : "createddate",
			"type": "date-euro" 		
		},
		{
			"sTitle" : "S.No.",
			"mData" : "rownum",
			"bVisible" : false	
		},
		{
			"sTitle" : "User Name",
			"mData" : "str_user_name"
		},
		
		{
			"sTitle" : "Organisation Name",
			"mData" : "str_org_name"
		},
		{
			"sTitle" : "Subject",
			"mData" : "str_subject"
		},
		{
			"sTitle" : "Problem",
			"mData" : "str_problem"
		},
		{
			"sTitle" : "Address",
			"mData" : "str_address"
		},
		{
			"sTitle" : "Pincode",
			"mData" : "str_pincode"
		},
		{
			"sTitle" : "Designation",
			"mData" : "str_designation"
		},
		{
			"sTitle" : "E-mail Address",
			"mData" : "str_email_id"
		},
		{
			"sTitle" : "Phone Number",
			"mData" : "str_landline_no"
		},
		{
			"sTitle" : "Problem Number",
			"mData" : "str_problemno"
		},
		{
			"sTitle" : "Attached Document",
			"mData" : ""
		},
		{
			"sTitle" : "Assigned To",
			"mData" : "assigned_to",
			"bVisible" : false
		},
		{
			"sTitle" : "Status",
			"mData" : "issue_status"
		},
		{
			"sTitle" : "Action",
			"mData" : ""
		},
		{
			"sTitle" : "",
			"mData" : "num_reply_status",
			"bVisible" : false
		},
		{
			"sTitle" : "",
			"mData" : "str_reply",
			"bVisible" : false
		},
		{
			"sTitle" : "",
			"mData" : "num_doc_id",
			"bVisible" : false
		},
		{
			"sTitle" : "",
			"mData" : "num_cdac_status",
			"bVisible" : false
		},
		{
			"sTitle" : "",
			"mData" : "num_cdac_issue_type",
			"bVisible" : false
		},
		{
			"sTitle" : "",
			"mData" : "str_cdac_remarks",
			"bVisible" : false
		},
		{
			"sTitle" : "",
			"mData" : "str_assigned_to",
			"bVisible" : false
		},
		{
			"sTitle" : "",
			"mData" : "num_issue_status",
			"bVisible" : false
		}
		
				],
				responsive: !0,
				columnDefs : [
						
						{
							"targets": [7,8,9,10,11,12,14],
			                 "className": "none",
			             	  
			             },
			             {
								"targets": 13,
			             	    "render": function ( data, type, row ) {
			             	   	var c = "";
			             	   	if(row.num_doc_id == 0){
			             	   		c = '<a id="doc1" >Not Available</a>';
			             	   	}else{
			             	   		c = '<a id="doc1" onclick="downloadDoc(\''+row.num_doc_id+'\')" href ="#">Download Document</a>';
				             	}
								
								return c;
											
								}
							},
			             {
								"targets": 16,
			             	    "render": function ( data, type, row ) {
			             	   	var c = "";
			             	   	
			             	   	var strProblem = row.str_problem;
								strProblem = strProblem.replace(/(?:\r\n|\r|\n)/g, ''); 

								var strSubject = row.str_subject;
								strSubject = strSubject.replace(/(?:\r\n|\r|\n)/g, ''); 

			             	  
								c = '<div class="btn-group dropleft"><button class="btn_default dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-angle-down"><span class="sr-only"></span></i></button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton">';
								//alert(row.num_reply_status);
								if(row.num_reply_status == 0){
									
									if(row.num_cdac_status == 0 || row.num_cdac_status == null){
										c = c
										+ ""
										+ '<a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForFirstChat" onclick="feedbackReply(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+row.str_user_name+'\');">Reply</a> <a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForUpdateCDACRem" onclick="fillCdacRemarks(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+row.str_user_name+'\');">Forward to support team</a></div></div>';
										//data-toggle="modal" data-target="#modelForFirstChat"
									}else{
										/* var strRem = row.str_cdac_remarks;
										strRem = strRem.replace(/(?:\r\n|\r|\n)/g, '');  */
										c = c
										+ ""
										+ '<a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForFirstChat" onclick="feedbackReply(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+row.str_user_name+'\');">Reply</a> <a class="dropdown-item" data-bs-target="#modelForViewCDACRem" data-bs-toggle="modal" onclick="viewCDACRemarks(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+row.str_user_name+'\');">Query sent to support team</a></div></div>';
										//data-toggle="modal" data-target="#modelForFirstChat"
									}
									
								}else{
									var strReply = row.str_reply;
									strReply = strReply.replace(/(?:\r\n|\r|\n)/g, ''); 
									if(row.num_cdac_status == 0 || row.num_cdac_status == null){
										c = c
										+ ""
										+ '<a class="dropdown-item" data-bs-target="#modelForViewDtls" data-bs-toggle="modal" onclick="showFeedbackReply(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+strReply+'\',\''+row.str_user_name+'\');">Preview</a> <a class="dropdown-item" data-bs-target="#modelForUpdateCDACRem" data-bs-toggle="modal" onclick="fillCdacRemarks(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+row.str_user_name+'\');">Forward to support team</a></div></div>';
										//data-toggle="modal" data-target="#modelForFirstChat"
									}else{
										/* var strRem = row.str_cdac_remarks;
										strRem = strRem.replace(/(?:\r\n|\r|\n)/g, '');  */
										c = c
										+ ""
										+ '<a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForViewDtls" onclick="showFeedbackReply(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+strReply+'\',\''+row.str_user_name+'\');">Preview</a> <a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#modelForViewCDACRem" onclick="viewCDACRemarks(\''+row.num_problem_id+'\',\''+strProblem+'\',\''+strSubject+'\',\''+row.str_problemno+'\',\''+row.str_email_id+'\',\''+row.str_user_name+'\');">Query sent to support team</a></div></div>';
										//data-toggle="modal" data-target="#modelForFirstChat"
									}
								}
								return c;
											
								}
							}
							
			             ],

	  order: [[1, 'desc']] 
	
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
			url :"getFeedbackResponseListing",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				 resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
}

function downloadDoc(id){
	//alert(id);
	var enDocId1 = btoa(id);

	//alert(enDocId1);
	var reverseval = reverseString(enDocId1);
//	alert(reverseval);
	var enDocId = btoa(reverseval);
	var fileType = 3;

	//alert(enDocId);
	
	document.getElementById("frm1").action = "${pageContext.request.contextPath}/downloadTmpFile_Secure";
	$("#ENdoc_id").val(enDocId);
	$("#fileType").val(fileType);
	document.getElementById("frm1").method = "POST";

	document.getElementById("frm1").submit();
	
	
	//window.location.href='${pageContext.request.contextPath}/downloadTmpFile_Secure/' +enDocId+ '/'+ fileType;
	//$('#doc1').prop('href','${pageContext.request.contextPath}/downloadTmpFile_Secure/' +enDocId+ '/'+1);
}

function feedbackReply(problemId,problem,subject,problemNo,email,userName){
	/* alert(problemId);  
	alert(problem);  
	alert(subject);  
	alert(problemNo);  
	alert(email);  
	alert(userName);   */
	
	$("#problemId").val(problemId);
	$("#userName").text(userName);
	$('#problem').text(problem);
	$('#subject').text(subject);
	$('#problemNumber').text(problemNo);
	$('#emailTo').text(email);
	$.ajax({
		type : "GET",
		url : "loadFeedbackReply",
		data : "problemId=" + problemId,
			success : function(response) {
				//alert(response.length+"  response.length ");
				for ( var i = 0; i < response.length; i++) {
					//alert(response[i].replyStatus);
					if(response[i].replyStatus == 1){
						warning_message("Already Replied to the Issue");
					}
					else{
						showModal('#modelForFirstChat');
					}
				} 
			}
		}); 
}

function fillCdacRemarks(problemId,problem,subject,problemNo,email,userName){
	$("#probId").val(problemId);
	$("#userNameCDACView").text(userName);
	$('#problemCDACView').text(problem);
	$('#subjectCDACView').text(subject);
	$('#problemNumberCDACView').text(problemNo);
	showModal('#modelForUpdateCDACRem');
}

function viewCDACRemarks(problemId,problem,subject,problemNo,email,userName){
	/* alert()
	alert(problemId);  
	alert(problem);  
	alert(subject);  
	alert(problemNo);  
	alert(email);  
	alert(userName); 

	alert(issueType);  
	alert(cdacRemarks);  
	alert(assignedTo); 
	alert(issueStatus);  */
	
	$("#probIdView").val(problemId);
	$("#userNameCDACView1").text(userName);
	$('#problemCDACView1').text(problem);
	$('#subjectCDACView1').text(subject);
	$('#problemNumberCDACView1').text(problemNo);
	
	/* var strIssueType;
	if(issueType == 1)
		strIssueType = "Guidance";
	else if(issueType == 2)
		strIssueType = "Software Related";
	else if(issueType == 3)
		strIssueType = "Solution Provider Related";
	else if(issueType == 4)
		strIssueType = "Other";
	
	$('#issueTypeView').text(strIssueType);
	$('#cdacRemarksView').text(cdacRemarks); */

	/* var strIssueStatus;
	if(issueStatus == 1)
		strIssueStatus = "No action taken";
	else if(issueStatus == 2)
		strIssueStatus = "In progress";
	else if(issueStatus == 3)
		strIssueStatus = "Resolved";
	else if(issueStatus == 4)
		strIssueStatus = "Guidance";
	else if(issueStatus == 5)
		strIssueStatus = "Response pending from user";
	else if(issueStatus == 6)
		strIssueStatus = "Pharmexcil to clarify";
	else if(issueStatus == 0)
		strIssueStatus = "NA"; */

	//alert(assignedTo);
	/* var strAssignedTo;
	if(assignedTo == 'null')
		strAssignedTo = "Not Assigned";
	else
		strAssignedTo = assignedTo;
	 
	$('#issueStatusView').text(strIssueStatus);
	$('#assignedToView').text(strAssignedTo); */
	
	showModal('#modelForViewCDACRem');
}

function showFeedbackReply(problemId,problem,subject,problemNo,email,reply,userName){
	
	//alert("dfsgjhuk   "+userName);
	$('#userNameView').text(userName);
	$('#problemView').text(problem);
	$('#subjectView').text(subject);
	$('#problemNumberView').text(problemNo);
	$('#emailView').text(email);
	$('#replyView').text(reply);
	//warning_message("Issue is closed");
	showModal('#modelForViewDtls');
}

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
			if (type == "reply") {
				replyFeedback();
			} else if (type == "updateRemarks") {
				updateCdacRemarks();
			} else if (type == "updateProblemStatus") {
				updatePrStatus();
			}
		} else {
			imp = false;
		}
	});

}

function updateCdacRemarks(){
	
	createFHash("frmCDAC");
	
	document.getElementById("frmCDAC").action = "${pageContext.request.contextPath}/updateFeedbackMstCDACRem";
	document.getElementById("frmCDAC").method = "POST";
	document.getElementById("frmCDAC").submit();
	alert("Query Forwarded to CDAC")
	
}

function updatePrStatus(){
	
	createFHash("frmCDAC1");
	
	document.getElementById("frmCDAC1").action = "${pageContext.request.contextPath}/updateProblemStatusFeedbackMst";
	document.getElementById("frmCDAC1").method = "POST";
	document.getElementById("frmCDAC1").submit();
}

function replyFeedback(){
	
	createFHash("frm");
	
	document.getElementById("frm").action = "${pageContext.request.contextPath}/updateFeedBackForReply";
	document.getElementById("frm").method = "POST";
	$("#frm").submit();
}

function showModal(event) {
	//alert("in show modal");
	$(event).modal({
		backdrop : 'static',
		keyboard : false,
		show : true

	});
} 
</script>

<!-- Creating token and validating with FormFieldValidationFilter.java G9 -->
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


<div class="content-wrapper mt-0 pt-0">
	<div class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold">Feedback Response</h1>
		</div>
		<!--begin::Portlet-->
		<div class="m-portlet m-portlet--last m-portlet--head-lg m-portlet--responsive-mobile" id="main_portlet">
			<div class="m-portlet__head" style=" background-image: linear-gradient(to left top, #e8e8d2, #9bbaa4, #4a8c8b, #005b78, #002856);">
				<div class="m-portlet__head-progress">
					<!-- here can place a progress bar-->
				</div>
			</div>

				<form:form  id="frm1" name="frm1" modelAttribute="reportProblemForm" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
				<form:hidden id="problem_id" path="problem_id" />
					<form:input type="hidden" id="ENdoc_id" path="ENdoc_id" />
				<form:input type="hidden" id="fileType" path="fileType" />
				
				
	             
					<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1" style="margin-top: 1%;width:100%;">
						<thead class="theadTransacColor">
				  			<tr>
					  									
					  		</tr>
						</thead>
						
					</table>
				 </form:form>
		</div>
		<!--end::Portlet-->
	</div>
      
 <!-- --------------------------------------------- Model for first chat ----------------------------------------------- -->	
<div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="modelForFirstChat" data-easein="slideDownBigIn">
  	<div class="modal-dialog modal-dialog-centered modal_wd">
	    <div class="modal-content">
			<form:form class="seminor-login-form" method="post" modelAttribute="reportProblemForm" id="frm" name="frm">
			<%-- <form:form method="post" id="modalfrm1" name="modalfrm1" modelAttribute="reportProblemForm"> --%>
				<div class="modal-header theadTransacColor">
					<h3 class="modal-title">Reply on Problem</h3>
					<button type="button" class="close" data-dismiss="modal">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>
				</div>
				<form:hidden path="problem_id" id="problemId"></form:hidden>
				<div class="modal-body">
					<div class="panel-body">	
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">User Name:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="userName" class="dvfrm-label"></span></div>					 
						</div>
							
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="problem" class="dvfrm-label"></span></div>
						</div>
							
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Subject:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="subject" class="dvfrm-label"></span></div>						  
						</div>
							
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem Number:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="problemNumber" class="dvfrm-label"></span></div>
						</div>							  

						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">E-mail To:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="emailTo" class="dvfrm-label"></span></div>
						</div>	

						<div class="row">
								<div class="col-md-6"><label for="strRemarks" class="dvfrm-label">Remarks:-<span style="color:#cd2026;">*</span></label></div>
								<div class="col-md-6"><form:textarea path="strRemarks" cssClass="form-control m-input" id="strRemarks" placeholder="Reply" />		
								</div>							  
						</div>						  
					</div>
				</div>
				<div class="modal-footer">
			<button type="button" id="saveReply"
				class="custom-btn position-relative" value="forward">
				Send
			</button>
			 <button type="button" class="btn_default"
				data-bs-dismiss="modal">
				Close
			</button>

		</div>
			</form:form>
		</div>

		
	</div> 
</div>

<!-- ------------------------------------------------------------------------------------------------------------------------------ -->	
			    	
			    	
<!-- --------------------------------------------- Model for View Details ----------------------------------------------- -->	
<div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="modelForViewDtls" data-easein="slideDownBigIn">
  <div class="modal-dialog modal-dialog-centered modal_wd">
    <div class="modal-content">
			<form:form class="seminor-login-form" method="post" modelAttribute="reportProblemForm" id="frm" name="frm3">
			<%-- <form:form method="post" id="modalfrm1" name="modalfrm1" modelAttribute="reportProblemForm"> --%>
				<div class="modal-header theadTransacColor">
					<h3 class="modal-title" align="center">Replied on Problem</h3>
					<button type="button" class="close" data-bs-dismiss="modal" aria-label="modal Close button">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>
				</div>
				<div class="modal-body">

					<div class="panel-body">
						<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">User Name:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="userNameView" class="dvfrm-label"></span></div>
						</div>	

							<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="problemView" class="dvfrm-label"></span></div>
							</div>							  
						
							<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Subject:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="subjectView" class="dvfrm-label"></span></div>					  
						</div>
						
						<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem Number:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="problemNumberView" class="dvfrm-label"></span></div>						  
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">E-mail To:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="emailView" class="dvfrm-label"></span></div>
							</div>							  
						</div>
						
						<div class="row">
							
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Reply:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="replyView" class="dvfrm-label"></span></div>	
							</div>							  
						</div>
							
					</div>
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn_default"
						data-bs-dismiss="modal">Close
					</button>

				</div>
			</form:form>
		</div> 
  </div>
</div> 	


<!-- ------------------------------------------------------------------------------------------------------------------------------ -->	


<!-- --------------------------------------------- Model for Update CDAC Remarks ----------------------------------------------- -->
		
		
 <div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="modelForUpdateCDACRem" data-easein="slideDownBigIn">
  <div class="modal-dialog modal-dialog-centered modal_wd">
    <div class="modal-content">
    
    		
			<form:form class="seminor-login-form" method="post" modelAttribute="reportProblemForm" id="frmCDAC" name="frmCDAC">
				<form:hidden path="problem_id" id="probId"></form:hidden>
				<div class="modal-header theadTransacColor">
					<h3 class="modal-title">Forward to CDAC</h3>
					<button type="button" class="close" data-bs-dismiss="modal" aria-label="modal Close button">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>
				</div>
				<div class="modal-body">

					<div class="panel-body">
						<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">User Name:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="userNameCDACView" class="dvfrm-label"></span></div>
						</div>	
							
						<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="problemCDACView" class="dvfrm-label"></span></div>						  
						</div>
						
						<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Subject:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="subjectCDACView" class="dvfrm-label"></span></div>							  
						</div>
						
						<div class="row">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem Number:-</label></div>
								<div class="col-md-6"><span for="example-text-input" id="problemNumberCDACView" class="dvfrm-label"></span></div>					  
						</div>
						
					<%-- 	<div class="row">
						
								<div class=" form-group" >
									<label class="cdacIssueType" for="cdacIssueType">Issue Type:<span style="color:#cd2026;">*</span></label>
									<form:select path="cdacIssueType" class="form-control" id="cdacIssueType">
										<form:option value="0">Select Issue Type</form:option>
										<form:option value="1">Guidance</form:option>
										<form:option value="2">Software Related</form:option>
										<form:option value="3">Solution Provider Related</form:option>
										<form:option value="4">Other</form:option>
									</form:select>	
								</div>
							
							<div class="row">
								<div class="col-md-6"><label for="cdacRemarks" class="dvfrm-label">CDAC Remarks:-<span style="color:#cd2026;">*</span></label></div>
								<div class="col-md-6"><form:textarea path="cdacRemarks" cssClass="form-control m-input" id="cdacRemarks" placeholder="Remarks" /></div>
									
							</div>							  
						</div>
						
						<div class="row">
								<div class=" form-group" >
									<label class="dvfrm-label" for="issueStaus">Issue Status:</label>
									<form:select path="issueStaus" class="form-control" id="issueStaus">
										<form:option value="0">Select Issue Status</form:option>
										<form:option value="1">No action taken</form:option>
										<form:option value="2">In progress</form:option>
										<form:option value="3">Resolved</form:option>
										<form:option value="4">Guidance</form:option>
										<form:option value="5">Response pending from user</form:option>
										<form:option value="6">Pharmexcil to clarify</form:option>
									</form:select>	
								</div>
							
							<div class="row">
								<div class="col-md-6"><label for="assignedTo" class="dvfrm-label">Issue Assigned To:-</label></div>
								<div class="col-md-6"><form:textarea path="assignedTo" cssClass="form-control m-input" id="assignedTo" placeholder="Assign Issue" /></div>
									
							</div>							  
						</div> --%>
							
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="updateCdacRemarks"
						class="saveReasonReject custom-btn position-relative" value="forward">
						Submit
					</button>
					<button type="button" class="btn_default"
						data-bs-dismiss="modal">Close
					</button>

				</div>
			</form:form>
		</div> 
  </div>
</div> 	


<!-- ------------------------------------------------------------------------------------------------------------------------------ -->	


<!-- --------------------------------------------- Model for View CDAC Remarks ----------------------------------------------- -->
		
		
<div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="modelForViewCDACRem" data-easein="slideDownBigIn">
  <div class="modal-dialog modal-dialog-centered modal_wd">
    <div class="modal-content">
    
    		
			<form:form class="seminor-login-form" method="post" modelAttribute="reportProblemForm" id="frmCDAC1" name="frmCDAC1">
				<form:hidden path="problem_id" id="probIdView"></form:hidden>
				<div class="modal-header theadTransacColor">
					<h3 class="modal-title">CDAC Review Details</h3>
					<button type="button" class="close" data-bs-dismiss="modal" aria-label="modal Close button">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>
				</div>
				<div class="modal-body">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">User Name:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="userNameCDACView1" class="dvfrm-label"></span></div>
						</div>	
							
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="problemCDACView1" class="dvfrm-label"></span></div>				  
						</div>
						
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Subject:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="subjectCDACView1" class="dvfrm-label"></span></div>					  
						</div>
						
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Problem Number:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="problemNumberCDACView1" class="dvfrm-label"></span></div>					  
						</div>
						
					<!-- 	<div class="row"> 
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Issue Type:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="issueTypeView" class="dvfrm-label"></span></div>
							</div>
							
							<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">CDAC Remarks:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="cdacRemarksView" class="dvfrm-label"></span></div>
							</div>						  
						</div>
						
						<div class="row" id="viewStatus"> 
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Issue Status:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="issueStatusView" class="dvfrm-label"></span></div>
							</div>
							
						<div class="row">
							<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Assigned To:-</label></div>
							<div class="col-md-6"><span for="example-text-input" id="assignedToView" class="dvfrm-label"></span></div>
						</div>	 -->
					<%-- 	<div class="row my-2" id="updateProbStatus">
							<label class="dvfrm-label" for="issueStaus">Issue Status:</label>
							<form:select path="issueStaus" class="form-control" id="issueStaus">
								<form:option value="0">Select Issue Status</form:option>
								<form:option value="1">No action taken</form:option>
								<form:option value="2">In progress</form:option>
								<form:option value="3">Resolved</form:option>
								<form:option value="4">Guidance</form:option>
								<form:option value="5">Response pending from user</form:option>
								<form:option value="6">Pharmexcil to clarify</form:option>
							</form:select>	
						</div>
							 --%>
					<%-- 	<div class="row">
							<div class="col-md-6 mb-2"><label for="assignedTo" class="dvfrm-label">Issue Assigned To:-</label></div>
							<div class="col-md-6 mb-2"><form:textarea path="assignedTo" cssClass="form-control m-input" id="assignedTo" placeholder="Assign Issue" /></div>
								
						</div> --%>						  
				</div><!--end modal body-->
						
				<div class="modal-footer">
				<!-- 	<button type="button" id="updateIssueStatus"
						class="custom-btn position-relative" value="forward">
						Edit
					</button>
					<button type="button" id="updateIssueStat"
						class="btn_default btn-success" value="forward">
					
						Edit & Update
					</button> -->
					 <button type="button" class="btn_default"
						data-bs-dismiss="modal">Close
					</button>
				</div><!--end modal footer-->	
			</form:form>
		</div><!--end modal Content-->	
	</div>
</div>



<!-- ------------------------------------------------------------------------------------------------------------------------------ -->	
</div>

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
