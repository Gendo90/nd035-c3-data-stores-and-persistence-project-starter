package com.udacity.jdnd.course3.critter.model;

import java.time.DayOfWeek;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

@Entity
public class Employee extends Person {
	public Employee() { }
	
	@ElementCollection(targetClass = DayOfWeek.class)
	private Set<DayOfWeek> daysAvailable;
	
	//Employee-specific fields
	@ManyToMany
	@JoinColumn(name = "schedule_id")
    private Set<Schedule> schedules;
	
	@ElementCollection(targetClass = EmployeeSkill.class)
	private Set<EmployeeSkill> skills;
	
	// Getters
	public Set<DayOfWeek> getDaysAvailable() {
		return daysAvailable;
	}
	
	public Set<Schedule> getSchedules() {
        return schedules;
    }
	
	public Set<EmployeeSkill> getSkills() {
        return skills;
    }
	
	// Setters
	public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
		this.daysAvailable = daysAvailable;
	}
	
    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }
    
    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
