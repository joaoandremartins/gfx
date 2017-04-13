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
   * Currency being traded for.
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

  public void close() {
    status = Status.CLOSED;
  }

  public long getId() {
    return id;
  }

  public Type getType() {
    return type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Currency getFromCurrency() {
    return fromCurrency;
  }

  public Currency getToCurrency() {
    return toCurrency;
  }

  public Status getStatus() {
    return status;
  }

  public LocalDateTime getCreatedTime() {
    return createdTime;
  }

  public User getUser() {
    return user;
  }

  public boolean isAcceptFractional() {
    return acceptFractional;
  }

  public static class Builder {
    private long id;
    private Type type;
    private BigDecimal amount;
    private Currency fromCurrency;
    private Currency toCurrency;
    private Status status = Status.OPEN;
    private LocalDateTime createdTime;
    private User user;
    private boolean acceptFractional;

    private Builder() {}

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder type(Type type) {
      this.type = type;
      return this;
    }

    public Builder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public Builder fromCurrency(Currency fromCurrency) {
      this.fromCurrency = fromCurrency;
      return this;
    }

    public Builder toCurrency(Currency toCurrency) {
      this.toCurrency = toCurrency;
      return this;
    }

    public Builder status(Status status) {
      this.status = status;
      return this;
    }

    public Builder user(User user) {
      this.user = user;
      return this;
    }

    public Builder acceptFractional(boolean acceptFractional) {
      this.acceptFractional = acceptFractional;
      return this;
    }

    public Order build() {
      if (type == null) {
        throw new IllegalArgumentException("An order type must be provided.");
      }
      if (amount == null) {
        throw new IllegalArgumentException("An amount must be provided.");
      }
      if (fromCurrency == null) {
        throw new IllegalArgumentException("A buy or sell currency must be provided.");
      }
      if (toCurrency == null) {
        throw new IllegalArgumentException("A target currency must be provided");
      }
      if (user == null) {
        throw new IllegalArgumentException("A user must be provided.");
      }
      createdTime = LocalDateTime.now();
      return new Order(id, type, amount, fromCurrency, toCurrency, status, createdTime, user,
          acceptFractional);
    }
  }

  public static Builder newBuilder() {
    return new Builder();
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
