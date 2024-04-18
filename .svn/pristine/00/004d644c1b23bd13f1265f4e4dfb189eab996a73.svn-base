<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	 <xsl:attribute name="name">num_upload_id</xsl:attribute>
	 <div class="row">
	 	<div class="col-lg-6" ><h4><b>Consignment Details</b></h4>	</div>
	</div>
	<div class="responsive">
	 <table id="tbl" class="table table-striped- table-bordered table-hover table-checkable responTable table-responsive table-responsive-bordered table-scroll" >
		  <thead class="theadTransacColor">
		   <tr>
		    <th>S. No.</th>
		    <th>E-Way Bill No.</th>
		    <th>Bill Date</th>
		    <th>Region</th>
		    <th>Country of Exp.</th>
		    <th>Source Port</th>
		    <th>Landing Port</th>
		    <th>Primary Count</th>
		    <th>S1 Count</th>
		    <th>S2 Count</th>
		    <th>S3 Count</th>
		    <th>Tertiary Count</th>
		   </tr>
		   </thead>
		   <tbody>
		     <xsl:for-each select="roottag/uploaddtl/consigndtl/cosignment">
		     <tr>
		        <td><xsl:value-of select="slno"/></td>
		    	<td><xsl:value-of select="str_invoice_no"/></td>
		        <td><xsl:value-of select="dt_inv_date"/></td>
		        <td><xsl:value-of select="str_region_cd"/></td>
		    	<td><xsl:value-of select="str_country_of_exp"/></td>
		        <td><xsl:value-of select="str_source_portname"/></td>
		        <td><xsl:value-of select="str_landing_portname"/></td>
		    	<td><xsl:value-of select="num_primary_count"/></td>
		        <td><xsl:value-of select="num_s1_count"/></td>
		        <td><xsl:value-of select="num_s2_count"/></td>
		    	<td><xsl:value-of select="num_s3_count"/></td>
		        <td><xsl:value-of select="num_tertiary_count"/></td>
			</tr>
		       </xsl:for-each>
		    </tbody>
		</table>
		</div>
		<br>
		</br>
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="roottag/uploaddtl/podtl/po/str_po_no != ''">
					<div class="row">
					 	<div class="col-lg-6" ><h4><b>Purchase Order Details</b></h4>	</div>
					</div>
					<div class="responsive">
					<table id="tb2" class="table table-striped- table-bordered table-hover table-checkable responTable table-responsive table-responsive-bordered table-scroll">
					  <thead class="theadTransacColor">
					   <tr>
					    <th>S. No.</th>
					    <th>Purchase Order No.</th>
					    <th>Purchase Order Date</th>
					    <th>Company Name</th>
					    <th>Company Add.</th>
					    <th>Country</th>
					   </tr>
					   </thead>
					   <tbody>
					     <xsl:for-each select="roottag/uploaddtl/podtl/po">
					     <tr>
					        <td><xsl:value-of select="slno"/></td>
					    	<td><xsl:value-of select="str_po_no"/></td>
					        <td><xsl:value-of select="dt_po_date"/></td>
					        <td><xsl:value-of select="str_company_name"/></td>
					    	<td><xsl:value-of select="str_company_add"/></td>
					        <td><xsl:value-of select="str_country_name"/></td>
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
		<br>
		</br>
		<span style="font-weight: normal;">
			<xsl:choose>
				<xsl:when test="roottag/uploaddtl/invoicedtl/invoice/str_inv_no != ''">
					<div class="row">
					 	<div class="col-lg-6" ><h4><b>Invoice Details</b></h4>	</div>
					</div>
					<div class="responsive">
					<table id="tb3" class="table table-striped table-bordered dt-responsive nowrap dspit dataTable no-footer dtr-inline collapsed" align="center">
					  <thead class="theadTransacColor">
					   <tr>
					    <th>S. No.</th>
					    <th>Invoice No.</th>
					    <th>Invoice Date</th>
					    <th>Purchase Order No.</th>
					   </tr>
					   </thead>
					   <tbody>
					     <xsl:for-each select="roottag/uploaddtl/invoicedtl/invoice">
					     <tr>
					        <td><xsl:value-of select="slno"/></td>
					    	<td><xsl:value-of select="str_inv_no"/></td>
					        <td><xsl:value-of select="dt_inv_date"/></td>
					        <td><xsl:value-of select="str_po_no"/></td>
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