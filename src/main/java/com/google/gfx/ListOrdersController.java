package com.google.gfx;

import com.google.gfx.model.Location;
import com.google.gfx.model.Order;
import com.google.gfx.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by joaomartins on 4/6/17.
 */
@RestController
public class ListOrdersController {

  @GetMapping(value = "/listBuyOrders")
  public List<Order> listBuyOrders() {
    List<Order> buyOrders = new ArrayList<>();
    buyOrders.add(new Order(1, Order.Type.BUY, new BigDecimal(100),
        Currency.getInstance("USD"), Currency.getInstance("SGD"), Order.Status.OPEN,
        LocalDateTime.now(), new User("Nelson Semedo", "nsemedo@google.com",
        new Location("New York")),false));
    buyOrders.add(new Order(4, Order.Type.BUY, new BigDecimal(30),
        Currency.getInstance("USD"), Currency.getInstance("SGD"), Order.Status.OPEN,
        LocalDateTime.now(), new User("Mitroglou", "mitroglou@google.com",
        new Location("Sydney")),false));

    return buyOrders;
  }

  @GetMapping(value = "/listSellOrders")
  public List<Order> listSellOrders() {
    List<Order> sellOrders = new ArrayList<>();
    sellOrders.add(new Order(2, Order.Type.SELL, new BigDecimal(101),
        Currency.getInstance("SGD"), Currency.getInstance("USD"), Order.Status.OPEN,
        LocalDateTime.now(), new User("Ederson", "ederson@google.com",
        new Location("Seoul")),true));
    sellOrders.add(new Order(3, Order.Type.SELL, new BigDecimal(400),
        Currency.getInstance("MXN"), Currency.getInstance("EUR"), Order.Status.OPEN,
        LocalDateTime.now(), new User("Luisao", "luisao@google.com",
        new Location("Lisbon")),true));

    return sellOrders;
  }
}
