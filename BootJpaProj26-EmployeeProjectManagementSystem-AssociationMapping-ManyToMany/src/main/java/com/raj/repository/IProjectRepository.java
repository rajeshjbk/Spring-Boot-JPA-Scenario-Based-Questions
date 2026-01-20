package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer> {

}
