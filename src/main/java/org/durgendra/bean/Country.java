package org.durgendra.bean;

public class Country{
	
	Long id;
	String countryName;	
	long population;
	
	public Country() {
		super();
	}
	public Country(Long i, String countryName,long population) {
		super();
		this.id = i;
		this.countryName = countryName;
		this.population=population;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}	
	
}