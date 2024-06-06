package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {

  SalariedEmployee salariedEmployee;

  @Before
  public void setUp() {
    salariedEmployee = new SalariedEmployee("Douglas", Date.valueOf("2020-02-02"), 1250.0);
  }

  @Test
  public void testPay() {
    assertEquals( 1250.0, salariedEmployee.pay(), .001);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(375, salariedEmployee.payTaxes(), .001);
  }

  @Test
  public void getSalary() {
  }

  @Test
  public void setSalary() {
  }
}