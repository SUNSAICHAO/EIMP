package Dao;

import Bean.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientDao {

    void addClient(Client client) throws SQLException;

    boolean deleteClientByName(String name) throws SQLException;
    boolean updateClient(Client client) throws SQLException;
    boolean findClientByName(String name)throws SQLException;
    ArrayList<Client>findAllClient() throws SQLException;
}
