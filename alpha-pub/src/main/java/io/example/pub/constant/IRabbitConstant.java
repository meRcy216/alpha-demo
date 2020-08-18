package io.example.pub.constant;

public interface IRabbitConstant {

	public static interface RabbitExchange {
		static final String EMAIL_EXCHANGE = "email-exchange";
	}

	public static interface RabbitQueue {
		static final String EMAIL_SEND_QUEUE = "email-send-queue";
	}
}
