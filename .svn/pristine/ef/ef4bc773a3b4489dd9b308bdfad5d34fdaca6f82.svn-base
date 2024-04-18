<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<script type="text/javascript">
	$(document).ready(function() {
		//alert('${premisesNo}');
		
	});
</script>


<div class="content-wrapper mt-0 pt-0">
	<section class="regdv content content-tiles">	
<div class="page-title"><h1 class="fw-bold">Manufacturing Site Details Preview</h1></div>		
<form:form id="frm" name="frm" modelAttribute="registrationForm">
	<form:hidden id="numPremiseNo" path="numPremiseNo" />
	<div class="bg_white">
 
															   
																						   
										   
														
		 
		
  
	  
	  
		<div id="accordion" role="tablist">
			<div class="row">
				${viewdata}
			</div>

		</div>
		<div class="form-group text-center">
			<!-- <button type="button" id="back" class="btn btn-success" value="back">
				<i class="fa fa-refresh fa-1x pad-right"></i>Edit</button> -->
				
			<button type="button" id="next" class="custom-btn position-relative" value="back">
				Final Submit</button>
		</div>
	</div>

</form:form>

</section>
</div>
	 <script>
	$('#back').click(function() {
		$("#numPremiseNo").val('${premisesNo}');
		document.getElementById("frm").action = "${pageContext.request.contextPath}/previousMemberSiteDetails";
		document.getElementById("frm").method = "GET";
		document.getElementById("frm").submit();

	});
	
	$('#next').click(function() {
		document.getElementById("frm").action = "${pageContext.request.contextPath}/finalSubmitMemberSiteDetails";
		document.getElementById("frm").method = "POST";
		document.getElementById("frm").submit();
		alert("Manufacturing site details added successfully");
	}); 
</script> 

