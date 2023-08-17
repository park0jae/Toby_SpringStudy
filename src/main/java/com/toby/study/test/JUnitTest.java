package com.toby.study.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    static JUnitTest testObject;

    @BeforeAll
    public static void beforeAll(){
        testObject = new JUnitTest();
    }

    @AfterEach
    public void afterEach(){
        testObject = this;
    }

    @Test
    public void test1(){
        Assertions.assertNotSame(testObject,this);
    }

    @Test
    public void test2(){
        Assertions.assertNotSame(testObject,this);
    }

    @Test
    public void test3(){
        Assertions.assertNotSame(testObject,this);
    }
}
