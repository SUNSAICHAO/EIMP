package com.ichao.dao;

import com.ichao.entity.Contact;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ContactDao {
    void insert(Contact contact) throws SQLException;


    Contact getByName(String name) throws SQLException;

    ArrayList<Contact> list() throws SQLException;
}
