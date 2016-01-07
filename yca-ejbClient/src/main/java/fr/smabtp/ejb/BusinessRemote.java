package fr.smabtp.ejb;

import javax.ejb.EJBException;

import org.springframework.security.core.userdetails.UserDetails;

public interface BusinessRemote {

	public <T> T find(Class<T> entityClass, Object primaryKey);

	public <T> Object persist(T object) throws IllegalStateException,
			EJBException;

	public UserDetails loadUserByUsername(String username);
}