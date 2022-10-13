package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;
import com.training.services.BookService;


@RequestMapping("bookstore/api")
@RestController
public class BookController { 

	@Autowired
	private BookServiceI bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}
	
	@GetMapping("/book/isbn/{isbn}")        //http://localhost:8081/bookstore/api/book/isbn/1234
	public ResponseEntity<Book> getBook(@PathVariable("isbn") Long isbn)
	{
		
		Book book = bookService.getBook(isbn);
		if(book!=null)
			return new ResponseEntity<Book>(book,HttpStatus.FOUND);
		
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		return new ResponseEntity<Book>(bookService.addBook(book),HttpStatus.CREATED);
				
	}
	
	@DeleteMapping("/book/isbn/{isbn}")        //http://localhost:8081/bookstore/api/book/isbn/1234
	public ResponseEntity<Book> deleteBook(@PathVariable("isbn") Long isbn)
	{
		
		Book book = bookService.deleteBook(isbn);
		if(book!=null)
			return new ResponseEntity<Book>(book,HttpStatus.OK);
		
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/book/isbn/{isbn}/stock/{newstock}")        //http://localhost:8081/bookstore/api/book/isbn/1234
	public ResponseEntity<Book> updateBook(@PathVariable("isbn") Long isbn,
			@PathVariable("newstock") Long newStock)
	{
		Book book = bookService.updateBook(isbn, newStock);
		if(book!=null)
			return new ResponseEntity<Book>(book,HttpStatus.OK);
		
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/book/title/{title}")        //http://localhost:8081/bookstore/api/book/isbn/1234
	public List<Book> getBookTitle(@PathVariable("title") String title)
	{
		
		List<Book> books = bookService.findByTitle(title);
		return books;
	}
	
}
