

 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--  <%@ page contentType="text/html"%> --%>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory,
javax.xml.parsers.DocumentBuilder,org.w3c.dom.*"
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>
</head>


<body>
	

 <%
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();

Document doc = db.parse("F:/DAVA_DEV/DAVA_PORTAL/src/main/webapp/WEB-INF/XSD/PROSchema.xml");


 
NodeList nl= doc.getElementsByTagName("PRODUCT_NAME");
NodeList n2= doc.getElementsByTagName("GENERIC_NAME");
NodeList n3= doc.getElementsByTagName("COMPOSITION");
NodeList n4= doc.getElementsByTagName("SCHEDULED");
NodeList n5= doc.getElementsByTagName("USAGE");
NodeList n6= doc.getElementsByTagName("REMARK");
NodeList n7= doc.getElementsByTagName("HS_CODE");

 
%>

<center>
 <table width="100%" border="1" cellspacing="2" cellpadding="2">
 <tr>
 <td style="background:#000033;color:#FFFFFF;font-weight:bold;">Product Name</td>
 <td style="background:#000033;color:#FFFFFF;font-weight:bold;">Generic Name</td>
 <td style="background:#000033;color:#FFFFFF;font-weight:bold;">Composition</td>
 <td style="background:#000033;color:#FFFFFF;font-weight:bold;">Scheduled</td>
 <td style="background:#000033;color:#FFFFFF;font-weight:bold;">Usage</td>
  <td style="background:#000033;color:#FFFFFF;font-weight:bold;">Remark</td>
  <td style="background:#000033;color:#FFFFFF;font-weight:bold;">HsCode</td>
 </tr>
 
 <tr>

 <%
 for(int i=0; i<6;i++)
 {
 %>
 
 <td><%= nl.item(i).getFirstChild().getNodeValue() %></td>
 <td><%= n2.item(i).getFirstChild().getNodeValue() %></td>
 <td><%= n3.item(i).getFirstChild().getNodeValue() %></td>
 <td><%= n4.item(i).getFirstChild().getNodeValue() %></td>
 <td><%= n5.item(i).getFirstChild().getNodeValue() %></td>
 <td><%= n6.item(i).getFirstChild().getNodeValue() %></td>
 <td><%= n7.item(i).getFirstChild().getNodeValue() %></td> 
 </tr>
 <%
 }
 %>
	  
	  
</table>
</center>	 
	 
</body>
</html> 