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

public class QueueTest {
	
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
		
		Connection connection = factory.createConnection();
		
		connection.start();
		
		Queue queue = new ActiveMQQueue("testQueue");
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		MessageConsumer consumer1 = session.createConsumer(queue);
		consumer1.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				try {
					System.out.println("Consumer1 get" + ((TextMessage)msg).getText());
				} catch (JMSException e) {
				}
			}
		});
		
		MessageConsumer consumer2 = session.createConsumer(queue);
		consumer2.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				try {
					System.out.println("Consumer2 get" + ((TextMessage)msg).getText());
				} catch (JMSException e) {
				}
			}
		});
		
		MessageProducer producer = session.createProducer(queue);
		
		for(int i=0; i<10; i++) {
			producer.send(session.createTextMessage("Message : " + i));
		}
	}
}
