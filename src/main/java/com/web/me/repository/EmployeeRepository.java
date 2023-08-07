package com.web.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.me.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
