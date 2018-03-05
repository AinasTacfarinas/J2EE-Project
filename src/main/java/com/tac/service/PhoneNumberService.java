package com.tac.service;

import com.tac.dao.DAOPhoneNumber;
import com.tac.dao.IDAOPhoneNumber;
import com.tac.entity.PhoneNumber;

public class PhoneNumberService {
	private IDAOPhoneNumber dao;
	
	public PhoneNumberService() {
		dao = new DAOPhoneNumber();
	}
	
	public PhoneNumber createPhoneNumber(PhoneNumber c) {
		return dao.createPhoneNumber(c);
	}

	public boolean removePhoneNumber(long id) {
		return dao.removePhoneNumber(id);
	}

	public PhoneNumber updatePhoneNumber(PhoneNumber c) {
		return dao.updatePhoneNumber(c);
	}

	public PhoneNumber searchPhoneNumberById(long id) {
		return dao.searchPhoneNumberById(id);
	}
	
	
}
