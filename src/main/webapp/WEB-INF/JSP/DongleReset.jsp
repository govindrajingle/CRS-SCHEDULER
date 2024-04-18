<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Digital Signature/ Certificate</title>
    <script>
        // Function to submit the form
        function validform() {
            document.getElementById("dashboardForm").submit();
        }
    </script>
</head>
<body>
    <div class="content-wrapper mt-0 pt-0 changePassword_page">
        <section class="regdv content content-tiles">
            <div class="page-title">
                <h1 class="fw-bold">Digital Signature/ Certificate Reset Successful</h1>
            </div>
            <form id="dashboardForm" action="${pageContext.request.contextPath}/Dashboard" method="get">
                <div class="text-center mt-0">
                    <input type="button" class="custom-btn position-relative" id="infosavebutton" value="Go To Dashboard" onclick="validform()" />
                </div>
            </form>
        </section>
    </div>
</body>
</html>
