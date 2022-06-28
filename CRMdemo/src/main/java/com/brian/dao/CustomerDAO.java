package com.brian.dao;

import java.util.List;

import com.brian.entity.Customer;

public interface CustomerDAO {
	List<Customer> getCustomers();
	void addCustomer(Customer customer);
	Customer getCustomerById(int id);
	void updateCustomerById(Customer customer);
	void deleteCustomerById(int id);
}
