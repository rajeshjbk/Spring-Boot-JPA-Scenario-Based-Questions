package com.raj.service;

import java.util.List;

import com.raj.document.Student;

public interface IStudentService {

	String addStudent(Student stu);
	String addMultipleStudents(List<Student> list);
	Iterable<Student> getAllStudents();
	Student getStudentById(String id);
	String updateStudentMarks(String id);
	String deleteStudent(String id);
	long countStudents();
	boolean checkStudentExists(String id); 
}
