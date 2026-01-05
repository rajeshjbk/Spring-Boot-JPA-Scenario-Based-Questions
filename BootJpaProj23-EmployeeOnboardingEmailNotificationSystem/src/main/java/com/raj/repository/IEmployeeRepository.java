package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
