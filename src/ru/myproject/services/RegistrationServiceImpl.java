package ru.myproject.services;

import ru.myproject.dao.UserDAO;
import ru.myproject.dao.UserDAOImpl;

/**
 * Created by taa on 07.11.16.
 */
public class RegistrationServiceImpl implements RegistrationService {

    private UserDAO userDAO =  new UserDAOImpl();

    @Override
    public boolean registrateUser(String username, String password, String email, String phone) {
        return userDAO.registrateUser(username, password, email, phone);


    }
}
