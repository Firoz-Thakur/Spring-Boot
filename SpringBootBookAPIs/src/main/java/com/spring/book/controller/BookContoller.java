package com.spring.book.controller;
import java.util.List;

import java.util.Optional;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.book.entity.Book;
import com.spring.book.service.BookService;

@RestController
public class BookContoller {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book>list =  this.bookService.getAllBook();
		if(list.size()==0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else {
			return ResponseEntity.of(Optional.of(list));
		}
		
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getSingleBOok(@PathVariable("id") int id)
	{
		Book book;
		try {
			book= this.bookService.getBookById(id);
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book)
	{
		Book book1=null;
		try {
			
			book1=this.bookService.createBook(book);
			return ResponseEntity.of(Optional.of(book));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	@DeleteMapping("books/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id)
	{
		try {
			 this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
    @PutMapping("books/{id}")
	public Book update(@RequestBody Book book,@PathVariable("id") int id)
	{
		return this.bookService.updateBook(book,id);
		
	}
	
}
