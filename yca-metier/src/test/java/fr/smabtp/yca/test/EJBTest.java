package fr.smabtp.yca.test;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.smabtp.jndi.GetEJB;
import fr.smabtp.yca.bean.Histo;

//@Ignore
public class EJBTest {

	final static Logger logger = Logger.getLogger(EJBTest.class.getName());

	private GetEJB getEJB = new GetEJB();

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
		String x = "22";
		Histo histoAdd = new Histo("Cahuzac" + x, "Yann" + x, new Timestamp(
				new Date().getTime()));
		Histo histoAddBack = (Histo) getEJB.recordData(histoAdd);
		logger.info("Retour JNDI: HistoAddBack Pk: " + histoAddBack.getPk());
	}
}