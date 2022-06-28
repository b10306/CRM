package com.brian.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brian.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public void updateCustomerById(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		Customer dbCustomer = session.get(Customer.class, customer.getId());
		dbCustomer.setName(customer.getName());
		dbCustomer.setEmail(customer.getEmail());
	}

	@Override
	@Transactional
	public void deleteCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer dbCustomer = session.get(Customer.class, id);
		session.delete(dbCustomer);
	}

}
