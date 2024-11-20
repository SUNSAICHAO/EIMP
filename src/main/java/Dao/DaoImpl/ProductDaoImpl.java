package Dao.DaoImpl;

import Bean.Product;
import Dao.ProductDao;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
    private static final String ADD_PRODUCT = "insert into product values(?,?,?,?)";
    private static final String FIND_ALL_PRODUCT = "select * from product";


    @Override
    public void addProduct(Product product) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_PRODUCT);
        preparedStatement.setString(1,product.getProductName());
        preparedStatement.setString(2,product.getProductModel());
        preparedStatement.setString(3,product.getProductNumber());
        preparedStatement.setString(4,product.getProductPrice());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
    }


    @Override
    public ArrayList<Product> findAllProduct() throws SQLException {
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
        JDBCUtils.closeConection(con);
        return allProduct;
    }
}
