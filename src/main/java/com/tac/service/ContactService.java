package com.tac.service;

import java.util.ArrayList;

import com.tac.dao.DAOContact;
import com.tac.dao.IDAOContact;
import com.tac.entity.Contact;

public class ContactService {
	private IDAOContact dao;
	public ContactService() {
		dao = new DAOContact();
	}

	public Contact createContact(Contact c){
		return dao.createContact(c);
	}
	
	public boolean deleteContactById(long id) {
		return dao.removeContact(id);
	}
	
	
	public ArrayList<Contact> getContacts(){
		return dao.searchAllContact();
	}
	
	
	
	public Contact getContactById(long id){
		return dao.searchContactById(id);
	}
	
	
	
	public Contact updateContact(Contact c) {	
		
		return dao.updateContact(c);
		
	}
	
	/*
	public ArrayList<Contact> getSearchContact(String fname, String lname, String mail) {
		// TODO Auto-generated method stub
		DAOContact daoContact = new DAOContact();
		return daoContact.searchContact(fname,lname,mail);
	}
	*/
	
	public ArrayList<Contact> getSearchAllContact() {
		// TODO Auto-generated method stub
		DAOContact daoContact = new DAOContact();
		return daoContact.searchAllContact();
	}
}
