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

public class addContact extends HttpServlet {
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
        String clientName = req.getParameter("clientName");
        String contactName = req.getParameter("contactName");
        String contactContents = req.getParameter("contactContents");
        String contactStart = req.getParameter("contactStart");
        String contactEnd = req.getParameter("contactEnd");
        String StaffName = req.getParameter("StaffName");

        if (username == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        if (contactName == null || contactName.isEmpty()) {
            resp.sendRedirect("addContact.jsp");
            return;
        }
        Contact contact = new Contact(clientName, contactName, contactContents, contactStart, contactEnd, StaffName);

        try {
            boolean flag1 = contactDao.findContactByName(contactName);
            if (flag1) {
                session.setAttribute("addContactMsg", "添加失败,合同名重复");
                resp.sendRedirect("addContact.jsp");
                return;
            }
            contactDao.addContact(contact);
//            session.setAttribute("addContactMsg", "添加成功");
            resp.sendRedirect("lookContact");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
