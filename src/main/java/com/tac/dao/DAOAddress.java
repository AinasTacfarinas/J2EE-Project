package com.tac.dao;

import org.hibernate.Session;

import com.tac.entity.Address;
import com.tac.util.HibernateUtil;

public class DAOAddress implements IDAOAddress{

	@Override
	public Address createAddress(Address a) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public boolean removeAddress(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(session.get(Address.class, id));
		session.getTransaction().commit();
		return false;
	}

	@Override
	public Address updateAddress(Address a) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(a);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Address searchAddressById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Address a = (Address)session.get(Address.class, id);
		session.getTransaction().commit();
		return a;
	}

}
