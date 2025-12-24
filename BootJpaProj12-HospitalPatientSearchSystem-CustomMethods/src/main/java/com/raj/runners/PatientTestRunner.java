package com.raj.runners;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Patient;
import com.raj.repository.IPatientRepository;

@Component
public class PatientTestRunner implements CommandLineRunner {

	@Autowired
	private IPatientRepository patientRepo;
	
	@Override
	public void run(String... args) throws Exception {

		try(Scanner sc = new Scanner(System.in)){

			while(true) {
				System.out.println("\n====== Hospital Management System ======");
				System.out.println("1. Add New Patient Details.");
				System.out.println("2. Find patients by disease.");
				System.out.println("3. Find patients by doctor name.");
				System.out.println("4. Find patients with age greater than a value.");
				System.out.println("5. Find patients admitted after a specific date.");
				System.out.println("6. Find patients who are not discharged.");
				System.out.println("7. Exit.");
        
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {

				case 1:
			
					System.out.print("Enter Patient Name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter Patient Disease: ");
					String disease = sc.nextLine();
					
					System.out.print("Enter Patient Doctor Name: ");
					String doctorName = sc.nextLine();
					
					System.out.print("Enter Patient Age: ");
					Integer age = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Patient Addmission Date(YYYY-MM-DD): ");
					LocalDate date = LocalDate.parse(sc.nextLine());
					
					System.out.print("Enter Patient Discharged: ");
					boolean discharged = Boolean.parseBoolean(sc.nextLine());
					
					Patient patient = new Patient(name, disease, doctorName, age, date, discharged);
							
					Patient save = patientRepo.save(patient);
					System.out.println("New Patient is Admitted with ID: "+save.getPatientID());
					break;
				case 2:
					System.out.print("Enter Patient Disease: ");
					disease = sc.nextLine();
                    patientRepo.findByDisease(disease).forEach(System.out::println);
					break;
				case 3:
					System.out.print("Enter Doctor Name: ");
					doctorName = sc.nextLine();
					patientRepo.findByDoctorName(doctorName).forEach(System.out::println);
					break;

				case 4:
					System.out.println("Enter patient age: ");
					age = Integer.parseInt(sc.nextLine());
					patientRepo.findByAgeGreaterThan(age).forEach(System.out::println);
					break;

				case 5:
					System.out.print("Enter specific Date: ");
					String d1 = sc.nextLine();
				    date = LocalDate.parse(d1);
                    patientRepo.findByAdmissionDateGreaterThan(date).forEach(System.out::println);
					break;

				case 6:
					System.out.print("Enter patient discharged(true/false): ");
					discharged = Boolean.parseBoolean(sc.nextLine());
					patientRepo.findByDischargedFalse(discharged).forEach(System.out::println);
					break;
				case 7:
					System.exit(0);
				default:
					System.err.println("Invalid Choice...");
				}
			}
		}catch (Exception e) {

			e.printStackTrace();
		}		
	}
}
