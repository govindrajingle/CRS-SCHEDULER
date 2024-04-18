package in.cdacnoida.dava.model;

import java.util.Date;

public class SolrSearchModel {

	
	private String freshImport;
	private Date fromDate;
	private Date toDate;
	private String query;
	
	public String getFreshImport() {
		return freshImport;
	}

	public void setFreshImport(String freshImport) {
		this.freshImport = freshImport;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	
	

}
