package com.betaplan.angela.springsecurity.repositories;

import java.util.List;

import com.betaplan.angela.springsecurity.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();
    List<Role> findByName(String name);
}
