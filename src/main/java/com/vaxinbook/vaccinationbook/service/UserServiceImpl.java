package com.vaxinbook.vaccinationbook.service;

import com.vaxinbook.vaccinationbook.dao.LoggedUser;
import com.vaxinbook.vaccinationbook.dao.Role;
import com.vaxinbook.vaccinationbook.dao.entity.User;
import com.vaxinbook.vaccinationbook.exception.Duplicate;
import com.vaxinbook.vaccinationbook.exception.InvalidUser;
import com.vaxinbook.vaccinationbook.exception.NotFound;
import com.vaxinbook.vaccinationbook.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        User user1 = userRepo.findByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCaseAndPhoneEquals(
                user.getFirstName(),
                user.getLastName(),
                user.getPhone());
        if(!Objects.isNull(user1))
            throw new Duplicate("User already registered");
        if(Objects.isNull(user.getRole()))
            user.setRole(Role.USER);
        return userRepo.save(user);
    }

    @Override
    public User login(User user) {
        User user1 = userRepo.findByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCaseAndPhoneEquals(
                user.getFirstName(),
                user.getLastName(),
                user.getPhone());
        if(Objects.isNull(user1)){
            throw new InvalidUser("Invalid user data");
        }
        LoggedUser.currentUser = user1;
        return user1;
    }

    @Override
    public User logout() {
        User user = LoggedUser.currentUser;
        if (Objects.isNull(user))
            throw new NotFound("No user logged in");
        LoggedUser.currentUser = null;
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepo.findById(id).orElseThrow(()-> new NotFound("User not found"));
    }
}
