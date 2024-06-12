package com.javatunes.personnel;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
  private Employee emp1;
  private Employee emp2;
  @Before
  public void setUp() {
    emp1 = getEmployee();
    emp2 = getEmployee();
  }

  private static Employee getEmployee() {
    return new Employee("John", Date.valueOf("2001-01-01")) {
      public double pay() {return 0;}

      @Override
      public double payTaxes() {return 0;}
    };
  }

  @Test
  public void equals_shouldReturnFalse_differentName_sameHireDate() {
    emp2.setName("Mary");
    assertNotEquals(emp1, emp2);

  }

  @Test
  public void equal_ShouldReturnTrue_allPropertiesSame() {
    assertEquals(emp1, emp2); // does an .equals() check
  }

  @Test
  public void equals_shouldReturnFalse_sameName_differentHireDate() {
    emp2.setHireDate(Date.valueOf("2020-02-02"));
    assertNotEquals(emp1, emp2); // does a !.equals

  }
  //NAMED MEMBER-LEVEL INNER CLASSES
//  private class DummyEmployee extends Employee {
//
//    public DummyEmployee() {
//    }
//
//    public DummyEmployee(String name, Date hireDate) {
//      super(name, hireDate);
//    }
//
//    @Override
//    public double pay() {
//      return 0;
//    }
//
//    @Override
//    public double payTaxes() {
//      return 0;
//    }
//  }
}