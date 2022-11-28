package com.udacity.jdnd.course3.critter.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;

@Transactional
@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer newCustomer) {
		Customer customer = customerRepository.save(newCustomer);
		
		return customer;
	}
	
	public Customer getCustomer(long id) {
		Customer result = null;
		
		Optional<Customer> optional = customerRepository.findById(id);
		
		if(optional.isPresent()) {
			result = optional.get();
		}
		
		return result;
	}
	
	public Customer getOwnerByPet(long id) {
		Customer result = null;
		
		Optional<Customer> optional = customerRepository.findByPetsId(id);
		
		if(optional.isPresent()) {
			result = optional.get();
		}
		
		return result;
	}
	
	public Set<Customer> getAllCustomers() {
		Iterable<Customer> allCustomersFromDB = customerRepository.findAll();
		Set<Customer> allCustomers = new HashSet<>();
		
		for (Customer customer : allCustomersFromDB) {
			allCustomers.add(customer);
		}
		
		return allCustomers;
	}
}
