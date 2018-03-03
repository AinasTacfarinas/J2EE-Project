package com.tac.service;

import java.util.ArrayList;

import com.tac.dao.DAOContact;
import com.tac.dao.IDAOContact;
import com.tac.entity.Contact;

public class ContactService {
	public IDAOContact dao;
	public ContactService() {
		dao = new DAOContact();
	}

	public Contact createContact(String firstname,String lastname,String email){
		return dao.createContact(new Contact(firstname, lastname, email));
	}
	
	public boolean deleteContactById(long id) {
		return dao.removeContact(id);
	}
	
	
	public ArrayList<Contact> getContacts(){
		DAOContact daoContact = new DAOContact();
		return daoContact.searchAllContact();
	}
	
	/*
	
	public Contact getContactById(long id){
		DAOContact daoContact = new DAOContact();
		
		
		return daoContact.searchContactById(id);
	}

	public boolean updateContact(Contact c) {
		
		DAOContact daoContact = new DAOContact();
		
		
		return daoContact.updateContact(c);
		
	}
	
	public ArrayList<Contact> getSearchContact(String fname, String lname, String mail) {
		// TODO Auto-generated method stub
		DAOContact daoContact = new DAOContact();
		return daoContact.searchContact(fname,lname,mail);
	}
	*/
}
