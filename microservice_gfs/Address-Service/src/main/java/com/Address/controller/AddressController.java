package com.Address.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Address.Entity.Address;
import com.Address.response.AddressResponse;
import com.Address.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
//	@GetMapping("/address/{employeeId}")
//	public ResponseEntity<AddressResponse> getEmployeeAddressByEmployeeId(@PathVariable("employeeId") int employeeId)
//	{
//		AddressResponse res = addressService.findAddressByEmployeeId(employeeId);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(res);
//	}
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> findAddress(@PathVariable("employeeId") int employeeId)
	{
		AddressResponse res = addressService.findAddressByEmployeeId(employeeId);
		
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@PostMapping("/address")
	public ResponseEntity<AddressResponse> createAddress(@RequestBody Address add)
	{
		AddressResponse createadd = addressService.createAddress(add);
		return ResponseEntity.status(HttpStatus.OK).body(createadd);
	}
}
