package ru.kpfu.Buzukina.servlets;

import ru.kpfu.Buzukina.helpers.TemplateSingleton;
import ru.kpfu.Buzukina.serviceImpl.CourseServiceImpl;
import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.services.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

/**
 * Created by taa on 26.10.16.
 */
@WebServlet(name = "CoursesPageServlet")
public class CoursesPageServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    private Connection conn;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String page_str = request.getParameter("page");
        HashMap<String, Object> root = new HashMap<>();
        int page_int = 0;
        page_int = Integer.parseInt(page_str);
        root.put("page", page_int);

        root.put("current_user",request.getSession().getAttribute("current_user"));
        String level = request.getParameter("level_selector");
        List<Course> courses1;
        if(level != null) {
            int level_int = Integer.parseInt(level);
            courses1 = courseService.getCoursesByLevel(level_int);
        } else {
            courses1 =  courseService.getNCourses(6, (page_int - 1) * 6);
        }
        root.put("courses", courses1);
        TemplateSingleton ts = new TemplateSingleton("courses.ftl");
        ts.render(request,response,root);

    }
}
