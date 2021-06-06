package com.parth.springboot.crmrestapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parth.springboot.crmrestapi.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Customer> getCustomers() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Customer> query = session.createQuery("from Customer c order by c.lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
		
	}

	@Override
	public Customer getCustomer(int customerId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Customer customer = session.get(Customer.class, customerId);
		
		return customer;
		
	}

	@Override
	public void addCustomer(Customer customer) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Customer where id = :employeeId");
		
		query.setParameter("employeeId", customerId);
		
		query.executeUpdate();
		
	}

}
