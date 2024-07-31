package com.book.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.book.Entity.Book;
import com.book.repository.BookRepository;
import com.book.service.bookService;

@Service
public class bookimpl  implements bookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll() ;
	}

	@Override
	public Book getBookById(int id) {
		return bookRepository.findById(id).orElseThrow();
	}

}
