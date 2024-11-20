package Dao.DaoImpl;

import Bean.Client;
import Dao.ClientDao;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;


public class ClientDaoImpl implements ClientDao {
    private static final String ADD_CLIENT = "insert into client values(?,?,?,?)";
    private static final String DELETE_CLIENT_BY_NAME = "delete from client where clientName=?";
    private static final String UPDATE_CLIENT = "update client set clientPhone=? ,clientAddress=?, clientEmail=? where clientName=?";
    private static final String FIND_CLIENT_BY_NAME = "select * from client where clientName=?";
    private static final String FIND_ALL_CLIENT = "select * from client";

    @Override
    public void addClient(Client client) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_CLIENT);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getPhone());
        preparedStatement.setString(3, client.getAddress());
        preparedStatement.setString(4, client.getEmail());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
    }

    @Override
    public boolean deleteClientByName(String name) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(DELETE_CLIENT_BY_NAME);
        preparedStatement.setString(1, name);
        int rows = preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
        return rows == 1;
    }


    public boolean updateClient(Client client) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(UPDATE_CLIENT);
        preparedStatement.setString(1, client.getPhone());
        preparedStatement.setString(2, client.getAddress());
        preparedStatement.setString(3, client.getEmail());
        preparedStatement.setString(4, client.getName());
        int rows = preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
        return rows == 1;
    }


    @Override
    public boolean findClientByName(String name) throws SQLException {
        Client client = null;
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(FIND_CLIENT_BY_NAME);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            client = JDBCUtils.resultTOClient(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        con.close();
        if (client != null)
            return true;
        else
            return false;
    }

    @Override
    public ArrayList<Client> findAllClient() throws SQLException {
        ArrayList<Client>allClient = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_CLIENT);
        while (resultSet.next()) {
            Client client = JDBCUtils.resultTOClient(resultSet);
            allClient.add(client);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeConection(con);
        return allClient;
    }


}
