package ru.kpfu.Buzukina.servlets;

import ru.kpfu.Buzukina.entities.Feedback;
import ru.kpfu.Buzukina.helpers.TemplateSingleton;
import ru.kpfu.Buzukina.serviceImpl.FeedbackServiceImpl;
import ru.kpfu.Buzukina.services.FeedbackService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by taa on 16.11.16.
 */
@WebServlet(name = "FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
    private FeedbackService feedbackService = new FeedbackServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String feedback_text = request.getParameter("feedback_text");
        Feedback feedback = new Feedback(name, phone, email, feedback_text);
        feedbackService.sendFeedback(feedback);
        String success = "Ваш вопрос отправлен и будет рассмотрен.";
        HashMap<String, Object> root = new HashMap<>();
        root.put("message", success);
        TemplateSingleton ts = new TemplateSingleton("feedback.ftl");
        ts.render(request,response,root);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        TemplateSingleton ts = new TemplateSingleton("feedback.ftl");
        ts.render(request,response,root);
    }
}
