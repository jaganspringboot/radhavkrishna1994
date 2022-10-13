package com.training.interfaces;

import java.util.List;

import com.training.model.Book;

public interface BookServiceI {
	
	public Book addBook(Book book);
	public List<Book> getBooks();
	public Book getBook(Long isbn);
	public Book deleteBook(Long isbn);
	public Book updateBook(Long isbn,Long newStock);
	public List<Book> findByTitle(String title);

}
