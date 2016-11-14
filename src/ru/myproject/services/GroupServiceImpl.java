package ru.myproject.services;

import ru.myproject.dao.GroupDAO;
import ru.myproject.dao.GroupDAOImpl;
import ru.myproject.entities.Course;
import ru.myproject.entities.Group;

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
