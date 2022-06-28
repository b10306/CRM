package com.brian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.dao.CustomerDAO;
import com.brian.entity.Customer;

@Controller
public class AddController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String test(Customer customer) {
		customerDAO.addCustomer(customer);
		return "redirect:/customer";
	}
}
