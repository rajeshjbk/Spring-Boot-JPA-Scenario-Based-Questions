package com.raj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.raj.entity.Employee;
import com.raj.service.IEmployeeMgmtService;

@Controller
public class EmployeeMgmtController {

	@Autowired
	private IEmployeeMgmtService empService;
	
	public String addNewEmployee(Employee emp) {
		
		return empService.addEmployee(emp);
	}
	
	public Page<Employee> getEmployeesByPaginationAndSorting(int pageNo, int pageSize, boolean ascOrder,
			String... props){
		
		return empService.getEmployeesByPaginationAndSorting(pageNo, pageSize, ascOrder, props);
	}
}
