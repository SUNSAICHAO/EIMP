package Dao;

import Bean.Cs;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CsDao {
    void addCs(Cs cs) throws SQLException;
    ArrayList<Cs> findAllCs() throws SQLException;
}
