
package in.cdacnoida.dava.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "envelope" })
@XmlRootElement(name = "PRODUCTS_LIST")
public class PRODUCTSLIST {

	@XmlElement(name = "ENVELOPE", required = true)
	protected PRODUCTSLIST.ENVELOPE envelope;

	public PRODUCTSLIST.ENVELOPE getENVELOPE() {
		return envelope;
	}

	public void setENVELOPE(PRODUCTSLIST.ENVELOPE value) {
		this.envelope = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "filename", "manufacturercode", "product" })
	public static class ENVELOPE {

		@XmlElement(name = "FILENAME", required = true)
		protected String filename;
		@XmlElement(name = "MANUFACTURER_CODE", required = true)
		protected String manufacturercode;
		@XmlElement(name = "PRODUCT", required = true)
		protected List<PRODUCTSLIST.ENVELOPE.PRODUCT> product;

		public String getFILENAME() {
			return filename;
		}

		public void setFILENAME(String value) {
			this.filename = value;
		}

		public String getMANUFACTURERCODE() {
			return manufacturercode;
		}

		public void setMANUFACTURERCODE(String value) {
			this.manufacturercode = value;
		}

		public List<PRODUCTSLIST.ENVELOPE.PRODUCT> getPRODUCT() {
			if (product == null) {
				product = new ArrayList<PRODUCTSLIST.ENVELOPE.PRODUCT>();
			}
			return this.product;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "producttype", "productcode", "productname", "genericname", "composition",
				"scheduled", "usage", "remark", "hscode" })
		public static class PRODUCT {

			@XmlElement(name = "PRODUCT_TYPE")
			protected String producttype;
			@XmlElement(name = "ProductCode", required = true)
			protected String productcode;
			@XmlElement(name = "PRODUCT_NAME", required = true)
			protected String productname;
			@XmlElement(name = "GENERIC_NAME", required = true)
			protected String genericname;
			@XmlElement(name = "COMPOSITION", required = true)
			protected String composition;
			@XmlElement(name = "SCHEDULED", required = true)
			protected String scheduled;
			@XmlElement(name = "USAGE", required = true)
			protected String usage;
			@XmlElement(name = "REMARK", required = true)
			protected String remark;
			@XmlElement(name = "HS_CODE", required = true)
			protected String hscode;

			public String getPRODUCTTYPE() {
				return producttype;
			}

			public void setPRODUCTTYPE(String value) {
				this.producttype = value;
			}

			public String getPRODUCTCODE() {
				return productcode;
			}

			public void setPRODUCTCODE(String value) {
				this.productcode = value;
			}

			public String getPRODUCTNAME() {
				return productname;
			}

			public void setPRODUCTNAME(String value) {
				this.productname = value;
			}

			public String getGENERICNAME() {
				return genericname;
			}

			public void setGENERICNAME(String value) {
				this.genericname = value;
			}

			public String getCOMPOSITION() {
				return composition;
			}

			public void setCOMPOSITION(String value) {
				this.composition = value;
			}

			public String getSCHEDULED() {
				return scheduled;
			}

			public void setSCHEDULED(String value) {
				this.scheduled = value;
			}

			public String getUSAGE() {
				return usage;
			}

			public void setUSAGE(String value) {
				this.usage = value;
			}

			public String getREMARK() {
				return remark;
			}

			public void setREMARK(String value) {
				this.remark = value;
			}

			public String getHSCODE() {
				return hscode;
			}

			public void setHSCODE(String value) {
				this.hscode = value;
			}

		}

	}

}
