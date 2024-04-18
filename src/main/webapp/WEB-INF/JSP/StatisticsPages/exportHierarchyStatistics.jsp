<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content-wrapper">
	 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {packages:["orgchart"]});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('string', 'Manager');
        data.addColumn('string', 'ToolTip');
var t="homo";
var t1="homo";
        // For each orgchart box, provide the name, manager, and tooltip to show.
        data.addRows([
        	
     [{'v':'T1', 'f':'Tertiary1<div>Tertiary Package</div>'},'', 'The President'],
     [{'v':'T2', 'f':'Tertiary2<div>Tertiary Package</div>'},'', 'The President1'],
     [{'v':'T3', 'f':'Tertiary3<div>Tertiary Package</div>'},'', 'The President'],
     [{'v':'Jim', 'f':'S3<div>S3 Package</div>'},'T1', 'VP'],
     [{'v':'Jim1', 'f':'S3<div>S3 Package</div>'},'T1', 'VP'],
     [{'v':'Jim2', 'f':'S3<div>S3 Package</div>'},'T1', 'VP'],                
     [{'v':'Jim3', 'f':'S3<div>S3 Package</div>'},'T2', 'VP'],
           [{'v':'Jim4', 'f':'S3<div>S2 Package</div>'},'T2', 'VP'],
           [{'v':'Jim5', 'f':'S2<div>S2 Package</div>'},'T3', 'VP'],
           [{'v':'Jim6', 'f':'S2<div>S3 Package</div>'},'T3', 'VP'],
           [{'v':'Jim7', 'f':'S2<div>S2 Package</div>'},'Jim', 'VP'],
            [{'v':'Jim8', 'f':'S2<div>S2 Package</div>'},'Jim1', 'VP'],
            [{'v':'Jim9', 'f':'S2<div>S2 Package</div>'},'Jim1', 'VP'], 
             [{'v':'Jim10', 'f':'S2<div>S2 Package</div>'},'Jim2', 'VP'],  
            [{'v':'Jim11', 'f':'S2<div>S2 Package</div>'},'Jim3', 'VP'],   
             [{'v':'Jim12', 'f':'S2<div>S2 Package</div>'},'Jim4', 'VP'],
           [{'v':'Jimi', 'f':'S1<div>S1 Package</div>'},'Jim7', 'VP'],
           [{'v':'Jimi1', 'f':'S1<div>S1 Package</div>'},'Jim8', 'VP'],
           [{'v':'Jimi2', 'f':'S1<div>S1 Package</div>'},'Jim9', 'VP'],
           [{'v':'Jimi3', 'f':'S1<div>S1 Package</div>'},'Jim10', 'VP'],
           [{'v':'Jimi4', 'f':'S1<div>S1 Package</div>'},'Jim11', 'VP'],
           [{'v':'Jimi5', 'f':'S1<div>S1 Package</div>'},'Jim12', 'VP'],
           [{'v':'Jimi6', 'f':'S1<div>S1 Package</div>'},'Jim5', 'VP'],
           [{'v':'Jimi7', 'f':'S1<div>S1 Package</div>'},'Jim6', 'VP'],
           [{'v':'Primary', 'f':'P1<div>Primary Package</div>'},'Jimi', 'VP'],
           [{'v':'Primary1', 'f':'P1<div>Primary Package</div>'},'Jimi1', 'VP'],
            [{'v':'Primary2', 'f':'P1<div>Primary Package</div>'},'Jimi2', 'VP'],
            [{'v':'Primary3', 'f':'P1<div>Primary Package</div>'},'Jimi3', 'VP'],
            [{'v':'Primary4', 'f':'P1<div>Primary Package</div>'},'Jimi4', 'VP'],
            [{'v':'Primary5', 'f':'P1<div>Primary Package</div>'},'Jimi5', 'VP'],
          [{'v':'Primary6', 'f':'P1<div>Primary Package</div>'},'Jimi6', 'VP'],
            [{'v':'Primary7', 'f':'P1<div>Primary Package</div>'},'Jimi7', 'VP'],
        ]);
        //data.setRowProperty(3, 'selectedStyle', 'background:#000');
        //data.setRowProperty(3, 'style', 'border: 1px solid green;background:#fff');
     // Set chart options
     var c="homo";
     if(c=="homo"){
    var d="secondarypackage";}
     else {
    	 var d="secondarypackage1"; 
     }
        var options = {allowHtml:true,
        		size:'large',
        		allowCollapse:false,
        		selectionColor:'#fff',        		
        		nodeClass:d,
        		
    		 
     };
     
   
        // Create the chart.
        var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
        // Draw the chart, setting the allowHtml option to true for the tooltips.
        chart.draw(data, options);
      }
   </script>
   <div class="content content-stat col-md-offset-12 col-md-12">
   <h3>Export Order Details</h3>
    <div id="chart_div"></div>
		
</div>
	</div>
</body>
</html>