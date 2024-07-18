package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee emp;
    private Employee emp2;

    @Before
    public void setUp() {
        emp = new SalariedEmployee("Cort", Date.valueOf("2024-05-07"));
        emp2 = new SalariedEmployee("Cort", Date.valueOf("2024-05-07"));
    }

    @Test
    public void equals_shouldReturnTrue_sameName_sameHireDate() {
        assertEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2020-04-12"));
        assertNotEquals(emp, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Beans");
        assertNotEquals(emp, emp2);
    }
}