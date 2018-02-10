package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.TestDao;
import com.example.demo.model.Book;
import com.example.demo.model.Test;
@Controller
public class TestControllerDao {
	
	@Autowired
	TestDao  tdao;
	

	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("testForm", new Test());
		tdao.TestUpdate();
		tdao.TestDelete();
		
		return "test";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Test test) throws IOException {
		
		tdao.saveTest(test);

		return "redirect:/test";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewTest(Model model)  {
		List<Test> list=tdao.TestView();
		for(Test Details:list) {
			System.out.println("id="+Details.getId()+"name="+Details.getLname());
		}
		
		return null;
		

	} 
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void TestUpdate()  {
		
		tdao.TestUpdate();
		

	} 
	@RequestMapping(value = "/Delete", method = RequestMethod.GET)
	public void TestDelete()  {
		
		tdao.TestDelete();
		

	} 
	
	@RequestMapping(value = "/testDelete/{id}", method = RequestMethod.GET)	
	public void delete(@PathVariable("id") int itemId, Model model) {

	    tdao.TestDelete(itemId); 


	}
	
	

}
