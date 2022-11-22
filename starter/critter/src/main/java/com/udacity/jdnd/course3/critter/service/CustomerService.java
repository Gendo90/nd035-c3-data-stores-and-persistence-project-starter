package com.udacity.jdnd.course3.critter.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer newCustomer) {
		Customer customer = customerRepository.save(newCustomer);
		
		return customer;
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
