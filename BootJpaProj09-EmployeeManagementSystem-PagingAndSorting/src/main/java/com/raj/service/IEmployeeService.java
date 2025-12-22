package com.raj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.raj.entity.Employee;

public interface IEmployeeService {

	String createEmployee(Employee employee);

    String createMultipleEmployees(List<Employee> employees);

	Optional<Employee> getEmployee(Integer id);

	List<Employee>getAllEmployees();
	
	String updateEmployee(Integer id);

	Boolean employeeExists(Integer id);

	long getEmployeeCount();

	Page<Employee> fetchEmployeesByPageAndSort(int pageNo, int pageSize, boolean ascOrder,String ...props);
	Iterable<Employee> sortBySalary(boolean ascOrder,String salary);
	Iterable<Employee> sortByDateOfJoining(boolean ascOrder,String dateOfJoining);

}
