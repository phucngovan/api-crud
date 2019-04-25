package com.example.apicrud.Service;

import com.example.apicrud.Model.User;
import com.example.apicrud.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
     UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(long id) {
        User user = findById(id);
        if (user !=null) {
            userRepository.delete(user);
        }
        return user ;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
      return userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
