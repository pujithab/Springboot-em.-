package com.example.demo.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.TestDao;
import com.example.demo.model.Test;
@Controller
public class TestControllerDao {
	
	@Autowired
	TestDao  tdao;
	

	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("testForm", new Test());		
		return "test";
	}
	
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Test test) throws IOException {
		
		tdao.saveTest(test);

		return "redirect:/test";
	} 

}
