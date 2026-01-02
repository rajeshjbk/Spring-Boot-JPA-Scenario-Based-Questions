package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Student;

public interface IStudentRepositiry extends JpaRepository<Student, Integer> {

}
