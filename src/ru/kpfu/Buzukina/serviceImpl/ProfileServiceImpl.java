package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.daoImpl.UserDAOImpl;
import ru.kpfu.Buzukina.services.ProfileService;
import ru.kpfu.Buzukina.dao.UserDAO;

/**
 * Created by taa on 15.11.16.
 */
public class ProfileServiceImpl implements ProfileService {
    private UserDAO userDAO = new UserDAOImpl();

}
