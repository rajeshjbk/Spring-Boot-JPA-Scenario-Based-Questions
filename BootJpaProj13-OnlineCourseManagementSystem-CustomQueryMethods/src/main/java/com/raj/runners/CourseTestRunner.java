package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.service.ICourseService;

@Component
public class CourseTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n====== Course Management System ======");
				System.out.println("1. Fetch all active courses.");
				System.out.println("2. Find courses by instructor.");
				System.out.println("3. Find courses with fee less than a given amount.");
				System.out.println("4. Search courses by title keyword (LIKE).");
				System.out.println("5. Find courses with duration greater than given value.");
				System.out.println("6. Fetch courses by instructor and available status.");
				System.out.println("7. Count total courses.");
				System.out.println("8. Get average course fee.");
				System.out.println("9. Get maximum course fee.");
				System.out.println("10. Count courses by instructor.");
				System.out.println("11. Update course fee by course ID.");
				System.out.println("12. Increase fee by percentage for long-duration courses.");
				System.out.println("13. Deactivate courses whose fee is below a certain amountt.");
				System.out.println("14. Delete inactive courses.");
				System.out.println("15. Delete courses by instructor.");
				System.out.println("16. Fetch courses ordered by fee (DESC).");
				System.out.println("17. Fetch top 3 highest-fee courses.");
				System.out.println("18. Exit.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					courseService.showAllAvailableCourses(true).forEach(System.out::println);
					break;
				case 2:
					System.out.print("Enter Instructor Name: ");
					String instructor = sc.nextLine();
					courseService.findCoursesByInstructor(instructor).forEach(System.out::println);
					break;
				case 3:
					System.out.print("Enter Course fee: ");
					double fee = Double.parseDouble(sc.nextLine());
					courseService.findCoursesFeeLessThan(fee).forEach(System.out::println);
					break;
				case 4:
					System.out.print("Enter Course Keyword Name: ");
					String keyword = sc.nextLine();
					courseService.searchCoursesByTitleLike(keyword).forEach(System.out::println);
					break;
				case 5:
					System.out.print("Enter Course Duration: ");
					int duration = Integer.parseInt(sc.nextLine());
					courseService.showCoursesByDurationGreaterThan(duration).forEach(System.out::println);
					break;
					
				case 6:
					System.out.print("Enter Instructor Name: ");
					instructor = sc.nextLine();
					System.out.print("Enter Course Course status: ");
					boolean available = Boolean.parseBoolean(sc.nextLine());
					courseService.showCoursesByInstructorAndAvailable(instructor, available).forEach(System.out::println);
					break;
				case 7:
					System.out.print("Enter Course Name: ");
					String name = sc.nextLine();
					long countTotalCourses = courseService.countTotalCourses(name);
					System.out.println("Total Count of Course: "+name+" = "+countTotalCourses);
					break;
				case 8:
					System.out.print("Enter Course Name: ");
					name = sc.nextLine();
					double averageCourseFee = courseService.averageCourseFee(name);
					System.out.println("Average Fee for Course: "+name+" = "+averageCourseFee);
					break;
				case 9:
					double maximumCourseFee = courseService.maximumCourseFee();
					System.out.println("Maximum Course Fee: "+maximumCourseFee);
					break;
				case 10:
					System.out.print("Enter Instructor Name: ");
					instructor = sc.nextLine();
					
					long totalCoursesOfInstructor = courseService.totalCoursesOfInstructor(instructor);
					System.out.println("Instructor "+instructor+" total Courses: "+totalCoursesOfInstructor);
					break;
				case 11:
					System.out.print("Enter Course new fee: ");
					fee = Double.parseDouble(sc.nextLine());
					
					System.out.print("Enter Course ID: ");
					int courseId = Integer.parseInt(sc.nextLine());
					
					int updated = courseService.updateCourseFeeByCourseId(fee, courseId);
					
					if(updated>0)
					   System.out.println("Course Id: "+courseId+" is Updated with new Fee: "+fee);
					else
						System.out.println("Course Fee not Updated..");
					break;
				case 12:
					System.out.print("Enter Course Duration: ");
					duration = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Hike Percent: ");
					double hikePercent = Double.parseDouble(sc.nextLine());
					
					int incement = courseService.increaseCourseFeeByDurartion(hikePercent, duration);
					System.out.println("No.of Courses Fee increases: "+incement);
					
					break;
				case 13:
					System.out.print("Enter Course fee: ");
					fee = Double.parseDouble(sc.nextLine());
					int deactivateCoursesByFee = courseService.deactivateCoursesByFee(fee);
					System.out.println("No. of Courses are Deactivated: "+deactivateCoursesByFee);
					break;
				case 14:
					int deleteInactivateCourses = courseService.deleteInactivateCourses();
					System.out.println(deleteInactivateCourses+" No. of Deactivated Courses are deleted.");
					break;
				case 15:
					System.out.print("Enter Instructor Name: ");
					instructor = sc.nextLine();
					
					int deleteCoursesByIntructor = courseService.deleteCoursesByIntructor(instructor);
					System.out.println("Instructor: "+instructor+" "+deleteCoursesByIntructor+" courses are deleted.");
					break;
					
				case 16:
					courseService.fetchCoursesByDescOrder().forEach(System.out::println);
					break;
				case 17:
					courseService.fetchTop3HighestFeeCourses().forEach(System.out::println);
					break;
				case 18:
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
