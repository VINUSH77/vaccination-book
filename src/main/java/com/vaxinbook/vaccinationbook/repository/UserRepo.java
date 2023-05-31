package com.vaxinbook.vaccinationbook.repository;

import com.vaxinbook.vaccinationbook.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCaseAndPhoneEquals(String firstName, String lastName, String phone);
}
