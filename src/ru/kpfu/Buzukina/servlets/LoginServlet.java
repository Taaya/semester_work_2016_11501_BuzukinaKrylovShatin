package ru.kpfu.Buzukina.servlets;

import ru.kpfu.Buzukina.helpers.ConnectionSingleton;
import ru.kpfu.Buzukina.helpers.TemplateSingleton;
import ru.kpfu.Buzukina.services.LoginService;
import ru.kpfu.Buzukina.serviceImpl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by taa on 22.10.16.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select password from users where username='" + username + "'");



            if (rs.next()) {
                if(loginService.checkPassword(password, username)) {
                    request.getSession().setAttribute("current_user", username);
                    if(rememberMe != null) {
                        loginService.saveCookies(username, response);
                    }
                    response.sendRedirect("/profile");
                } else {
                    response.sendRedirect("/login?err=Wrong Password&username=" + username);
                }
            } else {
                response.sendRedirect("/login?err=Wrong Username");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        HashMap<String, Object> root = new HashMap<>();
        root.put("username", username);
        root.put("current_user", request.getSession().getAttribute("current_user"));
        TemplateSingleton ts = new TemplateSingleton("login.ftl");
        ts.render(request,response,root);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> root = new HashMap<>();
        String err = request.getParameter("err");
        String username = request.getParameter("username");


        root.put("err", err);
        root.put("username", username);
        TemplateSingleton ts = new TemplateSingleton("login.ftl");
        ts.render(request,response,root);


    }


}

