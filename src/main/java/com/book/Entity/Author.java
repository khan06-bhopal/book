package com.book.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

	private int  authorId;
	private String firstName;
	private String lastname;
	private String lanuage;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	
	private Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author(int authorId, String firstName, String lastname, String lanuage) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.lanuage = lanuage;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLanuage() {
		return lanuage;
	}
	public void setLanuage(String lanuage) {
		this.lanuage = lanuage;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastname=" + lastname + ", lanuage="
				+ lanuage + "]";
	}
	
	
}
