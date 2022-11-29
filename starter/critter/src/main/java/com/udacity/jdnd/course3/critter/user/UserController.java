package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	EmployeeService employeeService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
    	Customer newCustomer = new Customer();
    	BeanUtils.copyProperties(customerDTO, newCustomer);

    	Customer resultCustomer = customerService.saveCustomer(newCustomer);
    	CustomerDTO resultCustomerDto = new CustomerDTO(resultCustomer);
    	
    	return resultCustomerDto;
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
    	Set<Customer> allCustomers = customerService.getAllCustomers();
    	List<CustomerDTO> allCustomerDtos = new ArrayList<>(); 

    	for (Customer customer : allCustomers) {
    		CustomerDTO customerDto = new CustomerDTO(customer);
    		allCustomerDtos.add(customerDto);
    	}
    	
    	return allCustomerDtos;
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        Customer petsOwner = customerService.getOwnerByPet(petId);
        
    	CustomerDTO resultCustomerDto = new CustomerDTO(petsOwner);
    	
    	return resultCustomerDto;
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
    	Employee newEmployee = new Employee();
    	BeanUtils.copyProperties(employeeDTO, newEmployee);

    	Employee resultEmployee = employeeService.saveEmployee(newEmployee);
    	EmployeeDTO resultEmployeeDto = new EmployeeDTO(resultEmployee);
    	
    	return resultEmployeeDto;
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        Employee retrievedEmployee = employeeService.getEmployee(employeeId);
        
        EmployeeDTO resultEmployeeDto = new EmployeeDTO();
    	BeanUtils.copyProperties(retrievedEmployee, resultEmployeeDto);
    	
    	return resultEmployeeDto;
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeeService.setAvailability(employeeId, daysAvailable);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }

}
