package com.microserviceExp.Entity;



import com.microserviceExp.response.AddressResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="age")
	private String age;
	
	@Transient
	private AddressResponse addressResponse;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AddressResponse getAddressResponse() {
		return addressResponse;
	}



	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}



	public Employee(int id, String name, String email, String age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}
	
    
	
}
