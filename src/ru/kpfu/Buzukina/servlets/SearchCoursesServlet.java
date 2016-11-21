package ru.kpfu.Buzukina.servlets;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kpfu.Buzukina.helpers.ConnectionSingleton;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by taa on 18.11.16.
 */
@WebServlet(name = "SearchCoursesServlet")
public class SearchCoursesServlet extends HttpServlet {
    private Connection conn;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String q = request.getParameter("q");

        if (q != null) {
            try {
                conn = ConnectionSingleton.getConnection();
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
                jo.put("result", ja);
                response.setContentType("text/json");
                //response.getWriter().println(names);
                response.getWriter().println(jo.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}
