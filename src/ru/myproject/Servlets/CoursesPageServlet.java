package ru.myproject.Servlets;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.myproject.entities.Course;
import ru.myproject.helpers.TemplateSingleton;
import ru.myproject.services.CourseService;
import ru.myproject.services.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        int page_int = Integer.parseInt(page_str);
        HashMap<String, Object> root = new HashMap<>();
        List<Course> courses = courseService.getNCourses(6, (page_int - 1) * 6);
        root.put("current_user",request.getSession().getAttribute("current_user"));
        root.put("courses", courses);
        root.put("page", page_int);

//        RequestDispatcher rd = request.getRequestDispatcher("/courses.jsp");
//        rd.forward(request, response);

        String q = request.getParameter("q");

        if (q != null) {
            try {
                PreparedStatement st = conn.prepareStatement("select name from courses where name like ?");
                st.setString(1, "%" + q + "%");
                ResultSet rs = st.executeQuery();
                rs = st.executeQuery();
                List<String> names = new ArrayList<String>();
                JSONArray ja = new JSONArray();
                while (rs.next()) {
                    ja.put(rs.getString("name"));
                }
                JSONObject jo = new JSONObject();
                jo.put("names", ja);
                response.setContentType("text/json");
                //response.getWriter().println(names);
                response.getWriter().println(jo.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }



        TemplateSingleton ts = new TemplateSingleton("courses.ftl");
        ts.render(request,response,root);

    }
}
