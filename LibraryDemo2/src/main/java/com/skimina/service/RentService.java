package com.skimina.service;


import java.util.List;

import com.skimina.entity.Book;
import com.skimina.entity.Rent;
import com.skimina.entity.User;

public interface RentService {

    void createRent(User user, Book book);
    List<Rent> findByUserOrderByCreatedDateDesc(User user);
    List<Rent> findAll();
}
