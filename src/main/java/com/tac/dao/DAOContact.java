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
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(session.get(Contact.class, id));
		session.getTransaction().commit();
		return false;
	}

	@Override
	public Contact updateContact(Contact c) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public ArrayList<Contact> searchAllContact() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ArrayList<Contact> res = (ArrayList<Contact>)session.createQuery("from Contact").list();
		session.getTransaction().commit();
		return res;
	}

	public Contact searchContactById(long id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Contact c = (Contact)session.get(Contact.class, id);
		session.getTransaction().commit();
		return c;
	}

}
