package com.toby.study.factory;

import com.toby.study.connection.ConnectionMaker;
import com.toby.study.connection.DConnectionMaker;
import com.toby.study.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * UserDao 와 ConnectionFactory 오브젝트들을 구성하고 관계를 정의하는 책임이 있음
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
