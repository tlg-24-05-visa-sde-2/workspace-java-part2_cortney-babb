package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    private SalariedEmployee semp;

    @Before
    public void setUp() {
        semp = new SalariedEmployee("Logan", Date.valueOf("2014-10-01"), 1500.0);
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, semp.pay(), .001); // fixed salary
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, semp.payTaxes(), .001); // 30% of the salary
    }
}