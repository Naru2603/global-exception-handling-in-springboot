package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.entity.Employee;
import com.infy.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	
	@Override
	public Employee getEmployeeByName(String employeeName) {
		return employeeRepository.findEmployeeByName(employeeName);
	}

	@Override
	public Employee deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
