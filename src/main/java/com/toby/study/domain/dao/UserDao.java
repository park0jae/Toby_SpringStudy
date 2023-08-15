package com.toby.study.domain.dao;

import com.toby.study.domain.dao.connection.ConnectionMaker;
import com.toby.study.domain.dao.connection.DConnectionMaker;
import com.toby.study.domain.user.User;

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

    private ConnectionMaker simpleConnectionMaker;

    public UserDao(ConnectionMaker connectionMaker){
        simpleConnectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        // 동적으로 클래스 정보를 가져온다.
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // DB 연결을 위한 커넥션을 가져온다.
        Connection c = simpleConnectionMaker.makeConnection();

        // SQL을 담은 Statement (Statement 또는 PreparedStatement)를 만든다.
        String query = "insert into users(id, name, password) values (?,?,?)";
        PreparedStatement ps = c.prepareStatement(query);
        
        // 파라미터 값을 설정해주고 , 만들어진 statement를 실행한다.
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        // 동적으로 클래스 정보를 가져온다.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // DB 연결을 위한 커넥션을 가져온다.
        Connection c = simpleConnectionMaker.makeConnection();

        // SQL을 담은 Statement (Statement 또는 PreparedStatement)를 만든다.
        String query = "select * from users where id = ?";
        PreparedStatement ps = c.prepareStatement(query);

        ps.setString(1, id);

        // 조회의 경우 ResultSet 반환
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }


}
