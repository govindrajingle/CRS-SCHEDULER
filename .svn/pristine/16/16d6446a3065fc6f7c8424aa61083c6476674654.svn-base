<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>
  
<style>
.modal-lg{
    max-width: 85%;
}

.modal-footer{
display:block !important;
}
</style>

	<!-- File Upload -->
	
	<script src="js/homepage/jquery.ui.widget.js"></script>
	<script src="js/homepage/jquery.iframe-transport.js"></script>
	<script src="js/homepage/jquery.fileupload.js"></script>	

    
	

<script>
$(document).ready(function(){
	$("#fileupload").on("change", uploadFile);
	$('#fileuploadRemove').hide();
	loadDataTable(1);

	if ('${flag}' == 1) {
		ok_message("Product Detail XML Successfully Uploaded.");
	}else if('${flag}' == 2){
		ok_message("Manufacturing Site Detail XML Successfully Uploaded.");
	}else if('${flag}' == 3){
		ok_message("Consignment Detail XML Successfully Uploaded.");
	}else if('${flag}' == 4){
		error_message("Someone tried to change in content.Failed to upload");
	}else if('${flag}' == 5){
		error_message("Duplicate codes.Failed to upload");
	}else{
		//error_message("There is some error in uploading XML files.")
	}
	
});



function getSignatureChecksum(){
	 
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
			 }else{
				 alert("Error");
			 }
		 }
		});
}



function uploadFile() {

	//getSignatureChecksum();
	
	
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
				 var filename = "XmlFileshubham"+res;
					var docId = "";
					var purposeType = $('#purposeTypeId').val();
					
					if($('#strDocId').val() == "-1")
						docId=0;
					else
						docId = $('#strDocId').val();
					
					  $.ajax({
					    url: "uploadFileXml/"+filename+"/"+docId+"/"+purposeType,
					    type: "POST",
					    data: new FormData($("#frm")[0]),
					    enctype: 'multipart/form-data',
					    processData: false,
					    contentType: false,
					    cache: false,
					    success: function (response) {
						    
					    		var Obj_List = response;
					  	 		var eNSuccessFlag = Obj_List[0].eNSuccessFlag;
					  	 	  	var SuccessFlag = Obj_List[0].successFlag;
					  	 	  	var FileName = Obj_List[0].fileName;
					  	
					  			if (SuccessFlag == 0 || SuccessFlag == 1){
					  		   		error_message("Please upload only XML files");
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
					  		        error_message("XML is Corrupted. Please try again.");
					  			   	$('#numDocId').closest('.form-group').addClass('has-error');
					  		       	}
					  		 	if (SuccessFlag == 6){
					  		        error_message("File already exist");
					  			   	$('#numDocId').closest('.form-group').addClass('has-error');
					  		       	}
					  		 	if (SuccessFlag == 7){
					  		        error_message(Obj_List[0].errorMsg);
					  			   	$('#numDocId').closest('.form-group').addClass('has-error');
					  		       	}
					  		     if (SuccessFlag == 8){
					  		        error_message("File has duplicate codes."+Obj_List[0].errorMsg);
					  			   	$('#numDocId').closest('.form-group').addClass('has-error');
					  		       	}
					  		   	if (SuccessFlag ==5){
					  		   		/* alert("File Uploaded Successfully");	 */	  		
					  		   		$('#numDocId').closest('.form-group').removeClass('has-error').addClass('has-success');
					  		   	 	$('#strDocId').val(eNSuccessFlag);
					  		   	 	$('#numDocId').val(5);
					  		   	/* 	$('#fileuploadName').text(FileName); */
					  		   		$('#fileuploadRemove').show();
					  	       		$('#fileupload').hide();			
					  	       		$('#fileuploadDownloadLink').attr('href',"${pageContext.request.contextPath}/downloadTmpFile_Secure/" +eNSuccessFlag+ "/"+2);
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


function showAppFile(divName, divfile) {
		$('#fileupload').val('');
		$('#' + divName).hide();
		$('#' + divfile).show();
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
				"sTitle" : "Uploaded Date",
				"mData" : "createddate"
			},
			{
				"sTitle" : "Uploaded Time",
				"mData" : "createdtime"
			},
			{
				"sTitle" : "Uploaded By",
				"mData" : "user_name"
			},
			{
				"sTitle" : "Site Code",
				"mData" : "str_manuf_code"
			},
			{
				"sTitle" : "Uploaded Xml",
				"mData" :  ""
			},
		{
			"sTitle" : "Action",
			"mData" : "",
			"responsivePriority" : "1",
			"sWidth" : "8%"
		}
		],
						         	responsive: !0,
									columnDefs : [
											{
												'targets' : 6,
												'searchable' : true,
												'orderable' : true,
												'className' : 'dt-body-top',
												'render' : function(
														data, type, row) {

													

													var a = "";
															
										
					    	    					a = '<a href="#" onclick="openDetails(\''+row.num_document_id+'\',\''+row.num_type_id+'\');">View Xml</a><br><a href="#" onclick="openTreeView(\''+row.num_upload_id+'\');">Tree View</a>'; 
					    	    				   return a;
															
												}
											},
											{
								"targets": 7,
			             	    "render": function ( data, type, row ) {
			             	    if(row.num_type_id == 3 ){
			             	   	var c = "";

								c = '<div class="btn-group dropleft"><button class="btn btn-sm btn-accent dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="flaticon-squares-4"></i></button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton">';
								c = c
										+ "";
							if(row.str_ackreceipt_filename != null && row.str_ackreceipt_filename != 'null' && row.str_ackreceipt_filename != ''){
						var enFid= window.btoa(row.num_document_id)
						c = c + '<a class="dropdown-item" id="uploadack'+row.num_document_id+'" href="${pageContext.request.contextPath}/downloadAckFile_Secure/' +enFid+ '/3" onclick=""  >Download Receipt of Acknowledgement</a></div></div>';
										
									}else
										c = c + '<a class="dropdown-item" id="uploadack'+row.num_document_id+'" href="#" onclick="test(\''+row.num_document_id+'\')"  >Upload Receipt of Acknowledgement</a></div></div>';
							
										return c;
										}else{
									return "";
									}
								}
							},
											{
												"targets": [],
								                 "className": "none",
								             	  
								             }],	             
    	
	});
	return Table;
}

function resetAndDrawTable(dataTableId,data,statusID){
	var sizeWidth,sizeHeight;
		sizeWidth="100%";
		sizeHeight="100%";
	var table = initTable(dataTableId,sizeWidth,sizeHeight,statusID);
	    // Get the column API object
	  // var roleId='${roleId}';
	  // if(roleId != 101){
		//var column = table.column(7);
 
        // Toggle the visibility
       // column.visible( false );
       // }
	table.clear().draw();
	table.rows.add(data); // Add new data
	table.columns.adjust().draw();
}


function loadDataTable(statusID){
	 $.ajax({
			type:"GET",
			data:{status :statusID},
			url :"getUploadXmlDetails",
			success: function(response){
				var JSONObject = JSON.parse(response);
				//alert(JSON.stringify(JSONObject.aaData));
				resetAndDrawTable("#m_table_1",JSONObject.aaData,statusID);// Redraw the DataTable
			}
		});
} 

function xmlFunction(docId){//${pageContext.request.contextPath}/downloadTmpFile_Secure/'+row.num_document_id
	//alert(docId);
	//var enFid = DataEncoder.encode(docId);
	var enFid =  window.btoa(docId);
	//alert(enFid);
	var fileType = 2;
	document.getElementById("frm").action = "${pageContext.request.contextPath}/downloadTmpFile_Secure/"+enFid+"/"+fileType;
	document.getElementById("frm").method = "GET";
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


        
		function openDetails(docId,typeId){
			$.ajax({
				type : "GET",
				data : {
					docId : docId
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
					  $(".modal-footer .pageno").removeClass('hide');
					}
					else{
					$(".modal-content .btn-prev").addClass('hide');
					  $(".modal-content .btn-next").addClass('hide');
					}
					$('#showDataModel').modal('show');
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

function test(docId){ 
    $("#numDocId2").val(docId);   
    var enFid =  window.btoa(docId);
	//alert(enFid);
	var fileType = 3;
	
	 $.ajax({
	    url: "checkifFileExists/"+enFid+"/"+fileType,
	    type: "GET",
	    success: function (response) {
	    //alert(response);
	    if(response == 'true')
	    {
	    	$('#fileuploadDownloadLink2').attr('href',"${pageContext.request.contextPath}/downloadAckFile_Secure/" +enFid+ "/"+3);
	  	    $('#fileuploadDownloadLink2').text('Download Uploaded Receipt ');
	  	    $("#fileuploadRemove2").show();
	  	    
	    } else{
	    $("#fileuploadRemove2").hide();
	    }
	        $('#uploadModal').modal('show');
	    
	    }
	    });
    
}
</script>

<script>
function uploadAckFile() {

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
	var enFid =  window.btoa(docId);
	
	
	
	  $.ajax({
	    url: "uploadFilePDF/"+docId,
	    type: "POST",
	    data: new FormData($("#frm2")[0]),
	    enctype: 'multipart/form-data',
	    processData: false,
	    contentType: false,
	    cache: false,
	    success: function (response) {
		    
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
	  		 	
	  		 	if (SuccessFlag == 6){
	  		        error_message("File already exist");
	  			   	$('#numDocId').closest('.form-group').addClass('has-error');
	  		       	}
	  		 	
	  		   	if (SuccessFlag ==5){
	  		   		   		
	  		   		
	  		   		//$('#fileuploadRemove').show();
	  	       		//$('#fileupload').hide();			
	  	       		$('#fileuploadDownloadLink2').attr('href',"${pageContext.request.contextPath}/downloadAckFile_Secure/" +enFid+ "/"+3);
	  	       		$('#fileuploadDownloadLink2').text('Download('+FileName+')');
	  	       		$('#fileuploadRemove2').show();
 				alert("File Uploaded Successfully");	
 				$('#uploadModal').modal('hide');
 				$('#uploadack'+docId).text('Download Receipt of Acknowledgement');
 				$('#uploadack'+docId).attr('href',"${pageContext.request.contextPath}/downloadAckFile_Secure/" +enFid+ "/"+3);
	  		    $('#uploadack'+docId).attr('onclick','');	
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
	</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>

<link rel="stylesheet" href="css/homepage/pw.css">

<style type="text/css">
		.alert-box {
	padding: 15px;
    margin-bottom: 20px;
    border: 1px solid transparent;
    border-radius: 4px;  
}

.success {
    color: #3c763d;
    background-color: #dff0d8;
    border-color: #d6e9c6;
    display: none;
}

.failure {
    color: #a94442;
    background-color: #f2dede;
    border-color: #ebccd1;
    display: none;
}

.warning {
    color: #8a6d3b;
    background-color: #fcf8e3;
    border-color: #faebcc;
    display: none;
}


	</style>
	

	
</head>
<body>
<div class="content-wrapper">
<section class="regdv">
	
	
	<div class="container-fluid reg_contain">
	
		
	
		<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittle">Upload Details</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div>
							
		<div class="scroll-top-wrapper ">
			<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>

		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm" modelAttribute="uploadData" enctype="multipart/form-data">
				<sec:csrfInput/>
				
				<div class="panel panel-default " id="addressDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Upload Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Purpose Type:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:select path="purposeType" class="form-control" id="purposeTypeId" required="required">
										<form:option value="0">Select Purpose Type</form:option>
										 <c:forEach items="${dataType}" var="s">
											<option value='${s.numTypeId}'>${s.strTypeName}</option>
										</c:forEach>
									</form:select>	
									
								</div>
								
								  <div class="col-md-6">
									<form:hidden path="numDocId" id="numDocId" />
									<form:hidden  path="strDocId" id="strDocId"  value="-1" />
									<label class="dvfrm-label">Upload XML</label>
										<div id="idUpload">
											<input class="form-control" id="fileupload"
												type="file" accept="application/xml" name="uploadfile" />
										</div>
										<input type="hidden" name="xmlUploadData" id="xmlUploadData">
										<div id="fileuploadRemove">
											<a id="fileuploadDownloadLink" href="#">download</a>
											<button type="button" id="fileuploadRemoveBtn" class="btn btn-primary"
													onclick="showAppFile('fileuploadRemove','fileupload')">Remove</button>
										</div>
								</div> 
									
								
							</div>
						</div>
				</div>
				
				
				<div class="text-center">
					<button type="button" class="btn btn-primary" id="save"> Save </button>
                	<button type="reset" class="btn btn-primary" id="reset"> Reset </button>
               	</div>
               	
               	
               
                 
             
                 
               	
               	 	 <fieldset>
               	<legend>Upload Xml Detail List</legend>
               	<table class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
					<thead class="theadTransacColor">
			  			
					</thead>
					
				
					 </table>
				</fieldset>
			</form:form>
		</div>
		
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
						<button type="button" class="close" data-dismiss="modal">&times;</button>

						

					</div>
						<input type="hidden" name="docID" id="docID"/>
						
					<div class="modal-body" id="showData">
						

					</div>
					<div class="modal-footer">
					<button type="button" class="btn" onclick="xmlFunction($('#docID').val())" style="
    float: left;
">Download XML</button>
					<span class="pageno hide ">Page 1 of 3</span>
						<button type="button" class="btn hide btn-default btn-next">Next</button>
					
					<!--	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
					</div>
				</div>

			</div>
		</div>
		
		<div id="showDataModel2" class="showDataModel modal " role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>

						

					</div>
					<input type="hidden" name="docID" id="docID"/>
					<input type="hidden" name="typeID" id="typeID"/>
					<div class="modal-body" id="showData2">
						

					</div>
					<div class="modal-footer">
<button type="button" class="btn" onclick="xmlFunction($('#docID').val())" style="
    float: left;
">Download XML</button>					<button type="button" class="btn hide btn-default btn-prev">Prev</button>
<span class="pageno hide ">Page 2 of 3</span>					<button type="button" class="btn hide btn-default btn-next">Next</button>
					</div>
				</div>

			</div>
		</div>
		
				<div id="showDataModel3" class="showDataModel modal" role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
					
						<button type="button" class="close" data-dismiss="modal">&times;</button>

						

					</div>
					<input type="hidden" name="docID" id="docID"/>
					<input type="hidden" name="typeID" id="typeID"/>
					<div class="modal-body" id="showData3">
						

					</div>
					<div class="modal-footer">
<button type="button" class="btn" onclick="xmlFunction($('#docID').val())" style="
    float: left;
">Download XML</button>			
	<button type="button" class="btn hide btn-default btn-prev">Prev</button>
		<span class="pageno hide ">Page 3 of 3</span>
	
					</div>
				</div>

			</div>
		</div>
		<!-- End: modal -->


		<!-- End: modal -->
		
		
		<!-- Modal -->
<div id="uploadModal" class="modal" role="dialog">
  <div class="modal-dialog modal-dialog-centered">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Upload Receipt of Acknowledgement</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        
      </div>
      <div class="modal-body">
        <!-- Form -->
       <form:form method="post" id="frm2" name="frm" modelAttribute="uploadData" enctype="multipart/form-data">
				<sec:csrfInput/>
        <sec:csrfInput/>
		<form:hidden path="numDocId" id="numDocId2" name="numDocId"/>
          <span style="
    font-size: large;
">Select file :</span><input class="form-control" id="file"
												type="file" accept="application/pdf" name="uploadfile" /><br>
		<input type="button" class="btn btn-info" value="Upload" onclick="uploadAckFile()" id="btn_upload" style="margin-left: 41%;">          
          
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
<div id="getCodeModal" class="modal" role="dialog">
  <div class="modal-dialog modal-dialog-centered">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Details</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        
      </div>
      <div class="modal-body" >
        <!-- Form -->
       <form:form method="post" id="frm3" target="_blank"  name="frm" >
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
		</section>
		
		
	<script>
	$('#save').click(function() {
	if($("#purposeTypeId").val()==0){
		 swal("Select Purpose Type!");
	}
	else if( document.getElementById("fileupload").files.length == 0 ){
    swal("Upload XML before saving!");
	}else{
		var enDocid=$('#strDocId').val();
		var purposeType=$('#purposeTypeId').val();
		 	document.getElementById("frm").action = "${pageContext.request.contextPath}/saveXmlData/"+enDocid+"/"+purposeType;
			document.getElementById("frm").method = "POST";
			$("#frm")[0].submit(); 
			}
			
	});
	</script>
	
	
	
	
	
</body>
</html>

 