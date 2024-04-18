<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Get App Search Logs</title>

<div class="content-wrapper mt-0 pt-0">
		<section class="regdv content content-tiles">
			<div class="page-title"><h1 class="fw-bold">App Search Logs</h1></div>
			<div class="bg_white">
				<table class="w-100 table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed"
								id="m_table_1">
					<tr>
						<th>Email</th>
						<th>Serial Number</th>
						<th>Date</th>
					</tr>
					
					<c:forEach var="data" items="${appSerachLogs}">
						<tr>
							<td>${data.email}</td>
							<td>${data.serialNumber}</td>
							<td>${data.createdDate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</div>

	<script type="text/javascript">
		$(document).ready( function () {
		   debugger;
			$('#m_table_1').DataTable();
			 alert("hello");
		} );
	</script>
	<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script>
</body>
</html>