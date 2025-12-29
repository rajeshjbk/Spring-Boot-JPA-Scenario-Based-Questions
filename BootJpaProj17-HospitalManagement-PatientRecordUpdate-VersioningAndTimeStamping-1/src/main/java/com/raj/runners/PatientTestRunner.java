package com.raj.runners;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Patient;
import com.raj.service.IPatientService;
@Component
public class PatientTestRunner implements CommandLineRunner {

	@Autowired
	private IPatientService patientService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("========== Hospital Management System ==========");
				System.out.println("1. Add New Patient.");
				System.out.println("2. Get Patient Record.");
				System.out.println("3. Get All Patient Records.");
				System.out.println("4. Update Diagnosis and Treatment.");
				System.out.println("5. Remove Patient.");
				System.out.println("6. Exit.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Patient Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Patient Diagnosis:");
					String diagnosis = sc.nextLine();
					System.out.print("Enter Patient Treatment:");
					String treatment = sc.nextLine();
					
					Patient patient = new Patient(name, diagnosis, treatment);
					
					String newPatient = patientService.addNewPatient(patient);
					System.out.println(newPatient);
					break;
					
				case 2:
					System.out.print("Enetr Patient ID: ");
					Integer id = Integer.parseInt(sc.nextLine());
					
					Optional<Patient> patientRecord = patientService.getPatientRecord(id);
					System.out.println(patientRecord.get());
					break;
					
				case 3:
					patientService.getAllPatientRecords().forEach(System.out::println);
					break;
					
				case 4:
					System.out.print("Enetr Patient ID: ");
					id = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Patient Diagnosis:");
					diagnosis = sc.nextLine();
					System.out.print("Enter Patient Treatment:");
					treatment = sc.nextLine();
					
					String updateDiagnosisAndTreatment = patientService.updateDiagnosisAndTreatment(id, diagnosis, treatment);
					System.out.println(updateDiagnosisAndTreatment);
					break;
					
				case 5:
					System.out.print("Enetr Patient ID: ");
					id = Integer.parseInt(sc.nextLine());
					
					String removePatient = patientService.removePatient(id);
					System.out.println(removePatient);
					break;
				case 6:
					System.exit(0);
				default:
					System.err.println("Invalid Choice..");
				}
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
