package it.example.queue.receiver;

import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/example/queue/client/queue-listener-context.xml" })
public class TestQueueReceiverSpring {

	// con l'inizializzazione del bean viene scodato un messaggio presente nella coda
	@Autowired
	private JmsMessageListener jmsMessageListener;

	@Autowired
	private ReceiverListener receiverListener;

	@Test
	public void testQueueReceiver() throws JMSException {
		System.out.println("SCODA!!!");
	}

	@Test
	public void testQueueReceiver2() throws JMSException {
		System.out.println("SCODA 2!!!");

		receiverListener.receiveMessage();

	}
}
