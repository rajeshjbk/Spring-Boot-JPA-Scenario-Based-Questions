package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.document.Student;
import com.raj.service.IStudentService;

@Component
public class StudentTestRunner implements CommandLineRunner{

	@Autowired
	private IStudentService studentService;

	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				System.out.println("\n============ Student Management System ============");
				System.out.println("1. Add New Student.");
				System.out.println("2. Add New Multiple Students.");
				System.out.println("3. Show All Students.");
				System.out.println("4. Fetch Student by Id.");
				System.out.println("5. Update Student by Id.");
				System.out.println("6. Delete Student by Id.");
				System.out.println("7. Total Students. ");
				System.out.println("8. Student exists? ");
				System.out.println("9. Exit");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Student name: ");
					String name = sc.nextLine();
					System.out.print("Enter Student Department: ");
					String dept = sc.nextLine();
					System.out.print("Enter Student Marks: ");
					Double marks = Double.parseDouble(sc.nextLine());
					
					Student student = new Student(name, dept, marks);
					
					String save = studentService.addStudent(student);
					System.out.println(save);
					break;
				case 2:
					System.out.print("Enter no.of Student, You want to add: ");
					int noOfStudent = Integer.parseInt(sc.nextLine());
					List<Student> list = new ArrayList<>();
					
					for(int i=1; i<=noOfStudent; i++) {
						System.out.println("Enter "+i+ " Student Details.");
						System.out.print("Enter Student name: ");
						name = sc.nextLine();
						System.out.print("Enter Student Department: ");
						dept = sc.nextLine();
						System.out.print("Enter Student Marks: ");
						marks = Double.parseDouble(sc.nextLine());
						
						student = new Student(name, dept, marks);
						list.add(student);
					}
					String multipleStudents = studentService.addMultipleStudents(list);
					System.out.println(multipleStudents);
					break;
				case 3:
					Iterable<Student> allStudents = studentService.getAllStudents();
					allStudents.forEach(System.out::println);
					break;
				case 4:
					System.out.print("Enter Student ID: ");
					String id = sc.nextLine();
					
					Student studentById = studentService.getStudentById(id);
					System.out.println(studentById);
					break;
					
				case 5:
					System.out.print("Enter Student ID: ");
					id = sc.nextLine();
					
					String updateStudentMarks = studentService.updateStudentMarks(id);
					System.out.println(updateStudentMarks);
					break;
				case 6:
					System.out.print("Enter Student ID: ");
					id = sc.nextLine();
					
					String deleteStudent = studentService.deleteStudent(id);
					System.out.println(deleteStudent);
					break;
				case 7:
					long countStudents = studentService.countStudents();
					
					System.out.println("Total Students: "+countStudents);
					break;
				case 8:
					System.out.print("Enter Student ID: ");
					id = sc.nextLine();
					boolean checkStudentExists = studentService.checkStudentExists(id);
					System.out.println(checkStudentExists?"Student is Exist with Id: "+id:"Student is not Exist with Id: "+id);
					break;
				case 9:
					System.exit(0);
				default:
					System.err.println("Invalid choice..");
				}
				System.out.println();
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
}
