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

        emp = new Employee("Cort", Date.valueOf("2024-05-07")) {

            @Override
            public double payTaxes() {
                return 0;
            }

            @Override
            public double pay() {
                return 0;
            }
        };
        // creating anonymous (subclass) class bc cant create new Employee object (its abstract)
        // you can clean it up so its not as messy by doing it inline
        emp2 = new Employee("Cort", Date.valueOf("2024-05-07")) {
            public double payTaxes() { return 0; }
            public double pay() { return 0; }
        };
        // with mock
        //emp = new DummyEmployee("Cort", Date.valueOf("2024-05-07"));
        //emp2 = new DummyEmployee("Cort", Date.valueOf("2024-05-07"));
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



    // NAMED MEMBER LEVEL INNER CLASS
    // called a Mock, fake business type just for testing
//    private class DummyEmployee extends Employee {
//
//        public DummyEmployee() {
//        }
//
//        public DummyEmployee(String name, Date hireDate) {
//            super(name, hireDate);
//        }
//
//        @Override
//        public double pay() {
//            return 0;
//        }
//
//        @Override
//        public double payTaxes() {
//            return 0;
//        }
//    }
}