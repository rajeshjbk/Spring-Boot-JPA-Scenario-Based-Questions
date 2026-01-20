package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.raj.BootJpaProj26EmployeeProjectManagementSystemAssociationMappingManyToManyApplication;
import com.raj.entity.Employee;
import com.raj.entity.Project;
import com.raj.service.IEmployeeProjectMgmtService;

@Component
public class ManyToManyTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeProjectMgmtService empProjMgmtService;

	@Override
	public void run(String... args) throws Exception {

		try(Scanner sc = new Scanner(System.in)){

			while(true) {

				System.out.println("========== Employee-Project Management System ============");
				System.out.println("1.Add new employees to the system.");
				System.out.println("2.Add new projects to the system");
				System.out.println("3.Assign one employee to multiple projects");
				System.out.println("4.Assign one project to multiple employees.");
				System.out.println("5.Retrieve employees along with their assigned projects.");
				System.out.println("6.Retrieve projects along with their assigned employees.");
				System.out.println("7.Exit.");

				System.out.print("Enter Your choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {
				case 1 -> {

					System.out.print("Enter number of Employees: ");
					int noOfEmps = Integer.parseInt(sc.nextLine());

					List<Employee> employees = new ArrayList<Employee>();

					for(int i=1; i<=noOfEmps; i++) {

						System.out.print("Enter Employee name: ");
						String name = sc.nextLine();

						System.out.print("Enter Employee Salary: ");
						Double salary = Double.parseDouble(sc.nextLine());

						System.out.print("Enter Employee Designation: ");
						String designation = sc.nextLine();

						Employee employee = new Employee(name, salary, designation);

						employees.add(employee);
					}
					String msg = empProjMgmtService.addEmployees(employees);
					System.out.println(msg);
				}
				case 2 -> {
                   System.out.print("Enter no.of Projects: ");
                   int noOfProjects = Integer.parseInt(sc.nextLine());
                   
                   List<Project> projects = new ArrayList<Project>();
                		   
                   for(int i=1; i<=noOfProjects; i++) {
                	   
                	   System.out.print("Enter Project Name: ");
                	   String projName = sc.nextLine();
                	   
                	   System.out.print("Enter Project Client Name: ");
                	   String clientName = sc.nextLine();
                	   
                	   System.out.print("Enter Project duration: ");
                	   Double duration = Double.parseDouble(sc.nextLine());
                	   
                	   Project project = new Project(projName, clientName, duration);
                	   projects.add(project);
                   }
                   String msg = empProjMgmtService.addProjects(projects);
                   System.out.println(msg);
				}
				
				case 3 -> {
					
					System.out.print("Enter Employee Id: ");
					int eid = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter no.of Projects which You assign to the Employee: ");
					int noOfProject = Integer.parseInt(sc.nextLine());
					
					List<Integer> projectIds = new ArrayList<Integer>();
					
					for(int i=1; i<=noOfProject; i++) {
						
						System.out.print("Enter "+i+" Project Id: ");
						int id = Integer.parseInt(sc.nextLine());
						
						projectIds.add(id);
					}
					
					String msg = empProjMgmtService.assignOneEmployeeToMulProjects(eid, projectIds);
					System.out.println(msg);
				}
				case 4 -> {
					
					System.out.print("Enter Project Id: ");
					int pid = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter no.of Employees which You assign to the Project: ");
					int noOfEmp = Integer.parseInt(sc.nextLine());
					
					List<Integer> empIds = new ArrayList<Integer>();
					
					for(int i=1; i<=noOfEmp; i++) {
						
						System.out.print("Enter "+i+" Employee Id: ");
						int id = Integer.parseInt(sc.nextLine());
						
						empIds.add(id);
					}
					String msg = empProjMgmtService.assignOneProjectToMulEmployees(pid, empIds);
				    System.out.println(msg);
				}
				case 5 -> {
					
					empProjMgmtService.showEmployeesWithTheirProjects().forEach(emp->{
						
						System.out.println(emp);
						emp.getProjects().forEach(proj->{
							
							System.out.println(proj);
						});
						System.out.println("................................................");
					});
				}
				case 6 ->{
					
					empProjMgmtService.showProjectsWithAssignedEmployees().forEach(proj->{
						
						System.out.println(proj);
						
						proj.getEmployees().forEach(emp->{
							System.out.println(emp);
						});
						System.out.println(".....................................................");
					});
				}
				case 7 -> System.exit(0);
				default -> System.err.println("Invalid Choice...");
				}
               System.out.println();
			}

		}catch (Exception e) {

			e.printStackTrace();
		}
	}

}
