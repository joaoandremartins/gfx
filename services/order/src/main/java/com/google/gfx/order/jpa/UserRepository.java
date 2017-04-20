package com.google.gfx.order.jpa;

import com.google.gfx.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by joaomartins on 4/19/17.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
