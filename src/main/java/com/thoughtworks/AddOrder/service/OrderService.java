package com.thoughtworks.AddOrder.service;

import com.thoughtworks.AddOrder.domain.Order;
import com.thoughtworks.AddOrder.repository.GoodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final GoodsRepository goodsRepository;
    private Order saveOrder(Order order){
        return goodsRepository.save(order);
    }
    public OrderService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public Integer addOrder(Order order){
        Integer orderId = Integer.valueOf(order.getId());
        if(!goodsRepository.existsById(orderId)){
            goodsRepository.save(order);
        }
        Order result = goodsRepository.save(order);
        return result.getId();
    }

    public Optional<Order> getOrder(Order order){
        Optional<Order> goods = goodsRepository.findById(order.getId());
        return goods;
    }

    public List<Order> getAllOrders(){
        List<Order> allOrders = goodsRepository.findAll();
        return allOrders;
    }

}
