package com.google.gfx.web;

import com.google.gfx.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by joaomartins on 4/6/17.
 */
@RestController
public class ListOrdersController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping(value = "/listBuyOrders")
  public List<Order> listBuyOrders() {
    return restTemplate.exchange("http://order-service/listBuyOrders", HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Order>>(){}).getBody();
  }

  @GetMapping(value = "/listSellOrders")
  public List<Order> listSellOrders() {
    return restTemplate.exchange("http://order-service/listSellOrders", HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Order>>(){}).getBody();
  }
}
