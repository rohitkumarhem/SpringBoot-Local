package com.microserviceExp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microserviceExp.Entity.Employee;
import com.microserviceExp.repository.EmployeeRepo;
import com.microserviceExp.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public EmployeeResponse getEmployeeById(int id)
	{
		Optional<Employee> employee = employeeRepo.findById(id);
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
		
		return employeeResponse;
	}

}
