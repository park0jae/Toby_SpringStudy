package com.toby.study.factory;

import com.toby.study.dao.JdbcContext;
import com.toby.study.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * UserDao 와 ConnectionFactory 오브젝트들을 구성하고 관계를 정의하는 책임이 있음
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        return userDao;
    }
    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/studyToby");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");

        return dataSource;
    }


}
