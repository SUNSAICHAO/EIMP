package com.ichao.dao;
import com.ichao.entity.ClientService;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientServiceDao {
    void insert(ClientService clientFeedback) throws SQLException;
    ArrayList<ClientService> list() throws SQLException;
}
