package com.example.demo.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@Controller
public class BookController {
	@Autowired
	BookDao  bdao;
	
	@RequestMapping("/booktest")
	public String booktest(Model model) {
		model.addAttribute("testBook", new Book());		
		return "book";
	}
	@RequestMapping(value = "/booktest", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Book book) throws IOException {
		
		bdao.saveBook(book);

		return "redirect:/booktest";
	} 
	
	

}
