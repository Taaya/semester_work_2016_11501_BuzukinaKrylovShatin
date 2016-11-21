package ru.kpfu.Buzukina.servlets;

import ru.kpfu.Buzukina.helpers.TemplateSingleton;
import ru.kpfu.Buzukina.serviceImpl.RegistrationServiceImpl;
import ru.kpfu.Buzukina.services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

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
            response.sendRedirect("/home");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        TemplateSingleton ts = new TemplateSingleton("registration.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        ts.render(request,response,root);
    }
}
