package ru.kpfu.Buzukina.services;

import ru.kpfu.Buzukina.entities.Course;

import java.util.List;

/**
 * Created by taa on 02.11.16.
 */
public interface CourseService {
    public List<Course> getAllCourses();

    public Course getCourse(long id);

    public List<Course> getNCourses(int limit, int offset);

    public List<Course> getCoursesByLevel(int level);
}
