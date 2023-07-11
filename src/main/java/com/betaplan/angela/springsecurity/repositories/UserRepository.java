package com.betaplan.angela.springsecurity.repositories;

import java.util.List;

import com.betaplan.angela.springsecurity.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findByEmail(String email);

}