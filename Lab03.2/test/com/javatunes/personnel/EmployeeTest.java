package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
  private Employee emp;
  private Employee emp2;
  @Before
  public void setUp() {
    emp = new SalariedEmployee("John", Date.valueOf("2000-01-01"));
    emp2 = new SalariedEmployee("John", Date.valueOf("2000-01-01"));

  }

  @Test
  public void equals_shouldReturnFalse_differentName_sameHireDate() {
    emp2.setName("Mary");
    assertNotEquals(emp, emp2);

  }

  @Test
  public void equal_ShouldReturnTrue_allPropertiesSame() {
    assertEquals(emp, emp2); // does an .equals() check
  }

  @Test
  public void equals_shouldReturnFalse_sameName_differentHireDate() {
    emp2.setHireDate(Date.valueOf("2020-02-02"));
    assertNotEquals(emp, emp2); // does a !.equals

  }
}