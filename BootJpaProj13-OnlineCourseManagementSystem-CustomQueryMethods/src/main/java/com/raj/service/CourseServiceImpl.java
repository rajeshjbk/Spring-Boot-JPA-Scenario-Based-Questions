package com.raj.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Course;
import com.raj.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseRepository courseRepo;

	@Override
	public List<Course> showAllAvailableCourses(boolean active) {
		
		return courseRepo.showAllAvailableCourses(active);
	}

	@Override
	public List<Course> findCoursesByInstructor(String instructor) {
		
		return courseRepo.findCoursesByInstructor(instructor);
	}

	@Override
	public List<Course> findCoursesFeeLessThan(double fee) {
		
		return courseRepo.findCoursesFeeLessThan(fee);
	}

	@Override
	public List<Course> searchCoursesByTitleLike(String keyword) {
		
		return courseRepo.searchCoursesByCourseNameLike(keyword);
	}
	
	@Override
	public List<Course> showCoursesByDurationGreaterThan(int duration) {
		
		return courseRepo.showCoursesByDurationGreaterThan(duration);
	}

	@Override
	public List<Course> showCoursesByInstructorAndAvailable(String instructor, boolean status) {
		
		return courseRepo.showCoursesByInstructorAndAvailable(instructor, status);
	}

	@Override
	public long countTotalCourses(String courseName) {
		
		return courseRepo.countTotalCourses(courseName);
	}

	@Override
	public double averageCourseFee(String courseName) {
		
		return courseRepo.averageCourseFee(courseName);
	}

	@Override
	public double maximumCourseFee() {
		
		return courseRepo.maximumCourseFee();
	}

	@Override
	public long totalCoursesOfInstructor(String instructor) {
		
		return courseRepo.totalCoursesOfInstructor(instructor);
	}

	@Override
	public int updateCourseFeeByCourseId(double newFee, int courseId) {
		
		
		return courseRepo.updateCourseFeeByCourseId(newFee, courseId);
	}

	@Override
	public int increaseCourseFeeByDurartion(double hikePercent, int duration) {
		
		return courseRepo.increaseCourseFeeByDurartion(hikePercent, duration);
	}

	@Override
	public int deactivateCoursesByFee(double fee) {
		
		return courseRepo.deactivateCoursesByFee(fee);
	}

	@Override
	public int deleteInactivateCourses() {
		
		return courseRepo.deleteInactivateCourses();
	}

	@Override
	public int deleteCoursesByIntructor(String instructor) {
		
		return courseRepo.deleteCoursesByIntructor(instructor);
	}

	@Override
	public List<Course> fetchCoursesByDescOrder() {
		
		return courseRepo.fetchCoursesByDescOrder();
	}

	@Override
	public List<Course> fetchTop3HighestFeeCourses() {
		
		return courseRepo.fetchTop3HighestFeeCourses();
	}
	
}
