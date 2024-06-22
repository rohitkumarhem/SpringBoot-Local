package com.microservice.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.entity.Employee;
import com.microservice.repository.EmployeeRepo;
import com.microservice.response.EmployeeResponse;

public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public EmployeeResponse getEmployeeById(int id)
	{
		Optional<Employee> employee = employeeRepo.findById(id);
		
		EmployeeResponse employeeResponse= mapper.map(employee, EmployeeResponse.class);
		
		return employeeResponse;
	}
	
}
