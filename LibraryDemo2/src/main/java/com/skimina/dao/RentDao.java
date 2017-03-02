package com.skimina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skimina.entity.Rent;
import com.skimina.entity.User;

import java.util.List;

@Repository
public interface RentDao extends JpaRepository<Rent, Long> {

    List<Rent> findByUserOrderByCreatedDateDesc(User user);

}
