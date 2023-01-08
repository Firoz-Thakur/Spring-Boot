package com.spring.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.book.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	
	
}
