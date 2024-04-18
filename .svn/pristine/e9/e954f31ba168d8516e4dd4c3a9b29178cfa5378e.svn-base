<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	<div id="details">
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div class="float-left"><h3 class="tittle" >Product Details</h3></div>
	</div>
	
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 " style="padding-top: 10px;border: 2px solid;border-radius: 12px;">
   				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-6" >
		   	<h4 class="bold">FILE NAME :<xsl:value-of select="MANUFACTURER_LIST/FILENAME"/></h4> 
		   	<h4 class="bold" >MANUFACTURER_CODE:<xsl:value-of select="MANUFACTURER_LIST/MANF_CODE"/> </h4>
		  </div>
		     
    
</div>
		
		
		
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="MANUFACTURER_LIST/MANUFACTURER != ''">
					<div id="ProductDtls">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
							<div class="float-left"><br></br><h3 class="tittlexsl" style="text-decoration-line: underline;">MANUFACTURER LIST</h3></div>
					</div>
					
					
<table id="tbl" class="table table-striped table-bordered dt-responsive nowrap dspit" style="width:100%;margin-top: 1%;word-wrap: break-word;table-layout: fixed;">				   
					   
						  <thead class="theadTransacColor">
						   <tr>
						   <th>SITE_TYPE</th>
						   <th>PREMISE_NAME</th>
						    <th>PREMISE_ADD </th>
						    <th>PREMISE_STATE </th>
						    <th>PREMISE_DISTRICT</th>
						    <th>PREMISE_POSTAL_CODE</th>
						    <th>PREMISE_CONTACT_NO</th>
						    <th>PREMISE_FAX_NO</th>
						    <th>SITE_EMAIL</th>
						    <th>GLN_NO</th>
						    <th>MANF_NAME</th>
						     <th>MANF_CONTACT</th>
						      <th>MANF_DESIG</th>
						       <th>MANF_EMAL</th>
						        <th>MANF_LICN</th>
						   </tr>
						   </thead>
						  
						     
						    
						 
						   <tbody>
						   
						               <xsl:for-each select="//MANUFACTURER">
						   						 
						     <tr>
						     
						      
						      	<td><xsl:value-of select="SITE_TYPE"/></td>
						        <td><xsl:value-of select="PREMISE_NAME"/></td>
						    	<td><xsl:value-of select="PREMISE_ADD"/></td>
						        <td><xsl:value-of select="PREMISE_STATE"/></td>
						        <td><xsl:value-of select="PREMISE_DISTRICT"/></td>
						        <td><xsl:value-of select="PREMISE_POSTAL_CODE"/></td>
						        <td><xsl:value-of select="PREMISE_CONTACT_NO"/></td>
						        <td><xsl:value-of select="PREMISE_FAX_NO"/></td>
						        <td><xsl:value-of select="SITE_EMAIL"/></td>
						        <td><xsl:value-of select="GLN_NO"/></td>
						        <td><xsl:value-of select="MANF_NAME"/></td>
						         <td><xsl:value-of select="MANF_CONTACT"/></td>
						          <td><xsl:value-of select="MANF_DESIG"/></td>
						           <td><xsl:value-of select="MANF_EMAL"/></td>
						            <td><xsl:value-of select="MANF_LICN"/></td>
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
		


	 </xsl:template>
</xsl:stylesheet>