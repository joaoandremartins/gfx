package com.google.gfx.web;

import com.google.gfx.Location;
import com.google.gfx.Order;
import com.google.gfx.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by joaomartins on 4/6/17.
 */
@RestController
public class AddOrderController {

  @Autowired
  @LoadBalanced
  private RestTemplate restTemplate;

  @PostMapping(value = "/addOrder")
  public void addOffer(
      @RequestParam("type") String typeParam,
      @RequestParam("amount") BigDecimal amount,
      @RequestParam("fromCurrency") String fromCurrency,
      @RequestParam("toCurrency") String toCurrency,
      @RequestParam("location") String location,
      @RequestParam(value = "acceptsFractional", required = false) boolean acceptFractional)
      throws IOException {
    // TODO(joaomartins): Consider case where valueOf fails.
    Order.Type type;
    if ("buy".equalsIgnoreCase(typeParam)) {
      type = Order.Type.BUY;
    } else if ("sell".equalsIgnoreCase(typeParam)) {
      type = Order.Type.SELL;
    } else {
      // TODO(joaomartins): Blow up.
      throw new RuntimeException("Order type is invalid");
    }

    Order order = Order.newBuilder()
        .user(new User("Joao", "joaomartins@google.com",
            new Location("New York")))
        .type(type)
        .amount(amount)
        .fromCurrency(Currency.getInstance(fromCurrency))
        .toCurrency(Currency.getInstance(toCurrency))
        .acceptFractional(acceptFractional)
        .build();

    restTemplate.postForObject("http://order-service/addOrder", order, Order.class);
  }
}
