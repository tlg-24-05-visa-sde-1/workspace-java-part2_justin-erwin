/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
    //business object(s) under test - called a "fixture" in JUnit
    private Calculator calc;

    //runs once before all tests (and @Before) - rarely used
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("beforeClass");
    }

    //runs once after all tests (and @After) - rarely used
    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("afterClass");
    }

    //set-up method - most used out of all the fixtures
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
        calc = new Calculator();  //instantiate new Calculator instance here and assign it to calc & we don't need to
        //repeat ourselves in each test.  setUp() is called before each test unit so each test gets a brand-new Calculator.
    }
    //tear-down method to clean up - mostly used to close connections or files we've opened.  Will run after each test method.
    @After
    public void cleanUp() throws Exception {
        System.out.println("cleanUp");
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");
        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(9));
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        assertEquals(2.5, calc.divide(5, 2), .001);  //delta is the tolerance, and we need to use it with doubles.
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

}