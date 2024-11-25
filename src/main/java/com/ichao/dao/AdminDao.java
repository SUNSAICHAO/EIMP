package com.ichao.dao;
import com.ichao.entity.Admin;
import java.sql.SQLException;

public interface AdminDao {

    Admin getByName(String username) throws SQLException;

    void insert(Admin admin) throws SQLException;

}
