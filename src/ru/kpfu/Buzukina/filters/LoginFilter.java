package ru.kpfu.Buzukina.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by taa on 22.10.16.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest) req).getSession().getAttribute("current_user") == null) {
            chain.doFilter(req, resp);
        } else {
            Cookie[] cookies = ((HttpServletRequest) req).getCookies();
            if (cookies != null) {
                for (Cookie c : cookies){
                    if (c.getName().equals(((HttpServletRequest) req).getSession().getAttribute("username"))){
                        ((HttpServletResponse) resp).sendRedirect("/profile");
                        break;
                    }
                }

            } else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
