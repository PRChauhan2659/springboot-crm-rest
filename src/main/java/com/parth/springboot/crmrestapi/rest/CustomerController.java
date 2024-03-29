package com.parth.springboot.crmrestapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parth.springboot.crmrestapi.dao.CustomerDAO;
import com.parth.springboot.crmrestapi.entity.Customer;
import com.parth.springboot.crmrestapi.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
		
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer( @PathVariable int customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer == null) {
			throw new RuntimeException("Customer with id : " + customerId + " not found.");
		}
		
		return customer;
		
	}
	
	@PostMapping("/customers")
	public Customer addCustomer( @RequestBody Customer customer) {
		
		customer.setId(0);
		
		customerService.addCustomer(customer);
		
		return customer;
		
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer( @RequestBody Customer customer) {
		
		customerService.addCustomer(customer);
		
		return customer;
		
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer( @PathVariable int customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer == null) {
			throw new RuntimeException("Customer with id : " + customerId + " not found.");
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Customer with id : " + customerId + " deleted.";
		
	}
	
}
