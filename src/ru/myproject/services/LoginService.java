package ru.myproject.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by taa on 06.11.16.
 */
public interface LoginService {
    boolean checkPassword(String password_from_input, String username);


    String[] familiarUser(HttpServletResponse response, HttpServletRequest request, Cookie[] cookies, String username, String password);
}
