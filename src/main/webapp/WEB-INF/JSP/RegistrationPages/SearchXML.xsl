<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittlexsl">Package Details</h3></div>
	</div>
	<div class="mt-1">
	  <table id="tb2" class="w-100 table table-striped table-bordered dt-responsive  dspit">
   
		  <thead class="theadTransacColor">
		   <tr>
		   	<th>SSCC </th>
		   	<th>Pack Code </th>
		    <th>Pack Type </th>
		    <th>Manufactured/Marketed by </th>
		    <th>Destination of Export</th>	
		    <th>Port of Export </th>	
		    <th>Port of Landing </th>	     
		   </tr>
		   </thead>
		  
		     
		    
		 
		   <tbody>
		     <xsl:for-each select="Iveda">
		 
		     <tr>
		     
		      <td><xsl:value-of select="SSCC"/></td>
		      	<td><xsl:value-of select="packCode"/></td>
		        <td><xsl:value-of select="packtype"/></td>
		    	<td><xsl:value-of select="source"/></td>
		        <td><xsl:value-of select="sendto"/></td>
		        <td><xsl:value-of select="PortName"/></td>
		        <td><xsl:value-of select="LandingPort"/></td>
			</tr>
		       </xsl:for-each>
		       
      

		    </tbody>
    
   
		</table>
		</div>
		
		
		<!-- <xsl:if test="count &gt; 0"> -->
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="Iveda/Product != ''">
					<div id="ProductDtls">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
							<div class="float-left"><h3 class="tittlexsl">Product Details</h3></div>
					</div>
					<div class="mt-1">
					<table id="tbl" class="w-100 table table-striped table-bordered dt-responsive">
				   
						  <thead class="theadTransacColor">
						   <tr>
						   	<th>Product code </th>
						    <th>Product Name </th>
						    <th>Batch Number </th>
						    <th>Expiry Date </th>						     
						   </tr>
						   </thead>
						  
						     
						    
						 
						   <tbody>
						   
						   
						     <xsl:for-each select="Iveda/Product">
						 
						     <tr>
						     
						      
						      	<td><xsl:value-of select="prodcd"/></td>
						        <td><xsl:value-of select="prodname"/></td>
						    	<td><xsl:value-of select="batchno"/></td>
						        <td><xsl:value-of select="expirydt"/></td>
							</tr>
						       </xsl:for-each>
						    </tbody>
				    
				   
					</table>
					</div>
					</div>
				</xsl:when>
				<xsl:otherwise>
					
				</xsl:otherwise>
			</xsl:choose>
		</span>
	 	
	 </xsl:template>
</xsl:stylesheet>