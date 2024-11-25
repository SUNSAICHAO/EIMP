package com.ichao.dao;
import com.ichao.entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    void insert(Product product) throws SQLException;

    ArrayList<Product> list() throws SQLException;
}
