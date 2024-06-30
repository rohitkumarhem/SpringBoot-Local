package com.Address.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Address.Entity.Address;
import com.Address.repository.AddressRepo;
import com.Address.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
    private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper mapper;
	
    public AddressResponse findAddressByEmployeeId(int employeeId)
    {
    	  Optional<Address> address = addressRepo.findAddressByEmployeeId(employeeId);
    	  AddressResponse res = mapper.map(address, AddressResponse.class);
    	  
    	  return res;
    }
    
   public Address findAddress(int id)
   {
	 Optional<Address> findId = addressRepo.findById(id);
	 //  AddressResponse res = mapper.map(add, AddressResponse.class);
	   return findId.get();
   }
   
   public AddressResponse createAddress(Address add)
   {
	   Address save = addressRepo.save(add);
	   AddressResponse res = mapper.map(save, AddressResponse.class);
	   
	   return res;
   }

}
