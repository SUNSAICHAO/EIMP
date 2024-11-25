package com.ichao.dao;



import com.ichao.entity.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientDao {

    void insert(Client client) throws SQLException;
    void deleteByName(String name) throws SQLException;
    void update(Client client) throws SQLException;
    Client getByName(String name)throws SQLException;
    ArrayList<Client>list() throws SQLException;
}
