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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    //business object(s) under test called a "fixture"
    private Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsEven() {
        assertTrue(calc.isEven(6));
        assertFalse(calc.isEven(1));
    }

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), .001);
    }
}