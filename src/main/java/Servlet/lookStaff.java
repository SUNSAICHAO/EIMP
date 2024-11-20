package Servlet;
import Bean.Staff;
import Dao.DaoImpl.StaffDaoImpl;
import Dao.StaffDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class lookStaff extends HttpServlet {
    StaffDao staffDao=new StaffDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        ArrayList<Staff>allStaff;
        try {
            allStaff = staffDao.findAllStaff();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("allStaff", allStaff);
        resp.sendRedirect("lookStaff.jsp");
    }
}
