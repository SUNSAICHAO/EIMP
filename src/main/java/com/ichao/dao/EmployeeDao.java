package com.ichao.dao;
import com.ichao.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDao {
    void insert(Employee employee) throws SQLException;

    ArrayList<Employee> list() throws SQLException;
}
