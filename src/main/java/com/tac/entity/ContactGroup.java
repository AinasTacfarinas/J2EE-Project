package com.tac.entity;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {
	private long id;
	private String name;
	HashSet<Contact> contacts;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ContactGroup() {}
	
	public ContactGroup(String groupname) {
		this.name = groupname;
		this.contacts = new HashSet<Contact>();
	}
	
	public long getID() {
		return this.id;
	}
	
	public String getGroupName() {
		return this.name;
	}
	
	public Set<Contact> getContacts() {
		return this.contacts;
	}
	
	public void setID(long id) {
		this.id = id;
	}
	
	public void setGroupName(String groupname) {
		this.name = groupname;
	}
	
	public void setContacts(HashSet<Contact> contacts) {
		this.contacts = contacts;
	}
}
