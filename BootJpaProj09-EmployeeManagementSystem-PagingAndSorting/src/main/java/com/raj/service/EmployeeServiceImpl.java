package com.raj.service;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.raj.entity.Employee;
import com.raj.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepo;

	@Override
	public String createEmployee(Employee employee) {

		Employee emp = employeeRepo.save(employee);

		return "New Employee is Saved with ID: "+emp.getEmpId();
	}

	@Override
	public String createMultipleEmployees(List<Employee> employees) {

		Iterable<Employee> saveAll = employeeRepo.saveAll(employees);

		List<Integer> ids = StreamSupport.stream(saveAll.spliterator(), false).map(Employee::getEmpId).collect(Collectors.toList());

		return ids.size()+"nos. of Employees are saved with ids: "+ids;
	}

	@Override
	public Optional<Employee> getEmployee(Integer id) {

		Optional<Employee> byId = employeeRepo.findById(id);

		return byId;
	}

	@Override
	public List<Employee> getAllEmployees() {

		Iterable<Employee> allEmployees = employeeRepo.findAll();

		return (List<Employee>) allEmployees;
	}

	@Override
	public Boolean employeeExists(Integer id) {

		boolean existsById = employeeRepo.existsById(id);

		return existsById;
	}

	@Override
	public long getEmployeeCount() {

		long count = employeeRepo.count();

		return count;
	}

	@Override
	public String updateEmployee(Integer id) {

		Employee employee = employeeRepo.findById(id).get();

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter New Salary: ");
		Double newSal=Double.parseDouble(sc.nextLine());

		employee.setSalary(newSal);

		Employee save = employeeRepo.save(employee);

		return "ID: "+id+" is updated with new Salary: "+newSal;
	}

	@Override
	public Page<Employee> fetchEmployeesByPageAndSort(int pageNo, int pageSize, boolean ascOrder,
			String... props) {

		//create Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);

		//create Pageable object having inputs
		Pageable  pageable= PageRequest.of(pageNo, pageSize,sort);

		//execute the code
		Page<Employee> pages = employeeRepo.findAll(pageable);
		return pages;
	}

	@Override
	public Iterable<Employee> sortBySalary(boolean ascOrder, String salary) {

		//create Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, salary);

		 Iterable<Employee> all = employeeRepo.findAll(sort);
		 
		return all;
	}

	@Override
	public Iterable<Employee> sortByDateOfJoining(boolean ascOrder, String dateOfJoining) {

		//create Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, dateOfJoining);

		Iterable<Employee> all = employeeRepo.findAll(sort);
		
		return all;
	}

}
