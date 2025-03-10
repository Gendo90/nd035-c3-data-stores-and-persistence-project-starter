package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.model.Schedule;
import com.udacity.jdnd.course3.critter.service.ScheduleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        
        schedule = scheduleService.saveSchedule(schedule, scheduleDTO.getEmployeeIds(), scheduleDTO.getPetIds());
        ScheduleDTO resultDto = new ScheduleDTO(schedule);
        
        return resultDto;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        Set<Schedule> resultSchedules = scheduleService.getAllSchedules();
        
        List<ScheduleDTO> resultScheduleDtos = new ArrayList<>();
        for (Schedule schedule : resultSchedules) {
        	ScheduleDTO resultScheduleDto = new ScheduleDTO(schedule);
        	resultScheduleDtos.add(resultScheduleDto);
        }
        
        return resultScheduleDtos;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        Set<Schedule> resultSchedules = scheduleService.getSchedulesByPetId(petId);
        
        List<ScheduleDTO> resultScheduleDtos = new ArrayList<>();
        for (Schedule s : resultSchedules) {
        	ScheduleDTO resultScheduleDto = new ScheduleDTO(s);
        	resultScheduleDtos.add(resultScheduleDto);
        }
        
        return resultScheduleDtos;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
    	Set<Schedule> resultSchedules = scheduleService.getSchedulesByEmployeeId(employeeId);
        
        List<ScheduleDTO> resultScheduleDtos = new ArrayList<>();
        for (Schedule s : resultSchedules) {
        	ScheduleDTO resultScheduleDto = new ScheduleDTO(s);
        	resultScheduleDtos.add(resultScheduleDto);
        }
        
        return resultScheduleDtos;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
    	Set<Schedule> resultSchedules = scheduleService.getSchedulesByCustomerId(customerId);
        
        List<ScheduleDTO> resultScheduleDtos = new ArrayList<>();
        for (Schedule s : resultSchedules) {
        	ScheduleDTO resultScheduleDto = new ScheduleDTO(s);
        	resultScheduleDtos.add(resultScheduleDto);
        }
        
        return resultScheduleDtos;
    }
}
