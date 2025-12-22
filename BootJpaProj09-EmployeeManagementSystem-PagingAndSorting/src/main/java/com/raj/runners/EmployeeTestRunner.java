package com.raj.runners;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.raj.controller.EmployeeController;
import com.raj.entity.Employee;

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
				System.out.println("7. Count Employees.");
				System.out.println("8. Fetch Employee Records by Page And Sort.");
				System.out.println("9. Sort By Salary.");
				System.out.println("10. Sort By Date of Joining.");
				System.out.println("11. Exit.");
				
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
					
					System.out.print("Enter Joining Data(YYYY-MM-DD): ");
					String date = sc.nextLine();
					
					LocalDate joiningDate = LocalDate.parse(date);
					
					Employee emp = new Employee(name,dept,sal,joiningDate);
					
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
						
						System.out.print("Enter Joining Data(YYYY-MM-DD): ");
						date = sc.nextLine();
						
						joiningDate = LocalDate.parse(date);
						emp = new Employee(name, dept, sal, joiningDate);
						
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
					System.out.print("Enter page size: ");
					int pageSize = Integer.parseInt(sc.nextLine());
					System.out.print("Enter page no which You want to see: ");
					int pageNo = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Flight property which basis you want Sort: ");
					String props = sc.nextLine();
					
					System.out.print("Enter Sorting Order, For Ascending(true) / Descending(false): ");
					boolean orderSort = Boolean.parseBoolean(sc.nextLine());
					
					Page<Employee> fetchEmployeesByPageAndSort = controller.fetchEmployeesByPageAndSort(pageNo,pageSize,orderSort,props);
					fetchEmployeesByPageAndSort.forEach(System.out::println);
					break;
					
				case 9:
					System.out.print("Enter Flight property which basis you want Sort: ");
					props = sc.nextLine();
					System.out.print("Enter Sorting Order, For Ascending(true) / Descending(false): ");
					orderSort = Boolean.parseBoolean(sc.nextLine());   
				    
					Iterable<Employee> sortBySalary = controller.sortBySalary(orderSort, props);
					sortBySalary.forEach(System.out::println);
					break;
					
				case 10:
					System.out.print("Enter Flight property which basis you want Sort: ");
					props = sc.nextLine();
					
					System.out.print("Enter Sorting Order, For Ascending(true) / Descending(false): ");
					orderSort = Boolean.parseBoolean(sc.nextLine());
					
					Iterable<Employee> sortByDateOfJoining = controller.sortByDateOfJoining(orderSort, props);
					sortByDateOfJoining.forEach(System.out::println);
					break;
					
				case 11:
					System.exit(0);
					
				default:
					System.err.println("Invalid Input...");
						
				}
				System.out.println();
			}
			
		}catch (Exception e) {

            e.printStackTrace();
		}
	}
}
