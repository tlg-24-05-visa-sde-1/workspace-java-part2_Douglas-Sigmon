package com.entertainment;

import java.util.Objects;

public class Television implements Comparable<Television> {

  private final Tuner tuner = new Tuner();
  private String brand;
  private int volume;

  //ctor
  public Television() {

  }

  public Television(String brand, int volume) {
    setBrand(brand);
    setVolume(volume);
  }

  //dictated by brand
  @Override
  public int compareTo(Television tv) {
    int result = this.getBrand().compareTo(tv.getBrand());
    if(result == 0) {
      result = Integer.compare(this.getVolume(), tv.getVolume());
    }
    return result;

  }

  //business or action methods
  public int getCurrentChannel() {
    return tuner.getChannel();
  }

  public void changeChannel(int channel) {
    tuner.setChannel(channel);
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Television other = (Television) obj;
    return getVolume() == other.getVolume() &&
        Objects.equals(this.getBrand(), other.getBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBrand(), getVolume());
  }

  @Override
  public String toString() {
    return String.format("%s [brand=%s, volume=%d, channel=%d]",
        getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
  }

}