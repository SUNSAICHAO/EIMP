package com.ichao.servlet;
import com.ichao.dao.AdminDao;
import com.ichao.dao.daoImpl.AdminDaoImpl;
import com.ichao.entity.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private AdminDao adminDao;

    @Override
    public void init() throws ServletException {
        super.init();
        adminDao=new AdminDaoImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            Admin admin = getAdminByRequest(req);
            Admin adminDB = adminDao.getByName(admin.getUsername());
            if (adminDB!=null){
                req.setAttribute("msg", "注册失败，用户已存在");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            }
            adminDao.insert(admin);
            HttpSession session = req.getSession();
            session.setAttribute("username", admin.getUsername());
            session.setAttribute("password", admin.getPassword());
            resp.getWriter().println("<script>");
            resp.getWriter().println("alert('注册成功，去登录');");
            resp.getWriter().println("window.document.location.href='login.jsp';");
            resp.getWriter().println("</script>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private Admin getAdminByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        return new Admin(username,password);
    }
}
