package JDBCUtils;

import Bean.*;

import java.sql.*;

public class JDBCUtils {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
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

    public static void closeConection(Connection connection) {
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

    public static User resultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    public static Client resultTOClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setName(resultSet.getString("clientName"));
        client.setPhone(resultSet.getString("clientPhone"));
        client.setAddress(resultSet.getString("clientAddress"));
        client.setEmail(resultSet.getString("clientEmail"));
        return client;
    }
    public static Contact resultToContact(ResultSet resultSet) throws SQLException {
        Contact contact=new Contact();
        contact.setClientName(resultSet.getString("clientName"));
        contact.setContactName(resultSet.getString("contactName"));
        contact.setContactContents(resultSet.getString("contactContents"));
        contact.setContactStart(resultSet.getString("contactStart"));
        contact.setContactEnd(resultSet.getString("contactEnd"));
        contact.setStaffName(resultSet.getString("StaffName"));
        return contact;
    }
    public static Cs resultToCs(ResultSet resultSet) throws SQLException {
       Cs cs=new Cs();
       cs.setClientName(resultSet.getString("clientName"));
       cs.setClientOpinion(resultSet.getString("clientOpinion"));
       cs.setStaffName(resultSet.getString("StaffName"));
       return cs;
    }
    public static Product resultToProduct(ResultSet resultSet) throws SQLException {
        Product product=new Product();
        product.setProductName(resultSet.getString("productName"));
        product.setProductModel(resultSet.getString("productModel"));
        product.setProductNumber(resultSet.getString("productNumber"));
        product.setProductPrice(resultSet.getString("productPrice"));
        return product;
    }
    public static Staff resultToStaff(ResultSet resultSet) throws SQLException {
        Staff staff=new Staff();
        staff.setStaffName(resultSet.getString("staffName"));
        staff.setStaffSex(resultSet.getString("staffSex"));
        staff.setStaffAge(resultSet.getString("staffAge"));
        staff.setStaffEducation(resultSet.getString("staffEducation"));
        staff.setStaffDepartment(resultSet.getString("staffDepartment"));
        staff.setStaffDate(resultSet.getString("staffDate"));
        staff.setStaffDuty(resultSet.getString("staffDuty"));
        staff.setStaffWage(resultSet.getString("staffWage"));
        return staff;
    }
}
