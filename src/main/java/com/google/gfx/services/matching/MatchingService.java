package com.google.gfx.services.matching;

import com.google.gfx.model.Match;
import com.google.gfx.model.Order;
import com.google.gfx.model.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Matches existing orders with other existing or new ones.
 */
public interface MatchingService {

  /**
   * This method was conceived to be ran as part of a cron job that matches existing buy and sell
   * orders.
   */
  void matchExistingBuyAndSellOrders();

  /**
   * Tries to match a created order with another existing order.
   *
   * <p>If the given order is a buy order, it will be matched with sell orders, and vice-versa.
   * Querying the existing orders is left to the method.
   *
   * @return zero matches if no matching offers exist, one match if an order for the same amount
   * exists or multiple matches if multiple orders sum up to the amount of the created order
   */
  List<Match> tryMatchOrder(Order newOrder);

  /**
   * Matches an existing buy and sell order.
   *
   * <p>Useful in the case where a user files, for example, a buy order, and there are existing sell
   * orders that can fulfill it.
   *
   * @return the created match, which should be subject to buyer and/or seller approval
   */
  Match matchOrder(Order buyOrder, Order sellOrder);

  /**
   * Creates a match for an order, that must be accepted by the order owner.
   *
   * <p>Useful in the case where a user finds an order they are interested in and match it fully or
   * partially, without explicitly creating a new order.
   *
   * @param order original posted order
   * @param matchingUser the user who responded to the match
   * @param amount amount of the match, which can fully or partially match the original order
   * @return the created match, which should be subject to buyer or seller approval
   */
  Match matchOrder(Order order, User matchingUser, BigDecimal amount);

  /**
   * Accepts a proposed match.
   *
   * @param match proposed match
   * @param deciderType BUY if the user deciding is the buyer, or SELL if they are the seller
   */
  void acceptMatch(Match match, Order.Type deciderType);

  /**
   * Declines a proposed match.
   *
   * @param match proposed match
   * @param deciderType BUY if the user deciding is the buyer, or SELL if they are the seller
   */
  void declineMatch(Match match, Order.Type deciderType);
}
