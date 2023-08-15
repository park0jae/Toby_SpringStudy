package com.toby.study.domain.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {

    public Connection makeConnection() throws SQLException;

}
