package com.ichao.servlet;

import com.ichao.dao.ProductDao;
import com.ichao.dao.daoImpl.ProductDaoImpl;
import com.ichao.entity.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private ProductDao productDao;

    @Override
    public void init() {
        productDao=new ProductDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ArrayList<Product>list = productDao.list();
            req.setAttribute("productList", list);
            req.getRequestDispatcher("/lookProduct.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Product product = getProductByRequest(req);
            productDao.insert(product);
            resp.sendRedirect("product");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Product getProductByRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String model = request.getParameter("model");
        String number = request.getParameter("number");
        String price = request.getParameter("price");
        return new Product(name,model,number,price);
    }


}
