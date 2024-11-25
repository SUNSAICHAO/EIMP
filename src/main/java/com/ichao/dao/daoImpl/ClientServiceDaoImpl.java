package com.ichao.dao.daoImpl;


import com.ichao.dao.ClientServiceDao;
import com.ichao.entity.ClientService;
import com.ichao.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class ClientServiceDaoImpl implements ClientServiceDao {
    private static final String ADD_CS = "insert into clientservice values(?,?,?)";
    private static final String FIND_ALL_CS = "select * from clientservice";

    @Override
    public void insert(ClientService clientService) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_CS);
        preparedStatement.setString(1, clientService.getClientName());
        preparedStatement.setString(2, clientService.getClientOpinion());
        preparedStatement.setString(3, clientService.getEmployeeName());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }


    @Override
    public ArrayList<ClientService> list() throws SQLException {
        ArrayList<ClientService> allCS = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_CS);
        while (resultSet.next()) {
            ClientService clientService = JDBCUtils.resultToCs(resultSet);
            allCS.add(clientService);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeCon(con);
        return allCS;
    }
}
