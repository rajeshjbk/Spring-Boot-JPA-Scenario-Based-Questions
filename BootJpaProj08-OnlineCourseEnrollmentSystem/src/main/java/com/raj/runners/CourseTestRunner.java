package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Course;
import com.raj.service.ICourseService;

@Component
public class CourseTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n====== Course Management Service ======");
				System.out.println("1. Add a single Course.");
				System.out.println("2. Add multiple Courses.");
				System.out.println("3. Find course by ID.");
				System.out.println("4. View all Courses.");
				System.out.println("5. Find Courses by IDs.");
				System.out.println("6. Find Total Courses.");
				System.out.println("7. Check Course Exists or not.");
				System.out.println("8. Remove Course by ID.");
				System.out.println("9. Remove Course by Course Object.");
				System.out.println("10. Remove Courses by Ids.");
				System.out.println("11. Remove All Courses.");
				System.out.println("12. Exit.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Course Name: ");
					String cName = sc.nextLine();
					System.out.print("Enter Course Instructor: ");
					String instructor = sc.nextLine();
					System.out.print("Enter Course Fee: ");
					Double fee = Double.parseDouble(sc.nextLine());
					System.out.print("Enter Course Durartion: ");
					Integer duration = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Course availability(true/false): ");
					Boolean available = Boolean.parseBoolean(sc.nextLine());
					
					Course course = new Course(cName, instructor, fee, duration, available);
					
					String courseAdded = courseService.addCourse(course);
					System.out.println(courseAdded);
					break;
				case 2:
					System.out.print("Enter number of Course, Which you want to add: ");
					int noOfCourses = Integer.parseInt(sc.nextLine());
					List<Course> list = new ArrayList<>();
					for(int i=1; i<=noOfCourses; i++) {
						
						System.out.println("Enter "+i +" Course Details.");
					    
						System.out.print("Enter Course Name: ");
						cName = sc.nextLine();
						System.out.print("Enter Course Instructor: ");
						instructor = sc.nextLine();
						System.out.print("Enter Course Fee: ");
						fee = Double.parseDouble(sc.nextLine());
						System.out.print("Enter Course Durartion: ");
						duration = Integer.parseInt(sc.nextLine());
						System.out.print("Enter Course availability(true/false): ");
						available = Boolean.parseBoolean(sc.nextLine());
						
						course = new Course(cName, instructor, fee, duration, available);
						list.add(course);
						System.out.println();
					}
					String multipleCourses = courseService.addMultipleCourses(list);
					System.out.println(multipleCourses);
					break;
				case 3:
					System.out.print("Enter Course ID: ");
					Integer id = Integer.parseInt(sc.nextLine());
					
					Course courseById = courseService.findCourseById(id);
					System.out.println(courseById);
					break;
				case 4:
					Iterable<Course> allCourses = courseService.findAllCourses();
					allCourses.forEach(System.out::println);
					break;
				case 5:
					System.out.print("Enter no of Ids which you want to fetch: ");
					int noOfIds = Integer.parseInt(sc.nextLine());
					
					List<Integer> idsList = new ArrayList<>();
					
					for(int i=1; i<=noOfIds; i++) {
						
						System.out.print("Enter "+i+ " Id: ");
						id = Integer.parseInt(sc.nextLine());
						
						idsList.add(id);
					}
					Iterable<Course> allCoursesByIds = courseService.findAllCoursesByIds(idsList);	
					allCoursesByIds.forEach(System.out::println);
					break;
					
				case 6:
					long totalCourses = courseService.findTotalCourses();
					System.out.println("Total Courses: "+totalCourses);
					break;
				case 7:
					System.out.println("Enter Course ID: ");
					id = Integer.parseInt(sc.nextLine());
					Boolean courseExistsById = courseService.isCourseExistsById(id);
					System.out.println(courseExistsById?"Course Exist with ID: "+id+":Yes":"Course Exist with ID: "+id+":No");
					break;
				case 8:
					System.out.print("Enter Course ID: ");
					id = Integer.parseInt(sc.nextLine());
					String deleteCourseById = courseService.deleteCourseById(id);
					System.out.println(deleteCourseById);
					break;
				case 9:
					System.out.print("Enter Course ID: ");
					id = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Course Name: ");
					cName = sc.nextLine();
					System.out.print("Enter Course Instructor: ");
					instructor = sc.nextLine();
					System.out.print("Enter Course Fee: ");
					fee = Double.parseDouble(sc.nextLine());
					System.out.print("Enter Course Durartion: ");
					duration = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Course availability(true/false): ");
					available = Boolean.parseBoolean(sc.nextLine());
					
					course = new Course(id,cName, instructor, fee, duration, available);
					
					String deleteCourse = courseService.deleteCourse(course);
					System.out.println(deleteCourse);
					break;
				case 10:
					System.out.print("Enter no of Ids which you want to delete: ");
					noOfIds = Integer.parseInt(sc.nextLine());
					
					idsList = new ArrayList<>();
					
					for(int i=1; i<=noOfIds; i++) {
						
						System.out.print("Enter "+i+ " Id: ");
						id = Integer.parseInt(sc.nextLine());
						idsList.add(id);
					}
					String deleteAllCourseByIds = courseService.deleteAllCourseByIds(idsList);
					System.out.println(deleteAllCourseByIds);
					break;
				case 11:
					String deleteAllCourses = courseService.deleteAllCourses();
					System.out.println(deleteAllCourses);
					break;
				case 12:
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
