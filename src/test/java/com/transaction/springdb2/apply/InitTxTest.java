package com.transaction.springdb2.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootTest
public class InitTxTest {

    @Autowired
    Hello hello;

    @Test
    void go() {
//        hello.initV1();
    }


    @TestConfiguration
    static class InitTxTestConfig {
        @Bean
        Hello hello() {
            return new Hello();
        }
    }


    static class Hello {

        @PostConstruct
        @Transactional
        public void initV1() {
            boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("hello init @Post tx active = {}", txActive);
        }

        @EventListener(ApplicationReadyEvent.class)
        @Transactional
        public void initV2() {
            boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("hello init @EventListener tx active = {}", txActive);
        }
    }
}
