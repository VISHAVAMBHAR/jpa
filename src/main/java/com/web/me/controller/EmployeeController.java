package com.web.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.me.model.Employee;
import com.web.me.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView emplist() 
	{
	  
	  List<Employee> elist= employeeService.findAllEmployee();
	  ModelAndView mv=new ModelAndView();
	  mv.addObject("emplist", elist);
	  mv.setViewName("emplist");
	  return mv;
	}
	
	@GetMapping(value = "/form")
	public String empform()
	{
		return "empform";
	}
	@PostMapping(value = "/save")
	public String empsave(@ModelAttribute Employee emp)
	{
		//System.out.println("before ser "+emp);
		employeeService.addEmployee(emp);
		//System.out.println(emp);
		return "redirect:/employee/list";
	}
	@GetMapping(value = "/delete/{empId}")
	public String empDelete(@PathVariable int empId)
	{
		employeeService.deleteEmployee(empId);
		return "redirect:/employee/list";
	}
	@GetMapping(value = "/update/{empId}")
	public ModelAndView empEdit(@PathVariable int empId)
	{
		Employee emp= employeeService.findEmployeeById(empId);
		ModelAndView mv=new ModelAndView();
		mv.addObject("emp", emp);
		mv.setViewName("empupdateform");
		return mv;
	}
	@PostMapping(value = "/update/{empId}")
	public String updateEmp(@PathVariable int empId,@ModelAttribute Employee emp)
	{
		employeeService.updateEmployee(empId, emp);
		return "redirect:/employee/list";
	}
	

}
