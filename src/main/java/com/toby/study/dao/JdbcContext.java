package com.toby.study.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcContext {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException{
        Connection c = null;
        PreparedStatement ps = null;

        try{
            c = dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);

            ps.executeUpdate();
        }catch (SQLException e){
            throw e;
        }finally {
            if(ps != null) {try {ps.close();} catch (SQLException e) {}}
            if(c != null) {try {c.close();} catch (SQLException e) {}}
        }
    }

    public ResultSet workWithResultSet(StatementStrategy stmt) throws SQLException{
        Connection c = null;
        PreparedStatement ps = null;

        try{
            c = dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);

            ResultSet rs = ps.executeQuery();
            return rs;
        }catch (SQLException e){
            throw e;
        }finally {
            if(ps != null) {try {ps.close();} catch (SQLException e) {}}
            if(c != null) {try {c.close();} catch (SQLException e) {}}
        }
    }
}
