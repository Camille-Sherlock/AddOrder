package com.thoughtworks.AddOrder.api;



import com.thoughtworks.AddOrder.domain.Order;
import com.thoughtworks.AddOrder.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class OrderController {
    private final OrderService orderService;
    private static final Integer OutOfAddOrderTime = 20;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity addOrder(Order order) throws InterruptedException, ExecutionException, TimeoutException {
        Integer newOrder = orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("goods",newOrder.toString())
                .body(null);
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }
}
