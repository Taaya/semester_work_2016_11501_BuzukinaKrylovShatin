package ru.myproject.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
            ((HttpServletResponse) resp).sendRedirect("/courses?page=1");

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
