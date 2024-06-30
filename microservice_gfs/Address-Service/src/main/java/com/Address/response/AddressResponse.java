package com.Address.response;

public class AddressResponse {
  
	private int id;
	private String state;
	private String city;
	public AddressResponse() {
		super();
	}
	public AddressResponse(int id, String state, String city) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
