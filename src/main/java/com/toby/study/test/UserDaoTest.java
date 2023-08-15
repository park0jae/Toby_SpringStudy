package com.toby.study.test;

import com.toby.study.dao.UserDao;
import com.toby.study.connection.ConnectionMaker;
import com.toby.study.connection.DConnectionMaker;
import com.toby.study.domain.user.User;
import com.toby.study.factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new DConnectionMaker();

        UserDao userDao = new DaoFactory().userDao();
        User user = new User();

        user.setId("1");
        user.setName("박영재");
        user.setPassword("1234");

        // 등록
        userDao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        // 	조회
        User getUser = userDao.get(user.getId());
        System.out.println(getUser.getName());
        System.out.println(getUser.getPassword());
        System.out.println(getUser.getId() + " 조회 성공");
    }
}
