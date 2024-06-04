package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class DuckRacer {
  private int id;
  private String name;
  private Collection<Reward> rewards = new ArrayList<>();

  //ctor
  public DuckRacer(int id, String name) {
    this.id = id;
    setName(name);
  }

  //business or action methods
  public void win(Reward reward) {
    rewards.add(reward);
  }

  //accessor methods
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getwins() {
    return rewards.size();
  }

  //Note: currently we are returning a direct reference to this collection
  // this.rewards = rewards; WRONG
  public Collection<Reward> getRewards(){
    return Collections.unmodifiableCollection(rewards); //returns read only view
  }

  @Override
  public String toString() {
    return String.format("%s: id=%d, name=%s, wins=%d, rewards=%s",
        getClass().getSimpleName(),getId(), getName(), getwins(), getRewards());
  }

}