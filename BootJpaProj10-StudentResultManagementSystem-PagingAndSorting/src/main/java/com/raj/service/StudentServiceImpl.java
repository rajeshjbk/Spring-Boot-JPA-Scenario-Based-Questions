package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.raj.entity.Student;
import com.raj.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepo;
	
	@Override
	public String addStudent(Student stu) {
		
		Student save = studentRepo.save(stu);
		return "New Student is added with ID: "+save.getStudentId();
	}

	@Override
	public Page<Student> fetchStudentsByPaging(int pageSize, int pageNo) {
		
		//create Pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> all = studentRepo.findAll(pageable);		
		return all;
	}

	@Override
	public Iterable<Student> sortStudents(boolean ascOrder, String... props) {
		
		//create Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);
		
		Iterable<Student> all = studentRepo.findAll(sort);
		return all;
	}

}
