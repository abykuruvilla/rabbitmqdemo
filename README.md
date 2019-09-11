# rabbitmqdemo
Demo Spring Boot RabbitMQ application 

To start Rabbit MQ in Docker

Run in root of application
docker-compose up

To run application run Application.main()

Output

***************************************
Checking and Publishing stock quote ...
2019-09-11 00:32:03.931  INFO 82493 --- [           main] y.quotes.query1v7.QuotesRequest          : Sending request: https://query1.finance.yahoo.com/v7/finance/quote?symbols=AAPL
*************************************************
Received Stock Quote -> AAPL: 216.7
*************************************************
