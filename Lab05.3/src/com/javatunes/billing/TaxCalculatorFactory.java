package com.javatunes.billing;

public class TaxCalculatorFactory {

  public static TaxCalculator getTaxCalculator(Location location) {
    TaxCalculator calc = switch (location) {
      case ONLINE -> new OnlineTax();
      case USA -> new USATax();
      case EUROPE -> new EuropeTax();
    };
    return calc;
  }
}