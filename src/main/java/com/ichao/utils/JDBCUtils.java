package com.ichao.utils;

import com.ichao.entity.*;

import java.sql.*;

public class JDBCUtils {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/eimp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";


    public static Connection getCon() {
        Connection connection=null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeCon(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null)
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Admin resultSetToUser(ResultSet resultSet) throws SQLException {
        Admin admin = new Admin();
        admin.setUsername(resultSet.getString("username"));
        admin.setPassword(resultSet.getString("password"));
        return admin;
    }

    public static Client resultToClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setName(resultSet.getString("name"));
        client.setPhone(resultSet.getString("phone"));
        client.setAddress(resultSet.getString("address"));
        client.setEmail(resultSet.getString("email"));
        return client;
    }
    public static Contact resultToContact(ResultSet resultSet) throws SQLException {
        Contact contact=new Contact();
        contact.setClientName(resultSet.getString("clientName"));
        contact.setName(resultSet.getString("name"));
        contact.setContents(resultSet.getString("contents"));
        contact.setStart(resultSet.getString("start"));
        contact.setEnd(resultSet.getString("end"));
        contact.setEmployeeName(resultSet.getString("employeeName"));
        return contact;
    }
    public static ClientService resultToCs(ResultSet resultSet) throws SQLException {
       ClientService clientservice =new ClientService();
       clientservice.setClientName(resultSet.getString("clientName"));
       clientservice.setClientOpinion(resultSet.getString("clientOpinion"));
       clientservice.setEmployeeName(resultSet.getString("employeeName"));
       return clientservice;
    }
    public static Product resultToProduct(ResultSet resultSet) throws SQLException {
        Product product=new Product();
        product.setName(resultSet.getString("name"));
        product.setModel(resultSet.getString("model"));
        product.setNumber(resultSet.getString("number"));
        product.setPrice(resultSet.getString("price"));
        return product;
    }
    public static Employee resultToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee =new Employee();
        employee.setName(resultSet.getString("name"));
        employee.setSex(resultSet.getString("sex"));
        employee.setAge(resultSet.getString("age"));
        employee.setEducation(resultSet.getString("education"));
        employee.setDepartment(resultSet.getString("department"));
        employee.setDate(resultSet.getString("date"));
        employee.setDuty(resultSet.getString("duty"));
        employee.setWage(resultSet.getString("wage"));
        return employee;
    }
}
