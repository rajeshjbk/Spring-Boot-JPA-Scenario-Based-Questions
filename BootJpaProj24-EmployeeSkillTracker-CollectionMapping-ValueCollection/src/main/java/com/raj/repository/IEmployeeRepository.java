package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.EmployeeInfo;

public interface IEmployeeRepository extends JpaRepository<EmployeeInfo, Long> {

}
