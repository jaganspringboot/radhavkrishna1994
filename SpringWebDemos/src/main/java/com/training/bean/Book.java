package com.training.bean;

public class Book {
	private Long isbn;
	public Long getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public Double getPrice() {
		return price;
	}
	private String title;
	private Double price;
	public Book(Long isbn, String title, Double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}
	public Book() {
		super();
	}
	
	

}
