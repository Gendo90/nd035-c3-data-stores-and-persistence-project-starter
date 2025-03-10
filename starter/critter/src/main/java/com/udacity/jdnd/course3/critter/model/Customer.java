package com.udacity.jdnd.course3.critter.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Customer extends Person {
	public Customer() { }
	
	//Customer-specific fields
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval=true)
	private Set<Pet> pets = new HashSet<>();
	
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
