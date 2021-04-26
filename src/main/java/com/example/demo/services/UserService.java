package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public ArrayList<User> getUsers(){
    return (ArrayList<User>) userRepository.findAll();
  }

  public User saveUser(User user){
    Optional<User> userOptional =userRepository.findUserByEmail(user.getEmail());
    if(userOptional.isPresent()){
      throw new IllegalStateException("email address has already been taken!");
    }
    return userRepository.save(user);
  }

  public Optional<User> getById(Long id){
    return userRepository.findById(id);
  }

  public ArrayList<User> getByPriority(Integer priority){
    return userRepository.findByPriority(priority);
  }

  public boolean deleteById(Long id){
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      //TODO: handle exception
      return false;
    }
  }
}
