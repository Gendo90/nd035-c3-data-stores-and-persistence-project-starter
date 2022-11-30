package com.udacity.jdnd.course3.critter.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
		// need to resave the employees, pets with the new schedule
		scheduledEmployees.forEach(a -> a.addSchedule(schedule));
		employeeService.saveAllUpdatedEmployees(scheduledEmployees);
		
		scheduledPets.forEach(a -> a.addSchedule(schedule));
		petService.saveAllUpdatedPets(scheduledPets);
		
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

	public Set<Schedule> getSchedulesByPetId(long petId) {
		List<Schedule> retrievedSchedules = scheduleRepository.findAllByPetsId(petId);
		Set<Schedule> results = new HashSet<>();
		
		for (Schedule s : retrievedSchedules) {
			results.add(s);
		}
		
		return results;
	}

	public Set<Schedule> getSchedulesByEmployeeId(long employeeId) {
		List<Schedule> retrievedSchedules = scheduleRepository.findAllByEmployeesId(employeeId);
		Set<Schedule> results = new HashSet<>();
		
		for (Schedule s : retrievedSchedules) {
			results.add(s);
		}
		
		return results;
	}

	public Set<Schedule> getSchedulesByCustomerId(long customerId) {
		List<Schedule> retrievedSchedules = scheduleRepository.findAllByPetsOwnerId(customerId);
		Set<Schedule> results = new HashSet<>();
		
		for (Schedule s : retrievedSchedules) {
			results.add(s);
		}
		
		return results;
	}

}
