package com.raj.service;

import java.util.List;

import com.raj.entity.EmployeeInfo;

public interface IEmployeeMgmtService {

	String addNewEmployee(EmployeeInfo empInfo);
	List<EmployeeInfo> showAllEmplyeesInfo();
	EmployeeInfo fetchEmployeeInfoById(long id);
	String deleteEmployeeInfoById(long id);
}
