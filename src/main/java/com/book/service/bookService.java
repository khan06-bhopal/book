package com.book.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.book.Entity.Book;

public interface bookService {

	Book saveBook(Book book);
	
	List<Book> getAllBook();
	
	Book getBookById(int id);
}
