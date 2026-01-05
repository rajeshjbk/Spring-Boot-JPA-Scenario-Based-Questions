package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.raj.entity.Employee;
import com.raj.repository.IEmployeeRepository;
@Service
public class EmployeeMgmtService implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository employeeRepo;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public String addEmployee(Employee employee) {

         Long id = employeeRepo.save(employee).getId();
         
         SimpleMailMessage message = new SimpleMailMessage();
         
         message.setTo(employee.getEmail());
         message.setSubject("Welcome to Our Company.");
         String body = """
         		        Hello, %s
         		        Welcome to Raj Private Limited,
         		        
         		        Department: %s
         		        Salary: %f
         		        
         		        Thanks for Joining Our Company..
         	         	""".formatted(employee.getName(),employee.getDepartment(),employee.getSalary());
       
         message.setText(body);
         
         mailSender.send(message);
         System.out.println("Email sent successfully to New Employee.");
         
		return "New Employee is added with ID: "+id;
	}

	@Override
	public Page<Employee> getEmployeesByPaginationAndSorting(int pageNo, int pageSize, boolean ascOrder,
			String... props) {

		//create Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);

		//create Pageable object having inputs
		Pageable  pageable= PageRequest.of(pageNo, pageSize,sort);

		//execute the code
		Page<Employee> pages = employeeRepo.findAll(pageable);
		return pages;

	}

}
