package fr.smabtp.ejb;

import javax.ejb.EJBException;

public interface BusinessRemote {

	public <T> T find(Class<T> entityClass, Object primaryKey);

	public <T> Object persist(T object) throws IllegalStateException,
			EJBException;
}