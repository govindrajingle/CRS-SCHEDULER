<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	 <xsl:attribute name="name">num_premises_no</xsl:attribute>
	  <!-- <xsl:variable name="set" select="roottag/Sitedtl/Premise/Approval/approval_dtl" />
	  <xsl:variable name="count" select="count($set)" /> -->
	<div class="col-md-12 col-lg-12">	 
	 <div class="row">
	 	<div class="col-lg-3 col-md-6 col-sm-12 col border " ><label class="dvfrm-label">Premise Name : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Premise_Name"/></b></span></div>
		
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Site Type : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Sitetype_Name"/></b></span></div>
	 </div>
	 
	 <div class="row">
	 	<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Site Address : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Site_Address"/></b></span></div>
	 
	 	<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Site Contact Details : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Contact_Dtl"/></b></span></div>
	 </div>
	 
	 <div class="row">
	 
	 	<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Request Date : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Fax_No"/></b></span></div>
		
	 	<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">E mail : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Email"/></b></span></div>
	 </div>
	 
	 <div class="row">
	 
	 	<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">GSTIN Number : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/GSTIN_No"/></b></span></div>
	 
	 	<!-- <div class="col-md-3" ><label class="dvfrm-label">GS1 Number : </label>	</div>
		<div class="col-md-3" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/GS1_No"/></b></span></div> -->
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Contact Person Name : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Contact_Name"/></b></span></div>
		
	 </div>
	 
	 <div class="row">
		
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Contact Person Designation : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Contact_Designation"/></b></span></div>
		
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Contact Person E mail : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Contact_Email"/></b></span></div>
	 </div>
	 
	 <div class="row">
		
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><label class="dvfrm-label">Contact Person Mobile Number : </label>	</div>
		<div class="col-lg-3 col-md-6 col-sm-12 col border" ><span class="lbvalue"><b><xsl:value-of select="roottag/Sitedtl/Premise/Contact_MobNo"/></b></span></div>
	 </div>
	</div> 
	
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
			<div><h3 class="fw-bold mt-4">License Details</h3></div>
	</div>
	<div class="table-responsive">
	  <table id="tb2" class="w-100 table table-striped table-bordered dt-responsive dspit">
   
		  <thead class="theadTransacColor">
		   <tr>
		   	<th>License Type </th>
		    <th>License Number </th>
		    <th>Issuing Authority </th>
		    <th>From Date </th>
		    <th>To Date </th>
		     
		   </tr>
		   </thead>

		   <tbody>
		     <xsl:for-each select="roottag/Sitedtl/Premise/Licence/licence_dtl">
		 
		     <tr>
		     
		      
		      	<td><xsl:value-of select="type_name"/></td>
		        <td><xsl:value-of select="lic_no"/></td>
		    	<td><xsl:value-of select="issuing_auth"/></td>
		        <td><xsl:value-of select="issue_dt"/></td>
		        <td><xsl:value-of select="expiry_dt"/></td>
			</tr>
		       </xsl:for-each>
		       
      

		    </tbody>
    
   
		</table>
		</div>
		
		
		<!-- <xsl:if test="count &gt; 0"> -->
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="roottag/Sitedtl/Premise/Approval/approval_dtl/app_no != ''">
					<div id="approvalDtls">
					<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 reg_col">
							<div class="page-title"><h2 class="fw-bold">Global Regulatory Approval Details</h2></div>
					</div>
					<table id="tbl" class="w-100 table table-striped- table-bordered table-hover table-checkable table-responsive table-responsive-bordered" >
				   
						  <thead class="theadTransacColor">
						   <tr>
						   	<th>Approval Type </th>
						    <th>Approval Number </th>
						    <!-- <th>Issuing Authority </th> -->
						    <th>From Date </th>
						    <th>To Date </th>
						     
						   </tr>
						   </thead>
						  
						     
						    
						 
						   <tbody>
						   
						   
						     <xsl:for-each select="roottag/Sitedtl/Premise/Approval/approval_dtl">
						 
						     <tr>
						     
						      
						      	<td><xsl:value-of select="type_name"/></td>
						        <td><xsl:value-of select="app_no"/></td>
						    	<!-- <td><xsl:value-of select="issuing_auth"/></td> -->
						        <td><xsl:value-of select="issue_dt"/></td>
						        <td><xsl:value-of select="expiry_dt"/></td>
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
	 	
	 </xsl:template>
</xsl:stylesheet>