package com.google.gfx;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * A match to an existing order, generated by a user responding to a buy/sell order or by an cron
 * task that matches existing orders periodically.
 */
public class Match {

  /**
   * Match unique identifier.
   */
  private long id;

  /**
   * The buy order being matched.
   */
  private Order buyOrder;

  /**
   * The sell order being matched.
   */
  private Order sellOrder;

  /**
   * The exchange rate that applied to the currency being bought results in the amount of the
   * currency being sold.
   */
  private BigDecimal fxRateBuyToSell;

  /**
   * The buyer's response. {@code true} if accepted, {@code false} is declined, or {@code null} if
   * non responded yet.
   */
  private Boolean buyerResponse;

  /**
   * The seller's response. {@code true} if accepted, {@code false} is declined, or {@code null} if
   * non responded yet.
   */
  private Boolean sellerResponse;

  /**
   * The time at which the buyer responded.
   */
  private LocalDateTime buyerResponseTime;

  /**
   * The time at which the seller responded.
   */
  private LocalDateTime sellerResponseTime;

  /**
   * The final transactioned amount as part of this trade.
   */
  private BigDecimal amount;

  /**
   * Time when match was created.
   */
  private LocalDateTime createdTime;

  /**
   * Time of the settlement, when both sides agree on the trade.
   */
  private LocalDateTime settlementTime;

  private Match(long id, Order buyOrder, Order sellOrder, BigDecimal fxRateBuyToSell,
                Boolean buyerResponse, LocalDateTime buyerResponseTime, Boolean sellerResponse,
                LocalDateTime sellerResponseTime, BigDecimal amount, LocalDateTime createdTime,
                LocalDateTime settlementTime) {
    this.id = id;
    this.buyOrder = buyOrder;
    this.sellOrder = sellOrder;
    this.fxRateBuyToSell = fxRateBuyToSell;
    this.buyerResponse = buyerResponse;
    this.buyerResponseTime = buyerResponseTime;
    this.sellerResponse = sellerResponse;
    this.sellerResponseTime = sellerResponseTime;
    this.amount = amount;
    this.createdTime = createdTime;
    this.settlementTime = settlementTime;
  }

  public void setBuyOrder(Order buyOrder) {
    if (buyOrder.getType() != Order.Type.BUY) {
      throw new IllegalArgumentException("Order type must buy.");
    }
    this.buyOrder = buyOrder;
  }

  public void setSellOrder(Order sellOrder) {
    if (sellOrder.getType() != Order.Type.SELL) {
      throw new IllegalArgumentException("Order type must sell.");
    }
    this.sellOrder = sellOrder;
  }

  public void setBuyerResponse(Boolean buyerResponse) {
    this.buyerResponse = buyerResponse;
    buyerResponseTime = LocalDateTime.now();
  }

  public void setSellerResponse(Boolean sellerResponse) {
    this.sellerResponse = sellerResponse;
    sellerResponseTime = LocalDateTime.now();
  }

  public void settle(BigDecimal fxRateBuyToSell) {
    this.fxRateBuyToSell = fxRateBuyToSell;
    settlementTime = LocalDateTime.now();
  }

  public long getId() {
    return id;
  }

  public Order getBuyOrder() {
    return buyOrder;
  }

  public Order getSellOrder() {
    return sellOrder;
  }

  public BigDecimal getFxRateBuyToSell() {
    return fxRateBuyToSell;
  }

  public boolean isBuyerAccepted() {
    return buyerResponse != null && buyerResponse;
  }

  public boolean isSellerAccepted() {
    return sellerResponse != null && sellerResponse;
  }

  public LocalDateTime getBuyerResponseTime() {
    return buyerResponseTime;
  }

  public LocalDateTime getSellerResponseTime() {
    return sellerResponseTime;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public LocalDateTime getCreatedTime() {
    return createdTime;
  }

  public static class Builder {

    private long id;
    private Order buyOrder;
    private Order sellOrder;
    private BigDecimal fxRateBuyToSell;
    private boolean buyerResponse;
    private LocalDateTime buyerResponseTime;
    private boolean sellerResponse;
    private LocalDateTime sellerResponseTime;
    private BigDecimal amount;
    private LocalDateTime createdTime;
    private LocalDateTime settlementTime;

    private Builder() {}

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder buyOrder(Order buyOrder) {
      this.buyOrder = buyOrder;
      return this;
    }

    public Builder sellOrder(Order sellOrder) {
      this.sellOrder = sellOrder;
      return this;
    }

    public Builder fxRateBuyToSell(BigDecimal fxRateBuyToSell) {
      this.fxRateBuyToSell = fxRateBuyToSell;
      return this;
    }

    public Builder buyerResponse(boolean buyerResponse) {
      this.buyerResponse = buyerResponse;
      return this;
    }

    public Builder buyerResponseTime(LocalDateTime buyerResponseTime) {
      this.buyerResponseTime = buyerResponseTime;
      return this;
    }

    public Builder sellerResponse(boolean sellerResponse) {
      this.sellerResponse = sellerResponse;
      return this;
    }

    public Builder sellerResponseTime(LocalDateTime sellerResponseTime) {
      this.sellerResponseTime = sellerResponseTime;
      return this;
    }

    public Builder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public Builder createdTime(LocalDateTime createdTime) {
      this.createdTime = createdTime;
      return this;
    }

    public Builder settlementTime(LocalDateTime settlementTime) {
      this.settlementTime = settlementTime;
      return this;
    }

    public Match build() {
      if (buyOrder == null && sellOrder == null) {
        throw new IllegalArgumentException("A buy or sell order must be specified");
      }
      if (buyOrder.getType() == Order.Type.SELL) {
        throw new IllegalArgumentException("Buy order type cannot be SELL.");
      }
      if (sellOrder.getType() == Order.Type.BUY) {
        throw new IllegalArgumentException("Sell order type cannot by BUY.");
      }
      createdTime = LocalDateTime.now();
      return new Match(id, buyOrder, sellOrder, fxRateBuyToSell, buyerResponse, buyerResponseTime,
          sellerResponse, sellerResponseTime, amount, createdTime, settlementTime);
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
