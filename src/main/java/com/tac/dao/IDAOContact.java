package com.tac.dao;

import java.util.ArrayList;

import com.tac.entity.Contact;

public interface IDAOContact{
	
	public Contact createContact(Contact c);
	
	public boolean removeContact(long id);
	
	public Contact updateContact(long id, String firstname, String lastname, String email);

	public  ArrayList<Contact> searchAllContact();
}
