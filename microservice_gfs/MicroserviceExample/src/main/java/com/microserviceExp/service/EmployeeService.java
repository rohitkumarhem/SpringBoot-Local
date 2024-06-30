package com.microserviceExp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microserviceExp.Entity.Employee;
import com.microserviceExp.feignclient.AddressClient;
import com.microserviceExp.repository.EmployeeRepo;
import com.microserviceExp.response.AddressResponse;
import com.microserviceExp.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AddressClient addressClient;
	
	
	public EmployeeResponse getEmployeeById(int id)
	{		 
		Optional<Employee> findId = employeeRepo.findById(id);
		//Employee employee = findId.get();
		EmployeeResponse employee = mapper.map(findId, EmployeeResponse.class);
		ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
		
		employee.setAddressResponse(addressResponse.getBody());
		
		return employee;
		
	}
	
	public EmployeeResponse createEmployee(Employee emp)
	{
		try
		{
		 employeeRepo.save(emp);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		EmployeeResponse empRes = mapper.map(emp, EmployeeResponse.class);
		
		return empRes;
	}

}
