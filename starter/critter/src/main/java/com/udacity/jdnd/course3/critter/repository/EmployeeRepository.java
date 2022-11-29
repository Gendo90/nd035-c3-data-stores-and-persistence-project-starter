package com.udacity.jdnd.course3.critter.repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>  {
	@Query("SELECT e FROM Employee e JOIN e.daysAvailable AS daysAvailable JOIN e.skills AS skills "
			+ "WHERE :available = daysAvailable "
			+ "AND (SELECT COUNT(s) FROM e.skills s WHERE s IN :skills) = :skill_count")
	public Optional<List<Employee>> findAllBySkillsAndAvailability(@Param("skills") Set<EmployeeSkill> skills, 
			@Param("skill_count") long count,
			@Param("available") DayOfWeek available);
}
