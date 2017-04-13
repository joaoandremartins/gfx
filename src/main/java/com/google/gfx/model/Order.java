package com.google.gfx.model;

import java.math.BigDecimal;
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
  private BigDecimal amount;

  /**
   * Currency being bought or sold.
   */
  private Currency fromCurrency;

  /**
   * Currency being sought.
   */
  private Currency toCurrency;

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

  public Order(long id, Type type, BigDecimal amount, Currency fromCurrency, Currency toCurrency,
               Status status, LocalDateTime createdTime, User user, boolean acceptFractional) {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.fromCurrency = fromCurrency;
    this.toCurrency = toCurrency;
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
