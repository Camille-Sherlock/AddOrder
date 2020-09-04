package com.thoughtworks.AddOrder.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.AddOrder.domain.Order;
import com.thoughtworks.AddOrder.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class OrderControllerTest {
    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void addGood() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = new Order();
        order.builder().name("可乐").number(1).price(1).status("add").unit(6);
        String request = objectMapper.writeValueAsString(order);

        mockMvc.perform(post("/addorder").content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        List<Order> orders = goodsRepository.findAll();
        assertEquals(1, orders.size());
    }

    @Test
    public void testSQL(){

    }
}