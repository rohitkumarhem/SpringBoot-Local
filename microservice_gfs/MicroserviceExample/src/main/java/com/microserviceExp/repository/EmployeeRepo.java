package com.microserviceExp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microserviceExp.Entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
