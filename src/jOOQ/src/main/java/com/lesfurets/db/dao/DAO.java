package com.lesfurets.db.dao;

import java.sql.Connection;

public class DAO {

    protected final Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

}
