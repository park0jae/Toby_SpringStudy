package com.toby.study.test;

import com.toby.study.dao.UserDao;
import com.toby.study.domain.user.User;
import com.toby.study.factory.DaoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserDaoTest {
    UserDao userDao;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
        userDao = context.getBean("userDao", UserDao.class);
        userDao.deleteAll();
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
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
