import io.example.api.consumer.ConsumerService;
import io.example.api.consumer.ConsumerServiceApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = ConsumerServiceApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ConsumerTest {

	@Autowired
	private ConsumerService consumerService;

	@Test
	public void test01() {
		System.out.println(consumerService.getService());
	}

}
