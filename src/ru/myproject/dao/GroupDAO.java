package ru.myproject.dao;

import ru.myproject.entities.Course;
import ru.myproject.entities.Group;

import java.util.List;

/**
 * Created by taa on 14.11.16.
 */
public interface GroupDAO {
    List<Group> getAllGroupsFromCourse(Course course);

    String getTeacherName(Group group);

    Group getGroupFromId(int id);

    List<String> getTime(Group group);

    String getFirstClass(Group group);

    int placesLeft(Group group);
}
