package ru.kpfu.Buzukina.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by taa on 26.10.16.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies){
            if (c.getValue().equals(request.getSession().getAttribute("current_user"))){
                c.setMaxAge(0);
                break;
            }
        }
        session.setAttribute("current_user", null);
        response.sendRedirect("/login");
    }
}
