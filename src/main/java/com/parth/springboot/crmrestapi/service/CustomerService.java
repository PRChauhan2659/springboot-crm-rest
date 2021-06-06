package com.parth.springboot.crmrestapi.service;

import java.util.List;

import com.parth.springboot.crmrestapi.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int customerId);
	
	public void addCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
}
