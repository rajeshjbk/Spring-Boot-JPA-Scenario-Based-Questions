package com.raj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Student;
import com.raj.repository.IStudentRepositiry;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private IStudentRepositiry studentRepo;

	@Override
	public String registerNewStudent(Student stu) {
		Integer rollNo = studentRepo.save(stu).getRollNo();
		return "New Student is Registered with Roll No: "+rollNo;
	}

	@Override
	public String registerMultipleNewStudents(List<Student> list) {

		List<Student> saveAll = studentRepo.saveAll(list);
		List<Integer> rollList = StreamSupport.stream(saveAll.spliterator(), false).map(Student::getRollNo).collect(Collectors.toList());
		return "New Students are Registered with Roll No are: "+rollList;
	}

	@Override
	public List<Student> getAllStudents() {


		return studentRepo.findAll();
	}

	@Override
	public Student getStudentRollNo(int rollNo) {

		Student student = studentRepo.findById(rollNo).orElseThrow(()-> new IllegalArgumentException("Invalid Roll No."));
		return student;
	}

	@Override
	public String updateMarks(int rollNo, double newMarks) {

		Optional<Student> byId = studentRepo.findById(rollNo);

		if(byId.isPresent()) {

			Student student = byId.get();
			student.setMarks(newMarks);

			studentRepo.save(student);

			return "Roll No: "+rollNo+" , Marks is Updated.";
		}
		return "Wrong Roll No: "+rollNo;
	}

	@Override
	public String updateResult(int rollNo, String newResult) {

		Optional<Student> byId = studentRepo.findById(rollNo);

		if(byId.isPresent()) {

			Student student = byId.get();
			student.setResult(newResult);

			studentRepo.save(student);

			return "Roll No: "+rollNo+" , Result is Updated.";
		}
		return "Wrong Roll No: "+rollNo;

	}

	@Override
	public List<Student> getPassedStudents(String pass) {

		return studentRepo.getPassedStudents(pass);
	}

	@Override
	public List<Student> getFailedStudents(String fail) {
		
		return studentRepo.getFailedStudents(fail);
	
	}

	@Override
	public List<Student> getStudentsAbove75(double max) {
		
		return studentRepo.getStudentsAbove75(max);
	}

	@Override
	public long countTotalStudents() {

		return studentRepo.count();
	}

	@Override
	public int countPassedStudents() {
		
		return studentRepo.getPassedStudents("Pass").size();
	}

	@Override
	public int countFailedStudents() {
		
        return studentRepo.getFailedStudents("Fail").size();
		
	}

	@Override
	public Student getTopperStudent() {
		
		return studentRepo.getTopperStudent();
	}

	@Override
	public Student getLowestMarksStudent() {
		
		return studentRepo.getLowestMarksStudent();
	}

}
