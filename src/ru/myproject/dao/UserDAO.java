package ru.myproject.dao;

import ru.myproject.entities.User;

/**
 * Created by taa on 06.11.16.
 */
public interface UserDAO {

    String getPassword(String username);

    boolean registrateUser(String usename, String password, String email, String phone);

    User getUser(String username);
}
