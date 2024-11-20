package Servlet;
import Bean.User;
import Dao.DaoImpl.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class login extends HttpServlet {
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        boolean flag;
        try {
            flag = userDao.findUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (flag) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user.getUsername());
            resp.sendRedirect("main.jsp");
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}


