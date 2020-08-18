package io.example.api.provider.service;


import io.example.api.provider.ProviderService;
import io.example.pub.constant.IRabbitConstant;
import io.example.pub.domain.Mail;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public String getService() {
		Mail mail = new Mail("wuyuke163@163.com", "邮箱服务", "默认邮件通知");
		rabbitTemplate.convertAndSend(IRabbitConstant.RabbitExchange.EMAIL_EXCHANGE, "email.send", mail);
		return "success";
	}
}
