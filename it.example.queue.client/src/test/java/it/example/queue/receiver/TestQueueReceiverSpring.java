package it.example.queue.receiver;

import javax.jms.JMSException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/example/queue/client/queue-listener-context.xml" })
public class TestQueueReceiverSpring {

	@Ignore
	@Test
	public void testQueueSender() throws JMSException {
		System.out.println("SCODA!!!");
	}
}
