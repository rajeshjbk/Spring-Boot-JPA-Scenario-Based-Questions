package com.raj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Patient;
import com.raj.repository.IPatientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepository patientRepo;

	@Override
	public String addNewPatient(Patient patient) {

		Integer patientId = patientRepo.save(patient).getPatientId();
		return "New Patient is Addmitted with ID: "+patientId;
	}

	@Override
	public Optional<Patient> getPatientRecord(int id) {

		Optional<Patient> byId = patientRepo.findById(id);

		if(byId.isPresent()) {

			return byId;
		}

		return Optional.empty();
	}

	@Override
	public List<Patient> getAllPatientRecords() {

		List<Patient> all = patientRepo.findAll();
		return all;
	}

	@Override
	public String updateDiagnosisAndTreatment(int id, String diagnosis, String treatment) {

		Optional<Patient> byId = patientRepo.findById(id);

		if(byId.isPresent()) {

			Patient patient = byId.get();
			patient.setDiagnosis(diagnosis);
			patient.setTreatment(treatment);
			
			patientRepo.save(patient);
			
			return "Patient ID:"+id + " Diagnosis And Treatment are Updated.";
		}
		return "Patient ID is Invalid.";
	}

	@Override
	public String removePatient(int id) {
		
		Optional<Patient> byId = patientRepo.findById(id);

		if(byId.isPresent()) {

			patientRepo.deleteById(id);
			
			return "Patient is Deleted with ID: "+id;
		}
		return "Patient ID is Invalid.";
	}
}
