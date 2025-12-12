package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.controller.EmployeeController;
import com.raj.entity.Employee;
import com.raj.service.IEmployeeService;

@Component
public class EmployeeTestRunner implements CommandLineRunner{

	@Autowired
	private EmployeeController controller;

	@Override
	public void run(String... args) throws Exception {
		
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("========== Employee Management System ==========");
				System.out.println("1. Insert Single Employee.");
				System.out.println("2. Insert Multiple Employees.");
				System.out.println("3. Find Employee by ID.");
				System.out.println("4. Find All Employees.");
				System.out.println("5. Update Employee Salary.");
				System.out.println("6. Check Employee Exist or not ?");
				System.out.println("7. Count Employees");
				System.out.println("8. Exit.");
				
				System.out.print("Enter Your Choice : ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Employee Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Employee Department: ");
					String dept = sc.nextLine();
					System.out.print("Enter Salary: ");
					Double sal = Double.parseDouble(sc.nextLine());
					
					Employee emp = new Employee(name, dept, sal);
					
					String msg = controller.createEmployee(emp);
					System.out.println(msg);
					break;
					
				case 2:
					System.out.print("Enter numbers of Employee details you want to saved: ");
					int nosOfFlight = Integer.parseInt(sc.nextLine());
					
					List<Employee> list = new ArrayList<>();
					
					for(int i=1; i<=nosOfFlight; i++) {
						
						System.out.println("\nEnter "+i +" Employee Details");
						
						System.out.print("Enter Employee Name: ");
						name = sc.nextLine();
						System.out.print("Enter Employee Department: ");
						dept = sc.nextLine();
						System.out.print("Enter Salary: ");
						sal = Double.parseDouble(sc.nextLine());
						
						emp = new Employee(name, dept, sal);
						
						list.add(emp);
					}
					String multipleEmployees = controller.createMultipleEmployees(list);
					System.out.println(multipleEmployees);
					break;
					
				case 3:
					System.out.print("Enter Employee ID: ");
					Integer id = Integer.parseInt(sc.nextLine());
					
					Optional<Employee> employee = controller.getEmployee(id);
					
					System.out.println(employee);
					break;
					
				case 4:
					List<Employee> allEmployees = controller.getAllEmployees();
					allEmployees.forEach(System.out::println);
					break;
					
				case 5:
					System.out.print("Enter Employee ID: ");
					id = Integer.parseInt(sc.nextLine());
					String updateEmployee = controller.updateEmployee(id);
					System.out.println(updateEmployee);
					break;
					
				case 6:
					System.out.print("Enter Employee ID: ");
					id = Integer.parseInt(sc.nextLine());
					boolean employeeExists = controller.employeeExists(id);
					
					System.out.print("Employee exist? : ");
					System.out.println(employeeExists?"Yes":"No");
					break;
					
				case 7:
					long employeeCount = controller.getEmployeeCount();
					System.out.println("Total Employees : "+employeeCount);
					break;
					
				case 8:
					System.exit(0);
					break;
				}
				System.out.println();
			}
			
		}catch (Exception e) {

            e.printStackTrace();
		}
		
	}
	
	
}
