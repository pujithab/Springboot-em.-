package com.example.demo.controller;

import java.io.IOException;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao  cdao;
	@RequestMapping("/customertest")
	public String booktest(Model model) {
		model.addAttribute("customertest", new Customer());	
		
		return "customer";
		
	}
	@RequestMapping(value = "/customertest", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Customer customer,Model model) throws IOException {
		
		cdao.saveCustomer(customer);
		Set<Customer> list=cdao.CustomerView();
		model.addAttribute("List", list);
		return "customerview";
	} 
	
	
	
	

}
