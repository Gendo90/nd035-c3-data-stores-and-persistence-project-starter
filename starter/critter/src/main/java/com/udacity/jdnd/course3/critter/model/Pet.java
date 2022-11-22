package com.udacity.jdnd.course3.critter.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.udacity.jdnd.course3.critter.pet.PetType;

@Entity
public class Pet {
	@Id
	@GeneratedValue
	private Long id;
	
    private PetType type;
    
    private String name;
    
    private LocalDate birthDate;
    
    private String notes;
    
	public Pet() { }
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Customer owner;
	
	//Getters
	public Long getId() {
		return this.id;
	}
	
	public PetType getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	
	public String getNotes() {
		return this.notes;
	}
	
	public Customer getOwner() {
		return this.owner;
	}
	
	//Setters
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setType(PetType type) {
		this.type = type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
}
