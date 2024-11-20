package Servlet;
import Bean.Product;
import Dao.DaoImpl.ProductDaoImpl;
import Dao.ProductDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class addProduct extends HttpServlet {
    ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String productName = req.getParameter("productName");
        String productModel = req.getParameter("productModel");
        String productNumber = req.getParameter("productNumber");
        String productPrice = req.getParameter("productPrice");
        if (username==null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        if (productName==null || productName.isEmpty()) {
            resp.sendRedirect("addProduct.jsp");
            return;
        }
        Product product = new Product(productName, productModel, productNumber, productPrice);
        try {
            productDao.addProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        session.setAttribute("addProductMsg", "添加成功");
        resp.sendRedirect("lookProduct");
    }
}
