package ru.kpfu.Buzukina.daoImpl;

import ru.kpfu.Buzukina.dao.CourseDAO;
import ru.kpfu.Buzukina.dao.ExamDAO;
import ru.kpfu.Buzukina.dao.UserDAO;
import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Exam;
import ru.kpfu.Buzukina.entities.User;
import ru.kpfu.Buzukina.helpers.ConnectionSingleton;
import ru.kpfu.Buzukina.helpers.MD5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by taa on 06.11.16.
 */
public class UserDAOImpl implements UserDAO {

    private Connection conn;

    @Override
    public String getPassword(String username) {

        try {
            conn = ConnectionSingleton.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select password from users where username='" + username + "'");
            rs.next();
            return rs.getString("password");

        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public boolean registrateUser(String username, String password, String email, String phone) {
        try {
            MD5 md5 = new MD5();
            String hashed_password = md5.getHash(password);
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("insert into users(\"username\",\"password\", \"email\",\"phone\", \"user_role\") values('" +
                    username + "', '" + hashed_password + "', '" + email + "', '" + phone + "', 'student');");
            return rs == 1;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public User getUser(String username) {
        try{
            Connection connection = ConnectionSingleton.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where username='" + username + "'");
            if (rs.next()){
                User user = new User(
                        (long)rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        "student",
                        rs.getString("phone")
                );
                return user;
            } else
                return null;

        } catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Course> getUsersCourses(User user) {
        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select course_id from group_enrollments join groups on groups.id = group_enrollments.group_id" +
                    " where group_enrollments.user_id=" + (int)user.getId());
            List<Course> courses = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            while (rs.next()) {
                ids.add(rs.getInt("course_id"));
            }
            CourseDAO courseDAO = new CourseDAOImpl();
            for (Integer id : ids) {
                Course course = courseDAO.getCourse(id);
                courses.add(course);
            }
            return courses;

        } catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<Exam> getUsersExams(User user) {
        try{
            conn = ConnectionSingleton.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select exam_id from exam_enrollments where user_id=" + user.getId());
            List<Exam> exams = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            while (rs.next()){
                ids.add(rs.getInt("exam_id"));
                System.out.println(rs.getInt("exam_id"));
            }


            ExamDAO examDAO = new ExamDAOImpl();
            for (Integer id : ids){
                Exam exam = examDAO.getExam(id);
                exams.add(exam);
            }
            for (Exam e : exams){
                System.out.println(e.getName());
            }
            return exams;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


}
