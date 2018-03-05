package com.tac.dao;

import java.util.ArrayList;

import com.tac.entity.Contact;

public interface IDAOContact{
	
	public Contact createContact(Contact c);
	
	public boolean removeContact(long id);
	
	public Contact updateContact(Contact c);

	public  ArrayList<Contact> searchAllContact();

	public Contact searchContactById(long id);
}
