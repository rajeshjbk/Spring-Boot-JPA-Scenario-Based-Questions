package com.raj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.raj.entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer>,PagingAndSortingRepository<Employee, Integer> {

}
