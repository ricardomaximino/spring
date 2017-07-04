package com.brasajava.business.registration;

public class Address {

	private long id;
	private String country;
	private String state;
	private String city;
	private String town;
	private String neighborhood;
	private String street;
	
	public Address(){
		
	}
	
	public Address(long id,String country,String state,String city,String town,String neighborhood,String street){
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.town = town;
		this.neighborhood = neighborhood;
		this.street = street;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", state=" + state + ", city=" + city + ", town=" + town
				+ ", neighborhood=" + neighborhood + ", street=" + street + "]";
	}
	
}
