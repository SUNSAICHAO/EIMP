package Servlet;

import Bean.Contact;
import Dao.ContactDao;
import Dao.DaoImpl.ContactDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class lookContact extends HttpServlet {
    ContactDao contactDao = new ContactDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
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
        ArrayList<Contact> allContact;
        try {
            allContact = contactDao.findAllContact();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("allContact", allContact);
        resp.sendRedirect("lookContact.jsp");

    }
}
