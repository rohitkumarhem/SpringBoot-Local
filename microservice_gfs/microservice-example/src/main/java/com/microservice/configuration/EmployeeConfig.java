package com.microservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice.service.EmployeeService;

@Configuration
public class EmployeeConfig {
	
	@Bean
	public EmployeeService employeeBean()
	{
		return new EmployeeService();
	}
	
	@Bean	
	public ModelMapper modelMapperBean()
	{
		return new ModelMapper();
	}

}
