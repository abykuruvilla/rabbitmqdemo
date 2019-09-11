package com.kaby.rabbitmqdemo.stockquotes;

/**
 *  Receiver that will respond to published stock quote messages
 *
 * Created by Aby Kuruvilla on 2019-09-10.
 */

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;


@Component
public class StockQuoteReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    public void receiveMessage(String message) {
        System.out.println("*************************************************");
        System.out.println("Received Stock Quote -> " + message);
        System.out.println("*************************************************");
        latch.countDown();
    }
}
