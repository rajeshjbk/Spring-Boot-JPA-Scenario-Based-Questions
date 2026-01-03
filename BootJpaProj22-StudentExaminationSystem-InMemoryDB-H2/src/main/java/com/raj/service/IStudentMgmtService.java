package com.raj.service;

import java.util.List;

import com.raj.entity.Student;

public interface IStudentMgmtService {

	String registerNewStudent(Student stu);
	
	String registerMultipleNewStudents(List<Student> list);
	
	List<Student> getAllStudents();
	
	Student getStudentRollNo(int rollNo);
	
	String updateMarks(int  rollNo, double newMarks);
	
	String updateResult(int rollNo, String newResult);
	
	List<Student> getPassedStudents(String pass);
	
	List<Student> getFailedStudents(String fail);
	
	List<Student> getStudentsAbove75(double max);
	
	long countTotalStudents();
	
	int countPassedStudents();
	
	int countFailedStudents();
	
	Student getTopperStudent();
	
	Student getLowestMarksStudent();
	
}
