package com.tac.entity;

public class Address {
	
	private long id;
	private String street;
	private String city;
	private String country;
	private Contact contact;
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address() {}
	
	public Address(String street, String city,String country) {
		this.street = street;
		this.city = city;
		this.country = country;
	}
	
	public long getAddressID() {
		return this.id;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public String getCity() {
		return this.city;
	}
	
	
	public void setAddressID(long id) {
		this.id = id;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
