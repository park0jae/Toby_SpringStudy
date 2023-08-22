package com.toby.study.dao;

import com.toby.study.domain.user.User;

import javax.sql.DataSource;
import java.sql.*;

/**
 *  1. DB 연결을 위한 Connection을 가져온다.
 *  2. SQL을 담은 Statement 또는 PreparedStatement를 만든다.
 *  3. 만들어진 Statement를 실행한다.
 *  4. 조회의 경우 SQL 쿼리의 실행 결과를 ResultSet으로 받아서 정보를 저장할 오브젝트에 옮겨준다 (= User)
 *  5. 작업 중 생성된 Connection , Statement, ResultSet 같은 리소스는 작업 마친 후 반드시 닫아준다.
 *  6. JDBC API가 만들어내는 예외를 잡아 직접 처리하거나, 메소드에 throws를 선언한다.
 */
public class UserDao {

    private JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }


    public User get(String id)throws SQLException {


        // DB 연결을 위한 커넥션을 가져온다.
        StatementStrategy strategy = c -> {
            PreparedStatement ps = c.prepareStatement("select * from users where id = ?");// 선정한 전략 클래스의 오브젝트 생성

            ps.setString(1, id);

            return ps;
        };

        ResultSet rs = jdbcContext.workWithResultSet(strategy);// 컨텍스트 호출, 전략 오브젝트 전달

        // 조회의 경우 ResultSet 반환
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        rs.close();

        return user;
    }

    public void deleteAll() throws SQLException {
        executeSql("delete from users");
    }

    public void executeSql(String sql) throws SQLException {
        StatementStrategy strategy = c -> c.prepareStatement(sql); // 선정한 전략 클래스의 오브젝트 생성
        jdbcContext.workWithStatementStrategy(strategy); // 컨텍스트 호출, 전략 오브젝트 전달
    }

    public void add(User user) throws SQLException {
        this.executeSql("insert into users(id, name, password) values (?, ?, ?)"
                , user.getId()
                , user.getName()
                , user.getPassword()
        );
    }

    public void executeSql(String sql, Object ...parameters) throws SQLException {
        StatementStrategy stmt = c -> {
            PreparedStatement ps = c.prepareStatement(sql);

            for(int i=1; i<=parameters.length; i++) {
                ps.setObject(i, parameters[i-1]);
            }

            return ps;
        };

        jdbcContext.workWithStatementStrategy(stmt);
    }

}
