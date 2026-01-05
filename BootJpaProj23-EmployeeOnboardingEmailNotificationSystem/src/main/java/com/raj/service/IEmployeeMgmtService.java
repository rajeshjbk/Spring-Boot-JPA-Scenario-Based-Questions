package com.raj.service;

import org.springframework.data.domain.Page;

import com.raj.entity.Employee;

public interface IEmployeeMgmtService {

	String addEmployee(Employee employee);
	
	Page<Employee> getEmployeesByPaginationAndSorting(int pageNo, int pageSize, boolean ascOrder,
			String... props);	
}
