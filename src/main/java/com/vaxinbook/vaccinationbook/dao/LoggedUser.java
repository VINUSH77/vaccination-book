package com.vaxinbook.vaccinationbook.dao;

import com.vaxinbook.vaccinationbook.dao.entity.User;
import lombok.Data;

@Data
public abstract class LoggedUser {
    public static User currentUser = null;
}
