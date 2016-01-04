package fr.smabtp.yca.test;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.smabtp.yca.bean.Histo;

public class EntityManagerTest {

	final static Logger logger = Logger.getLogger(EntityManagerTest.class.getName());

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
	@Ignore
	public void test1() {
		try {

			// Création de l'entity manager + factory, sans passer par du @persistenceContext:
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
			EntityManager em = emf.createEntityManager();

			// Recherche d'un objet en base:
			Histo histoFind = em.find(Histo.class, 1);

			if (histoFind == null) {

				logger.info("Personne non trouvee..");
				Date d = new Date();
				Histo histoAdd = new Histo("Cahuzac12", "Yann12", new Timestamp(d.getTime()));
				em.getTransaction().begin();
				em.persist(histoAdd);
				em.flush();
				em.refresh(histoAdd);
				em.getTransaction().commit();
				logger.info(histoAdd.toString());

			} else {

				em.refresh(histoFind);
				logger.info("Personne trouvee!");
				logger.info(histoFind.toString());

			}

			// Fermeture de l'entity manager + factory:
			em.close();
			emf.close();

		} catch (Exception e) {
			logger.error(e.fillInStackTrace());
		}
	}
}