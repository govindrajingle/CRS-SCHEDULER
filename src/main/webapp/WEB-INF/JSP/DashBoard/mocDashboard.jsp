<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>
</head>
<body>
	<div class="content-wrapper">
		<div class="content content-tiles">
			<div class="row auto-clear">
				<c:forEach items="${tileList}" var="k">

					<div class="col-lg-2 col-md-2 col-sm-6">
						<div class="card card-stats ${k.strColourName}">
						
							<div class="card-body ">
								<i class="bg-icon text-center fas fa-capsules"></i>
								<div class="col-lg-12 col-md-12">
									<div
										class="icon-big text-center icon-warning ${k.strIconColour}">
										<i class="${k.strIconName}" aria-hidden="true"></i>
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<div class="numbers">
										<a href="${pageContext.request.contextPath}/${k.strUrl}"
											class="card-category">${k.strTilesName}</a>


									</div>
								</div>

							</div>
							<div class="card-footer ">
								<hr>
								<div class="numbers">
								<c:set var="myParam" value="${k.strTilesName}"/>
								
									<a  href="${pageContext.request.contextPath}/${k.strCountUrl}" target=""  class="card-title" 
									style="color: white !important;">${tileMap[myParam]}</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
	<%-- 	<div class="content content-stat">
			<h3>State-wise number of sites</h3>
			<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>



			<div id="container2" style="width: 100%; height: 320px;">
				<canvas id="densityChart"> </canvas>
			</div>
	

		</div> --%>
		
      </div>
	<!-- /.content-wrapper -->
</body>
</html>