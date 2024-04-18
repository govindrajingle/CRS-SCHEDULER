<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	<div id="details">
	<div class="w-100 reg_col">
			<h3 class="tittlexsl" >Consignment Details</h3>
	</div>
	
	<div class="row " style="padding-top: 10px;border: 2px solid;border-radius: 12px;">
   				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-6" >
		   	<h4 class="bold">SENDER_MANUFACTURER_CODE :<xsl:value-of select="ConsignmentDetails/SENDER_MANUFACTURER_CODE"/></h4> 
		   	<h4 class="bold" >FILE NAME :<xsl:value-of select="ConsignmentDetails/FILENAME"/> </h4>
		   	<h4 class="bold" >FILE DATE : <xsl:value-of select="ConsignmentDetails/FILE_DATE"/> </h4>
		    <h4 class="bold" >FILE TIME : <xsl:value-of select="ConsignmentDetails/FILE_TIME"/></h4>
		    <h4 class="bold" >SUPPLY TYPE : <xsl:value-of select="ConsignmentDetails/SupplyType"/></h4>
		    <h4 class="bold" >SERIALIZATION TYPE : <xsl:value-of select="ConsignmentDetails/SERIALIZATION_TYPE"/></h4>
		    </div>
		    <div class="col-md-6 col-lg-6 col-sm-6 col-xs-6" >
		    <h4 class="bold" >EWAY_BILL_NO :<xsl:value-of select="ConsignmentDetails/EWay_Bill_No"/></h4>	
		    <h4 class="bold" >BILL_DATE :<xsl:value-of select="ConsignmentDetails/Bill_Date"/></h4>	   
		    <h4 class="bold" >Region Code :<xsl:value-of select="ConsignmentDetails/RegionCD"/> </h4>
		   	<h4 class="bold" >Country Of Export:<xsl:value-of select="ConsignmentDetails/CountryOfExp"/></h4>
		    <h4 class="bold" >Company Name :<xsl:value-of select="ConsignmentDetails/CompanyName"/> </h4>
		    <h4 class="bold" >Company Address :<xsl:value-of select="ConsignmentDetails/CompanyAddress"/></h4>
		    <h4 class="bold" >Port Name :<xsl:value-of select="ConsignmentDetails/PortName"/></h4>	    
		  </div>
		     
    
</div>
		
		
		<!-- Product Details start -->
		
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="ConsignmentDetails/TERTIARY != ''">
					<div id="ProductDtls">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
							<div class="float-left"><br></br><h3 class="tittlexsl" style="text-decoration-line: underline;">Product Details</h3></div>
					</div>
					
					
<table id="tbl" class="table table-striped table-bordered dt-responsive nowrap dspit" style="width:100%;margin-top: 1%;word-wrap: break-word;table-layout: fixed;">				   
					   
						  <thead class="theadTransacColor">
						   <tr>
						    <th>Product Name </th>
						    <th>Product code </th>
						    <th>Batch Number </th>
						    <th>Expiry Date </th>
						    <th>PROCUREMENT SOURCE GSTN </th>
						    <th>PROCUREMENT SOURCE NAME And ADDRESS </th>
						   </tr>
						   </thead>
						  
						     
						    
						 
						   <tbody>
						   
						               <xsl:for-each select="//BATCH_NUMBER[not(preceding::BATCH_NUMBER/. = .)]">
						   						 
						     <tr>
						     
						      
						      	<td><xsl:value-of select="../ProductName"/></td>
						        <td><xsl:value-of select="../ProdCode"/></td>
						    	<td><xsl:value-of select="."/></td>
						        <td><xsl:value-of select="../EXPIRY_DATE"/></td>
						        <td><xsl:value-of select="../PROCUREMENT_SOURCE_GSTN"/></td>
						        <td><xsl:value-of select="../PROCUREMENT_SOURCE_NAME"/>,<xsl:value-of select="../PROCUREMENT_SOURCE_ADDRESS"/></td>
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
		
		<div id="tertiary">
		<!-- <xsl:if test="count &gt; 0"> -->
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="ConsignmentDetails/TERTIARY != ''">
					<div id="ProductDtls">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
							<div class="float-left"><h3 class="tittlexsl" style="text-decoration-line: underline;">Tertiary Details</h3></div>
					</div>
					
					
<table id="tbl" class="table table-striped table-bordered dt-responsive nowrap dspit" style="width:100%;margin-top: 1%;word-wrap: break-word;table-layout: fixed;">				   
				   
						  <thead class="theadTransacColor">
						   <tr>
						    <th>TertiaryType </th>
						    <th>SSCC </th>
						    <th>ProductCount </th>
						    <th>Batch Number </th>

						   </tr>
						   </thead>
						  
						     
						    
						 
						   <tbody>
						   
						   
						     <xsl:for-each select="ConsignmentDetails/TERTIARY">
						 
						     <tr>
						     
						      
						      	<td><xsl:value-of select="TertiaryType"/></td>
						        <td><xsl:value-of select="SSCC"/></td>
						    	<td><xsl:value-of select="ProductCount"/></td>
						    	
						        <td><xsl:for-each select="Product/BATCH_NUMBER">
   									<xsl:value-of select="."/>
  								 <xsl:if test="position() != last()">
     						 <xsl:text>,</xsl:text>
   								</xsl:if>
								</xsl:for-each></td>
						        
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
	 	</div>
	 	
	 	<!-- secondary start -->
	 	<div id="secondary">
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="ConsignmentDetails/SEC_LIST != ''">
					<div id="ProductDtls">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
							<div class="float-left"><h3 class="tittle" style="text-decoration-line: underline;">Secondary Details</h3></div>
					</div>
					
					 
				   
				<table id="tbl" class="table table-striped table-bordered dt-responsive nowrap dspit" style="width:100%;margin-top: 1%;word-wrap: break-word;table-layout: fixed;">				   
				   
						  <thead class="theadTransacColor">
						   <tr>
						    <th>Secondary Type </th>
						    <th>SSCC </th>
						    <th>Level </th>
						    <th>Parent Code </th>
						    <th>Code_SNo</th>
						    
						    <th>Batch Number </th>
							<th>Primary Product Count </th>
						   </tr>
						   </thead>
						  
						     
						    
						 
						   <tbody>
						   
						   
						     <xsl:for-each select="//SECONDARY">
						 
						     <tr>
						     
						      
						      	<td><xsl:value-of select="Type"/></td>
						        <td><xsl:value-of select="SSCC"/></td>
						    	<td><xsl:value-of select="Level"/></td>
						    	<td><xsl:value-of select="ParentCD"/></td>
						    	<td><xsl:value-of select="CODE_SNo"/></td>
						        <td><xsl:for-each select="Product/BATCH_NUMBER">
   									<xsl:value-of select="."/>
  								 <xsl:if test="position() != last()">
     						 <xsl:text>,</xsl:text>
   								</xsl:if>
								</xsl:for-each></td>
						        <td><xsl:value-of select="SubCount"/></td>
						        
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
		</div>
	 	<!-- secondary ends -->
	 </xsl:template>
</xsl:stylesheet>