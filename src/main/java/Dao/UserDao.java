package Dao;

import Bean.User;

import java.sql.SQLException;

public interface UserDao {
    boolean findUser(User user) throws SQLException;

    //    在登陆页面检查用户是否存在(检查用户名和密码是否正确)存在就登录成功

    boolean findUserbyName(String username) throws SQLException;
    //    在注册页面检查用户名是否存在，若存在则提示该用户已存在，请登录

    void insertUser(User user) throws SQLException;
    //    在注册页面，添加新注册的用户名和密码到数据库
}
