package com.raj.repository;

import org.springframework.data.repository.CrudRepository;

import com.raj.entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

	
}
