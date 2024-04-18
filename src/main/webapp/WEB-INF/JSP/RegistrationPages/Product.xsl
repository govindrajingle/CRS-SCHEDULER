<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	<div id="details">
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="tittle"><h3 class="fw-bold" >Product Details</h3></div>
	</div>
	
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 " style="padding-top: 10px;border: 2px solid;border-radius: 12px;">
   				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-6" >
		   	<h4 class="bold">FILE NAME :<xsl:value-of select="PRODUCTS_LIST/FILENAME"/></h4> 
		   	<h4 class="bold" >MANUFACTURER_CODE:<xsl:value-of select="PRODUCTS_LIST/MANUFACTURER_CODE"/> </h4>
		  </div>
		     
    
</div>
		
		
		<!-- Product Details start -->
		
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="PRODUCTS_LIST/PRODUCT != ''">
					<div id="ProductDtls">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
							<div class="float-left"><br></br><h3 class="tittlexsl" style="text-decoration-line: underline;">Products</h3></div>
					</div>
					
					
<table id="tbl" class="table table-striped table-bordered dt-responsive nowrap dspit" style="width:100%;margin-top: 1%;word-wrap: break-word;table-layout: fixed;">				   
					   
						  <thead class="theadTransacColor">
						   <tr>
						   <th>PRODUCT_TYPE</th>
						   <th>GTIN</th>
						    <th>Product Name </th>
						    <th>GENERIC_NAME </th>
						    <th>COMPOSITION</th>
						    <th>SCHEDULED </th>
						    <th>REMARK</th>
						    <th>STORAGE_CONDITION</th>
						    <th>STRENGTH</th>
						    <th>DOSAGE</th>
						    <th>HS_CODE</th>
						   </tr>
						   </thead>
						  
						     
						    
						 
						   <tbody>
						   
						               <xsl:for-each select="//PRODUCT">
						   						 
						     <tr>
						     
						      
						      	<td><xsl:value-of select="PRODUCT_TYPE"/></td>
						        <td><xsl:value-of select="GTIN"/></td>
						    	<td><xsl:value-of select="PRODUCT_NAME"/></td>
						        <td><xsl:value-of select="GENERIC_NAME"/></td>
						        <td><xsl:value-of select="COMPOSITION"/></td>
						        <td><xsl:value-of select="SCHEDULED"/></td>
						        <td><xsl:value-of select="REMARK"/></td>
						        <td><xsl:value-of select="STORAGE_CONDITION"/></td>
						        <td><xsl:value-of select="STRENGTH"/></td>
						        <td><xsl:value-of select="DOSAGE"/></td>
						        <td><xsl:value-of select="HS_CODE"/></td>
							</tr>
						       </xsl:for-each>
						       
						       
						    </tbody>
				    
				   
					</table>
					</div>
				</xsl:when>
				<xsl:otherwise>
					
				</xsl:otherwise>
			</xsl:choose>
		</span>
		<!-- Product Details end -->
		
		</div>
		


	 </xsl:template>
</xsl:stylesheet>