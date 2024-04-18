<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

	<body>
	<div class="content-wrapper">
<div class="container-fluid reg_contain">
<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittle">Country-wise Export Statistics</h3></div>
		<div class="title-icon float-left">					
		<img class="mb-10" src="images/icontab2.png" alt="">
		</div>
		</div>
<div class="col-md-12 col-lg-12 col-sm-12">

<table class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" id="m_table_1">
						<thead class="theadTransacColor">
				  			<tr>
					  				<th>Country Name</th>
               						 <th>No. of sites</th>							
					  		</tr>
						</thead>
						<tbody id="tbodyId"></tbody>
						
					</table>

	</div></div></div>
	
	<script>
	

	$( document ).ready(function() {
		
	$.ajax({
	type : 'GET',
	url : 'viewAllCountryExportStatisticsajax',
	success : function(response) {	
			
		if(response!=null){
			var countryStatsList=[];
	    	//var countryStatistics=[];
	    	var countryCount1=[];
	    	
			var stateMap=new Map();			
			stateMap=response;
			//console.log(stateMap[0]);
			var countryStatsList = Object.keys(stateMap);
			//console.log(countryStatsList);
			
			for (var i = 0; i < countryStatsList.length; i++) {
				countryCount1 = stateMap[countryStatsList[i]];
				//console.log(countryCount1);
				//arindex1.push(countryCount1[0]);
				
				var html = "<tr><td>"+countryStatsList[i]+"</td><td>"+countryCount1+"</td></tr>";			

			
			$('#tbodyId').append(html);
			}
			$('#m_table_1').dataTable(); 
		}
		
	},error:function(error){
		console.log("error is come due to==");
		
	}

});

	});
	 
		</script>
	</body>