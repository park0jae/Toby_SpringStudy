package com.toby.study.factory;

import com.toby.study.connection.ConnectionMaker;
import com.toby.study.connection.DConnectionMaker;
import com.toby.study.dao.UserDao;

/**
 * UserDao 와 ConnectionFactory 오브젝트들을 구성하고 관계를 정의하는 책임이 있음
 */
public class DaoFactory {

    public UserDao userDao(){
        ConnectionMaker con = new DConnectionMaker();
        UserDao userDao = new UserDao(con);

        return userDao;
    }
}
