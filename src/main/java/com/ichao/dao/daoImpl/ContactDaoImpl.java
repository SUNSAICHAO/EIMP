package com.ichao.dao.daoImpl;

import com.ichao.dao.ContactDao;
import com.ichao.entity.Contact;
import com.ichao.utils.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;

public class ContactDaoImpl implements ContactDao {
    private static final String ADD_CONTACT = "insert into contact values(?,?,?,?,?,?)";
    private static final String DELETE_CONTACT_BY_NAME = "delete from contact where contactName=?";
    private static final String UPDATE_CONTACT = "update contact set clientName=?,contactContents=?,contactStart=?,contactEnd=?,StaffName=? where contactName=? ";
    private static final String FIND_CONTACT_BY_NAME = "select * from contact where name=?";
    private static final String FIND_ALL_CONTACT = "select * from contact";

    @Override
    public void insert(Contact contact) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_CONTACT);
        preparedStatement.setString(1, contact.getClientName());
        preparedStatement.setString(2, contact.getName());
        preparedStatement.setString(3, contact.getContents());
        preparedStatement.setString(4, contact.getStart());
        preparedStatement.setString(5, contact.getEnd());
        preparedStatement.setString(6, contact.getEmployeeName());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }

    @Override
    public Contact getByName(String contactName) throws SQLException {
        Contact contact = null;
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(FIND_CONTACT_BY_NAME);
        preparedStatement.setString(1, contactName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            contact = JDBCUtils.resultToContact(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        con.close();
        return contact;
    }

    @Override
    public ArrayList<Contact> list() throws SQLException {
        ArrayList<Contact> allContact = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_CONTACT);
        while (resultSet.next()) {
            Contact contact = JDBCUtils.resultToContact(resultSet);
            allContact.add(contact);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeCon(con);
        return allContact;
    }

}


