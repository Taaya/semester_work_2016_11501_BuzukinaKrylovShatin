package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.daoImpl.UserDAOImpl;
import ru.kpfu.Buzukina.helpers.MD5;
import ru.kpfu.Buzukina.services.LoginService;
import ru.kpfu.Buzukina.dao.UserDAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by taa on 06.11.16.
 */
public class LoginServiceImpl implements LoginService {


    MD5 md5 = new MD5();

    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public boolean checkPassword(String password_from_input, String username) {
        String input_password_hash = md5.getHash(password_from_input);
        String db_password = userDAO.getPassword(username);
        return input_password_hash.equals(db_password);


    }

    @Override
    public void saveCookies(String username, HttpServletResponse response) {
        Cookie username_cookie = new Cookie("username", username);
        int maxAge = 3600;
        username_cookie.setMaxAge(maxAge);
        response.addCookie(username_cookie);

    }


}
