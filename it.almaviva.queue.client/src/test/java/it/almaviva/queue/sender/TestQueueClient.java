package it.almaviva.queue.sender;

import it.almaviva.queue.receiver.ReceiverListener;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/almaviva/queue/client/queue-client-context.xml" })
public class TestQueueClient {
	@Ignore
	@Test
	public void testQueueSender() {
		Sender sender = new Sender();
		sender.sendMessage();
	}
	@Ignore
	@Test
	public void testQueueReciver() {
		ReceiverListener receiver = new ReceiverListener();
		receiver.receiveMessage();
	}
}
