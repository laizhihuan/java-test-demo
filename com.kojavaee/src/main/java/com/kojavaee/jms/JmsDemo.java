package com.kojavaee.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JmsDemo {
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		Queue queue = new ActiveMQQueue("testQueue");
		
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Message message = session.createTextMessage("hello jms");
		
		MessageProducer producer = session.createProducer(queue);
		producer.send(message);
		
		System.out.println("Send Message Completed!");
		
		MessageConsumer consumer = session.createConsumer(queue);
		Message recvMessage = consumer.receive();
		System.out.println(((TextMessage)recvMessage).getText());
	}
}
