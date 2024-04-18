<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
</style>

	<!-- File Upload -->
	<script src="js/homepage/jquery.ui.widget.js"></script>
	<script src="js/homepage/jquery.iframe-transport.js"></script>
	<script src="js/homepage/jquery.fileupload.js"></script>	

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
	
});




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
				"sTitle" : "EWAY bill number",
				"mData" : "str_invoice_no"
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
												'targets' : 4,
												'searchable' : true,
												'orderable' : true,
												'className' : 'dt-body-top',
												'render' : function(
														data, type, row) {

													//alert("112");
													//return '<input type="radio" class="radio" name="uid" id ="radio"'

													var a = "";

                                                   //a = '<a href="${pageContext.request.contextPath}/downloadTmpFile_Secure/'+row.num_document_id+'" target="">Download</a>'; 
													
					    	    					a = '<a href="#" onclick="openDetails(\''+row.num_document_id+'\',\''+row.num_type_id+'\');">View Xml</a>'; 
					    	    		//${pageContext.request.contextPath}/uploadXmlPage/
					    	    				   return a;
															
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
	
	table.clear().draw();
	table.rows.add(data); // Add new data
	table.columns.adjust().draw();
}


function loadDataTable(statusID){
	 $.ajax({
			type:"GET",
			data:{numTypeId:3},
			url :"getUploadExporterDetails",
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
			<div class="float-left"><h3 class="tittle"> Uploaded Data</h3></div>
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
             
                 
               	
               	 	 <fieldset>
               	<legend>Uploaded Data List</legend>
               	<table class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
					<thead class="theadTransacColor">
			  			
					</thead>
					
				
					 </table>
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
						<button type="button" class="close" data-dismiss="modal">&times;</button>

						

					</div>
						<input type="hidden" name="docID" id="docID"/>
						<input type="hidden" name="typeID" id="typeID"/>
						
					<div class="modal-body" id="showData">
						

					</div>
					<div class="modal-footer">
					<button type="button" class="btn" onClick="xmlFunction($('#docID').val())">Download XML</button>
					
						<button type="button" class="btn hide btn-default btn-next">Next</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
					<button type="button"  class="btn" onClick="xmlFunction($('#docID').val())">Download XML</button>
					<button type="button" class="btn hide btn-default btn-prev">Prev</button>
					<button type="button" class="btn hide btn-default btn-next">Next</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
					<button type="button"  class="btn" onClick="xmlFunction($('#docID').val())">Download XML</button>
					<button type="button" class="btn hide btn-default btn-prev">Prev</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- End: modal -->


		<!-- End: modal -->
	</section>
	
	</div>
	
	

	
	
	
	
</body>
</html>

  --%>