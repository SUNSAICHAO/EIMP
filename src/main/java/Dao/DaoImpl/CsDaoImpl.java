package Dao.DaoImpl;

import Bean.Cs;
import Dao.CsDao;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class CsDaoImpl implements CsDao {
    private static final String ADD_CS = "insert into cs values(?,?,?)";
    private static final String FIND_CS_BY_NAME = "select * from cs where clientName=?";

    private static final String FIND_ALL_CS = "select * from cs";

    @Override
    public void addCs(Cs cs) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement preparedStatement = con.prepareStatement(ADD_CS);
        preparedStatement.setString(1,cs.getClientName());
        preparedStatement.setString(2,cs.getClientOpinion());
        preparedStatement.setString(3,cs.getStaffName());
        preparedStatement.executeUpdate();
        JDBCUtils.closePreparedStatement(preparedStatement);
        JDBCUtils.closeConection(con);
    }


    @Override
    public ArrayList<Cs> findAllCs() throws SQLException {
        ArrayList<Cs> allCs = new ArrayList<>();
        Connection con = JDBCUtils.getCon();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_CS);
        while (resultSet.next()) {
            Cs cs = JDBCUtils.resultToCs(resultSet);
            allCs.add(cs);
        }
        JDBCUtils.closeResultSet(resultSet);
        JDBCUtils.closeStatement(statement);
        JDBCUtils.closeConection(con);
        return allCs;
    }
}
