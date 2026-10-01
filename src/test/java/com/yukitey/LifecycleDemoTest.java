package com.yukitey;

import org.junit.jupiter.api.*;

class LifecycleDemoTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("1. @BeforeAll — один раз перед всеми тестами");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("2. @BeforeEach — перед каждым тестом");
    }

    @Test
    void test1() {
        System.out.println("3. Тест №1");
    }

    @Disabled("Пока не готов")
    @Test
    void test2() {
        System.out.println("3. Тест №2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("4. @AfterEach — после каждого теста");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("5. @AfterAll — один раз после всех тестов");
    }
}