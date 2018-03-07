package com.tac.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "CONTACT")
public class Contact{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contact_id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "contact")
	private Set<PhoneNumber> phoneNumbers;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	private Address address;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable (
		       name="CONTACTGROUP_CONTACT",
		       joinColumns = {@JoinColumn(name="contactgroup_id")},
		       inverseJoinColumns = {@JoinColumn(name="contact_id")}
		   )
	private Set<ContactGroup> groups;
	
	public Contact() {
		this.groups = new HashSet<ContactGroup>();
		this.phoneNumbers = new HashSet<PhoneNumber>();
	}
	
	public Contact(String firstname, String lastname, String email) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.groups = new HashSet<ContactGroup>();
		this.phoneNumbers = new HashSet<PhoneNumber>();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
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
	
	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}
	
	public Set<ContactGroup> getGroups() {
		return this.groups;
	}
	
}