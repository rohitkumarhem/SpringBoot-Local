package com.microserviceExp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceExp.Entity.Employee;
import com.microserviceExp.response.EmployeeResponse;
import com.microserviceExp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	private ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee emp)
	{
		EmployeeResponse empRes= employeeService.createEmployee(emp);
		return ResponseEntity.status(HttpStatus.OK).body(empRes);
	}
	
	@GetMapping("/employees/{id}")
	private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id)
	{
		EmployeeResponse employee = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

}
