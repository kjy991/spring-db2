package com.transaction.springdb2.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class OrderServiceTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @Test
    void complete() {


    }

}