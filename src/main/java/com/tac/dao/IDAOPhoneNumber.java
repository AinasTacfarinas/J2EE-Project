package com.tac.dao;

import com.tac.entity.PhoneNumber;



public interface IDAOPhoneNumber {
	
	public PhoneNumber createPhoneNumber(PhoneNumber pn);
	
	public boolean removePhoneNumber(long id);
	
	public PhoneNumber updatePhoneNumber(PhoneNumber pn);

	public PhoneNumber searchPhoneNumberById(long id);
}
