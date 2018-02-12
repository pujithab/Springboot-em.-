package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		/*bdao.BookUpdate();
		bdao.BookDelete();*/
		return "book";
		
	}
	
	@RequestMapping(value = "/booktest", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Book book,Model model) throws IOException {
		int result=bdao.RecordExistsOrNot(book);
		if(result == 1)
		{
		bdao.saveBook(book);
		}
		else
		{
			return "redirect/book";
		}
		List<Book> list=bdao.BookView();
		model.addAttribute("booksList", list);
		return "bookView";
	} 
	
	
	/*@RequestMapping(value = "/bookupdate", method = RequestMethod.GET)
	public void BookUpdate()  {
		
		bdao.BookUpdate();
	}*/
	@RequestMapping(value = "/bookupdate/{id}", method = RequestMethod.GET)	
	public String update(@PathVariable("id") int itemId, Model model) {

	    bdao.BookUpdate(itemId);
		return null; 

	}
	
	
	
	/*@RequestMapping(value = "/bookview", method = RequestMethod.GET)
	public String viewBooks(Model model)  {
		
		
		model.addAttribute("booksList", list);
				
		for(Book Details:list) {
			System.out.println("id="+Details.getId()+"name="+Details.getName());
		}
		
		return "bookView";
		

	} */
	

	/*
	@RequestMapping(value = "/bookDelete", method = RequestMethod.GET)
	public void BookDelete()  {
		
		bdao.BookDelete();
		

	} */
	
	@RequestMapping(value = "/Delete/{id}", method = RequestMethod.GET)	
	public String delete(@PathVariable("id") int itemId, Model model) {

	    bdao.BookDelete(itemId);
		return "redirect:../bookView"; 


	}
	

}
