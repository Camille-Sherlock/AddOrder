package com.thoughtworks.AddOrder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "order_price")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer price;
    private Integer number;
    private Integer unit;
    private String status;
}
