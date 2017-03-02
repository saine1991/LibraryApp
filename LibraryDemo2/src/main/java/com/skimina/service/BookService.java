package com.skimina.service;

import java.util.List;

import com.skimina.entity.Book;


public interface BookService {
	List<Book> findAll();
	Book findOne(Long id);
	void save(Book book);
	void delete(Long id);
	
}
