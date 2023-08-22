package com.toby.study.test;

import com.toby.study.factory.DaoFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class ApplicationContextTest {

    @Autowired
    ApplicationContext applicationContext;

    static Set<ApplicationContext> applicationContexts = new HashSet<>();

    @AfterAll
    public static void afterAll(){
        Assertions.assertEquals(applicationContexts.size(), 1);
    }

    @Test
    public void test1(){
        applicationContexts.add(applicationContext);
    }
    @Test
    public void test2(){
        applicationContexts.add(applicationContext);
    }
    @Test
    public void test3(){
        applicationContexts.add(applicationContext);
    }
}
