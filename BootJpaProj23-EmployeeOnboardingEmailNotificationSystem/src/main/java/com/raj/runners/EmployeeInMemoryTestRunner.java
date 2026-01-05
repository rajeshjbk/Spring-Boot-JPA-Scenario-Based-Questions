package com.raj.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.raj.controller.EmployeeMgmtController;
import com.raj.entity.Employee;

@Component
public class EmployeeInMemoryTestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeMgmtController empMgmtController;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n========== Employee Management Service =============");
				System.out.println("1. Add New Employee.");
				System.out.println("2. Get employees with pagination & sorting.");
				
				System.out.println("3. Exit.");
				
				System.out.print("Enter Your Choice: ");
				
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice ) {
				
				case 1:
					System.out.print("Enter Employee Name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter Employee Email: ");
					String email = sc.nextLine();
					
					System.out.print("Enter Employee Department: ");
					String dept = sc.nextLine();
					
					System.out.print("Enter Employee Salary: ");
					Double salary = Double.parseDouble(sc.nextLine());
					
					System.out.print("Enter Employee Date of Joining(YYYY-MM-DD): ");
					LocalDate dateOfJoining = LocalDate.parse(sc.nextLine());
	
					Employee employee = new Employee(name, email, dept, salary, dateOfJoining);
					
					String newEmployee = empMgmtController.addNewEmployee(employee);
					System.out.println(newEmployee);
					break;
				case 2:
					System.out.print("Enter page size: ");
					int pageSize = Integer.parseInt(sc.nextLine());
					System.out.print("Enter page no which You want to see: ");
					int pageNo = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Employee property which basis you want Sort: ");
					String props = sc.nextLine();
					
					System.out.print("Enter Sorting Order, For Ascending(true) / Descending(false): ");
					boolean orderSort = Boolean.parseBoolean(sc.nextLine());
					
					Page<Employee> employeesByPaginationAndSorting = empMgmtController.getEmployeesByPaginationAndSorting(pageNo, pageSize, orderSort, props);
					employeesByPaginationAndSorting.forEach(System.out::println);
					break;
				case 3:
					System.exit(0);
				default:
					System.err.println("Invalid Choice..Plz Choice right choice.");
				}
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
