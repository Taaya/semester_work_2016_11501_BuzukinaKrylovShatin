package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.dao.ClassRequestDAO;
import ru.kpfu.Buzukina.daoImpl.ClassRequestDAOImpl;
import ru.kpfu.Buzukina.entities.ClassRequest;
import ru.kpfu.Buzukina.services.ClassRequestService;

/**
 * Created by taa on 17.11.16.
 */
public class ClassRequestServiceImpl implements ClassRequestService {
    private ClassRequestDAO classRequestDAO = new ClassRequestDAOImpl();

    @Override
    public boolean addClassRequest(ClassRequest classRequest) {
        return  classRequestDAO.insertClassRequest(classRequest);
    }
}
