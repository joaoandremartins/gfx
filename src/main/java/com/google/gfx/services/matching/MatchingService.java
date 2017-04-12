package com.google.gfx.services.matching;

import com.google.gfx.model.Match;
import com.google.gfx.model.Order;

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
   * Creates a match for an order, that must be accepted by the order owner.
   *
   * @param order original posted order
   * @param amount amount of the match, which might fully or partially match the original order
   */
  void matchOrder(Order order, float amount);

  /**
   * Accepts a proposed match.
   *
   * @param match proposed match
   */
  void acceptMatch(Match match);

  /**
   * Declines a proposed match.
   *
   * @param match proposed match
   */
  void declineMatch(Match match);
}
