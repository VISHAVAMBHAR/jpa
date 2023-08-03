package com.web.me.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.me.model.Employee;

@Service
public class EmployeeServiceWithCollection implements EmployeeService {
	
	private List<Employee> emplist= new ArrayList<>();
	
	

	public EmployeeServiceWithCollection() 
	{
	  emplist.add(new Employee(101,"Ram", 65000));	
	  emplist.add(new Employee(102,"Krushna", 90000));	
	  emplist.add(new Employee(103,"Laxman", 55000));	
	  emplist.add(new Employee(104,"Shree", 60000));	
	  emplist.add(new Employee(105,"RamKumar", 80000));	
	}
	
	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return emplist;
	}

	@Override
	public int addEmployee(Employee emp) {
		boolean flag= emplist.add(emp);
		System.out.println(emp);
		return flag?1:0;
	}

	@Override
	public int updateEmployee(int empId, Employee emp) {
		for(Employee employee:emplist)
		{
			if(employee.getEmpId()==empId)
			{
				int index = emplist.indexOf(employee);
				emplist.set(index, emp);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		for(Employee employee:emplist)
		{
			if(employee.getEmpId()==empId)
			{
				emplist.remove(employee);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public Employee findEmployeeById(int empId) {
		for(Employee employee:emplist)
		{
			if(employee.getEmpId()==empId)
			{
				emplist.remove(employee);
				return employee;
			}
		}
		
		return null;
	}

	

}
