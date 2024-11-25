package com.ichao.dao.daoImpl;

import com.ichao.dao.ClientDao;
import com.ichao.entity.Client;
import com.ichao.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;


public class ClientDaoImpl implements ClientDao {
    private static final String ADD_CLIENT = "insert into client values(?,?,?,?)";
    private static final String DELETE_CLIENT_BY_NAME = "delete from client where name=?";
    private static final String UPDATE_CLIENT = "update client set phone=? ,address=?, email=? where name=?";
    private static final String FIND_CLIENT_BY_NAME = "select * from client where name=?";
    private static final String FIND_ALL_CLIENT = "select * from client";

    @Override
    public void insert(Client client) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_CLIENT);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getPhone());
        preparedStatement.setString(3, client.getAddress());
        preparedStatement.setString(4, client.getEmail());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }

    @Override
    public void deleteByName(String name) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(DELETE_CLIENT_BY_NAME);
        preparedStatement.setString(1, name);
        preparedStatement.execute();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }


    public void update(Client client) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(UPDATE_CLIENT);
        preparedStatement.setString(1, client.getPhone());
        preparedStatement.setString(2, client.getAddress());
        preparedStatement.setString(3, client.getEmail());
        preparedStatement.setString(4, client.getName());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }


    @Override
    public Client getByName(String name) throws SQLException {
        Client client = null;
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(FIND_CLIENT_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            client = JDBCUtils.resultToClient(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        con.close();
        return client;
    }

    public ArrayList<Client> list() throws SQLException {
        ArrayList<Client>allClient = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_CLIENT);
        while (resultSet.next()) {
            Client client = JDBCUtils.resultToClient(resultSet);
            allClient.add(client);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeCon(con);
        return allClient;
    }


}
