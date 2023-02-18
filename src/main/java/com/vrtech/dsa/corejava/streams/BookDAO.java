package com.vrtech.dsa.corejava.streams;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	private List<Book> books;
	
	
	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public BookDAO(){		
		books=new ArrayList<Book>();		
		Book b1=new Book("1", "Java", 200);
		Book b2=new Book("2", "HTML", 100);
		Book b3=new Book("3", "Python", 50);
		books.add(b1);
		books.add(b2);
		books.add(b3);
	}
}
