package com.google.gfx;

/**
 * A user of Google Foreign Exchange.
 */
public class User {

  /**
   * User's email address, which is also their key.
   */
  private String email;

  /**
   * User's name.
   */
  private String name;

  /**
   * Where the user is located.
   */
  private Location location;

  public User(String name, String email, Location location) {
    this.name = name;
    this.email = email;
    this.location = location;
  }
}
