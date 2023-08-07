package com.web.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.me.model.Employee;
import com.web.me.repository.EmployeeRepository;
@Service
public class EmployeeServiceByJPA implements EmployeeService  {

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public int addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Employee e=employeeRepository.save(emp);
		if(e!=null)
		    return 1;
		else
			return 0;
	}

	@Override
	public int updateEmployee(int empId, Employee emp) {
		Employee oldemp = employeeRepository.findById(empId).orElse(null);
		oldemp.setEmpId(emp.getEmpId());
		oldemp.setEmpName(emp.getEmpName());
		oldemp.setEmpSalary(emp.getEmpSalary());
		employeeRepository.save(oldemp);
		return 0;
	}

	@Override
	public int deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
		return 0;
	}

	@Override
	public Employee findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empId).orElse(null);
	}

	@Override
	public List<Employee> findAllEmployee() {
	
		return employeeRepository.findAll();
	}

}
