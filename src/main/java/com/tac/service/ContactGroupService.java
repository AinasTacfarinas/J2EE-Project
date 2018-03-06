package com.tac.service;

import java.util.Set;

import com.tac.dao.DAOContactGroup;
import com.tac.dao.IDAOContactGroup;
import com.tac.entity.ContactGroup;


public class ContactGroupService {
	private IDAOContactGroup dao;
	public ContactGroupService() {
		dao = new DAOContactGroup();
	}

	public ContactGroup createContactGroup(ContactGroup cg){
		return dao.createContactGroup(cg);
	}
	
	public boolean deleteContactGroupById(long id) {
		return dao.removeContactGroup(id);
	}
	
	public boolean updateContactGroup(ContactGroup cg) {
		return dao.updateContactGroup(cg);
	}
	
	
	public Set<ContactGroup> getContactGroups(){
		return dao.searchAllContactGroup();
	}
	
	public ContactGroup getContactGroupById(long id){
		return dao.searchContactGroupById(id);
	}
	
	public ContactGroup getContactGroupByName(String name){
		return dao.searchContactGroupByName(name);
	}
	
}
