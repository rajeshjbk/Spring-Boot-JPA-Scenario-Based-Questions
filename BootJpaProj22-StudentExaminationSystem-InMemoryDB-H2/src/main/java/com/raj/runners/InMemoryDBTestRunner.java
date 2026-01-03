package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
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

				System.out.println("\n========== Student Examination Management Service ==========");
				System.out.println("1. Add One New Student.");
				System.out.println("2. Add more than one New Students.");
				System.out.println("3. View All Students.");
				System.out.println("4. Get Student by Roll No.");
				System.out.println("5. Update Student Marks.");
				System.out.println("6. Update Student Result.");
				System.out.println("7. Show All Passed Students.");
				System.out.println("8. Show All Failed Student.");
				System.out.println("9. Show Students Above 75 marks.");
				System.out.println("10.Total Students.");
				System.out.println("11.Pass vs Fail Count.");
				System.out.println("12.Find Topper Student.");
				System.out.println("13.Find Lowest Marks Student.");
                System.out.println("14. Exit.");
                
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
					
					System.out.print("Enter no.of Student You want to registered: ");
                    int noOfStudent = Integer.parseInt(sc.nextLine());
                    
                    List<Student> list = new ArrayList<Student>();
                    
                    for(int i=1; i<=noOfStudent; i++) {
                    	
                    	System.out.println("Enter "+i+ " Student Detail.");
                    	System.out.print("Enter Student Name: ");
    					name = sc.nextLine();

    					System.out.print("Enter Student Class Name: ");
    					className = sc.nextLine();

    					System.out.print("Enter Student Marks: ");
    					marks = Double.parseDouble(sc.nextLine());

    					System.out.print("Enter Student Result: ");
    					result = sc.nextLine();
    					System.out.print("Enter Student Exam Year: ");
    					examYear = sc.nextLine();

    					student = new Student(name, className, marks, result, examYear);
    					
    					list.add(student);
                    }
                    String registerMultipleNewStudents = studentService.registerMultipleNewStudents(list);
					System.out.println(registerMultipleNewStudents);
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
					
				case 5:
					System.out.print("Enter Student Roll No: ");
					rollNo = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Student Updated Marks: ");
					marks = Double.parseDouble(sc.nextLine());
					
					String updateMarks = studentService.updateMarks(rollNo, marks);
					System.out.println(updateMarks);
					break;
					
				case 6:
					System.out.print("Enter Student Roll No: ");
					rollNo = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Student Updated Results: ");
					result = sc.nextLine();
					
					String updateResult = studentService.updateResult(rollNo, result);
					System.out.println(updateResult);
					break;
					
				case 7:
					List<Student> passedStudents = studentService.getPassedStudents("Pass");
					passedStudents.forEach(System.out::println);
					break;
					
				case 8:
					studentService.getFailedStudents("Fail").forEach(System.out::println);
					break;
					
				case 9:
					studentService.getStudentsAbove75(75.0).forEach(System.out::println);
					break;
					
				case 10:
					long countTotalStudents = studentService.countTotalStudents();
					System.out.println("Total Students: "+countTotalStudents);
					break;
					
				case 11:
					System.out.println("Pass vs Fail Count:");
					int countPassedStudents = studentService.countPassedStudents();
					System.out.println("Passed Students: "+countPassedStudents);
					
					int countFailedStudents = studentService.countFailedStudents();
					System.out.println("Failed Students: "+countFailedStudents);
					break;
					
				case 12:
					Student topperStudent = studentService.getTopperStudent();
					
					System.out.println("Topper Student: "+topperStudent);
					break;
					
				case 13:
					Student lowestMarksStudent = studentService.getLowestMarksStudent();
					System.out.println("Lowest Marks Student: "+lowestMarksStudent);
					break;
					
				case 14:
					System.exit(0);
					
				default:
					System.err.println("Invalid Choice...");
				}
			}
			
		}catch (Exception e) {

             e.printStackTrace();
		}
	}
}
