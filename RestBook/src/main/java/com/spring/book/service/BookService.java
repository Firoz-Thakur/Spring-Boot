package com.spring.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.spring.book.entities.Book;


@Component
public class BookService {

	
	private static List<Book> list = new ArrayList();
	
	static {
		
		list.add(new Book(1,"Life streets1","firoz"));
		list.add(new Book(2,"Life streets2","firoz"));
		list.add(new Book(3,"Life streets3","firoz"));
		list.add(new Book(4,"Life streets4","firoz"));
		list.add(new Book(5,"Life streets5","firoz"));
		list.add(new Book(6,"Life streets6","firoz"));
		list.add(new Book(7,"Life streets7","firoz"));
	}
	
	// get all books
	public List<Book> getAllBook()
	{
	    return this.list;
	}
	
	public Book getBookById(int bookId)
	{
		Book book = null;
		try {
		
		book=list.stream().filter(e->e.getId()==bookId).findFirst().get();
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return book;
	
//		for(Book book: list)
//		{
//			if(book.getId()==bookId)
//				return book;
//		}
//		return null;
	}
	
	public Book createBook(Book book)
	{
		this.list.add(book);
		return book;

	}
	public List<Book> deleteBook(int id)
	{
		//Book book = null;
		List<Book> book=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
//		this.list.remove(book);
		return book;		
	}
	public Book updateBook(Book book, int id)
	{
	    Book book1 = list.stream().filter(e->e.getId()==id).findFirst().get();
	    book1.setTitle(book.getTitle());
	    book1.setAuthor(book.getAuthor());
	    return book1;
		
//		list=list.stream().map(e->{
//			if(e.getId()==id)
//			{
//			e.setAuthor(book.getAuthor());
//			e.setTitle(book.getTitle());
//			}
//		return b;
//		}).collectct(Collectors.toList());
	}	
}
