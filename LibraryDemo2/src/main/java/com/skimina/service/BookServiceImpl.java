package com.skimina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skimina.dao.BookDao;
import com.skimina.entity.Book;

@Service
public class BookServiceImpl implements BookService{
	 @Autowired
	 private BookDao bookDao;

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findOne(Long id) {
		return bookDao.findOne(id);
	}

	@Override
	public void save(Book book) {
		bookDao.save(book);
		
	}

	@Override
	public void delete(Long id) {
		bookDao.delete(id);
		
	}
	 
	 
}
