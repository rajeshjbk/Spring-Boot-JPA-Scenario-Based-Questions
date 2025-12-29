package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
