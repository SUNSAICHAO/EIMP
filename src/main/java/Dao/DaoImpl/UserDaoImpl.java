package Dao.DaoImpl;

import Bean.User;
import Dao.UserDao;
import JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private static final String FIND_USER = "select * from user where username=? and password=?";
    private static final String FIND_USER_BY_NAME = "select * from user where username=?";
    private static final String INSET_USER = "insert into user values(?,?)";

    @Override
    public boolean findUser(User user) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(FIND_USER);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        User user1=null;
        while (resultSet.next()){
             user1 = JDBCUtils.resultSetToUser(resultSet);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
        if (user1 != null)
            return true;
        else
            return false;

    }

    @Override
    public boolean findUserbyName(String username) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(FIND_USER_BY_NAME);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user1=null;
        while (resultSet.next()){
            user1= JDBCUtils.resultSetToUser(resultSet);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
        if (user1!=null)
            return true;
        else
            return false;
    }


    @Override
    public void insertUser(User user) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(INSET_USER);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
    }
}
