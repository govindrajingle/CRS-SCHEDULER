<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html  lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>IVEDA</title>
   </head>
   <%-- <body>
      <div class="content-wrapper pt-0 mt-0">
         <div class="content content-tiles">
         <div class="page-title">
	        <h1 class="fw-bold">Dashboard</h1>
	      </div>
            <div class="row  card-section">
               <c:forEach items="${tileList}" var="k">
                  <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
                     <div class="card">
                        <div class="card-content card-stats ${k.strColourName}">
                           <img class="bg-icon" src="images/open-medical-capsule-icon.png" alt="Capsule Background Image" />
                           <div class="card-body p-0">
                              <div class="icon-big text-center icon-warning ${k.strIconColour}">
                                 <a href="${pageContext.request.contextPath}/${k.strUrl}"
                                    class="card-category"  title="Icon Links"><i class="${k.strIconName}" aria-hidden="true"></i></a>
                              </div>
                              <div class="numbers">
                                 <a href="${pageContext.request.contextPath}/${k.strUrl}"
                                    class="card-category">${k.strTilesName}</a>
                              </div>
                           </div>
                        </div>
                        <div class="card-footer ">
                           <div class="numbers">
                              <c:set var="myParam" value="${k.strTilesName}"/>
                              <a  href="${pageContext.request.contextPath}/${k.strCountUrl}" target=""  class="card-title" 
                                 title="Tiles">${tileMap[myParam]}</a>
                           </div>
                        </div>
                     </div>
                  </div>
               </c:forEach>
            </div>
         </div>
      </div> --%>
      <!-- /.content-wrapper -->
   </body>
</html>