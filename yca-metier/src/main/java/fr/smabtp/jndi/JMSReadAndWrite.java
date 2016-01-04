package fr.smabtp.jndi;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class JMSReadAndWrite {

	final static Logger logger = Logger.getLogger(JMSReadAndWrite.class
			.getName());

	// Global:
	Context context = null;
	ConnectionFactory factory = null;
	Connection connection = null;
	javax.jms.Queue queue = null;
	Session session = null;

	// Lecture:
	MessageConsumer receiver = null;

	// Ecriture:
	QueueSender qsender;
	TextMessage msg;

	/**
	 * Exécute ecriture/lecture.
	 */
	public void doIt() {
		try {
			init();
			send("Test 1 yca");
			lire();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Sends a message to a JMS queue.
	 */
	public void send(String message) throws NamingException, JMSException {
		msg = session.createTextMessage();
		qsender = (QueueSender) session.createProducer(queue);
		msg.setText(message);
		qsender.send(msg);
	}

	/**
	 * Reads a message from a JMS queue.
	 */
	public void lire() throws NamingException, JMSException {
		receiver = session.createConsumer(queue);
		connection.start();
		Message message = receiver.receive();

		if (message instanceof TextMessage) {
			TextMessage text = (TextMessage) message;
			System.out.println("Message lu: [" + text.getText() + "]");
		} else if (message != null) {
			System.out.println("Aucun message dans la file..");
		}
	}

	/**
	 * Creates all the necessary objects for sending/reading messages to a JMS
	 * queue.
	 */
	public void init() throws NamingException, JMSException {
		context = new InitialContext();
		factory = (ConnectionFactory) context.lookup("myJMSConnectionFactory");
		queue = (javax.jms.Queue) context.lookup("jms/myQueue");
		connection = (Connection) factory.createConnection();
		session = (connection).createSession(false, Session.AUTO_ACKNOWLEDGE);
	}

}