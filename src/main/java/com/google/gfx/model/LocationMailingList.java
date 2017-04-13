package com.google.gfx.model;

/**
 * An email address that is notified for every new order.
 */
public class LocationMailingList {

  private String emailAddress;
  private Location location;

  public LocationMailingList(String emailAddress, Location location) {
    this.emailAddress = emailAddress;
    this.location = location;
  }
}
