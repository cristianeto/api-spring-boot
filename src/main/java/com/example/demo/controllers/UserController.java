package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping()
  public ArrayList<User> getUsers(){
    return userService.getUsers();
  }

  @PostMapping()
  public User saveUser(@Valid @RequestBody User user){
    return userService.saveUser(user);
  }

  @GetMapping(path = "/{id}")
  public Optional<User> getUserById(@PathVariable("id") Long id){
    return userService.getById(id); 
  }

  @GetMapping("/query")
  public ArrayList<User> getUsersByPriority(@RequestParam("priority") Integer priority) {
     return userService.getByPriority(priority);
  }

  @DeleteMapping(path = "/{id}")
  public String deleteUserById(@PathVariable("id") Long id){
    boolean userDeleted = userService.deleteById(id);
    if(userDeleted) {
      return "User with id: " + id + " was deleted";
    }else{
      return "User with id: " + id +" not was deleted";
    }
  }
  
}
