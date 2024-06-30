package com.Address.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Address.Entity.Address;
import com.Address.response.AddressResponse;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	@Query(nativeQuery = true,
			value="select ea.id, ea.state, ea.city from microservices.address ea join microservices.employee em on ea.id = em.id where ea.employee_id=:employeeId")
     Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
