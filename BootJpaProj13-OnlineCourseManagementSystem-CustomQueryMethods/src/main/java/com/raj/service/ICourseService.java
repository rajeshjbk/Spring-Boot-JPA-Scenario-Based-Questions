package com.raj.service;

import java.util.List;


import com.raj.entity.Course;

public interface ICourseService {

	List<Course> showAllAvailableCourses(boolean active);
	List<Course> findCoursesByInstructor(String instructor);
	List<Course> findCoursesFeeLessThan(double fee);	
    List<Course> searchCoursesByTitleLike(String keyword);
    
    List<Course> showCoursesByDurationGreaterThan(int duration);
	List<Course> showCoursesByInstructorAndAvailable(String instructor, boolean status);
	
	long countTotalCourses(String courseName);
	double averageCourseFee(String courseName);
	double maximumCourseFee();
	long totalCoursesOfInstructor(String instructor);
	
	int updateCourseFeeByCourseId(double newFee, int courseId);
	
	int increaseCourseFeeByDurartion(double hikePercent,int duration);
	
	int deactivateCoursesByFee(double fee);
	
	int deleteInactivateCourses();
	
	int deleteCoursesByIntructor(String instructor);
	
	List<Course> fetchCoursesByDescOrder();
	
	List<Course> fetchTop3HighestFeeCourses();
}








