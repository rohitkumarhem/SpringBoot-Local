package com.Address.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Address.service.AddressService;

@Configuration
public class AddressConfig {
	
	@Bean
	public ModelMapper modelMapperBean()
	{
		return new ModelMapper();
	}
	
	@Bean
	public AddressService addressServiceBean()
	{
		return new AddressService();
	}

}
