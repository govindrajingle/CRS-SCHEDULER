<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>
</head>
<body>
	<div class="container">
		
		<c:if test="${registrationSuccessful}">
			<h2> Registration Successful.... A verification link is sent to your registered email id. Please verify your email address 
			 	by clicking on the link present in mail.<br>
			 	Please click on home to go to home page
			</h2>
		</c:if>
		
		<c:if test="${emailVerificationSuccessful}">
			<h2>
				Email Verification Successful... You can proceed to login<br> 
					Please click on home to go to home page
			</h2>
		</c:if>	
		
	</div>
</body>
</html>