package com.udacity.jdnd.course3.critter.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

@Entity
public class Schedule {
	@Id
	@GeneratedValue
	private Long id;
	
	// may need to add initial hashsets for employees and pets
	@ManyToMany(mappedBy = "schedules")
	private Set<Employee> employees;
	
	@ManyToMany(mappedBy = "schedules")
    private Set<Pet> pets;
	
    private LocalDate date;
    
    @ElementCollection(targetClass = EmployeeSkill.class)
    private Set<EmployeeSkill> activities;
    
    public Schedule() { }

    // Getters
    public long getId(){
        return id;
    }
    
    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Pet> getPets() {
        return pets;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public Set<EmployeeSkill> getActivities() {
        return activities;
    }
    
    // Setters
    public void setId(long id){
        this.id = id;
    }
    
    // May want change these methods to add an employee or pet
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
