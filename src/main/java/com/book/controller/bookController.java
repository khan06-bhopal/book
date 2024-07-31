package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.Entity.Book;
import com.book.service.bookService;

@RestController
@RequestMapping("/book")
public class bookController {
	
	@Autowired
	private bookService bservice;

	@PostMapping
	public Book saveBook(@RequestBody Book book) { 
		
		return bservice.saveBook(book);
	}
	
	@GetMapping
	public List<Book> gellAllBooks(){ 
		return bservice.getAllBook();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) { 
		return bservice.getBookById(id);
	}
}
