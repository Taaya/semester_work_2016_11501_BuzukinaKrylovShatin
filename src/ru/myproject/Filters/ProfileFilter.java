package ru.myproject.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by taa on 23.10.16.
 */
@WebFilter(filterName = "ProfileFilter")
public class ProfileFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(((HttpServletRequest) req).getSession().getAttribute("current_user") != null){
            chain.doFilter(req, resp);
        } else {
            Cookie[] cookies = ((HttpServletRequest) req).getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")){
                        HttpSession session = ((HttpServletRequest) req).getSession();
                        session.setAttribute("current_user", c.getValue());
                        chain.doFilter(req, resp);
                        break;
                    }
                }
                ((HttpServletResponse) resp).sendRedirect("/login");
            } else {

                ((HttpServletResponse) resp).sendRedirect("/login");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
