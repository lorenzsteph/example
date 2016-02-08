package it.example.queue.autowired;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/example/queue/client/autowired-test-context.xml" })
public class TestAutowired {

	@Autowired
	private Customer c;
	
	@Test
	public void testQueueSender() {
		boolean result = c.customerLiveInCity();
		System.out.println("Correct Autowired? " + result);
	}

}
