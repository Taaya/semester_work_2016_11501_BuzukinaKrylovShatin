package ru.kpfu.Buzukina.dao;

import ru.kpfu.Buzukina.entities.Course;

import java.util.List;

/**
 * Created by taa on 02.11.16.
 */
public interface CourseDAO {
    List<Course> getCourses();

    Course getCourse(long id);


    List<Course> getNCourses(int limit, int offset);

    String getNextClass(Course course);

    List<Course> getCoursesByLevel(int level);
}
