package com.raj.repository;

import org.springframework.data.repository.CrudRepository;

import com.raj.entity.Course;

public interface ICourseRepository extends CrudRepository<Course, Integer> {

}
