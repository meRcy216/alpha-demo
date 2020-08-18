package io.example.email_service.email.send;

import io.example.pub.domain.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendMailService {

	@Value("${mail.fromMail.sender}")
	private String sender;

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendMail(Mail mail) {
		/**
		 * 简单文本邮件	SimpleMailMessage
		 * MimeMessage message = javaMailSender.createMimeMessage();
		 * MimeMessageHelper helper = new MimeMessageHelper(message, true);
		 */
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(sender);
		simpleMailMessage.setTo(mail.getReceiver());
		simpleMailMessage.setSubject(mail.getTitle());
		simpleMailMessage.setText(mail.getContent());
		try {
			javaMailSender.send(simpleMailMessage);
			log.info("发送邮件成功。");
		} catch(Exception e) {
			log.info("发送邮件失败。");
			return "email failed";
		}
		return "email success";
	}
}
