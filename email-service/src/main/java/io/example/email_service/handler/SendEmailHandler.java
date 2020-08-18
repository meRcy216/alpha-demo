package io.example.email_service.handler;

import io.example.email_service.email.send.SendMailService;
import io.example.pub.constant.IRabbitConstant;
import io.example.pub.domain.Mail;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = IRabbitConstant.RabbitQueue.EMAIL_SEND_QUEUE)
public class SendEmailHandler {

	@Autowired
	private SendMailService sendMailService;

	@RabbitHandler
	public void process(Mail mail) {
		sendMailService.sendMail(mail);
	}
}
