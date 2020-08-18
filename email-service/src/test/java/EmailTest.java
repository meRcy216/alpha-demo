import io.example.email_service.EmailServiceApp;
import io.example.email_service.email.send.SendMailService;
import io.example.pub.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = EmailServiceApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmailTest {

	@Autowired
	private SendMailService sendMailService;

	@Test
	public void test01() {
		Mail mail = new Mail("wuyuke163@163.com", "test", "unit test");
		sendMailService.sendMail(mail);
	}

}
