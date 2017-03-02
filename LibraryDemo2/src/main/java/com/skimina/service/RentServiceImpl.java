package com.skimina.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skimina.dao.BookDao;
import com.skimina.dao.RentDao;
import com.skimina.entity.Book;
import com.skimina.entity.Rent;
import com.skimina.entity.User;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void createRent(User user, Book book) {
        Rent rent = new Rent(user, book);

        rentDao.save(rent);
        book.decrementQuantity();
        bookDao.save(book);
    }
    
    public List<Rent> findByUserOrderByCreatedDateDesc(User user) {
    	return rentDao.findByUserOrderByCreatedDateDesc(user);
    }

	@Override
	public List<Rent> findAll() {
		return rentDao.findAll();
	}
}
