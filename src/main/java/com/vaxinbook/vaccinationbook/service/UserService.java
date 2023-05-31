package com.vaxinbook.vaccinationbook.service;

import com.vaxinbook.vaccinationbook.dao.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User login(User user);
    User logout();
    List<User> getAllUser();
    User getUserById(Integer id);
}
