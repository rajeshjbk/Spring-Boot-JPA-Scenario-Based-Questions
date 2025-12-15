package com.raj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raj.document.Student;

public interface IStudentRepository extends MongoRepository<Student, String> {

}
