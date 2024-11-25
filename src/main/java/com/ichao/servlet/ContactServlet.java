package com.ichao.servlet;

import com.ichao.dao.ContactDao;
import com.ichao.dao.daoImpl.ContactDaoImpl;
import com.ichao.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private ContactDao contactDao;
    @Override
    public void init() throws ServletException {
        super.init();
        contactDao=new ContactDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Contact> list = contactDao.list();
            req.setAttribute("contactList", list);
            req.getRequestDispatcher("/lookContact.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contact contact = getContactByRequest(req);
        try {
            Contact contactDB = contactDao.getByName(contact.getName());
            if (contactDB!=null){
                req.setAttribute("msg", "添加失败，合同名已存在");
                req.getRequestDispatcher("/addContact.jsp").forward(req, resp);
            }
            contactDao.insert(contact);
            resp.sendRedirect("contact");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Contact getContactByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String clientName = request.getParameter("clientName");
        String name = request.getParameter("name");
        String contents = request.getParameter("contents");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String staffName = request.getParameter("staffName");
        return new Contact(clientName,name,contents,start,end,staffName);
    }
}
