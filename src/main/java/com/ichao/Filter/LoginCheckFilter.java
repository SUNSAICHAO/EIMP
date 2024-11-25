package com.ichao.Filter;

import org.apache.commons.lang.StringUtils;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig)  {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = request.getRequestURI();
        if (url.contains("login") || url.contains("register")||url.contains("unLogin")) {
            filterChain.doFilter(request, response);
            return;
        }
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (StringUtils.isBlank(username)) {
            response.sendRedirect("unLogin.jsp");
            return;
        }
        System.out.println("verify success!");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
