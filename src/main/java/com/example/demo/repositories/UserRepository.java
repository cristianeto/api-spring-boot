package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
 
  public abstract ArrayList<User> findByPriority(Integer priority);

  public abstract Optional<User> findUserByEmail(String email);
}
