package com.udacity.jdnd.course3.critter.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet {
	public Pet() { }
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Customer owner;
}
