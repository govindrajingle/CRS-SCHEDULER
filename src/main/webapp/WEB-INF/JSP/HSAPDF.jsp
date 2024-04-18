<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<head>





</head>

<body>

	<div class="content-wrapper">
		<section class="regdv">
			<div class="container-fluid reg_contain">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
						<div class="float-left"><h3 class="tittle">Solr Config Page</h3></div>
						<div class="title-icon float-left">					
							<img class="mb-10" src="images/icontab2.png" alt="">
						</div>
						<div class="scroll-top-wrapper ">
							<span class="scroll-top-inner"> <i class="fa fa-2x "></i> </span>
						</div>
					</div>
					
					
					
					<div class="col-md-12">
						<form:form id="frm" name="frm" modelAttribute="solrSearchModel" 
								action="${pageContext.request.contextPath}/HSAPDF" method="post">
							<div class="panel panel-default " id="distributionDetails">
								<div class="panel-heading bluepanel medium bold panel-sfda dvfrm-panel-heading"><b>Import Details</b></div>
								<div class="panel-body dvfrm-panel-body">
									<div class="row">
									 	<div class=" col-md-6">
											<label class="dvfrm-label">Fresh Import:<span style="color:red;">*</span><span class="iconStyle"></span></label>
											 <form:select path="freshImport" class="form-control" id="freshImport">
												<form:option value="true">Yes</form:option>
												<form:option value="false">No</form:option>
											 </form:select>	
										</div>
									</div>
								</div>
							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-primary" id="save"> Save </button>
							</div>
							
						</form:form>
					</div>
					
				</div>
			</section>
		</div>
</body>