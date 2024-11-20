package Dao;

import Bean.Cs;
import Bean.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    void addProduct(Product product) throws SQLException;
    ArrayList<Product> findAllProduct() throws SQLException;
}
