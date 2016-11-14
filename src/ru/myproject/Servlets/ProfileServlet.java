package ru.myproject.Servlets;

import ru.myproject.helpers.TemplateSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by taa on 12.11.16.
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");

        HashMap<String, Object> root = new HashMap<>();
        TemplateSingleton ts = new TemplateSingleton("profile.ftl");
        ts.render(request,response,root);

    }
}
