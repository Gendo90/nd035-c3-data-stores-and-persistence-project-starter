package com.udacity.jdnd.course3.critter.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.model.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;

@Transactional
@Service
public class ScheduleService {
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	PetService petService;
	
	public ScheduleService() {}
	
	public Schedule saveSchedule(Schedule newSchedule, List<Long> employeeIds, List<Long> petIds) {
		// need to add employees, pets to the new schedule before saving it
		Set<Employee> scheduledEmployees = employeeService.getAllByIds(employeeIds); 
		newSchedule.setEmployees(scheduledEmployees);
		
		Set<Pet> scheduledPets = petService.getAllByIds(petIds); 
		newSchedule.setPets(scheduledPets);
		
		Schedule schedule = scheduleRepository.save(newSchedule);
		
		return schedule;
	}
	
	public Set<Schedule> getAllSchedules() {
		Iterable<Schedule> allSchedulesFromDB = scheduleRepository.findAll();
		Set<Schedule> allSchedules = new HashSet<>();
		
		for (Schedule schedule : allSchedulesFromDB) {
			allSchedules.add(schedule);
		}
		
		return allSchedules;
	}

}
