package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.dao.UserDAO;
import ru.kpfu.Buzukina.daoImpl.UserDAOImpl;
import ru.kpfu.Buzukina.services.SearchLoginService;

/**
 * Created by taa on 12.11.16.
 */
public class SearchLoginServiceImpl implements SearchLoginService {

    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public boolean LoginEngaged(String username) {
        System.out.println(userDAO.getUser(username));
        return userDAO.getUser(username) != null;
    }
}
