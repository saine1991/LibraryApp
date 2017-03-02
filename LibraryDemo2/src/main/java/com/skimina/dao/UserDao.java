package com.skimina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skimina.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);

}




