package Servlet;

import Bean.Cs;
import Dao.CsDao;
import Dao.DaoImpl.CsDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class addCs extends HttpServlet {
    CsDao csDao=new CsDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String clientName=req.getParameter("clientName");
        String clientOpinion=req.getParameter("clientOpinion");
        String StaffName=req.getParameter("StaffName");
        if (username == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        if (clientName==null||clientName.isEmpty()){
            resp.sendRedirect("addCs.jsp");
            return;
        }
        Cs cs=new Cs(clientName,clientOpinion,StaffName);
        try {
            csDao.addCs(cs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        session.setAttribute("addCsMsg", "添加成功");
        resp.sendRedirect("lookCs");
    }
}
