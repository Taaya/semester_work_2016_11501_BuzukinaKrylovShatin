package ru.kpfu.Buzukina.servlets;

import org.json.JSONObject;
import ru.kpfu.Buzukina.services.SearchLoginService;
import ru.kpfu.Buzukina.serviceImpl.SearchLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by taa on 12.11.16.
 */
@WebServlet(name = "CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {

    private SearchLoginService searchLoginService = new SearchLoginServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsonObject = new JSONObject();
        String message = "";
        if (searchLoginService.LoginEngaged(request.getParameter("username"))){
            message = "Данное имя пользователя занято";

        }
        jsonObject.put("result", message);
        response.setContentType("text/json");
        response.getWriter().print(jsonObject.toString());


    }
}
