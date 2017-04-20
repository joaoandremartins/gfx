package com.google.gfx;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * A user of Google Foreign Exchange.
 */
@Entity
public class User {

  /**
   * User's email address, which is also their key.
   */
  @Id
  private String email;

  /**
   * User's name.
   */
  private String name;

  /**
   * Where the user is located.
   */
  @ManyToOne
  private Location location;

  public User() {}

  public User(String name, String email, Location location) {
    this.name = name;
    this.email = email;
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
