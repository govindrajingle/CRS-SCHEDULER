<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>


</head>
<body>
	<div class="content-wrapper">
<section class="regdv">	
	<div class="container-fluid reg_contain">
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittle">Gallery Details</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div>
		
		<div class="col-md-12">
			<form:form method="post" id="frm" name="frm" modelAttribute="galleryForm" action="galleryform" enctype="multipart/form-data" role="form" data-toggle="validator" novalidate="true">
			<div class="panel panel-default " id="addressDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Enter Event detail</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								
								
								<div class=" col-md-6">
								<form:input path="galleryId" type="hidden" class="form-control" value="" id="galleryId" placeholder="" />
								<form:input path="flag" type="hidden" class="form-control" value="" id="flag" placeholder="" />
								<form:input path="galleryImagepath" type="hidden" class="form-control" value="" id="gallerypathlist" placeholder="" />
								
									<label class="dvfrm-label">Event Name:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="eventName" type="text" class="form-control"
								 			id="eventName" placeholder="Enter Event Name" required="required" data-error="Please enter event name"/>	
								 		
								</div>
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Event Place:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="eventPlace" type="text" class="form-control"
								 			id="eventPlace" placeholder="Enter Event Place" required="required" data-error="Please enter event Place"/>	
								</div>
												
											
								
								
								<div class=" col-md-6">
									<label class="dvfrm-label">Event Date:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<div class="form-group">
        								<div class='input-group date' id=''>	
        	<form:input path="eventDate" type="date" class="form-control" value=""	id="eventDate" placeholder="" required="required" data-error="Please enter event date"/>
										 	 <span class="input-group-text" id="basic-addon2"><span class="fa fa-calendar"></span>
                    </span>
										 	
          								</div>
      								</div>
								</div>
								
									<div class=" col-md-6">
									<label class="dvfrm-label">Event Publish Date:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<div class="form-group">
        								<div class='input-group date' id=''>	
        		<form:input path="eventPublishDate" type="date" class="form-control" value="" id="eventPublishDate" placeholder="" required="required" data-error="Please enter event publish date"/>
					
						 <span class="input-group-text" id="basic-addon2"><span class="fa fa-calendar"></span>				 	
          								</div>
      								</div>
      								
								</div>
								
										<div class=" col-md-6">
									<label class="dvfrm-label">Event Expiry Date:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<div class="form-group">
        								<div class='input-group date' id=''>	
        			<form:input path="eventExpiryDate" type="date" class="form-control" value="" id="eventExpiryDate" placeholder="" required="required" data-error="Please enter event expire date"/>
								 <span class="input-group-text" id="basic-addon2"><span class="fa fa-calendar"></span>		 	
          								</div>
      								</div>
								</div>
								
										
								
								<div class=" col-md-6">
									<label class="dvfrm-label" for=ssiNumber>Upload images:<span style="color:red;">*</span><span class="iconStyle"></span></label>
				<input type="file" class="form-control" name="galleryImage" id="galleryIdimage" placeholder="Please upload images only" accept="image/*"  multiple="multiple"/>
									
			
								</div>
								
								
								
							
							<div class="col-md-12 text-center">
				<input type="button" class="btn btn-primary" id="savegellery" value="Submit" onclick="validgalleryform()" />
				<!--  <input type="button" class="btn btn-primary" id="Modify" value="Modify" onclick="validgalleryform()" style="display:none"/>-->
                 
               	</div>	
								
								
								
								
							</div>
						</div>
				</div>
				</form:form>
				</div>
				<div id="msg"></div>
				<div class="col-md-12">
					<fieldset>
               	<legend>Event List</legend>
               	<table class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="eventlist">
					<thead class="theadTransacColor">
			  			  <tr>
                            <th>Gallery id</th>
                            <th>Event Name</th>
                            <th>Event Place</th>
                            <th>Event Date</th>
                            <th>Event Publish Date</th>
                            <th>Event Expiry Date</th>
                            <th>Delete</th>
                            <th>Gallery image path </th>
                            
                        </tr>
					</thead>
					 <tbody>
                    
                    <c:forEach items="${eventList}" var="eventnamelist">            
                     <tr>
                     <td>${eventnamelist.galleryId}</td>
                      <td>${eventnamelist.eventName}</td>
                        <td>${eventnamelist.eventPlace}</td>                  
                         <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${eventnamelist.eventDate}" /></td>
                            <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${eventnamelist.eventPublishDate}" /></td>
                              <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${eventnamelist.eventExpiryDate}" /></td>
                      <td><div class="" ><a href="#" onclick="deleteEntry('${eventnamelist.galleryId}');" id="editor_remove"><i class="fa fa-trash"></i></a></div></td>
                      <td>${eventnamelist.galleryImagepath}</td>
                      </tr>
                      </c:forEach>
				</table>
				</fieldset>
				</div>
				
				
	</div>
</section>

</div>
<script>

function deleteEntry(pUID){
	console.log("deleteEntry==");
	console.log("pUID=="+pUID);
	 $.ajax({
			type : 'GET',
			url : 'deletegallerydata',
			 data: { pUID : pUID},
								success : function(response) {
									//ok_message(response);
									alert(response);
									window.location.reload();			
									 
			}
			
		}); 
	}


$(document).ready(function() {
if('${uploadedResult}'== 2){
	ok_message("Data Added Successfully.");
		
	}
	
	if('${uploadedResult}'== 1){
		error_message("Data is not added.");}
	
	

	
});
	


</script>
	</body>
	</html>