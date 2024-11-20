package Dao;

import Bean.Contact;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ContactDao {
    void addContact(Contact contact) throws SQLException;


    boolean findContactByName(String name) throws SQLException;

    ArrayList<Contact> findAllContact() throws SQLException;
}
