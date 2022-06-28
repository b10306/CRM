package com.brian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.dao.CustomerDAO;
import com.brian.entity.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getAllCustomers(Model model) {
		List<Customer> list = customerDAO.getCustomers();
		model.addAttribute("customerList", list);
		return "customer";
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public String getCustomer(@PathVariable("id") Integer id, Model model) {
		Customer customer = customerDAO.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "update";
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	public String updateCustomer(Customer customer) {
		customerDAO.updateCustomerById(customer);
		return "redirect:/customer";
	}
	
	@RequestMapping(value = "/customer/test/{id}")
	public String deleteCustomer(@PathVariable("id") Integer id) {
		System.out.println(id);
		customerDAO.deleteCustomerById(id);
		return "redirect:/customer";
	}
}
