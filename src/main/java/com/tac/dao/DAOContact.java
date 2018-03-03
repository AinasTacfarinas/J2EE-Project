package com.tac.dao;

import java.util.ArrayList;

import org.hibernate.Session;

import com.tac.entity.Contact;
import com.tac.util.HibernateUtil;

public class DAOContact implements IDAOContact{

	@Override
	public Contact createContact(Contact c) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public boolean removeContact(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contact updateContact(long id, String firstname, String lastname, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contact> searchAllContact() {
		// TODO Auto-generated method stub
		return null;
	}

}
