package ru.myproject.services;

import ru.myproject.entities.Course;
import ru.myproject.entities.Group;

import java.util.List;

/**
 * Created by taa on 14.11.16.
 */
public interface GroupService {

    List<Group> getAllGroupsFromCourse(Course course);
}
