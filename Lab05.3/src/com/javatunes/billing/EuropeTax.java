/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * European orders are taxed as follows: VAT is 17% of taxable amount. Luxury tax is an additional
 * 25% on amount over $100.
 * <p>
 * TODO: implement this algorithm.
 */
public class EuropeTax implements TaxCalculator {
  public static final double VAT = 0.17;
  public static final double LUXUARY_TAX = 0.25;
  public static final double AMOUNT_BEFORE_LUXURY = 100.0;


  @Override
  public double taxAmount(double taxable) {
    double taxAmount = taxable * VAT;
    if (taxable > AMOUNT_BEFORE_LUXURY) {
      taxable -= AMOUNT_BEFORE_LUXURY;
      taxAmount += (taxable * LUXUARY_TAX);
    }
    return taxAmount;
  }
}