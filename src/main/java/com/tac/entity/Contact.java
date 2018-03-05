package com.tac.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;



@Entity
@Table(name = "CONTACT")
public class Contact{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contact_id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private Set<PhoneNumber> phoneNumbers;
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	private Address address;
	
	/*
	private Set<ContactGroup> groups;
	*/
	
	public Contact() {}
	
	public Contact(String firstname, String lastname, String email) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		//this.groups = new HashSet<ContactGroup>();
		this.phoneNumbers = new HashSet<PhoneNumber>();
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
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public void setPhoneNumbers(Set<PhoneNumber> phones) {
		this.phoneNumbers = phones;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	/*
	
	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}
	
	
	
	
	public Set<ContactGroup> getGroups() {
		return this.groups;
	}
	
	
	*/
}