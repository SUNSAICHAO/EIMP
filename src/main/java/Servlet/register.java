package Servlet;
import Bean.Result;
import Bean.User;
import Dao.DaoImpl.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        UserDaoImpl userDao = new UserDaoImpl();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if (username==null){
            resp.sendRedirect("UnLogin.jsp");
            return;
        }
        User user = new User(username,password);
        try {
            boolean flag1 = userDao.findUserbyName(req.getParameter("username"));
            if (flag1) {
                req.setAttribute("err_msg", "error");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }
            userDao.insertUser(user);
            session.setAttribute("newUser", user);
            session.setAttribute("success_msg","OK" );
            resp.sendRedirect("register.jsp");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
