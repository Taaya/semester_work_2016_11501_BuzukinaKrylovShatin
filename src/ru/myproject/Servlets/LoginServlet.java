package ru.myproject.Servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.myproject.dao.CookieDAO;
import ru.myproject.dao.CookieDAOImpl;
import ru.myproject.dao.UserDAO;
import ru.myproject.dao.UserDAOImpl;
import ru.myproject.entities.MyCookie;
import ru.myproject.entities.User;
import ru.myproject.helpers.*;
import ru.myproject.services.LoginService;
import ru.myproject.services.LoginServiceImpl;

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
                if(rs.getString("password").equals(password)) {
                    request.getSession().setAttribute("current_user", username);
                    if(rememberMe != null) {
                        Cookie username_cookie = new Cookie("username", username);
                        CookieTokenizer ct = new CookieTokenizer();
                        String password_token = ct.getCookieHash(password);
                        Cookie password_cookie = new Cookie("password", password_token);
                        int maxAge = 3600;
                        username_cookie.setMaxAge(maxAge);
                        password_cookie.setMaxAge(maxAge);
                        response.addCookie(username_cookie);
                        response.addCookie(password_cookie);
                        UserDAO userDAO = new UserDAOImpl();
                        User user = userDAO.getUser(username);
                        MyCookie myCookie = new MyCookie("password", password_token, user.getId());
                        CookieDAO cookieDAO = new CookieDAOImpl();
                        cookieDAO.insertCookie(myCookie);
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
        root.put("password", password);
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

        String password = "";
        String password_token_browser = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cu : cookies){
                if (cu.getName().equals("username")){
                    username = cu.getValue();
                    for (Cookie cp : cookies){
                        if (cp.getName().equals("password")){
                            password_token_browser = cp.getValue();
                            CookieDAO cookieDAO = new CookieDAOImpl();
                            password = cookieDAO.getPassword(password_token_browser);
                            break;
                        }
                    }
                    break;
                }
            }
        }

        root.put("err", err);
        root.put("username", username);
        root.put("password", password);
        TemplateSingleton ts = new TemplateSingleton("login.ftl");
        ts.render(request,response,root);


    }


}

