package com.kaby.rabbitmqdemo.stockquotes;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Created by abykuruvilla on 2019-09-10.
 */
@Component
public class StockQuoteGeneratorAndSender implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final StockQuoteReceiver receiver;

    public StockQuoteGeneratorAndSender(RabbitTemplate rabbitTemplate, StockQuoteReceiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    /**
     * Gets the stock price and sends to the stock-quote-queue
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************************************");
        System.out.println("Checking and Publishing stock quote ...");
        Stock stock = YahooFinance.get("AAPL");

        rabbitTemplate.convertAndSend(Application.topicExchangeName, "stock.quote.AAPL", stock.toString());
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);

    }
}
