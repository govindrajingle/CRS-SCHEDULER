<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video Tutorial</title>
<style>

  .modal-backdrop.show{
  opacity:0;
}
  .modal-backdrop.in{
  opacity:0;
}
    </style>
  
</head>
<body>
<section class="reg_note reg_notegal" id="skiptomaincontent">
  <div class="container">
    <div class="page-title text-center"><h1 class="fw-bold position-relative">Video <span>Tutorials</span></h1></div>
      <div class="reg_col reg_colvideo">
          <ul class="row">
            <li class="col-lg-4 col-md-4 col-sm-6 col-xs-12 col col1">
              <a class="trnln card position-relative d-flex w-100 h-100" onclick="showvideo('https://www.youtube.com/embed/EitLDLSm3YY');" >
                <div class="overlay"></div>
                <div class="circle"><i class="fa fa-user"></i></div>
                <h3>Registration Guidelines</h3>
              </a>
            </li>
      
            <li class="col-lg-4 col-md-4 col-sm-6 col-xs-12 col col2">
              <a class="trnln card position-relative d-flex w-100 h-100" onclick="showvideo('https://www.youtube.com/embed/Duo-XII9oQE');" >
                <div class="overlay"></div>
                <div class="circle"><i class="fa fa-list-alt"></i></div>
                <h3>Product Schema XML Made Easy</h3>
              </a>
            </li>

            <li class="col-lg-4 col-md-4 col-sm-6 col-xs-12 col col3">
              <a class="trnln card position-relative d-flex w-100 h-100" onclick="showvideo('https://www.youtube.com/embed/8GBdQN7j9fs');" >
                <div class="overlay"></div>
                <div class="circle"><i class="fa fa-file"></i></div>
                <h3>Export Packaging XML</h3>
              </a>
            </li>
            
            <li class="col-lg-4 col-md-4 col-sm-6 col-xs-12 col col4">
              <a href="#" class="trnln card position-relative d-flex w-100 h-100" onclick="showvideo('https://www.youtube.com/embed/gRVWiLrFtXQ');" >
                <div class="overlay"></div>
                <div class="circle"><i class="fa fa-list-alt"></i></div>
                <h3>Product Schema XML 1.2</h3>
              </a>
            </li>

            <li class="col-lg-4 col-md-4 col-sm-6 col-xs-12 col col5">
              <a href="#" class="trnln card position-relative d-flex w-100 h-100" onclick="showvideo('https://www.youtube.com/embed/f5eadFd9bsE');" >
                <div class="overlay"></div>
                <div class="circle"><i class="fa fa-file"></i></div>
                <h3>Export Packaging XML 1.2</h3>
              </a>
          </li>

          <li class="col-lg-4 col-md-4 col-sm-6 col-xs-12 col col6">
            <a href="#" class="trnln card position-relative d-flex w-100 h-100" onclick="showvideo('https://www.youtube.com/embed/bPyWMWEwZJI');" >
              <div class="overlay"></div>
              <div class="circle"><i class="fa fa-list-alt"></i></div>
              <h3>Consignment Schema Files 1.6 version</h3>
            </a>
          </li>
      </ul>
    </div>
  </div>
</section>

 <!-- Modal -->
  <div class="modal fade" id="myModaltrn" role="dialog">
    <div class="modal-dialog modal-lg modal-sm">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
          
        </div>
        
      </div>
      
    </div>
  </div>



<script>
function showvideo(linkname){
	/* window.location.href = linkname; */
	window.open(linkname, '_blank');
}
/*      function showvideo(linkname){    
        $('#myModaltrn').modal({
            backdrop: 'false',
            keyboard: false
        });
        $(".modal-body").html("");
        var newSrc=linkname;
         $(".modal-body").append("<iframe src='" + linkname + "' class='embedvd' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen='allowfullscreen'></iframe>");
      }  */
    $('#myModaltrn .close').click (function(e) {$(".modal-body").html("");});
</script>
</body>
</html>