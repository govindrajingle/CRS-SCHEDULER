<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IVEDA</title>
</head>
<body>
<%-- 
<div class="content-wrapper  pt-0 mt-0">
  <div class="content content-tiles phadmin">
     <div class="page-title">
        <h1 class="fw-bold">Dashboard</h1>
      </div>
      <div class="row card-section">
          <!-- ---------  Added by Deepshikha for role based dynamic tiles ------ -->
        <c:forEach items="${tileList}" var="k">
                <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-12">
                  <div class="card">
                  <div class="card-content card-stats ${k.strColourName}">
                      <img class="bg-icon" src="images/open-medical-capsule-icon.png" alt="Capsule Background Image" />
                      <div class="card-body p-0 position-relative z-index">
                          <div class="icon-big text-center icon-warning ${k.strIconColour}">
                            <a  href="${pageContext.request.contextPath}/${k.strUrl}" class="card-category" title="Icon Links"><i class="${k.strIconName}" aria-hidden="true"></i></a>
                          </div>
                          <div class="numbers">
                             <h3><a  href="${pageContext.request.contextPath}/${k.strUrl}" class="card-category" title="Icon Links">${k.strTilesName}</a></h3>
                          </div>
                  
                      </div>
  
                    </div>
                </div>
              </div>
        </c:forEach>
      </div><!--  end row -->

      <div class="dshbrd-dv">
        <div class="section-title"><h2>State-wise number of sites</h2></div>
        <div class="content content-stat">
          <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
          <div id="container2" style="width: 100%; height: 320px;">
            <canvas id="densityChart"> </canvas>
          </div>
        </div>
      </div>
  </div><!--  end content title -->
</div> <!-- /.content-wrapper -->

    <script>
     
    
    
    var ctx1 = document.getElementById("chartBig2").getContext("2d");
    var gradientStroke = ctx1.createLinearGradient(0, 230, 0, 50);

    gradientStroke.addColorStop(1, 'rgba(66,134,121,0.15)');
    gradientStroke.addColorStop(0.4, 'rgba(66,134,121,0.0)'); //green colors
    gradientStroke.addColorStop(0, 'rgba(66,134,121,0)'); //green colors

    
    
    
    var myChart1 = new Chart(ctx1, {
        type: 'line',
        responsive: true,
        legend: {
          display: false
        },
        
        data: {
         labels: ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'],
          datasets: [{
            label: "Months",
            fill: true,
            backgroundColor: gradientStroke,
            borderColor: '#00d6b4',
            borderWidth: 2,
            borderDash: [],
            borderDashOffset: 0.0,
            pointBackgroundColor: '#00d6b4',
            pointBorderColor: 'rgba(255,255,255,0)',
            pointHoverBackgroundColor: '#00d6b4',
            pointBorderWidth: 20,
            pointHoverRadius: 4,
            pointHoverBorderWidth: 15,
            pointRadius: 4,
            data: [50, 36, 10, 86, 70, 45,34,52,89,76,20,43],
          }]
        },
       
     

   options:{
  maintainAspectRatio: false,
              legend: {
                display: false
              },
           
              tooltips: {
                backgroundColor: '#f5f5f5',
                titleFontColor: '#333',
                bodyFontColor: '#666',
                bodySpacing: 4,
                xPadding: 12,
                mode: "nearest",
                intersect: 0,
                position: "nearest"
              },
              responsive: true,
              scales: {
                 yAxes: [{
                     barPercentage: 1.6,
                     gridLines: {
                       drawBorder: false,
                       color: 'rgba(29,140,248,0.0)',
                       zeroLineColor: "transparent",
                     },
                     ticks: {
                       suggestedMin: 60,
                       suggestedMax: 125,
                       padding: 20,
                       fontColor: "#9a9a9a"
                     }
                   }],

                 xAxes: [{
                   barPercentage: 1.6,
                   gridLines: {
                     drawBorder: false,
                     color: 'rgba(233,32,16,0.1)',
                     zeroLineColor: "transparent",
                   },
                   ticks: {
                     padding: 20,
                     fontColor: "#9a9a9a"
                   }
                 }]
              } }
          
           }); 
    </script>
  
   <script>
     
    
    
    var ctx3 = document.getElementById("monthwise-stat").getContext("2d");
    var gradientStroke = ctx3.createLinearGradient(0, 230, 0, 50);

    gradientStroke.addColorStop(1, 'rgba(66,134,121,0.15)');
    gradientStroke.addColorStop(0.4, 'rgba(66,134,121,0.0)'); //green colors
    gradientStroke.addColorStop(0, 'rgba(66,134,121,0)'); //green colors

    
    
    
    var myChart1 = new Chart(ctx3, {
        type: 'line',
        responsive: true,
        legend: {
          display: false
        },
        
        data: {
         labels: ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'],
          datasets: [{
            label: "Months",
            fill: true,
            backgroundColor: gradientStroke,
            borderColor: '#00d6b4',
            borderWidth: 2,
            borderDash: [],
            borderDashOffset: 0.0,
            pointBackgroundColor: '#00d6b4',
            pointBorderColor: 'rgba(255,255,255,0)',
            pointHoverBackgroundColor: '#00d6b4',
            pointBorderWidth: 20,
            pointHoverRadius: 4,
            pointHoverBorderWidth: 15,
            pointRadius: 4,
            data: [50, 36, 10, 86, 70, 45,34,52,89,76,20,43],
          }]
        },
       
     

   options:{
  maintainAspectRatio: false,
              legend: {
                display: false
              },
           
              tooltips: {
                backgroundColor: '#f5f5f5',
                titleFontColor: '#333',
                bodyFontColor: '#666',
                bodySpacing: 4,
                xPadding: 12,
                mode: "nearest",
                intersect: 0,
                position: "nearest"
              },
              responsive: true,
              scales: {
                 yAxes: [{
                     barPercentage: 1.6,
                     gridLines: {
                       drawBorder: false,
                       color: 'rgba(29,140,248,0.0)',
                       zeroLineColor: "transparent",
                     },
                     ticks: {
                       suggestedMin: 60,
                       suggestedMax: 125,
                       padding: 20,
                       fontColor: "#9a9a9a"
                     }
                   }],

                 xAxes: [{
                   barPercentage: 1.6,
                   gridLines: {
                     drawBorder: false,
                     color: 'rgba(233,32,16,0.1)',
                     zeroLineColor: "transparent",
                   },
                   ticks: {
                     padding: 20,
                     fontColor: "#9a9a9a"
                   }
                 }]
              } }
          
           }); 
    </script>
 
   <script>
    
 
         
        var ctx2 = document.getElementById("chartBig").getContext("2d");
         var gradientStroke = ctx2.createLinearGradient(0, 230, 0, 50);

         gradientStroke.addColorStop(1, 'rgba(66,134,121,0.15)');
         gradientStroke.addColorStop(0.4, 'rgba(66,134,121,0.0)'); //green colors
         gradientStroke.addColorStop(0, 'rgba(66,134,121,0)'); //green colors

         
         
         
         var myChart2 = new Chart(ctx2, {
             type: 'polarArea',
                       
             legend: {
               display: false
             },
            options: {
                responsive: true, 
                maintainAspectRatio: false
            },
             data: {
               labels: ['Americas', 'European', 'Eastern Mediterranean', 'South-East Asia', 'Africa', 'Western Pacific'],
               
               datasets: [{
                 label: "Regions",              
                 data: [45,34,52,89,76,43],
                backgroundColor: [
                    "#FF6384",
                    "#4BC0C0",
                    "#FFCE56",
                    "#292e88",
                    "#36A2EB",
                    "#e3421e"
                ]
               }]
             },
            
          

    
              
               }); 
   </script>
    
    
    <!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-RRHHYLSBGG"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-RRHHYLSBGG');
</script> --%>
    
   
</body>
</html>