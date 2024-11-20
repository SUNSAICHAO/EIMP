package Dao.DaoImpl;

import Bean.Staff;
import Dao.StaffDao;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class StaffDaoImpl implements StaffDao {
    private static final String ADD_STAFF="insert into staff values(?,?,?,?,?,?,?,?)";
    private static final String FIND_ALL_STAFF="select * from staff";

    @Override
    public void addStaff(Staff staff) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_STAFF);
        preparedStatement.setString(1,staff.getStaffName());
        preparedStatement.setString(2,staff.getStaffSex());
        preparedStatement.setString(3,staff.getStaffAge());
        preparedStatement.setString(4,staff.getStaffEducation());
        preparedStatement.setString(5,staff.getStaffDepartment());
        preparedStatement.setString(6,staff.getStaffDate());
        preparedStatement.setString(7,staff.getStaffDuty());
        preparedStatement.setString(8,staff.getStaffWage());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
    }

    @Override
    public ArrayList<Staff> findAllStaff() throws SQLException {
        ArrayList<Staff> allStaff = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_STAFF);
        while (resultSet.next()) {
            Staff staff = JDBCUtils.resultToStaff(resultSet);
            allStaff.add(staff);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeConection(con);
        return allStaff;
    }
}
