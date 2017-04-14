package com.google.gfx.order.impl;

import com.google.gfx.Order;
import com.google.gfx.User;
import com.google.gfx.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Created by joaomartins on 4/14/17.
 */
public class OrderServiceImpl implements OrderService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public void storeOrder(Order order) {

  }

  @Override
  public void deleteOrder(Order order) {

  }

  @Override
  public void closeOrder(Order order) {

  }

  @Override
  public List<Order> listAllOrders() {
    return null;
  }

  @Override
  public List<Order> listAllSellOrders() {
    return null;
  }

  @Override
  public List<Order> listAllBuyOrders() {
    return null;
  }

  @Override
  public List<Order> listSellOrdersForUser(User user) {
    return null;
  }

  @Override
  public List<Order> listBuyOrdersForUser(User user) {
    return null;
  }

  @Override
  public List<Order> listBuyOrdersByAmount(BigDecimal amount, Currency currency, int numOrders) {
    return null;
  }

  @Override
  public List<Order> listSellOrdersLowerByAmount(BigDecimal amount, Currency currency, int numOrders) {
    return null;
  }
}
