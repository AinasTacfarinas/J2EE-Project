package com.tac.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.tac.entity.ContactGroup;
import com.tac.util.HibernateUtil;

public class DAOContactGroup implements IDAOContactGroup{

	@Override
	public ContactGroup createContactGroup(ContactGroup cg) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cg);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public boolean removeContactGroup(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(session.get(ContactGroup.class, id));
		session.getTransaction().commit();
		return false;
	}

	@Override
	public boolean updateContactGroup(ContactGroup cg) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(cg);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Set<ContactGroup> searchAllContactGroup() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Set<ContactGroup> res = new HashSet(session.createQuery("from ContactGroup").list());
		session.getTransaction().commit();
		return res;
	}

	@Override
	public ContactGroup searchContactGroupById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ContactGroup cg = (ContactGroup)session.get(ContactGroup.class, id);
		session.getTransaction().commit();
		return cg;
	}

	@Override
	public ContactGroup searchContactGroupByName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		ContactGroup cg = (ContactGroup)session.createQuery("from ContactGroup C where C.name='"+name+"'").list().get(0);
		session.getTransaction().commit();
		return cg;
	}

}
