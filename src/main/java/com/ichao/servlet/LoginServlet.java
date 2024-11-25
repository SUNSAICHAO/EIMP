package com.ichao.servlet;

import com.ichao.dao.AdminDao;
import com.ichao.dao.daoImpl.AdminDaoImpl;
import com.ichao.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private AdminDao adminDao;

    @Override
    public void init() throws ServletException {
        super.init();
        adminDao = new AdminDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Admin admin = adminDao.getByName(username);
            if (admin==null){
                req.setAttribute("msg", "登录失败，账号不存在");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                return;
            }
            if (!password.equals(admin.getPassword())){
                req.setAttribute("msg", "登录失败，密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                return;
            }
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("main.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



