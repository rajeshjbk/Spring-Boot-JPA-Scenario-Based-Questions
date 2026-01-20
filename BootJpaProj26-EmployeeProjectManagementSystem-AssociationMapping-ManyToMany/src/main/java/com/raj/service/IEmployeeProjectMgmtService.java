package com.raj.service;

import java.util.List;

import com.raj.entity.Employee;
import com.raj.entity.Project;

public interface IEmployeeProjectMgmtService {

	String addEmployees(List<Employee> employees);
	String addProjects(List<Project> projects);
	
	String assignOneEmployeeToMulProjects(Integer empId, List<Integer> projectIds);
	String assignOneProjectToMulEmployees(Integer projectId, List<Integer> employeeIds);
	
	List<Employee> showEmployeesWithTheirProjects();
	List<Project> showProjectsWithAssignedEmployees();
}
