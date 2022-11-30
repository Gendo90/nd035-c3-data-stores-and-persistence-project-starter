package com.udacity.jdnd.course3.critter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.model.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long>{
	public List<Schedule> findAllByPetsId(long petId);

	public List<Schedule> findAllByEmployeesId(long employeeId);

	public List<Schedule> findAllByPetsOwnerId(long customerId);
}
