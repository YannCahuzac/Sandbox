package fr.smabtp.jndi;

import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;

import fr.smabtp.ejb.BusinessRemote;

public class GetEJB {

	final static Logger logger = Logger.getLogger(GetEJB.class.getName());

	public <T> Object recordData(T object) {
		logger.info("Debut GetEJB");
		try {

			InitialContext context = new InitialContext();

			context.getNameInNamespace();
			context.getEnvironment();

			BusinessRemote inter = (BusinessRemote) context
					.lookup("fr.smabtp.ejb.BusinessRemote");

			object = (T) inter.persist(object);

		} catch (EJBException e) {
			logger.error("EJBException: " + e.getMessage());
		} catch (IllegalStateException e) {
			logger.error("IllegalStateException: " + e.getMessage());
		} catch (NamingException e) {
			logger.error("NamingException: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception: " + e.getMessage());
		}
		logger.info("Fin GetEJB");
		return object;
	}

	public UserDetails loadUserByUsername(String username) {
		logger.info("Debut GetEJB");
		UserDetails ret = null;
		try {

			InitialContext context = new InitialContext();

			context.getNameInNamespace();
			context.getEnvironment();

			BusinessRemote inter = (BusinessRemote) context
					.lookup("fr.smabtp.ejb.BusinessRemote");

			ret = inter.loadUserByUsername(username);

		} catch (EJBException e) {
			logger.error("EJBException: " + e.getMessage());
		} catch (IllegalStateException e) {
			logger.error("IllegalStateException: " + e.getMessage());
		} catch (NamingException e) {
			logger.error("NamingException: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception: " + e.getMessage());
		}
		logger.info("Fin GetEJB");
		return ret;
	}
}