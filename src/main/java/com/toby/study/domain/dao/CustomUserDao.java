package com.toby.study.domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomUserDao extends UserDao{
    @Override
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/studyToby";
        String dbUser = "root";
        String pw = "12345678";
        Connection c = DriverManager.getConnection(url, dbUser, pw);

        return c;
    }
}
