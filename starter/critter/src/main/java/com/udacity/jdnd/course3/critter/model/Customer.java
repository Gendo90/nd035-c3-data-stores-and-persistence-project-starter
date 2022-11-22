package com.udacity.jdnd.course3.critter.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.BeanUtils;

@Entity
public class Customer extends Person {
	public Customer() { }
	
	//Customer-specific fields
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval=true)
	private Set<Pet> pets;
	
	//Getters
	public Set<Pet> getPets() {
		return this.pets;
	}
	
	//Setters
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
	public void addPet(Pet pet) {
		this.pets.add(pet);
	}
	
	public void removePet(Pet pet) {
		this.pets.remove(pet);
	}
}
