package ru.myproject.Servlets;

import ru.myproject.entities.Exam;
import ru.myproject.helpers.TemplateSingleton;
import ru.myproject.services.ExamService;
import ru.myproject.services.ExamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by taa on 13.11.16.
 */
@WebServlet(name = "ExamServlet")
public class ExamServlet extends HttpServlet {
    private ExamService examService = new ExamServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id = request.getParameter("id");
        long id_long = Long.parseLong(id);
        Exam exam = examService.getExam(id_long);

        HashMap<String, Object> root = new HashMap<>();

        root.put("exam", exam);
        root.put("current_user",request.getSession().getAttribute("current_user"));
        TemplateSingleton ts = new TemplateSingleton("exam.ftl");
        ts.render(request,response,root);

    }
}
