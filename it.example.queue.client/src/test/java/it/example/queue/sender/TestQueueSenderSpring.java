package it.example.queue.sender;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:it/example/queue/client/queue-sender-context.xml" })
public class TestQueueSenderSpring {

	@Autowired
	private JmsMessageSender jmsMessageSender;
	@Ignore
	@Test
	public void testQueueSender() throws JMSException {
		jmsMessageSender.sendAndReplyTo("ste response", "QueueResponse");
	}
	@Ignore
	@Test
	public void testQueueConvertAndSend() throws JMSException {
		jmsMessageSender.sendText("hello JMS");
	}
	@Ignore
	@Test
	public void testQueueSend() throws JMSException {
		Queue queue = new ActiveMQQueue("SAMPLEQUEUE");
		jmsMessageSender.send(queue, "hello Another Message", "Pippo");
	}
}
