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
		<section class="regdv">
			<sec:authorize access="hasRole('ADMIN')">
			Hello ADMIN
		</sec:authorize>
		<sec:authorize access="hasRole('USER')">
			Hello USER
		</sec:authorize>	
		 
		
		<h4>Hello <sec:authentication property="principal.username"/></h4>
		<a href="${pageContext.request.contextPath}/logout">Logout</a>
		<a href="${pageContext.request.contextPath}/adminHime">Admin Home</a>
		</section>
		
</body>
</html>