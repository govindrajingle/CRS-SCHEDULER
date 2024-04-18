<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html  lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1">
      <meta name="description" content="Integrated Validation of Export of Drugs and its Authentication">   
      <link rel=" icon" href="images/favicon-icon.png" rel="icon" type="image/jpg">  
      <title>IVEDA Homepage</title>
      <link rel="stylesheet" href="css/homepage/bootstrap.css" >
      <link rel="stylesheet" href="css/homepage/bootstrap-datetimepicker.min.css" />
      <link rel="stylesheet" href="css/homepage/common_style.css">
      <link rel="stylesheet" href="css/homepage/homepage.css">
      <link rel="stylesheet" href="css/homepage/stylesheet.css">
      <link rel="stylesheet" href="css/homepage/owl.carousel.min.css">
      <link rel="stylesheet" href="css/homepage/owl.theme.default.min.css">
      <link rel="stylesheet" href="css/homepage/font-awesome.min.css">
      <link rel="stylesheet" href="css/homepage/aos.css">
      <link rel="stylesheet" href="css/homepage/animate.css">
      <link rel="stylesheet" href="css/dashboard/sweetalert.css">
      <link rel="stylesheet" href="js/validation/bootstrapValidator.css" rel="stylesheet">
      <link rel="stylesheet" href="css/dataTable/dataTables.bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/dataTable/responsive.bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/homepage/all.min.css">                                                           
       <script src="js/homepage/jquery-3.7.0.min.js"></script>
      <script src="js/homepage/bootstrap.bundle.min.js"></script>
      <script type="text/javascript" src="js/dataTable/jquery.dataTables.min.js"></script>  
      <script type="text/javascript" src="js/dataTable/dataTables.bootstrap.min.js"></script>
      <script type="text/javascript" src="js/dataTable/dataTables.responsive.min.js"></script>
      <script type="text/javascript" src="js/dataTable/responsive.bootstrap.min.js "></script>
      
      <script src="js/homepage/owl.carousel.min.js"></script>
      <script src="js/homepage/aos.js"></script>
      <script src="js/homepage/homepage.js"></script>               
      <script src="js/homepage/wow.min.js"></script>
      <link rel="stylesheet" href="css/homepage/jquery.fancybox.css" media="screen">
      
      <script src="js/homepage/jquery.fancybox.min.js"></script>
      <script src="js/homepage/jquery.bootstrap.newsbox.min.js" type="text/javascript"></script>
      <script src="js/homepage/moment.min.js"></script>
      <script src="js/homepage/bootstrap-datetimepicker.min.js"></script>
      <script src="js/homepage/bootstrapValidator.js"></script>     
      <script src="js/homepage/v4-shims.js"></script>
      <!-- Disable password storage-->
	<style>		
	#txtp {
  		-webkit-text-security: disc;
	}
	</style>
   </head>
   <body onload=changeCaptcha()>
      <header id="header" class="header">
         <!--TopHeader-->
         <div class="top-header">
            <div class="container-fluid">
                    <div class="row d-flex">
                        <div class="col-lg-4 col-md-4 col-sm-3 col-xs-5 p-0 top-logos">
                           <ul class="d-flex topbar_menu">
                             <li class="menu-item position-relative"><a href="#skiptomaincontent">Skip to main content</a></li>
                             <!-- <li class="menu-item position-relative"><a href="">Sitemap</a></li> -->
                             <li class="menu-item position-relative"><a href="${pageContext.request.contextPath}/screenreader">Screen Reader</a></li>
                           </ul>
                        </div>

                        <div class="col-lg-8 col-md-8 col-sm-9 col-xs-7 p-0 menu-top">
                          <ul class="d-flex digi_logos">
                              <li>
                                 <a href="https://www.digitalindia.gov.in/"  onclick="externallinkFunction()" target="_blank"><img src="images/digital-india.png" alt="Digital India Logo" class="w-100"></a>
                              </li>
                                 <li><a href="https://www.g20.org/en/"  onclick="externallinkFunction()" target="_blank"><img src="images/g20-logo1.png" alt="G20 logo" class="w-100"></a></li>

                                 <li>
                                    <div id="mySidepanel" class="sidepanel">
                                      <a href="javascript:void(0)" class="closebtn" onclick="closeNavAccessible()">&times;</a>
                                       <ul>
                                          <li class="header_toggle position-relative">
                                             <h5 class="text-center fw-bold">Color Contrast</h5>
                                             <input type="checkbox" class="checkbox" id="checkbox">
                                             <label for="checkbox" class="checkbox-label">
                                              <i class="fas fa-moon"><span class="sr-only">Dark theme mode</span>
                                              </i>
                                              <i class="fas fa-sun"><span class="sr-only">Light theme mode</span>
                                              </i>
                                              <span class="ball"></span> 
                                            </label>
                                          </li>
                                          <li class="font-increse position-relative">
                                             <h5 class="text-center fw-bold">Text Size</h5>
                                              <ul>
                                                <li>
                                                   <a tabindex="3" onclick="set_font_size('increase')" href="javascript:void(0);">
                                                      <span class="increase"> <i class="fa fa-search-plus"></i>Increase Font </span></a>                    
                                                </li>
                                                <li>
                                                   <a href="javascript:void(0);" onclick="set_font_size()">
                                                      <span class="reset"> <i class="fas fa-undo"></i> Reset </span></a>                    
                                                </li>
                                                <li>
                                                   <a href="javascript:void(0);" onclick="set_font_size('decrease')">
                                                      <span class="decrease"> <i class="fa fa-search-plus"></i> Decrease Font</span></a>                    
                                                </li>
                                             </ul>
                                          </li>
                                       </ul>
                                    </div>
                                    <button class="openbtn" onclick="openNavToggle()" aria-label="Accessibility options"><i class="fab fa-accessible-icon" title="Accessibility options">
                                     <span class="sr-only">Accessibility options</span>
                                     </i>
                                    </button>
                                    </li>

                                 </ul>      
                    </div>
                </div>
            </div>
         </div><!--End topHeader-->

         <!--MainHeader-->
         <div class="main-header">
            <div class="container-fluid">
               <nav class="row d-flex">
                  <div class="col-lg-5 col-md-8 col-sm-12 d-flex main-logo">
                    <div class="emblem-logo">
                     <img src="images/emblem-logo.png" alt="emblem Logo">
                     <div class="logo-img-mob"><img src="images/logo1.png" alt="Integrated Validation of Export of Drugs and its Authentication"></div>
                    </div>
                     <a class="logo-col d-flex" href="/IVEDA" aria-label="Integrated Validation of Export of Drugs and its Authentication , Ministry of Commerce & Industry, Government of India">
                        <div class="logo-img"><img src="images/logo1.png" alt="Integrated Validation of Export of Drugs and its Authentication"></div>
                        <ul>
                           <li class="logo-name">Integrated Validation of Export of <br/>Drugs and its Authentication</li>
                           <li class="mci">Ministry of Commerce & Industry</li>
                           <li class="goi">Government of India</li>
                        </ul>
                     </a>
                  </div>
                  <div class="navigation col-lg-7 col-md-4 col-sm-4 main-nav d-flex position-relative">
                     <input type="radio" name="slider" id="menu-btn" aria-label="Menu Button"/>
                     <input type="radio" name="slider" id="close-btn" aria-label="Close Button" />
                     <ul class="nav-links">
                        <label for="close-btn" class="btn close-btn" aria-label="Close Icon"><i class="fa fa-times text-white"> <span class="sr-only"></span></i></label>
                        <li class="current-menu-item"><a href="/IVEDA">Home</a></li>
                        <li><a href="#aboutus">About</a></li>
                        <li class="dropdown_menu">
                           <a href="#" class="desktop-item">Information <span class="caret"></span></a>
                           <input type="checkbox" id="showDropmenu1">
                           <label for="showDropmenu1" class="mobile-item">Information <span class="caret"></span></label>
                           <ul class="drop-menu">
                              <li><a href="${pageContext.request.contextPath}/download/PN 66_0.pdf" target="_blank">DGFT Notifications/Public Notices</a></li>
                             <!--  <li><a href="#" target="_blank">Pharmexcil Circulars on Bar Cording</a></li>
                              <li><a href="#" target="_blank">Presentations</a></li> -->
                           </ul>
                        </li>

                        <li class="dropdown_menu">
                           <a href="#guidelines" class="desktop-item">Guidelines <span class="caret"></span></a>
                           <input type="checkbox" id="showDropmenu2">
                           <label for="showDropmenu2" class="mobile-item">Guidelines <span class="caret"></span></label>
                           <ul class="drop-menu">
                             <li><a href="${pageContext.request.contextPath}/download/Manuals_iveda/User_Manual_for_Registration_v1.0.pdf" target="_blank">Registration</a></li>
                            <li><a href="${pageContext.request.contextPath}/download/Manuals_iveda/User Manual_for_iVEDA_v1.1 .pdf" target="_blank">User Manual</a></li>
                            <li><a href="${pageContext.request.contextPath}/download/Manuals_iveda/iVEDA User Manual for Update Consignment Details.pdf" target="_blank">User Manual to Update Consignment Details</a></li>
                            <li><a href="${pageContext.request.contextPath}/download/Manuals_iveda/User_Manual_for_Packaging_Levels_v1.0.pdf" target="_blank">Packaging Levels </a></li>
                            <li><a href="${pageContext.request.contextPath}/download/Manuals_iveda/User_Manual_for_Excel_to_XML_v1.0.pdf" target="_blank">Know-how of file conversions from XML to Excel and XML</a></li>
                            <li><a onclick="showFormats();" href="#">Schema Files</a></li>
                            <li><a href="${pageContext.request.contextPath}/download/Manuals_iveda/User_Manual_for_Data_Aggregation_v1.0.pdf" target="_blank">Data Aggregation and Upload</a></li>
                            <li><a href="${pageContext.request.contextPath}/videotutorial">Video Tutorials</a></li>
                            <li><a href="${pageContext.request.contextPath}/faq">FAQs</a></li>
                            <li><a href="${pageContext.request.contextPath}/ReportProblem">Reach out iVEDA Team</a></li>
                           </ul>
                        </li>
                        <li><a href="#contactus">Contact Us</a></li>
                        <li><a href="#" class="login-btn loginbtn"  data-bs-toggle="modal" data-bs-target="#sem-login">Login</a></li>
                          <!-- <li class="menu-item-mob"><a href="">Sitemap</a></li> -->
                          <li class="menu-item-mob"><a href="${pageContext.request.contextPath}/screenreader">Screen Reader</a></li>
                     </ul>
                    <div class="mob-toggle d-flex">
                        <a href="#" class="login-btn custom-btn loginbtn position-relative" data-bs-toggle="modal" data-bs-target="#sem-login" >Login</a>
                     <label for="menu-btn" class="btn menu-btn"><i class="fas fa-bars" aria-hidden="true"><span class="sr-only">Menu Toogle</span></i></label>
                    </div>

                  </div>
               </nav>
            </div>
         </div>
      </header>
      <!--  ==   login modal  ====  -->
      <!--  modal login -->
      <!-- The Modal -->
      <div class="modal modallg fade seminor-login-modal" data-backdrop="static" id="sem-login" data-easein="slideDownBigIn">
         <div class="modal-dialog modal-dialog-centered modal_wd d-flex h-100">
            <div class="modal-content">
               <div class="model-header d-flex position-relative"> 
                  <h4 class="modal-title fw-bold">LOGIN</h4>
                  <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                      <i class="fa fa-times-circle" aria-hidden="true">
                        <span class="sr-only">Close</span>
                      </i>
                     </button>
               </div>
               <!-- Modal body -->
               <div class="modal-body seminor-login-modal-body">
                  <form:form action="${pageContext.request.contextPath}/login" class="seminor-login-form" 
                     method="post" modelAttribute="loginBean" id="frm2" autocomplete="off" name = "frm2">
            
                                 <form:hidden path="token" id="token" />
                     <div class="form-group">
                        <label for="username" class="fw-bold">Email Address</label>
                <form:input path="username" required="true"  class="form-control" placeholder="Email Address" id="username"/>
                     </div>
                     <div class="form-group">
                        <label for="password" class="fw-bold">Password</label>
                         <form:input path="password" required="true" class="form-control" placeholder="Password" id="txtp"  autocomplete="off"/>                          
                     </div>
                     <div class="row">
                        <div class="form-group p-0 mb-0">
                            <label for="captcha" class="w-100 fw-bold">Enter Captcha</label>
                             <div class="form-group col-md-12 col-lg-12 col-sm-12 col-xs-4 p-0 text-center captccha w-100" id="loginCaptcha" style="user-select:none;color: blue;">
                              ${generatedCaptcha}
                              </div>
                              <div class="form-group col-md-12 col-lg-12 col-sm-12 col-xs-12 d-flex p-0 ">
                              <form:input path="captcha" required="true" placeholder="Enter Captcha "  oninvalid="this.setCustomValidity('Please Enter captcha')" class="form-control" id="captcha"/>
                            <div class="refresh" onclick="changeCaptcha()"> 
                              <i class="fa fa-refresh" aria-hidden="true"></i>
                           </div>
                        </div>
                        </div>
                       
                     </div>
                     <div class="form-group btn-check-log">        
                         <form:button class="btn-check-login">Login</form:button>
                        <input type="submit" class=" custom-btn position-relative w-100 d-block"  onclick="loginSubmit()" value="Login">
                     </div>
                     <div class="forgot-pass-fau text-center">
                        <a href="#" class="semreset" data-bs-toggle="modal" data-bs-target="#sem-resetpassword">Forgot Password?</a>
                     </div>
                     <div class="regh text-center p-0">                                                
                        <a href="${pageContext.request.contextPath}/rcmcRegistration" >Register Here</a>
                     </div>
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      
      <!--  reset password modal  -->
      <!--  modal login -->
      <!-- The Modal -->
      <div class="modal fade seminor-login-modal" data-backdrop="static" id="sem-resetpassword" data-easein="slideDownBigIn">
         <div class="modal-dialog modal-dialog-centered modal_wd d-flex h-100">
            <div class="modal-content">
               <div class="model-header d-flex position-relative"> 
                  <h4 class="modal-title fw-bold">Forgot Password</h4>
                  <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                      <i class="fa fa-times-circle" aria-hidden="true">
                        <span class="sr-only">Close</span>
                      </i>
                     </button>
               </div>
               <!-- Modal body -->
               <div class="modal-body seminor-login-modal-body">
                  <form:form action="${pageContext.request.contextPath}/forgotPassword" class="seminor-login-form" method="post" modelAttribute="loginBean" id="frm3" name = "frm3">
                     <div class="form-group">
                        <label for="fusername" class="fw-bold">Enter Username</label>
                        <form:input path="fusername" class="form-control" placeholder="Enter Username" id="fusername" name="fusername"  autocomplete="off"/>
                     </div>
                     <div class="form-group btn-check-log w-100">        
                         <form:button class="btn-check-login">Login</form:button>
                        <input type="button" class="custom-btn position-relative w-100"  onclick="forgotPassSubmit()" value="Submit" aria-label="Submit">
                     </div>
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      <!--  reset password modal closed -->
      <!--  schema files modal -->
      <div id="formatsModal" class="modal" role="dialog" data-backdrop="false">
         <div class="modal-dialog modal-dialog-centered modal_wd">
            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
                  <h4 class="newuse">Formats</h4>
                   <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                      <i class="fa fa-times-circle" aria-hidden="true">
                        <span class="sr-only">Close</span>
                      </i>
                     </button>
               </div>
               <div class="modal-body schdiv">
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/PROSchema.xsd" target="_blank">Product Schema XSD v(${schemaVersion})</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/PROSchema.xml" target="_blank">Product Schema XML v(${schemaVersion})</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/Product.xlsx" target="_blank">Product Excel v(${schemaVersion})</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/IVEDAExporterPackingDtl.xsd" target="_blank">Consignment/Tertiary Schema XSD v(${schemaVersion})</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/IVEDAExporterPackingDtl.xml" target="_blank">Consignment/Tertiary Schema XML v(${schemaVersion})</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/ExporterTertiaryExcel.xlsx" target="_blank">Consignment/Tertiary Excel v(${schemaVersion})</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/RegionList(V1).xlsx" target="_blank">Region List Excel (New)</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/DosageFormList.xlsx" target="_blank">Dosage Form List Excel</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/StorageConditionList.xlsx" target="_blank">Storage Condition List Excel</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/ScheduleDrugList.xlsx" target="_blank">Schedule Drug List Excel</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/Manuals_iveda/User_Manual_for_Schema_Files_v2.0.pdf">Schema Files User Manual version 2.0</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/User_Manual_for_ExceltoXMLValidationv1.0 (2).pdf">Excel to XML User Manual ${schemaVersion}</a></p>
                  <p><i class="fa fa-file-text"></i><a class="" href="${pageContext.request.contextPath}/download/IVEDA_ErrorCode.xlsx">Error code document list</a></p>
               </div>
            </div>
         </div>
      </div>
      <div class="clearfix"></div>
      <!--  schema files modal close -->
      <script type="text/javascript" src="js/homepage/sha256.js"></script>
      <script src="js/dashboard/alert_new.js"></script>
      <script src="js/dashboard/alert.js"></script>
      <script src="js/dashboard/sweetalert.min.js"></script>
      <script type="text/javascript">

   

     
      function loginSubmit() {   
            let username=$('#username').val();
            let passwordd=$('#txtp').val();
           // alert(passwordd);
            let captcha=$('#captcha').val();
            let token=$('#token').val();
            
            
            if(username==''){
                //alert('Please enter username');
                return false;
            }
            if(passwordd==''){
                //alert('Please enter password');
                return false;
            }
            if(captcha==''){
                //alert('Please enter captcha');
                return false;
            }

            //added by harshita
          //  var randomNumber=Math.ceil(Math.random() * 10000);

            //alert("token" + token);
         
         //var chk=base.split(' ### ').reverse().join(' ### ')
      //  var base = window.btoa(username+' ### '+passwordd+' ### '+Math.ceil(Math.random() * 10000));   
        var base = window.btoa(username+' ### '+passwordd+' ### '+token);    
        //alert("base:::" + passwordd);
          // alert("base:::" + base);
         //base.reverse();
         var reverseval=reverseString(base);
      
      //alert("reverseval:::"+reverseval);

          var base2 = window.btoa(reverseval);
         
      // alert ("base2222:::" + base2);
         
         //alert ("base.reverse()" + reverseString(base + ""));
      // var base2 = window.btoa(base);
         //var base3 = window.btoa(base2);
         //var base4 = window.btoa(base3);
	
         //$('#password').val(base2);
	
		$('#txtp').val(base2);

           //var un = window.btoa(username); 
           // alert("un"+ un)
            //var un1 =reverseString(un);
            //alert("un1"+ un1)
            // var un2  = window.btoa(un1);
           // alert("un2"+ un2)
            // $('#username').val(un2);
             
            $('#frm2').submit();
         }
         
                                   
                                    
                
      function forgotPassSubmit() { 
    	  
          let fusername=$('#fusername').val();  
        //  alert("hello"+ fusername);
                                 
          if(fusername==null || fusername==''){ 
              alert('please enter username');   
              return false;   
          } 



          //var base = window.btoa(fusername);
        //  alert("helo"+ base)
         // var reverseval=reverseString(base)
        //  alert("helo"+ reverseval)
         // var base2 = window.btoa(reverseval);
        //  alert("helo"+ base2)
          
       // $('#fusername').val(base2); 
          
                           
      /*   //added by harshita   
          var decodedStringBtoA = $('#fusername').val(); 

       // Encode the String   
       var encodedStringBtoA = btoa(decodedStringBtoA);
           encodedStringBtoA = reverse(decodedStringBtoA);
           encodedStringBtoA = btoa(encodedStringBtoA);  
      // alert("hello" + encodedStringBtoA); 
       $('#fusername').val(encodedStringBtoA);  
         
       console.log(encodedStringBtoA); 
                               */
          createFHash("frm3");
          $('#frm3').submit();   
       }
         function showFormats(){
            //alert("1");
            $('#formatsModal').modal('show');
            
         }

         //dark theme
         const checkbox = document.getElementById("checkbox")
         checkbox.addEventListener("change", () => {
           document.body.classList.toggle("dark")
         })

   //logo onlcick alert message
     function externallinkFunction() {
     alert("You are being redirected to an external website. Please note that IVEDA is not responsible for external websites content & privacy policies.");
     }
       
     //scan  Qr code button
      function openNav() {
        document.getElementById("mySidenav").style.width = "100%"; 
      }

      function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
      }

      /* Accessible toogle icon
      Set the width of the sidebar to 250px (show it) */
      function openNavToggle() {
        document.getElementById("mySidepanel").style.width = "250px";
      }

      /* Set the width of the sidebar to 0 (hide it) */
      function closeNavAccessible() {
        document.getElementById("mySidepanel").style.width = "0";
      }
   
      </script>
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

   </script>
<script> 

//added by harshita  
function reverseString(str) { 
   //alert ('Hello');   
    var newString = ""; 
    for (var i = str.length - 1; i >= 0; i--) { 
        newString += str[i];  
    } 
    return newString;   
}  

</script>
 
 <script>
var token_key = "NMD_TOKEN_KEY";
var createFHash = function(frmName){
//alert("createFHash same"+frmName);
	 datastring = $("form[name='"+frmName+"']").serializeArray();
	 
	 
	var tokenval = getHexaCode(datastring);
												
	
	//alert("token==="+tokenval);			 
	
	$('<input>').attr({
	    type: 'hidden',
	    id: token_key,
	    name: token_key,
	    value:tokenval
	}).appendTo('form');
	
 	
};
 
 var getHexaCode = function(datastring){
		
	 //alert("getHexaCode "+datastring);
	 datastring.sort(function(a, b){
	        var a1= a.name.toLowerCase(), b1= b.name.toLowerCase();
	        if(a1== b1) return 0;
				   
				   
	        return a1> b1? 1: -1;
	    });
	     
	//alert("aaa"+datastring);
	//console.log(datastring);
	
	
	
	var myInput = "";
	var datalength=0;
	$.each(datastring, function( index, val ) {
		 
		if(val.name != token_key){
			
			//alert( index + ": " + val.name +" ="+val.value+"=");
			//alert(val.value);
			var newVal =  val.value;
			
			if(newVal!=''){
				
				newVal = newVal.replace(/ /gi, "_");
				newVal	 = newVal.replace(/\n|\r\n|\r/g, '_');
				myInput = myInput+""+newVal;
				datalength=datalength+1;
			}
			
		}
		
		  
	});
	
	//console.log("str :: "+myInput);
	//alert(myInput);
	return hex_md5(myInput);
	
	//return myInput;
	
	
 };
 
 
var submitForm = function(){
	
	//alert("inside submitForm");
	 		
	document.forms[0].submit();
	
	
};
 
var getQueryParameters = function(str){
	str = str.split('?')[1];
	
	var outputArray = new Array();
	
	var strVals = str.split("&");
	
	for(var i=0; i< strVals.length; i++){
		
		var newVals = strVals[i].split("=");
		
		var obj = {name:""+newVals[0] , value:""+newVals[1]} ;
		
		outputArray[i] = obj;
		
	} 
	
	return outputArray;
	
};
</script>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
      <!-- File Upload -->
      
      <script src="js/homepage/jquery.ui.widget.js"></script>
      <script src="js/homepage/jquery.iframe-transport.js"></script>
      <script src="js/homepage/jquery.fileupload.js"></script>  
      <script type="text/javascript" src="js/homepage/sha256.js"></script>
      <script src="js/homepage/jquery.ui.widget.js"></script>
     <script src="js/homepage/jquery.iframe-transport.js"></script>
      <script src="js/homepage/jquery.fileupload.js"></script>
     <!--  <script type="text/javascript" src="js/formFieldValidation/CSRF2.js"></script> -->
      <script type="text/javascript" src="js/formFieldValidation/md5.js"></script>  
      <script src="js/homepage/fontsize.js"></script>
       
   </body>
</html> --%>