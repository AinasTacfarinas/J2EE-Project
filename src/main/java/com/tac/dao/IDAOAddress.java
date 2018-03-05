package com.tac.dao;

import com.tac.entity.Address;

public interface IDAOAddress {
	
	public Address createAddress(Address a);
	
	public boolean removeAddress(long id);
	
	public Address updateAddress(Address a);

	public Address searchAddressById(long id);
}
