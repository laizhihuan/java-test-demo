package com.kojavaee.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class MessageSendReceiveAndReply {
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
		Connection connection = factory.createConnection();
		connection.start();
		
		Queue queue = new ActiveMQQueue("testQueue");
		Queue replyQueue = new ActiveMQQueue("replyQueue");
		
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Message message = session.createTextMessage("KO");
		message.setJMSReplyTo(replyQueue);
		
		MessageProducer producer = session.createProducer(queue);
		producer.send(message);
		
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				MessageProducer producer;
				try {
					producer = session.createProducer(msg.getJMSReplyTo());
					System.out.println("ddd"+((TextMessage)msg).getText());
					producer.send(session.createTextMessage("Hello " + ((TextMessage)msg).getText()));
					
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
		MessageConsumer consumer2 = session.createConsumer(replyQueue);
		consumer2.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				try {
					System.out.println(((TextMessage)msg).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
