/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.entertainment.Television;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class CatalogTest {


  @Test
  public void findByBrand_shouldReturnPopulatedMap_brandsPassed() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Not-Found");
    assertEquals(2, tvMap.size());
    Collection<Television> sonyTvs = tvMap.get("Sony");
    for (Television tv : sonyTvs) {
      assertEquals(7, sonyTvs.size());
      assertEquals("Sony", tv.getBrand());
    }

    Collection<Television> notFoundTvs = tvMap.get("Not-Found");
    assertTrue(notFoundTvs.isEmpty());


  }

  @Test
  public void findByBrands_shouldReturnEmptyMap_noBrandsPassed() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands();
    assertNotNull(tvMap);
    assertTrue(tvMap.isEmpty()); //map has a size method that equals the number of rows so size() == 0
  }

  @Test
  public void findByBrand_shouldReturnPopulatedCollection_brancFound() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertEquals(7, tvs.size());
    for (Television tv : tvs) {
      assertEquals("Sony", tv.getBrand());
    }
  }

  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void FindByBrand_shouldReturnEmptyCollection_brandNotFound() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }
}