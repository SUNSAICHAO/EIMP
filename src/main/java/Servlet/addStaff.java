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

public class addStaff extends HttpServlet {
    StaffDao staffDao = new StaffDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username =(String) session.getAttribute("username");
        String staffName = req.getParameter("staffName");
        String staffSex = req.getParameter("staffSex");
        String staffAge = req.getParameter("staffAge");
        String staffEducation = req.getParameter("staffEducation");
        String staffDepartment = req.getParameter("staffDepartment");
        String staffDate = req.getParameter("staffDate");
        String staffDuty = req.getParameter("staffDuty");
        String staffWage = req.getParameter("staffWage");
        if (username == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        if (staffName == null || staffName.isEmpty()) {
            resp.sendRedirect("addStaff.jsp");
            return;
        }
        Staff staff = new Staff(staffName, staffSex, staffAge, staffEducation, staffDepartment, staffDate, staffDuty, staffWage);
        try {
            staffDao.addStaff(staff);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        session.setAttribute("addStaffMsg", "添加成功");
        resp.sendRedirect("lookStaff");
    }
}
