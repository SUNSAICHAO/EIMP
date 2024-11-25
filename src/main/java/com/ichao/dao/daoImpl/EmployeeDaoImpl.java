package com.ichao.dao.daoImpl;

import com.ichao.dao.EmployeeDao;
import com.ichao.entity.Employee;
import com.ichao.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String ADD_STAFF="insert into employee values(?,?,?,?,?,?,?,?)";
    private static final String FIND_ALL_STAFF="select * from employee";

    @Override
    public void insert(Employee employee) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_STAFF);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getSex());
        preparedStatement.setString(3, employee.getAge());
        preparedStatement.setString(4, employee.getEducation());
        preparedStatement.setString(5, employee.getDepartment());
        preparedStatement.setString(6, employee.getDate());
        preparedStatement.setString(7, employee.getDuty());
        preparedStatement.setString(8, employee.getWage());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeCon(con);
    }

    @Override
    public ArrayList<Employee> list() throws SQLException {
        ArrayList<Employee> allEmployee = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_STAFF);
        while (resultSet.next()) {
            Employee employee = JDBCUtils.resultToEmployee(resultSet);
            allEmployee.add(employee);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeCon(con);
        return allEmployee;
    }
}
