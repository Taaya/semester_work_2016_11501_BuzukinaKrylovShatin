package ru.kpfu.Buzukina.dao;

import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Group;

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
