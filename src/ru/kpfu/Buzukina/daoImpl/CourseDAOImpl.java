package ru.kpfu.Buzukina.daoImpl;

import ru.kpfu.Buzukina.dao.ClassesDAO;
import ru.kpfu.Buzukina.dao.CourseDAO;
import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.helpers.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by taa on 02.11.16.
 */
public class CourseDAOImpl implements CourseDAO {

    private Connection conn;
    private ClassesDAO classesDAO = new ClassesDAOImp();
    @Override
    public List<Course> getCourses() {

        try {
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from courses");
            List<Course> courses = new ArrayList<>();
            while (rs.next()){
                Course course =
                        new Course(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getString("language_code"),
                                rs.getInt("level")
                        );
                courses.add(course);
            }
            return courses;

        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public Course getCourse(long id) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from courses where id='" + id + "'");
            rs.next();

            Course course = new Course(
                    (long)rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("language_code"),
                    rs.getInt("level")
            );

            return course;


        } catch (SQLException e) {
            return  null;
        }

    }

    @Override
    public List<Course> getNCourses(int limit, int offset) {
        try {
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from courses limit " + limit + "offset " + offset);
            List<Course> courses = new ArrayList<>();
            while (rs.next()){
                Course course =
                        new Course(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getString("language_code"),
                                rs.getInt("level")
                        );
                courses.add(course);
            }
            return courses;

        }catch (SQLException e){
            return null;
        }


    }

    @Override
    public String getNextClass(Course course) {
        return classesDAO.getNextClass(course);
    }

    @Override
    public List<Course> getCoursesByLevel(int level) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from courses where level=" + level);
            List<Course> courses = new ArrayList<>();
            while (rs.next()){

                Course course = new Course(
                        (long)rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("language_code"),
                        rs.getInt("level")
                );
                courses.add(course);
            }
            return courses;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
