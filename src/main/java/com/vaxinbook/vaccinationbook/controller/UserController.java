package com.vaxinbook.vaccinationbook.controller;

import com.vaxinbook.vaccinationbook.dao.entity.User;
import com.vaxinbook.vaccinationbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<User> login(@RequestBody User user){
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/logout")
    ResponseEntity<User> logout(){
        return new ResponseEntity<>(userService.logout(), HttpStatus.OK);
    }

}
