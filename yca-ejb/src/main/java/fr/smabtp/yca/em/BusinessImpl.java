package fr.smabtp.yca.em;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import fr.smabtp.ejb.BusinessRemote;

@Stateless
@Remote
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BusinessImpl implements BusinessRemote {

	final static Logger logger = Logger.getLogger(BusinessImpl.class.getName());

	@PersistenceContext(unitName = "PU")
	private EntityManager entityManager;

	public <T> T find(Class<T> entityClass, Object primaryKey) {
		return entityManager.find(entityClass, primaryKey);
	}

	public <T> Object persist(T object) throws IllegalStateException, EJBException {
		logger.info("Debut persist");
		entityManager.persist(object);
		entityManager.flush();
		entityManager.refresh(object);
		logger.info("Fin persist");
		return object;
	}
}