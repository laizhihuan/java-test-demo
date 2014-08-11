package com.kojavaee.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class TopicTest {
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		Topic topic = new ActiveMQTopic("testTopic");
		Topic topic2 = new ActiveMQTopic("testTopic2");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		MessageConsumer consumer1 = session.createConsumer(topic);
		consumer1.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				try {
					System.out.println("Consumer1 get" + ((TextMessage)msg).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
		MessageConsumer consumer2 = session.createConsumer(topic2);
		consumer2.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				try {
					System.out.println("Consumer2 get" + ((TextMessage)msg).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
		MessageProducer producer = session.createProducer(topic);
		for(int i=0; i<10; i++) {
			producer.send(session.createTextMessage("message:"+i));
		}
		
		MessageProducer producer1 = session.createProducer(topic2);
		for(int i=0; i<10; i++) {
			producer1.send(session.createTextMessage("message2:"+i));
		}
	}
}
