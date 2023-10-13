package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Employee;
import com.infy.exception.InValidInputException;
import com.infy.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/byName/{employeeName}")
	public Employee getEmployeeByName(@PathVariable("employeeName") String employeeName) {
		if((employeeName.length() > 2 ) && (isNameNotContainsDigits(employeeName)))
			return employeeService.getEmployeeByName(employeeName);
		else
			throw new InValidInputException("Invalid Employee Name");
	}
	
	private boolean isNameNotContainsDigits(String employeeName) {
		
		for(Character c : employeeName.toCharArray())
		{
			if(Character.isDigit(c))
				throw new InValidInputException("Name should not conatin any digit!!");
		}
		return true;
	}

	@GetMapping("/hello")
	public String hello(){
		return "Hello World..!!";

	}
}
