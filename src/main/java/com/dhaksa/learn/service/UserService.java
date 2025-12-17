package com.dhaksa.learn.service;
import java.util.List;


import com.dhaksa.learn.model.User;


public interface UserService {
    // CRUD
    User createUser(User user);
    List<User>getAllUsers();
    User updateUsersById(Long id,User user);
    void deleteUsersById(Long id);
}
