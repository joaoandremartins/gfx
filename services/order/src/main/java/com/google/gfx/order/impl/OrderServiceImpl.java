package com.google.gfx.order.impl;

import com.google.gfx.Order;
import com.google.gfx.User;
import com.google.gfx.order.OrderService;
import com.google.gfx.order.jpa.LocationRepository;
import com.google.gfx.order.jpa.OrderRepository;
import com.google.gfx.order.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Currency;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by joaomartins on 4/14/17.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@EntityScan("com.google.gfx")
@EnableJpaRepositories(basePackageClasses = OrderRepository.class)
@PropertySource(value={"classpath:application.properties"})
public class OrderServiceImpl implements OrderService {
  Logger logger = Logger.getGlobal();

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private LocationRepository locationRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public static void main(String[] args) throws SQLException {
    System.setProperty("spring.config.name", "orders-server");

    SpringApplication.run(OrderServiceImpl.class, args);
  }

  @Override
  @PostMapping(value = "/addOrder")
  public void storeOrder(
      @RequestBody Order order) {
    orderRepository.save(order);
    logger.info("Order saved.");
  }

  @Override
  public void deleteOrder(Order order) {

  }

  @Override
  public void closeOrder(Order order) {

  }

  @Override
  @GetMapping("/listOrders")
  @Transactional
  public List<Order> listAllOrders() {
    return orderRepository.streamAllOrders().collect(Collectors.toList());
  }

  @Override
  @GetMapping("/listSellOrders")
  public List<Order> listAllSellOrders() {
    return orderRepository.findByType(Order.Type.SELL);
  }

  @Override
  @GetMapping("listBuyOrders")
  public List<Order> listAllBuyOrders() {
    return orderRepository.findByType(Order.Type.BUY);
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
