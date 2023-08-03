package com.web.me.service;

import java.util.List;

import com.web.me.model.Employee;

public interface EmployeeService {
	int addEmployee(Employee emp);
	int updateEmployee(int empId,Employee emp);
	int deleteEmployee(int empId);
	
	Employee findEmployeeById(int empId);
	List<Employee> findAllEmployee();
}
