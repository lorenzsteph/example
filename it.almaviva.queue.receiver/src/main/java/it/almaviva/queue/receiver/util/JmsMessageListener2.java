package it.almaviva.queue.receiver.util;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener2 implements MessageListener {

	@Autowired
	private JmsMessageReplyTo jmsMessageReplyTo;

	public void onMessage(Message message) {
		System.out.println("queueDestination2");
		if (message instanceof TextMessage) {
			try {
				System.out.println(((TextMessage) message).getText());
				replyTo(message);
			} catch (JMSException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			throw new IllegalArgumentException("Message must be of type TextMessage");
		}
	}

	private void replyTo(Message message) throws JMSException {
		System.out.println("replyTo queue : " + message.getJMSReplyTo());
		jmsMessageReplyTo.send(message.getJMSReplyTo(), "reply to queue");

	}

}
