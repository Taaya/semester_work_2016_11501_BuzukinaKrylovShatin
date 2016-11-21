package ru.kpfu.Buzukina.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by taa on 06.11.16.
 */
public interface LoginService {
    boolean checkPassword(String password_from_input, String username);

    void saveCookies(String username, HttpServletResponse response);
}
