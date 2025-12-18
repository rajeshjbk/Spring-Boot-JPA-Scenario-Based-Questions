package com.raj.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Course;
import com.raj.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseRepository courseRepo;

	@Override
	public String addCourse(Course course) {

		Course save = courseRepo.save(course);

		return "New Course is Added with Course ID: "+save.getCourseId();
	}

	@Override
	public String addMultipleCourses(List<Course> list) {

		Iterable<Course> saveAll = courseRepo.saveAll(list);
		List<Integer> idsList = StreamSupport.stream(saveAll.spliterator(), false).map(Course::getCourseId).collect(Collectors.toList());
		return "New Courses are added with Ids: "+idsList;
	}

	@Override
	public Course findCourseById(Integer id) {

		if(courseRepo.findById(id).isPresent()) {
			
			return courseRepo.findById(id).get();
		}
			
		return new Course();
	}

	@Override
	public Iterable<Course> findAllCourses() {

		Iterable<Course> all = courseRepo.findAll();
		return all;
	}

	@Override
	public Iterable<Course> findAllCoursesByIds(List<Integer> ids) {

		Iterable<Course> allById = courseRepo.findAllById(ids);
		return allById;
	}

	@Override
	public long findTotalCourses() {

		return courseRepo.count();
	}

	@Override
	public Boolean isCourseExistsById(Integer id) {

		return courseRepo.existsById(id);
	}

	@Override
	public String deleteCourseById(Integer id) {

		if(courseRepo.findById(id).get()!=null) {

			courseRepo.deleteById(id);
			return "Course is deleted with ID: "+id;
		}
		return "Course is not deleted by given Id.";
	}

	@Override
	public String deleteCourse(Course course) {

		if(courseRepo.findById(course.getCourseId()).get()!=null) {

			courseRepo.delete(course);
			return "Course is deleted with Record: "+course;
		}
		return "Course is not deleted by given Record.";

	}

	@Override
	public String deleteAllCourseByIds(List<Integer> ids) {
		
		Iterable<Course> allByIds = courseRepo.findAllById(ids);
		int size = StreamSupport.stream(allByIds.spliterator(), false).map(Course::getCourseId).collect(Collectors.toList()).size();
		
		if(size!=0) {
			
		    courseRepo.deleteAllById(ids);
		    return "All Courses are deleted with Ids: "+ids;
		}

		return "Courses are not deleted with ids: "+ids;
	}

	@Override
	public String deleteAllCourses() {

		courseRepo.deleteAll();
		return "All Courses are deleted.";
	}

}
