package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
public class HourlyEmployeeTest {

  private HourlyEmployee emp;

  @Before
  public void setUp() {
    emp = new HourlyEmployee("Amilia", Date.valueOf("2010-10-10"), 25.0, 35.0);
  }

  @Test
  public void testPay() {
    assertEquals(875.0, emp.pay(), 0.001);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(218.75, emp.payTaxes(), .001);
  }

  @Test
  public void getRate() {
  }

  @Test
  public void setRate() {
  }

  @Test
  public void getHours() {
  }

  @Test
  public void setHours() {
  }
}