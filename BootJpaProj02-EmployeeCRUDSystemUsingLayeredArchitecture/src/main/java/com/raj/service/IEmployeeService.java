package com.raj.service;

import java.util.List;
import java.util.Optional;

import com.raj.entity.Employee;

public interface IEmployeeService {

	String createEmployee(Employee employee);

    String createMultipleEmployees(List<Employee> employees);

	Optional<Employee> getEmployee(Integer id);

	List<Employee>getAllEmployees();
	
	String updateEmployee(Integer id);

	Boolean employeeExists(Integer id);

	long getEmployeeCount();


}
