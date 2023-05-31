package com.vaxinbook.vaccinationbook.dao.entity;

import com.vaxinbook.vaccinationbook.dao.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "USERS")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<SlotBook> slot;
}