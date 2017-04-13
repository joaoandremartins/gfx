package com.google.gfx.services.order;

import com.google.gfx.model.Order;
import com.google.gfx.model.User;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Manages the orders in the system.
 */
public interface OrderService {

  /**
   * Stores an order.
   */
  void storeOrder(Order order);

  /**
   * Deletes an existing order.
   */
  void deleteOrder(Order order);

  /**
   * Closes an order after it is fulfilled.
   *
   * <p>The order should not be deleted as part of this operation.
   */
  void closeOrder(Order order);

  /**
   * Lists all existing orders.
   */
  // TODO(joaomartins): Implement pagination.
  List<Order> listAllOrders();

  // TODO(joaomartins): Implement pagination.
  List<Order> listAllSellOrders();

  // TODO(joaomartins): Implement pagination.
  List<Order> listAllBuyOrders();

  // TODO(joaomartins): Implement pagination.
  List<Order> listSellOrdersForUser(User user);

  // TODO(joaomartins): Implement pagination.
  List<Order> listBuyOrdersForUser(User user);

  /**
   * Lists a number of buy orders by their amount.
   *
   * <p>This operation is useful to search similar orders to the one a user is just filing. For
   * example, if a user wants to sell 20 USD, they will be presented with buy orders of value
   * 20 USD, or the closest value, up or down, until {@code numOrders} results are obtained. If
   * there are less than {@code numOrders} on the system, for the given {@code amount} and
   * {@code currency}, all existing orders are listed.
   *
   * @param amount base amount around which to search
   * @param currency currency being bought
   * @param numOrders number of orders to be returned
   * @return open {@code numOrders} buy orders with value closest to {@code amount} of
   * {@code currency}
   */
  // TODO(joaomartins): Implement pagination.
  List<Order> listBuyOrdersByAmount(BigDecimal amount, Currency currency, int numOrders);

  /**
   * Lists a number of sell orders by their amount.
   *
   *
   * <p>This operation is useful to search similar orders to the one a user is just filing. For
   * example, if a user wants to buy 20 USD, they will be presented with sell orders of value
   * 20 USD, or the closest value, up or down, to a limit of {@code numOrders}. If there are less
   * than {@code numOrders} on the system, for the given {@code amount} and {@code currency}, all
   * existing orders are listed.
   *
   * @param amount base order amount to search for
   * @param currency currency being sold
   * @param numOrders number of orders to be returned
   * @return open {@code numOrders} sell orders with value closest to {@code amount} of
   * {@code currency}
   */
  // TODO(joaomartins): Implement pagination.
  List<Order> listSellOrdersLowerByAmount(BigDecimal amount, Currency currency, int numOrders);
}
