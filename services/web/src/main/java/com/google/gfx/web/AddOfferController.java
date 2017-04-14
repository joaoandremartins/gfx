package com.google.gfx.web;

import com.google.gfx.Location;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Currency;

/**
 * Created by joaomartins on 4/6/17.
 */
@RestController
public class AddOfferController {

  @PostMapping(value = "/addOffer")
  public void addOffer(
      @RequestParam("wantedAmount") String wantedAmount,
      @RequestParam("wantedCurrency") Currency wantedCurrency,
      @RequestParam("offeredAmount") Integer offeredAmount,
      @RequestParam("offeredCurrency") Currency offeredCurrency,
      @RequestParam("location") Location location,
      HttpServletResponse response) throws IOException {
//    Order order = new Order(Integer.parseInt(wantedAmount), wantedCurrency, offeredAmount,
//        offeredCurrency);
    response.sendRedirect("/");
  }
}
