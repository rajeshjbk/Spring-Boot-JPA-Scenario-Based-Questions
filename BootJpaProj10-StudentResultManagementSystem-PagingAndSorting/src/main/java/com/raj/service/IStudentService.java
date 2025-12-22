package com.raj.service;

import org.springframework.data.domain.Page;

import com.raj.entity.Student;

public interface IStudentService {

	String addStudent(Student stu);
	Page<Student> fetchStudentsByPaging(int pageSize, int pageNo);
	Iterable<Student> sortStudents(boolean ascOrder, String ...props);
	
}
