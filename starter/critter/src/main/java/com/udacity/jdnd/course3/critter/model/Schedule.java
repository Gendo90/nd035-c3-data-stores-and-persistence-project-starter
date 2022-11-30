package com.udacity.jdnd.course3.critter.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy = "schedules")
	private Set<Employee> employees = new HashSet<>();
	
	@ManyToMany(mappedBy = "schedules")
    private Set<Pet> pets = new HashSet<>();;
	
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
