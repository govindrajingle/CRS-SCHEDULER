<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib
	uri="http://www.springframework.org/tags" prefix="spring"%><%@ taglib
	prefix="sec" uri="http://www.springframework.org/security/tags"%><%@ page
	import="in.cdacnoida.dava.util.DataEncoder"%>
<!DOCTYPE html>
<html lang="en">
<head>


<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #000;
}

.welcome-text {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 50%;
	height: 50%;
	text-align: center;
	display: flex;
	align-items: center;
	justify-content: center;
	border: 2px solid white; /* Black border */
	color: white; /* Font color */
	font-family: 'Raleway', sans-serif;
}

h1 {
	font-size: 3em; /* Large font size */
}
</style>
<title>IVEDA</title>

<script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script>
<script type="text/javascript" src="js/formFieldValidation/md5.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description"
	content="Integrated Validation of Export of Drugs and its Authentication">

</head>

<body>
	<div class="welcome-text">
		<h1>BIS - CRS</h1>
	</div>
</body>

<%-- <body id="body" data-spy="scroll" data-target=".navbar" data-offset="50" onload=changeRegistrationCaptcha()>
    
<!--   <script>
  function changeCaptcha() {
      var captcha = Math.random().toString(36).substring(7);
      document.getElementById("registrationCaptchaOne").innerHTML = captcha; 
    }
  window.onload = function() {
      changeRegistrationCaptcha();
  };
    </script>  -->
  
    <section id="topslide" class="hero-banner">
      <div class="hero-banner-form">
            <div id="mySidenav" class="sidenav">
              <div class="content7 p-0">
                <div class="banner-verifacation-form">
                   <div class="trck">
                   <a class="closebtn"  onclick="closeNav()">&times;</a>  
                      <form:form id="frm" name="frm" modelAttribute="hibernateSearchModel" onsubmit="" class="clear">

                         <div class="bannerform">
                           <div class="slide-text">
                             <div class="page-title position-relative"><h1>Drug Validation and <span>Authentication</span></h1></div>
                          </div>
                         <div class="form-group">
                           <label for="searchString">Enter Verification Code:</label>
                           <a class="fw-bold help_link" data-bs-toggle="modal" data-bs-target="#guidelines_model"> <i class="fa fa-question-circle" aria-hidden="true"></i> Help</a>
                           <!-- <span class="tooltip">
                              <i class="fa fa-question-circle" aria-hidden="true"></i>
                               <p>Help</p> --
                              <div class="top">
                                 <ul>
                                    <li>Please enter verification key </li>
                                 </ul>
                                 <i></i>
                              </div>
                           </span> -->
                           <div class="input-group">
                              <span class="d-flex input-group-addon bg-dark rounded-top rounded-bottom">
                              <i class="fa fa-qrcode text-white" style="font-size: 26px;"></i>
                              </span>

                              <input path="searchString" type="text" class="form-control" id="searchString" placeholder="Verification Code"  aria-label="Enter Verification Code"/>
                           </div>
                         </div>

                         <div class="form-group">
                           <label for="cpatchaTextBox">Enter Captcha:</label>
                           <div class="input-group w-100">
                              <div class="col-md-12 col-lg-12 col-sm-12 col-xs-4 p-0 text-center w-100">
                                <p id="registrationCaptchaOne" style="color: #0e3463;user-select:none;color: blue;">${generatedCaptcha} </p>
                              </div>
                              <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 d-flex p-0">
                                <input type="text" name="verificationCaptcha" class="w-100 m-0" placeholder="Enter Captcha" id="cpatchaTextBox"  aria-label="Enter Cpatcha" />
                                <i class="fa fa-refresh"  onclick="changeRegistrationCaptcha()" aria-hidden="true"></i>
                             </div>
                         </div>
                         </div>
                         <div class="d-flex button_dvfm mt-3">
                            <button type="button" id="save" class="position-relative custom-btn  btn btn-default trcksbtn" data-bs-modal="modal" data-bs-target="#showDataModel"><span class="p-0">Submit</span></button>
                            <div class="reghp">
                               <a href="${pageContext.request.contextPath}/ReportProblem" class="position-relative custom-btn">Report Problem</a>
                            </div>
                         </div>
                       </div>
                       </form:form>
                     </div>

                   </div><!--end verification code-->
              </div>
             </div>
             <button class="qrcode-btn d-flex" onclick="openNav()"><!-- <i class="fa fa-qrcode"></i>  --><i><img src="images/qr-barcode.png" alt="QR code Image" style="
          width: 100%; max-width: 30px;"></i><span>Scan your Code</span></button>
           </div>
         <div class="site-wrap">
            <div class="intro-section custom-owl-carousel" id="home-section">
               <div class="container-fluid">
                  <div class="row">
                     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ml-auto img7 p-0">
                        <div class="owl-carousel slide-one-item-alt">
                           <div class="banner-content">
                              <img src="images/banner33.jpg" alt="ethics committee" class="img-fluid banner_img img-responsive">
                           </div>
                           <div class="banner-content">
                              <img src="images/banner1.jpg" alt="ethics committee" class="img-fluid banner_img img-responsive">
                           </div>
                           <div class="banner-content-img">
                              <img src="images/banner3.jpg" alt="ethics committee" class="img-fluid banner_img img-responsive">
                           </div>
                        </div>
                        <div class="owl-custom-direction" id="for_abt">
                           <a href="#" class="custom-prev">
                           <span class="fa fa-chevron-left "><span class="sr-only">Previous</span></span>
                           </a>
                           <a href="#" class="custom-next">
                           <span class="fa fa-chevron-right"><span class="sr-only">Next</span></span>
                           </a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- end banner-->



      <!-- latest notification-->
      <section class="latest-notfication" id="skiptomaincontent">
        <div class="row">
          <div class="col-md-12 col-lg-12 no-pad mar d-flex">
            <!-- <div class="dates" id="triangle-toplefts">
              <p id="demo">
                  <i class="fa fa-bell" aria-hidden="true"></i> Latest Notifications
              </p>
            </div> -->
            <marquee id="newss" behavior="scroll" direction="left" onmouseover="this.stop();" onmouseout="this.start();">
              <ul>
               <li>
                  <i class="fa fa-circle blinking"></i>
                  <a href="${pageContext.request.contextPath}/download/DESKTOP_APPLICATION_CONFIGURATION.pdf" target="_blank">Click here to check the guidelines to reconfigure new version of desktop app</a>
                </li>
                <li>
                  <i class="fa fa-circle blinking"></i>
                  <a href="${pageContext.request.contextPath}/download/XsdExcelVersionUpdatesDetails.txt" target="_blank">Click here to download the 1.5 version update details.</a>
                </li>
                <li>
                  <i class="fa fa-circle blinking"></i>Latest version of iVEDA Desktop app 1.4 released on 15th December 2023.
                </li>
                <li>
                  <i class="fa fa-circle blinking"></i>View the latest version 1.5 of Xsd's uploaded on 15th December 2023.
                </li>
                <li>
                  <i class="fa fa-circle blinking"></i>iVEDA Web Portal -Beta Version launched on 15th December 2023.
                </li>
                     <li>
                        <i class="fa fa-circle"></i>
                        <a href="${pageContext.request.contextPath}/WorkshopRegistration"
                                             class="text-secondap effect-7 ">
                           <b>Workshop Registration</b>
                        </a>
                     </li>
                     <li>
                        <i class="fa fa-circle"></i>
                        <a href="${pageContext.request.contextPath}/RegistrationOfficials"
                                             class="text-secondap effect-7 ">
                           <b>New Official registration</b>
                        </a>
                     </li>
              </ul>
            </marquee>
            <div id="marque_fa">
              <i class="fa fa-pause white st_cdsco" value="Stop Marquee" title="Pause" onclick="document.getElementById('newss').stop();"></i>
              <i class="fa fa-play white st_cdsco" value="Start Marquee" title="Play" onclick="document.getElementById('newss').start();"></i>
            </div>
          </div>
        </div>
   </section>
  
      <!-- end latest notification-->
   <!-- ===  portal Statistics ==== -->
         <div class="map">
           <div id="menuToggle" class="menuToggle menutogglestat" title="show menu">
             <span class="navClosedss">Statistics</span>
             <!-- <img alt="our centers" style="cursor:pointer" src="images/our-centers.png" />-->
           </div>
           <div class="map-img">
             <div class="boxx-inner map ">
               <h3 class="tittle1 text-center ">Statistics</h3>
               <div>
                 <section class="panel panel-featured-left panel-featured-primary mb-2">
                   <div class="panel-body">
                     <div class="widget-summary">
                       <div class="widget-summary-col widget-summary-col-icon">
                         <div class="summary-icon bg-secondary">
                           <i class="fa fa-user"></i>
                         </div>
                       </div>
                       <div class="widget-summary-col">
                         <div class="summary">
                           <h4 class="title">Registered Users</h4>
                           <div class="info">
                             <p>Manufacturers: <span>${manufacturer}</span>
                             </p>
                             <p>Merchant Exporters: <span>${exporters}</span>
                             </p>
                           </div>
                         </div>
                       </div>
                     </div>
                   </div>
                 </section>
                 <section class="panel panel-featured-left panel-featured-secondary">
                   <div class="panel-body">
                     <div class="widget-summary">
                       <div class="widget-summary-col widget-summary-col-icon">
                         <div class="summary-icon bg-secondary">
                           <i class="fa fa-upload"></i>
                         </div>
                       </div>
                       <div class="widget-summary-col">
                         <div class="summary">
                           <h4 class="title">Data uploaded by Exporters</h4>
                           <div class="info">
                             <p>Manufacturers: <span>${expDataManuf}</span>
                             </p>
                             <p>Merchant Exporters: <span>${expDataExp}</span>
                             </p>
                           </div>
                         </div>
                       </div>
                     </div>
                   </div>
                 </section>
               </div>
             </div>
             <!--boxx-inner-->
           </div>
           <!--  mapnew div close> -->
         </div>
         <!-- ==  statistics end == -->

         <!-- ====   alerts starts === -->
         <div class="container">
           <div class="row">
             <p>
               <button class="btn js-jumbo" id="btnFly">
                 <span class="navCloseds">Alerts</span>
               </button>
             </p>
             <div id="message1" class="jumbotron flyover flyover-centered">
               <button type="button" class="close jmbclose float-right fw-bold" aria-hidden="true">&times;</button>
                 <h3 class="text-center">Alerts</h3>
                 <div class="row">
                   <div class="col-sm-6 col-md-6">
                     <div class="alert-message alert-message-success">
                       <a href="${pageContext.request.contextPath}/download/PN 66_0.pdf" target="_blank">
                         <h4> DGFT Trade Notifications/Public Notices</h4>
                       </a>
                     </div>
                   </div>
                   <!-- <div class="col-sm-6 col-md-6">
                     <div class="alert-message alert-message-danger">
                       <a href="#">
                         <h4> Global FDA Alerts </h4>
                       </a>
                     </div>
                   </div> -->
                 <!--   <div class="col-sm-6 col-md-6">
                     <div class="alert-message alert-message-success">
                       <a href="#">
                         <h4> CDSCO Notifications/Alerts </h4>
                       </a>
                     </div>
                   </div> -->
                   <div class="col-sm-6 col-md-6">
                     <div class="alert-message alert-message-danger">
                       <a href="#" onclick="showFormats();">
                         <h4> iVEDA Alerts on Data Uploads & Formats</h4>
                       </a>
                     </div>
                   </div>
                 </div>
             </div>
           </div>
         </div>
         <!-- ====   alerts end === -->

      <!--about us section-->
      
         <section id="aboutus" >
         <div class="container">
            <div class="row">
               <div class="wedo-left col-md-9 col-lg-9 col-sm-12 col-xs-12">
                  <div class="section-title">
                     <h2 class="tittle">About <span>iVEDA</span>
                     </h2>
                  </div>
                  <div style="float: left;height: 600px;overflow-y: scroll;"> ${dynamicHomepage.aboutus} </div>
               </div>
               <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
               <div class="row">
                <!---Minister-banner--->
            <div class="minister-banner col-md-12 col-sm-12 col-xs-6 p-0">
                  <div class="row">
                     <div class="col-lg-12 col-md-12 col-sm-12 p-0">
                        <div class="card minister bg-white position-relative d-fle p-0">
                              <figure> <img class="w-100" src="images/PG_minister.jpg" alt="Shri Piyush Goyal, Minister for Commerce and Industry" /></figure>
                           <div class="card-body">
                              <h5 class="fw-bold text-center mt-2">Shri Piyush Goyal</h5>
                           <p class="mb-1">Minister for Commerce and Industry</p>
                           </div>
                        </div>
                     </div>
                  </div>
            </div>
            <!---end Minister-banner--->
             <div class="news  col-md-12  col-sm-12 col-xs-6 p-0">
                <div class="section-title">
                   <h3 class="tittle">Latest <span>News /Events</span>
                   </h3>
                </div>
                <div class="panel panel-default">
                   <div class="panel-heading"></div>
                   <div class="panel-body">
                      <div class="row">
                         <div class="col-xs-12 p-0">
                            <ul class="demo1">
                               <li class="news-item">
                                  <table  class="table w-100 p-2">
                                     <tr>
                                        <td>
                                           <div class="icon position-relative d-flex">
                                              <i class="fa fa-newspaper-o img-circle" aria-hidden="true"><span class="sr-only">Newspaper icon</span></i>
                                           </div>
                                        </td>
                                        <td>
                                           <p>
                                              <strong>iVEDA Web Portal</strong> -Beta Version launched and LIVE NOW FOR COMPANY REGISTRATION and DATA UPLOAD
                                           </p>
                                        </td>
                                     </tr>
                                  </table>
                               </li>
                               <li class="news-item">
                                  <table class="table w-100 p-2">
                                     <tr>
                                        <td>
                                           <div class="icon position-relative d-flex">
                                              <i class="fa fa-newspaper-o img-circle" aria-hidden="true"></i>
                                           </div>
                                        </td>
                                        <td>
                                           <p>View the latest version 1.5 of XSD's uploaded on 9th Sep 2020</p>
                                        </td>
                                     </tr>
                                  </table>
                               </li>
                               <li class="news-item">
                                  <table class="w-100 p-2">
                                     <tr>
                                        <td>
                                           <div class="icon position-relative d-flex">
                                              <i class="fa fa-newspaper-o img-circle" aria-hidden="true"></i>
                                           </div>
                                        </td>
                                        <td>
                                           <p>View the latest version 1.3 of Desktop App uploaded on 9th Sep 2020</p>
                                        </td>
                                     </tr>
                                  </table>
                               </li>
                            </ul>
                         </div>
                      </div>
                   </div>
                   <div class="panel-footer"></div>
                </div>
             </div><!--end news-->
             </div><!--end row-->
           </div>
            </div>
         </div>
      </section>
      
      <!--end about us section-->

      <!--Guidance to Industry-->
      <section class="guidelines" id="guidelines">
         <div class="container z-index position-relative">
            <div class="section-title section-title-center text-center">
               <h2 class="tittle">Process
               </h2>
            </div>
            <div class="row">
               <div class="col-md-3 col-sm-6 col-xs-12 col">
                    <div class="banner-box w-100 position-relative orange-box">
                      <div class="banner-box-inner w-100">
                        <div class="img position-relative"><img src="images/manufacturer-img.jpg" alt="manufacturer-img" class="img-responsive w-100">
                        <div class="box-title position-abosolute w-100 text-center d-flex"><h4 class="m-0">manufacturer</h4></div>
                      </div>
                       
                      </div>
                    </div>
                 </div>
             <div class="col-md-3 col-sm-6 col-xs-12 banner2 col">
                <div class="banner-box w-100 position-relative green-box">
                  <div class="banner-box-inner w-100">
                   <div class="img position-relative"><img src="images/export1.jpg" alt="manufacturer-img" class="img-responsive w-100">
                    <div class="box-title position-abosolute w-100 text-center d-flex"><h4 class="m-0">Exporter</h4></div>
                  </div>
                </div>
                </div>
            </div>

             <div class="col-md-3 col-sm-6 col-xs-12 banner3 col">
              <div class="banner-box w-100 position-relative gray-box">
                <div class="banner-box-inner">
                <div class="img position-relative"><img src="images/regulator.jpg" alt="manufacturer-img" class="img-responsive w-100">
                  <div class="box-title position-abosolute w-100 text-center d-flex"><h4 class="m-0">Regulator</h4></div>
              </div>
              </div>
            </div>
          </div>
             <div class="col-md-3 col-sm-6 col-xs-12 banner4 col">
                <div class="banner-box w-100 position-relative blue-box"> 
                  <div class="banner-box-inner w-100">
                  <div class="img position-relative"><img src="images/government.jpg" alt="manufacturer-img" class="img-responsive w-100">
                    <div class="box-title position-abosolute w-100 text-center d-flex"><h4 class="m-0">Government</h4></div>
                </div>
                </div>
             </div>
            </div>
            </div>
         </div>
      </section>
      <!--Guidance to Industry-->


      <section id="gallery" class="ptb-5 news">
    <div class="container">
        <div id="fancyTabWidget"  class="tabs t-tabs ">
           <ul class="nav nav-tabs fancyTabs" id="nav-tab" role="tablist" id="fancyTabsajax">
               <li role='list' class="tab fancyTab col-md-4 col-lg-4 col-sm-4 col-xs-12"><button class="w-100 nav-link active" id="galleryTab1-tab" data-bs-toggle="tab" data-bs-target="#galleryTab1" type="button" role="tab" aria-controls="galleryTab1" aria-selected="true">Workshop Conducted In Ahmedabad</button>
               </li>
               <li role='list' class="tab fancyTab col-md-4 col-lg-4 col-sm-4 col-xs-12"><button class="w-100 nav-link" id="galleryTab2-tab" data-bs-toggle="tab" data-bs-target="#galleryTab2" type="button" role="tab" aria-controls="galleryTab2" aria-selected="false">Workshop Conducted In Chandigarh</button>
               </li>
               <li role='list' class="tab fancyTab col-md-4 col-lg-4 col-sm-4 col-xs-12"><button class="w-100 nav-link" id="galleryTab3-tab" data-bs-toggle="tab" data-bs-target="#galleryTab3" type="button" role="tab" aria-controls="galleryTab3" aria-selected="false">Workshop Conducted In Hyderabad</button>
               </li>
           </ul><!--end tabs-->

            <div class="tab-content fancyTabContent" id="myTabContent">
               <div class="tab-pane fade active show" id="galleryTab1" role="tabpanel" aria-labelledby="galleryTab1-tab">
                  <div class="row m-0">
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Ahmedabad20200512/1.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Ahmedabad20200512/1.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Ahmedabad20200512/2.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Ahmedabad20200512/2.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Ahmedabad20200512/3.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Ahmedabad20200512/3.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Ahmedabad20200512/4.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Ahmedabad20200512/4.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Ahmedabad20200512/5.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Ahmedabad20200512/5.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                  </div>
               </div><!--galleryTab1-->
               <div class="tab-pane fade" id="galleryTab2" role="tabpanel" aria-labelledby="galleryTab2-tab">
                  <div class="row m-0">
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Chandigarh20200506/1.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Chandigarh20200506/1.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Chandigarh20200506/2.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Chandigarh20200506/2.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Chandigarh20200506/3.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Chandigarh20200506/3.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Chandigarh20200506/4.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Chandigarh20200506/4.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Chandigarh20200506/5.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Chandigarh20200506/5.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Chandigarh20200506/6.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Chandigarh20200506/6.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                  </div>
               </div><!--galleryTab2-->
               <div class="tab-pane fade" id="galleryTab3" role="tabpanel" aria-labelledby="galleryTab3-tab">
                  <div class="row m-0">
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Hyderabad20200505/1.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Hyderabad20200505/1.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Hyderabad20200505/2.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Hyderabad20200505/2.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Hyderabad20200505/3.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Hyderabad20200505/3.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Hyderabad20200505/4.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Hyderabad20200505/4.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Hyderabad20200505/5.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Hyderabad20200505/5.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                     <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb">
                        <a href="images/Eventgallery/Hyderabad20200505/6.jpg" class="fancybox" rel="ligthbox0">
                        <img src="images/Eventgallery/Hyderabad20200505/6.jpg" class="zoom img-fluid" alt="Gallery Images">
                        </a>
                     </div>
                  </div>
               </div><!--galleryTab1-->
            </div><!--end tab content-->
            
            <div class="viewmore text-center"><a href="/IVEDA/gallery" class="position-relative custom-btn"><span class="p-0">View All</span> <i class="fa fa-eye"></i></a></div>
        </div><!--end fancyTabWidget-->
    </div><!--end container-->
  </section><!--end gallery section-->

<div id="fancyTabWidget" class="tabs t-tabs ">
              <ul class="nav nav-tabs fancyTabs" role="tablist" id="fancyTabsajax">
              </ul>
                <div id="myTabContent" class="tab-content fancyTabContent" aria-live="polite">
                </div>
            <div class="viewmore text-center"><a href="${pageContext.request.contextPath}/gallery" class="position-relative custom-btn"><span class="p-0">View All</span> <i class="fa fa-eye"></i></a></div>
         </div>
         </div> 


      <!--Logo slider section-->
      <section class="logo-section">
       <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-12 col-xl-12 p-0">
           <!--  <div class="section-title">
              <h2>Important <span>Links</span></h2>
            </div> -->
            <div id="owl-demo-imp" class="owl-carousel owl-theme">
              <div class="item">
                <div class="pic">
                  <a href="https://commerce.gov.in/" target="_blank" onclick="externallinkFunction()">
                    <img src="images/department-commerce.png" alt="department-commerce">
                  </a>
                </div>
              </div>
              <div class="item">
                <div class="pic">
                  <a href="https://pharmexcil.com/" target="_blank" onclick="externallinkFunction()">
                    <img src="images/phrm.jpg" alt="pharmexcil Logo">
                  </a>
                </div>
              </div>
              <div class="item">
                <div class="pic">
                  <a href="https://cdsco.gov.in/opencms/opencms/en/Home/" target="_blank"onclick="externallinkFunction()">
                    <img src="images/cdsco.jpg" alt="Central Drugs Standard Control Organisation(CDSCO) Logo" />
                  </a>
                </div>
              </div>
              <div class="item">
                <div class="pic">
                  <a href="https://dgft.gov.in/" target="_blank" onclick="externallinkFunction()">
                    <img src="images/dgft.jpg" alt="Directorate General of Foreign Trade" />
                  </a>
                </div>
              </div>
              <div class="item">
                <div class="pic">
                  <a href="https://csc.gov.in/digitalIndia" target="_blank" onclick="externallinkFunction()">
                    <img src="images/digital_india.png" alt="Digital India Logo">
                  </a>
                </div>
              </div>
              <div class="item">
                <div class="pic">
                  <a href="https://www.g20.org/en/" target="_blank" onclick="externallinkFunction()">
                    <img src="images/G20_India_Logo.png" alt="G20 Logo"/>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

   </section><!--end Logo slider section-->

   <!-- Verification code Guidelines model-->
         <div id="guidelines_model" class="modal fade" role="dialog" tabindex="-1">
            <div class="modal-dialog-centered modal-dialog-inner h-100">
               <div class="modal-dialog ">
               <!-- Modal content-->
               <div class="modal-content">
                  <div class="modal-header d-flex position-relative">  
                    <h3 class="modal-title fw-bold">Read Guidelines for Verification Code </h3>
                      <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <i class="fa fa-times-circle" aria-hidden="true">
                          <span class="sr-only">Close</span>
                      </i>
                       
                     </button>
                  </div>
                  <div class="modal-body">
                    
                    <h4 class="fw-bold">GS1 Data Secondary Code</h4>
                    <p>A GS1 Data Matrix can contain the following attributes:</p>
                      <ul>
                          <li> Manufacturer Product Code (GTIN) - 14 digits using application identifier(01).</li>
                          <li>Expiry Date - 6 digits (YYMMDD) using application identifier (17).</li>
                          <li>Batch / lot Number - up to 20 alpha-numeric characters usingapplication
                          identifier(10).</li>
                          <li>Unique Serial Number (randomized) - up to 20 alphanumeric characters using
                          application</li>
                          <li> Identifier (21).</li>
                      </ul>
                    <h4 class="fw-bold">GS1 Tertiary Code</h4>
                    <p>SCCC can contain the following attributes:</p>
                      <ul>
                        <li> SSCC is the 18 digit numeric serial no. of the Shipper/Carton/Tertiary level packaging. Using application identifier (00).</li>
                        <li>SSCC comprises an extension digit, a GS1 company prefix, a serial reference, and a check digit</li>
                        <li>iVeda Tertiary Code</li>
                      </ul>
                    <strong>iVeda Tertiary code contain 14 digit code. Example: 1AS2012205678A</strong>
                    <ul>
                      <li> <strong>1</strong>This digit signifies the pack level.</li>
                      <li> <strong>AS2</strong> These 3 digits signifies the manufacturer/exporter unique code.</li>
                      <li> <strong>0</strong> This 0 digit signifies it is homogeneous (0) or heterogeneous(1).</li>
                      <li> <strong>1220</strong> These 4 digit signifies date (mmyy).</li>
                      <li> <strong>5678</strong> These 4 digit signifies running serial number.</li>
                      <li><strong>A</strong> This digit signifies the checked digit.</li>
                      <li><strong>4</strong> iVeda Secondary Code</li>
                    </ul>
                    <strong>iVeda Secondary Code contain 16 digit code Example: 1AS201204205678A</strong>
                    <ul>
                      <li><strong>1</strong> This digit signifies the pack level.</li>
                      <li><strong>AS2</strong> These 3 digits signifies the manufacturer/exporter unique code.</li>
                      <li><strong> 0</strong> This 1 digit signifies it is homogeneous (0) or heterogeneous(1).</li>
                      <li><strong>120420</strong> These 6 digit signifies date (ddmmyy).</li>
                      <li><strong>5678</strong> These 4 digit signifies running serial number.</li>
                      <li><strong>C </strong> This digit signifies the checked digit</li>
                    </ul>
                  </div>
                  <div class="modal-footer">
                     <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  </div>
               </div>
            </div>
            </div>
         </div>
      <!--pop up code end-->

      <!-- pop up code-->
      <section>
         <!-- Modal -->
         <div id="consolPopup" class="modal fade" role="dialog" tabindex="-1">
            <div class="modal-dialog-centered modal-dialog-inner h-100">
               <div class="modal-dialog ">
               <!-- Modal content-->
               <div class="modal-content">
                  <div class="modal-header d-flex position-relative">  
                    <h4 class="modal-title fw-bold">Welcome to iVEDA Portal</h4>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                      <i class="fa fa-times-circle" aria-hidden="true">
                        <span class="sr-only">Close</span>
                      </i>
                     </button>
                  </div>
                  <div class="modal-body">
                     <h4 class="extTitle">Exporter's/Official's Registration</h4>
                     <div class="regt">
                        <a href="${pageContext.request.contextPath}/rcmcRegistration" class="custom-btn position-relative"> Register</a>
                        <a target="blank" href="${pageContext.request.contextPath}/download/Manuals_iveda/User_Manual_for_Registration_v1.0.pdf" class="custom-btn position-relative">
                          <!-- <a target="blank" href="${pageContext.request.contextPath}/download/Manuals_iveda/Registration_User_Manual_v1.0.pdf" class="custom-btn position-relative"></a> -->
                           Registration Guidelines
                        </a>
                     </div>
                  </div>
                  <div class="modal-footer">
                     <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  </div>
               </div>
            </div>
            </div>
         </div>
      </section>
      <!--pop up code end-->
      
      
      <!--Begin: modal -->
    <!-- Modal -->
        <div id="showDataModel" class="showDataModel modal" role="dialog" tabindex="-1">
      <div class="modal-dialog modal-lg modal-dialog-centered">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header d-flex position-relative">
            <button type="button" class="close" data-bs-dismiss="modal" aria-label="modal Close button">
              <span><i class="fa fa-times-circle" aria-hidden="true"></i></span>
            </button>

            

          </div>
            <input type="hidden" name="docID" id="docID" aria-label="Doc ID"/>
            <input type="hidden" name="typeID" id="typeID" aria-label="Type Id"/>
            
          <div class="modal-body" id="showData">
            

          </div>

          <div class="modal-footer">
            <button type="button" class="btn_default" data-bs-dismiss="modal">Close</button>
          </div>
        </div>

      </div>
    </div>

      <script type="text/javascript">
      function changeCaptcha() {

         $.ajax({
            type : "GET",
            url : "getCaptcha",
            success : function(data) {
               document.getElementById("loginCaptcha").innerHTML = data;
            }

         });

      }

      $(document).ready(function() {

         let registrationSuccessful = '${registrationSuccessful}';
         if (registrationSuccessful == 'true') {
            ok_message("${registrationStatus}")
         }

         let exception = '${exception}';
         
         if (exception === 'true') {
        	    //alert("Before Error POPUP"); 
        	    error_message_login('${error}');
        	   // alert('${error}');
        	    //window.location.href = "http://localhost:8080/IVEDA/login";          
        	}


         if('${officialRegStatus}'=='1'){
            ok_message("Official Registration Successull , A email verification link is sent to your Registered Mail Id");
         }
         
      });
   </script>


<!-- Reload page after invalid credentials -->
<script>    
function error_message_login(msg)
{
 	swal({
		title: msg,	
		type:"error",
		confirmButtonColor: "#237DA7",
		timer: 10000
		//showConfirmButton: false
		});
 	$('.confirm').click(function(){
 		//alert("INSIDE FUN swal2");
 		window.location.href = "http://localhost:8080/IVEDA/login";
 		//window.location.href = "https://iveda-india.in/IVEDA/login";
  });
}
</script>



   <script>
      $('#save').click(function() {
        
        
       // alert("in save");
        
         var searchInput = $("#searchString").val();
          var reg=/^[a-zA-Z0-9().\/,\s\-]+$/;
          if(!reg.test(searchInput)){
              alert("Please enter a valid data");
              $("#searchString").val("");
              return false;
            } 
          
            var un = window.btoa(searchInput);
      //alert("EncodedSearchString | "+ un);
      var un1 = reverseString(un);
      //alert("ReversedSearchString | "+ un1);

      searchInput = un1;
      //alert("PassedSearchString | "+searchInput);
      /* $('#searchInput').val(); */
         
         let captcha=document.getElementById("registrationCaptchaOne").innerHTML;
         //alert('captcha: '+captcha);         
         let enteredCaptcha=$('#cpatchaTextBox').val();
         //alert('enteredCaptcha: '+enteredCaptcha);
         if(enteredCaptcha=='' || captcha!=enteredCaptcha){
            alert('Please enter valid captcha');
            return false;
         }

        $.ajax({
            type : "GET",
            data : {
               searchString : searchInput
            },
            url : "PerformSolrSearch",
            success : function(response) {
               
              
              //alert(searchInput + response);
              
            
            
               $('#showData').html(response);

               $('#showDataModel').modal('show')
               closeNav();
               
                $('#searchString').val('');
               
               
               console.log(response);
               $("#response").html(response);
            }
         });

         
        
/*         
$('#save').click(function() {
var searchInput=$("#searchString").val();
//alert(searchInput);
      $.ajax({
      type:"GET",
      data:{searchString :searchInput},
      url :"PerformSolrSearch",
      success: function(response){
        console.log(response);
        $("#response").html(response);
        
      }
    });
    
}); */

      });
   </script>
   
   <script type="text/javascript">
   function closeNavAccessible() {
       document.getElementById("mySidepanel").style.width = "0";
     }
   </script>
   
    <script>
    /*$(document).ready(function() {
      $.ajax({
         type : 'GET',
         url :'getgalleryimage',
         data: {limit: '3'},
         success : function(response) {                     
                        console.log("response=="+response);
                         var imagtag;
                        var gallerypath=[];
                        var finalgallerypath=[];
                        var elements=[];
                        var galleryName=[];
                        if(response!=null){
                           var gallerymap=new Map();
                        
                           gallerymap=response;
                           console.log("response=="+gallerymap);
                           var gallerykey = Object.keys(gallerymap);
                           console.log("gallerykey=="+gallerykey);
                           for (var i = 0; i < gallerykey.length; i++) {
                              gallerypath = gallerymap[gallerykey[i]];
                        
                              finalgallerypath.push(gallerypath[0]);
                              galleryName.push(gallerypath[1]);

                           }  console.log("gallerypath==="+gallerypath[0]);
                         for (var k = 0; k < galleryName.length; k++) {
                              if(k==0){                        $("#fancyTabsajax").append("<li role='list' class='tab fancyTab active col-md-4 col-lg-4 col-sm-4 col-xs-12'><div class='arrow-down'><div class='arrow-down-inner'></div></div><a role='option' id=tab"+k+" href=#"+gallerykey[k]+" role='tab' aria-controls="+gallerykey[k]+" aria-selected='true' data-bs-toggle='tab' tabindex='0'><span class=''>"+galleryName[k]+"</span></a><div class='whiteBlock'></div></li>");  
      }
                              else{ $("#fancyTabsajax").append("<li role='list' class='tab fancyTab col-md-4 col-lg-4 col-sm-4 col-xs-12'><div class='arrow-down'><div class='arrow-down-inner'></div></div><a role='option' id=tab"+k+" href=#"+gallerykey[k]+" role='tab' aria-controls="+gallerykey[k]+" aria-selected='true' data-bs-toggle='tab' tabindex='0'><span class=''>"+galleryName[k]+"</span></a><div class='whiteBlock'></div></li>");   
                                  }}
                           
                           
                           for (var l = 0; l < finalgallerypath.length; l++) {
                              elements = finalgallerypath[l].split("@##");
                              
                              if(l==0){
                              $("#myTabContent").append("<div class='tab-pane  fade active in' id="+gallerykey[l]+" role='tabpanel' aria-labelledby=tab"+l+" aria-hidden='false' tabindex='0'>");
                              }
         else{$("#myTabContent").append("<div class='tab-pane  fade' id="+gallerykey[l]+" role='tabpanel' aria-labelledby=tab"+l+" aria-hidden='true' tabindex='0'>");
      }  $("#"+gallerykey[l]).append("<div class='row m-0' id="+gallerykey[l]+"00>");
      elements.pop();
                              for (var m = 0; m < elements.length; m++) {
                                 // step one : converting comma separate String to array of String
                        var y= "<div>"+elements[m]+"</div>";
                        var firstimg = $(y).find("img:first").attr("src");
                              //var x = document.getElementsByClassName("img-fluid").src;
      $("#"+gallerykey[l]+"00").append("<div class='col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12 thumb'><a href="+firstimg+" class='fancybox' rel='ligthbox"+l+"'>"+elements[m]+"</a></div>");
                           

                           }
                           $("#myTabContent").append("</div></div>");
                           
                           }
       
                        
                           }
                        $(".fancybox").fancybox();
               
                            
         } 
         
      });
      });*/
  
//show  Gallary images with adding active class
$('.nav-tabs').on('click', 'li', function() {
    $('.nav-tabs li.active').removeClass('active');
    $(this).addClass('active');
});
//show  Gallary images
 $(".nav-tabs li a").click(function () {
      $(".tab-pane").hide();
      $($(this).closest("ul").attr("href")).show();
  }); 


</script>
 
   <script type="text/javascript">
    //logo onlcick alert message
  function externallinkFunction() {
  alert("You are being redirected to an external website. Please note that IVEDA is not responsible for external websites content & privacy policies.");
  }
    
  document.getElementById("registrationCaptchaOne").textContent = "${generatedCaptcha}";
     function changeRegistrationCaptcha(){
         $.ajax({
            type:"GET",
            url:"getCaptcha",
            success:function(data){
               document.getElementById("registrationCaptchaOne").textContent = data;
               
            }
         
         });
      } 

   

      function showModal(event) {
         //alert("in show modal");
         $(event).modal({
            backdrop : 'static',
            keyboard : false,
            show : true

         });
      } 

    
 
      </script>
      
        <script>
    function reverseString(str) {
      //alert ('Hello');
      var newString = "";
      for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
      }
      return newString;
    }
  </script>

<!-- Google tag (gtag.js) 
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
 // window.dataLayer = window.dataLayer || [];
 // function gtag(){dataLayer.push(arguments);}
 // gtag('js', new Date());
 // gtag('config', 'G-RRHHYLSBGG');
</script> -->

</body> --%>
</html>