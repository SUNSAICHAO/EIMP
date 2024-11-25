package com.ichao.servlet;

import com.ichao.dao.EmployeeDao;
import com.ichao.dao.daoImpl.EmployeeDaoImpl;
import com.ichao.entity.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDao employeeDao;

    @Override
    public void init() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Employee> list = employeeDao.list();
            req.setAttribute("employeeList", list);
            req.getRequestDispatcher("/lookEmployee.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = getEmployeeByRequest(req);
        try {
            employeeDao.insert(employee);
            resp.sendRedirect("employee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Employee getEmployeeByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String education = request.getParameter("education");
        String department = request.getParameter("department");
        String date = request.getParameter("date");
        String duty = request.getParameter("duty");
        String wage = request.getParameter("wage");
        return new Employee(name,sex,age,education,department,date,duty,wage);
    }


}
