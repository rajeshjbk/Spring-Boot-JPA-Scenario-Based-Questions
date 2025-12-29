package com.raj.service;

import java.util.List;
import java.util.Optional;

import com.raj.entity.Patient;

public interface IPatientService {

	String addNewPatient(Patient patient);
	
	Optional<Patient> getPatientRecord(int id);
	
	List<Patient> getAllPatientRecords();
	
	String updateDiagnosisAndTreatment(int id, String diagnosis, String treatment);
	
	String removePatient(int id);
}
