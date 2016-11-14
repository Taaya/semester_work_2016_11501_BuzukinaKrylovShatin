package ru.myproject.dao;

import ru.myproject.entities.Course;

import java.util.List;

/**
 * Created by taa on 02.11.16.
 */
public interface CourseDAO {
    List<Course> getCourses();

    Course getCourse(long id);


    List<Course> getNCourses(int limit, int offset);
}
