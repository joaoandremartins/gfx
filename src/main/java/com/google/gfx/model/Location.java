package com.google.gfx.model;

/**
 * Used to localise users.
 */
public enum Location {
  NEW_YORK("New York"),
  MOUNTAIN_VIEW("Mountain View"),
  SAN_FRANCISCO("San Francisco"),
  SEATTLE("Seattle"),
  KIRKLAND("Kirkland"),
  LOS_ANGELES("Los Angeles"),
  BOULDER("Boulder"),
  CAMBRIDGE("Cambridge"),
  WATERLOO("Waterloo"),
  LISBON("Lisbon"),
  DUBLIN("Dublin"),
  LONDON("London"),
  MUNICH("Munich"),
  ZURICH("Zurich"),
  SYDNEY("Sydney"),
  SINGAPORE("Singapore");

  private String name;

  Location(String name) {
    this.name = name;
  }
}
