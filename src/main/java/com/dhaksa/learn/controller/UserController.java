package com.dhaksa.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhaksa.learn.model.User;
import com.dhaksa.learn.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService  userService;

    @PostMapping("/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return ResponseEntity.status(201).body(newUser);

    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User>users=userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User>updateUser(@PathVariable Long id,@RequestBody User user){
        User updatedUser = userService.updateUsersById(id, user);
        return ResponseEntity.status(200).body(updatedUser);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable Long id){
        userService.deleteUsersById(id);
        return ResponseEntity.status(200).body("User record deleted successfully");
    }
 
}
