package com.tac.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTGROUP")
public class ContactGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactgroup_id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (
		       name="CONTACTGROUP_CONTACT",
		       joinColumns = {@JoinColumn(name="contact_id")},
		       inverseJoinColumns = {@JoinColumn(name="contactgroup_id")}
		   )
	Set<Contact> contacts;
	
	public ContactGroup() {}
	
	public ContactGroup(String groupname) {
		this.name = groupname;
		this.contacts = new HashSet<Contact>();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ContactGroup other = (ContactGroup) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getID() {
		return this.contactgroup_id;
	}
	
	public String getGroupName() {
		return this.name;
	}
	
	public Set<Contact> getContacts() {
		return this.contacts;
	}
	
	public void setID(long id) {
		this.contactgroup_id = id;
	}
	
	public void setGroupName(String groupname) {
		this.name = groupname;
	}
	
	public void setContacts(HashSet<Contact> contacts) {
		this.contacts = contacts;
	}
}
