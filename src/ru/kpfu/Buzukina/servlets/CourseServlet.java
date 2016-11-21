package ru.kpfu.Buzukina.servlets;

import ru.kpfu.Buzukina.entities.Course;
import ru.kpfu.Buzukina.entities.Group;
import ru.kpfu.Buzukina.helpers.TemplateSingleton;
import ru.kpfu.Buzukina.services.CourseService;
import ru.kpfu.Buzukina.serviceImpl.CourseServiceImpl;
import ru.kpfu.Buzukina.services.GroupService;
import ru.kpfu.Buzukina.serviceImpl.GroupServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by taa on 11.11.16.
 */
@WebServlet(name = "CourseServlet")
public class CourseServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    private GroupService groupService = new GroupServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id = request.getParameter("id");
        long id_long = Long.parseLong(id);
        Course course = courseService.getCourse(id_long);


        List<Group> groups = groupService.getAllGroupsFromCourse(course);
        List<List<String>> times = new ArrayList<>();
        for (Group g : groups) {
            times.add(g.getTime());
        }
        HashMap<String, Object> root = new HashMap<>();
        root.put("groups", groups);
        root.put("times", times);
        root.put("current_user",request.getSession().getAttribute("current_user"));
        root.put("course", course);
        TemplateSingleton ts = new TemplateSingleton("course.ftl");
        ts.render(request,response,root);



    }
}
