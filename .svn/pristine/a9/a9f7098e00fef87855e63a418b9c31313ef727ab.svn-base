<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<title>About Us</title>
<script>
$(document).ready(function(){
	//alert("on load");
	$("#frm").bootstrapValidator({
											fields : {
												aboutUs : {
													validators : {
														notEmpty : {
															message : "About us is required and can\'t be empty"
														}
													}
												}
											}
		});
	
	$('#save').click(function() {
		//alert("hello")
		 var bV = $("#frm").data('bootstrapValidator');
		   bV.validate();
			if(bV.isValid()){ 
				confirm_alert('Do you Really want to save?','save');
			}
			else{
			}
		});
	
	
	if('${flagSave}'== 1){
		ok_message("Content updated Successfully.");
		
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
						    	  } 

					    	  else {
					    		  imp=false;
					    	  }
					    	});
	}

	function submit_form(){
		document.getElementById("frm").action = "${pageContext.request.contextPath}/saveAboutUs";
		document.getElementById("frm").method = "POST";
		$("#frm").submit();
	}
});

</script>
<div class="content-wrapper mt-0 pt-0">
<section class="regdv content content-tiles">
	<div class="page-title"><h1 class="fw-bold">About Us</h1></div>
			<form:form method="post" id="frm" name="frm" modelAttribute="aboutUsModel">
				<sec:csrfInput/>
				<div class="panel panel-default " id="dynamicAboutUs">
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class="col-lg-6 col-md-12 col-sm-12">
									<div class="form-group">
										<label class="dvfrm-label" for="aboutUs">About Us :<span style="color:#cd2026;">*</span><span class="iconStyle"></span></label>
										<form:textarea path="aboutUs" type="text" class="form-control" id="aboutUs" placeholder="" required="required"/>
									</div>
								</div>
							</div>
						</div>	
				</div>
				
				<div class="text-center">
					<button type="button" class="custom-btn position-relative" id="save"> Save </button>
                	<button type="reset" class="btn_default" id="reset"> Reset </button>
               	</div>
               	
			</form:form>
	</section>
	
</div>