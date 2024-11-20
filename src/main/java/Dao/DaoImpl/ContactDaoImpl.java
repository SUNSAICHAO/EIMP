package Dao.DaoImpl;

import Bean.Contact;
import Dao.ContactDao;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class ContactDaoImpl implements ContactDao {
    private static final String ADD_CONTACT = "insert into contact values(?,?,?,?,?,?)";
    private static final String DELETE_CONTACT_BY_NAME = "delete from contact where contactName=?";
    private static final String UPDATE_CONTACT = "update contact set clientName=?,contactContents=?,contactStart=?,contactEnd=?,StaffName=? where contactName=? ";
    private static final String FIND_CONTACT_BY_NAME = "select * from contact where contactName=?";
    private static final String FIND_ALL_CONTACT = "select * from contact";

    @Override
    public void addContact(Contact contact) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_CONTACT);
        preparedStatement.setString(1, contact.getClientName());
        preparedStatement.setString(2, contact.getContactName());
        preparedStatement.setString(3, contact.getContactContents());
        preparedStatement.setString(4, contact.getContactStart());
        preparedStatement.setString(5, contact.getContactEnd());
        preparedStatement.setString(6, contact.getStaffName());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
    }

    @Override
    public boolean findContactByName(String contactName) throws SQLException {
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
        return contact != null;
    }

    @Override
    public ArrayList<Contact> findAllContact() throws SQLException {
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
        JDBCUtils.closeConection(con);
        return allContact;
    }

}


