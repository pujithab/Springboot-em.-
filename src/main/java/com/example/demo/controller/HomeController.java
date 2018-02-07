package com.example.demo.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.TestDao;
import com.example.demo.model.Employee;
import com.example.demo.model.Test;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeDao  edao;
	
	
	@RequestMapping("/")
	public String homeUser(Model model) {
	model.addAttribute("userForm", new Employee());
		return "emp";
	}
	
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Employee emp) throws IOException {
		
		edao.saveEmployee(emp);

		return "redirect:/";
	} 
	
	
	
	
	
	@RequestMapping("/test1")
	public String test1(Model model) {
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(Model model) {
		return "test2";
	}
	
	
	
	
	
}
