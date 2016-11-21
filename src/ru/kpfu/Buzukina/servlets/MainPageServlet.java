package ru.kpfu.Buzukina.servlets;

import ru.kpfu.Buzukina.helpers.TemplateSingleton;
import ru.kpfu.Buzukina.serviceImpl.ClassRequestServiceImpl;
import ru.kpfu.Buzukina.entities.ClassRequest;
import ru.kpfu.Buzukina.services.ClassRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by taa on 17.11.16.
 */
@WebServlet(name = "MainPageServlet")
public class MainPageServlet extends HttpServlet {
   private ClassRequestService classRequestService = new ClassRequestServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        ClassRequest classRequest = new ClassRequest(name, email, phone);
        classRequestService.addClassRequest(classRequest);
        String success = "Спасибо за заявку! Наш оператор свяжется с Вами в течение дня.";
        HashMap<String, Object> root = new HashMap<>();
        root.put("message", success);
        TemplateSingleton ts = new TemplateSingleton("main.ftl");
        ts.render(request,response,root);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        HashMap<String, Object> root = new HashMap<>();
        TemplateSingleton ts = new TemplateSingleton("main.ftl");
        root.put("current_user", request.getSession().getAttribute("current_user"));
        ts.render(request,response,root);
    }
}
