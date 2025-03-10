package com.udacity.jdnd.course3.critter.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
	public Optional<List<Pet>> findAllByOwnerId(Long ownerId);
	
}