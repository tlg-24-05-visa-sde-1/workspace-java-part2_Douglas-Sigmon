package com.javatunes.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class InMemoryCatalogTest {

  InMemoryCatalog catalog;

  @Before
  public void setUp() {
    catalog = new InMemoryCatalog();
  }


  @Test
  public void findByCategory_shouldReturnPopulateCollection_categoryFound() {
    Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);

    assertEquals(4, popItems.size());

    for (MusicItem item : popItems) {
      assertEquals(MusicCategory.POP, item.getMusicCategory());
    }
  }

  @Test
  public void findByCategory_shouldReturnPopulateCollection_categoryNotFound() {
    Collection<MusicItem> jazzItems = catalog.findByCategory(MusicCategory.JAZZ);

    assertNotNull(jazzItems);
  }

  @Test
  public void findById_shouldReturnMusicItem_idFound() {
    MusicItem item = catalog.findById(6L);

    assertNotNull(item);

    assertEquals(6L, item.getId().longValue());
  }

  @Test
  public void findById_shouldReturnMusicItem_idNotFound() {
    MusicItem item = catalog.findById(101L);
    assertNull(item);
  }

  @Test
  public void findAlbumsThatEqualNames() {
    Collection<MusicItem> items = catalog.findAlbumsThatEqualNames();
    assertEquals(2, items.size());

    for (MusicItem item : items) {
      assertEquals(item.getTitle(), item.getArtist());
    }
  }

  @Test
  public void cheapRock() {
    Collection<MusicItem> items = catalog.cheapRock(12.0);
    assertEquals(2, items.size());
    for (MusicItem item : items) {
      assertTrue(item.getPrice() < 12.0);
    }
  }

  /**
   * TASK: how many items of the specified genre (MusicCategory) do we sell?
   */
  @Test
  public void genreCount() {
    int count = catalog.genreCount(MusicCategory.POP);
    assertEquals(4, count);
    count = catalog.genreCount(MusicCategory.JAZZ);
    assertEquals(0, count);
    count = catalog.genreCount(MusicCategory.CLASSIC_ROCK);
    assertEquals(1, count);
  }

  @Test
  public void avgPrice() {
    double avgPrice = catalog.avgPrice();
    assertEquals(15.308, avgPrice, 0.001);
  }

//  /**
//   * TASK: find the cheapest item with the specified genre (MusicCategory).
//   */
//  @Test
//  public void isAllCheap() {
//    MusicItem item = catalog.cheapestInGenre(MusicCategory.POP);
//    assertEquals(1L, item.getId().longValue());
//  }


  /**
   * TASK: find the average price of items in the specified genre (MusicCategory).
   */
  @Test
  public void genreAvgPrice() {
    double avgPrice = catalog.genreAvgPrice(MusicCategory.POP);
    assertEquals(16.23, avgPrice, 0.001);
  }

  @Test
  public void cheaperThan10() {
    boolean cheaperThan10 = catalog.cheaperThan10();
    assertFalse(cheaperThan10);
  }

  /**
   * TASK: do we sell any items with the specified genre (MusicCategory)? Another yes/no answer.
   */
  @Test
  public void doWeSellCategory() {
    boolean doWe = catalog.doWeSellCategory(MusicCategory.JAZZ);
    assertFalse(doWe);
  }

  @Test
  public void popItemsSorted() {
    List<String> popTitlesSorted = catalog.popItemsSorted();
    assertEquals(4, popTitlesSorted.size());
    assertEquals("Diva", popTitlesSorted.get(0));
    assertEquals("Dream of the Blue Turtles", popTitlesSorted.get(1));
    assertEquals("Seal", popTitlesSorted.get(2));
    assertEquals("So", popTitlesSorted.get(3));
  }

  @Test
  public void releaseIn80atPrice() {
    List<MusicItem> musicItems = catalog.releaseIn80atPrice(11.97);
    for(MusicItem item : musicItems) {
      assertEquals(11.97, item.getPrice(), 0.001);
      assertTrue(item.getReleaseDate().toLocalDate().getYear() > 1979 &&
          item.getReleaseDate().toLocalDate().getYear() < 1990);
    }
  }

  @Test
  public void sortByCategory() {
  }
}