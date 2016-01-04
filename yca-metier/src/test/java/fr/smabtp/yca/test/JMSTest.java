package fr.smabtp.yca.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.smabtp.jndi.JMSReadAndWrite;

public class JMSTest {

	final static Logger logger = Logger.getLogger(JMSTest.class.getName());

	@Before
	public void initialize() {
		logger.info("#################### Debut Test ####################");
		System.setProperty("AS_DERBY_INSTALL", "C:\\glassfish3\\javadb");
	}

	@After
	public void end() {
		logger.info("#################### Fin Test ######################\n");
	}

	@Test
	public void test3() {
		JMSReadAndWrite raw = new JMSReadAndWrite();
		raw.doIt();
	}

}