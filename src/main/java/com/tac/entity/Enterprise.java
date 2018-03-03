package com.tac.entity;

public class Enterprise extends Contact{
	
	private long id;
	private String siret;
	
	
	public Enterprise(){}
	
	public Enterprise(String siret){
		this.siret = siret;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
	
}
