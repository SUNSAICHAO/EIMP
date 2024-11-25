package com.ichao.servlet;

import com.ichao.dao.ClientServiceDao;
import com.ichao.dao.daoImpl.ClientServiceDaoImpl;
import com.ichao.entity.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/clientService")
public class ClientServiceServlet extends HttpServlet {
    private ClientServiceDao clientServiceDao;

    @Override
    public void init() throws ServletException {
        super.init();
        clientServiceDao = new ClientServiceDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ArrayList<ClientService> list = clientServiceDao.list();
            req.setAttribute("clientServiceList", list);
            req.getRequestDispatcher("/lookClientService.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ClientService clientService = getCSByRequest(req);
            clientServiceDao.insert(clientService);
            resp.sendRedirect("clientService");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ClientService getCSByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String clientName=request.getParameter("clientName");
        String clientOpinion=request.getParameter("clientOpinion");
        String employeeName=request.getParameter("employeeName");
        return new ClientService(clientName,clientOpinion,employeeName);
    }
}


