package ru.myproject.services;

import ru.myproject.dao.UserDAO;
import ru.myproject.dao.UserDAOImpl;
import ru.myproject.helpers.MD5;

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
        String db_password_hash = md5.getHash(userDAO.getPassword(username));
        return input_password_hash.equals(db_password_hash);


    }
    public String[] familiarUser(HttpServletResponse response, HttpServletRequest request, Cookie[] cookies, String username, String password){
        String[] data = {"", ""};
        if (request.getSession().getAttribute("current_user") == null){
            if (cookies != null){
                for (Cookie c : cookies){
                    if (c.getName().equals("username")){
                        UserDAO userDAO = new UserDAOImpl();
                        password = userDAO.getPassword(username);
                        data[0] = username;
                        data[1] = password;
                        break;
                    }
                }
            }
        }

        return new String[0];
    }

}
