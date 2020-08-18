package io.example.api.provider.config;

import io.example.pub.constant.IRabbitConstant;
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
}
