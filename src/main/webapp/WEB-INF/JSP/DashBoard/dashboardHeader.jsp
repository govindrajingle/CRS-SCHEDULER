<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1">
<meta name="description"
	content="Integrated Validation of Export of Drugs and its Authentication">
<link rel=" icon" href="images/favicon-icon.png" type="image/png">
<title>Dashboard</title>
<link rel="stylesheet" href="css/homepage/bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/homepage/bootstrap-glyphicons.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/dashboard/all.min.css">
<link rel="stylesheet" href="css/dashboard/adminlte.min.css">
<link rel="stylesheet" href="css/dashboard/dashboard_impact.css">
<link rel="stylesheet" href="css/homepage/stylesheet.css">
<link rel="stylesheet" href="css/homepage/common_style.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="css/dashboard/overlayScrollbars/css/OverlayScrollbars.min.css">
<link rel="stylesheet" href="css/homepage/font-awesome.min.css">
<link rel="stylesheet" href="css/homepage/aos.css">
<link rel="stylesheet" href="css/dashboard/sweetalert.css">
<link rel="stylesheet" href="css/dashboard/pw.css">

<link rel="stylesheet" href="js/dashboard/jquery-jvectormap-2.0.3.css">
<script src="js/homepage/jquery-3.7.0.min.js"></script>
<script src="js/homepage/bootstrap.bundle.min.js"></script>
<script src="js/homepage/wow.min.js"></script>
<script src="js/dashboard/moment.min.js"></script>
<script
	src="css/dashboard/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<script src="js/dashboard/adminlte.js"></script>
<script src="js/dashboard/dashboard.js"></script>
<script src="js/homepage/aos.js"></script>

<script src="js/dashboard/alert_new.js"></script>
<script src="js/dashboard/alert.js"></script>
<script src="js/dashboard/sweetalert.min.js"></script>
<!-- 	<script src="js/dashboard/charts/Chart.js"></script>  -->
<!-- File Upload -->
<script src="js/homepage/jquery.ui.widget.js"></script>
<script src="js/homepage/jquery.iframe-transport.js"></script>
<script src="js/homepage/jquery.fileupload.js"></script>
<script src="js/dashboard/jquery-jvectormap-2.0.3.min.js"></script>
<script src="js/dashboard/jquery-jvectormap-world-mill.js"></script>


<link rel="stylesheet" href="css/dataTable/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/dataTable/responsive.bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/dataTable/datatables.bundle.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/dataTable/jquery.dataTables.min.css"
	rel="stylesheet">


<script type="text/javascript"
	src="js/dataTable/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="js/dataTable/dataTables.bootstrap.min.js"></script>
<script type="text/javascript"
	src="js/dataTable/dataTables.responsive.min.js"></script>
<script type="text/javascript"
	src="js/dataTable/responsive.bootstrap.min.js "></script>
<script type="text/javascript" src="js/dataTable/datatables.bundle.js"></script>
<!--  <script type="text/javascript" src="js/dataTable/dataTables.editor.min.js"></script> -->

<link rel="stylesheet" href="js/validation/bootstrapValidator.css"
	rel="stylesheet">
<script type="text/javascript" src="js/validation/bootstrapValidator.js"></script>
<!-- <link href="css/dashboard/jquery.multiselect.css" rel="stylesheet" />
<script src="js/dashboard/jquery.multiselect.js"></script> -->
<!-- CSS -->
<link href="jqv_map/jqvmap.css" media="screen" rel="stylesheet"
	type="text/css" />

<!-- JS -->

<script src="jqv_map/jquery.vmap.js" type="text/javascript"></script>
<script src="jqv_map/jquery.vmap.world.js" type="text/javascript"></script>
<script src="jqv_map/jquery.vmap.continents.js" type="text/javascript"></script>
<script src="jqv_map/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="jqv_map/jquery.vmap.programdata.js" type="text/javascript"></script>


<link rel="stylesheet" href="css/dashboard/select2.css">
<script src="js/dashboard/select2.js"></script>
</head>
<body>
<%-- 
	<!-- Navbar -->
	<div class="layer">
		<nav class="main-header navbar navbar-expand"> <!-- Left navbar links -->
		<ul class="navbar-nav nav-left">
			<li class="nav-item"><a class="nav-link" data-widget="pushmenu"><i
					class="fas fa-bars"></i></a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/Dashboard"> <i
					class="fas fa-home" title="Dashboard"><span class="sr-only">
							Home</span> </i>
			</a></li>
		</ul>


		<!-- Right navbar links -->
		<ul class="navbar-nav ml-auto nav-right">
			<div class="pull-right padded">

				<div class="header-right-left ">

					<c:if test="${not empty lastLogin}">
						<div class="header-right-left ">
							Last Login :<span class="blue bold"> ${lastLogin}</span>
						</div>
					</c:if>

					<!-- Last Login :<span class="leftdt bold"><%= (new java.util.Date()).toLocaleString()%></span> -->
				</div>

			</div>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/EmailData"> <i
					class="fas fa-envelope" title="Email Data"> <span
						class="sr-only"> Email Data</span>
				</i>

			</a></li>

			<li class="nav-item dropdown"><a class="nav-link"
				data-bs-toggle="dropdown"><span><i class="fas fa-user"
						title=""></i></span></a>

				<div
					class="dropdown-menu dropdown-menu-lg dropdown-menu-right headerdropdown-menu">
					<div class="dropdown-menu-header">
						<div class="dropdown-menu-header-inner bg-info">
							<div class="menu-header-content text-left">
								<div class="widget-content p-0">
									<div class="widget-content-wrapper">
										<div class="widget-content-left">
											<h4 class="fw-bold">${userData.userName}</h4>
											<div class="widget-subheading">(${userData.userType} -
												${uniqueCode})</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="dropdown-divider"></div>
					<a href="/IVEDA/download/Manuals_iveda/User Manual_for_iVEDA_v1.1 .pdf"
						class="dropdown-item"> Download User Manual </a>

					<div class="dropdown-divider"></div>
					<a
						href="/IVEDA/download/Manuals_iveda/DesktopApp_User Manual_v1.0.pdf"
						class="dropdown-item"> Download User Manual for Desktop App </a>

					<div class="dropdown-divider"></div>
					<a href="/IVEDA/download/IVEDADesktopApp.zip" class="dropdown-item">
						Download Desktop App version ${desktopAppVersion} </a>

					<div class="dropdown-divider"></div>
					<a href="${pageContext.request.contextPath}/updateProfile"
						class="dropdown-item"> User Profile </a>
					<!--  <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item"><i class="fa fa-bell-o fnticon" aria-hidden="true"></i>
           Notifications
          
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item"><i class="fa fa-undo fnticon" aria-hidden="true"></i>
             Switch Role
           
          </a> -->

					<div class="dropdown-divider"></div>
					<a href="${pageContext.request.contextPath}/changePassword"
						class="dropdown-item"> Change Password </a>
					<div class="dropdown-divider"></div>
										<a href="${pageContext.request.contextPath}/resetDongle"
						class="dropdown-item" onclick="resetDongleWithConfirmation()"> Reset Digital
						(Signature/ Certificate) </a>
					<a href="javascript:void(0);" class="dropdown-item"
						onclick="resetDongleWithConfirmation()"> Reset Digital
						(Signature/ Certificate)</a>
					<div class="dropdown-divider"></div>
					<a href="${pageContext.request.contextPath}/logout"
						class="dropdown-item"> Logout </a>

				</div></li>
			 <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="${pageContext.request.contextPath}/logout">
         <span class="glyphicon glyphicon-off"></span><span class="txt-hd">Logout</span>
        </a>
      </li>
		</ul>

		</nav>
	</div>
	<!-- /.navbar -->

	<!-- Main Sidebar Container -->
	<div class="dsh_main">
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<!-- Brand Logo --> <a href="/IVEDA/Dashboard" class="brand-link">
			<img src="images/logo1.png" alt="iVEDA Logo" class="brand-image">
			<span class="brand-text">Integrated Validation of Export of <br>Drugs
				& its Authentication
		</span>
		</a> <!-- Sidebar -->
		<div class="sidebar">
			<!-- Sidebar user panel (optional) -->
			<!--  <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="images/avatar5.png" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">User Profile</a>
        </div>
      </div> -->

			<!-- Sidebar Menu -->
			<nav class="mt-4">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->

				<!-- -------- Added by Deepshikha for role wise dynamic menu ---------------------->
				<c:forEach items="${menuList}" var="mL">
					<li class="nav-item has-treeview"><c:if
							test="${!empty mL.numGroupId}">
							<a href="#" class="nav-link"> <i
								class="nav-icon fab fa-wpforms"></i>
								<p class="w-100">${mL.groupName}</p> <i
								class="right fas fa-angle-left"></i>
							</a>
							<ul class="nav nav-treeview">
								<c:forEach items="${mL.arrProcessName}" var="process"
									varStatus="status">
									<li class="nav-item"><a
										href="${mL.arrProcessURL[status.index]}" class="nav-link ">
											<!-- -->
											<p class="w-100">${process}</p>
									</a></li>
								</c:forEach>
							</ul>
						</c:if></li>
				</c:forEach>

			</ul>
			</nav>
			<!-- /.sidebar-menu -->
		</div>
		<!-- /.sidebar --> </aside>


		<!-- Content Header (Breadcrumbs) -->
		<div class="content-wrapper content-wrap">
			<div class="content-header">
				<div class="container-fluid content-prg">
					<div class="row mb-2">
						<div class="col-md-6 col-sm-12">
							<ol class="breadcrumb float-sm-left">
								<li class="breadcrumb-item"><a
									href="${pageContext.request.contextPath}/Dashboard">Home</a></li>
								<c:if test="${roleId ==100}">
									<li class="breadcrumb-item active">Manufacturer
										${uniqueCode}</li>
								</c:if>
								<c:if test="${roleId ==101}">
									<li class="breadcrumb-item active">Merchant Exporter
										${uniqueCode}</li>
								</c:if>
								<c:if test="${roleId ==200}">
									<li class="breadcrumb-item active">Pharmexcil Official</li>
								</c:if>
								<c:if test="${roleId ==105}">
									<li class="breadcrumb-item active">Custom Official</li>
								</c:if>
								<c:if test="${roleId ==104}">
									<li class="breadcrumb-item active">Manufacturing Site
										Official ${premiseUniqueCode}</li>
								</c:if>
							</ol>
						</div>
						<!-- /.col -->

						<c:if test="${roleId != 200}">
							<div class="col-md-6 col-sm-12">
								<div class="profile-completion ">
									<!--  <h5><i class="fas fa-building"></i>Profile Completeness</h5> -->
									<span class="skill">Profile ${percent}% Complete</span>
									<div class="progress skill-bar ">
										<div
											class="progress-bar progress-bar-success progress-bar-striped active"
											role="progressbar" aria-valuenow="${percent}"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
								</div>
							</div>
							<!-- /.col -->
						</c:if>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
		</div>
		<!-- /.content-header -->
	</div>
	<script type="text/javascript" src="js/homepage/sha256.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script>
	<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>

	<script>
function resetDongleWithConfirmation() {
    message_alert1("Are you sure you want to reset the Digital (Signature/Certificate)?")
        .then((ok) => {
            if (ok) {
                // User clicked "Ok," perform the resetDongle action here
                window.location.href = '/IVEDA/resetDongle';
                alert("Digital certificate reset !!")
            } else {
                // User clicked "Cancel" or closed the dialog, no action needed
            }
        })
        .catch(() => {
            // Handle errors if any
        });
}

function message_alert1(msg) {
    return new Promise((resolve) => {
        var m = msg.split('.');
        var msg1 = m[0];
        msg2 = m[1];
        swal({
            title: msg1,
            text: msg2,
            showCancelButton: true,
            confirmButtonColor: "#34A534",
            confirmButtonText: "Ok",
            cancelButtonText: "Cancel",
            closeOnConfirm: true,
            closeOnCancel: true
        },
        function(isConfirm){
            if (isConfirm) {
                resolve(true); // Resolve with true for "Ok"
            } else {
                resolve(false); // Resolve with false for "Cancel"
            }
        });
    });
}
</script> --%>
</body>
</html>