package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.raj.entity.Student;
import com.raj.service.IStudentService;

@Component
public class StudentTestRunner implements CommandLineRunner {

	@Autowired
	private IStudentService studentService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n====== Student Management System ======");
				System.out.println("1. Add New Student.");
				System.out.println("2. Fetch Student By Page.");
				System.out.println("3. Sort Student By Property.");
				System.out.println("4. Exit.");
				
				System.out.print("Enter Your choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Student Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Student Course: ");
					String course = sc.nextLine();
					System.out.print("Enter Student Marks: ");
					Double marks = Double.parseDouble(sc.nextLine());
					System.out.print("Enter Student Grade: ");
					String grade = sc.nextLine();
					
					Student student = new Student(name, course, marks, grade);
					
					String student2 = studentService.addStudent(student);
					System.out.println(student2);
					break;
				case 2:
					System.out.print("Enter page size: ");
					int pageSize = Integer.parseInt(sc.nextLine());
					System.out.print("Enter page no which You want to see: ");
					int pageNo = Integer.parseInt(sc.nextLine());
					
					Page<Student> fetchStudentsByPaging = studentService.fetchStudentsByPaging(pageSize, pageNo);
					fetchStudentsByPaging.forEach(System.out::println);
					break;
				case 3:
					System.out.print("Enter Student property, which basis you want Sort: ");
					String props = sc.nextLine();
					System.out.print("Enter Sorting Order, For Ascending(true) / Descending(false): ");
					boolean orderSort = Boolean.parseBoolean(sc.nextLine());  
					Iterable<Student> sortStudents = studentService.sortStudents(orderSort, props);
					sortStudents.forEach(System.out::println);
					break;
				case 4:
					System.exit(0);
				default:
					System.err.println("Invalid input...");
				}
				
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
