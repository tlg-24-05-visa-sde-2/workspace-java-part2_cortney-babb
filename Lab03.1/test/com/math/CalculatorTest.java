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
    // business object(s) under test - call "fixture"
    private Calculator calc;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        calc = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Test
    public void testIsEven() {
        assertTrue(calc.isEven(6));
        assertFalse(calc.isEven(11));
    }

    @Test
    public void testDivide() {
        assertEquals(6.5, calc.divide(13, 2), .001); // decimals must use delta (.001)
    }

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }
}