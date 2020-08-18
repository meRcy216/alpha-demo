package io.example.email_service.config;

import io.example.pub.constant.IRabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public TopicExchange initEmailExchange() {
		TopicExchange emailExchange = new TopicExchange(IRabbitConstant.RabbitExchange.EMAIL_EXCHANGE, true, false);

		return emailExchange;
	}

	@Bean
	public Queue initEmailSendQueue() {
		Queue emailSendQueue = new Queue(IRabbitConstant.RabbitQueue.EMAIL_SEND_QUEUE, true, false, false);
		return emailSendQueue;
	}

	@Bean
	public Binding bindEmailSendQueue2EmailExchange(TopicExchange initEmailExchange, Queue initEmailSendQueue) {

		return BindingBuilder.bind(initEmailSendQueue).to(initEmailExchange).with("email.send");
	}
}
