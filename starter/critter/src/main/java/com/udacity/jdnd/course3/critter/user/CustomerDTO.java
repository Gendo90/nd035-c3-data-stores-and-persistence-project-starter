package com.udacity.jdnd.course3.critter.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
public class CustomerDTO {
    private long id;
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Long> petIds;
    
    public CustomerDTO() { }
    
    public CustomerDTO(Customer customer) {
    	BeanUtils.copyProperties(customer, this);
    	List<Long> petIds = new ArrayList<>();
    	
    	for (Pet pet : customer.getPets()) {
    		petIds.add(pet.getId());
    	}
    	this.petIds = petIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
