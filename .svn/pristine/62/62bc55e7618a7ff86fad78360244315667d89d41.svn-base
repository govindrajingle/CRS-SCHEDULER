<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="in.cdacnoida.dava.util.DataEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content-wrapper regdv">


<div class="container-fluid reg_contain">

<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
					<div class="float-left"><h3 class="tittle">Statewise Site Detail</h3></div>
				<div class="title-icon float-left">					
				<img class="mb-10" src="images/icontab2.png" alt="">
				</div>
				</div>
				
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
						 <table id="sitesdisplay" class="table table-striped table-bordered dt-responsive nowrap dspit">
                    <thead class="theadTransacColor">
                        <tr>
                        <th>Site Type</th>
                            <th>Premise name</th>
                            <th>Premise Address</th>
                            <th>Site Phone Number</th>
                            <th>Fax Number</th>
                             <th>E-mail Address</th>
                             <th>GSTIN Number</th>
                             <th>GS1 Number</th>
                             <th>Contact Person Name</th>
                             <th>Contact Person Mobile Number</th>
                             <th>Contact Person E-mail</th>
                             <th>Contact Person Designation</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    
                    <c:forEach items="${siteList}" var="sitesname">
                     <tr>
                      <td>${sitesname.siteType}</td>
                             <td>${sitesname.premiseName}</td>
                           <td>${sitesname.premiseAddress}</td>
                          <td>${sitesname.contactNumber}</td>
                             <td>${sitesname.faxNumber}</td>
                           <td>${sitesname.emailId}</td>
                           <td>${sitesname.gstin}</td>
                           <td>${sitesname.gs1}</td>
                           <td>${sitesname.contactPersonName}</td>
                           <td>${sitesname.contPerMobileNo}</td>
                           <td>${sitesname.contPersEmail}</td>
                           <td>${sitesname.contactPerDesg}</td>
                    </tr>
                    </c:forEach>
                     
                    </tbody>
                </table>
					</div>

</div></div>

</body>
</html>