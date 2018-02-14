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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@Controller
public class BookController {
	@Autowired
	BookDao  bdao;
	
	@RequestMapping("/booktest")
	public String booktest(Model model) {
		model.addAttribute("testBook", new Book());	
		List<Book> list=bdao.BookView();
		model.addAttribute("booksList", list);
		/*bdao.BookUpdate();
		bdao.BookDelete();*/
		return "book";
		
	}
	
	@RequestMapping(value = "/booktest", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Book book,Model model,RedirectAttributes redir) throws IOException {
		if(book.getId()==0)
		{
		int result=bdao.RecordExistsOrNot(book);
		System.out.println( result );
		if(result == 1)
		{
		bdao.saveBook(book);
		}
		else
		{
			redir.addFlashAttribute("msg", "Record exists");
			redir.addFlashAttribute("cssMsg", "danger");
			return "redirect:booktest";
		}
		
		}
		else
		{
			bdao.updateBook(book);
			redir.addFlashAttribute("msg", "Record update successfully");
			redir.addFlashAttribute("cssMsg", "success");
			return "redirect:booktest";
			
		}
		
		List<Book> list=bdao.BookView();
		model.addAttribute("booksList", list);
		redir.addFlashAttribute("msg", "Record inserted");
		redir.addFlashAttribute("cssMsg", "success");
		return "redirect:booktest";
	} 
	
	
	/*@RequestMapping(value = "/bookupdate", method = RequestMethod.GET)
	public void BookUpdate()  {
		
		bdao.BookUpdate();
	}*/
	
	@RequestMapping(value = "/bookupdate/{id}", method = RequestMethod.GET)	
	public String update(@PathVariable("id") int itemId, Model model) {
		List<Book> list=bdao.BookView();
		model.addAttribute("booksList", list);

	    bdao.BookUpdate(itemId);
		return "book"; 

	}
	
	
	
	@RequestMapping(value = "/bookview", method = RequestMethod.GET)
	public String viewBooks(Model model)  {
		
		List<Book> list=bdao.BookView();
		model.addAttribute("booksList", list);
				
		
		return "bookView";
		

	} 
	

	/*
	@RequestMapping(value = "/bookDelete", method = RequestMethod.GET)
	public void BookDelete()  {
		
		bdao.BookDelete();
		

	} */
	
	@RequestMapping(value = "/delete")	
	public String deleteBook(@RequestParam(value ="id",required=true)String id, Model model,RedirectAttributes redir) {

		int id1 = Integer.parseInt(id);
	   int status = 0;
	try {
		status = bdao.BookDelete(id1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   if(status == 1)
	   {
		   redir.addFlashAttribute("msg", "Record deleted");
			redir.addFlashAttribute("cssMsg", "success");
		return "redirect:booktest";
	   }
	   else
		   redir.addFlashAttribute("msg", "Record notdeleted");
		redir.addFlashAttribute("cssMsg", "success");
	return "redirect:booktest"; 
	   

	}
	
	
	@RequestMapping(value = "/edit")	
	public String editBook(@RequestParam(value ="id",required=true)String id, Model model,RedirectAttributes redir) {

		int id1= Integer.parseInt(id);
		Book b= bdao.getBookById(id1);
		System.out.println(b);
		
		model.addAttribute("testBook", b);	
		List<Book> list=bdao.BookView();
		model.addAttribute("booksList", list);
		return "book";
		
	}

}
