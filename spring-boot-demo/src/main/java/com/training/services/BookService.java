package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;
import com.training.repo.BookRepo;

@Service
public class BookService implements BookServiceI{
	
	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book addBook(Book book) {
		
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book getBook(Long isbn) {
		
		Optional<Book> opBook = bookRepo.findById(isbn);
		if(opBook.isPresent())
		return opBook.get();
		else
			return null;
	}

	@Override
	public Book deleteBook(Long isbn) {
		Book book = getBook(isbn);
		if(book!=null)
		bookRepo.delete(book);
		return book;
	}

	@Override
	public Book updateBook(Long isbn, Long newStock) {
		Book book = getBook(isbn);
		if(book!=null)
		{
			book.setStock(book.getStock()+newStock);
			bookRepo.save(book);
		}
		return book;
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return bookRepo.findByTitle(title);
	}
	
	
	
	

}
