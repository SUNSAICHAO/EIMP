package com.ichao.dao.daoImpl;

import com.ichao.dao.AdminDao;
import com.ichao.entity.Admin;
import com.ichao.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    private static final String FIND_USER_BY_NAME = "select * from admin where username=?";
    private static final String INSET_USER = "insert into admin values(?,?)";

    @Override
    public Admin getByName(String username) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(FIND_USER_BY_NAME);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        Admin admin = null;
        while (resultSet.next()) {
            admin = JDBCUtils.resultSetToUser(resultSet);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
        return admin;
    }


    @Override
    public void insert(Admin admin) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(INSET_USER);
        preparedStatement.setString(1, admin.getUsername());
        preparedStatement.setString(2, admin.getPassword());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }
}
