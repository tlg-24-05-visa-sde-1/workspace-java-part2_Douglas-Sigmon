/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }

  /**
   * Given the input map, create and return the correct object (with its properties set). If the
   * input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable
   * message.
   */
  public static Employee createEmployee(Map<String, String> inputMap)
      throws IllegalArgumentException {

    String type = inputMap.get("type");
    if (!"HE".equals(type) && !"SE".equals(type)) {
      throw new IllegalArgumentException("Invalid employee type " + type + ". " +
          "Valid types are HE, SE");
    }
    // return value

    Employee emp = null;

    String name = inputMap.get("name");
    Date date = Date.valueOf(inputMap.get("hireDate"));
    Double rate = null;
    Double hours = null;
    Double salary = null;

    //FIRST, extract the 'indicator' form the Map, i.e., "HE" or "SE"
    if ("HE".equals(type)) {
      rate = Double.valueOf(inputMap.get("rate"));
      hours = Double.valueOf(inputMap.get("hours"));
      emp = new HourlyEmployee(name, date, rate, hours);
    } else if ("SE".equals(type)) {
      salary = Double.valueOf(inputMap.get("salary"));
      emp = new SalariedEmployee(name, date, salary);
    }
    return emp;
  }
}