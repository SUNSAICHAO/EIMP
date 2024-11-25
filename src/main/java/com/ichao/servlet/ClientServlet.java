package com.ichao.servlet;

import com.ichao.dao.ClientDao;
import com.ichao.dao.daoImpl.ClientDaoImpl;
import com.ichao.entity.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    ClientDao clientDao;

    @Override
    public void init() throws ServletException {
        super.init();
        clientDao = new ClientDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Client> list = clientDao.list();
            request.setAttribute("clientList", list);            request.getRequestDispatcher("/lookClient.jsp").forward(request, response);
            System.out.println("clientInfo has been loaded...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException{
        try {
            Client client = getClientByRequest(request);
            Client clientDB = clientDao.getByName(client.getName());
            if (clientDB != null) {
                request.setAttribute("msg", "添加失败,客户已存在");
                request.getRequestDispatcher("/addClient.jsp").forward(request, response);
                return;
            }
            clientDao.insert(client);
            response.sendRedirect("client");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        try {
            Client clientDB = clientDao.getByName(name);
            if (clientDB == null) {
                request.setAttribute("msg", "删除失败，不存在此客户");
                request.getRequestDispatcher("/deleteClient.jsp").forward(request, response);
                return;
            }
            clientDao.deleteByName(name);
            response.sendRedirect("client");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Client client = getClientByRequest(request);
        Client clientDB = null;
        try {
            clientDB = clientDao.getByName(client.getName());
            if (clientDB == null) {
                request.setAttribute("msg", "修改失败，不存在此客户");
                request.getRequestDispatcher("/updateClient.jsp").forward(request, response);
                return;
            }
            clientDao.update(client);
            response.sendRedirect("client");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Client getClientByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        return new Client(name, phone, address, email);
    }
}

