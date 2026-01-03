package com.raj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raj.entity.Student;

public interface IStudentRepositiry extends JpaRepository<Student, Integer> {

	@Query("from Student where result=:pass")
	List<Student> getPassedStudents(String pass);

	@Query("from Student where result=:fail")
	List<Student> getFailedStudents(String fail);

	@Query("from Student where marks>:max")
	List<Student> getStudentsAbove75(double max);

	@Query("FROM Student s WHERE s.marks = (SELECT MAX(s2.marks) FROM Student s2)")
	Student getTopperStudent();

	@Query("FROM Student s WHERE s.marks = (SELECT MIN(s2.marks) FROM Student s2)")
	Student getLowestMarksStudent();
}
