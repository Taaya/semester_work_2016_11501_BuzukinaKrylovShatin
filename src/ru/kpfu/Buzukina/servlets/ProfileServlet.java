package ru.kpfu.Buzukina.servlets;

import ru.kpfu.Buzukina.dao.ExamDAO;
import ru.kpfu.Buzukina.dao.UserDAO;
import ru.kpfu.Buzukina.daoImpl.ExamDAOImpl;
import ru.kpfu.Buzukina.daoImpl.UserDAOImpl;
import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Exam;
import ru.kpfu.Buzukina.entities.User;
import ru.kpfu.Buzukina.helpers.TemplateSingleton;
import ru.kpfu.Buzukina.services.ProfileService;
import ru.kpfu.Buzukina.serviceImpl.ProfileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by taa on 12.11.16.
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    private ProfileService profileService = new ProfileServiceImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private ExamDAO examDAO = new ExamDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");


        User user = userDAO.getUser((String) request.getSession().getAttribute("current_user"));

        HashMap<String, Object> root = new HashMap<>();
        List<Course> courses = userDAO.getUsersCourses(user);
        root.put("user", user);
        root.put("courses", courses);
        List<Exam> exams = userDAO.getUsersExams(user);
        root.put("exams", exams);
        TemplateSingleton ts = new TemplateSingleton("profile.ftl");
        ts.render(request,response,root);

    }
}
