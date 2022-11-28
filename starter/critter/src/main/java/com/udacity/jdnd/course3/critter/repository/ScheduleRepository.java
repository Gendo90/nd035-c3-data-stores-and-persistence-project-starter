package com.udacity.jdnd.course3.critter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.model.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long>{

}
