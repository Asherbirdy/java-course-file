package com.kucw.security;

import org.junit.jupiter.api.*;

public class MyTest {

    @BeforeEach
    public void before(){
        System.out.println("before");
    }

    @AfterEach
    public void after(){
        System.out.println("after");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("BeforeAll");
    }

    @Test
    public void test1(){
        System.out.println( "test1");
    }

    @Test
    public void test2(){
        System.out.println( "test2");
    }
}
