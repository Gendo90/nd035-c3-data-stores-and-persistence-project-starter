package com.udacity.jdnd.course3.critter.service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

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
	
	public Set<Employee> getAllByIds(List<Long> employeeIds) {
		Set<Employee> employees = new HashSet<>();
		Iterable<Employee> results = employeeRepository.findAllById(employeeIds);
		
		for (Employee e : results) {
			employees.add(e);
		}
		
		return employees;
	}
	
	public Employee setAvailability(long id, Set<DayOfWeek> available) {
		Employee employee = this.getEmployee(id);
		employee.setDaysAvailable(available);
		employee = employeeRepository.save(employee);
		
		return employee;
	}
	
	public List<Employee> getBySkillsAndAvailability(Set<EmployeeSkill> skills, DayOfWeek available) {
		List<Employee> matchingEmployees = new ArrayList<>();
		Optional<Set<Employee>> optional = employeeRepository.findAllBySkillsAndAvailability(skills, skills.size(), 
				available);
		
		if(optional.isPresent()) {
			matchingEmployees = new ArrayList<>(optional.get());
		}
		
		return matchingEmployees;
	}

	public void saveAllUpdatedEmployees(Iterable<Employee> updatedEmployees) {
		employeeRepository.saveAll(updatedEmployees);
	}
}
