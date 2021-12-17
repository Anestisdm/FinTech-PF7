package gr.codelearn.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AMQPConfiguration {
    public static final String exchangeName = "payment.exchange";
    public static final String queueName = "payment.queue";
    public static final String routingKey = "payment";
    public static final String walletQueue = "wallet.queue";
    public static final String walletRoutingKey = "wallet";
    @Bean
    DirectExchange paymentExchange() {
        // Durable means that the exchange will not be removed when RabbitMQ is stopped.
        // Auto-delete means that the exchange will be deleted when the last consumer has disconnected from it
        return new DirectExchange(exchangeName, true, false);
    }

    @Bean
    protected Queue paymentQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    protected Queue walletQueue() {
        return new Queue(walletQueue, true);
    }

    @Bean
    Binding paymentDirectBinding(DirectExchange exchange, Queue paymentQueue) {
        return BindingBuilder.bind(paymentQueue).to(exchange).with(routingKey);
    }
    @Bean
    Binding walletDirectBinding(DirectExchange exchange, Queue walletQueue) {
        return BindingBuilder.bind(walletQueue).to(exchange).with(walletRoutingKey);
    }
}
