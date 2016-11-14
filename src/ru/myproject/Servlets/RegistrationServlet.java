package ru.myproject.Servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.myproject.dao.UserDAO;
import ru.myproject.dao.UserDAOImpl;
import ru.myproject.entities.User;
import ru.myproject.helpers.ConfigSingleton;
import ru.myproject.helpers.ConnectionSingleton;
import ru.myproject.helpers.MD5;
import ru.myproject.helpers.TemplateSingleton;
import ru.myproject.services.RegistrationService;
import ru.myproject.services.RegistrationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by taa on 26.10.16.
 */
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private RegistrationService registrationService = new RegistrationServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (registrationService.registrateUser(username, password, email, phone)) {
            response.sendRedirect("/profile");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        TemplateSingleton ts = new TemplateSingleton("registration.ftl");
        HashMap<String, Object> root = new HashMap<>();
        ts.render(request,response,root);
    }
}
