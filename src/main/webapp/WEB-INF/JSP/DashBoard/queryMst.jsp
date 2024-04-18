<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content-wrapper">
		<section class="regdv">
			<div class="container-fluid reg_contain">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
						<div class="float-left"><h3 class="tittle">Query Page</h3></div>
						<div class="title-icon float-left">					
							<img class="mb-10" src="images/icontab2.png" alt="">
						</div>
						<div class="scroll-top-wrapper ">
							<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>
						</div>
					</div>
					
					
					
					<div class="col-md-12">
						<form:form id="frm" name="frm" modelAttribute="solrSearchModel" 
								action="${pageContext.request.contextPath}/queryMst" method="post">
							<div class="panel panel-default " id="distributionDetails">
								<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Entity Details</b></div>
								<div class="panel-body dvfrm-panel-body">
									<div class="row">
									 	<div class=" col-md-6">
											<label class="dvfrm-label">Enter Query:<span style="color:red;">*</span><span class="iconStyle"></span></label>
											<form:textarea path="query" class="form-control"/>
										</div>
									</div>
								</div>
							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-primary" id="save"> Save </button>
							</div>
							
						</form:form>
					</div>
					<div class="col-md-12">
						<b>${data}</b>
						<b>${getMessage}</b>
					</div>
				</div>
			</section>
		</div>
</body>
</html>