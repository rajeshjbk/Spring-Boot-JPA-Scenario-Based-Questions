package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Student;
import com.raj.service.IStudentMgmtService;

@Component
public class InMemoryDBTestRunner implements CommandLineRunner {

	@Autowired
	private IStudentMgmtService studentService;

	@Override
	public void run(String... args) throws Exception {

		try(Scanner sc = new Scanner(System.in)){


			while(true) {

				System.out.println("========== Student Examination Management Service ==========");
				System.out.println("1. Add One New Student.");
				System.out.println("2. Add more than one New Students.");
				System.out.println("3. View All Students.");
				System.out.println("4. Get Student by Roll No.");
				System.out.println("5. ");
				System.out.println("");
				System.out.println("");
				System.out.println("");

				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {
				case 1:
					System.out.print("Enter Student Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Student Class Name: ");
					String className = sc.nextLine();

					System.out.print("Enter Student Marks: ");
					double marks = Double.parseDouble(sc.nextLine());

					System.out.print("Enter Student Result: ");
					String result = sc.nextLine();
					System.out.print("Enter Student Exam Year: ");
					String examYear = sc.nextLine();

					Student student = new Student(name, className, marks, result, examYear);
					String registerNewStudent = studentService.registerNewStudent(student);
					System.out.println(registerNewStudent);
					break;

				case 2:

					break;
				case 3:
					studentService.getAllStudents().forEach(System.out::println);
					break;

				case 4:
					System.out.print("Enter Student Roll No: ");

					int rollNo = Integer.parseInt(sc.nextLine());

					Student studentRollNo = studentService.getStudentRollNo(rollNo);
					System.out.println(studentRollNo);
					break;

				default:
					System.err.println("Invalid Choice...");

				}
			}
		}catch (Exception e) {

             e.printStackTrace();
		}

	}

}
