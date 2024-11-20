package Servlet;
import Dao.DaoImpl.ClientDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
public class deleteClient extends HttpServlet {
    ClientDaoImpl clientDao = new ClientDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String clientName=req.getParameter("clientName");
        if (username == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        if (clientName== null|| clientName.isEmpty()) {
            resp.sendRedirect("deleteClient.jsp");
            return;
        }
        boolean flag;
        try {
            flag = clientDao.deleteClientByName(clientName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (flag) {
//            session.setAttribute("deleteClientMsg", "客户信息删除成功");
            resp.sendRedirect("lookClient");
        } else {
            session.setAttribute("deleteClientMsg", "删除失败，客户不存在");
            resp.sendRedirect("deleteClient.jsp");
        }

    }
}
