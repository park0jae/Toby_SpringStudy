package com.toby.study.domain.test;

import com.toby.study.domain.dao.UserDao;
import com.toby.study.domain.dao.connection.ConnectionMaker;
import com.toby.study.domain.dao.connection.DConnectionMaker;
import com.toby.study.domain.user.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new DConnectionMaker();

        UserDao dao = new UserDao(connectionMaker);
        User user = new User();

        user.setId("1");
        user.setName("박영재");
        user.setPassword("1234");

        // 등록
        dao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        // 	조회
        User getUser = dao.get(user.getId());
        System.out.println(getUser.getName());
        System.out.println(getUser.getPassword());
        System.out.println(getUser.getId() + " 조회 성공");
    }
}
