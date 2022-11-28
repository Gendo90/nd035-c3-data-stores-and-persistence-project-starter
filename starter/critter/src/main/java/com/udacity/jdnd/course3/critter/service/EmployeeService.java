package com.udacity.jdnd.course3.critter.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;

@Transactional
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee newEmployee) {
		Employee employee = employeeRepository.save(newEmployee);
		
		return employee;
	}
	
	public Employee getEmployee(long id) {
		 Employee employee = null;
		 Optional<Employee> optional = employeeRepository.findById(id);
		 
		 if(optional.isPresent()) {
			 employee = optional.get();
		 }
		 
		
		return employee;
	}
}
