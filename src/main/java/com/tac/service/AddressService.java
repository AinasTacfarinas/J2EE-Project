package com.tac.service;


import com.tac.dao.DAOAddress;
import com.tac.dao.IDAOAddress;
import com.tac.entity.Address;

public class AddressService {
	
	
	private IDAOAddress dao;
	public AddressService() {
		dao = new DAOAddress();
	}

	public Address createAddress(Address c){
		return dao.createAddress(c);
	}
	
	public Address updateContact(Address a) {
		return dao.updateAddress(a);
	}
	
	public boolean deleteContactById(long id) {
		return dao.removeAddress(id);
	}
	
	public Address getAddressById(long id){
		return dao.searchAddressById(id);
	}
}
