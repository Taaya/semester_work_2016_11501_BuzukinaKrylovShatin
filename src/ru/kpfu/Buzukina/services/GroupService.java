package ru.kpfu.Buzukina.services;

import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Group;

import java.util.List;

/**
 * Created by taa on 14.11.16.
 */
public interface GroupService {

    List<Group> getAllGroupsFromCourse(Course course);
}
