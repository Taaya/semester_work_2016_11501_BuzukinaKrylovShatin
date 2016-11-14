package ru.myproject.dao;

import ru.myproject.entities.MyCookie;
import ru.myproject.entities.User;

import javax.servlet.http.Cookie;

/**
 * Created by taa on 13.11.16.
 */
public interface CookieDAO {

    MyCookie getCookie(User user);

    boolean insertCookie(MyCookie cookie);

    String getPassword (String password_token);
}
