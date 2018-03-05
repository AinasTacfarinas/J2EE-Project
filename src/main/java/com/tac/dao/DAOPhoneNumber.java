package com.tac.dao;

import org.hibernate.Session;

import com.tac.entity.PhoneNumber;
import com.tac.util.HibernateUtil;

public class DAOPhoneNumber implements IDAOPhoneNumber{
	
	
	@Override
	public PhoneNumber createPhoneNumber(PhoneNumber pn) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(pn);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public boolean removePhoneNumber(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(session.get(PhoneNumber.class, id));
		session.getTransaction().commit();
		return false;
	}

	@Override
	public PhoneNumber updatePhoneNumber(PhoneNumber pn) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(pn);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public PhoneNumber searchPhoneNumberById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		PhoneNumber pn = (PhoneNumber)session.get(PhoneNumber.class, id);
		session.getTransaction().commit();
		return pn;
	}

}
