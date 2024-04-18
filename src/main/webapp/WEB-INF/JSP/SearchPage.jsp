<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" java.io.File,java.util.*"%> 
<%@ page isELIgnored="false" errorPage="ErrorPage.jsp"%>




<div class="content-wrapper regdv">


<div class="container-fluid reg_contain">
			    			    
<div class="m-content">
<div class="row">
	<div class="col-lg-12">

			<div class="container-fluid">
				<form:form  id="frm" name="frm" modelAttribute="hibernateSearchModel" method="POST" cssClass="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" >
			<!-- Member details -->
				<div class="panel panel-default " id="personDetails">
					<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Search</b></div>
						<div class="panel-body dvfrm-panel-body">
							<div class="row">
								<div class=" col-md-6">
									<label class="dvfrm-label">Enter code:<span style="color:red;">*</span><span class="iconStyle"></span></label>
									<form:input path="searchString" type="text" class="form-control"
								 			id="searchString" placeholder="Enter Name"/>	
								</div>
								
								
							</div>
						</div>	
				</div>
				
				<div class="text-center">
					<button type="button" class="btn btn-primary" id="save"> Search </button>
              
               	</div>
					
					<div id="response"></div>
				</form:form>
			</div>
		</div>
		<!--end::Portlet-->
	</div>
</div>		        </div>
			    		    </div></div>


<script>

$('#save').click(function() {
var searchInput=$("#searchString").val();
//alert(searchInput);
			$.ajax({
			type:"GET",
			data:{searchString :searchInput},
			url :"PerformSolrSearch",
			success: function(response){
				console.log(response);
				$("#response").html(response);
				
			}
		});
		
});
</script>			    		    
			    		    