package com.raj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Employee;
import com.raj.entity.Project;
import com.raj.repository.IEmployeeRepository;
import com.raj.repository.IProjectRepository;

import jakarta.transaction.Transactional;
@Service
public class EmployeeProjectMgmtService implements IEmployeeProjectMgmtService {

	@Autowired
	private IProjectRepository projectRepo;
	
	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Override
	public String addEmployees(List<Employee> employees) {
		
		List<Employee> saveAllEmployees = employeeRepo.saveAll(employees);
		List<Integer> ids = saveAllEmployees.stream().map(Employee::getEmpId).collect(Collectors.toList());
		return ids.size()+" no.of Employees are added with Emp ID: "+ids;
	}

	@Override
	public String addProjects(List<Project> projects) {
		
		List<Project> saveAllProjects = projectRepo.saveAll(projects);
		
		List<Integer> pIds = saveAllProjects.stream().map(Project::getProjId).collect(Collectors.toList());
		
		return pIds+" no.of Projects are added with Project ID: "+pIds;
	}

	@Override
	@Transactional
	public String assignOneEmployeeToMulProjects(Integer empId, List<Integer> projectIds) {

	    // 1. Fetch Employee
	    Employee employee = employeeRepo.findById(empId)
	            .orElseThrow(() ->
	                    new RuntimeException("Employee not found with ID : " + empId));

	    // 2. Fetch Projects using user-given IDs
	    List<Project> projects = projectRepo.findAllById(projectIds);

	    if (projects.size() != projectIds.size()) {
	        throw new RuntimeException("One or more Project IDs are invalid");
	    }

	    // 3. Assign projects to employee
	    employee.getProjects().addAll(projects);

	    // 4. Save employee (owning side)
	    employeeRepo.save(employee);

	    return "Employee ID:" + empId + " assigned to Projects IDs: " + projectIds;
	}

	@Override
	@Transactional
	public String assignOneProjectToMulEmployees(Integer projectId, List<Integer> employeeIds) {

	    // 1. Fetch Project
	    Project project = projectRepo.findById(projectId)
	            .orElseThrow(() ->
	                    new RuntimeException("Project not found with ID : " + projectId));

	    // 2. Fetch Employees using user-given IDs
	    List<Employee> employees = employeeRepo.findAllById(employeeIds);

	    if (employees.size() != employeeIds.size()) {
	        throw new RuntimeException("One or more Employee IDs are invalid");
	    }

	    // 3. Assign project to each employee
	    for (Employee emp : employees) {
	        emp.getProjects().add(project);
	    }

	    // 4. Save employees (owning side)
	    employeeRepo.saveAll(employees);

	    return "Project ID:" + projectId + " assigned to Employees Ids: " + employeeIds;
	}


	@Override
	public List<Employee> showEmployeesWithTheirProjects() {
	    return employeeRepo.findAll();
	}

	@Override
	public List<Project> showProjectsWithAssignedEmployees() {
	    return projectRepo.findAll();
	}

}
