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
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testIsEven() {
        Calculator calc = new Calculator();
        assertTrue(calc.isEven(6));
        assertFalse(calc.isEven(11));
    }

    @Test
    public void testDivide() {
        Calculator calc = new Calculator();
        assertEquals(6.5, calc.divide(13, 2), .001); // decimals must use delta (.001)
    }

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }
}