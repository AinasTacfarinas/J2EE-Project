package com.tac.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID")
	private long contact_id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	/*
	private Set<ContactGroup> groups;
	private Set<PhoneNumber> phoneNumbers;
	private Address address;
	*/
	
	public Contact() {}
	
	public Contact(String firstname, String lastname, String email) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		//this.groups = new HashSet<ContactGroup>();
		//this.phoneNumbers = new HashSet<PhoneNumber>();
	}
	

	public long getContact_id() {
		return this.contact_id;
	}
	
	public void setContact_id(long id) {
		this.contact_id = id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}

	
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	
	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public void setPhoneNumbers(Set<PhoneNumber> phones) {
		this.phoneNumbers = phones;
	}
	
	public Set<ContactGroup> getGroups() {
		return this.groups;
	}
	
	public Address getAddress() {
		return this.address;
	}
	*/
}