package com.udacity.jdnd.course3.critter.service;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;

@Transactional
@Service
public class PetService {
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	CustomerService customerService;
	
	public Pet savePet(Pet newPet, long ownerId) {
		Customer owner = customerService.getCustomer(ownerId);
		
		newPet.setOwner(owner);
		
		Pet pet = petRepository.save(newPet);
		
		owner.addPet(pet);
		customerService.saveCustomer(owner);
		
		return pet;
	}
	
	public Pet getPet(long id) {
		Pet pet = null;
		Optional<Pet> optional = petRepository.findById(id);
		
		if(optional.isPresent()) {
			pet = optional.get();
		}
		
		return pet;
	}
	
	public Set<Pet> getAllByIds(List<Long> petIds) {
		Set<Pet> pets = new HashSet<>();
		Iterable<Pet> results = petRepository.findAllById(petIds);
		
		for (Pet p : results) {
			pets.add(p);
		}
		
		return pets;
	}
	
	public List<Pet> getPetsByOwner(long ownerId) {
		List<Pet> retrievedPets = null;
		
		Optional<List<Pet>> optional = petRepository.findAllByOwnerId(ownerId);
		
		if(optional.isPresent()) {
			retrievedPets = optional.get();
		}
		
		return retrievedPets;
	}

	public void saveAllUpdatedPets(Iterable<Pet> scheduledPets) {
		petRepository.saveAll(scheduledPets);
	}
}
