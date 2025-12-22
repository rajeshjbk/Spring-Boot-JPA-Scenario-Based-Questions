package com.raj.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.raj.entity.Employee;
import com.raj.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	public String createEmployee(Employee emp) {
		
		return service.createEmployee(emp);
	}
	
	public String createMultipleEmployees(List<Employee> list){
		
		return service.createMultipleEmployees(list);
	}
	
	public Optional<Employee> getEmployee(Integer id) {
		
		return service.getEmployee(id);
	}
	
	public List<Employee> getAllEmployees(){
		
		return service.getAllEmployees();
	}
	
	public boolean employeeExists(Integer id) {
		
		return service.employeeExists(id);
	}
	
	public long getEmployeeCount() {
		
		return service.getEmployeeCount();
	}

	public String updateEmployee(Integer id) {
		
		return service.updateEmployee(id);
	}
	
	public Page<Employee> fetchEmployeesByPageAndSort(int pageNo, int pageSize, boolean ascOrder,String ...props){
		
		return service.fetchEmployeesByPageAndSort(pageNo, pageSize, ascOrder, props);
	}
	
	public Iterable<Employee> sortBySalary(boolean ascOrder, String salary) {
		
		return service.sortBySalary(ascOrder, salary);
		
	}
	
	public Iterable<Employee> sortByDateOfJoining(boolean ascOrder,String dateOfJoining){
		
		return service.sortByDateOfJoining(ascOrder, dateOfJoining);
	
	}
}
