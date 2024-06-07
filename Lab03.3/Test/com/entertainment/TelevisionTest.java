package com.entertainment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  private Television tv1;
  private Television tv2;

  @Before
  public void setUp() {
    tv1 = new Television("A");
    tv2 = new Television("A");
  }

  @Test(expected = InvalidChannelException.class)
  public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
      throws InvalidChannelException {
    tv1.changeChannel(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
    tv1.setVolume(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
    tv1.setVolume(101);
  }

  @Test
  public void setVolume_shouldStoreValue_validInput_lowerBound() {
    tv1.setVolume(0);
    assertEquals(0, tv1.getVolume());
  }

  @Test
  public void setVolume_shouldStoreValue_validInput_upperBound() {
    //100

  }

  @Test
  public void compareTo_ShouldReturnZero_whenSameBrand() {
    assertEquals(0, tv1.compareTo(tv2));
  }
}