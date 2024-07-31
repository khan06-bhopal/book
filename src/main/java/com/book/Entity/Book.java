package com.book.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String bookname;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
	public Book(int id, String bookname, Author author) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
