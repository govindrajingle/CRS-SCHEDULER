<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <meta name="description" content="Integrated Validation of Export of Drugs and its Authentication">
<title>IVEDA Dashboard</title>
</head>

<body>
<%-- 
	<div class="content-wrapper pt-0 mt-0">
		<div class="content content-tiles">
			<div class="page-title">
				<h1 class="fw-bold">Dashboard</h1>
			</div>
		   <div class="row card-section">
		      <!-- ---------  Added by Deepshikha for role based dynamic tiles ------ -->
		      <c:forEach items="${tileList}" var="k">
		         <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
		            <div class="card">
			            <div class="card-content card-stats ${k.strColourName}">
			            	<img class="bg-icon" src="images/open-medical-capsule-icon.png" alt="Capsule Background Image" />
			               <div class="card-body p-0 position-relative z-index">
			                     <div class="icon-big text-center icon-warning ${k.strIconColour}">
			                        <a href="${pageContext.request.contextPath}/${k.strUrl}" class="card-category"><i class="${k.strIconName}" aria-hidden="true"></i>
			                        </a>
			                     </div>
			                     <div class="numbers">
			                        <h3><a href="${pageContext.request.contextPath}/${k.strUrl}" class="card-category">${k.strTilesName}</a></h3>
			                     </div>
			               </div>
			               <div class="card-footer">	
		                  <div class="numbers">
		                     <c:set var="myParam" value="${k.strTilesName}"/>
		                     <a  href="${pageContext.request.contextPath}/${k.strCountUrl}" target=""  class="card-title" 
		                      title="Tiles">${tileMap[myParam]}</a>
		                  </div>
			           	</div>
			            </div>
			            
		            </div>
		         </div>
		      </c:forEach>
		   </div><!--  end row -->

<!--  2nd chart with select option  -->
<div class="dshbrd-dv">
	<div class="section-title"><h2>Export Statistics</h2></div>
<div class="content content-stat dshbrd-dv">
	<div class="row">
   <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
   	 <label class="dvfrm-label" for="menu">Select the type of Export
      Statistics</label>
      <Select id="menu" class="w-100">
         <option value="countrywise">Country-wise</option>
         <option value="packtype">Region-wise</option>
      </Select>
   </div>
	</div>
	<div id="countrywise" class="colors2"
	   style="display: block; height: 300px;">
		<div class="row d-flex">
		   <div class="col-md-6 col-sm-12 col-xs-12 col-lg-6 ">
		      <h3 class="export_p">Top 20 Countries Export</h3>
		   </div>
		   <div class="col-md-6 col-sm-12 col-xs-12 col-lg-6  more_info">
		      <a href="${pageContext.request.contextPath}/viewAllCountryExportStatistics" class="custom-btn position-relative">
		      View All Country Export Statistics
		      </a>
		   </div>
		</div>
		<canvas id="chartBig1"> </canvas>
		<script type="text/javascript">
	   	$("#menu").change(function(){
	  	 var selectedChart=$('#menu').val();
		     if(selectedChart=='countrywise'){
		    	 document.getElementById("worldmap").style.display = "none";
		    	 document.getElementById("countrywise").style.display = "block";
		    	/* menu.draw(data, options);  */            	    	            	    	 
		     }
		     else if(selectedChart=="packtype"){
		    	/*  menu.draw(data1, options);  */
		    	 document.getElementById("worldmap").style.display = "block";
		    	 document.getElementById("countrywise").style.display = "none";
		     }
		     /* else if(selectedChart=="producttype"){
		    	menu.draw(data2, options); 
		     } */
		     else{
		    	 alert("no option is selected ");
		     }
	  	  });    
		</script>
	</div>
	<div id="worldmap" style="display: none;">
		<img src="images/mapw.png" usemap="#image-map" alt="Map Image">
			<map name="image-map">
					<area target="_blank" onmouseover="tooltip.pop(this, 'hi there')"
						alt="Region of the Americas" title="Region of the Americas"
						href="#"
						coords="18,64,30,57,42,44,67,39,77,39,96,39,111,41,133,44,146,45,157,45,154,38,150,29,166,33,167,45,180,46,187,39,206,31,223,24,231,14,254,12,230,25,213,33,228,34,231,56,228,61,215,73,218,83,230,71,231,87,232,94,215,96,206,101,196,112,178,126,161,139,158,147,153,151,150,159,76,104,63,112,54,126,59,136,60,146,70,147,72,158,80,176,85,185,96,192,103,196,116,197,102,172,108,159,118,156,131,150,139,148,122,139,118,189,106,189,117,141,116,131,103,115,88,114,96,117,101,123,108,127,120,147,78,112,110,128,113,137,102,142,89,127,107,135,97,134,71,110,81,118,184,281,124,184,136,209,153,219,169,218,177,215,188,214,203,226,220,239,222,245,237,254,256,256,265,266,268,291,259,305,256,313,239,340,227,346,214,353,206,382,205,399,200,404,220,231,215,233,168,229,151,250,145,268,163,292,179,307,186,329,187,365,188,378,192,396,208,257,201,242,156,231,199,235,212,253,246,194,244,193,246,194"
						shape="poly">
					<area target="_blank" alt="African Region" title="African Region"
						href="#"
						coords="390,135,376,137,369,141,362,151,350,156,348,164,341,169,334,179,330,184,326,191,328,207,339,218,345,227,357,227,378,226,391,230,397,240,401,254,411,267,409,284,406,294,407,306,413,316,416,330,420,341,424,351,431,348,443,344,448,338,453,330,462,321,467,313,467,301,474,292,479,271,478,255,481,248,478,236,461,233,444,234,427,194,407,181,391,150,396,168,396,176,405,176,407,181,396,170,414,199,393,174,422,228,412,217,400,182,397,182"
						shape="poly">
					<area target="_blank" alt="European Region" title="European Region"
						href="#"
						coords="360,131,349,130,351,117,370,120,368,104,371,97,381,89,395,86,410,85,421,83,431,75,437,62,426,47,411,53,413,66,408,74,388,59,405,49,394,68,415,41,427,41,444,45,451,54,467,49,484,46,506,46,529,44,542,33,562,26,577,22,584,29,601,30,622,33,636,38,658,35,672,37,684,36,698,40,719,44,731,44,752,48,743,62,741,77,750,86,725,60,696,69,691,80,699,89,708,117,714,101,708,91,390,113,417,108,428,117,404,109,439,123,446,129,466,133,482,129,472,119,456,119,446,112,453,105,473,101,472,111,494,117,501,103,512,121,533,127,541,128,551,128,568,115,572,108,575,96,588,87,604,84,617,84,629,88,644,90,652,84,668,76,681,89,685,95,698,100,264,22,280,37,274,58,295,50,314,43,334,31,343,14,328,4,322,7,296,10,308,12,284,11,273,12"
						shape="poly">
					<area target="_blank" alt="Eastern Mediterranean Region"
						title="Eastern Mediterranean Region"
						href="#"
						coords="398,140,407,147,419,153,428,151,440,149,453,153,466,145,476,137,484,132,497,131,503,136,518,133,527,136,536,136,557,135,565,135,565,147,563,159,553,168,545,170,529,180,508,191,492,201,461,191,463,202,461,217,453,225,440,228,395,145,431,163"
						shape="poly">
					<area target="_blank" alt="South-East Area Region"
						title="South-East Area Region" href="#"
						coords="573,140,567,153,563,165,561,176,569,180,575,192,577,205,586,216,592,196,601,184,610,179,617,175,625,175,630,181,635,187,646,196,644,184,639,173,630,160,646,236,654,250,658,256,622,160"
						shape="poly">
					<area target="_blank" alt="Western Pacific Region"
						title="Western Pacific Region" href="#"
						coords="713,297,720,291,734,288,743,284,743,293,747,299,754,297,761,288,766,301,778,313,778,324,780,335,771,341,750,361,740,356,737,350,724,346,706,341,695,340,679,348,679,333,682,320,686,312"
						shape="poly">
					<area target="_blank" alt="Western Pacific Region"
						title="Western Pacific Region" href="#"
						coords="587,119,579,110,583,102,595,96,613,94,629,93,635,96,655,96,667,95,666,85,689,98,701,108,683,120,674,134,682,146,692,161,683,174,655,176,667,204,661,209,575,116,566,127,577,138,583,141,608,154,593,144,597,138,590,127,603,147,661,173,644,162,604,154"
						shape="poly">
				</map>
			</div>
		</div>
	</div>
	</div><!-- end Content Tile -->
		




	
	
	
	<script type="text/javascript">
	var isZoom=false;
	var dX,dY,dS;
	jQuery(document).ready(function() {
		jQuery('#vmap').vectorMap({
			map: 'world_en',
			backgroundColor: '#ffffff',
			color: '#ffffff',
			hoverOpacity: 0.7,
			selectedColor: '#666666',
			borderColor: '#ffffff',
			colors : test,
			enableZoom: false,
			showTooltip: true,
			onRegionOver : function (element, code, region)
			{
				highlightRegionOfCountry(code);
			},
			onRegionOut : function (element, code, region)
			{
				unhighlightRegionOfCountry(code);
			},
			onRegionClick: function (element, code, region)
			{
				if(!isZoom){ //first click; zooms in
					if(countryMap[code]=="Asia"){
						dX=280;dY=-100;dS=1.3;
					}
					if(countryMap[code]=="Africa"){
						dX=150;dY=150;dS=1.7;
					}
					if(countryMap[code]=="Europe"){
						dX=170;dY=50;dS=2.4;
					}
					if(countryMap[code]=="northAmerica"){
						dX=-200;dY=-200;dS=1.5;
					}
					if(countryMap[code]=="Australia"){
						dX=470;dY=300;dS=2;
					}
					if(countryMap[code]=="southAmerica"){
						dX=-200;dY=300;dS=1.5;
					}
					zoomInOnContinent(dX,dY,dS);
					isZoom=true;
					setRegion(code);
					setRegionColors();
					$('#directions').text('Please select a country');
				}
				else{ //second click on country
					$('#description-box').html('');
					countrySelected = true;
					selectedCode = code;
					displayBoxText(code);
				}
			}
		});
		document.getElementById("description-box").style.display = "none";
		document.getElementById("backButton").style.display = "none";
		$('#directions').text('Please select a continent');
	});

	function backButtonClick(){
		if(isZoom){
			zoomOutOnContinent(dX,dY,dS);
			isZoom=false;
			$('#vmap').vectorMap('set', 'colors', test);
		}
	}
	</script>


	
	
	<!--  <div class="row"> 
    
   
    <div class=" col-lg-6">
    <div id="worldmap" style="display:block;">
				<img src="images/mapw.png" usemap="#image-map" style="width:100%">

				<map name="image-map">
					<area target="_blank" onmouseover="tooltip.pop(this, 'hi there')"
						alt="Region of the Americas" title="Region of the Americas"
						href="https://www.google.co.in/"
						coords="18,64,30,57,42,44,67,39,77,39,96,39,111,41,133,44,146,45,157,45,154,38,150,29,166,33,167,45,180,46,187,39,206,31,223,24,231,14,254,12,230,25,213,33,228,34,231,56,228,61,215,73,218,83,230,71,231,87,232,94,215,96,206,101,196,112,178,126,161,139,158,147,153,151,150,159,76,104,63,112,54,126,59,136,60,146,70,147,72,158,80,176,85,185,96,192,103,196,116,197,102,172,108,159,118,156,131,150,139,148,122,139,118,189,106,189,117,141,116,131,103,115,88,114,96,117,101,123,108,127,120,147,78,112,110,128,113,137,102,142,89,127,107,135,97,134,71,110,81,118,184,281,124,184,136,209,153,219,169,218,177,215,188,214,203,226,220,239,222,245,237,254,256,256,265,266,268,291,259,305,256,313,239,340,227,346,214,353,206,382,205,399,200,404,220,231,215,233,168,229,151,250,145,268,163,292,179,307,186,329,187,365,188,378,192,396,208,257,201,242,156,231,199,235,212,253,246,194,244,193,246,194"
						shape="poly">
					<area target="_blank" alt="African Region" title="African Region"
						href="https://www.cdac.in/"
						coords="390,135,376,137,369,141,362,151,350,156,348,164,341,169,334,179,330,184,326,191,328,207,339,218,345,227,357,227,378,226,391,230,397,240,401,254,411,267,409,284,406,294,407,306,413,316,416,330,420,341,424,351,431,348,443,344,448,338,453,330,462,321,467,313,467,301,474,292,479,271,478,255,481,248,478,236,461,233,444,234,427,194,407,181,391,150,396,168,396,176,405,176,407,181,396,170,414,199,393,174,422,228,412,217,400,182,397,182"
						shape="poly">
					<area target="_blank" alt="European Region" title="European Region"
						href="http://localhost:8080/DAVA/login"
						coords="360,131,349,130,351,117,370,120,368,104,371,97,381,89,395,86,410,85,421,83,431,75,437,62,426,47,411,53,413,66,408,74,388,59,405,49,394,68,415,41,427,41,444,45,451,54,467,49,484,46,506,46,529,44,542,33,562,26,577,22,584,29,601,30,622,33,636,38,658,35,672,37,684,36,698,40,719,44,731,44,752,48,743,62,741,77,750,86,725,60,696,69,691,80,699,89,708,117,714,101,708,91,390,113,417,108,428,117,404,109,439,123,446,129,466,133,482,129,472,119,456,119,446,112,453,105,473,101,472,111,494,117,501,103,512,121,533,127,541,128,551,128,568,115,572,108,575,96,588,87,604,84,617,84,629,88,644,90,652,84,668,76,681,89,685,95,698,100,264,22,280,37,274,58,295,50,314,43,334,31,343,14,328,4,322,7,296,10,308,12,284,11,273,12"
						shape="poly">
					<area target="_blank" alt="Eastern Mediterranean Region"
						title="Eastern Mediterranean Region"
						href="https://navodaya.gov.in/nvs/en/Home1"
						coords="398,140,407,147,419,153,428,151,440,149,453,153,466,145,476,137,484,132,497,131,503,136,518,133,527,136,536,136,557,135,565,135,565,147,563,159,553,168,545,170,529,180,508,191,492,201,461,191,463,202,461,217,453,225,440,228,395,145,431,163"
						shape="poly">
					<area target="_blank" alt="South-East Area Region"
						title="South-East Area Region" href="https://www.cdac.in/"
						coords="573,140,567,153,563,165,561,176,569,180,575,192,577,205,586,216,592,196,601,184,610,179,617,175,625,175,630,181,635,187,646,196,644,184,639,173,630,160,646,236,654,250,658,256,622,160"
						shape="poly">
					<area target="_blank" alt="Western Pacific Region"
						title="Western Pacific Region" href="https://www.google.co.in/"
						coords="713,297,720,291,734,288,743,284,743,293,747,299,754,297,761,288,766,301,778,313,778,324,780,335,771,341,750,361,740,356,737,350,724,346,706,341,695,340,679,348,679,333,682,320,686,312"
						shape="poly">
					<area target="_blank" alt="Western Pacific Region"
						title="Western Pacific Region" href="https://www.google.co.in/"
						coords="587,119,579,110,583,102,595,96,613,94,629,93,635,96,655,96,667,95,666,85,689,98,701,108,683,120,674,134,682,146,692,161,683,174,655,176,667,204,661,209,575,116,566,127,577,138,583,141,608,154,593,144,597,138,590,127,603,147,661,173,644,162,604,154"
						shape="poly">
				</map>
			</div>
    </div>
    
     
        
        <div class=" col-lg-6">
      <div class=" card card-chart">
        <div class=" card-header">
          <h3 class=" card-category">Maximum Export Regionwsie</h3>
         
        </div>
        <div class=" card-body">
          <div class=" chart-area">
          
          
            	<div id="map-holder">
		<div id="vmap" style="width:100%;"></div>
		<div id="directions"></div>
		<div id="backButton" onClick="backButtonClick();">Back</div>
		
		Use this to display data
		<div id="description-box"></div>
	</div>
	
          
          
          
          
          </div>
        </div>
      </div>
    </div>
        </div> -->



</div>

	<!-- /.content-wrapper -->
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