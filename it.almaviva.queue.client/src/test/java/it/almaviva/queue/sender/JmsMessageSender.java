package it.almaviva.queue.sender;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendAndReplyTo(final String text, final String queueReplyTo) {

		this.jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				
				// set ReplyTo header of Message, pretty much like the concept of email.
				message.setJMSReplyTo(new ActiveMQQueue(queueReplyTo));
				message.setJMSCorrelationID("001");

				return message;
			}
		});
	}

	public void sendText(final String text) {
		this.jmsTemplate.convertAndSend(text);
	}

	public void send(final Destination dest, final String text, final String destReplyTo) {

		this.jmsTemplate.send(dest, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				// set ReplyTo header of Message, pretty much like the concept of email.
				
				message.setJMSReplyTo(new ActiveMQQueue(destReplyTo));
				message.setJMSCorrelationID("001");
				
				return message;
			}
		});
	}

}