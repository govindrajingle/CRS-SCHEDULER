<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>Uploaded Data</title>
<style>
.modal-lg{
    max-width: 85%;
}
</style>

	<!-- File Upload -->
	<script src="js/homepage/jquery.ui.widget.js"></script>
	<script src="js/homepage/jquery.iframe-transport.js"></script>
	<script src="js/homepage/jquery.fileupload.js"></script>	
    <script type="text/javascript" src="js/formFieldValidation/md5.js"></script>  
<script>
$(document).ready(function(){
	//alert("on load");
	//$("#fileupload").on("change", uploadFile);
	$('#fileuploadRemove').hide();
	loadDataTable(1);

	if ('${flag}' == 1) {
		ok_message("Product Detail XML Successfully Uploaded.");
	}else if('${flag}' == 2){
		ok_message("Manufacturing Site Detail XML Successfully Uploaded.");
	}else if('${flag}' == 3){
		ok_message("Consignment Detail XML Successfully Uploaded.");
	}else{
		//error_message("There is some error in uploading XML files.")
	}


	/* $('#frmConsign').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {  
			ewayBill : {
	                 validators: {
	                     notEmpty: {
	                         message: 'Bill Number is required and can\'t be empty'
	                     },
	                     regexp :{
		                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
								message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
							},
	                     
	                     stringLength: {
	                         min:3,
	                         max: 20,
	                         message: 'Bill Number can contain minimum 3 and maximum of 20 characters'
	                     }
	                 }
	        },
	        billDate : {
				selector : '#billDate',
				validators : {
					notEmpty : {
						message : 'The Bill Date is required'
					}
				}
			},
			exportingRegion : {
                validators: {
                    notEmpty: {
                        message: 'Exporting Region is required and can\'t be empty'
                    },
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:2,
                        max: 8,
                        message: 'Exporting Region can contain minimum 2 and maximum of 8 characters'
                    }
                }
      		},
      		exportingCountry : {
                validators: {
                    notEmpty: {
                        message: 'Country Of Export is required and can\'t be empty'
                    },
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:3,
                        max:50,
                        message: 'Country Of Export can contain minimum 3 and maximum of 50 characters'
                    }
                }
      		},
      		portName : {
                validators: {
                    notEmpty: {
                        message: 'Source Port Name is required and can\'t be empty'
                    },
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:3,
                        max:250,
                        message: 'Source Port Name can contain minimum 3 and maximum of 250 characters'
                    }
                }
      		},
      		landingPort : {
                validators: {
                    notEmpty: {
                        message: 'Landing Port Name is required and can\'t be empty'
                    },
                    regexp :{
	                     regexp :/^[a-zA-Z0-9().\/,\s\-]+$/,
							message : 'Only alphabet,numbers, special characters(/ , . () ) and white spaces are permitted'
						},
                    
                    stringLength: {
                        min:3,
                        max:250,
                        message: 'Landing Port Name can contain minimum 3 and maximum of 250 characters'
                    }
                }
      		}
		}
	});  */

	/* $('#updateConsignDtls').click(function() {
		//alert("in submit"+$("#uploadIdCon").val());
		
		var bV = $("#frmConsign").data('bootstrapValidator');
		bV.validate();
		if (bV.isValid()) {
			swal(
					{  		
					title: "Are you sure ?",   text: "Do you want to Add Details.",   
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

					    		  	document.getElementById("frmConsign").action = "${pageContext.request.contextPath}/updateConsignmentDtls";
					    			document.getElementById("frmConsign").method = "POST";
					    			document.getElementById("frmConsign").submit(); 
		  					}
		  	});
		} else {
		}
	});  */
	
});




function showAppFile(divName, divfile) {
		$('#fileupload').val('');
		$('#' + divName).hide();
		$('#' + divfile).show();
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
				"sTitle" : "User Name",
				"mData" : "user_name"
			},
			{
				"sTitle" : "Purpose Type",
				"mData" : "str_remarks"
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
			,
			{
				"sTitle" : "Action",
				"mData" :  ""
			},
			{
				"sTitle" : "Status",
				"mData" :  "status"
			},
			{
				"sTitle" : "Error Name",
				"mData" :  "exact_code"
			},
			{
				"sTitle" : "",
				"mData" : "num_status",
				"bVisible": false
			},
			{
			    "sTitle" : "File Final Status",
			    "mData" : function (source, type, val) {
			        if (source.num_verify_by == 0 || source.num_verify_by == 1 || source.num_verify_by == 22) {
			            return "Success";
			        } else if(source.num_verify_by == 33) {
			            return "Failed";
			        } else {
			        	return "Under Scrutiny";
			        }
			    }
			}				
		],
						         	responsive: !0,
									columnDefs : [
											{
												'targets' : 5,
												'searchable' : true,
												'orderable' : true,
												'className' : 'dt-body-top',
												'render' : function(
														data, type, row) {


													var a = "";
													
					    	    					a = '<a href="#" onclick="openDetails(\''+row.num_document_id+'\',\''+row.num_type_id+'\');">View Xml</a>'; 
					    	    		//${pageContext.request.contextPath}/uploadXmlPage/ <br><a href="#" onclick="openTreeView(\''+row.num_upload_id+'\');">Tree View</a>
					    	    				   return a;
															
												}
											},
									
								{
								"targets": 6,
			             	    "render": function ( data, type, row ) {
				             	    if(row.num_status == 1 || row.num_status == 2){
				             	    	if(row.num_type_id == 3 ){
					             	   		var c = "";
		
											c = '<div class="btn-group dropleft"><button class="dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-angle-down"><span class="sr-only">DropDown Doggle</span></i></button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton">';
											c = c
												+ "";
											if(row.str_ackreceipt_filename != null && row.str_ackreceipt_filename != 'null' && row.str_ackreceipt_filename != ''){
												var enFid= window.btoa(row.num_document_id);
												if(row.exist_flg_con == 0){
													c = c + '<a class="dropdown-item" id="uploadack'+row.num_document_id+'" onclick="downloadFile(\''+row.num_document_id+'\')"  >Download Receipt of Acknowledgement</a><a href="#" onclick="totalRecall(\''+row.num_upload_id+'\');">Recall XML</a><div><a href="#" onclick="consignmentDtls(\''+row.num_upload_id+'\');">Add Consignment Details</a></div></div></div>';
												}else{
													c = c + '<a class="dropdown-item" id="uploadack'+row.num_document_id+'" onclick="downloadFile(\''+row.num_document_id+'\')"  >Download Receipt of Acknowledgement</a><a href="#" onclick="totalRecall(\''+row.num_upload_id+'\');">Recall XML</a><div><a data-bs-toggle="modal" data-bs-target="#modelForViewConsignment" onclick="consignmentDtlsSaved(\''+row.num_upload_id+'\');">Preview Consignment</a></div></div></div>';
												}	
											}else
												if(row.exist_flg_con == 0){
													c = c + '<a class="dropdown-item" id="uploadack'+row.num_document_id+'" href="#" onclick="test(\''+row.num_document_id+'\')"  >Upload Receipt of Acknowledgement</a><a href="#" onclick="totalRecall(\''+row.num_upload_id+'\');">Recall XML</a><div><a href="#" onclick="consignmentDtls(\''+row.num_upload_id+'\');">Add Consignment Details</a></div></div></div>';
												}
												else{
													c = c + '<a class="dropdown-item" id="uploadack'+row.num_document_id+'" href="#" onclick="test(\''+row.num_document_id+'\')"  >Upload Receipt of Acknowledgement</a><a href="#" onclick="totalRecall(\''+row.num_upload_id+'\');">Recall XML</a><div><a data-bs-toggle="modal" data-bs-target="#modelForViewConsignment" onclick="consignmentDtlsSaved(\''+row.num_upload_id+'\');">Preview Consignment</a></div></div></div>';
												}
												return c;
										}else
											return "";
					             	  }else
						             	  return "No Action Required";
				             	    
								}
							},			
											
											{
												"targets": [],
								                 "className": "none",
								             	  
								             }]	,
												'rowCallback' : function(row, data, dataIndex) {
													//alert(data.num_status);
													if (data.num_status == 1 || data.num_status == 2) {
														$(row).css("background-color", "#edfbde");
													}/*  else if (data.num_status == 2) {
														$(row).css("background-color", "#edfbde");
													} */ else if (data.num_status == 3) {
														$(row).css("background-color", "#f3d1ce");
													}

												}		             
    	
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
	 $.ajax({
			type:"GET",
			data:{status :statusID},
			url :"getConsignmentUploadXmlDetails",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//console.log(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
} 

function xmlFunction(docId){//${pageContext.request.contextPath}/downloadTmpFile_Secure/'+row.num_document_id
	$("#docID").val(docId);
	//alert(docId);
	var fileType = 2;
	document.getElementById("frm").action = "${pageContext.request.contextPath}/downloadTmpFile_Secure";


	$("#ENdoc_id").val(docId);
    $("#fileType").val(fileType);
	/* document.getElementById("frm").method = "GET"; */
	document.getElementById("frm").method = "POST";
	createFHash("frm");
	document.getElementById("frm").submit(); 
	//ok_message("Under Processing......");
}

function downloadFile(docId){//${pageContext.request.contextPath}/downloadTmpFile_Secure/'+row.num_document_id
//	alert(docId);
	//var enFid = DataEncoder.encode(docId);
	var enFid1 =  btoa(docId);
	var reverseval=reverseString(enFid1);
	
	var enFid = btoa(reverseval);  
	//alert ("hello" + enFid)
	
	//alert(enFid);
	//var fileType = 2;
	document.getElementById("frm").action = "${pageContext.request.contextPath}/downloadAckFile_Secure";

	$("#ENdoc_id").val(enFid);
    $("#fileType").val(3);
		
	/* document.getElementById("frm").method = "GET"; */
	document.getElementById("frm").method = "POST";
	createFHash("frm");
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
			//alert("docId=="+docId);
			//alert("typeId=="+typeId);

			$("#numDocId2").val(docId);   
		    var docId1 = btoa(docId);
		    var reverseval=reverseString(docId1);
		    var docId = btoa(reverseval); 

		    $("#docId").val(docId);

		    createFHash("frm"); 
		    
		    var form = $('#frm')[0];
			var form_data = new FormData(form);
			
		 	$.ajax({
				type : "POST",
				//enctype: 'multipart/form-data',
				data : form_data,
				//data : { "docId" : docId },
				url : "viewUploadedXML",
				cache : false,
		         processData : false,
		         contentType : false,
				success : function(response) {
					//alert(response);


						  if (/xml/i.test(response)) {
				
							  //alert("if");
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
				} else {


					error_message("Form Data Tampered");
		            // Response is null, redirect to another page
					//window.location.href = '${pageContext.request.contextPath}/error.jsp';
					 window.location.href = '${pageContext.request.contextPath}/login';
				}
				}						
				});
				}
			

</script>
<script>
$(document).ready(function(){
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
<script>
function test(docId){ 
    $("#numDocId2").val(docId);   
    var enFid1 = btoa(docId);
    var reverseval=reverseString(enFid1);
    var enFid = btoa(reverseval); 

    $("#ENdoc_id").val(enFid);
   
    
    
	//alert(enFid);
	var fileType = 3;
	 $("#fileType").val(3);

	
	 createFHash("frm"); 
	    
	    var form = $('#frm')[0];
		var form_data = new FormData(form);
	 $.ajax({
		   
		    type: "POST",
		    data : form_data,
		    url: "checkifFileExists",

		    cache : false,
	         processData : false,
	         contentType : false,
		    
		    success: function (response) {
		    //alert(response);
		    if(response == 'true')
		    {
		    
			    
		    	$('#fileuploadDownloadLink2').attr('href',"${pageContext.request.contextPath}/downloadAckFile_Secure");
		  	    $('#fileuploadDownloadLink2').text('Download Uploaded Receipt ');
		  	    $("#fileuploadRemove2").show();
		  	    
		    } 

		    if (/tampered/i.test(response)) 
		    {
		    
			    
		    	error_message("Form Data Tampered");
		    	window.location.href = '${pageContext.request.contextPath}/login';
		    } 


		    else {
		    $("#fileuploadRemove2").hide();
		    $('#uploadModal').modal('show');
		    }
		       
		    
		    }
		    });

	    
}

function totalRecall(uploadId){

	//alert(uploadId);
	$("#uploadId").val(uploadId);
	createFHash("frm");
	swal(
			{  		
			title: "Are you sure ?",   text: "Do you want to recall this.",   
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
			    		    
			    		  	document.getElementById("frm").action = "${pageContext.request.contextPath}/saveTotalRecall";
			    			document.getElementById("frm").method = "POST";
			    			
			    			document.getElementById("frm").submit(); 
  					}
  });
	
	
	
}

function consignmentDtls(uploadId){

	//alert(uploadId);
	var enUploadId1 = window.btoa(uploadId);
	var reverseval=reverseString(enUploadId1);
	var enUploadId = window.btoa(reverseval);
	//alert(enUploadId);
	/* window.location.href='${pageContext.request.contextPath}/ConsignmentDetailPage?enUploadId='+enUploadId; */

	document.getElementById("frm").action = "${pageContext.request.contextPath}/ConsignmentDetailPage";
	$("#enUploadId").val(enUploadId);
 
	//document.getElementById("frm").method = "GET";
	document.getElementById("frm").method = "POST";
	createFHash("frm");
	document.getElementById("frm").submit(); 

	
	
}
function consignmentDtlsSaved(uploadId){
	//alert("hello")
//	alert(uploadId);

	var enUploadId1 = window.btoa(uploadId);
	var reverseval=reverseString(enUploadId1);
	var enUploadId = window.btoa(reverseval);
//	alert(enUploadId);

	 $("#enUploadId").val(enUploadId);
	 createFHash("frm"); 
	    
	    var form = $('#frm')[0];
		var form_data = new FormData(form);
	$.ajax({
		type:"POST",
		data : form_data,
		url :"fetchDataConsignmentDtls",
		cache : false,
        processData : false,
        contentType : false,
	 	success: function (response) {

//alert(response);
if (/xml/i.test(response)) {
			 //alert(response);
			 //$('#conData').val(response);
			 document.getElementById("conData").innerHTML=response;
			 showModal('#modelForViewConsignment');

} else {


					error_message("Form Data Tampered");
		            // Response is null, redirect to another page
					//window.location.href = '${pageContext.request.contextPath}/error.jsp';
					 window.location.href = '${pageContext.request.contextPath}/login';

				}



				}
	});
	/* var enUploadId = window.btoa(uploadId);
	window.location.href='${pageContext.request.contextPath}/fetchDataConsignmentDtls?enUploadId='+enUploadId;
	showModal('#modelForViewConsignment'); */
	
	//ok_message("Consignment Details already Uploaded.");
}


</script>
<script>
function fileValidation(id) {
	var fileInput = document.getElementById(id);
	var filePath = fileInput.value;
	var file = fileInput.files[0];
	var allowedExtensions = /(\.pdf)$/i;
	if(file.size==0)
        {
         alert('File size should be more than 0 and less than 10 MB ');
       // error_message('Please upload file having extensions .pdf only');
        fileInput.value = '';
        return false;
        }
	if (!allowedExtensions.exec(filePath)) {
		alert('Please upload file having extensions .pdf only.');

		fileInput.value = '';
		return false;
	}
	// alert(filePath);
}

</script>
<script>
function uploadAckFile() {

	//alert("hello");
/* 	var fileInput = document.getElementById(id);
	var filePath = fileInput.value;
	var file = fileInput.files[0];
	var allowedExtensions = /(\.pdf)$/i;
	if(file.size==0)
        {
         alert('File size should be more than 0 and less than 10 MB ');
       // error_message('Please upload file having extensions .pdf only');
        fileInput.value = '';
        return false;
        }
	if (!allowedExtensions.exec(filePath)) {
		alert('Please upload file having extensions .pdf only.');

		fileInput.value = '';
		return false;
	} */

swal(
				{  		
				title: "Are you sure ?",   text: "Once uploaded , you cannot upload the file again!",   
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
	var docId = $('#numDocId2').val();
	var enFid1 = btoa(docId);
    var reverseval=reverseString(enFid1);
    var enFid = btoa(reverseval); 

//alert(docId);
    $("#docId1").val(enFid);

    //alert(enFid);
    
    
	 somecheck=$('#file').val().toString();
	//alert(somecheck);
		var path=somecheck.toString();
		 var r1=btoa(path);
		 //alert("r1:::"+r1);
		 //$('#hashValue').val(r1);

		 var r2=reverseString(r1);
		 var r3=btoa(r2);
		 $('#hashValue').val(r3);
		 //alert("r3:::"+r3);
	createFHash("frm2"); 
	
	 var form = $('#frm2')[0];
			var form_data = new FormData(form); 
	  $.ajax({
	    url: "uploadFilePDF",
	    type: "POST",
	    data: new FormData($("#frm2")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function (response) {

		   // alert(response);
		    if (/tampered/i.test(response)){

		    	error_message("Form Data Tampered");
	            // Response is null, redirect to another page
				//window.location.href = '${pageContext.request.contextPath}/error.jsp';
				 window.location.href = '${pageContext.request.contextPath}/login';


			    } else {


		    var Obj_List = response;
	  	 		var eNSuccessFlag = Obj_List[0].eNSuccessFlag;
	  	 	  	var SuccessFlag = Obj_List[0].successFlag;
	  	 	  	var FileName = Obj_List[0].fileName;
	  	
	  			if (SuccessFlag == 0 || SuccessFlag == 1){
	  		   		error_message("Please upload only PDF files");
	  		  	 	$('#numDocId').closest('.form-group').addClass('has-error');
	  		   		}
	  		   	if (SuccessFlag== 2){
	  		   		error_message("File size should be more than 0 and less than 10 MB  ");
	  		   		$('#numDocId').closest('.form-group').addClass('has-error');
	  		   		} 
	  		   	if (SuccessFlag == 3){
	  		   		error_message("There was some error in uploading the file. Please try again.");
	  		   		$('#numDocId').closest('.form-group').addClass('has-error');
	  		   		}
	  		  if (SuccessFlag == 4){
	  		   		error_message("Invalid File.");
	  		   		$('#numDocId').closest('.form-group').addClass('has-error');
	  		   		}
	  		 	if (SuccessFlag == 6){
	  		        error_message("File already exist");
	  			   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		       	}
	  		 	
	  		   	if (SuccessFlag ==5){
	  		   		   		
	  		   		
	  		   		//$('#fileuploadRemove').show();
	  	       		//$('#fileupload').hide();			
	  	       		$('#fileuploadDownloadLink2').attr('href',"${pageContext.request.contextPath}/downloadAckFile_Secure");
	  	       		$('#fileuploadDownloadLink2').text('Download('+FileName+')');
	  	       		$('#fileuploadRemove2').show();
 				   alert("File Uploaded Successfully");
 				 window.location.reload();	


 				$('#uploadModal').modal('hide');
 				$('#uploadack'+docId).text('Download Receipt of Acknowledgement');
 				$('#uploadack'+docId).attr('href',"${pageContext.request.contextPath}");
	  		    $('#uploadack'+docId).attr('onclick','');	
	  		    }
			    }
		      
	    },
	    error: function () {
	      // Handle upload error
	      // ...
	    }
	  });
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


function getCountryBasedOnRegion(regionId) {
	$.ajax({
		type:"GET",
		url :"countrybasedOnRegion",
		data:{regionId:regionId},
	 	success: function (response) {
			 for(var country in response){
				 $('#exportingCountry').append($("<option></option>").attr("value",response[country].num_country_id).text(response[country].str_country_name));
				 
			 }
		}
	});
}

$('.js-example-basic-multiple').select2({
	multiple : true,
	placeholder : '-- Select --',
	allowClear : true
});
</script>

<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">
		<div class="page-title">
			<h1 class="fw-bold"> Uploaded Data</h1>
		</div>
        
         <form:form method="post" id="frm" name="frm" modelAttribute="uploadData" enctype="multipart/form-data">
		<sec:csrfInput/>
          <form:input type="hidden" id="ENdoc_id" path="ENdoc_id" />
						<form:input type="hidden" id="fileType" path="fileType" />	
						
					   <form:hidden path="enUploadId" id="enUploadId"/>	   
                 <form:hidden path="docId" id="docId"/>
       	<form:hidden path="uploadId" id="uploadId" aria-label="Upload Id"/>
       	 	<fieldset class="mt-2">
		       	<div class="section-title"><h2>Uploaded Data List</h2></div>
		       	<div class="bg_white">
	       		<table class="w-100 table table-striped table-bordered dt-responsive  dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
					<thead class="theadTransacColor">
			  			
					</thead>
			
		
			 	</table>
       			</div>
			</fieldset>
		</form:form>
	
	
	<!--Begin: modal -->
		<!-- Modal -->

<!--Begin: modal -->
		<!-- Modal -->
				<div id="showDataModel" class="showDataModel modal" role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-bs-dismiss="modal">&times;</button>
						

					</div>
						<input type="hidden" name="docID" id="docID" aria-label="Doc ID"/>
						<input type="hidden" name="typeID" id="typeID" aria-label="Type ID"/>
						
					<div class="modal-body" id="showData">
						

					</div>
					<div class="modal-footer">
					<button type="button" class="custom-btn position-relative" onClick="xmlFunction($('#docID').val())">Download XML</button>
					
						<button type="button" class="hide  btn_default btn-success btn-next">Next</button>
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
						<button type="button" class="close" data-bs-dismiss="modal">&times;</button>

						

					</div>
					<input type="hidden" name="docID" id="docID" aria-label="Doc ID"/>
					<input type="hidden" name="typeID" id="typeID" aria-label="Type ID"/>
					<div class="modal-body" id="showData2">
						

					</div>
					<div class="modal-footer">
					<button type="button"  class="custom-btn position-relative" onClick="xmlFunction($('#docID').val())">Download XML</button>
					<button type="button" class="hide btn_default btn-prev">Prev</button>
					<button type="button" class="hide btn_default btn-success btn-next">Next</button>
						<button type="button" class="btn_default btn-prev" data-bs-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		
				<div id="showDataModel3" class="showDataModel modal" role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
					
						<button type="button" class="close" data-bs-dismiss="modal">&times;</button>

						

					</div>
					<input type="hidden" name="docID" id="docID"  aria-label="Doc ID"/>
					<input type="hidden" name="typeID" id="typeID" aria-label="Type ID"/>
					<div class="modal-body" id="showData3">
						

					</div>
					<div class="modal-footer">
					<button type="button"  class="custom-btn position-relative" onClick="xmlFunction($('#docID').val())">Download XML</button>
					<button type="button" class="hide btn_default btn-prev">Prev</button>
						<button type="button" class="btn btn_default" data-bs-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- End: modal -->


		<!-- End: modal -->
		
		<!-- Modal -->
<div id="getCodeModal" class="modal" role="dialog">
  <div class="modal-dialog modal-dialog-centered">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Details</h4>
        <button type="button" class="close" data-bs-dismiss="modal">&times;</button>
        
      </div>
      <div class="modal-body" >
        <!-- Form -->
       <form:form method="post" id="frm3" target="_blank"  name="frm3" >
				<sec:csrfInput/>
        <sec:csrfInput/>

          
																					
        </form:form>

        <!-- Preview-->
        <div id="tree"></div>
      </div>
 
    </div>

  </div>
</div>

 <!-- Modal -->
 
 
 <!-- Modal -->
<div id="uploadModal" class="modal" role="dialog">
  <div class="modal-dialog  modal-dialog-centered">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Upload Receipt of Acknowledgement</h4>
        <button type="button" class="close" data-bs-dismiss="modal">&times;</button>
        
      </div>
      <div class="modal-body">
        <!-- Form -->
       <form:form method="post" id="frm2" name="frm2" modelAttribute="uploadData" enctype="multipart/form-data">
       
       
        <form:hidden path="docId1" id="docId1"/>
				<sec:csrfInput/>
        <sec:csrfInput/>
		<form:hidden path="numDocId" id="numDocId2" name="numDocId" aria-label="numDocId"/>
		<form:hidden path="hashValue" id="hashValue" name="hashValue" aria-label="hashValue"/>
          <label for="file" class="dvfrm-label">Select file :</label>
          <input class="form-control" id="file" type="file" accept="application/pdf" name="uploadfile" /><br>
			<input type="button" class="btn btn_default" value="Upload" onclick="uploadAckFile()" id="btn_upload" aria-label="Upload File">          
          
          	<div id="fileuploadRemove2">
			<a id="fileuploadDownloadLink2" href="#" style="font-size: large;">Download Uploaded Receipt</a>
											
										</div>
										
        </form:form>

        <!-- Preview-->
        <div id='preview'></div>
      </div>
 
    </div>

  </div>
</div>

 <!-- Modal -->
 
 
 <!-- --------------------------------------------- Section to add/update consignment details in invoice table ----------------------------------------------- -->
		
		
 <div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="modelForUpdateConsignment" data-easein="slideDownBigIn">
  <div class="modal-dialog modal-dialog-centered modal_wd">
    <div class="modal-content">
    
    		
			<form:form class="seminor-login-form" method="post" modelAttribute="uploadData" id="frmConsign" name="frmConsign">
				<form:hidden path="uploadId" id="uploadIdCon"/>
				<div class="modal-header theadTransacColor">
					<h3 class="modal-title" align="center">Add Consignment Details</h3>
					<button type="button" class="close" data-bs-dismiss="modal">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>
				</div>
				<div class="modal-body">

					<div class="panel-body">
						<div class="row">
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">EWay Bill No:-<span style="color:red;">*</span></label></div>
								<div class="col-md-6"><form:textarea path="ewayBill" cssClass="form-control m-input" id="ewayBill" placeholder="EWay Bill No." /></div>
							</div>	
							
						
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Bill Date:-<span style="color:red;">*</span></label></div>
								<div class="form-group">
        							<div class='input-group date' id=''>	
        								<form:input path="billDate" type="date" class="form-control" value=""
										 		id="toDate" placeholder="" />
          							</div>
      							</div>
							</div>							  
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Region Code:-<span style="color:red;">*</span></label></div>
								<div class="col-md-6"><form:textarea path="exportingRegion" cssClass="form-control m-input" id="exportingRegion" placeholder="Region Code" /></div>
								<form:select path="exportingRegion" id="exportingRegion" class="form-control" onchange="getCountryBasedOnRegion(this.value)">
									<form:option value="0">-select Export region-</form:option>
									<c:forEach items="${regionDtls}" var="p">
										<form:option value="${p.numRegionId}">${p.strRegionName}</form:option>
									</c:forEach>
								</form:select>
							</div>	
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Country of Export:-<span style="color:red;">*</span></label></div>
								
								<div class="col-md-6"><form:textarea path="exportingCountry" cssClass="form-control m-input" id="exportingCountry" placeholder="Country of Export" /></div>
								<form:select path="country_id" class="custom-select js-example-basic-multiple"
											multiple="multiple" id="exportingCountry">
									<form:option value="0">-select country-</form:option>
								</form:select>	 
							</div>							  
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Source Port Name:-<span style="color:red;">*</span></label></div>
								<div class="col-md-6"><form:textarea path="portName" cssClass="form-control m-input" id="portName" placeholder="Port Name" /></div>
							</div>
							<div class="form-group">
								<div class="col-md-6"><label for="example-text-input" class="dvfrm-label">Landing Port:-<span style="color:red;">*</span></label></div>
								<div class="col-md-6"><form:textarea path="landingPort" cssClass="form-control m-input" id="landingPort" placeholder="Landing Port" /></div>
							</div>							  
						</div>
						
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="updateConsignDtls"
						class="btn btn-primary m-btn--wide" value="forward">
						<i class="fa fa-location-arrow" style="padding-right: 15%"></i>
						Submit
					</button>
					 <button type="button" class="btn btn-primary m-btn--wide"
						data-bs-dismiss="modal">
						<i class="flaticon-circle" style="padding-right: 15%"></i>Close
					</button>

				</div>
			</form:form>
		</div> 
  </div>
</div> 	


<!-- ------------------------------------------------------------------------------------------------------------------------------ -->	

 <!-- --------------------------------------------- Section to Preview consignment details ----------------------------------------------- -->
		<div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="modelForViewConsignment" data-easein="slideDownBigIn">
			  <div class="modal-dialog modal-dialog-centered modal_wd">
				<div class="modal-content">
		  
				  <!-- Modal body -->
				  <div class="modal-body seminor-login-modal-body p-0">
					<form:form class="seminor-login-form" method="post" modelAttribute="uploadData" id="frmConsignDtls" name="frmConsignDtls">
			  			<div class="modal-header theadTransacColor">
							<h2 class="modal-title" align="center"><b>Preview Consignment Details</b></h2>
							<button type="button" class="close" data-bs-dismiss="modal">
								<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
							</button>
						</div>
							<br>		
									<div class="row" id="conData">
									
									</div>
								
						<div class="modal-footer">
							 <button type="button" class="btn_default"
								data-bs-dismiss="modal">
								Close
							</button>
		
						</div>
		  			</form:form>
		  
				  </div>
				</div>
			  </div>
			</div>		
		
<div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="modelForViewConsignment" data-easein="slideDownBigIn">
  <div class="modal-dialog modal-dialog-centered modal_wd">
    <div class="modal-content">
    
    		
			<form:form class="seminor-login-form" method="post" modelAttribute="uploadData" id="frmConsignDtls" name="frmConsignDtls">
				
				<div class="modal-header theadTransacColor">
					<h3 class="modal-title" align="center">Preview Consignment Details</h3>
					<button type="button" class="close" data-bs-dismiss="modal">
						<span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
					</button>
				</div>
				<div class="modal-body">

					<div class="panel-body">
						<br>
						<br>
							
							<div class="row" id="conData">
							
							</div>
						<br>
						<br>
					</div>
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn btn-primary m-btn--wide"
						data-bs-dismiss="modal">
						<i class="flaticon-circle" style="padding-right: 15%"></i>Close
					</button>

				</div>
			</form:form>
		</div> 
  </div>
</div>


<!-- ------------------------------------------------------------------------------------------------------------------------------ -->	
 
	</section>
	
	</div>

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
	  <script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<!-- <script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> --> 
 --%>