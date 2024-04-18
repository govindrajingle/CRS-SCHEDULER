jQuery(document).ready(function($) {

	"use strict";
$('#colorselector').change(function(){
            $('.colors').hide();
            $('#' + $(this).val()).show();
        });


$('.progress .progress-bar').css("width",
        function() {
            return $(this).attr("aria-valuenow") + "%";
        }
);

//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {$.fn.scrollFunction()};

$.fn.scrollFunction= function(){ 
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}
new WOW().init();
$('#sitesdisplay').DataTable();

/*$(window).resize(function(){
	  drawChart();
	 
	});*/


var table=$('#eventlist').DataTable({
	 'columnDefs' : [
	        //hide the second & fourth column
	        { 'visible': false, 'targets': [0,7] }
	    ]}
	);
$('#eventlist tbody').on( 'click', '#editor_edit', function () {
	 //$("#savegellery").prop("style").display = "none";
  //  $("#Modify").show()
	var resultArray1=table.row( this ).data();
    console.log("hhhhhhhh=="+resultArray1[7]);
  
    /* imgClick(); */
    $('#flag').val(checkID);	
   	 $('#galleryId').val($.trim(resultArray1[0]));	
   		$('#eventName').val($.trim(resultArray1[1]));
   		$('#eventPlace').val($.trim(resultArray1[2]));
   		$('#eventDate').val($.trim(resultArray1[3]));
   		$('#eventPublishDate').val($.trim(resultArray1[4]));
   		$('#eventExpiryDate').val($.trim(resultArray1[5]));
   		$('#gallerypathlist').val($.trim(resultArray1[7]));
   	 
  
    
  

} );

/** jquery close*/
});
function validgalleryform() {
	 let eventName=$('#eventName').val();
	 if(eventName==null || eventName==""){
		 alert('please enter eventName');
		 return false;
	 }
	 
	 let eventPlace=$('#eventPlace').val();
	 if(eventPlace==null || eventPlace==""){
		 alert('please enter eventPlace');
		 return false;
	 }
	
	 let eventDate=$('#eventDate').val();
	 if(eventDate==null || eventDate==""){
		 alert('please enter eventDate');
		 return false;
	 }

	 let eventPublishDate=$('#eventPublishDate').val();
	 if(eventPublishDate==null || eventPublishDate==""){
		 alert('please enter eventPublishDate');
		 return false;
	 }
	 
	 let eventExpiryDate=$('#eventExpiryDate').val();
	 if(eventExpiryDate==null || eventExpiryDate==""){
		 alert('please enter eventExpiryDate');
		 return false;
	 }
	 
	 
	 let galleryIdimage=$('#galleryIdimage').val();
	 if(galleryIdimage==null || galleryIdimage==""){
		 alert('please upload image');
		 return false;
	 }
	 
	 let $fileUpload = $("input[type='file']");
	
	    if (parseInt($fileUpload.get(0).files.length)>10){
	     alert("You can only upload a maximum of 10 files");
	     return false;
	    }
	    var sizesum=0;
	    var imageSize=[];
	    var oFile = document.getElementById("galleryIdimage"); // <input type="file" id="fileUpload" accept=".jpg,.png,.gif,.jpeg"/>
	    for (var i = 0; i < oFile.files.length; i++) {
	    	imageSize.push(oFile.files[i].size);
	    	
		    }
	    
	    for (var j = 0; j < imageSize.length; j++) {
	    	
	    sizesum =sizesum + imageSize[j];
	    }
        if (sizesum > 2097152) // 2 mb for bytes.
        {
            alert("File size must under 2mb!");
            return false;
        }
	   
	$("#frm").submit();			
	
			
	 
	 
}
//When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}


$( document ).ready(function() {
	/*var myChart;
$.ajax({
	type : 'GET',
	url : 'DummyCharts',
	success : function(response) {
		
		if(response!=null){
			var stateList=[];
	    	var stateStatistics=[];
	    	var stateCount1=[];
	    	var arindex1=[];
	    	var arindex2=[];
	    	var arindex3=[];
			var stateMap=new Map();
			stateMap=response;
			//console.log(stateMap);
			var stateList = Object.keys(stateMap);
			//console.log(stateList);
			
			for (var i = 0; i < stateList.length; i++) {
				stateCount1 = stateMap[stateList[i]];
				//console.log(stateCount1[0]);
				arindex1.push(stateCount1[0]);
			}
			for (var i = 0; i < stateList.length; i++) {
				var stateCountt = stateMap[stateList[i]];
				//console.log(stateCountt[1]);
				arindex3.push(stateCountt[1]);
			}
			
			 for (var i = 0; i < stateList.length; i++) {
				var stateCount2 = stateMap[stateList[i]];
				console.log(stateCount);
				arindex2.push(stateCount);
			} 
			
			for (var i = 0; i < stateList.length; i++) {
				var stateCount = stateMap[stateList[i]];
				//console.log(stateCount);
				stateStatistics.push(stateCount);
			}
	
		
		var ctx = document.getElementById("densityChart").getContext("2d");

	    var gradientStroke = ctx.createLinearGradient(0, 230, 0, 50);
	    
	    
	       gradientStroke.addColorStop(1, 'rgba(12, 101, 111, 0.9)');
	       gradientStroke.addColorStop(0.4, 'rgba(12, 101, 111, 0.5)');
	       gradientStroke.addColorStop(0, 'rgba(12, 101, 111,0.2)'); //blue colors
	      myChart = new Chart(ctx, {
	         type: 'bar',
	         responsive: true,
	         legend: {
	           display: false
	         },
	         data: {
	        	 //labels: ['Haryana', 'Uttar Pradesh', 'Punjab', 'Karnataka', 'Rajasthan', 'Andhra Pradesh', 'Goa','Uttarakhand','Jammu And Kashmir','Bihar','Jharkhand','Gujarat','West Bengal','Kerala','Odisha','Madhya Pradesh','Chhattishgarh','Maharashtra','Tamil Nadu','Assam','Manipur','Himachal Pradesh','Nagaland','Meghalaya','Arunachal Pradesh','Mizoram','Telangana'],
	          	labels: stateList,
	          	idtt:arindex3,
	        	 datasets: [{
	             label: "Sites",
	             fill: true,
	             backgroundColor: gradientStroke,
	             hoverBackgroundColor: gradientStroke,
	             borderColor: '#0c656f',
	             borderWidth: 2,
	             borderDash: [],
	             borderDashOffset: 0.0,
	             data: arindex1,
	             
	           }]
	         },
	        
	      

	    options:{
	   maintainAspectRatio: false,
	       	      legend: {
	       	        display: false
	       	      },
	       	   onClick: graphClickEvent,		       	  
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

	       	          gridLines: {
	       	            drawBorder: false,
	       	            color: 'rgba(29,140,248,0.1)',
	       	            zeroLineColor: "transparent",
	       	          },
	       	          ticks: {
	       	            suggestedMin: 1,
	       	            suggestedMax: 30,
	       	             stepSize: 0,
	       	            padding: 70,
	       	            fontColor: "#2C3539"
	       	          }
	       	        }],

	       	        xAxes: [{

	       	          gridLines: {
	       	            drawBorder: false,
	       	            color: 'rgba(29,140,248,0.1)',
	       	            zeroLineColor: "transparent",
	       	          },
	       	          ticks: {
	       	            padding: 20,
	       	            fontColor: "#2C3539",
	       	            maxRotation: 90,
	                    minRotation: 90,
	                    fontSize:14,
	                 
	       	          }
	       	        }]
	       	      }	}
	   			  
	   			   }); 
	}
	
	},error:function(error){
		console.log("error is come due to==");
		
	}

});

$.ajax({
	type : 'GET',
	url : 'getcntstat',
	success : function(response) {
		
		if(response!=null){
			var countryList=[];
			var countryCount1=[];
	    	var arindex1=[];
	    	var CountryMap=new Map();
			CountryMap=response;
			//console.log(stateMap);
			var countryList = Object.keys(CountryMap);
			for (var i = 0; i < countryList.length; i++) {
				countryCount1 = CountryMap[countryList[i]];
				arindex1.push(countryCount1);
				
				
			}
			
var ctx1 = document.getElementById("chartBig1").getContext("2d");
var gradientStroke = ctx1.createLinearGradient(0, 230, 0, 50);

gradientStroke.addColorStop(1, 'rgba(233,32,16,0.2)');
gradientStroke.addColorStop(0.4, 'rgba(233,32,16,0.0)');
gradientStroke.addColorStop(0, 'rgba(233,32,16,0)'); //red colors



var myChart1 = new Chart(ctx1, {
 type: 'line',
 responsive: true,
 legend: {
   display: false
 },
 
 data: {
        	 labels: ['Japan', 'Finland', 'London', 'Australia', 'US', 'Bangladesh', 'China','Switzerland','Nepal','Canada','Cuba','Indonesia'],
         
labels: countryList,
datasets: [{
     label: "Countries",
     fill: true,
     backgroundColor: gradientStroke,
     hoverBackgroundColor: gradientStroke,
     borderColor: '#95410e',
     borderWidth: 2,
     borderDash: [],
     pointBorderColor: '#95410e',
     pointRadius: 4,
     pointHoverRadius: 4,
     pointBorderWidth: 8,
     borderDashOffset: 0.0,
     data: [50, 36, 10, 86, 70, 45,34,52,89,76,20,43],
     data: arindex1, 
   }]
 },



options:{
 elements: {
    line: {
        tension: 0 // disables bezier curves
    }
}, 
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

	          gridLines: {
	            drawBorder: false,
	            color: 'rgba(29,140,248,0.1)',
	            zeroLineColor: "transparent",
	          },
	          ticks: {
	            suggestedMin: 60,
	            suggestedMax: 120,
	            padding: 20,
	            fontColor: "#000"
	          }
	        }],

	        xAxes: [{

	          gridLines: {
	            drawBorder: false,
	            color: 'rgba(29,140,248,0.1)',
	            zeroLineColor: "transparent",
	          },
	          ticks: {
	            padding: 20,
	            fontColor: "#000"
	          }
	        }]
	      }	}
		  
		   }); 
		}

	},error:function(error){
		console.log("error is come due to==");
		
	}

});


function graphClickEvent(event, array){
	 //alert("hello");
	 var clickEvent=myChart.getElementAtEvent(event);
	 if(clickEvent.length>0){
		//console.log( myChart.getElementAtEvent(event));
		e=array[0];
	    //console.log("index",e._chart.data.idtt);
	 var kk=e._chart.data.idtt[e._index];
	//console.log("kk=="+kk);
	window.location.href = "StatewiseSiteDetails?dist=" + kk;

	
	 }
	 
	

	   
	}*/


/** document.ready closed here */
});



  
