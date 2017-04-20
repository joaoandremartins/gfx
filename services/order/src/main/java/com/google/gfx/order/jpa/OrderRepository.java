package com.google.gfx.order.jpa;

import com.google.gfx.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by joaomartins on 4/18/17.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

  @Query("select o from Order o")
  Stream<Order> streamAllOrders();

  List<Order> findByType(Order.Type type);
}
