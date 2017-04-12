package com.google.gfx.model;

import java.time.LocalDateTime;
import java.util.Currency;

/**
 * A currency exchange order request to either buy or sell currency.
 */
public class Order {

  /**
   * Order unique identification.
   */
  private long id;

  /**
   * Order type: buy or sell.
   */
  private Type type;

  /**
   * Amount of currency for exchange.
   */
  private float amount;

  /**
   * Currency being bought or sold.
   */
  private Currency currency;

  /**
   * Currency being sought.
   */
  private Currency targetCurrency;

  /**
   * Order status: open or closed.
   */
  private Status status;

  /**
   * Date and time at which the order was created.
   */
  private LocalDateTime createdTime;

  /**
   * User who filed the request.
   */
  private User user;

  /**
   * Whether the user accepts the order to be fulfilled by multiple matches or only a single one.
   */
  private boolean acceptFractional;

  public Order(long id, Type type, float amount, Currency currency, Currency targetCurrency,
               Status status, LocalDateTime createdTime, User user, boolean acceptFractional) {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.currency = currency;
    this.targetCurrency = targetCurrency;
    this.status = status;
    this.createdTime = createdTime;
    this.user = user;
    this.acceptFractional = acceptFractional;
  }

  public enum Type {
    BUY,
    SELL
  }

  public enum Status {
    OPEN,
    CLOSED
  }
}
