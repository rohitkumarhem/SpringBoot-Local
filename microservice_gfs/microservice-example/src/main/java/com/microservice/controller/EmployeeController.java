package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.response.EmployeeResponse;
import com.microservice.service.EmployeeService;

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id")int id)
	{
	EmployeeResponse employeeResponse =	employeeService.getEmployeeById(id);
	   
	return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
	
}
