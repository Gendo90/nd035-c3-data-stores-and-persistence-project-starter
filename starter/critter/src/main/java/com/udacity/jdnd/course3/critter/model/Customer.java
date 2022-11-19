package com.udacity.jdnd.course3.critter.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer extends Person {
	public Customer() { }
	
	//Customer-specific fields
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval=true)
	@JoinColumn(name = "pet_id")
	private Set<Pet> pets;
}
