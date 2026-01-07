package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.EmployeeInfo;
import com.raj.repository.IEmployeeRepository;
@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Override
	public String addNewEmployee(EmployeeInfo empInfo) {
		
		Long empId = employeeRepo.save(empInfo).getEmpId();
		return "New Employee is added with EMP_ID: "+empId;
	}

	@Override
	public List<EmployeeInfo> showAllEmplyeesInfo() {
		
		return employeeRepo.findAll();
	}

	@Override
	public EmployeeInfo fetchEmployeeInfoById(long id) {
		
		return employeeRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id."));
	}

	@Override
	public String deleteEmployeeInfoById(long id) {
		
		employeeRepo.deleteById(id);
		return "EMP_ID: "+id+" Employee Information is Deleted.";
	}

}
