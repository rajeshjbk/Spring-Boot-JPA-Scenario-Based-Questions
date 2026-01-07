package com.raj.runners;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.EmployeeInfo;
import com.raj.service.IEmployeeMgmtService;
@Component
public class CollectionMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService empMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n========== Employee Skills Tracker ===========");
			    System.out.println("1. Add New Employee Information.");
			    System.out.println("2. Show All Employees Information.");
			    System.out.println("3. Show Employee Information by ID.");
			    System.out.println("4. Delete Employee Information By ID.");
				System.out.println("5. Exit.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					EmployeeInfo employeeInfo = new EmployeeInfo("Sanjay",
							List.of("Java","MERN","Springboot"), 
							Set.of("NIT","ServiceNow") ,
							Map.of("E-Commerce App",4.7,"Hotel Management System",4.5));
					String newEmployee = empMgmtService.addNewEmployee(employeeInfo);
					System.out.println(newEmployee);
					break;
					
				case 2:
					
					empMgmtService.showAllEmplyeesInfo().forEach(System.out::println);
					break;
					
				case 3:
					System.out.print("Enter EMP_ID: ");
					long id = Long.parseLong(sc.nextLine());
					EmployeeInfo fetchEmployeeInfoById = empMgmtService.fetchEmployeeInfoById(id);
					System.out.println(fetchEmployeeInfoById);
					break;
					
				case 4:
					System.out.print("Enter EMP_ID: ");
					id = Long.parseLong(sc.nextLine());
					String deleteEmployeeInfoById = empMgmtService.deleteEmployeeInfoById(id);
				    System.out.println(deleteEmployeeInfoById);
				    break;
				case 5:
					System.exit(0);
					
				}
				
			}
		}catch (Exception e) {
			
		    e.printStackTrace();
		}

	}

}
