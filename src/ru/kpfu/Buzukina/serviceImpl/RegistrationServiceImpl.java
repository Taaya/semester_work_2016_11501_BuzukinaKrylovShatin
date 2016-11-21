package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.daoImpl.UserDAOImpl;
import ru.kpfu.Buzukina.dao.UserDAO;
import ru.kpfu.Buzukina.services.RegistrationService;

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
