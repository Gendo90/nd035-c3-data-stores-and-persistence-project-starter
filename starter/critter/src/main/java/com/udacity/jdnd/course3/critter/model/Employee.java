package com.udacity.jdnd.course3.critter.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

@Entity
public class Employee extends Person {
	public Employee() { }
	
	//Employee-specific fields
	@ElementCollection(targetClass = EmployeeSkill.class)
	private Set<EmployeeSkill> skills;
	
	public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }
}
