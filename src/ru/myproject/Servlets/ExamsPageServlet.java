package ru.myproject.Servlets;

import ru.myproject.entities.Exam;
import ru.myproject.helpers.TemplateSingleton;
import ru.myproject.services.ExamService;
import ru.myproject.services.ExamServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by taa on 05.11.16.
 */
@WebServlet(name = "ExamsPageServlet")
public class ExamsPageServlet extends HttpServlet {

    private ExamService examService = new ExamServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String page_str = request.getParameter("page");
        int page_int = Integer.parseInt(page_str);
        HashMap<String, Object> root = new HashMap<>();
        List<Exam> exams = examService.getNExams(6, (page_int - 1) * 6);
        root.put("exams", exams);
        root.put("current_user",request.getSession().getAttribute("current_user"));
        root.put("page", page_int);

//        RequestDispatcher rd = request.getRequestDispatcher("/courses.jsp");
//        rd.forward(request, response);

        TemplateSingleton ts = new TemplateSingleton("exams.ftl");
        ts.render(request,response,root);

    }
}
