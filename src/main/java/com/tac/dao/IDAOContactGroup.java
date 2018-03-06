package com.tac.dao;


import java.util.Set;

import com.tac.entity.ContactGroup;


public interface IDAOContactGroup {
	public ContactGroup createContactGroup(ContactGroup cg);
	
	public boolean removeContactGroup(long id);
	
	public boolean updateContactGroup(ContactGroup cg);

	public Set<ContactGroup> searchAllContactGroup();

	public ContactGroup searchContactGroupById(long id);

	public ContactGroup searchContactGroupByName(String name);
}
