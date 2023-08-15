package com.toby.study.domain.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/studyToby";
        String dbUser = "root";
        String pw = "12345678";
        Connection c = DriverManager.getConnection(url, dbUser, pw);

        return c;
    }
}
