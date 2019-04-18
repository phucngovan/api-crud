package com.example.apicrud.Service;

import com.example.apicrud.Model.User;

import java.util.List;

public interface UserService {
//    User findById(Long id);
//
//    User findByName(String name);
//
//    void saveUser(User user);
//
//    void updateUser(User user);
//
//    void deleteUserById(Long id);
//
//    void deleteAllUsers();
//
//    List<User> findAllUsers();
    User create(User user);

    User delete(long id);

    List<User> findAll();

    User findById(long id);

    User update(User user);
    User findByName(String name);
}
