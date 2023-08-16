package com.toby.study.test;

import com.toby.study.dao.UserDao;
import com.toby.study.domain.user.User;
import com.toby.study.factory.DaoFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);

        User user = new User();

        user.setId("1");
        user.setName("박영재");
        user.setPassword("1234");

        // 등록
        userDao.add(user);
        System.out.println(user.getId() + " 등록 성공");

        // 	조회
        User getUser = userDao.get(user.getId());

        assertThat(getUser.getName()).isEqualTo(user.getName());
        assertThat(getUser.getPassword()).isEqualTo(user.getPassword());
    }
}
