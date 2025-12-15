package com.raj.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.BootJpaProj03StudentManagementSystemMongoRepositoryApplication;
import com.raj.document.Student;
import com.raj.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

    private final BootJpaProj03StudentManagementSystemMongoRepositoryApplication bootJpaProj03StudentManagementSystemMongoRepositoryApplication;

	@Autowired
	private IStudentRepository studentRepo;

    StudentServiceImpl(BootJpaProj03StudentManagementSystemMongoRepositoryApplication bootJpaProj03StudentManagementSystemMongoRepositoryApplication) {
        this.bootJpaProj03StudentManagementSystemMongoRepositoryApplication = bootJpaProj03StudentManagementSystemMongoRepositoryApplication;
    }

	@Override
	public String addStudent(Student stu) {
		
		Student save = studentRepo.save(stu);
		return "New Student is registered with ID: "+save.getStudentId();
	}

	@Override
	public String addMultipleStudents(List<Student> list) {
		
		List<Student> saveAll = studentRepo.saveAll(list);
		return saveAll.size()+" Students is registered with IDs: ";
	}

	@Override
	public Iterable<Student> getAllStudents() {
		
		List<Student> all = studentRepo.findAll();
		return all;
	}

	@Override
	public Student getStudentById(String id) {
		
		Optional<Student> byId = studentRepo.findById(id);
		return byId.get();
	}

	@Override
	public String updateStudentMarks(String id) {

		Scanner sc = new Scanner(System.in);
       
		Student student = studentRepo.findById(id).get();
		System.out.print("Enter new marks: ");
		Double newPrice = Double.parseDouble(sc.nextLine());
		
		student.setMarks(newPrice);
		
		Student save = studentRepo.save(student);
       
		return "Student Makrs is Updated with new Marks: "+save.getStudentId();
	}

	@Override
	public String deleteStudent(String id) {
		
        studentRepo.delete(studentRepo.findById(id).get());
        
		return "ID: "+id+" Student is deleted.";
	}

	@Override
	public long countStudents() {
		
		long count = studentRepo.count();
		return count;
	}

	@Override
	public boolean checkStudentExists(String id) {
		
		return studentRepo.existsById(id);
	}
}
