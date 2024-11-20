package Dao;

import Bean.Contact;
import Bean.Staff;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StaffDao {
    void addStaff(Staff staff) throws SQLException;

    ArrayList<Staff> findAllStaff() throws SQLException;
}
