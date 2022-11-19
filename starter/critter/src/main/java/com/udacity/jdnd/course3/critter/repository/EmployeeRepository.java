package com.udacity.jdnd.course3.critter.repository;

import org.springframework.data.repository.CrudRepository;

import com.udacity.jdnd.course3.critter.model.Employee;

public interface EmployeeRepository extends CrudRepository<Long, Employee>  {

}
