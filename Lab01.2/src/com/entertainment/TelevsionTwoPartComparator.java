package com.entertainment;

import java.util.Comparator;

class TelevsionTwoPartComparator implements Comparator<Television> {

  @Override
  public int compare(Television tv1, Television tv2) {
    int result = Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
    if(result == 0) {
      result = Double.compare(tv1.getVolume(),tv2.getVolume());
    }
    return result;
  }
}