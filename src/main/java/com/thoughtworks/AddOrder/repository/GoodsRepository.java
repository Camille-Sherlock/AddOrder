package com.thoughtworks.AddOrder.repository;


import com.thoughtworks.AddOrder.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface GoodsRepository extends CrudRepository<Order, Integer> {
List<Order> findAll();
}