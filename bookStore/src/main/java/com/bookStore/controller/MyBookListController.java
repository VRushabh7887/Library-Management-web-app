package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.services.BookService;
import com.bookStore.services.MyBookListService;

@Controller
public class MyBookListController {
		
	@Autowired
	private MyBookListService service;

	@Autowired
	private BookService bookService;
		
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_books";
	}
	
	// can add this method seperately in this class instead of main book controller class
/**
	@GetMapping("/my_books")
	public String getMyBooks(Model model, Authentication authentication){
		if(authentication==null || !authentication.isAuthenticated()) {
			return "redirect:/login";
		}
		List<MyBookList>list=service.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id, Authentication authentication) {
		if(authentication==null || !authentication.isAuthenticated()) {
			return "redirect:/login";
			}
		
		Book b=bookService.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		service.saveMyBooks(mb);
		return "redirect:/my_books";
	 }
	**/
}
