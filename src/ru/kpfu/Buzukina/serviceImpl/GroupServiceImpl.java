package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.dao.GroupDAO;
import ru.kpfu.Buzukina.daoImpl.GroupDAOImpl;
import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Group;
import ru.kpfu.Buzukina.services.GroupService;

import java.util.List;

/**
 * Created by taa on 14.11.16.
 */
public class GroupServiceImpl implements GroupService {

    private GroupDAO groupDAO = new GroupDAOImpl();



    @Override
    public List<Group> getAllGroupsFromCourse(Course course) {
        return groupDAO.getAllGroupsFromCourse(course);

    }

}
