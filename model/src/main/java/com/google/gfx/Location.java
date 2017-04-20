package com.google.gfx;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Used to localise users and orders.
 */
@Entity
public class Location {

  @Id
  @GeneratedValue
  /**
   * Location unique identifier.
   */
  private long id;

  /**
   * Full name of the location.
   */
  private String name;

  public Location() {}

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
