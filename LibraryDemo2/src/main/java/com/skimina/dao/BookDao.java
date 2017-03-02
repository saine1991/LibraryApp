package com.skimina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skimina.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
}
