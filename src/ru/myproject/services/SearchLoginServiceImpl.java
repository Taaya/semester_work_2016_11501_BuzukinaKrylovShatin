package ru.myproject.services;

import ru.myproject.dao.UserDAO;
import ru.myproject.dao.UserDAOImpl;

/**
 * Created by taa on 12.11.16.
 */
public class SearchLoginServiceImpl implements SearchLoginService {

    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public boolean LoginEngaged(String username) {

        return userDAO.getUser(username) != null;
    }
}
