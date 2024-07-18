package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {

    private HourlyEmployee hemp;

    @Before
    public void setUp() {
        hemp = new HourlyEmployee("Malachi", Date.valueOf("2018-11-29"), 32.0, 80.0);
    }

    @Test
    public void testPay() {
        assertEquals(2560, hemp.pay(), .001); // rate * hours
    }

    @Test
    public void testPayTaxes() {
        assertEquals(640.0, hemp.payTaxes(), .001); // should be 640
    }
}