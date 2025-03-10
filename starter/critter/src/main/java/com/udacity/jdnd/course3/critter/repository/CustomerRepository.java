package com.udacity.jdnd.course3.critter.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public Optional<Customer> findByPetsId(Long id);
	
}
