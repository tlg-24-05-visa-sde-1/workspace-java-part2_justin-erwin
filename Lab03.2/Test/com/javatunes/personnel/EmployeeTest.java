package com.javatunes.personnel;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

public class EmployeeTest {
    private Employee emp1;  //we need 2 Employee objects to compare in order to check equals()
    private Employee emp2;
    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("John", Date.valueOf("2000-01-01"));
        emp2 = new SalariedEmployee("John", Date.valueOf("2000-01-01"));
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Mary");  //change name of emp2 to check
        assertNotEquals(emp1,emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2020-02-02"));  //change hireDate of emp2 to check
        assertNotEquals(emp1,emp2); //this does a .equals() check
        assertFalse(emp1.equals(emp2)); //alternative assertion calling .equals() ourselves
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {  //method name_shouldDoThis_whenThis
        assertEquals(emp1, emp2);  //this does a .equals() check
        assertTrue(emp1.equals(emp2));  //alternative assertion
    }
}