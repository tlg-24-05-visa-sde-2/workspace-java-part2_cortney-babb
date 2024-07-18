package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    private SalariedEmployee semp;
    private SalariedEmployee semp2;

    @Before
    public void setUp() {
        semp = new SalariedEmployee("Logan", Date.valueOf("2014-10-01"), 1500.0);
        semp2 = new SalariedEmployee("Logan", Date.valueOf("2014-10-01"), 1500.0);
    }

    @Test
    public void testPay() {
        assertEquals(1500.0, semp.pay(), .001); // fixed salary
    }

    @Test
    public void testPayTaxes() {
        assertEquals(450.0, semp.payTaxes(), .001); // 30% of the salary
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(semp, semp2); // assertEquals for objects does a .equals() check
//        assertTrue(semp.equals(semp2)); // alternative
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        semp2.setSalary(1299.0);
        assertNotEquals(semp, semp2);
//        assertFalse(semp.equals(semp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        semp2.setHireDate(Date.valueOf("2022-10-12"));
        assertNotEquals(semp, semp2);
//        assertFalse(semp.equals(semp2));
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        semp2.setName("Jhene");
        assertNotEquals(semp, semp2);
    }
}