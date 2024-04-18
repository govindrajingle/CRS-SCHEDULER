<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

	<!-- File Upload -->
	<script src="js/homepage/jquery.ui.widget.js"></script>
	<script src="js/homepage/jquery.iframe-transport.js"></script>
	<script src="js/homepage/jquery.fileupload.js"></script>	
<script src="http://www.datejs.com/build/date.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	       
	$("#frm")
	.bootstrapValidator(
		{
			fields : {
				numEventType : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Event Type',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('numEventType').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  },							  
			  eventDate : {
					selector : '#eventDate',
					validators : {
						notEmpty : {
							message : 'The Date is required'
						}
					}
				},
				details : {
					validators : {
						notEmpty : {
							message : "Details is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						
					}
				},
				status : {
	 				validators : {
	 					callback: {
	 				           message: 'Please specify Status',
	 				           callback: function(value, validator, $field) {
	 				               
	 				               var options = validator.getFieldElements('status').val();

	 				               return (options != 0);
	 				           }
	 					}
	 				}
			  }, 
			  publishDate : {
					selector : '#publishDate',
					validators : {
						notEmpty : {
							message : 'The Date is required'
						}
					}
				},
				validUpto : {
					selector : '#validUpto',
					validators : {
						notEmpty : {
							message : 'The Date is required'
						}
					}
				},
				approveBy : {
					validators : {
						notEmpty : {
							message : "ApprovedBy is required and can\'t be empty"
						},
						regexp : {
							regexp : /^[a-zA-Z0-9().\/,\s\-]+$/,
							message : "Only alphabet, numbers, special characters( / , . () - ) and white spaces are permitted"
						},
						stringLength : {
							min : 1,
							max : 50,
							message : "ApprovedBy can contain maximum of 50 characters"
						}
					}
				}
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
		ok_message("News Added Successfully.");
		
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
		document.getElementById("frm").action = "${pageContext.request.contextPath}/saveNewsEvents";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}
	
	
});

</script>
<script>

function test(){
		 $("#save").show();
	 	showAppFile('fileuploadRemove','fileupload');
		$('#frm')[0].resetForm();
	 
}


function checkEventDate(){
	if ($('#eventDate').val() != '') {
		var curDate = new Date();
		var eventDate = $('#eventDate').val();
		var eventDateSplit = eventDate.split("-");
		objJoinDate = new Date(eventDateSplit[1] + " " + eventDateSplit[2] + " " + eventDateSplit[0]);
		if (curDate < objJoinDate) {
			warning_message("Event Date cannot be greator than current date!.");
			$('#eventDate').val("");
		}
		else {
		}
	
	}
}

function checkPublishDate(){
	if ($('#publishDate').val() != '') {
		var curDate = new Date();
		var publishDate = $('#publishDate').val();
		var publishDateSplit = publishDate.split("-");
		objPublishDate = new Date(publishDateSplit[1] + " " + publishDateSplit[2] + " " + publishDateSplit[0]);
		if (curDate > objPublishDate) {
			warning_message("Publish Date cannot be less than current date!.");
			$('#publishDate').val("");
		}
		else {
		}
	
	}
}

function checkValidUptoDate(){
	if ($('#validUpto').val() != '') {
		var curDate = new Date();
		var validUptoDate = $('#validUpto').val();
		var validUptoDateSplit = validUptoDate.split("-");
		objValidUptoDate = new Date(validUptoDateSplit[1] + " " + validUptoDateSplit[2] + " " + validUptoDateSplit[0]);
		if (curDate > objValidUptoDate) {
			warning_message("Valid upto date cannot be less than current date!.");
			$('#validUpto').val("");
		}
		else {
		}
	
	}
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
			<div class="float-left"><h3 class="tittle">News / Events</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div>
							
		<div class="scroll-top-wrapper ">
			<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>

		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm" modelAttribute="newsEventsModel" enctype="multipart/form-data" autocomplete="off">
				<c:forEach items="${errors }" var="error">
                    	<div class="alert alert-success" role="alert">
  							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  						<div class="text-danger">
							<c:out value="${error }"></c:out>
						</div>
						</div>	
				</c:forEach>
				<sec:csrfInput/>
					<form:hidden path="numEventId" id="numEventId" />
				<div class="panel panel-default " id="addressDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Add News/Events Details</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-md-6">
									<label class="dvfrm-label">Event Type:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:select path="numEventType" class="form-control" id="eventType" required="required">
										<form:option value="0">Select Event Type</form:option>
										 <c:forEach items="${eventTypeList}" var="s">
									<option value='${s.numEventTypeId}'>${s.strEventTypeName}</option>
								</c:forEach>
									</form:select>	
									
								</div>
								
								<div class="col-md-6">
									<label class="dvfrm-label">Event Date<span style="color: red;">*</span></label>
									<div class="form-group">
        								<div class='input-group date' id=''>	
        									<form:input path="eventDate" type="date" class="form-control" value=""
										 	id="eventDate" placeholder="" onchange="checkEventDate();"/>
										 	<span class="input-group-addon">
                        						<!-- <span class="glyphicon glyphicon-calendar"></span> -->
          									</span>	
          								</div>
      								</div>
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Details<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="details" type="text" class="form-control"
								 			id="details" placeholder="Enter the News" required="required"/>	
								</div>																
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Status:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:select path="status" class="form-control" id="status" required="required">
										<form:option value="0">Select Status</form:option>
										<form:option value="1">Public</form:option>
										<form:option value="2">Hold</form:option>
									</form:select>	
								</div>
								
								<div class="col-md-6">
									<label class="dvfrm-label">Publish Date<span style="color: red;">*</span></label>
									<div class="form-group">
        								<div class='input-group date' id=''>	
        									<form:input path="publishDate" type="date" class="form-control" value=""
										 	id="publishDate" placeholder="" onchange="checkPublishDate();"/>
										 	<span class="input-group-addon">
                        						<!-- <span class="glyphicon glyphicon-calendar"></span> -->
          									</span>	
          								</div>
      								</div>
								</div>
								
								<div class="col-md-6">
									<label class="dvfrm-label">Valid Upto<span style="color: red;">*</span></label>
									<div class="form-group">
        								<div class='input-group date' id=''>	
        									<form:input path="validUpto" type="date" class="form-control" value=""
										 	id="validUpto" placeholder="" onchange="checkValidUptoDate();"/>
										 	<span class="input-group-addon">
                        						<!-- <span class="glyphicon glyphicon-calendar"></span> -->
          									</span>	
          								</div>
      								</div>
								</div>
								
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Approve By:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="approveBy" type="text" class="form-control"
										 id="approveBy" placeholder="Enter approve by" required="required"/>	
								</div>		
														
								
							</div>
						</div>
				</div>
				
				
				<div class="text-center">
					<button type="button" class="btn btn-primary" id="save"> Save </button>
                	<button type="reset" class="btn btn-primary" id="reset"> Reset </button>
               	</div>              	
			</form:form>
		</div>
		
	</div>
	
	</section>
	
	</div>
	
	
	<script>



	</script>
	
	<script>
	</script>

</body>
</html>

 