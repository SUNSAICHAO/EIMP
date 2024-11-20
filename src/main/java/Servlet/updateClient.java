package Servlet;
import Bean.Client;
import Dao.ClientDao;
import Dao.DaoImpl.ClientDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class updateClient extends HttpServlet {
    ClientDao clientDao=new ClientDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String name=req.getParameter("clientName");
        String phone=req.getParameter("clientPhone");
        String address=req.getParameter("clientAddress");
        String email=req.getParameter("clientEmail");
        if (username==null){
            resp.sendRedirect("login.jsp");
            return;
        }
        if (name==null){
            resp.sendRedirect("updateClient.jsp");
            return;
        }
        Client client =new Client(name,phone,address,email);
        boolean flag;
        try {
            flag = clientDao.updateClient(client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (flag){
//            session.setAttribute("updateClientMsg", "客户信息修改成功");
            resp.sendRedirect("lookClient");
        }
        else {
            session.setAttribute("updateClientMsg", "修改失败，不存在此客户");
            resp.sendRedirect("updateClient.jsp");
        }
    }
}
