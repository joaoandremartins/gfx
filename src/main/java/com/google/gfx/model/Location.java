package com.google.gfx.model;

/**
 * Used to localise users and orders.
 */
public class Location {

  /**
   * Full name of the location.
   */
  private String name;

  public Location(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
