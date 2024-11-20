package Servlet;

import Bean.Client;
import Dao.DaoImpl.ClientDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class addClient extends HttpServlet {
    ClientDaoImpl clientDao = new ClientDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        System.out.println(req.getParameter("clientName"));
        System.out.println(req.getParameter("clientPhone"));
        String clientName = req.getParameter("clientName");
        String clientPhone = req.getParameter("clientPhone");
        String clientAddress = req.getParameter("clientAddress");
        String clientEmail = req.getParameter("clientEmail");
        System.out.println("test");
        System.out.println("cccccccccccc");
        if (clientName == null||clientName.isEmpty()) {
            resp.sendRedirect("addClient.jsp");
            return;
        }
        Client client = new Client(clientName, clientPhone, clientAddress, clientEmail);
        try {
            boolean flag1 = clientDao.findClientByName(clientName);
            if (flag1) {
                session.setAttribute("addClientMsg", "添加失败,客户已存在");
                resp.sendRedirect("addClient.jsp");
                return;
            }
            clientDao.addClient(client);
            resp.sendRedirect("lookClient");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
