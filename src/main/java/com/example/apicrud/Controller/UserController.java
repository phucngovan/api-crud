package com.example.apicrud.Controller;

import com.example.apicrud.Model.User;
import com.example.apicrud.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api")
public class UserController { public static Logger logger =LoggerFactory.getLogger(UserController.class);
   @Autowired
    UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUser(){
        List<User> listUser= userService.findAll();
        if(listUser.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUser(@PathVariable("id") long id) {
        User user= userService.findById(id);
        if(user == null) {
            ResponseEntity.notFound().build();
        }
        return user;
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public User saveUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                                         @Valid @RequestBody User userForm) {
        User user = userService.findById(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setId(userForm.getId());
        user.setName(userForm.getName());
        user.setAge(userForm.getAge());
        user.setSalary(userForm.getSalary());

        User updatedUser = userService.create(user);
        return ResponseEntity.ok(updatedUser);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {
        User user = userService.findById(id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
