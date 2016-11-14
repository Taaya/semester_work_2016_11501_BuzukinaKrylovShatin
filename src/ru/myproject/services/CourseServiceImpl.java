package ru.myproject.services;

import ru.myproject.dao.CourseDAO;
import ru.myproject.dao.CourseDAOImpl;
import ru.myproject.entities.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taa on 02.11.16.
 */
public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public List<Course> getAllCourses(){

        return courseDAO.getCourses();
    }



    public Course getCourse(long id){
        Course course = courseDAO.getCourse(id);
        return course;

    }

    @Override
    public List<Course> getNCourses(int limit, int offset) {
        return courseDAO.getNCourses(limit, offset);
    }
}
