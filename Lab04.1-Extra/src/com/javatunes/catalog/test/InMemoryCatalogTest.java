/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;
import java.util.Collection;

class InMemoryCatalogTest {

  /*
   * One by one, complete each test method below, and then "activate" it by
   * uncommenting the call to that method in main().
   *
   * Once you see that the test method verifies the corresponding business method
   * works correctly, you can comment out that call in main() and proceed to the next one.
   */
  public static void main(String[] args) {
//    testFindById();
//     testFindByKeyword();
//     testFindByCategory();
     testSize();
    // testGetAll();
  }

  private static void testSize() {
    InMemoryCatalog catalog = new InMemoryCatalog();
    catalog.size();
    System.out.println(catalog.size());
  }

//  private static void testFindById() {
//    InMemoryCatalog catalog = new InMemoryCatalog();
//    MusicItem found = catalog.findById(6L);
//    System.out.println(found);
//    MusicItem notFound = catalog.findById(20L);
//    System.out.println(notFound);
//  }

    private static void testFindByKeyword() {
    InMemoryCatalog catalog = new InMemoryCatalog();
    Collection<MusicItem> keyWordItems = catalog.findByKeyword("SeaL");
    dump(keyWordItems);
    }

//
    private static void testFindByCategory() {
      InMemoryCatalog catalog = new InMemoryCatalog();
      Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
      dump(popItems);
      Collection<MusicItem> jazzItems = catalog.findByCategory(MusicCategory.JAZZ);
      dump(jazzItems);
    }
//
//    private static void testSize() {
//    }
//
//    private static void testGetAll() {
//    }
      private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
          System.out.println(item);
        }
      }

}