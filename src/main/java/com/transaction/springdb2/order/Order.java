package com.transaction.springdb2.order;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "orders")
@RequiredArgsConstructor
@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String payStatus;
}
