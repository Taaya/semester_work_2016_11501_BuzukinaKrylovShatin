package ru.kpfu.Buzukina.serviceImpl;

import ru.kpfu.Buzukina.dao.CourseDAO;
import ru.kpfu.Buzukina.daoImpl.CourseDAOImpl;
import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.services.CourseService;

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

    @Override
    public List<Course> getCoursesByLevel(int level) {
        return courseDAO.getCoursesByLevel(level);
    }
}
