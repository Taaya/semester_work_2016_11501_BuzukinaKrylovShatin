package ru.kpfu.Buzukina.dao;

import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Exam;
import ru.kpfu.Buzukina.entities.User;

import java.util.List;

/**
 * Created by taa on 06.11.16.
 */
public interface UserDAO {

    String getPassword(String username);

    boolean registrateUser(String usename, String password, String email, String phone);

    User getUser(String username);

    List<Course> getUsersCourses(User user);

    List<Exam> getUsersExams(User user);

    boolean editUserInfo(String oldLogin, String newLogin, String newEmail);
}
