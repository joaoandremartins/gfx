package com.google.gfx.model;

import java.util.Collection;

/**
 * Used to localise users and orders.
 */
public class Location {

  /**
   * Full name of the location.
   */
  private String name;

  /**
   * List of email addresses to email whenever there is a new order for that location.
   */
  private Collection<String> emailAddresses;

  public Location(String name, Collection<String> emailAddresses) {
    this.name = name;
    this.emailAddresses = emailAddresses;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<String> getEmailAddresses() {
    return emailAddresses;
  }

  public void setEmailAddresses(Collection<String> emailAddresses) {
    this.emailAddresses = emailAddresses;
  }
}
