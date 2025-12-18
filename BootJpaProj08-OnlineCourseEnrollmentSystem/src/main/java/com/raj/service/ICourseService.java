package com.raj.service;

import java.util.List;

import com.raj.entity.Course;

public interface ICourseService {

	String addCourse(Course course);
	String addMultipleCourses(List<Course> list);
	Course findCourseById(Integer id);
	Iterable<Course> findAllCourses();
	Iterable<Course> findAllCoursesByIds(List<Integer> ids);
	long findTotalCourses();
	Boolean isCourseExistsById(Integer id);
	String deleteCourseById(Integer id);
	String deleteCourse(Course course);
	String deleteAllCourseByIds(List<Integer> ids);
	String deleteAllCourses();
}
