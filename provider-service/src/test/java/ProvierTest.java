import io.example.api.provider.ProviderServiceApp;
import io.example.pub.constant.IRabbitConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = ProviderServiceApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ProvierTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void test01() {
		rabbitTemplate.convertAndSend(IRabbitConstant.RabbitExchange.EMAIL_EXCHANGE, "email.send", "RabbitMQ");
	}
}
