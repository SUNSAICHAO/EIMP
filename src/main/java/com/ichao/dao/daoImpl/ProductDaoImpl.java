package com.ichao.dao.daoImpl;

import com.ichao.dao.ProductDao;
import com.ichao.entity.Product;
import com.ichao.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
    private static final String ADD_PRODUCT = "insert into product values(?,?,?,?)";
    private static final String FIND_ALL_PRODUCT = "select * from product";


    @Override
    public void insert(Product product) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_PRODUCT);
        preparedStatement.setString(2,product.getModel());
        preparedStatement.setString(3,product.getNumber());
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(4,product.getPrice());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }
    @Override
    public ArrayList<Product> list() throws SQLException {
        ArrayList<Product> allProduct = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_PRODUCT);
        while (resultSet.next()) {
            Product product = JDBCUtils.resultToProduct(resultSet);
            allProduct.add(product);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeCon(con);
        return allProduct;
    }
}
