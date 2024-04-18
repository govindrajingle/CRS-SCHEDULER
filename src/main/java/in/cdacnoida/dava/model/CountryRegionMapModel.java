package in.cdacnoida.dava.model;

import java.util.List;

public class CountryRegionMapModel {
	
	int region_id;
	int country_id;
	List<String> listExpCountry;
	
	
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	
	public List<String> getListExpCountry() {
		return listExpCountry;
	}
	public void setListExpCountry(List<String> listExpCountry) {
		this.listExpCountry = listExpCountry;
	}
	
	
   	
	
}
