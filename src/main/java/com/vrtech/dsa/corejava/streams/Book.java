package com.vrtech.dsa.corejava.streams;

public class Book {
	
	private String id ;
	private String name;
	private int pages;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pages=" + pages + "]";
	}
	public Book(String id, String name, int pages) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

}
